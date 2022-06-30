package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.MovimientoPosicionCambiariaDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.MovimientoPosicionCambiaria;

@RestController
@RequestMapping("/movimientoposicioncambiaria")
public class MovimientoPosicionCambiariaEndpoint extends AbstractRestController<MovimientoPosicionCambiaria, MovimientoPosicionCambiariaDTO> {
	public MovimientoPosicionCambiariaEndpoint() {
		super(MovimientoPosicionCambiaria.class, MovimientoPosicionCambiariaDTO.class);
	}
}
