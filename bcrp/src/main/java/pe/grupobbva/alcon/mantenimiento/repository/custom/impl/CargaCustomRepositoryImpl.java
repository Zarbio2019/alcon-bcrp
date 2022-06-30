package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CargaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CargaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.CargaTableDTO;
import pe.grupobbva.alcon.mantenimiento.repository.custom.CargaCustomRepository;

public class CargaCustomRepositoryImpl implements CargaCustomRepository {

	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public List<CargaDTO> listarCargaPorReprocesar(Calendar fecha) {

		List<CargaDTO> resultados;

		resultados = em.createNamedStoredProcedureQuery("SP_BCR_CARGA_LISTARREPROCESAR")
				.setParameter("P_FECHAPROCESO", new Date(fecha.getTimeInMillis()))
				.getResultList();

		return resultados;
	}

	@Override
	public void reprocesar(String idcarga) {

		em.createNamedStoredProcedureQuery("SP_BCR_CARGA_REPROCESAR")
		  .setParameter("P_IDCARGA", idcarga)
		  .execute();

	}

	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<CargaTableDTO> search(CargaSearch search) {
		List<CargaTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_CARGA_LISTAR")
				.getResultList();
		
		return new DatatableDTO<>(
				search.getDraw(), 
					Long.valueOf(resultados != null ? resultados.size(): 0 ),
					Utils.paginador(resultados, search)
				);

	}

}
