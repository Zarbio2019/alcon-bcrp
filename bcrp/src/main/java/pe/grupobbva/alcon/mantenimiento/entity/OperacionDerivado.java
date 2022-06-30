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
import javax.validation.constraints.Size;

@Entity
@Table(name = "OperacionDerivado")
@SuppressWarnings("serial")
public class OperacionDerivado extends AbstractEntity {
	
	public OperacionDerivado(String id)  {
		super(id);
	}
	
	public OperacionDerivado() {
		super();
	}
	
	private String idCarga;
	
	private Calendar fechareporte;
	
	//dealstar
	@Size(max = 50)
	private String numerooperacion;
	
	@Size(max = 50)
	private String codigodiva;
	
	//Tipo liquidacion del producto
	private Producto producto;
	
	private String tipooperacion;
	
	private Cliente cliente; //codigo contraparte star / nombre de contraparte
	
	@Size(max = 3)
	private String tipocliente;
	
	private String residente;
	
	@Size(max = 2)
	private String paisresidencia;
	
	//Monto nominal equivalente en dólares (CALCULAR)
	@Column(precision = 20 ,scale = 6)
	private BigDecimal importeusd;
	
	private String iddivisa;  //codigo moneda
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal importedivisa; //montonominal
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaefectiva;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechatermino;
	
	private String callput;
	
	private String estilo;
	
	private String tipoproceso;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal strikerate;
	
	@Size(max = 10)
	private String benchmark;
	
	//Tipo subyacente Tabla 5
	@Size(max = 2)
	private String tiposubyacente;
	
	//Descripcion subyacente
	@Size(max = 30)
	private String descripcionsubyacente;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal preciopactado;
	
	//Commodities: Tamaño del contrato en unidades
	@Column(precision = 20 ,scale = 6)
	private BigDecimal commoditytamanocontratounid;
	
	//Commodities: Unidad de medida
	@Size(max = 10)
	private String commoditytamanounidmedida;
	
	@Size(max = 10)
	private String benchmarkfrecuencia;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal volatilidad;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal prima;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal delta;
	
	@Size(max = 1)
	private String intencioncontratacion;
	
	@Size(max = 1)
	private String tipoaccion;
	
	@Size(max = 2000)
	private String observacion;
	
	private Integer idfilaarchivo;
	
	private Calendar fechamovimiento;
	
	@Size(max = 20)
	@Column(unique = true)
	private String correlativo;
	
	private String mensajeerror;
	
	@Size(max = 20)
	private String codigoreporte;
	
	@Size(max = 50)
	public String getIdCarga() {
		return idCarga;
	}

