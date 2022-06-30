package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.Operaciones41DTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Operaciones41;

@RestController
@RequestMapping("/operaciones41")
public class Operaciones41Endpoint extends AbstractRestController<Operaciones41, Operaciones41DTO> {
	public Operaciones41Endpoint() {
		super(Operaciones41.class, Operaciones41DTO.class);
	}
}
