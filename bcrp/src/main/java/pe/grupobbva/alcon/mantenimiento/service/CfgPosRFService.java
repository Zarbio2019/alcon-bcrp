package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRFDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgPosRFSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CfgPosRF;


public interface CfgPosRFService extends AbstractService<CfgPosRF> {
	public DatatableDTO<CfgPosRFDTO> search(CfgPosRFSearch search);
}
