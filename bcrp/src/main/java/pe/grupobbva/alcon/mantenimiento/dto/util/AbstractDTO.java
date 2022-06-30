package pe.grupobbva.alcon.mantenimiento.dto.util;

import java.util.Calendar;

import pe.grupobbva.alcon.core.beans.Codigoestado;
import pe.grupobbva.alcon.mantenimiento.entity.AbstractEntity;

public abstract class AbstractDTO<T extends AbstractEntity> {

	public AbstractDTO() {
		super();
	}

	public AbstractDTO(T entity) {
		super();
		this.id = entity.getId();
	}

	public AbstractDTO(String id) {
		super();
		this.id = id;
	}

	
	
	
	public AbstractDTO(String id, String creadoPor, String actualizadoPor, Calendar fechaCreacion,
			Calendar fechaModificacion, Integer codigoestado) {
		super();
		this.id = id;
		this.creadoPor = creadoPor;
		this.actualizadoPor = actualizadoPor;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.codigoestado = codigoestado;
	}




	protected String id;

	protected String creadoPor;

	protected String actualizadoPor;

	protected Calendar fechaCreacion;

	protected Calendar fechaModificacion;

	protected Integer codigoestado;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	public String getActualizadoPor() {
		return actualizadoPor;
	}

	public void setActualizadoPor(String actualizadoPor) {
		this.actualizadoPor = actualizadoPor;
	}

	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Calendar getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Calendar fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Integer getCodigoestado() {
		return codigoestado;
	}

	public void setCodigoestado(Integer codigoestado) {
		this.codigoestado = codigoestado;
	}

	public abstract T fromDTO(T entity);

	public void preNuevo() {
		this.codigoestado = Codigoestado.ACTIVO.getCodigoestado();
	}

	public void preactualizar() {
		this.codigoestado = null;
	}

}
