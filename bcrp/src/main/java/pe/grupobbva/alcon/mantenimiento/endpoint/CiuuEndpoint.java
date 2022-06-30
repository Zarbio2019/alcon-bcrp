package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.CiuuDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Ciuu;

@RestController
@RequestMapping("/ciuu")
public class CiuuEndpoint extends AbstractRestController<Ciuu, CiuuDTO> {
	public CiuuEndpoint() {
		super(Ciuu.class, CiuuDTO.class);
	}
}
