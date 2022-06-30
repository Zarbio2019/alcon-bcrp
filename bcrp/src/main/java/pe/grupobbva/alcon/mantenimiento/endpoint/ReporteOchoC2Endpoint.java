package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroDetalleDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoAnexo8DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoDetalleC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.Circular;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportTxtView;
import pe.grupobbva.alcon.mantenimiento.service.ReporteOchoC2Service;

@RestController
@RequestMapping("/reporteochoc2")
public class ReporteOchoC2Endpoint extends ReportFilter{

	@Autowired
	private ReporteOchoC2Service reporteOchoC2Service;
	
	@GetMapping(produces = "application/json")
	public DatatableDTO<ReporteOchoC2DTO> searchReportEightC2(ReporteSearch reporteSearch){
		return reporteOchoC2Service.searchReportEightC2(reporteSearch);
	}
	
	@PostMapping(path = "/generar", produces = "application/json")
	public void generateReportEightC2(ReporteSearch reporteSearch) {
		reporteOchoC2Service.generateReportEightC2(reporteSearch);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView excelReportEightC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteOchoExcelC2DTO> consulta = reporteOchoC2Service.getExcelReportEightC2(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteOchoExcelC2DTO>(consulta, "gvReporte8"));
	}
	
	@GetMapping(path="/generartxt")
	public ModelAndView txtReportEightC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteOchoTxtC2DTO> consulta = reporteOchoC2Service.getTxtReportEightC2(reporteSearch); 
		Iterator<String> namefile = consulta.getColumnas().iterator();
		String name="";
		while(namefile.hasNext()) {
			name += namefile.next().toString();
		}
		return new ModelAndView(new ReportTxtView<ReporteOchoTxtC2DTO>(consulta,name));
	}
	
	@GetMapping(path="/vertxt")
	public List<ReporteOchoTxtC2DTO> viewTxtReportEightC2(ReporteSearch reporteSearch){
		return reporteOchoC2Service.viewTxtReportEightC2(reporteSearch);
	} 
	
	@GetMapping(path="/verdetalle")
	public List<ReporteOchoDetalleC2DTO> viewDetailReporteEightC2(ReporteSearch reporteSearch, String id){
		return reporteOchoC2Service.viewDetailReportEightC2(reporteSearch, id);
	} 
	
	@GetMapping(path="/generarexceldetalleoperaciones")
	public ModelAndView excelDetailReportEightC2(ReporteSearch reporteSearch, String id) {
		TablaDinamica<ReporteOchoDetalleC2DTO> consulta = reporteOchoC2Service.getExcelDetailReportEightC2(reporteSearch, id); 
		return new ModelAndView(new ReportExcelView<ReporteOchoDetalleC2DTO>(consulta, "Operaciones"));
	}	
	
	@GetMapping(path="/generaranexo8")
	public ModelAndView excelAnexo8(ReporteSearch reporteSearch, String id) {
		TablaDinamica<ReporteOchoAnexo8DTO> consulta = reporteOchoC2Service.getExcelAnexo8(reporteSearch, id); 
		return new ModelAndView(new ReportExcelView<ReporteOchoAnexo8DTO>(consulta, "Anexo 8"));
	}	
}
