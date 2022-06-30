package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "OperacionesAdelantado39")
public class OperacionesAdelantado39 extends AbstractEntity {
	
//	private Integer id;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal importeusd;
	
	@Size(max = 2)
	private String codigobcr;
	
	
	private TipoOperacion tipooperacion;
	
	@Size(max = 30)
	private String tipoCliente;
	
	
	private Residente residente;
	
	
	private TipoEntrega tipoentrega;
	

	private CallPut callput;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechacontratacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechavencimiento;
	
	private Integer iddivisaentrada;
	
	@Size(max = 20)
	private String numerooperacion;
	
	
	private Estado estado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechamovimiento;

	public BigDecimal getImporteusd() {
		return importeusd;
	}

	public void setImporteusd(BigDecimal importeusd) {
		this.importeusd = importeusd;
	}

	public String getCodigobcr() {
		return codigobcr;
	}

	public void setCodigobcr(String codigobcr) {
		this.codigobcr = codigobcr;
	}
	

	@Enumerated(EnumType.STRING)
	public TipoOperacion getTipooperacion() {
		return tipooperacion;
	}

	public void setTipooperacion(TipoOperacion tipooperacion) {
		this.tipooperacion = tipooperacion;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Enumerated(EnumType.STRING)
	public Residente getResidente() {
		return residente;
	}

	public void setResidente(Residente residente) {
		this.residente = residente;
	}

	@Enumerated(EnumType.STRING)
	public TipoEntrega getTipoentrega() {
		return tipoentrega;
	}

	public void setTipoentrega(TipoEntrega tipoentrega) {
		this.tipoentrega = tipoentrega;
	}

	@Enumerated(EnumType.STRING)
	public CallPut getCallput() {
		return callput;
	}

	public void setCallput(CallPut callput) {
		this.callput = callput;
	}

	public Calendar getFechacontratacion() {
		return fechacontratacion;
	}

	public void setFechacontratacion(Calendar fechacontratacion) {
		this.fechacontratacion = fechacontratacion;
	}

	public Calendar getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(Calendar fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	public Integer getIddivisaentrada() {
		return iddivisaentrada;
	}

	public void setIddivisaentrada(Integer iddivisaentrada) {
		this.iddivisaentrada = iddivisaentrada;
	}

	public String getNumerooperacion() {
		return numerooperacion;
	}

	public void setNumerooperacion(String numerooperacion) {
		this.numerooperacion = numerooperacion;
	}

	@Enumerated(EnumType.STRING)
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Calendar getFechamovimiento() {
		return fechamovimiento;
	}

	public void setFechamovimiento(Calendar fechamovimiento) {
		this.fechamovimiento = fechamovimiento;
	}
	
	
	
}
