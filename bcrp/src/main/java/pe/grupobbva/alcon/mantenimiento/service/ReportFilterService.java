package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.mantenimiento.dto.custom.FiltroReporte;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.FiltroReporteResponse;

public interface ReportFilterService {
		
	public FiltroReporteResponse getFilter(FiltroReporte filtro);

}
