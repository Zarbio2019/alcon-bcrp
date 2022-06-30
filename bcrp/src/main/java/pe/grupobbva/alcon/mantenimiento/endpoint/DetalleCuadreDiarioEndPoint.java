package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.DetalleCuadreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleCuadreDiario;

@RestController
@RequestMapping("/detallecuadrediario")
public class DetalleCuadreDiarioEndPoint extends AbstractRestController<DetalleCuadreDiario,DetalleCuadreDiarioDTO> {
	public DetalleCuadreDiarioEndPoint() {
		super(DetalleCuadreDiario.class,DetalleCuadreDiarioDTO.class);
	}
	
}
