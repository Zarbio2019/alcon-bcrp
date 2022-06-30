package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.DetalleParametroDTO;
import pe.grupobbva.alcon.mantenimiento.dto.ValorParametroDTO;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.ParametroResponse;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.ValorParametroResponse;
import pe.grupobbva.alcon.mantenimiento.dto.search.ParametroSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.ParametroTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterCode;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterRequestBody;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterTableResponseDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleParametro;
import pe.grupobbva.alcon.mantenimiento.entity.Parametro;
import pe.grupobbva.alcon.mantenimiento.entity.ValorParametro;
import pe.grupobbva.alcon.mantenimiento.repository.custom.ParametroCustomRepository;

public class ParametroCustomRepositoryImpl implements ParametroCustomRepository {

	@Autowired
	private EntityManager em;
	
	private static final Logger log = LogManager.getLogger();
	
	@Autowired
	private AbstractRestController<DetalleParametro, DetalleParametroDTO> detalleparametro;
	
	@Autowired
	private AbstractRestController<ValorParametro, ValorParametroDTO> valorparametro;
	
	@SuppressWarnings("unchecked")
	@Override
	public ParameterTableResponseDTO search(ParametroSearch parametroSearch) {
		ParameterTableResponseDTO consultaDinamica = new ParameterTableResponseDTO();
		
		List<ParametroTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_PARAMETRO_LISTAR")
				.setParameter("P_CODIGO",StringUtils.isBlank(parametroSearch.getCodigo())?"001": parametroSearch.getCodigo())
				.setParameter("P_DETALLE_ID",null)
				.getResultList();
		
		List<ValorParametroResponse> valores = 
				em.createNamedStoredProcedureQuery("SP_BCR_PARAMETRO_LISTARVALORES")
				.setParameter("P_CODIGO",StringUtils.isBlank(parametroSearch.getCodigo())?"001": parametroSearch.getCodigo() )
				.setParameter("P_DETALLE_ID",null)
				.getResultList();
		
		List<ParametroResponse> parametroResponse = new ArrayList<ParametroResponse>();
		parametroResponse = this.getParameters(resultados, valores);
		
		ParameterCode parametercode = new ParameterCode();
		consultaDinamica.setColumnas(parametercode.getColumns(parametroSearch.getCodigo()));
		consultaDinamica.setRegistros(parametroResponse);
		
		return consultaDinamica;	
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public ParameterTableResponseDTO getParameter(String id) {
		ParameterTableResponseDTO consultaDinamica = new ParameterTableResponseDTO();
		
		List<ParametroTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_PARAMETRO_LISTAR")
				.setParameter("P_CODIGO",null)
				.setParameter("P_DETALLE_ID",id)
				.getResultList();
		
		List<ValorParametroResponse> valores = 
				em.createNamedStoredProcedureQuery("SP_BCR_PARAMETRO_LISTARVALORES")
				.setParameter("P_CODIGO",null)
				.setParameter("P_DETALLE_ID",id)
				.getResultList();
		
		List<ParametroResponse> parametroResponse = new ArrayList<ParametroResponse>();
		parametroResponse = this.getParameters(resultados, valores);
		
		ParameterCode parametercode = new ParameterCode();
		consultaDinamica.setColumnas(parametercode.getColumns(resultados.get(0).getCodigoparametro()));
		consultaDinamica.setRegistros(parametroResponse);
		
		return consultaDinamica;	
	}
	
	
	@Override
	public  ResponseEntity<Void> create(ParameterRequestBody data){
		if(StringUtils.isBlank(data.getDetalleparametro().getId())) {
			
			//crea nuevo detalle parametro
			ResponseEntity<Void> response = detalleparametro.create(data.getDetalleparametro());
			String iddetalleparametro = response.getHeaders()
					.getLocation()
					.toString()
					.replace(ServletUriComponentsBuilder.fromCurrentRequest().toUriString()+"/", "");
			
			if(response.getStatusCode().value() == HttpStatus.CREATED.value()) {
				//Crear valores
				Integer orden= 0;
				for(ValorParametroDTO valor: data.getValorparametro()) {
					orden+=1;
					if(StringUtils.isBlank(valor.getId())) {
						if(!StringUtils.isBlank(valor.getValor())) {
							valor.setIdDetalle(iddetalleparametro);
							valor.setOrden(orden);
							ResponseEntity<Void> responsevalor = valorparametro.create(valor);
							if(responsevalor.getStatusCode().value() != HttpStatus.CREATED.value()) {
								return responsevalor;
							}
						}
					}
				}
				return ResponseEntity.status(HttpStatus.CREATED).build();
			}else {
				return response;
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	
	@Override
	public  ResponseEntity<Void> update(ParameterRequestBody data){
		if(!StringUtils.isBlank(data.getDetalleparametro().getId())) {
			//Actualiza detalle parametro
			ResponseEntity<Void> response = detalleparametro.update(data.getDetalleparametro(), data.getDetalleparametro().getId());
			String iddetalleparametro = response.getHeaders()
					.getLocation()
					.toString()
					.replace(ServletUriComponentsBuilder.fromCurrentRequest().toUriString()+"/", "");
			
			if(response.getStatusCode().value() == HttpStatus.OK.value()) {
				Integer orden= 0;
				for(ValorParametroDTO valor: data.getValorparametro()) {
					orden+=1;
					if(StringUtils.isBlank(valor.getId())  ) {
						//Crear valores
						if(!StringUtils.isBlank(valor.getValor())) {
								
								valor.setIdDetalle(iddetalleparametro);
								valor.setOrden(orden);
								ResponseEntity<Void> responsevalor = valorparametro.create(valor);
							
								if(responsevalor.getStatusCode().value() != HttpStatus.CREATED.value()) {
										return responsevalor;
								}
						}
						
					}else if(!StringUtils.isBlank(valor.getId())) {
						//Actualizar valores
						valor.setOrden(orden);
						ResponseEntity<Void> responsevalor = valorparametro.update(valor, valor.getId());
						if(responsevalor.getStatusCode().value() != HttpStatus.OK.value()) {
							return responsevalor;
						}
					}
				}
				return ResponseEntity.status(HttpStatus.OK).build();
			}else {
				return response;
			}
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	public Integer getOrden(ParameterRequestBody data) {
		return 0;
	}
	
	public List<ParametroResponse> getParameters(List<ParametroTableDTO> details, List<ValorParametroResponse> values){
		
		List<ParametroResponse> parametroResponse = new ArrayList<ParametroResponse>();
		
		for(int i = 0;i<details.size();i++) {
			ParametroResponse  parametroResponseTmp = new ParametroResponse(details.get(i));
			
			List<ValorParametroResponse> valorParametroList = new ArrayList<ValorParametroResponse>();
			for(int j = 0;j<values.size();j++) {
				if(details.get(i).getIddetalleparametro().equals(values.get(j).getIddetalleparametro())) {
					ValorParametroResponse valorParametroResponse= new ValorParametroResponse();
					valorParametroResponse.setIddetalleparametro(values.get(j).getIddetalleparametro());
					valorParametroResponse.setIdvalorparametro(values.get(j).getIdvalorparametro());
					valorParametroResponse.setValorparametro(values.get(j).getValorparametro());
					valorParametroResponse.setOrden(values.get(j).getOrden());
					valorParametroList.add(valorParametroResponse);
				}
			}
			
			for(int n = 0;n<valorParametroList.size();n++) {
				Integer valor = n;
				if(valorParametroList.get(n).getOrden()!=null) {
					valor = valorParametroList.get(n).getOrden();
					valor = valor-1;
				}
				
				switch(valor) {
				  case 0:
					  parametroResponseTmp.setIdvalorparametro1(valorParametroList.get(n).getIdvalorparametro());
					  parametroResponseTmp.setValorparametro1(valorParametroList.get(n).getValorparametro());
					  break;
				  case 1:
					  parametroResponseTmp.setIdvalorparametro2(valorParametroList.get(n).getIdvalorparametro());
					  parametroResponseTmp.setValorparametro2(valorParametroList.get(n).getValorparametro());
				    break;
				  case 2:
					  parametroResponseTmp.setIdvalorparametro3(valorParametroList.get(n).getIdvalorparametro());
					  parametroResponseTmp.setValorparametro3(valorParametroList.get(n).getValorparametro());
					    break;
				  case 3:
					  parametroResponseTmp.setIdvalorparametro4(valorParametroList.get(n).getIdvalorparametro());
					  parametroResponseTmp.setValorparametro4(valorParametroList.get(n).getValorparametro());
					    break;
				  case 4:
					  parametroResponseTmp.setIdvalorparametro5(valorParametroList.get(n).getIdvalorparametro());
					  parametroResponseTmp.setValorparametro5(valorParametroList.get(n).getValorparametro());
					    break;
				  default:
				    // code block
				}
			}
			parametroResponse.add(parametroResponseTmp);
		}
		
		return parametroResponse;
	}

	
	@Override
	public SelectOptions<SelectOptionsDTO> type(String codigo){
		
		ParameterCode parametercode = new ParameterCode();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		/** Begin create query */
		CriteriaQuery<SelectOptionsDTO> cq = cb.createQuery(SelectOptionsDTO.class);
		
		/** Begin FROM Y JOINS */
		Root<ValorParametro> valorparametro = cq.from(ValorParametro.class);
		Join<DetalleParametro, ValorParametro> detalleparametro = valorparametro.join("detalleParametro");
		Join<Parametro,DetalleParametro> parametro = detalleparametro.join("parametro");
		
		/** Begin where */
		List<Predicate> andPredicates=new ArrayList<>();
		if(codigo!=null) {
			andPredicates.add(cb.equal(parametro.get("codigo"), cb.parameter(String.class,"codigoParametro")));
			andPredicates.add(cb.isTrue(detalleparametro.get("visible")));
		}
		
		if(codigo!=null && codigo.equals(parametercode.getEntidadCliente())) {
			andPredicates.add(cb.equal(valorparametro.get("valor"), "BBVA"));
		}
		
		andPredicates.add(cb.equal(valorparametro.get("orden"), 1));
		cq.where(andPredicates.stream().toArray(Predicate[]::new));
		
		
		/** Begin orderBy */
		cq.orderBy(cb.asc(detalleparametro.get("descripcion")));
		
		/** Begin Select */
		cq.select(cb.construct(SelectOptionsDTO.class,
				valorparametro.get("valor")	,
				detalleparametro.get("descripcion")
						
			));
		
		TypedQuery<SelectOptionsDTO> query = em.createQuery(cq);
		
		query.setParameter("codigoParametro", codigo);
		
		return new SelectOptions<>(query.getResultList()) ;
	}
	
	
	@Override
	public SelectOptions<SelectOptionsDTO> typeParameter() {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		/** Begin create query */
		CriteriaQuery<SelectOptionsDTO> cq = cb.createQuery(SelectOptionsDTO.class);
		
		/** Begin FROM Y JOINS */
		Root<Parametro> parametro = cq.from(Parametro.class);
		
		/** Begin orderBy */
		cq.orderBy(cb.asc(parametro.get("descripcion")));
		
		/** Begin Select */
		cq.select(cb.construct(SelectOptionsDTO.class,
				parametro.get("codigo")	,
				parametro.get("descripcion")
						
			));
		
		TypedQuery<SelectOptionsDTO> query = em.createQuery(cq);
	
		return new SelectOptions<>(query.getResultList()) ;
	}
	

}
