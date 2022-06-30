package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportTxtView;
import pe.grupobbva.alcon.mantenimiento.service.ReporteUnoService;

@RestController
@RequestMapping("/reporteuno")
public class ReporteUnoEndpoint extends ReportFilter {

	@Autowired
	private ReporteUnoService reporteUnoService;

	@GetMapping(produces = "application/json")
	public DatatableDTO<ReporteUnoDTO> searchReportOne(ReporteSearch reporteSearch){
		return reporteUnoService.searchReportOne(reporteSearch);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView excelReportOne(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteUnoExcelDTO> consulta = reporteUnoService.getExcelReportOne(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteUnoExcelDTO>(consulta, "gvReporte1"));
	}
	
	@GetMapping(path="/generartxt")
	public ModelAndView txtReportOne(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteUnoTxtDTO> consulta = reporteUnoService.getTxtReportOne(reporteSearch); 
		
		Iterator<String> namefile = consulta.getColumnas().iterator();
		String name="";
		while(namefile.hasNext()) {
			name += namefile.next().toString();
		}
		return new ModelAndView(new ReportTxtView<ReporteUnoTxtDTO>(consulta,name));
	}
	
	@GetMapping(path="/vertxt")
	public List<ReporteUnoTxtDTO> viewTxtReportOne(ReporteSearch reporteSearch){
		return reporteUnoService.viewTxtReportOne(reporteSearch);
	}

}
