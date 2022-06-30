package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ReporteUnoRepository {

	public DatatableDTO<ReporteUnoDTO> searchReportOne(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteUnoExcelDTO> getExcelReportOne(ReporteSearch reporteSearch);
	
	public TablaDinamica<ReporteUnoTxtDTO> getTxtReportOne(ReporteSearch reporteSearch);
	
	public List<ReporteUnoTxtDTO> viewTxtReportOne(ReporteSearch reporteSearch);

}
