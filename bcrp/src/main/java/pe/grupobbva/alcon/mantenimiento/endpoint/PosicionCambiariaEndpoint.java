package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.PosicionCambiariaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.PosicionCambiariaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.PosicionCambiariaTableDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.PosicionCambiaria;
import pe.grupobbva.alcon.mantenimiento.service.PosicionCambiariaService;

@RestController
@RequestMapping("/posicioncambiaria")
public class PosicionCambiariaEndpoint extends AbstractRestController<PosicionCambiaria, PosicionCambiariaDTO> {
	public PosicionCambiariaEndpoint() {
		super(PosicionCambiaria.class, PosicionCambiariaDTO.class);
	}
	
	@GetMapping(produces="application/json")
	public DatatableDTO<PosicionCambiariaTableDTO> search(PosicionCambiariaSearch posicionCambiariaSearch){
		return ((PosicionCambiariaService)service).search(posicionCambiariaSearch);
	}
}
