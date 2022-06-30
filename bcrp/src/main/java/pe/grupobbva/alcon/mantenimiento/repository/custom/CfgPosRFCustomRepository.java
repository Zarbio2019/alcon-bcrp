package pe.grupobbva.alcon.mantenimiento.repository.custom;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRFDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgPosRFSearch;

public interface CfgPosRFCustomRepository {
	public DatatableDTO<CfgPosRFDTO> search(CfgPosRFSearch search);
}
