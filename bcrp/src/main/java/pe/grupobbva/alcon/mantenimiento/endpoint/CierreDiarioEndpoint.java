package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CierreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CierreDiarioSearch;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.CierreDiario;
import pe.grupobbva.alcon.mantenimiento.service.CierreDiarioService;

@RestController
@RequestMapping("/cierrediario")
public class CierreDiarioEndpoint extends AbstractRestController<CierreDiario, CierreDiarioDTO> {
	
	public CierreDiarioEndpoint() {
		super(CierreDiario.class, CierreDiarioDTO.class);
	}
	
	@GetMapping(produces = "application/json" )
	public DatatableDTO<CierreDiarioDTO> search(CierreDiarioSearch cierrediariosearch){
		return  ((CierreDiarioService)service).search(cierrediariosearch);
		
	}
}
