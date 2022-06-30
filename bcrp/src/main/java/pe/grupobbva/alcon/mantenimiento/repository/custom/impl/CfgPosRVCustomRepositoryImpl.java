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
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRVDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgPosRVSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CfgPosRV;
import pe.grupobbva.alcon.mantenimiento.repository.custom.CfgPosRVCustomRepository;

public class CfgPosRVCustomRepositoryImpl implements CfgPosRVCustomRepository{

	@Autowired
	private EntityManager em;

	
	@Override
	public DatatableDTO<CfgPosRVDTO> search(CfgPosRVSearch cfgPosRVSearch) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<CfgPosRVDTO>  cq = cb.createQuery(CfgPosRVDTO.class);
		CriteriaQuery<Long> cqc = cb.createQuery(Long.class);
		
		List<Predicate> andPredicates = new ArrayList<>();
		
		Root<CfgPosRV> cfg = cq.from(CfgPosRV.class);
		Root<CfgPosRV> cfgc = cqc.from(CfgPosRV.class);
		
		andPredicates.add(cb.equal(cfg.get("codigoestado"), 1));
		
		cq.where(andPredicates.stream().toArray(Predicate[]::new));
		
		Map<OrderCriterias, String> order = cfgPosRVSearch.getOrder().get(0);
		
		cq.select(cb.construct(CfgPosRVDTO.class, cfg.get("id"), cfg.get("cartera"), cfg.get("clase"), cfg.get("divisa"), cfg.get("importe"), cfg.get("cuenta")));
		cqc.select(cb.coalesce(cb.count(cfgc), 0l));
		
		TypedQuery<CfgPosRVDTO> query = em.createQuery(cq);
		TypedQuery<Long> queryc = em.createQuery(cqc);
		
		query.setFirstResult(cfgPosRVSearch.getStart());
		
		return new DatatableDTO<>(cfgPosRVSearch.getDraw(), queryc.getSingleResult(), query.getResultList());
	}

}
