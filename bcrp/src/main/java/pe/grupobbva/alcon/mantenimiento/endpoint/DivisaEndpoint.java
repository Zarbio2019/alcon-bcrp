package pe.grupobbva.alcon.mantenimiento.endpoint;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.DivisaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.DivisaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.service.DivisaService;

@RestController
@RequestMapping("/divisa")
public class DivisaEndpoint extends AbstractRestController<Divisa, DivisaDTO> {
	private static final Logger log = LogManager.getLogger();

	public DivisaEndpoint() {
		super(Divisa.class, DivisaDTO.class);
	}
	
	@GetMapping(produces = "application/json" )
	public DatatableDTO<DivisaDTO> search(DivisaSearch divisaSearch){
		return  ((DivisaService)service).search(divisaSearch);
		
	}
	
	@GetMapping("/listar")
	public SelectOptions< SelectOptionsDTO> listOptions(){
		return((DivisaService)service).listOptions();
	}
	
}
