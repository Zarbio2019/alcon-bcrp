package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.PosicionCambiariaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.PosicionCambiariaTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.PosicionCambiaria;

public interface PosicionCambiariaService extends AbstractService<PosicionCambiaria> {

	public DatatableDTO<PosicionCambiariaTableDTO> search(PosicionCambiariaSearch posicionCambiariaSearch);

}
