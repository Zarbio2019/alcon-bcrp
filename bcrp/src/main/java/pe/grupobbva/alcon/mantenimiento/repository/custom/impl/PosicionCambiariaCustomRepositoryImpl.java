package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.PosicionCambiariaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.PosicionCambiariaTableDTO;
import pe.grupobbva.alcon.mantenimiento.repository.custom.PosicionCambiariaCustomRepository;

public class PosicionCambiariaCustomRepositoryImpl implements PosicionCambiariaCustomRepository {

	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<PosicionCambiariaTableDTO> search(PosicionCambiariaSearch posicionCambiariaSearch) {

		List<PosicionCambiariaTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_POSICION_CAMBIARIA")
				.setParameter("P_DESCRIPCION", posicionCambiariaSearch.getDescripcion())
				.setParameter("P_RUBRO", posicionCambiariaSearch.getRubro())
				.setParameter("P_PADRE_RUBRO", posicionCambiariaSearch.getRubropadre())
				.getResultList();
		return new DatatableDTO<>(posicionCambiariaSearch.getDraw(),
				Long.valueOf(resultados != null ? resultados.size() : 0),
				Utils.paginador(resultados, posicionCambiariaSearch));
	}

}
