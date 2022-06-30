package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.ConfiguracionDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Configuracion;

@RestController
@RequestMapping("/configuracion")
public class ConfiguracionEndpoint extends AbstractRestController<Configuracion, ConfiguracionDTO> {
	public ConfiguracionEndpoint() {
		super(Configuracion.class, ConfiguracionDTO.class);
	}
}