	public void setIdCarga(String idCarga) {
		this.idCarga = idCarga;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFechareporte() {
		return fechareporte;
	}

	public void setFechareporte(Calendar fechareporte) {
		this.fechareporte = fechareporte;
	}

	public String getNumerooperacion() {
		return numerooperacion;
	}

	public void setNumerooperacion(String numerooperacion) {
		this.numerooperacion = numerooperacion;
	}

	public String getCodigodiva() {
		return codigodiva;
	}

	public void setCodigodiva(String codigodiva) {
		this.codigodiva = codigodiva;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public String getTipooperacion() {
		return tipooperacion;
	}

	public void setTipooperacion(String tipooperacion) {
		this.tipooperacion = tipooperacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTipocliente() {
		return tipocliente;
	}

	public void setTipocliente(String tipocliente) {
		this.tipocliente = tipocliente;
	}

	public String getResidente() {
		return residente;
	}

	public String getPaisresidencia() {
		return paisresidencia;
	}

	public void setPaisresidencia(String paisresidencia) {
		this.paisresidencia = paisresidencia;
	}

	public void setResidente(String residente) {
		this.residente = residente;
	}

	public BigDecimal getImporteusd() {
		return importeusd;
	}

	public void setImporteusd(BigDecimal importeusd) {
		this.importeusd = importeusd;
	}

	public String getIddivisa() {
		return iddivisa;
	}

	public void setIddivisa(String iddivisa) {
		this.iddivisa = iddivisa;
	}

	public BigDecimal getImportedivisa() {
		return importedivisa;
	}

	public void setImportedivisa(BigDecimal importedivisa) {
		this.importedivisa = importedivisa;
	}

	public Calendar getFechaefectiva() {
		return fechaefectiva;
	}

	public void setFechaefectiva(Calendar fechaefectiva) {
		this.fechaefectiva = fechaefectiva;
	}

	public Calendar getFechatermino() {
		return fechatermino;
	}

	public void setFechatermino(Calendar fechatermino) {
		this.fechatermino = fechatermino;
	}

	public String getCallput() {
		return callput;
	}

	public void setCallput(String callput) {
		this.callput = callput;
	}

	@Size(max=1)
	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public String getTipoproceso() {
		return tipoproceso;
	}

	public void setTipoproceso(String tipoproceso) {
		this.tipoproceso = tipoproceso;
	}

	public BigDecimal getStrikerate() {
		return strikerate;
	}

	public void setStrikerate(BigDecimal strikerate) {
		this.strikerate = strikerate;
	}

	public String getBenchmark() {
		return benchmark;
	}

	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}

	public String getTiposubyacente() {
		return tiposubyacente;
	}

	public void setTiposubyacente(String tiposubyacente) {
		this.tiposubyacente = tiposubyacente;
	}

	public String getDescripcionsubyacente() {
		return descripcionsubyacente;
	}

	public void setDescripcionsubyacente(String descripcionsubyacente) {
		this.descripcionsubyacente = descripcionsubyacente;
	}

	public BigDecimal getPreciopactado() {
		return preciopactado;
	}

	public void setPreciopactado(BigDecimal preciopactado) {
		this.preciopactado = preciopactado;
	}

	public BigDecimal getCommoditytamanocontratounid() {
		return commoditytamanocontratounid;
	}

	public void setCommoditytamanocontratounid(BigDecimal commoditytamanocontratounid) {
		this.commoditytamanocontratounid = commoditytamanocontratounid;
	}

	public String getCommoditytamanounidmedida() {
		return commoditytamanounidmedida;
	}

	public void setCommoditytamanounidmedida(String commoditytamanounidmedida) {
		this.commoditytamanounidmedida = commoditytamanounidmedida;
	}

	public String getBenchmarkfrecuencia() {
		return benchmarkfrecuencia;
	}

	public void setBenchmarkfrecuencia(String benchmarkfrecuencia) {
		this.benchmarkfrecuencia = benchmarkfrecuencia;
	}

	public BigDecimal getVolatilidad() {
		return volatilidad;
	}

	public void setVolatilidad(BigDecimal volatilidad) {
		this.volatilidad = volatilidad;
	}

	public BigDecimal getPrima() {
		return prima;
	}

	public void setPrima(BigDecimal prima) {
		this.prima = prima;
	}

	public BigDecimal getDelta() {
		return delta;
	}

	public void setDelta(BigDecimal delta) {
		this.delta = delta;
	}

	public String getIntencioncontratacion() {
		return intencioncontratacion;
	}

	public void setIntencioncontratacion(String intencioncontratacion) {
		this.intencioncontratacion = intencioncontratacion;
	}

	public String getTipoaccion() {
		return tipoaccion;
	}

	public void setTipoaccion(String tipoaccion) {
		this.tipoaccion = tipoaccion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Integer getIdfilaarchivo() {
		return idfilaarchivo;
	}

	public void setIdfilaarchivo(Integer idfilaarchivo) {
		this.idfilaarchivo = idfilaarchivo;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFechamovimiento() {
		return fechamovimiento;
	}

	public void setFechamovimiento(Calendar fechamovimiento) {
		this.fechamovimiento = fechamovimiento;
	}

	public String getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(String correlativo) {
		this.correlativo = correlativo;
	}

	public String getMensajeerror() {
		return mensajeerror;
	}

	public void setMensajeerror(String mensajeerror) {
		this.mensajeerror = mensajeerror;
	}

	public String getCodigoreporte() {
		return codigoreporte;
	}

	public void setCodigoreporte(String codigoreporte) {
		this.codigoreporte = codigoreporte;
	}
	
}
