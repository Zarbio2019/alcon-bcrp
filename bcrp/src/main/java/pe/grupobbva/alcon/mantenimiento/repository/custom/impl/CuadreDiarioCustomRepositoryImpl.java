package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.grupobbva.alcon.core.beans.Codigoestado;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.CuadreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.DetalleCuadreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CuadreDiarioSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.DetallePlantillaCalculoTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterCode;
import pe.grupobbva.alcon.mantenimiento.dto.util.PersonalizeDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CuadreDiario;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleCuadreDiario;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleParametro;
import pe.grupobbva.alcon.mantenimiento.entity.Parametro;
import pe.grupobbva.alcon.mantenimiento.entity.PlantillaCalculo;
import pe.grupobbva.alcon.mantenimiento.entity.ValorParametro;
import pe.grupobbva.alcon.mantenimiento.repository.custom.CuadreDiarioCustomRepository;
import pe.grupobbva.alcon.mantenimiento.service.CuadreDiarioService;
import pe.grupobbva.alcon.mantenimiento.service.DetalleCuadreDiarioService;

public class CuadreDiarioCustomRepositoryImpl implements CuadreDiarioCustomRepository {

	private static final Logger log = LogManager.getLogger();
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private CuadreDiarioService cuadreDiarioService;
	
	@Autowired
	private DetalleCuadreDiarioService detalleCuadreDiarioService;
	
	@Override
	public PersonalizeDTO<CuadreDiarioDTO, DetallePlantillaCalculoTableDTO> search(CuadreDiarioSearch cuadreDiarioSearch) {
		ParameterCode parametercode = new ParameterCode();
		CriteriaBuilder cb = em.getCriteriaBuilder();

		/** Begin createquery */
		
		CriteriaQuery<CuadreDiarioDTO> cq = cb.createQuery(CuadreDiarioDTO.class);
		CriteriaQuery<DetallePlantillaCalculoTableDTO> cqdetail = cb.createQuery(DetallePlantillaCalculoTableDTO.class);
		
		List<Predicate> andPredicates = new ArrayList<>();
		List<Predicate> andPredicatesdetail = new ArrayList<>();
		
		/** FROM y JOINS */
		//Cuadre diario
		Root<CuadreDiario> cuadreDiario = cq.from(CuadreDiario.class);
	
		//Detalle cuadre diario
		Root<DetalleCuadreDiario> detalleCuadreDiario = cqdetail.from(DetalleCuadreDiario.class);
		Join<CuadreDiario,DetalleCuadreDiario> cuadreDiariod = detalleCuadreDiario.join("cuadrediario");
		Join<PlantillaCalculo,DetalleCuadreDiario> plantillaCalculo = detalleCuadreDiario.join("plantillacalculo");
				//TipoPlantilla
				Root<ValorParametro> valorTP = cqdetail.from(ValorParametro.class);
				Join<DetalleParametro, ValorParametro> detalleTP = valorTP.join("detalleParametro");
				Join<Parametro, ValorParametro> parametroTP = detalleTP.join("parametro");
				parametroTP.on(cb.and(cb.equal(parametroTP.get("codigo"), parametercode.getTipoDatoPlantilla()),
						cb.equal(valorTP.get("valor"), plantillaCalculo.get("tipodatoplantilla"))));
				
				//TipoSigno
				Root<ValorParametro> valorTS = cqdetail.from(ValorParametro.class);
				Join<DetalleParametro, ValorParametro> detalleTS = valorTS.join("detalleParametro");
				Join<Parametro, ValorParametro> parametroTS = detalleTS.join("parametro");
				parametroTS.on(cb.and(cb.equal(parametroTS.get("codigo"), parametercode.getSignoPlantilla()),
						cb.equal(valorTS.get("valor"), plantillaCalculo.get("tiposigno"))));
	
				
		/** Begin Where */
				
		if(cuadreDiarioSearch.getFecha() != null) {
			andPredicates.add(
					cb.equal(
							cb.function("TO_CHAR",Date.class,cuadreDiario.get("fechacuadrediario"), cb.literal("yyyy-MM-dd")),
							cb.function("TO_CHAR",Date.class,cb.parameter(Date.class, "fechacuadrediario"), cb.literal("yyyy-MM-dd"))
							));
			andPredicatesdetail.add(
					cb.equal(
							cb.function("TO_CHAR",Date.class,cuadreDiariod.get("fechacuadrediario"), cb.literal("yyyy-MM-dd")),
							cb.function("TO_CHAR",Date.class,cb.parameter(Date.class, "fechacuadrediariod"), cb.literal("yyyy-MM-dd"))
							));
		}
		
		
		cq.where(andPredicates.stream().toArray(Predicate[]::new));
		cqdetail.where(andPredicatesdetail.stream().toArray(Predicate[]::new)); 
		
		/** Begin select */
		cq.select(cb.construct(CuadreDiarioDTO.class, 
				cuadreDiario.get("id"), 
				cuadreDiario.get("fechacuadrediario"), 
				cuadreDiario.get("totalcuadreplantilla"),
				cuadreDiario.get("totalreferencial"),
				cuadreDiario.get("estado")
			));

		cqdetail.select(cb.construct(DetallePlantillaCalculoTableDTO.class, 
				plantillaCalculo.get("id"),
				plantillaCalculo.get("tipodatoplantilla"),
				plantillaCalculo.get("idposicioncambiaria"),
				plantillaCalculo.get("rubro"),
				plantillaCalculo.get("texto"),
				plantillaCalculo.get("tiposigno"),
				plantillaCalculo.get("estado"),
				detalleTP.get("descripcion"),
				detalleTS.get("descripcion"),
				detalleCuadreDiario.get("valorcuadre")
			));
		/** End select */
		TypedQuery<CuadreDiarioDTO> query = em.createQuery(cq);
		TypedQuery<DetallePlantillaCalculoTableDTO> querydetail = em.createQuery(cqdetail);
		query.setMaxResults(1);
		
		/** Parametros */
		if(cuadreDiarioSearch.getFecha() != null) {
			query.setParameter("fechacuadrediario", cuadreDiarioSearch.getFecha());
			querydetail.setParameter("fechacuadrediariod", cuadreDiarioSearch.getFecha());
		}

		return new PersonalizeDTO<>(
				query.getResultList().size()==0?null : query.getResultList().get(0), 
				new ArrayList<>(querydetail.getResultList())
			);
	}

