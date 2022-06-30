package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.mantenimiento.dto.DetalleAnexoOchoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.DetalleAnexoOchoExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleAnexoOcho;
import pe.grupobbva.alcon.mantenimiento.service.DetalleAnexoOchoService;
import pe.grupobbva.alcon.mantenimiento.service.OperacionService;

@RestController
@RequestMapping("/detalleanexoocho")
public class DetalleAnexoOchoEndPoint extends AbstractRestController<DetalleAnexoOcho, DetalleAnexoOchoDTO>{

	public DetalleAnexoOchoEndPoint() {
		super(DetalleAnexoOcho.class, DetalleAnexoOchoDTO.class);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView excelDetalleAnexoOcho(String id) {
		
		TablaDinamica<DetalleAnexoOchoExcelDTO> consulta = ((DetalleAnexoOchoService) service).generarexcel(id);
		return new ModelAndView(new ReportExcelView<DetalleAnexoOchoExcelDTO>(consulta, "Observasiones anexo 8"));
	
	}

}
