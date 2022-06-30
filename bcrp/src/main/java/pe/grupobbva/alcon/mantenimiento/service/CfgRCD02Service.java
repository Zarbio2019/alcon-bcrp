package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD02DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgRCD02Search;
import pe.grupobbva.alcon.mantenimiento.entity.CfgRCD02;


public interface CfgRCD02Service extends AbstractService<CfgRCD02> {
	public DatatableDTO<CfgRCD02DTO> search(CfgRCD02Search search);
}
