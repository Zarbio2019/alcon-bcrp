package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroDetalleDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.Circular;

public interface ReporteCuatroRepository {
	
	public DatatableDTO<ReporteCuatroDTO> searchReportFour(ReporteSearch reporteSearch, Circular circular);
	
	public ReporteCuatroDTO getReportFour(String id);
	
	public void generar(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteCuatroExcelDTO> getExcelReportFour(ReporteSearch reporteSearch, Circular circular);
	
	public TablaDinamica<ReporteCuatroExcelDTO> getPdfReportFour(ReporteSearch reporteSearch, Circular circular);
	
	public TablaDinamica<ReporteCuatroTxtDTO> getTxtReportFour(ReporteSearch reporteSearch, Circular circular);
	
	public List<ReporteCuatroTxtDTO> viewTxtReportFour(ReporteSearch reporteSearch, Circular circular);

	public List<ReporteCuatroDetalleDTO> viewDetailReportFour(ReporteSearch reporteSearch, String id, Circular circular);

	public TablaDinamica<ReporteCuatroDetalleDTO> getExcelDetailReportFour(ReporteSearch reporteSearch, String id, Circular circular);

	public TablaDinamica<ReporteCuatroDetalleDTO> getExcelAnexo8(ReporteSearch reporteSearch, String id, Circular circular);
	
}
