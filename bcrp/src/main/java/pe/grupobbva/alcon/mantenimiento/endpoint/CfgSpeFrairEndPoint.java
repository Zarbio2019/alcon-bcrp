package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgSpeFrairDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgSpeFrairSearch;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.CfgSpeFrair;
import pe.grupobbva.alcon.mantenimiento.service.CfgSpeFrairService;

@RestController
@RequestMapping("/cfgspefrair")
public class CfgSpeFrairEndPoint extends AbstractRestController<CfgSpeFrair,CfgSpeFrairDTO> {
	public CfgSpeFrairEndPoint() {
		super(CfgSpeFrair.class, CfgSpeFrairDTO.class);
	}
	
	@GetMapping(produces = "application/json")
	public DatatableDTO<CfgSpeFrairDTO> search(CfgSpeFrairSearch search){
		return ((CfgSpeFrairService) service).search(search);
	}
}
