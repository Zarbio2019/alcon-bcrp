package pe.grupobbva.alcon.mantenimiento.service;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.OficinaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OficinaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OficinaTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Oficina;

public interface OficinaService extends AbstractService<Oficina> {
	
	public DatatableDTO<OficinaTableDTO> search(OficinaSearch oficinaSearch);
	public SelectOptions<SelectOptionsDTO> listOptions();
	public Oficina obtenerOficinaPorCodigo(String codigo);
	public List<OficinaDTO> listarOficinas();
	
}
