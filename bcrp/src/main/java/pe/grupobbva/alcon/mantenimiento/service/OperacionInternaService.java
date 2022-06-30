package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.custom.OperacionCalculate;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.OperacionCalculateResponse;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionInternaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacionInternaTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionInterna;

public interface OperacionInternaService extends AbstractService<OperacionInterna> {
	
	public DatatableDTO<OperacionInternaTableDTO> search(OperacionInternaSearch operacionSearch);
	public OperacionCalculateResponse calculate(OperacionCalculate calculate);
	
}
