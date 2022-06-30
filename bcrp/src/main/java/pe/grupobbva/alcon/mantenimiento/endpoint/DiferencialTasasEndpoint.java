package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.DiferencialTasasDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.DiferencialTasas;

@RestController
@RequestMapping("/diferencialtasas")
public class DiferencialTasasEndpoint extends AbstractRestController<DiferencialTasas, DiferencialTasasDTO> {
	public DiferencialTasasEndpoint() {
		super(DiferencialTasas.class, DiferencialTasasDTO.class);
	}
}
