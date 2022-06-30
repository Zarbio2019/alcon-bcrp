package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "TipoCambioSbs")
@Data
public class TipoCambioSbs extends AbstractEntity {

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	private Calendar fecha;
	
	@Size(max = 3)
	@NotNull
	private String divisa;
	
	@Column(precision = 18 ,scale = 4)
	private BigDecimal tcfix;

}
