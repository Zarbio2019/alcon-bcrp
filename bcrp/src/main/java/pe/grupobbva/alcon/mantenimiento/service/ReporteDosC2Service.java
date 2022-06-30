package pe.grupobbva.alcon.mantenimiento.service;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteDosC2Service {
	
	public DatatableDTO<ReporteDosC2DTO> searchReportTwoC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteDosExcelC2DTO> getExcelReportTwoC2(ReporteSearch reporteSearch);
	
	public List<ReporteDosTxtC2DTO> viewTxtReportTwoC2(ReporteSearch reporteSearch);

	public TablaDinamica<ReporteDosTxtC2DTO> getTxtReportTwoC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteDosTxtC2DTO> getTxtToExcelReportTwoC2(ReporteSearch reporteSearch);

}
