package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.AnexoOchoDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.AnexoOcho;

@RestController
@RequestMapping("/anexoocho")
public class AnexoOchoEndPoint extends AbstractRestController<AnexoOcho, AnexoOchoDTO>{

	public AnexoOchoEndPoint() {
		super(AnexoOcho.class, AnexoOchoDTO.class);
	}

}
