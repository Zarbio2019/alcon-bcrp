package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuadreDiarioC2ExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteCuadreDiarioC2Service {
	
	public TablaDinamica<ReporteCuadreDiarioC2ExcelDTO> getExcelReport(ReporteSearch reporteSearch);

}
