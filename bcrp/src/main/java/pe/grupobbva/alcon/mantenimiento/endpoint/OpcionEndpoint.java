package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.OpcionDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Opcion;

@RestController
@RequestMapping("/opcion")
public class OpcionEndpoint extends AbstractRestController<Opcion, OpcionDTO> {
	public OpcionEndpoint() {
		super(Opcion.class, OpcionDTO.class);
	}
}