	@Override
	public ResponseEntity<Void> create(PersonalizeDTO<CuadreDiarioDTO, DetalleCuadreDiarioDTO> dto) {
		CuadreDiario entity=null;
		entity = dto.getPrimaryData().fromDTO(entity);
		ValidatorUtil.validateEntity(entity);
		cuadreDiarioService.guardar(entity);
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
		
		//Save Details
		for (DetalleCuadreDiarioDTO data: dto.getSecondaryData()) {
			data.setIdCuadreDiario(entity.getId());
			DetalleCuadreDiario entityDetalle = null;
			entityDetalle = data.fromDTO(entityDetalle);
			ValidatorUtil.validateEntity(entityDetalle);
			detalleCuadreDiarioService.guardar(entityDetalle);
		}
		      
		return ResponseEntity.status(HttpStatus.CREATED)
				.header(HttpHeaders.LOCATION, location.toString()).build();
	}

	@Override
	public ResponseEntity<Void> update(PersonalizeDTO<CuadreDiarioDTO, DetalleCuadreDiarioDTO> dto) {
		CuadreDiario entity = cuadreDiarioService.buscarId(dto.getPrimaryData().getId());
		if(entity == null || entity.getCodigoestado().equals(Codigoestado.INACTIVO.getCodigoestado())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		dto.getPrimaryData().preactualizar();
		entity = dto.getPrimaryData().fromDTO(entity);
		ValidatorUtil.validateEntity(entity);
		cuadreDiarioService.actualizar(entity);
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
		
		// Update Details
		for (DetalleCuadreDiarioDTO data: dto.getSecondaryData()) {
			DetalleCuadreDiario entityDetalle = detalleCuadreDiarioService.buscarId(data.getId());
			if(entityDetalle == null || entity.getCodigoestado().equals(Codigoestado.INACTIVO.getCodigoestado())) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			
			data.preactualizar();
			entityDetalle = data.fromDTO(entityDetalle);
			ValidatorUtil.validateEntity(entityDetalle);
			detalleCuadreDiarioService.actualizar(entityDetalle);
		} 
		
		return ResponseEntity.status(HttpStatus.OK)
				.header(HttpHeaders.LOCATION, location.toString()).build();
	
	}
	
}
