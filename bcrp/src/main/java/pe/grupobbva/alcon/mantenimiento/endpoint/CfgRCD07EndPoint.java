package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD07DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgRCD07Search;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;

import pe.grupobbva.alcon.mantenimiento.entity.CfgRCD07;
import pe.grupobbva.alcon.mantenimiento.service.CfgRCD07Service;

@RestController
@RequestMapping("/cfgRCD07")
public class CfgRCD07EndPoint extends AbstractRestController<CfgRCD07, CfgRCD07DTO> {
	public CfgRCD07EndPoint() {
		super(CfgRCD07.class, CfgRCD07DTO.class);
	}
	@GetMapping(produces = "application/json")
	public DatatableDTO<CfgRCD07DTO> search(CfgRCD07Search cfgRCD07Search){
		return ((CfgRCD07Service) service).search(cfgRCD07Search);
	} 
}
