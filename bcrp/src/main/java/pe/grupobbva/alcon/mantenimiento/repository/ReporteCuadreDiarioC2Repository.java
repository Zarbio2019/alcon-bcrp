package pe.grupobbva.alcon.mantenimiento.repository;

import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuadreDiarioC2ExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteCuadreDiarioC2Repository {

	public TablaDinamica<ReporteCuadreDiarioC2ExcelDTO> getExcelReport(ReporteSearch reporteSearch);

}
