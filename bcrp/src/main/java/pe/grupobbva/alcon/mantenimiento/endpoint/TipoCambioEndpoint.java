package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.TipoCambioSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.TipoCambioTableDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCambio;
import pe.grupobbva.alcon.mantenimiento.service.TipoCambioService;

@RestController
@RequestMapping("/tipocambio")
public class TipoCambioEndpoint extends AbstractRestController<TipoCambio, TipoCambioTableDTO> {
	
	public TipoCambioEndpoint() {
		super(TipoCambio.class, TipoCambioTableDTO.class);
	}
	
	@GetMapping(produces = "application/json" )
	public DatatableDTO<TipoCambioTableDTO> search(TipoCambioSearch tipoCambioSearch){
		return  ((TipoCambioService)service).search(tipoCambioSearch);
		
	}
	
}
