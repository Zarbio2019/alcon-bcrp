package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "DiferencialTasas")
@Data
public class DiferencialTasas extends AbstractEntity {
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha;
	
	private Integer plazo;
	
	@Column(precision = 12 ,scale = 2)
	private BigDecimal diferencialcompra;
	
	@Column(precision = 12 ,scale = 2)
	private BigDecimal  diferencialventa;
	
	private Integer codigoestado;

}
