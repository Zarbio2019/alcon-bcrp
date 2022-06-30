package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuadreDiarioExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.service.ReporteCuadreDiarioService;

@RestController
@RequestMapping("/reportecuadrediario")
public class ReporteCuadreDiarioEndpoint extends ReportFilter{
	@Autowired
	private ReporteCuadreDiarioService reporteCuadreDiarioService;
	
	@GetMapping(path="/generarexcel")
	public ModelAndView getExcelReport(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCuadreDiarioExcelDTO> consulta = reporteCuadreDiarioService.getExcelReport(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteCuadreDiarioExcelDTO>(consulta, "ReportePClientePorMes","CUADRE DE OPERACIONES STAR VS ALTAMIRA",reporteSearch.getFecha(), 9));
	}
	
}
