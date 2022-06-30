package pe.grupobbva.alcon.mantenimiento.repository.custom;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD02DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgRCD02Search;

public interface CfgRCD02CustomRepository {
	public DatatableDTO<CfgRCD02DTO> search(CfgRCD02Search cfgRCD02search);
	}
