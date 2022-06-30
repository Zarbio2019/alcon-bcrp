package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.DivisaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.DivisaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;

public interface DivisaService extends AbstractService<Divisa> {
	
	public DatatableDTO<DivisaDTO> search(DivisaSearch divisaSearch);
	public SelectOptions<SelectOptionsDTO> listOptions();
	public Divisa obtenerDivisaPorCodigo(String codigo);
	public Long divisaExistentes(String codigo);
	public Divisa obtenerDivisaPorId(String id);

}
