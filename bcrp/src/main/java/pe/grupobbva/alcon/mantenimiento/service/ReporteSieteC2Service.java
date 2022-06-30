package pe.grupobbva.alcon.mantenimiento.service;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSieteC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSieteExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSieteTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteSieteC2Service {

	public DatatableDTO<ReporteSieteC2DTO> searchReportSevenC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteSieteExcelC2DTO> getExcelReportSevenC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteSieteTxtC2DTO> getTxtReportSevenC2(ReporteSearch reporteSearch);
	
	public List<ReporteSieteTxtC2DTO> viewTxtReportSevenC2(ReporteSearch reporteSearch);

	public TablaDinamica<ReporteSieteTxtC2DTO> getTxtToExcelReportSevenC2(ReporteSearch reporteSearch);
	
	public List<ReporteSieteC2DTO> listReportSevenC2(ReporteSearch reporteSearch);
	
}
