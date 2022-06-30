package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportTxtView;
import pe.grupobbva.alcon.mantenimiento.service.ReporteDosC2Service;

@RestController
@RequestMapping("/reportedosc2")
public class ReporteDosC2Endpoint extends ReportFilter{

	@Autowired
	private ReporteDosC2Service reporteDosC2Service;

	@GetMapping(produces = "application/json")
	public DatatableDTO<ReporteDosC2DTO> searchReportTwoC2(ReporteSearch reporteSearch){
		return reporteDosC2Service.searchReportTwoC2(reporteSearch);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView excelReportTwoC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteDosExcelC2DTO> consulta = reporteDosC2Service.getExcelReportTwoC2(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteDosExcelC2DTO>(consulta, "gvReporte2"));
	}
	

	@GetMapping(path="/vertxt")
	public List<ReporteDosTxtC2DTO> viewTxtReportTwoC2(ReporteSearch reporteSearch){
		return reporteDosC2Service.viewTxtReportTwoC2(reporteSearch);
	}

	@GetMapping(path="/generartxt")
	public ModelAndView txtReportTwoC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteDosTxtC2DTO> consulta = reporteDosC2Service.getTxtReportTwoC2(reporteSearch);
		Iterator<String> namefile = consulta.getColumnas().iterator();
		String name="";
		while(namefile.hasNext()) {
			name += namefile.next().toString();
		}
		return new ModelAndView(new ReportTxtView<ReporteDosTxtC2DTO>(consulta,name));
	}
	
	@GetMapping(path="/generarexcel/txt")
	public ModelAndView txtToExcelReportTwoC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteDosTxtC2DTO> consulta = reporteDosC2Service.getTxtToExcelReportTwoC2(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteDosTxtC2DTO>(consulta, "gvReporte2"));
	}
}
