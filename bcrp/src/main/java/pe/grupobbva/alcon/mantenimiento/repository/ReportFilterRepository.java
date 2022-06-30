package pe.grupobbva.alcon.mantenimiento.repository;

import pe.grupobbva.alcon.mantenimiento.dto.custom.FiltroReporte;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.FiltroReporteResponse;

public interface ReportFilterRepository {
	public FiltroReporteResponse getFilter(FiltroReporte filtro); 
}
