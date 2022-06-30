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
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.DivisaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.DivisaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.repository.custom.DivisaCustomRepository;

public class DivisaCustomRepositoryImpl implements DivisaCustomRepository {

	@Autowired
	private EntityManager em;

	@Override
	public DatatableDTO<DivisaDTO> search(DivisaSearch divisaSearch) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		/** Begin createquery */
		CriteriaQuery<DivisaDTO> cq = cb.createQuery(DivisaDTO.class);
		CriteriaQuery<Long> cqc = cb.createQuery(Long.class);

		List<Predicate> andPredicates = new ArrayList<>();
		List<Predicate> andPredicatesc = new ArrayList<>();
		/** End createquery */

		/** Begin FROM y JOINS */
		Root<Divisa> divisa = cq.from(Divisa.class);
		Root<Divisa> divisac = cqc.from(Divisa.class);

		andPredicates.add(cb.equal(divisa.get("codigoestado"), 1));
		andPredicatesc.add(cb.equal(divisa.get("codigoestado"), 1));
		/** End FROM y JOINS */ 

		/** Begin Where */
		if (divisaSearch.getDescripcion() != null) {
			andPredicates.add(cb.like(cb.upper(divisa.get("descripcion")), cb.concat(cb.concat("%", cb.upper(cb.parameter(String.class, "descripcionDivisa"))), "%")));
			andPredicatesc.add(cb.like(divisac.get("descripcion"), cb.concat(cb.concat("%", cb.upper(cb.parameter(String.class, "descripcionDivisa"))), "%")));
		}

		cq.where(andPredicates.stream().toArray(Predicate[]::new));
		cqc.where(andPredicatesc.stream().toArray(Predicate[]::new));
		/** End Where */

		/** Begin orderBy */

		Map<OrderCriterias, String> order = divisaSearch.getOrder().get(0);

		if (order.get(OrderCriterias.dir).equals("asc")) {
			cq.orderBy(cb.asc(divisa.get(order.get(OrderCriterias.name))));
		} else {
			cq.orderBy(cb.desc(divisa.get(order.get(OrderCriterias.name))));
		}

		/** End orderBy */

		/** Begin select */
		cq.select(cb.construct(DivisaDTO.class, divisa.get("id"), divisa.get("codigo"), divisa.get("descripcion"),
				divisa.get("codigoestado")));

		cqc.select(cb.coalesce(cb.count(divisac), 0l));
		/** End select */

		TypedQuery<DivisaDTO> query = em.createQuery(cq);
		TypedQuery<Long> queryc = em.createQuery(cqc);

		/** Paginador */
		query.setFirstResult(divisaSearch.getStart());
		/** Paginador */

		/** Tamano */
		if (divisaSearch.getLength() > -1) {
			query.setMaxResults(divisaSearch.getLength());
		}

		/** Parametros */
		if (divisaSearch.getDescripcion() != null) {
			query.setParameter("descripcionDivisa", divisaSearch.getDescripcion());
			queryc.setParameter("descripcionDivisa", divisaSearch.getDescripcion());
		}

		return new DatatableDTO<>(divisaSearch.getDraw(), queryc.getSingleResult(), query.getResultList());
	}

	public SelectOptions<SelectOptionsDTO> listOptions() {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		/** Begin create query */
		CriteriaQuery<SelectOptionsDTO> cq = cb.createQuery(SelectOptionsDTO.class);

		/** Begin FROM y JOINS */
		Root<Divisa> divisa = cq.from(Divisa.class);

		/** Begin where */
		cq.where(cb.equal(divisa.get("codigoestado"), "1"));

		/** Begin oderBy */
		cq.orderBy(cb.asc(divisa.get("codigo")));

		/** Begin Select */
		cq.select(cb.construct(SelectOptionsDTO.class, divisa.get("id"), divisa.get("codigo")));
		TypedQuery<SelectOptionsDTO> query = em.createQuery(cq);
		return new SelectOptions<>(query.getResultList());
	}
}
