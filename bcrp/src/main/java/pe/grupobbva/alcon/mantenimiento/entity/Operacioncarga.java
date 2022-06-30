package pe.grupobbva.alcon.mantenimiento.entity;

import java.text.ParseException;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import pe.grupobbva.alcon.core.beans.TimeFormat;
import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionCargaType;

@Entity
@Table(name = "OperacionCarga")
@SuppressWarnings("serial")
public class Operacioncarga extends AbstractEntity {

	/**
	 * @param registro
	 * @throws ParseException
	 */
	public Operacioncarga(OperacionCargaType registro) throws ParseException {

		this.carga = new Carga(registro.getIdcarga());

		this.idfilaarchivo = registro.getIdfilaarchivo();

		if (registro.getFechacarga() != null) {
			this.fechacarga = Utils.stringtoCalendar(registro.getFechacarga(), TimeFormat.TIMESTAMPFORMAT);
		}

		if (registro.getFechacontratacion() != null) {
			this.fechacontratacion = registro.getFechacontratacion();
		}

		this.producto = registro.getProducto();
		this.numerooperacion = registro.getNumerooperacion();
		this.codigocliente = registro.getCodigocliente();
		this.nombrecliente = registro.getNombrecliente();
		this.tipooperacion = TipoOperacion.valueOf(registro.getTipooperacion());
		this.divisaentrada = registro.getDivisaentrada();
		this.divisasalida = registro.getDivisasalida();
		this.importedivisaentrada = registro.getImportedivisaentrada();
		this.importedivisasalida = registro.getImportedivisasalida();
		this.cotizacion = registro.getCotizacion();
		this.puntosswap = registro.getPuntosswap();
		this.basica = registro.getBasica();
		this.cambioref = registro.getCambioref();

		if (registro.getFechavalor() != null) {
			this.fechavalor = registro.getFechavalor();
		}

		if (registro.getFechavencimiento() != null) {
			this.fechavencimiento = registro.getFechavencimiento();
		}

		this.plazo = registro.getPlazo();

		if (registro.getFechaejercicio() != null) {
			this.fechaejercicio = registro.getFechaejercicio();
		}

		this.callput = registro.getCallput();
		this.plaza = registro.getPlaza();
		this.paisresidencia = registro.getPaisresidencia();
		this.paisriesgo = registro.getPaisriesgo();
		this.prima = registro.getPrima();
		this.divisaprima = registro.getDivisaprima();
		this.observacioncarga = registro.getObservacioncarga();

		if (registro.getFechaalta() != null) {
			this.fechaalta = registro.getFechaalta();
		}

		if (registro.getFechamodificacioncarga() != null) {
			this.fechamodificacioncarga = registro.getFechamodificacioncarga();
		}

		this.operacionsustituye = registro.getOperacionsustituye();

		if (registro.getFechavencimiento() != null) {
			this.fechabaja = registro.getFechavencimiento();
		}

		this.nif = registro.getNif();
		this.intermediario = registro.getIntermediario();
		this.intermediariodescripcion = registro.getIntermediariodescripcion();
		this.usuario = registro.getUsuario();
		this.nombreusuario = registro.getNombreusuario();
		this.estado = registro.getEstado();

		if (registro.getFechafixing() != null) {
			this.fechafixing = registro.getFechafixing();
		}

		this.tasapen = registro.getTasapen();
		this.tasausd = registro.getTasausd();
		this.delta = registro.getDelta();
		this.basicaauxiliar = registro.getBasicaauxiliar();
		this.tipopperacionauxiliar = registro.getTipooperacionauxiliar();
		this.mensajeerror = registro.getMensajeerror();
		this.tipoproceso = registro.getTipoproceso();
		
		// cambio nueva circular 0002-2020
		this.recibetasafijaspread = registro.getRecibetasafijaspread();
		this.recibetfija = registro.getRecibetfija();
		this.recibeidentificadorfrecuencia = registro.getRecibeidentificadorfrecuencia();
		this.pagatasafijaspread = registro.getPagatasafijaspread();
		this.pagatfija = registro.getPagatfija();
		this.pagaidentificadorfrecuencia = registro.getPagaidentificadorfrecuencia();

	}

