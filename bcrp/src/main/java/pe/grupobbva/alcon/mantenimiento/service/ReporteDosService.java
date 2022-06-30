package pe.grupobbva.alcon.mantenimiento.service;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteDosService {
	
	public DatatableDTO<ReporteDosDTO> searchReportTwo(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteDosExcelDTO> getExcelReportTwo(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteDosTxtDTO> getTxtReportTwo(ReporteSearch reporteSearch);
	
	public List<ReporteDosTxtDTO> viewTxtReportTwo(ReporteSearch reporteSearch);

}
