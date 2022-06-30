package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.Operaciones40DTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Operaciones40;

@RestController
@RequestMapping("/operaciones40")
public class Operaciones40Endpoint extends AbstractRestController<Operaciones40, Operaciones40DTO> {
	public Operaciones40Endpoint() {
		super(Operaciones40.class, Operaciones40DTO.class);
	}
}
