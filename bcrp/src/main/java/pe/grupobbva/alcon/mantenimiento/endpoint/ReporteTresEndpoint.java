package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportTxtView;
import pe.grupobbva.alcon.mantenimiento.service.ReporteTresService;

@RestController
@RequestMapping("/reportetres")
public class ReporteTresEndpoint extends ReportFilter {
	
	@Autowired
	private ReporteTresService reporteTresService;

	@GetMapping(produces = "application/json")
	public DatatableDTO<ReporteTresDTO> searchReportThree(ReporteSearch reporteSearch){
		return reporteTresService.searchReportThree(reporteSearch);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView excelReportThree(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteTresExcelDTO> consulta = reporteTresService.getExcelReportThree(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteTresExcelDTO>(consulta, "gvReporte3"));
	}
	
	@GetMapping(path="/generartxt")
	public ModelAndView txtReportThree(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteTresTxtDTO> consulta = reporteTresService.getTxtReportThree(reporteSearch); 
		Iterator<String> namefile = consulta.getColumnas().iterator();
		String name="";
		while(namefile.hasNext()) {
			name += namefile.next().toString();
		}
		return new ModelAndView(new ReportTxtView<ReporteTresTxtDTO>(consulta,name));
	}
	
	@GetMapping(path="/vertxt")
	public List<ReporteTresTxtDTO> viewTxtReportThree(ReporteSearch reporteSearch){
		return reporteTresService.viewTxtReportThree(reporteSearch);
	}
	
}
