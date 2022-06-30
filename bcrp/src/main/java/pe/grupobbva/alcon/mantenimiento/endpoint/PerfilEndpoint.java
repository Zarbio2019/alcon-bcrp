package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.PerfilDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Perfil;

@RestController
@RequestMapping("/perfil")
public class PerfilEndpoint extends AbstractRestController<Perfil, PerfilDTO> {
	public PerfilEndpoint() {
		super(Perfil.class, PerfilDTO.class);
	}
}
