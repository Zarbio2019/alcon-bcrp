package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroDetalleDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.Circular;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportPdfView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportTxtView;
import pe.grupobbva.alcon.mantenimiento.service.ReporteCuatroService;

@RestController
@RequestMapping("/reportecuatro")
public class ReporteCuatroEndpoint extends ReportFilter{
	
	@Autowired
	private ReporteCuatroService reporteCuatroService;
	
	@GetMapping(produces = "application/json")
	public DatatableDTO<ReporteCuatroDTO> searchReportFour(ReporteSearch reporteSearch){
		return reporteCuatroService.searchReportFour(reporteSearch, Circular.C1);
	}
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public ReporteCuatroDTO getReportFour(@PathVariable String id) {
		return reporteCuatroService.getReportFour(id);
	}
	
	@PostMapping(path = "/generar", produces = "application/json")
	public void generar(ReporteSearch reporteSearch) {
		reporteCuatroService.generar(reporteSearch);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView excelReportFour(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCuatroExcelDTO> consulta = reporteCuatroService.getExcelReportFour(reporteSearch,Circular.C1); 
		return new ModelAndView(new ReportExcelView<ReporteCuatroExcelDTO>(consulta, "gvReporte4"));
	}
	
	@GetMapping(path="/generarpdf")
	public ModelAndView pdfReportFour(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCuatroExcelDTO> consulta = reporteCuatroService.getPdfReportFour(reporteSearch, Circular.C1); 
		return new ModelAndView(new ReportPdfView<ReporteCuatroExcelDTO>(consulta, "Reporte4","REPORTE 4: POSICIÓN GLOBAL Y CONTABLE"));
	}
	
	@GetMapping(path="/generartxt")
	public ModelAndView txtReportFour(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCuatroTxtDTO> consulta = reporteCuatroService.getTxtReportFour(reporteSearch, Circular.C1); 
		Iterator<String> namefile = consulta.getColumnas().iterator();
		String name="";
		while(namefile.hasNext()) {
			name += namefile.next().toString();
		}
		return new ModelAndView(new ReportTxtView<ReporteCuatroTxtDTO>(consulta,name));
	}
	
	@GetMapping(path="/vertxt")
	public List<ReporteCuatroTxtDTO> viewTxtReportFour(ReporteSearch reporteSearch){
		return reporteCuatroService.viewTxtReportFour(reporteSearch, Circular.C1);
	} 
	
	@GetMapping(path="/verdetalle")
	public List<ReporteCuatroDetalleDTO> viewDetailReportFour(ReporteSearch reporteSearch, String id){
		return reporteCuatroService.viewDetailReportFour(reporteSearch, id, Circular.C1);
	} 
	
	@GetMapping(path="/generarexceldetalleoperaciones")
	public ModelAndView excelDetailReportFour(ReporteSearch reporteSearch, String id) {
		TablaDinamica<ReporteCuatroDetalleDTO> consulta = reporteCuatroService.getExcelDetailReportFour(reporteSearch, id, Circular.C1); 
		return new ModelAndView(new ReportExcelView<ReporteCuatroDetalleDTO>(consulta, "Operaciones"));
	}	
	
	@GetMapping(path="/generaranexo8")
	public ModelAndView excelAnexo8(ReporteSearch reporteSearch, String id) {
		TablaDinamica<ReporteCuatroDetalleDTO> consulta = reporteCuatroService.getExcelAnexo8(reporteSearch, id, Circular.C1); 
		return new ModelAndView(new ReportExcelView<ReporteCuatroDetalleDTO>(consulta, "Anexo 8"));
	}	

	/*
	 * Circular 002
	 */
	
	@GetMapping(path="/c2", produces = "application/json")
	public DatatableDTO<ReporteCuatroDTO> searchReportFourC2(ReporteSearch reporteSearch){
		return reporteCuatroService.searchReportFour(reporteSearch, Circular.C2);
	}
	
	@GetMapping(path="/vertxtc2")
	public List<ReporteCuatroTxtDTO> viewTxtReportFourC2(ReporteSearch reporteSearch){
		return reporteCuatroService.viewTxtReportFour(reporteSearch, Circular.C2);
	} 
	
	@GetMapping(path="/generartxtc2")
	public ModelAndView txtReportFourC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCuatroTxtDTO> consulta = reporteCuatroService.getTxtReportFour(reporteSearch, Circular.C2); 
		Iterator<String> namefile = consulta.getColumnas().iterator();
		String name="";
		while(namefile.hasNext()) {
			name += namefile.next().toString();
		}
		return new ModelAndView(new ReportTxtView<ReporteCuatroTxtDTO>(consulta,name));
	}
	
	@GetMapping(path="/generarexcelc2")
	public ModelAndView excelReportFourC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCuatroExcelDTO> consulta = reporteCuatroService.getExcelReportFour(reporteSearch,Circular.C2); 
		return new ModelAndView(new ReportExcelView<ReporteCuatroExcelDTO>(consulta, "gvReporte4"));
	}
	
	@GetMapping(path="/generarpdfc2")
	public ModelAndView pdfReportFourC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCuatroExcelDTO> consulta = reporteCuatroService.getPdfReportFour(reporteSearch, Circular.C2); 
		return new ModelAndView(new ReportPdfView<ReporteCuatroExcelDTO>(consulta, "Reporte4","REPORTE 4: POSICIÓN GLOBAL Y CONTABLE"));
	}
	
	@GetMapping(path="/verdetallec2")
	public List<ReporteCuatroDetalleDTO> viewDetailReportFourC2(ReporteSearch reporteSearch, String id){
		return reporteCuatroService.viewDetailReportFour(reporteSearch, id, Circular.C2);
	} 
	
	@GetMapping(path="/generarexceldetalleoperacionesc2")
	public ModelAndView excelDetailReportFourC2(ReporteSearch reporteSearch, String id) {
		TablaDinamica<ReporteCuatroDetalleDTO> consulta = reporteCuatroService.getExcelDetailReportFour(reporteSearch, id, Circular.C2); 
		return new ModelAndView(new ReportExcelView<ReporteCuatroDetalleDTO>(consulta, "Operaciones"));
	}	
	
	
	@GetMapping(path="/generaranexo8c2")
	public ModelAndView excelAnexo8C2(ReporteSearch reporteSearch, String id) {
		TablaDinamica<ReporteCuatroDetalleDTO> consulta = reporteCuatroService.getExcelAnexo8(reporteSearch, id, Circular.C2); 
		return new ModelAndView(new ReportExcelView<ReporteCuatroDetalleDTO>(consulta, "Anexo 8"));
	}	
}
