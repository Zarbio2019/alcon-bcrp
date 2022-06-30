package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.TasaDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Tasa;

@RestController
@RequestMapping("/tasa")
public class TasaEndpoint extends AbstractRestController<Tasa, TasaDTO> {
	public TasaEndpoint() {
		super(Tasa.class, TasaDTO.class);
	}
}