	public Operacioncarga() {
		super();
	}

	private Carga carga;

	private Calendar fechacarga;

	private Integer idfilaarchivo;

	private String fechacontratacion;
	private String producto;
	private String numerooperacion;
	private String codigocliente;
	private String nombrecliente;

	private String divisaentrada;
	private String divisasalida;
	private String importedivisaentrada;
	private String importedivisasalida;
	private String cotizacion;
	private String puntosswap;
	private String basica;
	private String cambioref;

	private String fechavalor;

	private String fechavencimiento;
	private String plazo;

	private String fechaejercicio;

	private String callput;
	private String plaza;
	private String paisresidencia;
	private String paisriesgo;
	private String prima;
	private String divisaprima;
	private String observacioncarga;
	private String fechaalta;
	private String fechamodificacioncarga;
	private String operacionsustituye;
	private String fechabaja;
	private String nif;
	private String intermediario;
	private String intermediariodescripcion;
	private String usuario;
	private String nombreusuario;
	private String estado;

	private String fechafixing;
	private String tasapen;
	private String tasausd;
	private String delta;
	private String basicaauxiliar;
	private String tipopperacionauxiliar;
	private String mensajeerror;

	private TipoProceso tipoproceso;

	private TipoOperacion tipooperacion;
	
	// cambio nueva circular 0002-2020
	private String recibetasafijaspread;
	private String recibetfija;
	private String recibeidentificadorfrecuencia;
	private String pagatasafijaspread;
	private String pagatfija;
	private String pagaidentificadorfrecuencia;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_carga")
	public Carga getCarga() {
		return carga;
	}

