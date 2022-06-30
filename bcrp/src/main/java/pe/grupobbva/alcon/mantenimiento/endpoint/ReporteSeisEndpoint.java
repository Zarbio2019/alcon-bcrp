package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportTxtView;
import pe.grupobbva.alcon.mantenimiento.service.ReporteSeisService;

@RestController
@RequestMapping("/reporteseis")
public class ReporteSeisEndpoint extends ReportFilter {

	@Autowired
	private ReporteSeisService reporteSeisService;

	@GetMapping(produces = "application/json")
	public DatatableDTO<ReporteSeisDTO> searchReportSix(ReporteSearch reporteSearch){
		return reporteSeisService.searchReportSix(reporteSearch);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView excelReportSix(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSeisExcelDTO> consulta = reporteSeisService.getExcelReportSix(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteSeisExcelDTO>(consulta, "gvReporte6"));
	}
	
	@GetMapping(path="/generartxt")
	public ModelAndView txtReportSix(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSeisTxtDTO> consulta = reporteSeisService.getTxtReportSix(reporteSearch); 
		Iterator<String> namefile = consulta.getColumnas().iterator();
		String name="";
		while(namefile.hasNext()) {
			name += namefile.next().toString();
		}
		return new ModelAndView(new ReportTxtView<ReporteSeisTxtDTO>(consulta,name));
	}
	
}
