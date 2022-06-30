package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.beans.Codigoestado;
import pe.grupobbva.alcon.mantenimiento.entity.AbstractEntity;
import pe.grupobbva.alcon.mantenimiento.repository.AbstractRepository;
import pe.grupobbva.alcon.mantenimiento.service.AbstractService;


public class AbstractServiceImpl<T extends AbstractEntity> implements AbstractService<T>{

	@Autowired
	protected AbstractRepository<T> repository;
	
	@Override
	public void guardar(T entity) {
		entity.setCodigoestado(Codigoestado.ACTIVO.getCodigoestado());
		repository.save(entity);	
	}

	@Override
	public T buscarId(String id) {
		Optional<T> optional = repository.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public void actualizar(T entity) {
		repository.save(entity);	
		
	}

	@Override
	public void eliminar(T entity) {
		entity.setCodigoestado(Codigoestado.INACTIVO.getCodigoestado());
		repository.save(entity);	
		
	}	
}
