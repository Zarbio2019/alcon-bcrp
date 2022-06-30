package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

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

import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.TipoCambioSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.TipoCambioTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCambio;
import pe.grupobbva.alcon.mantenimiento.repository.custom.TipoCambioCustomRepository;

public class TipoCambioCustomRepositoryImpl implements TipoCambioCustomRepository {
	@Autowired
	private EntityManager em;

	@Override
	public DatatableDTO<TipoCambioTableDTO> search(TipoCambioSearch tipoCambioSearch) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		/** Begin createquery */
		CriteriaQuery<TipoCambioTableDTO> cq = cb.createQuery(TipoCambioTableDTO.class);
		CriteriaQuery<Long> cqc = cb.createQuery(Long.class);

		List<Predicate> andPredicates = new ArrayList<>();
		List<Predicate> andPredicatesc = new ArrayList<>();
		/** End createquery */

		/** Begin FROM y JOINS */
		Root<TipoCambio> tipoCambio = cq.from(TipoCambio.class);
		Root<TipoCambio> tipoCambioc = cqc.from(TipoCambio.class);

		Join<Divisa, TipoCambio> divisa = tipoCambio.join("divisa");
		tipoCambioc.join("divisa");
		/** End FROM y JOINS */

		/** Begin Where */
	
		if (tipoCambioSearch.getFecha() != null ) {
			andPredicates.add(
					cb.equal(
							cb.function("TO_CHAR",Date.class,tipoCambio.get("fecha"), cb.literal("yyyy-MM-dd")),
							cb.function("TO_CHAR",Date.class,cb.parameter(Date.class, "fechaTipoCambio"), cb.literal("yyyy-MM-dd"))
							));
			andPredicatesc.add(
					cb.equal(
							cb.function("TO_CHAR",Date.class,tipoCambioc.get("fecha"), cb.literal("yyyy-MM-dd")),
							cb.function("TO_CHAR",Date.class,cb.parameter(Date.class, "fechaTipoCambio"), cb.literal("yyyy-MM-dd"))
							));
		}
		andPredicates.add(cb.equal(tipoCambio.get("codigoestado"), 1));
		andPredicatesc.add(cb.equal(tipoCambioc.get("codigoestado"), 1));
		
		cq.where(andPredicates.stream().toArray(Predicate[]::new));
		cqc.where(andPredicatesc.stream().toArray(Predicate[]::new));
		/** End Where */

		/** Begin orderBy */
		/*Map<OrderCriterias, String> order = tipoCambioSearch.getOrder().get(0);

		if (order.get(OrderCriterias.dir).equals("asc")) {
			cq.orderBy(cb.asc(tipoCambio.get(order.get(OrderCriterias.name))));
		} else {
			cq.orderBy(cb.desc(tipoCambio.get(order.get(OrderCriterias.name))));
		}*/
		cq.orderBy(cb.asc(divisa.get("codigo")));
		
		/** End orderBy */

		/** Begin select */
		cq.select(
				cb.construct(TipoCambioTableDTO.class, 
						tipoCambio.get("id"), 
						divisa.get("id"), 
						tipoCambio.get("fecha"),
						tipoCambio.get("importe"),
						tipoCambio.get("codigoestado"), 
						cb.function("TO_CHAR",String.class,tipoCambio.get("fecha"), cb.literal("dd-MM-yyyy")),
						divisa.get("codigo")
						));

		cqc.select(cb.coalesce(cb.count(tipoCambioc), 0l));

		/** End select */

		TypedQuery<TipoCambioTableDTO> query = em.createQuery(cq);
		TypedQuery<Long> queryc = em.createQuery(cqc);

		/** Paginador */
		query.setFirstResult(tipoCambioSearch.getStart());
		/** Paginador */

		/** Tamano */
		if (tipoCambioSearch.getLength() > -1) {
			query.setMaxResults(tipoCambioSearch.getLength());
		}

		/** Parametros */
		if (tipoCambioSearch.getFecha() != null ) {
			query.setParameter("fechaTipoCambio", tipoCambioSearch.getFecha());
			queryc.setParameter("fechaTipoCambio", tipoCambioSearch.getFecha());
		}

		return new DatatableDTO<>(tipoCambioSearch.getDraw(), queryc.getSingleResult(), query.getResultList());
	}
}
