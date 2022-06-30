package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRVDTO;

import pe.grupobbva.alcon.mantenimiento.dto.search.CfgPosRVSearch;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.CfgPosRV;
import pe.grupobbva.alcon.mantenimiento.service.CfgPosRVService;

@RestController
@RequestMapping("/cfgposrv")
public class CfgPosRVEndPoint extends AbstractRestController<CfgPosRV, CfgPosRVDTO> {
	public CfgPosRVEndPoint() {
		super(CfgPosRV.class, CfgPosRVDTO.class);
	}
	
	@GetMapping(produces = "application/json")
	public DatatableDTO<CfgPosRVDTO> search(CfgPosRVSearch cfgPosRVSearch){
		return ((CfgPosRVService) service).search(cfgPosRVSearch);
	} 
}
