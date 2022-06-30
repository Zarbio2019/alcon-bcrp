package pe.grupobbva.alcon.mantenimiento.endpoint;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.CuadreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.DetalleCuadreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CuadreDiarioSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.DetallePlantillaCalculoTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.PersonalizeDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.CuadreDiario;
import pe.grupobbva.alcon.mantenimiento.service.CuadreDiarioService;

@RestController
@RequestMapping("/cuadrediario")
public class CuadreDiarioEndpoint extends AbstractRestController<CuadreDiario, CuadreDiarioDTO> {
	
	public CuadreDiarioEndpoint() {
		super(CuadreDiario.class, CuadreDiarioDTO.class);
	}
	
	private static final Logger log = LogManager.getLogger();
	
	@GetMapping(produces = "application/json" )
	public PersonalizeDTO<CuadreDiarioDTO, DetallePlantillaCalculoTableDTO> search(CuadreDiarioSearch cuadreDiarioSearch){
		return  ((CuadreDiarioService)service).search(cuadreDiarioSearch);
	}
	
	@PostMapping(path="/save", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Void> create (@RequestBody PersonalizeDTO<CuadreDiarioDTO, DetalleCuadreDiarioDTO> data){
		return ((CuadreDiarioService)service).create(data);
	}
	
	@PutMapping(path="/update", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Void> update (@RequestBody PersonalizeDTO<CuadreDiarioDTO, DetalleCuadreDiarioDTO> data){
		return ((CuadreDiarioService)service).update(data);
	}
	


}
