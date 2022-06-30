package pe.grupobbva.alcon.mantenimiento.service;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteSeisC2Service {
	
	public DatatableDTO<ReporteSeisC2DTO> searchReportSixC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteSeisExcelC2DTO> getExcelReportSixC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteSeisTxtC2DTO> getTxtReportSixC2(ReporteSearch reporteSearch);
	
	public List<ReporteSeisTxtC2DTO> viewTxtReportSixC2(ReporteSearch reporteSearch);

	public TablaDinamica<ReporteSeisTxtC2DTO> getTxtToExcelReportSixC2(ReporteSearch reporteSearch);
	
	public List<ReporteSeisC2DTO> listReportSixC2(ReporteSearch reporteSearch);
}
