package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.DeltaDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Delta;

@RestController
@RequestMapping("/delta")
public class DeltaEndpoint extends AbstractRestController<Delta, DeltaDTO> {
	public DeltaEndpoint() {
		super(Delta.class, DeltaDTO.class);
	}
}
