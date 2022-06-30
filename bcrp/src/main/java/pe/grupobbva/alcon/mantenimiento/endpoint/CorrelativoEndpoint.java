package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.CorrelativoDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Correlativo;

@RestController
@RequestMapping("/correlativo")
public class CorrelativoEndpoint extends AbstractRestController<Correlativo, CorrelativoDTO> {
	public CorrelativoEndpoint() {
		super(Correlativo.class, CorrelativoDTO.class);
	}
}
