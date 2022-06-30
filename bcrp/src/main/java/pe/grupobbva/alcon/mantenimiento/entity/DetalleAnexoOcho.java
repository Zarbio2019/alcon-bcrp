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
@Table(name = "DetalleAnexoOcho")
public class DetalleAnexoOcho extends AbstractEntity{

	/*Todos los productos*/
	private static final long serialVersionUID = 1L;
	
	private CuadreAnexoOcho cuadreAnexoOcho;
	private String fuente;
	private String producto;
	private String numerooperacion;
	private String codigooperacion;
	private BigDecimal montoposicioncambiaria;
	private BigDecimal montoanexo;
	private BigDecimal diferencia;
	private String tipooperacion;
	private String monedaentrega;
	private String monedarecibe;
	private Calendar fechainicio;
	private Calendar fechavencimiento;
	private String cliente;
	private String residente;
	private String pais;
	private String financiero;

	/* Solo IRS */
	private String tipotasainteresrecibe;
	private String tipotasainteresentrega;
	private String moneda;
	private BigDecimal tasainteresrecibe;
	private BigDecimal tasainteresentrega; 
	
	private String observacion;

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuadreanexoocho")
	public CuadreAnexoOcho getCuadreAnexoOcho() {
		return cuadreAnexoOcho;
	}

	public void setCuadreAnexoOcho(CuadreAnexoOcho cuadreAnexoOcho) {
		this.cuadreAnexoOcho = cuadreAnexoOcho;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getTipooperacion() {
		return tipooperacion;
	}

	public void setTipooperacion(String tipooperacion) {
		this.tipooperacion = tipooperacion;
	}

	
	public String getMonedaentrega() {
		return monedaentrega;
	}

	public void setMonedaentrega(String monedaentrega) {
		this.monedaentrega = monedaentrega;
	}

	public String getMonedarecibe() {
		return monedarecibe;
	}

	public void setMonedarecibe(String monedarecibe) {
		this.monedarecibe = monedarecibe;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Calendar fechainicio) {
		this.fechainicio = fechainicio;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(Calendar fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getResidente() {
		return residente;
	}

	public void setResidente(String residente) {
		this.residente = residente;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getFinanciero() {
		return financiero;
	}

	public void setFinanciero(String financiero) {
		this.financiero = financiero;
	}

	public String getTipotasainteresrecibe() {
		return tipotasainteresrecibe;
	}

	public void setTipotasainteresrecibe(String tipotasainsteresrecibe) {
		this.tipotasainteresrecibe = tipotasainsteresrecibe;
	}

	public String getTipotasainteresentrega() {
		return tipotasainteresentrega;
	}

	public void setTipotasainteresentrega(String tipotasainteresentrega) {
		this.tipotasainteresentrega = tipotasainteresentrega;
	}

	public String getMoneda() {
		return moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	@Column(precision = 20, scale =6)
	public BigDecimal getTasainteresrecibe() {
		return tasainteresrecibe;
	}

	public void setTasainteresrecibe(BigDecimal tasainteresrecibe) {
		this.tasainteresrecibe = tasainteresrecibe;
	}

	@Column(precision = 20, scale =6)
	public BigDecimal getTasainteresentrega() {
		return tasainteresentrega;
	}

	public void setTasainteresentrega(BigDecimal tasainteresentrega) {
		this.tasainteresentrega = tasainteresentrega;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	
	public String getNumerooperacion() {
		return numerooperacion;
	}

	public void setNumerooperacion(String numerooperacion) {
		this.numerooperacion = numerooperacion;
	}
	
	public String getCodigooperacion() {
		return codigooperacion;
	}

	public void setCodigooperacion(String codigooperacion) {
		this.codigooperacion = codigooperacion;
	}

	
	@Column(precision = 20, scale =6)
	public BigDecimal getMontoposicioncambiaria() {
		return montoposicioncambiaria;
	}

	public void setMontoposicioncambiaria(BigDecimal montoposicioncambiaria) {
		this.montoposicioncambiaria = montoposicioncambiaria;
	}

	@Column(precision = 20, scale =6)
	public BigDecimal getMontoanexo() {
		return montoanexo;
	}

	public void setMontoanexo(BigDecimal montoanexo) {
		this.montoanexo = montoanexo;
	}
	
	@Column(precision = 20, scale =6)
	public BigDecimal getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(BigDecimal diferencia) {
		this.diferencia = diferencia;
	}
	
	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}
}
