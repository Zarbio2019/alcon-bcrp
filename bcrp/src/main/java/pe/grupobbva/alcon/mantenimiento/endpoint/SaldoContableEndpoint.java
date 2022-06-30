package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.SaldoContableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.SaldoContableSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.SaldoContableTableDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.SaldoContable;
import pe.grupobbva.alcon.mantenimiento.service.SaldoContableService;

@RestController
@RequestMapping("/saldocontable")
public class SaldoContableEndpoint extends AbstractRestController<SaldoContable, SaldoContableDTO> {
	
	public SaldoContableEndpoint() {
		super(SaldoContable.class, SaldoContableDTO.class);
	}
	
	@GetMapping(produces="application/json")
	public DatatableDTO<SaldoContableTableDTO> search(SaldoContableSearch saldoContableSearch){
		return ((SaldoContableService)service).search(saldoContableSearch);
		
	}
}
