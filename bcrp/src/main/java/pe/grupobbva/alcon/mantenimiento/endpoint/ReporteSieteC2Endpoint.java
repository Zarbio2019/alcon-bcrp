package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSieteC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSieteExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSieteTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportTxtView;
import pe.grupobbva.alcon.mantenimiento.service.ReporteSieteC2Service;

@RestController
@RequestMapping("/reportesietec2")
public class ReporteSieteC2Endpoint extends ReportFilter{
	
	@Autowired
	private ReporteSieteC2Service reporteSieteC2Service;
	
	@GetMapping(produces = "application/json")
	public DatatableDTO<ReporteSieteC2DTO> searchReportSevenC2(ReporteSearch reporteSearch){
		return reporteSieteC2Service.searchReportSevenC2(reporteSearch);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView excelReportSevenC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSieteExcelC2DTO> consulta = reporteSieteC2Service.getExcelReportSevenC2(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteSieteExcelC2DTO>(consulta, "gvReporte7"));
	}
	
	@GetMapping(path="/vertxt")
	public List<ReporteSieteTxtC2DTO> viewTxtReportSevenC2(ReporteSearch reporteSearch){
		return reporteSieteC2Service.viewTxtReportSevenC2(reporteSearch);
	}
	
	@GetMapping(path="/generartxt")
	public ModelAndView txtReportSevenC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSieteTxtC2DTO> consulta = reporteSieteC2Service.getTxtReportSevenC2(reporteSearch); 
		
		Iterator<String> namefile = consulta.getColumnas().iterator();
		String name = "";
		while(namefile.hasNext()) {
			name += namefile.next().toString();
		}
		return new ModelAndView(new ReportTxtView<ReporteSieteTxtC2DTO>(consulta,name));
	}

	@GetMapping(path="/generarexcel/txt")
	public ModelAndView txtToExcelReportSevenC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSieteTxtC2DTO> consulta = reporteSieteC2Service.getTxtToExcelReportSevenC2(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteSieteTxtC2DTO>(consulta, "gvReporte7"));
	}
}
