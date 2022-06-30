package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionDerivadoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionOtrosDerivadosDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionDerivado;
import pe.grupobbva.alcon.mantenimiento.service.OperacionDerivadoService;

@RestController
@RequestMapping("/operacionderivado")
public class OperacionDerivadoEndpoint extends AbstractRestController<OperacionDerivado, OperacionDerivadoDTO>{

	public OperacionDerivadoEndpoint() {
		super(OperacionDerivado.class, OperacionDerivadoDTO.class);
	}
	
	@GetMapping(produces = "application/json")
	public DatatableDTO<OperacionOtrosDerivadosDTO> search(OperacionSearch operacionSearch) {
		return ((OperacionDerivadoService) service).search(operacionSearch);
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView generarexcel(OperacionSearch operacionSearch) {
		TablaDinamica<OperacionOtrosDerivadosDTO> consulta = ((OperacionDerivadoService) service).generarexcel(operacionSearch);
		return new ModelAndView(new ReportExcelView<OperacionOtrosDerivadosDTO>(consulta, "otrosderivados"));
	}
}
