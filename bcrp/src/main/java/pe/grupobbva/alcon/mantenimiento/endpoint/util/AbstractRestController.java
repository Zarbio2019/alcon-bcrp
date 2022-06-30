package pe.grupobbva.alcon.mantenimiento.endpoint.util;

import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.grupobbva.alcon.core.beans.Codigoestado;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.AbstractEntity;
import pe.grupobbva.alcon.mantenimiento.service.AbstractService;

public class AbstractRestController<T extends AbstractEntity, K extends AbstractDTO<T>> {
	

	
	private Class<K> dtoClazz;
	private Class<T> entityClazz;
	
	public AbstractRestController(Class<T> entityClazz, Class<K> dtoClazz) {
		super();
		this.entityClazz = entityClazz;
		this.dtoClazz = dtoClazz;
	}
	
	@Autowired
	protected AbstractService<T> service;
	
	private static final Logger log = LogManager.getLogger();

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<Void> create (@RequestBody K dto) {
		log.info("post :" + dto);
		T entity=null;
		
		dto.preNuevo();
		entity = dto.fromDTO(entity);
		ValidatorUtil.validateEntity(entity);
		service.guardar(entity);
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.header(HttpHeaders.LOCATION, location.toString()).build();
	}
	
	@PutMapping(path = "/{id}",consumes = "application/json",produces = "application/json" )
	public ResponseEntity<Void> update(@RequestBody K dto, @PathVariable String id) {
		log.info("update : " + id + " - " + dto);
		T entity = service.buscarId(id);
		log.info("entity: "+entity);
		if(entity == null || entity.getCodigoestado().equals(Codigoestado.INACTIVO.getCodigoestado())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		dto.preactualizar();
		entity = dto.fromDTO(entity);
		ValidatorUtil.validateEntity(entity);
		service.actualizar(entity);
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
		
		return ResponseEntity.status(HttpStatus.OK)
				.header(HttpHeaders.LOCATION, location.toString()).build();
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> delete( @PathVariable String id) {
		log.info("delete : " + id);
		T entity = service.buscarId(id);
		
		if(entity == null || entity.getCodigoestado().equals(Codigoestado.INACTIVO.getCodigoestado())) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		ValidatorUtil.validateEntity(entity);
		service.eliminar(entity);
		
		URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
		
		return ResponseEntity.status(HttpStatus.OK)
				.header(HttpHeaders.LOCATION, location.toString()).build();
	}
	
	@GetMapping(path = "/{id}", produces = "application/json")
	public ResponseEntity<K> get(@PathVariable String id) {
		
		T entity = service.buscarId(id);
		
		if(entity == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		K dto = null;
		try {
			dto = dtoClazz.getDeclaredConstructor(entityClazz).newInstance(entity);
		} catch (Exception e) {
			log.error("failed!",e);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(dto);	
		
	}
	
}
