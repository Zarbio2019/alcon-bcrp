package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ClienteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.ClienteTableDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;
import pe.grupobbva.alcon.mantenimiento.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteEndpoint extends AbstractRestController<Cliente, ClienteTableDTO> {
	
	public ClienteEndpoint() {
		super(Cliente.class, ClienteTableDTO.class);
	}

	@GetMapping(produces = "application/json")
	public DatatableDTO<ClienteTableDTO> search(ClienteSearch clienteSearch){
		return  ((ClienteService)service).search(clienteSearch);
		
	}
	
	@GetMapping(path = "/procesar", produces = "application/json")
	public void procesarClientesInforeport() {
		((ClienteService) service).procesarClientesInforeport();
	}
	
}
