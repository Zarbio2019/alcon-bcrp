package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.PlantillaCalculoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.PlantillaCalculoTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.PlantillaCalculo;

public interface PlantillaCalculoService extends AbstractService<PlantillaCalculo> {
	
	public DatatableDTO<PlantillaCalculoTableDTO> search(PlantillaCalculoSearch plantillaCalculoSearch);

}
