package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoAnexo8DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoDetalleC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteOchoC2Repository {

public DatatableDTO<ReporteOchoC2DTO> searchReportEightC2(ReporteSearch reporteSearch); 
	
	public void generateReportEightC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteOchoExcelC2DTO> getExcelReportEightC2(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteOchoTxtC2DTO> getTxtReportEightC2(ReporteSearch reporteSearch);
	
	public List<ReporteOchoTxtC2DTO> viewTxtReportEightC2(ReporteSearch reporteSearch);

	public List<ReporteOchoDetalleC2DTO> viewDetailReportEightC2(ReporteSearch reporteSearch, String id);
	
	public TablaDinamica<ReporteOchoDetalleC2DTO> getExcelDetailReportEightC2(ReporteSearch reporteSearch, String id);
	
	public TablaDinamica<ReporteOchoAnexo8DTO> getExcelAnexo8(ReporteSearch reporteSearch, String id);
	
}
