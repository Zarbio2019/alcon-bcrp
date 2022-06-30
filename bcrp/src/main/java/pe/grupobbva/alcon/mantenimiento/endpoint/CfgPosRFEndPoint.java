package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRFDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgPosRFSearch;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.CfgPosRF;
import pe.grupobbva.alcon.mantenimiento.service.CfgPosRFService;


@RestController
@RequestMapping("/cfgposrf")
public class CfgPosRFEndPoint extends AbstractRestController<CfgPosRF, CfgPosRFDTO> {
	public CfgPosRFEndPoint() {
		super(CfgPosRF.class, CfgPosRFDTO.class);
	}
	@GetMapping(produces = "application/json")
	public DatatableDTO<CfgPosRFDTO> search(CfgPosRFSearch cfgPosRFSearch){
		return ((CfgPosRFService) service).search(cfgPosRFSearch);
	} 
}
