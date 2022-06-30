package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteTresC2Repository {
	
	public DatatableDTO<ReporteTresC2DTO> searchReportThreeC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteTresExcelC2DTO> getExcelReportThreeC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteTresTxtC2DTO> getTxtReportThreeC2(ReporteSearch reporteSearch);
	
	public List<ReporteTresTxtC2DTO> viewTxtReportThreeC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteTresTxtC2DTO> getTxtToExcelReportThreeC2(ReporteSearch reporteSearch);
}
