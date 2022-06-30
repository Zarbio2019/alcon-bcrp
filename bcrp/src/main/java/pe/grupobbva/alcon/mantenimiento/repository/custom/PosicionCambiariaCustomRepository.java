package pe.grupobbva.alcon.mantenimiento.repository.custom;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.PosicionCambiariaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.PosicionCambiariaTableDTO;

public interface PosicionCambiariaCustomRepository {
	public DatatableDTO<PosicionCambiariaTableDTO> search(PosicionCambiariaSearch posicionCambiariaSearch);
}
