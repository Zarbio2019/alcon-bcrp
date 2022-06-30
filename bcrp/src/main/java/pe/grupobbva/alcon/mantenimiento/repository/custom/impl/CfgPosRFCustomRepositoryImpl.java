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
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRFDTO;

import pe.grupobbva.alcon.mantenimiento.dto.search.CfgPosRFSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CfgPosRF;
import pe.grupobbva.alcon.mantenimiento.repository.custom.CfgPosRFCustomRepository;

public class CfgPosRFCustomRepositoryImpl implements CfgPosRFCustomRepository{

	@Autowired
	private EntityManager em;
	
	@Override
	public DatatableDTO<CfgPosRFDTO> search(CfgPosRFSearch cfgPosRFSearch) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<CfgPosRFDTO> cq = cb.createQuery(CfgPosRFDTO.class);
		CriteriaQuery<Long> cqc = cb.createQuery(Long.class);
		
		List<Predicate> andPredicates = new ArrayList<>();
		
		Root<CfgPosRF> cfg = cq.from(CfgPosRF.class);
		Root<CfgPosRF> cfgc = cqc.from(CfgPosRF.class);
		
		andPredicates.add(cb.equal(cfg.get("codigoestado"), 1));
		
		cq.where(andPredicates.stream().toArray(Predicate[]::new));
		
		Map<OrderCriterias, String> order = cfgPosRFSearch.getOrder().get(0);
		
		cq.select(cb.construct(CfgPosRFDTO.class, cfg.get("id"), cfg.get("cartera"), cfg.get("clase"), cfg.get("divisa"), cfg.get("importe"), cfg.get("cuenta")));
		cqc.select(cb.coalesce(cb.count(cfgc), 0l));
		
		TypedQuery<CfgPosRFDTO> query = em.createQuery(cq);
		TypedQuery<Long> queryc = em.createQuery(cqc);
		
		query.setFirstResult(cfgPosRFSearch.getStart());
		
		return new DatatableDTO<>(cfgPosRFSearch.getDraw(), queryc.getSingleResult(), query.getResultList());
	}

}
