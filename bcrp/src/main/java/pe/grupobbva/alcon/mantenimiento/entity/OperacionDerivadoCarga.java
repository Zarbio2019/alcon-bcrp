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
import javax.validation.constraints.Size;

import pe.grupobbva.alcon.core.beans.TimeFormat;
import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionDerivadoCargaType;

@Entity
@Table(name = "OperacionDerivadoCarga")
@SuppressWarnings("serial")
public class OperacionDerivadoCarga extends AbstractEntity {

	public OperacionDerivadoCarga(OperacionDerivadoCargaType registro) throws ParseException {

		this.carga = new Carga(registro.getIdcarga());
		this.idfilaarchivo = registro.getIdfilaarchivo();

		if (registro.getFechacarga() != null) {
			this.fechacarga = Utils.stringtoCalendar(registro.getFechacarga(), TimeFormat.TIMESTAMPFORMAT);
		}

		if (registro.getFechareporte() != null) {
			this.fechareporte = registro.getFechareporte();
		}

		this.numerooperacion = registro.getNumerooperacion();
		this.codigodiva = registro.getCodigodiva();
		this.producto = registro.getProducto();
		this.tipooperacion = TipoOperacion.valueOf(registro.getTipooperacion());
		this.codigocliente = registro.getCodigocliente();
		this.nombrecliente = registro.getNombrecliente();
		this.importeusd = registro.getImporteusd();
		this.divisa = registro.getDivisa();
		this.importedivisa = registro.getImportedivisa();

		if (registro.getFechaefectiva() != null) {
			this.fechaefectiva = registro.getFechaefectiva();
		}

		if (registro.getFechatermino() != null) {
			this.fechatermino = registro.getFechatermino();
		}

		this.callput = registro.getCallput();
		this.estilo = registro.getEstilo();
		this.tipoproceso = registro.getTipoproceso();
		this.strikerate = registro.getStrikerate();
		this.benchmark = registro.getBenchmark();
		this.benchmarkfrecuencia = registro.getBenchmarkfrecuencia();
		this.tiposubyacente = registro.getTiposubyacente();
		this.descripcionsubyacente = registro.getDescripcionsubyacente();
		this.preciopactado = registro.getPreciopactado();
		this.commoditytamanocontratounid = registro.getCommoditytamanocontratounid();
		this.commoditytamanounidmedida = registro.getCommoditytamanounidmedida();
		this.volatilidad = registro.getVolatilidad();
		this.prima = registro.getPrima();
		this.delta = registro.getDelta();
		this.observacion = registro.getObservacion();
		this.tipoaccion = registro.getTipoaccion();

	}

	public OperacionDerivadoCarga() {
		super();
	}

	private Carga carga;
	private Calendar fechacarga;
	private Integer idfilaarchivo;

	private String fechareporte;
	private String numerooperacion;
	private String codigodiva;
	private String producto;
	private TipoOperacion tipooperacion;

	private String codigocliente;
	private String nombrecliente;
	private String paisresidencia;
	private String importeusd;

	private String divisa;
	private String importedivisa;

	private String fechaefectiva;
	private String fechatermino;
	private String callput;
	private String estilo;
	private TipoProceso tipoproceso;
	private String strikerate;
	private String benchmark;
	private String tiposubyacente;
	private String descripcionsubyacente;
	private String preciopactado;
	private String commoditytamanocontratounid;
	private String commoditytamanounidmedida;
	private String benchmarkfrecuencia;
	private String volatilidad;
	private String prima;
	private String delta;
	private String mensajeerror;
	private String observacion;
	private String tipoaccion;

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

	public String getFechareporte() {
		return fechareporte;
	}

	public void setFechareporte(String fechareporte) {
		this.fechareporte = fechareporte;
	}

	public String getNumerooperacion() {
		if (numerooperacion == null) {
			numerooperacion = "";
		}

		return numerooperacion;
	}

	public void setNumerooperacion(String numerooperacion) {
		this.numerooperacion = numerooperacion;
	}

	public String getCodigodiva() {
		if (codigodiva == null) {
			codigodiva = "";
		}

		return codigodiva;
	}

	public void setCodigodiva(String codigodiva) {
		this.codigodiva = codigodiva;
	}

	public String getProducto() {
		if (producto == null) {
			producto = "";
		}
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	@Enumerated(EnumType.STRING)
	public TipoOperacion getTipooperacion() {
		return tipooperacion;
	}

	public void setTipooperacion(TipoOperacion tipooperacion) {
		this.tipooperacion = tipooperacion;
	}

	public String getCodigocliente() {
		if (codigocliente == null) {
			codigocliente = "";
		}
		return codigocliente;
	}

	public void setCodigocliente(String codigocliente) {
		this.codigocliente = codigocliente;
	}

	public String getNombrecliente() {
		if (nombrecliente == null) {
			nombrecliente = "";
		}
		return nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}

	public String getPaisresidencia() {
		if (paisresidencia == null) {
			paisresidencia = "";
		}
		return paisresidencia;
	}

	public void setPaisresidencia(String paisresidencia) {
		this.paisresidencia = paisresidencia;
	}

	public String getImporteusd() {
		if (importeusd == null) {
			importeusd = "";
		}

		return importeusd;
	}

	public void setImporteusd(String importeusd) {
		this.importeusd = importeusd;
	}

	public String getDivisa() {
		if (divisa == null) {
			divisa = "";
		}
		return divisa;
	}

	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}

