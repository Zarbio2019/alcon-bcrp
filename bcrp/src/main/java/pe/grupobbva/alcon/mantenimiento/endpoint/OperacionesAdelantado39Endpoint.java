package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.OperacionesAdelantado39DTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionesAdelantado39;

@RestController
@RequestMapping("/operacionesadelantado39")
public class OperacionesAdelantado39Endpoint extends AbstractRestController<OperacionesAdelantado39, OperacionesAdelantado39DTO> {
	public OperacionesAdelantado39Endpoint() {
		super(OperacionesAdelantado39.class, OperacionesAdelantado39DTO.class);
	}
}
