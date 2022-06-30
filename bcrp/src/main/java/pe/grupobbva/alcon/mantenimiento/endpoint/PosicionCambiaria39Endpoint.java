package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.PosicionCambiaria39DTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.PosicionCambiaria39;

@RestController
@RequestMapping("/posicioncambiaria39")
public class PosicionCambiaria39Endpoint extends AbstractRestController<PosicionCambiaria39, PosicionCambiaria39DTO> {
	public PosicionCambiaria39Endpoint() {
		super(PosicionCambiaria39.class, PosicionCambiaria39DTO.class);
	}
}
