package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRVDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgPosRVSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CfgPosRV;

public interface CfgPosRVService extends AbstractService<CfgPosRV>{
	public DatatableDTO<CfgPosRVDTO> search(CfgPosRVSearch search);
}
