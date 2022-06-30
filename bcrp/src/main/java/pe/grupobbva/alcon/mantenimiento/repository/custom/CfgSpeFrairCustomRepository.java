package pe.grupobbva.alcon.mantenimiento.repository.custom;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgSpeFrairDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgSpeFrairSearch;

public interface CfgSpeFrairCustomRepository {
	public DatatableDTO<CfgSpeFrairDTO> search(CfgSpeFrairSearch search);
}
