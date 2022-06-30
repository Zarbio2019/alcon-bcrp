package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;


import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable.OrderCriterias;
import pe.grupobbva.alcon.mantenimiento.dto.CfgFxVigenteDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgFxVigenteSearch;

import pe.grupobbva.alcon.mantenimiento.entity.CfgFxVigente;

import pe.grupobbva.alcon.mantenimiento.repository.custom.CfgFxVigenteCustomRepository;

public class CfgFxVigenteCustomRepositoryImpl implements CfgFxVigenteCustomRepository {
	
	

	@Autowired
	private EntityManager em;
	
	@Override
	public DatatableDTO<CfgFxVigenteDTO> search(CfgFxVigenteSearch cfgFxVigenteSearch) {
		// TODO Auto-generated method stub
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		
		CriteriaQuery<CfgFxVigenteDTO> cq = cb.createQuery(CfgFxVigenteDTO.class);
		CriteriaQuery<Long> cqc = cb.createQuery(Long.class);
		
		List<Predicate> andPredicates = new ArrayList<>();
		
		Root<CfgFxVigente> cfg = cq.from(CfgFxVigente.class);
		Root<CfgFxVigente> cfgc = cqc.from(CfgFxVigente.class);
		
		andPredicates.add(cb.equal(cfg.get("codigoestado"), 1));
		
		cq.where(andPredicates.stream().toArray(Predicate[]::new));
		
		Map<OrderCriterias, String> order = cfgFxVigenteSearch.getOrder().get(0);
		
		cq.select(cb.construct(CfgFxVigenteDTO.class, cfg.get("id"), cfg.get("subproducto"), cfg.get("operacion"), cfg.get("fecha_vencimiento"), cfg.get("divisa"), cfg.get("cuenta")));
		cqc.select(cb.coalesce(cb.count(cfgc), 0l));
		
		
		TypedQuery<CfgFxVigenteDTO> query = em.createQuery(cq);
		TypedQuery<Long> queryc = em.createQuery(cqc);
		
		/** Paginador */
		query.setFirstResult(cfgFxVigenteSearch.getStart());
		/** Paginador */

		/** Tamano 
		if (cfgFxVigenteSearch.getLength() > -1) {
			query.setMaxResults(cfgFxVigenteSearch.getLength());
		}*/
		
		
		
		return new DatatableDTO<>(cfgFxVigenteSearch.getDraw(), queryc.getSingleResult(), query.getResultList());
	}

}
