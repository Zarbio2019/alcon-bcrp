package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.mantenimiento.entity.AbstractEntity;

public interface AbstractService<T extends AbstractEntity> {

	public void guardar(T entity);
	
	public T buscarId(String id);

	public void actualizar(T entity);
	
	public void eliminar(T entity);
}
