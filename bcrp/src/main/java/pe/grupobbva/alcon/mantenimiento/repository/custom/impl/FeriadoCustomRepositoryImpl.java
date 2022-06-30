package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.FeriadoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.custom.FeriadoCopia;
import pe.grupobbva.alcon.mantenimiento.dto.search.FeriadoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.FeriadoTableDTO;
import pe.grupobbva.alcon.mantenimiento.repository.custom.FeriadoCustomRepository;

public class FeriadoCustomRepositoryImpl implements FeriadoCustomRepository {

	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<FeriadoTableDTO> search(FeriadoSearch feriadoSearch) {
		List<FeriadoTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_FERIADO_LISTAR")
				.setParameter("P_ANIO", feriadoSearch.getAnio() == null ? 0 : feriadoSearch.getAnio())
				.setParameter("P_MES", feriadoSearch.getMes() == null ? 0 : feriadoSearch.getMes())
				.setParameter("P_TIPO", StringUtils.isBlank(feriadoSearch.getTipo())? null:feriadoSearch.getTipo())
				.getResultList();
		
		return new DatatableDTO<>(
				feriadoSearch.getDraw(), 
					Long.valueOf(resultados != null ? resultados.size(): 0 ),
					Utils.paginador(resultados, feriadoSearch)
				);
	}
	
	@Override
	public void copiarFeriado(FeriadoCopia feriadoCopia) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_FERIADO_COPIAR")
		   .setParameter("P_TIPO", feriadoCopia.getTipo())
		   .setParameter("P_ANIO", feriadoCopia.getAnio())
		   .setParameter("P_USUARIOCREACION", feriadoCopia.getCreadoPor())
		   .execute();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FeriadoDTO> listarFeriados() {
		
		List<FeriadoDTO> resultados;
		
		resultados = em.createNamedStoredProcedureQuery("SP_BCR_FERIADO_LISTAR")
					   .setParameter("P_ANIO", 0)
					   .setParameter("P_MES", 0)
					   .setParameter("P_TIPO", "")
					   .getResultList();
		
		return resultados;	
	}

}
