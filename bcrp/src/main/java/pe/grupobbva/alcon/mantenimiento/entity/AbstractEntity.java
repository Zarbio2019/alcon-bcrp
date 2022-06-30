package pe.grupobbva.alcon.mantenimiento.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AbstractEntity implements Serializable {

	protected String id;

	protected String creadoPor;

	protected String actualizadoPor;

	protected Calendar fechaCreacion;

	protected Calendar fechaModificacion;

	protected Integer codigoestado;

	public AbstractEntity(String id) {
		super();
		this.id = id;
	}

	public AbstractEntity() {
		super();

	}

	/**
	 * @return the id
	 */
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Calendar fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Calendar fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	@CreatedBy
	public String getCreadoPor() {
		return creadoPor;
	}

	public void setCreadoPor(String creadoPor) {
		this.creadoPor = creadoPor;
	}

	@LastModifiedBy
	public String getActualizadoPor() {
		return actualizadoPor;
	}

	public void setActualizadoPor(String actualizadoPor) {
		this.actualizadoPor = actualizadoPor;
	}

	public Integer getCodigoestado() {
		return codigoestado;
	}

	public void setCodigoestado(Integer codigoestado) {
		this.codigoestado = codigoestado;
	}

}
