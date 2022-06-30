package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.TasaTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.TasaInteres;

public interface OperacionTasasInteresService extends AbstractService<TasaInteres> { 

	public DatatableDTO<TasaTableDTO> search(OperacionSearch operacionSearch);

}
