package pe.grupobbva.alcon.mantenimiento.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Feriado")
public class Feriado extends AbstractEntity {
	
	public Feriado(String id) {
		super(id);
	}
	
	public Feriado() {
		super();
	}


	private String tipo;
	

	private Calendar fecha;
	
	@Size(max = 1)
	private String operacion;

	@NotNull
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	
	
	

}