	public String getImportedivisa() {
		if (importedivisa == null) {
			importedivisa = "";
		}

		return importedivisa;
	}

	public void setImportedivisa(String importedivisa) {
		this.importedivisa = importedivisa;
	}

	public String getFechaefectiva() {
		if (fechaefectiva == null) {
			fechaefectiva = "";
		}
		return fechaefectiva;
	}

	public void setFechaefectiva(String fechaefectiva) {
		this.fechaefectiva = fechaefectiva;
	}

	public String getFechatermino() {
		if (fechatermino == null) {
			fechatermino = "";
		}
		
		return fechatermino;
	}

	public void setFechatermino(String fechatermino) {
		this.fechatermino = fechatermino;
	}

	public String getCallput() {
		if (callput == null) {
			callput = "";
		}
		return callput;
	}

	public void setCallput(String callput) {
		this.callput = callput;
	}

	public String getEstilo() {
		if (estilo == null) {
			estilo = "";
		}
		
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	@Enumerated(EnumType.STRING)
	public TipoProceso getTipoproceso() {
		return tipoproceso;
	}

	public void setTipoproceso(TipoProceso tipoproceso) {
		this.tipoproceso = tipoproceso;
	}

	public String getStrikerate() {
		if (strikerate == null) {
			strikerate = "";
		}
		
		return strikerate;
	}

	public void setStrikerate(String strikerate) {
		this.strikerate = strikerate;
	}

	public String getBenchmark() {
		if (benchmark == null) {
			benchmark = "";
		}
		
		return benchmark;
	}

	public void setBenchmark(String benchmark) {
		this.benchmark = benchmark;
	}

	public String getTiposubyacente() {
		if (tiposubyacente == null) {
			tiposubyacente = "";
		}
		
		return tiposubyacente;
	}

	public void setTiposubyacente(String tiposubyacente) {
		this.tiposubyacente = tiposubyacente;
	}

	public String getDescripcionsubyacente() {
		if (descripcionsubyacente == null) {
			descripcionsubyacente = "";
		}
		
		return descripcionsubyacente;
	}

	public void setDescripcionsubyacente(String descripcionsubyacente) {
		this.descripcionsubyacente = descripcionsubyacente;
	}

	public String getPreciopactado() {
		if (preciopactado == null) {
			preciopactado = "";
		}
		
		return preciopactado;
	}

	public void setPreciopactado(String preciopactado) {
		this.preciopactado = preciopactado;
	}

	public String getCommoditytamanocontratounid() {
		if (commoditytamanocontratounid == null) {
			commoditytamanocontratounid = "";
		}
		
		return commoditytamanocontratounid;
	}

	public void setCommoditytamanocontratounid(String commoditytamanocontratounid) {
		this.commoditytamanocontratounid = commoditytamanocontratounid;
	}

	public String getCommoditytamanounidmedida() {
		if (commoditytamanounidmedida == null) {
			commoditytamanounidmedida = "";
		}
		
		return commoditytamanounidmedida;
	}

	public void setCommoditytamanounidmedida(String commoditytamanounidmedida) {
		this.commoditytamanounidmedida = commoditytamanounidmedida;
	}

	public String getBenchmarkfrecuencia() {
		if (benchmarkfrecuencia == null) {
			benchmarkfrecuencia = "";
		}
		
		return benchmarkfrecuencia;
	}

	public void setBenchmarkfrecuencia(String benchmarkfrecuencia) {
		this.benchmarkfrecuencia = benchmarkfrecuencia;
	}

	public String getVolatilidad() {
		if (volatilidad == null) {
			volatilidad = "";
		}
		
		return volatilidad;
	}

	public void setVolatilidad(String volatilidad) {
		this.volatilidad = volatilidad;
	}

	public String getPrima() {
		if (prima == null) {
			prima = "";
		}

		return prima;
	}

	public void setPrima(String prima) {
		this.prima = prima;
	}

	public String getDelta() {
		if (delta == null) {
			delta = "";
		}
		return delta;
	}

	public void setDelta(String delta) {
		this.delta = delta;
	}

	public String getMensajeerror() {
		if (mensajeerror == null) {
			mensajeerror = "";
		}

		return mensajeerror;
	}

	public void setMensajeerror(String mensajeerror) {
		this.mensajeerror = mensajeerror;
	}

	public String getObservacion() {
		if (observacion == null) {
			observacion = "";
		}

		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getTipoaccion() {
		if (tipoaccion == null) {
			tipoaccion = "";
		}
		
		return tipoaccion;
	}

	public void setTipoaccion(String tipoaccion) {
		this.tipoaccion = tipoaccion;
	}

}
