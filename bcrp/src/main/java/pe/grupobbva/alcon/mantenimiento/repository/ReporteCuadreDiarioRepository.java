package pe.grupobbva.alcon.mantenimiento.repository;

import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuadreDiarioExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteCuadreDiarioRepository {
	
	public TablaDinamica<ReporteCuadreDiarioExcelDTO> getExcelReport(ReporteSearch reporteSearch);

}
