package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteUnoC2Repository {

	public DatatableDTO<ReporteUnoC2DTO> searchReportOneC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteUnoExcelC2DTO> getExcelReportOneC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteUnoTxtC2DTO> getTxtReportOneC2(ReporteSearch reporteSearch);

	public List<ReporteUnoTxtC2DTO> viewTxtReportOneC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteUnoTxtC2DTO> getTxtToExcelReportOneC2(ReporteSearch reporteSearch);
	
	public List<ReporteUnoC2DTO> listReportOneC2(ReporteSearch reporteSearch);

}
