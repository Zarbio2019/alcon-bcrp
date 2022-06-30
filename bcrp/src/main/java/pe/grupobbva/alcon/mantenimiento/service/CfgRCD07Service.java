package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD07DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgRCD07Search;
import pe.grupobbva.alcon.mantenimiento.entity.CfgRCD07;

public interface CfgRCD07Service extends AbstractService<CfgRCD07> {
	public DatatableDTO<CfgRCD07DTO> search(CfgRCD07Search search);
}
