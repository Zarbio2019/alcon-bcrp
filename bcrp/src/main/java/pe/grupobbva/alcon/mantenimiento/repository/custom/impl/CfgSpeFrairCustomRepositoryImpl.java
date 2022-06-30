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
import pe.grupobbva.alcon.mantenimiento.dto.CfgSpeFrairDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgSpeFrairSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CfgSpeFrair;
import pe.grupobbva.alcon.mantenimiento.repository.custom.CfgSpeFrairCustomRepository;

public class CfgSpeFrairCustomRepositoryImpl implements CfgSpeFrairCustomRepository {
	
	@Autowired
	private EntityManager em;

	@Override
	public DatatableDTO<CfgSpeFrairDTO> search(CfgSpeFrairSearch cfgSpeFrairSearch) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CfgSpeFrairDTO> cq = cb.createQuery(CfgSpeFrairDTO.class);
		CriteriaQuery<Long> cqc = cb.createQuery(Long.class);
		
		List<Predicate> andPredicates = new ArrayList<>();
		
		Root<CfgSpeFrair> cfg = cq.from(CfgSpeFrair.class);
		Root<CfgSpeFrair> cfgc = cqc.from(CfgSpeFrair.class);
		
		andPredicates.add(cb.equal(cfg.get("codigoestado"), 1));
		
		cq.where(andPredicates.stream().toArray(Predicate[]::new));
		
		Map<OrderCriterias, String> order = cfgSpeFrairSearch.getOrder().get(0);
		
		cq.select(cb.construct(CfgSpeFrairDTO.class, cfg.get("id"), cfg.get("subproducto"), cfg.get("operacion"), cfg.get("divisa"), cfg.get("importe"), cfg.get("recibo"), cfg.get("cuenta")));
cqc.select(cb.coalesce(cb.count(cfgc), 0l));
		
		
		TypedQuery<CfgSpeFrairDTO> query = em.createQuery(cq);
		TypedQuery<Long> queryc = em.createQuery(cqc);
		
		/** Paginador */
		query.setFirstResult(cfgSpeFrairSearch.getStart());
		
		return new DatatableDTO<>(cfgSpeFrairSearch.getDraw(), queryc.getSingleResult(), query.getResultList());
	}

}
