package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name = "CuadreDiario")
@Data
public class CuadreDiario extends AbstractEntity {

	public CuadreDiario(String id) {
		super(id);
	}
	
	public CuadreDiario() {
		super();
	}

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechacuadrediario;
	

	
}
