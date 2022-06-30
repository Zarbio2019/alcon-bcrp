package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

// Tabla para derivados de tasas circular C0002


@MappedSuperclass
public class DerivadoTasa extends AbstractEntity {
	
	public DerivadoTasa(String id) {
		super(id);
	}
	
	public DerivadoTasa() {
		super();
	}
	
	private String idCarga;
	
	private Calendar fechacontratacion;
	
	@Size(max = 50)
	private String numerooperacion;
	
	private Cliente cliente;
	
	private String tipooperacion;
	
	private String iddivisaentrada;
	
	private String iddivisasalida;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal importedivisaentrada;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal importedivisasalida;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal cotizacion;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal puntosswap;
	
	@Size(max = 10)
	private String basica;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal cambioref;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechavalor;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechavencimiento;
	
	private Integer plazo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaejercicio;

	private String callput;
	
	@Size(max = 30)
	private String plaza;
	
	@Size(max = 2)
	private String paisresidencia;
	
	@Size(max = 2)
	private String riesgopais;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal prima;
	
	private String iddivisaprima;
	
	@Size(max = 2000)
	private String observaciones;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaalta;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechamodificacioncarga;
	
	@Size(max = 20)
	private String operacionsustituye;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechabaja;
	
	@Size(max = 20)
	private String nif;
	
	@Size(max = 20)
	private String intermediario;
	
	@Size(max = 200)
	private String intermediariodescripcion;

	private String estado;
	
	@Size(max = 10)
	private String contrato;

	private String residente;
	
	
	private String estilo;
	

	private String tipoopcion;

	private String tipoproceso;
	
	private Integer historico;

	private Calendar fechamovimiento;
	
	@Size(max = 10)
	private String usuariocarga;
	
	@Size(max = 2)
	private String codigooperacion;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal importeusd;
	
	@Size(max = 20)
	private String codigoreporte;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal tasamonedanacional;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal montomonedaextranjera;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal tasadiferencial;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal delta;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal tasamonedaextranjera;
	
	private String idmonedaextranjera;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal montopen;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal tipocambiospot;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal tipocambiopactado;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal tipocambiovencimiento;
	
	@Size(max = 200)
	private String validacion;
	
	@Size(max = 20)
	private String codigoagrupacion;
	
	@Size(max = 30)
	private String tipocliente;

	private Integer idfilaarchivo;
	
	private String mensajeerror;
	
	@Size(max = 20)
	@Column(unique = true)
	private String correlativo;

	private Producto producto;
	
	//campos para C0002
	@Column(precision = 20 ,scale = 6)
	private BigDecimal recibetasafijaspread;
	
	@Size(max = 5)
	private String recibetfija;
	
	@Size(max = 10)
	private String recibeidentificadorfrecuencia;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal pagatasafijaspread;
	
	@Size(max = 5)
	private String pagatfija;
	
	@Size(max = 10)
	private String pagaidentificadorfrecuencia;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal volatilidad;
	
	@Size(max = 1)
	private String intencioncontratacion;
	
	@Size(max = 1)
	private String tipoaccion;

	@Size(max = 50)
	public String getIdCarga() {
		return idCarga;
	}