	public void setCarga(Carga carga) {
		this.carga = carga;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFechacarga() {
		return fechacarga;
	}

	public void setFechacarga(Calendar fechacarga) {
		this.fechacarga = fechacarga;
	}

	public Integer getIdfilaarchivo() {
		return idfilaarchivo;
	}

	public void setIdfilaarchivo(Integer idfilaarchivo) {
		this.idfilaarchivo = idfilaarchivo;
	}

	public String getFechacontratacion() {
		if(fechacontratacion==null) {
			fechacontratacion=""; 
		}
		return fechacontratacion;
	}

	public void setFechacontratacion(String fechacontratacion) {
		this.fechacontratacion = fechacontratacion;
	}

	public String getProducto() {
		if(producto == null) {
			producto = ""; 
		}
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getNumerooperacion() {
		if(numerooperacion == null) {
			numerooperacion = ""; 
		}
		return numerooperacion;
	}

	public void setNumerooperacion(String numerooperacion) {
		this.numerooperacion = numerooperacion;
	}

	public String getCodigocliente() {
		if(codigocliente == null) {
			codigocliente = ""; 
		}
		return codigocliente;
	}

	public void setCodigocliente(String codigocliente) {
		this.codigocliente = codigocliente;
	}

	public String getNombrecliente() {
		if(nombrecliente == null) {
			nombrecliente = ""; 
		}
		return nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public String getDivisaentrada() {
		if(divisaentrada == null) {
			divisaentrada = ""; 
		}
		return divisaentrada;
	}

	public void setDivisaentrada(String divisaentrada) {
		this.divisaentrada = divisaentrada;
	}

	public String getDivisasalida() {
		if(divisasalida == null) {
			divisasalida = ""; 
		}
		return divisasalida;
	}

	public void setDivisasalida(String divisasalida) {
		this.divisasalida = divisasalida;
	}

	public String getImportedivisaentrada() {
		if(importedivisaentrada == null) {
			importedivisaentrada = ""; 
		}
		return importedivisaentrada;
	}

	public void setImportedivisaentrada(String importedivisaentrada) {
		this.importedivisaentrada = importedivisaentrada;
	}

	public String getImportedivisasalida() {
		if(importedivisasalida == null) {
			importedivisasalida = ""; 
		}
		return importedivisasalida;
	}

	public void setImportedivisasalida(String importedivisasalida) {
		this.importedivisasalida = importedivisasalida;
	}

	public String getCotizacion() {
		if(cotizacion == null) {
			cotizacion = ""; 
		}
		return cotizacion;
	}

	public void setCotizacion(String cotizacion) {
		this.cotizacion = cotizacion;
	}

	public String getPuntosswap() {
		if(puntosswap == null) {
			puntosswap = ""; 
		}
		return puntosswap;
	}

	public void setPuntosswap(String puntosswap) {
		this.puntosswap = puntosswap;
	}

	public String getBasica() {
		if(basica == null) {
			basica = ""; 
		}
		return basica;
	}

	public void setBasica(String basica) {
		this.basica = basica;
	}

	public String getCambioref() {
		if(cambioref == null) {
			cambioref=""; 
		}
		return cambioref;
	}

	public void setCambioref(String cambioref) {
		this.cambioref = cambioref;
	}

	public String getFechavalor() {
		if(fechavalor == null) {
			fechavalor = ""; 
		}
		return fechavalor;
	}

	public void setFechavalor(String fechavalor) {
		this.fechavalor = fechavalor;
	}

	public String getFechavencimiento() {
		if(fechavencimiento == null) {
			fechavencimiento = ""; 
		}
		return fechavencimiento;
	}

	public void setFechavencimiento(String fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	public String getPlazo() {
		if(plazo == null) {
			plazo = ""; 
		}
		return plazo;
	}

	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	public String getFechaejercicio() {
		if(fechaejercicio == null) {
			fechaejercicio = ""; 
		}
		return fechaejercicio;
	}

	public void setFechaejercicio(String fechaejercicio) {
		this.fechaejercicio = fechaejercicio;
	}

	public String getCallput() {
		if(callput == null) {
			callput = ""; 
		}
		return callput;
	}

	public void setCallput(String callput) {
		this.callput = callput;
	}

	public String getPlaza() {
		if(plaza == null) {
			plaza = ""; 
		}
		return plaza;
	}

	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}

	public String getPaisresidencia() {
		if(paisresidencia == null) {
			paisresidencia = ""; 
		}
		return paisresidencia;
	}

	public void setPaisresidencia(String paisresidencia) {
		this.paisresidencia = paisresidencia;
	}

	public String getPaisriesgo() {
		if(paisriesgo == null) {
			paisriesgo = ""; 
		}
		return paisriesgo;
	}

	public void setPaisriesgo(String paisriesgo) {
		this.paisriesgo = paisriesgo;
	}

	public String getPrima() {
		if(prima == null) {
			prima = ""; 
		}		
		return prima;
	}

	public void setPrima(String prima) {
		this.prima = prima;
	}

	public String getDivisaprima() {
		if(divisaprima == null) {
			divisaprima = ""; 
		}
		return divisaprima;
	}

	public void setDivisaprima(String divisaprima) {
		this.divisaprima = divisaprima;
	}

	public String getObservacioncarga() {
		if(observacioncarga == null) {
			observacioncarga = ""; 
		}
		return observacioncarga;
	}

	public void setObservacioncarga(String observacioncarga) {
		this.observacioncarga = observacioncarga;
	}

	public String getFechaalta() {
		if(fechaalta == null) {
			fechaalta = ""; 
		}
		return fechaalta;
	}

	public void setFechaalta(String fechaalta) {
		this.fechaalta = fechaalta;
	}

	public String getFechamodificacioncarga() {
		if(fechamodificacioncarga == null) {
			fechamodificacioncarga = ""; 
		}
		return fechamodificacioncarga;
	}

	public void setFechamodificacioncarga(String fechamodificacioncarga) {
		this.fechamodificacioncarga = fechamodificacioncarga;
	}

	public String getOperacionsustituye() {
		if(operacionsustituye == null) {
			operacionsustituye = ""; 
		}
		return operacionsustituye;
	}

	public void setOperacionsustituye(String operacionsustituye) {
		this.operacionsustituye = operacionsustituye;
	}

	public String getFechabaja() {
		if(fechabaja == null) {
			fechabaja = ""; 
		}
		
		return fechabaja;
	}

	public void setFechabaja(String fechabaja) {
		this.fechabaja = fechabaja;
	}

	public String getNif() {
		if(nif == null) {
			nif = ""; 
		}
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getIntermediario() {
		if(intermediario == null) {
			intermediario = ""; 
		}
		return intermediario;
	}

	public void setIntermediario(String intermediario) {
		this.intermediario = intermediario;
	}

	public String getIntermediariodescripcion() {
		if(intermediariodescripcion == null) {
			intermediariodescripcion = ""; 
		}
		return intermediariodescripcion;
	}

	public void setIntermediariodescripcion(String intermediariodescripcion) {
		this.intermediariodescripcion = intermediariodescripcion;
	}

	public String getUsuario() {
		if(usuario == null) {
			usuario = ""; 
		}
		
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNombreusuario() {
		if(nombreusuario == null) {
			nombreusuario = ""; 
		}
		return nombreusuario;
	}

	public void setNombreusuario(String nombreusuario) {
		this.nombreusuario = nombreusuario;
	}

	public String getEstado() {
		if(estado==null) {
			estado=""; 
		}
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechafixing() {
		if(fechafixing == null) {
			fechafixing = ""; 
		}
		return fechafixing;
	}

	public void setFechafixing(String fechafixing) {
		this.fechafixing = fechafixing;
	}

	public String getTasapen() {
		if(tasapen == null) {
			tasapen = ""; 
		}
		return tasapen;
	}

	public void setTasapen(String tasapen) {
		this.tasapen = tasapen;
	}

	public String getTasausd() {
		if(tasausd == null) {
			tasausd = ""; 
		}
		return tasausd;
	}

	public void setTasausd(String tasausd) {
		this.tasausd = tasausd;
	}

	public String getDelta() {
		if(delta == null) {
			delta = ""; 
		}
		return delta;
	}

	public void setDelta(String delta) {
		this.delta = delta;
	}

	public String getBasicaauxiliar() {
		if(basicaauxiliar == null) {
			basicaauxiliar = ""; 
		}
		return basicaauxiliar;
	}

	public void setBasicaauxiliar(String basicaauxiliar) {
		this.basicaauxiliar = basicaauxiliar;
	}

	public String getTipopperacionauxiliar() {
		if(tipopperacionauxiliar == null) {
			tipopperacionauxiliar = ""; 
		}
		return tipopperacionauxiliar;
	}

	public void setTipopperacionauxiliar(String tipopperacionauxiliar) {
		this.tipopperacionauxiliar = tipopperacionauxiliar;
	}

	public String getMensajeerror() {
		if(mensajeerror == null) {
			mensajeerror = ""; 
		}
		return mensajeerror;
	}

	public void setMensajeerror(String mensajeerror) {
		this.mensajeerror = mensajeerror;
	}

	@Enumerated(EnumType.STRING)
	public TipoProceso getTipoproceso() {
		return tipoproceso;
	}

	public void setTipoproceso(TipoProceso tipoproceso) {
		this.tipoproceso = tipoproceso;
	}

	@Enumerated(EnumType.STRING)
	public TipoOperacion getTipooperacion() {
		return tipooperacion;
	}

	public void setTipooperacion(TipoOperacion tipooperacion) {
		this.tipooperacion = tipooperacion;
	}
	
	// cambio nueva circular 0002-2020
	public String getRecibetasafijaspread() {
		return recibetasafijaspread;
	}

	public void setRecibetasafijaspread(String recibetasafijaspread) {
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

	public String getPagatasafijaspread() {
		return pagatasafijaspread;
	}

	public void setPagatasafijaspread(String pagatasafijaspread) {
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

}
