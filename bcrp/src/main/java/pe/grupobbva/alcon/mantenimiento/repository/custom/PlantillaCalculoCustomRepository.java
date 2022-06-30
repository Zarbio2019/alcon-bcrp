package pe.grupobbva.alcon.mantenimiento.repository.custom;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.PlantillaCalculoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.PlantillaCalculoTableDTO;

public interface PlantillaCalculoCustomRepository {
	
	public DatatableDTO<PlantillaCalculoTableDTO> search(PlantillaCalculoSearch plantillaCalculoSearch);

}
