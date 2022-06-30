package pe.grupobbva.alcon.mantenimiento.repository.custom;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.DivisaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.DivisaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;

public interface DivisaCustomRepository {
	
	public DatatableDTO<DivisaDTO> search(DivisaSearch divisaSearch);
	public SelectOptions<SelectOptionsDTO> listOptions();
}
