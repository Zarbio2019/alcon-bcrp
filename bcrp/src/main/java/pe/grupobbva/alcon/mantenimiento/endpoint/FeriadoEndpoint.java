package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.FeriadoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.custom.FeriadoCopia;
import pe.grupobbva.alcon.mantenimiento.dto.search.FeriadoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.FeriadoTableDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Feriado;
import pe.grupobbva.alcon.mantenimiento.service.FeriadoService;

@RestController
@RequestMapping("/feriado")
public class FeriadoEndpoint extends AbstractRestController<Feriado, FeriadoDTO> {
	
	public FeriadoEndpoint() {
		super(Feriado.class, FeriadoDTO.class);
	}
	
	@GetMapping(produces="application/json")
	public DatatableDTO<FeriadoTableDTO> search(FeriadoSearch feriadoSearch){
		return ((FeriadoService)service).search(feriadoSearch);
	}
	
	@GetMapping("/copiar")
	public void copiarFeriado(FeriadoCopia feriadoCopia) {
		((FeriadoService) service).copiarFeriado(feriadoCopia);
		
	}
	
}
