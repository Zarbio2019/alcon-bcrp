package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.OperacionesDefinitivo39DTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionesDefinitivo39;

@RestController
@RequestMapping("/operacionesdefinitivo39")
public class OperacionesDefinitivo39Endpoint extends AbstractRestController<OperacionesDefinitivo39, OperacionesDefinitivo39DTO> {
	public OperacionesDefinitivo39Endpoint() {
		super(OperacionesDefinitivo39.class, OperacionesDefinitivo39DTO.class);
	}
}
