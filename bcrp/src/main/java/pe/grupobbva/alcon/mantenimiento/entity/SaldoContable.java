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

import pe.grupobbva.alcon.mantenimiento.dto.process.SaldoContableCargaType;

@Entity
@Table(name = "SaldoContable")
@SuppressWarnings("serial")
public class SaldoContable extends AbstractEntity {
	
	/**
	 * @param registro
	 * @throws ParseException
	 */
	public SaldoContable(SaldoContableCargaType registro) throws ParseException {
		
		Divisa div = new Divisa();
		div.setCodigo(registro.getCodigoDivisa());
		
		Oficina ofi = new Oficina();
		ofi.setCodigo(registro.getCodigoOficina());
		
		this.divisa = div;
		this.oficina = ofi;
		this.fecha = registro.getFecha();
		this.importe = registro.getImporte();

	}
	
	public SaldoContable() {
		super();
	}
	

	private Divisa divisa;

	private Oficina oficina;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal importe;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_divisa")
	public Divisa getDivisa() {
		return divisa;
	}

	public void setDivisa(Divisa divisa) {
		this.divisa = divisa;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_oficina")
	public Oficina getOficina() {
		return oficina;
	}

	public void setOficina(Oficina oficina) {
		this.oficina = oficina;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	
	
	
}
