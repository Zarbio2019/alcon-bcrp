package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MovimientoSaldoDerivados")
public class MovimientoSaldoDerivados extends AbstractEntity{

	private SaldoDerivados saldoDerivados;
	private Calendar fecha;
	private BigDecimal monto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_saldoderivados")
	public SaldoDerivados getSaldoDerivados() {
		return saldoDerivados;
	}
	
	public void setSaldoDerivados(SaldoDerivados saldoDerivados) {
		this.saldoDerivados = saldoDerivados;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	@Column(precision = 20 ,scale = 6)
	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}
	
}
