package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.RutaCarpetaDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.RutaCarpeta;

@RestController
@RequestMapping("/rutacarpeta")
public class RutaCarpetaEndpoint extends AbstractRestController<RutaCarpeta, RutaCarpetaDTO> {
	public RutaCarpetaEndpoint() {
		super(RutaCarpeta.class, RutaCarpetaDTO.class);
	}
	
	
	
	
	
	
}
