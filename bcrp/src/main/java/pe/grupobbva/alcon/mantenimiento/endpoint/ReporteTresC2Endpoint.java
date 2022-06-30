package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportTxtView;
import pe.grupobbva.alcon.mantenimiento.service.ReporteTresC2Service;

@RestController
@RequestMapping("/reportetresc2")
public class ReporteTresC2Endpoint extends ReportFilter {
	
	@Autowired
	private ReporteTresC2Service reporteTresC2Service;

	@GetMapping(produces = "application/json")
	public DatatableDTO<ReporteTresC2DTO> searchReportThreeC2(ReporteSearch reporteSearch){
		return reporteTresC2Service.searchReportThreeC2(reporteSearch);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView excelReportThreeC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteTresExcelC2DTO> consulta = reporteTresC2Service.getExcelReportThreeC2(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteTresExcelC2DTO>(consulta, "gvReporte3"));
	}
	
	@GetMapping(path="/generartxt")
	public ModelAndView txtReportThreeC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteTresTxtC2DTO> consulta = reporteTresC2Service.getTxtReportThreeC2(reporteSearch); 
		Iterator<String> namefile = consulta.getColumnas().iterator();
		String name="";
		while(namefile.hasNext()) {
			name += namefile.next().toString();
		}
		return new ModelAndView(new ReportTxtView<ReporteTresTxtC2DTO>(consulta,name));
	}
	
	@GetMapping(path="/vertxt")
	public List<ReporteTresTxtC2DTO> viewTxtReportThreeC2(ReporteSearch reporteSearch){
		return reporteTresC2Service.viewTxtReportThreeC2(reporteSearch);
	}
	
	@GetMapping(path="/generarexcel/txt")
	public ModelAndView txtToExcelReportThreeC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteTresTxtC2DTO> consulta = reporteTresC2Service.getTxtToExcelReportThreeC2(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteTresTxtC2DTO>(consulta, "gvReporte3"));
	}
}
