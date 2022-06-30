package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteTresRepository {
	
	public DatatableDTO<ReporteTresDTO> searchReportThree(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteTresExcelDTO> getExcelReportThree(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteTresTxtDTO> getTxtReportThree(ReporteSearch reporteSearch);
	
	public List<ReporteTresTxtDTO> viewTxtReportThree(ReporteSearch reporteSearch);
	
}
