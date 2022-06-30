package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacioncargaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacioncargaTableDTO;
import pe.grupobbva.alcon.mantenimiento.repository.custom.OperacionCargaCustomRepository;

public class OperacionCargaCustomRepositoryImpl implements OperacionCargaCustomRepository {
	
	@Autowired
	private EntityManager em;
	
	private static final Logger log = LogManager.getLogger();
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<OperacioncargaTableDTO> listarErrores(OperacioncargaSearch operacioncargaSearch) {

		List<OperacioncargaTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_OPERACIONCARGA_LSTERROR")
				.setParameter("P_IDCARGA", operacioncargaSearch.getId())
				.getResultList();

		return new DatatableDTO<>(
				operacioncargaSearch.getDraw(), 
				Long.valueOf(resultados != null ? resultados.size() : 0),
				resultados
			);

	}

}
