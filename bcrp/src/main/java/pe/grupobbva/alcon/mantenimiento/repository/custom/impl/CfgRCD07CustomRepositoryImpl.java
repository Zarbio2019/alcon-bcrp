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
import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD02DTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD07DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgRCD07Search;
import pe.grupobbva.alcon.mantenimiento.entity.CfgRCD07;
import pe.grupobbva.alcon.mantenimiento.repository.custom.CfgRCD07CustomRepository;

public class CfgRCD07CustomRepositoryImpl implements CfgRCD07CustomRepository{

	@Autowired
	private EntityManager em;
	
	@Override
	public DatatableDTO<CfgRCD07DTO> search(CfgRCD07Search cfgRCD07Search) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<CfgRCD07DTO> cq = cb.createQuery(CfgRCD07DTO.class);
		CriteriaQuery<Long> cqc = cb.createQuery(Long.class);
		
		List<Predicate> andPredicates = new ArrayList<>();
		
		Root<CfgRCD07> cfg = cq.from(CfgRCD07.class);
		Root<CfgRCD07> cfgc = cqc.from(CfgRCD07.class);
		
		andPredicates.add(cb.equal(cfg.get("codigoestado"), 1));
		
		cq.where(andPredicates.stream().toArray(Predicate[]::new));
		
		Map<OrderCriterias, String> order = cfgRCD07Search.getOrder().get(0);
		
		cq.select(cb.construct(CfgRCD07DTO.class, cfg.get("id"), cfg.get("filainicio"), cfg.get("filafin"), cfg.get("divisa"), cfg.get("cuenta")));
		cqc.select(cb.coalesce(cb.count(cfgc), 0l));
		
		TypedQuery<CfgRCD07DTO> query = em.createQuery(cq);
		TypedQuery<Long> queryc = em.createQuery(cqc);
		
		query.setFirstResult(cfgRCD07Search.getStart());
		
		return new DatatableDTO<>(cfgRCD07Search.getDraw(), queryc.getSingleResult(), query.getResultList());
		
	}

}
