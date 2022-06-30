package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.TipoCambioSbsDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCambioSbs;

@RestController
@RequestMapping("/tipocambiosbs")
public class TipoCambioSbsEndpoint extends AbstractRestController<TipoCambioSbs, TipoCambioSbsDTO> {
	public TipoCambioSbsEndpoint() {
		super(TipoCambioSbs.class, TipoCambioSbsDTO.class);
	}
}
