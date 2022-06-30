package pe.grupobbva.alcon.mantenimiento.repository;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCincoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCincoExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCincoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteCincoC2Repository {
	
public DatatableDTO<ReporteCincoC2DTO> searchReportFiveC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteCincoExcelC2DTO> getExcelReportFiveC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteCincoTxtC2DTO> getTxtReportFiveC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteCincoTxtC2DTO> getTxtToExcelReportFiveC2(ReporteSearch reporteSearch);

}
