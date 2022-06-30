package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable.OrderCriterias;
import pe.grupobbva.alcon.mantenimiento.dto.CierreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CierreDiarioSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CierreDiario;
import pe.grupobbva.alcon.mantenimiento.repository.custom.CierreDiarioCustomRepository;

public class CierreDiarioCustomRepositoryImpl implements CierreDiarioCustomRepository {

	@Autowired
	private EntityManager em;

	@Override
	public DatatableDTO<CierreDiarioDTO> search(CierreDiarioSearch cierreDiarioSearch) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		/** Begin create query */
		CriteriaQuery<CierreDiarioDTO> cq = cb.createQuery(CierreDiarioDTO.class);
		CriteriaQuery<Long> cqc = cb.createQuery(Long.class);

		List<Predicate> andPredicates = new ArrayList<>();
		List<Predicate> andPredicatesc = new ArrayList<>();

		/** End create query */
		
		/** Begin FROM Y JOINS */
		Root<CierreDiario> cierrediario = cq.from(CierreDiario.class);
		Root<CierreDiario> cierrediarioc = cqc.from(CierreDiario.class);
		
		/** Begin Where */
		if (cierreDiarioSearch.getAnio() != null && cierreDiarioSearch.getAnio() >= 0) {
			andPredicates.add(cb.equal(cb.function("year",Integer.class,cierrediario.get("fecha")), cb.parameter(Integer.class, "anioCierreDiario")));
			andPredicatesc.add(cb.equal(cb.function("year", Integer.class, cierrediarioc.get("fecha")), cb.parameter(Integer.class, "anioCierreDiario")));
		}

		if (cierreDiarioSearch.getMes() != null && cierreDiarioSearch.getMes() >= 0) {
			andPredicates.add(cb.equal(cb.function("month", Integer.class, cierrediario.get("fecha")), cb.parameter(Integer.class, "mesCierreDiario")));
			andPredicatesc.add(cb.equal(cb.function("month", Integer.class, cierrediarioc.get("fecha")), cb.parameter(Integer.class, "mesCierreDiario")));
		}
		
		andPredicates.add(cb.equal(cierrediario.get("codigoestado"), 1));
		andPredicatesc.add(cb.equal(cierrediarioc.get("codigoestado"), 1));
		
		cq.where(andPredicates.stream().toArray(Predicate[]::new));
		cqc.where(andPredicatesc.stream().toArray(Predicate[]::new));

		/** End Where */

		/** Begin orderBy */
		Map<OrderCriterias, String> order = cierreDiarioSearch.getOrder().get(0);

		if (order.get(OrderCriterias.dir).equals("asc")) {
			cq.orderBy(cb.asc(cierrediario.get(order.get(OrderCriterias.name))));
		} else {
			cq.orderBy(cb.desc(cierrediario.get(order.get(OrderCriterias.name))));
		}
		/** End OrderBy */
		
		/** Begin Select */
		cq.select(cb.construct(CierreDiarioDTO.class, cierrediario.get("id"), cierrediario.get("fecha"),
				cierrediario.get("codigoestado")));
		
		cqc.select(cb.coalesce(cb.count(cierrediarioc), 0l));
		/** End Select */
		
		TypedQuery<CierreDiarioDTO> query = em.createQuery(cq);
		TypedQuery<Long> queryc = em.createQuery(cqc);
		/** Paginador */
		query.setFirstResult(cierreDiarioSearch.getStart());
		/**Tamano*/
		if(cierreDiarioSearch.getLength()>-1) {
			query.setMaxResults(cierreDiarioSearch.getLength());
		}
		
		/** Parametros */
		if(cierreDiarioSearch.getAnio()!=null) {
			query.setParameter("anioCierreDiario", cierreDiarioSearch.getAnio());
			queryc.setParameter("anioCierreDiario", cierreDiarioSearch.getAnio());
		}
		if(cierreDiarioSearch.getMes()!=null) {
			query.setParameter("mesCierreDiario", cierreDiarioSearch.getMes());
			queryc.setParameter("mesCierreDiario", cierreDiarioSearch.getMes());
		}
		
		return new DatatableDTO<>(
				cierreDiarioSearch.getDraw(),
				queryc.getSingleResult(),
				query.getResultList()
				);
	}

}