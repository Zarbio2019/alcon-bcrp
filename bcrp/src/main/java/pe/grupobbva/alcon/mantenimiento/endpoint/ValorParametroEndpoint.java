package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.ValorParametroDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.ValorParametro;

@RestController
@RequestMapping("/valorparametro")
public class ValorParametroEndpoint extends AbstractRestController<ValorParametro,ValorParametroDTO>{

	public ValorParametroEndpoint() {
		super(ValorParametro.class, ValorParametroDTO.class);
	}

}
