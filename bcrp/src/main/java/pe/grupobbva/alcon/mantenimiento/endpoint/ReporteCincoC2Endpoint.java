package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCincoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCincoExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCincoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportTxtView;
import pe.grupobbva.alcon.mantenimiento.service.ReporteCincoC2Service;

@RestController
@RequestMapping("/reportecincoc2")
public class ReporteCincoC2Endpoint extends ReportFilter {

	@Autowired
	private ReporteCincoC2Service reporteCincoC2Service;

	@GetMapping(produces = "application/json")
	public DatatableDTO<ReporteCincoC2DTO> searchReportFiveC2(ReporteSearch reporteSearch){
		return reporteCincoC2Service.searchReportFiveC2(reporteSearch);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView excelReportFive(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCincoExcelC2DTO> consulta = reporteCincoC2Service.getExcelReportFiveC2(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteCincoExcelC2DTO>(consulta, "gvReporte5"));
	}
	
	@GetMapping(path="/generartxt")
	public ModelAndView txtReportFiveC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCincoTxtC2DTO> consulta = reporteCincoC2Service.getTxtReportFiveC2(reporteSearch); 
		Iterator<String> namefile = consulta.getColumnas().iterator();
		String name="";
		while(namefile.hasNext()) {
			name += namefile.next().toString();
		}
		return new ModelAndView(new ReportTxtView<ReporteCincoTxtC2DTO>(consulta,name));
	}
	
	@GetMapping(path="/generarexcel/txt")
	public ModelAndView txtToExcelReportFiveC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCincoTxtC2DTO> consulta = reporteCincoC2Service.getTxtToExcelReportFiveC2(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteCincoTxtC2DTO>(consulta, "gvReporte5"));
	}
}
