package pe.grupobbva.alcon.mantenimiento.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CierreDiario")
public class CierreDiario extends AbstractEntity {
	
	public CierreDiario(String id) {
		super(id);
	}
	
	public CierreDiario() {
		super();
	}

	
	private Calendar fecha;
	

	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}


	
	
	
}
