package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable.OrderCriterias;
import pe.grupobbva.alcon.mantenimiento.dto.PlantillaCalculoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.PlantillaCalculoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.PlantillaCalculoTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterCode;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleParametro;
import pe.grupobbva.alcon.mantenimiento.entity.Parametro;
import pe.grupobbva.alcon.mantenimiento.entity.PlantillaCalculo;
import pe.grupobbva.alcon.mantenimiento.entity.ValorParametro;
import pe.grupobbva.alcon.mantenimiento.repository.custom.PlantillaCalculoCustomRepository;

public class PlantillaCalculoCustomRepositoryImpl implements PlantillaCalculoCustomRepository {
	@Autowired
	private EntityManager em;
	
	@Override
	public DatatableDTO<PlantillaCalculoTableDTO> search(PlantillaCalculoSearch plantillaCalculoSearch){
		ParameterCode parametercode = new ParameterCode();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		/** Begin createquery */
		CriteriaQuery<PlantillaCalculoTableDTO> cq = cb.createQuery(PlantillaCalculoTableDTO.class);
		CriteriaQuery<Long> cqc = cb.createQuery(Long.class);
		
		List<Predicate> andPredicates = new ArrayList<>();
		List<Predicate> andPredicatesc = new ArrayList<>();
		/** End createquery */
		
		/** Begin FROM y JOINS */
		Root<PlantillaCalculo> plantillaCalculo = cq.from(PlantillaCalculo.class);
		Root<PlantillaCalculo> plantillaCalculoc = cqc.from(PlantillaCalculo.class);
		
		//TipoPlantilla
		Root<ValorParametro> valorTP = cq.from(ValorParametro.class);
		Join<DetalleParametro, ValorParametro> detalleTP = valorTP.join("detalleParametro");
		Join<Parametro, ValorParametro> parametroTP = detalleTP.join("parametro");
		parametroTP.on(cb.and(cb.equal(parametroTP.get("codigo"), parametercode.getTipoDatoPlantilla()),
		cb.equal(valorTP.get("valor"), plantillaCalculo.get("tipodatoplantilla"))));
		
		//TipoSigno
		Root<ValorParametro> valorTS = cq.from(ValorParametro.class);
		Join<DetalleParametro, ValorParametro> detalleTS = valorTS.join("detalleParametro");
		Join<Parametro, ValorParametro> parametroTS = detalleTS.join("parametro");
		parametroTS.on(cb.and(cb.equal(parametroTS.get("codigo"), parametercode.getSignoPlantilla()),
		cb.equal(valorTS.get("valor"), plantillaCalculo.get("tiposigno"))));
		
		//TipoPlantillac
		Root<ValorParametro> valorTPc = cqc.from(ValorParametro.class);
		Join<DetalleParametro, ValorParametro> detalleTPc = valorTPc.join("detalleParametro");
		Join<Parametro, ValorParametro> parametroTPc = detalleTPc.join("parametro");
		parametroTPc.on(cb.and(cb.equal(parametroTPc.get("codigo"), parametercode.getTipoDatoPlantilla()),
		cb.equal(valorTPc.get("valor"), plantillaCalculoc.get("tipodatoplantilla"))));
				
		//TipoSignoc
		Root<ValorParametro> valorTSc = cqc.from(ValorParametro.class);
		Join<DetalleParametro, ValorParametro> detalleTSc = valorTSc.join("detalleParametro");
		Join<Parametro, ValorParametro> parametroTSc = detalleTSc.join("parametro");
		parametroTSc.on(cb.and(cb.equal(parametroTSc.get("codigo"), parametercode.getSignoPlantilla()),
		cb.equal(valorTSc.get("valor"), plantillaCalculoc.get("tiposigno"))));
		
		/** End FROM y JOINS */
		
		/** Begin Where */
		andPredicates.add(cb.equal(plantillaCalculo.get("codigoestado"), 1));
		andPredicatesc.add(cb.equal(plantillaCalculoc.get("codigoestado"), 1));
		
		if(plantillaCalculoSearch.getRubro() != null && !plantillaCalculoSearch.getRubro().trim().equals("")) {
			andPredicates.add(cb.like(cb.upper(plantillaCalculo.get("rubro")), cb.concat(cb.concat("%", cb.upper(cb.parameter(String.class,"rubroPlantillaCalculo"))),"%")));
			andPredicatesc.add(cb.like(cb.upper(plantillaCalculo.get("rubro")), cb.concat(cb.concat("%",cb.upper(cb.parameter(String.class,"rubroPlantillaCalculo"))),"%")));
		}
		
		cq.where(andPredicates.stream().toArray(Predicate[]::new));
		cqc.where(andPredicatesc.stream().toArray(Predicate[]::new));
		/** End Where */
		
		/** Begin orderBy */
		Map<OrderCriterias, String> order = plantillaCalculoSearch.getOrder().get(0);
		
		if (order.get(OrderCriterias.dir).equals("asc")) {
			cq.orderBy(cb.asc(plantillaCalculo.get(order.get(OrderCriterias.name))));
		} else {
			cq.orderBy(cb.desc(plantillaCalculo.get(order.get(OrderCriterias.name))));
		}
		/** End orderBy */
		
		/** Begin select */
		cq.select(cb.construct(PlantillaCalculoTableDTO.class,
				plantillaCalculo.get("id"),
				plantillaCalculo.get("tipodatoplantilla"),
				plantillaCalculo.get("idposicioncambiaria"),
				plantillaCalculo.get("rubro"),
				plantillaCalculo.get("texto"),
				plantillaCalculo.get("tiposigno"),
				plantillaCalculo.get("estado"),
				detalleTP.get("descripcion"),
				detalleTS.get("descripcion")
			));
		
		cqc.select(cb.coalesce(cb.count(plantillaCalculoc), 0l));
		
		/** End select */
		
		TypedQuery<PlantillaCalculoTableDTO> query = em.createQuery(cq);
		TypedQuery<Long> queryc = em.createQuery(cqc);

		/** Paginador */
		query.setFirstResult(plantillaCalculoSearch.getStart());
		/** Paginador */

		
		/** Tamano */
		if(plantillaCalculoSearch.getLength() > -1) {
			query.setMaxResults(plantillaCalculoSearch.getLength());
		}
		
		/** Parametros */
		if(plantillaCalculoSearch.getRubro() != null && !plantillaCalculoSearch.getRubro().trim().equals("")) {
			query.setParameter("rubroPlantillaCalculo", plantillaCalculoSearch.getRubro());
			queryc.setParameter("rubroPlantillaCalculo", plantillaCalculoSearch.getRubro());
		}
		
		return new DatatableDTO<>(
				plantillaCalculoSearch.getDraw(),
				queryc.getSingleResult(),
				query.getResultList()
			);
	}
}
