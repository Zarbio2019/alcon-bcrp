package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.PlantillaCalculoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.PlantillaCalculoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.PlantillaCalculoTableDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.PlantillaCalculo;
import pe.grupobbva.alcon.mantenimiento.service.PlantillaCalculoService;

@RestController
@RequestMapping("/plantillacalculo")
public class PlantillaCalculoEndpoint extends AbstractRestController<PlantillaCalculo, PlantillaCalculoDTO> {
	
	public PlantillaCalculoEndpoint() {
		super(PlantillaCalculo.class, PlantillaCalculoDTO.class);
	}
	
	@GetMapping(produces = "application/json" )
	public DatatableDTO<PlantillaCalculoTableDTO> search(PlantillaCalculoSearch plantillaCalculoSearch){
		return  ((PlantillaCalculoService)service).search(plantillaCalculoSearch);
		
	}
	
}
