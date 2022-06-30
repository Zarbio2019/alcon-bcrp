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
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgRCD02Search;
import pe.grupobbva.alcon.mantenimiento.entity.CfgRCD02;
import pe.grupobbva.alcon.mantenimiento.repository.custom.CfgRCD02CustomRepository;

public class CfgRCD02CustomRepositoryImpl implements CfgRCD02CustomRepository{

	@Autowired
	private EntityManager em;

	@Override
	public DatatableDTO<CfgRCD02DTO> search(CfgRCD02Search cfgRCD02Search) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		CriteriaQuery<CfgRCD02DTO> cq = cb.createQuery(CfgRCD02DTO.class);
		CriteriaQuery<Long> cqc = cb.createQuery(Long.class);
		
		List<Predicate> andPredicates = new ArrayList<>();
		
		Root<CfgRCD02> cfg = cq.from(CfgRCD02.class);
		Root<CfgRCD02> cfgc = cqc.from(CfgRCD02.class);
		
		andPredicates.add(cb.equal(cfg.get("codigoestado"), 1));
		
		cq.where(andPredicates.stream().toArray(Predicate[]::new));
		
		Map<OrderCriterias, String> order = cfgRCD02Search.getOrder().get(0);
		
		cq.select(cb.construct(CfgRCD02DTO.class, cfg.get("id"), cfg.get("filainicio"), cfg.get("filafin"), cfg.get("divisa"), cfg.get("cuenta")));
		cqc.select(cb.coalesce(cb.count(cfgc), 0l));
		
		TypedQuery<CfgRCD02DTO> query = em.createQuery(cq);
		TypedQuery<Long> queryc = em.createQuery(cqc);
		
		query.setFirstResult(cfgRCD02Search.getStart());
		
		return new DatatableDTO<>(cfgRCD02Search.getDraw(), queryc.getSingleResult(), query.getResultList());
	}
}
