package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CuadreAnexoOchoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.UploadCargaAnexoOchoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.UploadCargaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.CuadreAnexoOchoTableDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.CuadreAnexoOcho;
import pe.grupobbva.alcon.mantenimiento.service.CuadreAnexoOchoService;

@RestController
@RequestMapping("/cuadreanexoocho")
public class CuadreAnexoOchoEndPoint extends AbstractRestController<CuadreAnexoOcho, CuadreAnexoOchoDTO>{

	private static final Logger log = LogManager.getLogger();
	
	public CuadreAnexoOchoEndPoint() {
		super(CuadreAnexoOcho.class, CuadreAnexoOchoDTO.class);
	}

	@GetMapping(produces = "application/json")
	public DatatableDTO<CuadreAnexoOchoTableDTO> search(ReporteSearch reporteSearch){
		return  ((CuadreAnexoOchoService)service).search(reporteSearch);
	}
	
	@PostMapping(path = "/upload", consumes = "multipart/form-data", produces = "application/json")
	public void upload(UploadCargaAnexoOchoDTO uploadCarga) {
		((CuadreAnexoOchoService)service).generar(uploadCarga);
	}
}
