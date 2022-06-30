package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionInternaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.custom.OperacionCalculate;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.OperacionCalculateResponse;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionInternaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacionInternaTableDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionInterna;
import pe.grupobbva.alcon.mantenimiento.service.OperacionInternaService;

@RestController
@RequestMapping("/operacioninterna")
public class OperacionInternaEndpoint extends AbstractRestController<OperacionInterna, OperacionInternaDTO> {

	public OperacionInternaEndpoint() {
		super(OperacionInterna.class, OperacionInternaDTO.class);
	}

	@GetMapping(produces = "application/json")
	public DatatableDTO<OperacionInternaTableDTO> search(OperacionInternaSearch operacionSearch) {
		return ((OperacionInternaService) service).search(operacionSearch);
	}

	@GetMapping("/calcular")
	public OperacionCalculateResponse calculate( OperacionCalculate calculate) {
		return ((OperacionInternaService) service).calculate(calculate);
		
	}

}