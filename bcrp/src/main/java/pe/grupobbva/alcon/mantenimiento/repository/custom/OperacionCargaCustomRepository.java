package pe.grupobbva.alcon.mantenimiento.repository.custom;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacioncargaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacioncargaTableDTO;

public interface OperacionCargaCustomRepository {

	public DatatableDTO<OperacioncargaTableDTO> listarErrores(OperacioncargaSearch search);

}
