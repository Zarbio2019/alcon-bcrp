package pe.grupobbva.alcon.mantenimiento.repository.custom;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.FeriadoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.custom.FeriadoCopia;
import pe.grupobbva.alcon.mantenimiento.dto.search.FeriadoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.FeriadoTableDTO;

public interface FeriadoCustomRepository {

	public DatatableDTO<FeriadoTableDTO> search(FeriadoSearch feriadoSearch);
	public void copiarFeriado(FeriadoCopia feriadoCopia);
	public List<FeriadoDTO> listarFeriados();
	
}
