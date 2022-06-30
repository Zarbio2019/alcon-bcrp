package pe.grupobbva.alcon.mantenimiento.repository;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteSeisRepository {
	
	public DatatableDTO<ReporteSeisDTO> searchReportSix(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteSeisExcelDTO> getExcelReportSix(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteSeisTxtDTO> getTxtReportSix(ReporteSearch reporteSearch);

}
