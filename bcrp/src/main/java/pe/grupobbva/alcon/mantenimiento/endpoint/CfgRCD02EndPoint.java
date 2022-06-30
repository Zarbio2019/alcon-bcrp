package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;

import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD02DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgRCD02Search;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.CfgRCD02;
import pe.grupobbva.alcon.mantenimiento.service.CfgRCD02Service;

@RestController
@RequestMapping("/cfgRCD02")
public class CfgRCD02EndPoint extends AbstractRestController<CfgRCD02, CfgRCD02DTO> {
	public CfgRCD02EndPoint() {
		super(CfgRCD02.class, CfgRCD02DTO.class);
	}
	@GetMapping(produces = "application/json")
	public DatatableDTO<CfgRCD02DTO> search(CfgRCD02Search cfgRCD02Search){
		return ((CfgRCD02Service) service).search(cfgRCD02Search);
	} 
}
