package pe.grupobbva.alcon.mantenimiento.repository.custom;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRVDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgPosRVSearch;
public interface CfgPosRVCustomRepository {
	public DatatableDTO<CfgPosRVDTO> search(CfgPosRVSearch search);
}
