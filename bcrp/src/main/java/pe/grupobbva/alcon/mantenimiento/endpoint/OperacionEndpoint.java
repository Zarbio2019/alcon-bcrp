package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacionTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.entity.Operacion;
import pe.grupobbva.alcon.mantenimiento.service.OperacionService;

@RestController
@RequestMapping("/operacion")
public class OperacionEndpoint extends AbstractRestController<Operacion, OperacionDTO> {

	public OperacionEndpoint() {
		super(Operacion.class, OperacionDTO.class);
	}

	@GetMapping(produces = "application/json")
	public DatatableDTO<OperacionTableDTO> search(OperacionSearch operacionSearch) {
		return ((OperacionService) service).search(operacionSearch);
	}
	
	@GetMapping("/unwind")
	public void unwindOperacion(OperacionSearch operacionSearch) {
		((OperacionService) service).unwindOperacion(operacionSearch);
		
	}
	
	@GetMapping("/anular")
	public void anularOperacion(OperacionSearch operacionSearch) {
		((OperacionService) service).anularOperacion(operacionSearch);
		
	}
	
	@GetMapping(path="/generarexcel")
	public ModelAndView generarexcel(OperacionSearch operacionSearch) {
		TablaDinamica<OperacionTableDTO> consulta = ((OperacionService) service).generarexcel(operacionSearch);
		return new ModelAndView(new ReportExcelView<OperacionTableDTO>(consulta, "operaciones"));
	}
	
	@GetMapping(path = "/vistaprevia")
	public DatatableDTO<OperacionTableDTO> vistaPrevia(OperacionSearch operacionSearch){
		return  ((OperacionService)service).feriadoListarOperaciones(operacionSearch);
		
	}
	
	@PostMapping(path = "/procesar/{idferiado}", produces = "application/json")
	public void procesarOperacionFeriado(@PathVariable String idferiado) {
		((OperacionService) service).procesarOperacionFeriado(idferiado);
		
	}
	
}
