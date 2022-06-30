package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.PosicionCambiaria1DTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.PosicionCambiaria1;

@RestController
@RequestMapping("/posicioncambiaria1")
public class PosicionCambiaria1Endpoint extends AbstractRestController<PosicionCambiaria1, PosicionCambiaria1DTO> {
	public PosicionCambiaria1Endpoint() {
		super(PosicionCambiaria1.class, PosicionCambiaria1DTO.class);
	}
}
