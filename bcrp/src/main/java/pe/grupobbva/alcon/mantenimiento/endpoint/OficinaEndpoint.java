package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.OficinaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OficinaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OficinaTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Oficina;
import pe.grupobbva.alcon.mantenimiento.service.OficinaService;

@RestController
@RequestMapping("/oficina")
public class OficinaEndpoint extends AbstractRestController<Oficina, OficinaDTO> {
	
	public OficinaEndpoint() {
		super(Oficina.class, OficinaDTO.class);
	}
	
	@GetMapping(produces = "application/json" )
	public DatatableDTO<OficinaTableDTO> search(OficinaSearch oficinaSearch){
		return  ((OficinaService)service).search(oficinaSearch);
	}
	
	@GetMapping("/listar")
	public SelectOptions< SelectOptionsDTO> listOptions(){
		return((OficinaService)service).listOptions();
	}
}
