package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.io.IOException;
import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.UploadCargaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CargaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.CargaTableDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.service.CargaService;
import pe.grupobbva.alcon.mantenimiento.util.CargaThreadUtil;
import pe.grupobbva.alcon.mantenimiento.util.ReprocesarThreadUtil;

@RestController
@RequestMapping("/carga")
public class CargaEndpoint extends ReportFilter{

	private static final Logger log = LogManager.getLogger();

	@Autowired
	private CargaService cargaService;
	
	@Autowired
	private CargaThreadUtil cargaThreadUtil;
	
	@Autowired
	private ReprocesarThreadUtil reprocesarThreadUtil;
	
	
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;

	
	@PostMapping(path = "upload", consumes = "multipart/form-data", produces = "application/json")
	public ResponseEntity<Void> upload(UploadCargaDTO uploadCarga, Integer opcionTipoCarga) {
		
		log.info("post :" + uploadCarga);
		Carga carga = null;

		uploadCarga.preNuevo();
		cargaService.cargarDatosAdicionales(uploadCarga);
		carga = uploadCarga.fromDTO(carga);
		
		ValidatorUtil.validateEntity(carga);
		
			cargaService.guardar(carga);
			
			try {
				cargaThreadUtil.load(opcionTipoCarga, uploadCarga.getFile().getInputStream(), uploadCarga.getFile().getOriginalFilename(), carga.getId());
				taskExecutor.execute(cargaThreadUtil);
			} catch (IOException e) {
				log.error("failed!",e);
			}
		
	

		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(carga.getId())
				.toUri();

		return ResponseEntity.status(HttpStatus.CREATED)
				.header(HttpHeaders.LOCATION, location.toString())
				.build();
	}
	
	@GetMapping(produces = "application/json")
	public DatatableDTO<CargaTableDTO> search(CargaSearch search){
		return  cargaService.search(search);
		
	}
	
	@PostMapping(path = "reprocesar/{idcarga}", produces = "application/json")
	public void reprocesar(@PathVariable String idcarga) {
		
		
			reprocesarThreadUtil.load(idcarga);
			taskExecutor.execute(reprocesarThreadUtil);
		
	}
	
	@PostMapping(path = "eliminar/{idcarga}", produces = "application/json")
	public void eliminar(@PathVariable String idcarga) {
		cargaService.eliminar(idcarga);
		
	}

}
