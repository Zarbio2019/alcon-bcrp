package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgFxVigenteDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgFxVigenteSearch;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.CfgFxVigente;
import pe.grupobbva.alcon.mantenimiento.service.CfgFxVigenteService;

@RestController
@RequestMapping("/cfgfxvigente")
public class CfgFxVigenteEndpoint extends AbstractRestController<CfgFxVigente, CfgFxVigenteDTO>{
	
	public CfgFxVigenteEndpoint() {
		super(CfgFxVigente.class, CfgFxVigenteDTO.class);
	}
	
	
	@GetMapping(produces = "application/json")
	public DatatableDTO<CfgFxVigenteDTO> search(CfgFxVigenteSearch cfgFxVigenteSearch){
		return ((CfgFxVigenteService)service).search(cfgFxVigenteSearch);
	} 
}
