package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportTxtView;
import pe.grupobbva.alcon.mantenimiento.service.ReporteDosService;

@RestController
@RequestMapping("/reportedos")
public class ReporteDosEndpoint extends ReportFilter{

	@Autowired
	private ReporteDosService reporteDosService;

	@GetMapping(produces = "application/json")
	public DatatableDTO<ReporteDosDTO> searchReportTwo(ReporteSearch reporteSearch){
		return reporteDosService.searchReportTwo(reporteSearch);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView excelReportTwo(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteDosExcelDTO> consulta = reporteDosService.getExcelReportTwo(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteDosExcelDTO>(consulta, "gvReporte2"));
	}
	
	@GetMapping(path="/generartxt")
	public ModelAndView txtReportTwo(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteDosTxtDTO> consulta = reporteDosService.getTxtReportTwo(reporteSearch);
		Iterator<String> namefile = consulta.getColumnas().iterator();
		String name="";
		while(namefile.hasNext()) {
			name += namefile.next().toString();
		}
		return new ModelAndView(new ReportTxtView<ReporteDosTxtDTO>(consulta,name));
	}
	
	@GetMapping(path="/vertxt")
	public List<ReporteDosTxtDTO> viewTxtReportTwo(ReporteSearch reporteSearch){
		return reporteDosService.viewTxtReportTwo(reporteSearch);
	}
	
}
