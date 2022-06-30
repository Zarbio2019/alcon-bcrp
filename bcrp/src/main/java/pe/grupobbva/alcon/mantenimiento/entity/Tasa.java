package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "Tasa")
@Data
public class Tasa extends AbstractEntity {

	public Tasa() {
		super();
	}

	@Size(max = 50)
	private String curva;

	private String iddivisa;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechavencimiento;

	@Size(max = 50)
	private String par;

	@Column(precision = 10, scale = 4)
	private BigDecimal coordenaday;

	@Column(precision = 10, scale = 4)
	private BigDecimal coordenadax;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechainicio;

	private Integer plazo;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaproceso;

}
