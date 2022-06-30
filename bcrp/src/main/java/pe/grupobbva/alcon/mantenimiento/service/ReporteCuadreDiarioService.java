package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuadreDiarioExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteCuadreDiarioService {

	public TablaDinamica<ReporteCuadreDiarioExcelDTO> getExcelReport(ReporteSearch reporteSearch);

}
