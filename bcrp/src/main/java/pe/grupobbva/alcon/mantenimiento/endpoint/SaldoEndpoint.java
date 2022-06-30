package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.SaldoDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Saldo;

@RestController
@RequestMapping("/saldo")
public class SaldoEndpoint extends AbstractRestController<Saldo, SaldoDTO> {
	public SaldoEndpoint() {
		super(Saldo.class, SaldoDTO.class);
	}
}
