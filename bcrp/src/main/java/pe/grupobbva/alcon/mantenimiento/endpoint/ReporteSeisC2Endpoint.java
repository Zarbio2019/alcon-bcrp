package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportTxtView;
import pe.grupobbva.alcon.mantenimiento.service.ReporteSeisC2Service;

@RestController
@RequestMapping("/reporteseisc2")
public class ReporteSeisC2Endpoint extends ReportFilter{
	
	@Autowired
	private ReporteSeisC2Service reporteSeisC2Service;
	
	@GetMapping(produces = "application/json")
	public DatatableDTO<ReporteSeisC2DTO> searchReportSixC2(ReporteSearch reporteSearch){
		return reporteSeisC2Service.searchReportSixC2(reporteSearch);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView excelReportSixC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSeisExcelC2DTO> consulta = reporteSeisC2Service.getExcelReportSixC2(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteSeisExcelC2DTO>(consulta, "gvReporte6"));
	}
	
	@GetMapping(path="/vertxt")
	public List<ReporteSeisTxtC2DTO> viewTxtReportSixC2(ReporteSearch reporteSearch){
		return reporteSeisC2Service.viewTxtReportSixC2(reporteSearch);
	}
	
	@GetMapping(path="/generartxt")
	public ModelAndView txtReportSixC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSeisTxtC2DTO> consulta = reporteSeisC2Service.getTxtReportSixC2(reporteSearch); 
		
		Iterator<String> namefile = consulta.getColumnas().iterator();
		String name = "";
		while(namefile.hasNext()) {
			name += namefile.next().toString();
		}
		return new ModelAndView(new ReportTxtView<ReporteSeisTxtC2DTO>(consulta,name));
	}
	
	@GetMapping(path="/generarexcel/txt")
	public ModelAndView txtToExcelReportSixC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSeisTxtC2DTO> consulta = reporteSeisC2Service.getTxtToExcelReportSixC2(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteSeisTxtC2DTO>(consulta, "gvReporte6"));
	}

}
