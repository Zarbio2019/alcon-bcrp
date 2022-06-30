package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacioncargaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacioncargaTableDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Operacioncarga;
import pe.grupobbva.alcon.mantenimiento.service.OperacionCargaService;

@RestController
@RequestMapping("/operacioncarga")
public class OperacioncargaEndpoint extends AbstractRestController<Operacioncarga, OperacioncargaTableDTO> {

	public OperacioncargaEndpoint() {
		super(Operacioncarga.class, OperacioncargaTableDTO.class);
	}

	@GetMapping(produces = "application/json")
	public DatatableDTO<OperacioncargaTableDTO> listarErrores(OperacioncargaSearch operacioncargaSearch){
		return  ((OperacionCargaService)service).listarErrores(operacioncargaSearch);
		
	}
	
}
