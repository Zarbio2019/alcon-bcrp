package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportTxtView;
import pe.grupobbva.alcon.mantenimiento.service.ReporteUnoC2Service;

@RestController
@RequestMapping("/reporteunoc2")
public class ReporteUnoC2Endpoint extends ReportFilter{
	
	@Autowired
	private ReporteUnoC2Service reporteUnoC2Service;
	
	@GetMapping(produces = "application/json")
	public DatatableDTO<ReporteUnoC2DTO> searchReportOneC2(ReporteSearch reporteSearch){
		return reporteUnoC2Service.searchReportOneC2(reporteSearch);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView excelReportOneC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteUnoExcelC2DTO> consulta = reporteUnoC2Service.getExcelReportOneC2(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteUnoExcelC2DTO>(consulta, "gvReporte1"));
	}
	
	@GetMapping(path="/vertxt")
	public List<ReporteUnoTxtC2DTO> viewTxtReportOneC2(ReporteSearch reporteSearch){
		return reporteUnoC2Service.viewTxtReportOneC2(reporteSearch);
	}
	
	@GetMapping(path="/generartxt")
	public ModelAndView txtReportOneC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteUnoTxtC2DTO> consulta = reporteUnoC2Service.getTxtReportOneC2(reporteSearch); 
		
		Iterator<String> namefile = consulta.getColumnas().iterator();
		String name = "";
		while(namefile.hasNext()) {
			name += namefile.next().toString();
		}
		return new ModelAndView(new ReportTxtView<ReporteUnoTxtC2DTO>(consulta,name));
	}
	
	@GetMapping(path="/generarexcel/txt")
	public ModelAndView txtToExcelReportOneC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteUnoTxtC2DTO> consulta = reporteUnoC2Service.getTxtToExcelReportOneC2(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteUnoTxtC2DTO>(consulta, "gvReporte1"));
	}

}
