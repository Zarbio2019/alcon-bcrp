package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.OficinaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OficinaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OficinaTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Oficina;
import pe.grupobbva.alcon.mantenimiento.repository.custom.OficinaCustomRepository;

public class OficinaCustomRepositoryImpl implements OficinaCustomRepository {
	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<OficinaTableDTO> search(OficinaSearch oficinaSearch) {

		List<OficinaTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_OFICINA_LISTAR")
				.setParameter("P_DESCRIPCION", oficinaSearch.getDescripcion())
				.getResultList();
		
		return new DatatableDTO<>(
				oficinaSearch.getDraw(), 
					Long.valueOf(resultados != null ? resultados.size(): 0 ),
					Utils.paginador(resultados, oficinaSearch)
				);
	}
	
	public SelectOptions<SelectOptionsDTO> listOptions() {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		/** Begin create query */
		CriteriaQuery<SelectOptionsDTO> cq = cb.createQuery(SelectOptionsDTO.class);

		/** Begin FROM y JOINS */
		Root<Oficina> divisa = cq.from(Oficina.class);

		/** Begin where */
		cq.where(cb.equal(divisa.get("codigoestado"), "1"));

		/** Begin oderBy */
		cq.orderBy(cb.asc(divisa.get("codigo")));

		/** Begin Select */
		cq.select(cb.construct(SelectOptionsDTO.class, divisa.get("id"), divisa.get("codigo")));
		TypedQuery<SelectOptionsDTO> query = em.createQuery(cq);
		return new SelectOptions<>(query.getResultList());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OficinaDTO> listarOficinas() {
		
		List<OficinaDTO> resultados;
		
		resultados = em.createNamedStoredProcedureQuery("SP_BCR_OFICINA_LISTAR")
					   .setParameter("P_DESCRIPCION","")
					   .getResultList();
		
		return resultados;	
	}
}
