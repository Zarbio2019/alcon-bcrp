package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.DetalleParametroDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleParametro;

@RestController
@RequestMapping("/detalleparametro")
public class DetalleParametroEndpoint extends AbstractRestController<DetalleParametro,DetalleParametroDTO>{

	public DetalleParametroEndpoint() {
		super(DetalleParametro.class, DetalleParametroDTO.class);
	}
	
}
