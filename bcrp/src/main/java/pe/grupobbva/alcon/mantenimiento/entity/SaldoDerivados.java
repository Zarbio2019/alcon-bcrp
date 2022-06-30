package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "SaldoDerivados")
public class SaldoDerivados extends AbstractEntity {

	public SaldoDerivados(String id) {
		super(id);
	}
	
	public SaldoDerivados() {
		super();
	}
	
	@Size(max = 4)
	private String codigooperacion;
	
	@Size(max = 100)
	private String descripcion;

	public String getCodigooperacion() {
		return codigooperacion;
	}

	public void setCodigooperacion(String codigooperacion) {
		this.codigooperacion = codigooperacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
