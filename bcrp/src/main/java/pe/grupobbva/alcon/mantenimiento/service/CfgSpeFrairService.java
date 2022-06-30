package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgSpeFrairDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgSpeFrairSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CfgSpeFrair;

public interface CfgSpeFrairService extends AbstractService<CfgSpeFrair> {
	public DatatableDTO<CfgSpeFrairDTO> search(CfgSpeFrairSearch search);
}
