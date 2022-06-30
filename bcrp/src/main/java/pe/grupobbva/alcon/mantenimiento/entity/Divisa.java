package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "Divisa")
public class Divisa extends AbstractEntity {

	public Divisa(String id) {
		super(id);
	}

	public Divisa() {
		super();
	}

	private String codigo;

	private String descripcion;

	@Size(max = 3)
	@NotNull
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Size(max = 50)
	@NotNull
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