	public void setIdCarga(String idCarga) {
		this.idCarga = idCarga;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFechacontratacion() {
		return fechacontratacion;
	}

	public void setFechacontratacion(Calendar fechacontratacion) {
		this.fechacontratacion = fechacontratacion;
	}

	public String getNumerooperacion() {
		return numerooperacion;
	}

	public void setNumerooperacion(String numerooperacion) {
		this.numerooperacion = numerooperacion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getTipooperacion() {
		return tipooperacion;
	}

	public void setTipooperacion(String tipooperacion) {
		this.tipooperacion = tipooperacion;
	}

	public String getIddivisaentrada() {
		return iddivisaentrada;
	}

	public void setIddivisaentrada(String iddivisaentrada) {
		this.iddivisaentrada = iddivisaentrada;
	}

	public String getIddivisasalida() {
		return iddivisasalida;
	}

	public void setIddivisasalida(String iddivisasalida) {
		this.iddivisasalida = iddivisasalida;
	}

	public BigDecimal getImportedivisaentrada() {
		return importedivisaentrada;
	}

	public void setImportedivisaentrada(BigDecimal importedivisaentrada) {
		this.importedivisaentrada = importedivisaentrada;
	}

	public BigDecimal getImportedivisasalida() {
		return importedivisasalida;
	}

	public void setImportedivisasalida(BigDecimal importedivisasalida) {
		this.importedivisasalida = importedivisasalida;
	}

	public BigDecimal getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(BigDecimal cotizacion) {
		this.cotizacion = cotizacion;
	}

	public BigDecimal getPuntosswap() {
		return puntosswap;
	}

	public void setPuntosswap(BigDecimal puntosswap) {
		this.puntosswap = puntosswap;
	}

	public String getBasica() {
		return basica;
	}

	public void setBasica(String basica) {
		this.basica = basica;
	}

	public BigDecimal getCambioref() {
		return cambioref;
	}

	public void setCambioref(BigDecimal cambioref) {
		this.cambioref = cambioref;
	}

	public Calendar getFechavalor() {
		return fechavalor;
	}

	public void setFechavalor(Calendar fechavalor) {
		this.fechavalor = fechavalor;
	}

	public Calendar getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(Calendar fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	public Integer getPlazo() {
		return plazo;
	}

	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	public Calendar getFechaejercicio() {
		return fechaejercicio;
	}

	public void setFechaejercicio(Calendar fechaejercicio) {
		this.fechaejercicio = fechaejercicio;
	}

	public String getCallput() {
		return callput;
	}

	public void setCallput(String callput) {
		this.callput = callput;
	}

	public String getPlaza() {
		return plaza;
	}

	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}

	public String getPaisresidencia() {
		return paisresidencia;
	}

	public void setPaisresidencia(String paisresidencia) {
		this.paisresidencia = paisresidencia;
	}

	public String getRiesgopais() {
		return riesgopais;
	}

	public void setRiesgopais(String riesgopais) {
		this.riesgopais = riesgopais;
	}

	public BigDecimal getPrima() {
		return prima;
	}

	public void setPrima(BigDecimal prima) {
		this.prima = prima;
	}

	public String getIddivisaprima() {
		return iddivisaprima;
	}

	public void setIddivisaprima(String iddivisaprima) {
		this.iddivisaprima = iddivisaprima;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Calendar getFechaalta() {
		return fechaalta;
	}

	public void setFechaalta(Calendar fechaalta) {
		this.fechaalta = fechaalta;
	}

	public Calendar getFechamodificacioncarga() {
		return fechamodificacioncarga;
	}

	public void setFechamodificacioncarga(Calendar fechamodificacioncarga) {
		this.fechamodificacioncarga = fechamodificacioncarga;
	}

	public String getOperacionsustituye() {
		return operacionsustituye;
	}

	public void setOperacionsustituye(String operacionsustituye) {
		this.operacionsustituye = operacionsustituye;
	}

	public Calendar getFechabaja() {
		return fechabaja;
	}

	public void setFechabaja(Calendar fechabaja) {
		this.fechabaja = fechabaja;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getIntermediario() {
		return intermediario;
	}

	public void setIntermediario(String intermediario) {
		this.intermediario = intermediario;
	}

	public String getIntermediariodescripcion() {
		return intermediariodescripcion;
	}

	public void setIntermediariodescripcion(String intermediariodescripcion) {
		this.intermediariodescripcion = intermediariodescripcion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getContrato() {
		return contrato;
	}

	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	public String getResidente() {
		return residente;
	}

	public void setResidente(String residente) {
		this.residente = residente;
	}
	@Size(max=1)
	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	@Size(max=1)
	public String getTipoopcion() {
		return tipoopcion;
	}

	public void setTipoopcion(String tipoopcion) {
		this.tipoopcion = tipoopcion;
	}

	public String getTipoproceso() {
		return tipoproceso;
	}

	public void setTipoproceso(String tipoproceso) {
		this.tipoproceso = tipoproceso;
	}

	public Integer getHistorico() {
		return historico;
	}

	public void setHistorico(Integer historico) {
		this.historico = historico;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFechamovimiento() {
		return fechamovimiento;
	}

	public void setFechamovimiento(Calendar fechamovimiento) {
		this.fechamovimiento = fechamovimiento;
	}

	public String getUsuariocarga() {
		return usuariocarga;
	}

	public void setUsuariocarga(String usuariocarga) {
		this.usuariocarga = usuariocarga;
	}

	public String getCodigooperacion() {
		return codigooperacion;
	}

	public void setCodigooperacion(String codigooperacion) {
		this.codigooperacion = codigooperacion;
	}

	public BigDecimal getImporteusd() {
		return importeusd;
	}

	public void setImporteusd(BigDecimal importeusd) {
		this.importeusd = importeusd;
	}

	public String getCodigoreporte() {
		return codigoreporte;
	}

	public void setCodigoreporte(String codigoreporte) {
		this.codigoreporte = codigoreporte;
	}

	public BigDecimal getTasamonedanacional() {
		return tasamonedanacional;
	}

	public void setTasamonedanacional(BigDecimal tasamonedanacional) {
		this.tasamonedanacional = tasamonedanacional;
	}

	public BigDecimal getMontomonedaextranjera() {
		return montomonedaextranjera;
	}

	public void setMontomonedaextranjera(BigDecimal montomonedaextranjera) {
		this.montomonedaextranjera = montomonedaextranjera;
	}

	public BigDecimal getTasadiferencial() {
		return tasadiferencial;
	}

	public void setTasadiferencial(BigDecimal tasadiferencial) {
		this.tasadiferencial = tasadiferencial;
	}

	public BigDecimal getDelta() {
		return delta;
	}

	public void setDelta(BigDecimal delta) {
		this.delta = delta;
	}

	public BigDecimal getTasamonedaextranjera() {
		return tasamonedaextranjera;
	}

	public void setTasamonedaextranjera(BigDecimal tasamonedaextranjera) {
		this.tasamonedaextranjera = tasamonedaextranjera;
	}

	public String getIdmonedaextranjera() {
		return idmonedaextranjera;
	}

	public void setIdmonedaextranjera(String idmonedaextranjera) {
		this.idmonedaextranjera = idmonedaextranjera;
	}

	public BigDecimal getMontopen() {
		return montopen;
	}

	public void setMontopen(BigDecimal montopen) {
		this.montopen = montopen;
	}

	public BigDecimal getTipocambiospot() {
		return tipocambiospot;
	}

	public void setTipocambiospot(BigDecimal tipocambiospot) {
		this.tipocambiospot = tipocambiospot;
	}

	public BigDecimal getTipocambiopactado() {
		return tipocambiopactado;
	}

	public void setTipocambiopactado(BigDecimal tipocambiopactado) {
		this.tipocambiopactado = tipocambiopactado;
	}

	public BigDecimal getTipocambiovencimiento() {
		return tipocambiovencimiento;
	}

	public void setTipocambiovencimiento(BigDecimal tipocambiovencimiento) {
		this.tipocambiovencimiento = tipocambiovencimiento;
	}

	public String getValidacion() {
		return validacion;
	}

	public void setValidacion(String validacion) {
		this.validacion = validacion;
	}

	public String getCodigoagrupacion() {
		return codigoagrupacion;
	}

	public void setCodigoagrupacion(String codigoagrupacion) {
		this.codigoagrupacion = codigoagrupacion;
	}

	public String getTipocliente() {
		return tipocliente;
	}

	public void setTipocliente(String tipocliente) {
		this.tipocliente = tipocliente;
	}

	public Integer getIdfilaarchivo() {
		return idfilaarchivo;
	}

	public void setIdfilaarchivo(Integer idfilaarchivo) {
		this.idfilaarchivo = idfilaarchivo;
	}

	public String getMensajeerror() {
		return mensajeerror;
	}

	public void setMensajeerror(String mensajeerror) {
		this.mensajeerror = mensajeerror;
	}

	public String getCorrelativo() {
		return correlativo;
	}

	public void setCorrelativo(String correlativo) {
		this.correlativo = correlativo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_producto")
	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public BigDecimal getRecibetasafijaspread() {
		return recibetasafijaspread;
	}

	public void setRecibetasafijaspread(BigDecimal recibetasafijaspread) {
		this.recibetasafijaspread = recibetasafijaspread;
	}

	public String getRecibetfija() {
		return recibetfija;
	}

	public void setRecibetfija(String recibetfija) {
		this.recibetfija = recibetfija;
	}

	public String getRecibeidentificadorfrecuencia() {
		return recibeidentificadorfrecuencia;
	}

	public void setRecibeidentificadorfrecuencia(String recibeidentificadorfrecuencia) {
		this.recibeidentificadorfrecuencia = recibeidentificadorfrecuencia;
	}

	public BigDecimal getPagatasafijaspread() {
		return pagatasafijaspread;
	}

	public void setPagatasafijaspread(BigDecimal pagatasafijaspread) {
		this.pagatasafijaspread = pagatasafijaspread;
	}

	public String getPagatfija() {
		return pagatfija;
	}

	public void setPagatfija(String pagatfija) {
		this.pagatfija = pagatfija;
	}

	public String getPagaidentificadorfrecuencia() {
		return pagaidentificadorfrecuencia;
	}

	public void setPagaidentificadorfrecuencia(String pagaidentificadorfrecuencia) {
		this.pagaidentificadorfrecuencia = pagaidentificadorfrecuencia;
	}

	public BigDecimal getVolatilidad() {
		return volatilidad;
	}

	public void setVolatilidad(BigDecimal volatilidad) {
		this.volatilidad = volatilidad;
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

}
