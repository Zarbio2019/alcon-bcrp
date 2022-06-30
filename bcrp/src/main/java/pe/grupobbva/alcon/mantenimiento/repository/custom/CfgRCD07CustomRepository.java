package pe.grupobbva.alcon.mantenimiento.repository.custom;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD07DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgRCD07Search;

public interface CfgRCD07CustomRepository {
	public DatatableDTO<CfgRCD07DTO> search(CfgRCD07Search cfgRCD07search);
}
