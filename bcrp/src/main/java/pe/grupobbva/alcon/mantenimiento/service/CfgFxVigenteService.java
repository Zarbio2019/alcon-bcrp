package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgFxVigenteDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgFxVigenteSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CfgFxVigente;

public interface CfgFxVigenteService extends AbstractService<CfgFxVigente> {
	public DatatableDTO<CfgFxVigenteDTO> search(CfgFxVigenteSearch cfgFxVigenteSearch);
}
