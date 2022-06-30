package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CierreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CierreDiarioSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CierreDiario;

public interface CierreDiarioService extends AbstractService<CierreDiario> {
	
	public DatatableDTO<CierreDiarioDTO> search(CierreDiarioSearch cierrediarioSearch);

}
