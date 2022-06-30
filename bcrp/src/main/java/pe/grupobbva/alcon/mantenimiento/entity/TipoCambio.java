package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import pe.grupobbva.alcon.mantenimiento.dto.process.TipocambioCargaType;

@Entity
@Table(name = "tipo_cambio")
@SuppressWarnings("serial")
public class TipoCambio extends AbstractEntity {
	
	/**
	 * @param registro
	 * @throws ParseException
	 */
	public TipoCambio(TipocambioCargaType registro) throws ParseException {
		this.fecha = registro.getFecha();
		this.importe = registro.getImporte();

	}
	
	public TipoCambio() {
		super();
	}
	
	
	private Divisa divisa;

	private Calendar fecha;
	

	private BigDecimal importe;

	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	@JoinColumn(name = "id_divisa")
	public Divisa getDivisa() {
		return divisa;
	}

	public void setDivisa(Divisa divisa) {
		this.divisa = divisa;
	}

	
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	@Column(precision = 20 ,scale = 7)
	@NotNull
	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}

	
	
	
}
