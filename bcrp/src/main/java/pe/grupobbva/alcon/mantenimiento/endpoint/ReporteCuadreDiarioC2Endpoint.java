package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuadreDiarioC2ExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.service.ReporteCuadreDiarioC2Service;

@RestController
@RequestMapping("/reportecuadrediarioc2")
public class ReporteCuadreDiarioC2Endpoint extends ReportFilter{

	@Autowired
	private ReporteCuadreDiarioC2Service reporteCuadreDiarioC2Service;
	
	@GetMapping(path="/generarexcel")
	public ModelAndView getExcelReport(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCuadreDiarioC2ExcelDTO> consulta = reporteCuadreDiarioC2Service.getExcelReport(reporteSearch); 
		return new ModelAndView(new ReportExcelView<ReporteCuadreDiarioC2ExcelDTO>(consulta, "ReportePClientePorMes","CUADRE DE OPERACIONES STAR VS ALTAMIRA",reporteSearch.getFecha(), 9));
	}
	
}
