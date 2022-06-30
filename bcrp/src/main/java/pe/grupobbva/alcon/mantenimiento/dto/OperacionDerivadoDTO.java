package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionDerivado;
@Data
public class OperacionDerivadoDTO extends AbstractDTO<OperacionDerivado>{

	private String idCarga;
	private Calendar fechareporte;
	private String numerooperacion;
	private String tipooperacion;
	private String idCliente;
	private String residente;
	private String paisresidencia;
	private BigDecimal importeusd;
	private String iddivisa;
	private BigDecimal importedivisa;
	private String fechaefectiva;
	private Calendar fechatermino;
	private String callput;
	private String estilo;
	private String tipoproceso;
//	private BigDecimal strikerate;
//	private String benchmarkfrecuencia;
	private BigDecimal volatilidad;
	private BigDecimal prima;
	private BigDecimal delta;
	private String intencioncontratacion;
	private String tipoaccion;
	private String observacion;
	private Integer idfilaarchivo;
	private Calendar fechamovimiento;
	private String correlativo;
	private String mensajeerror;
	private String codigoreporte;
	private String idProducto;
	
	
	private BigDecimal cotizacion;
	private BigDecimal puntosswap;
	private String basica;
	private BigDecimal cambioref;
	private Calendar fechavalor;
	private Calendar fechavencimiento;
	private Integer plazo;
	private Calendar fechaejercicio;
	private String plaza;
	private String riesgopais;
	private String iddivisaprima;
	private Calendar fechaalta;
	private Calendar fechamodificacioncarga;
	private String operacionsustituye;
	private Calendar fechabaja;
	private String nif;
	private String intermediario;
	private String intermediariodescripcion;
	private String estado;
	private String contrato;
	private String tipoopcion;
	private Integer historico;
	private String usuariocarga;
	private String codigooperacion;
	private BigDecimal tasamonedanacional;
	private BigDecimal montomonedaextranjera;
	private BigDecimal tasadiferencial;
	private BigDecimal tasamonedaextranjera;
	private String idmonedaextranjera;
	private BigDecimal montopen;
	private BigDecimal tipocambiospot;
	private BigDecimal tipocambiopactado;
	private BigDecimal tipocambiovencimiento;
	private String validacion;
	private String codigoagrupacion;
	private String tipocliente;
	private BigDecimal recibetasafijaspread;
	private String recibetfija;
	private String recibeidentificadorfrecuencia;
	private BigDecimal pagatasafijaspread;
	private String pagatfija;
	private String pagaidentificadorfrecuencia;
	
	
	public OperacionDerivadoDTO(String id) {
		super(id);
	}
	
	public OperacionDerivadoDTO() {
		super();
	}
	
	public OperacionDerivadoDTO(OperacionDerivado entity) {
		super(entity);
		this.codigoreporte= entity.getCodigoreporte();
		this.numerooperacion= entity.getNumerooperacion();
		this.fechatermino= entity.getFechatermino();
		this.delta= entity.getDelta();
		this.importeusd = entity.getImporteusd();
		this.volatilidad= entity.getVolatilidad();
		this.intencioncontratacion = entity.getIntencioncontratacion();
		this.tipoaccion = entity.getTipoaccion();
	}
	
	@Override
	public OperacionDerivado fromDTO(OperacionDerivado entity) {
		if(entity == null) {
			entity = new OperacionDerivado();
		}
		
		if(codigoreporte != null) {
			entity.setCodigoreporte(this.codigoreporte);
		}
		
		if(numerooperacion != null) {
			entity.setNumerooperacion(this.numerooperacion);
		}
		
		if(fechatermino != null) {
			entity.setFechatermino(this.fechatermino);
		}
		
		if(delta != null) {
			entity.setDelta(this.delta);
		}
		
		if(importeusd != null) {
			entity.setImporteusd(this.importeusd);
		}
		
		if(volatilidad != null) {
			entity.setVolatilidad(this.volatilidad);
		}
		
		if(intencioncontratacion != null) {
			entity.setIntencioncontratacion(this.intencioncontratacion);
		}
		
		if(tipoaccion != null) {
			entity.setTipoaccion(this.tipoaccion);
		}
		
		return entity;
	}
	
	@Override
	public void preactualizar() {
		super.preactualizar();
	}

	/**
	 * 
	 * @param id
	 * @param idCarga
	 * @param fechacontratacion
	 * @param numerooperacion
	 * @param cliente
	 * @param tipooperacion
	 * @param iddivisaentrada
	 * @param iddivisasalida
	 * @param importedivisaentrada
	 * @param importedivisasalida
	 * @param cotizacion
	 * @param puntosswap
	 * @param basica
	 * @param cambioref
	 * @param fechavalor
	 * @param fechavencimiento
	 * @param plazo
	 * @param fechaejercicio
	 * @param callput
	 * @param plaza
	 * @param paisresidencia
	 * @param riesgopais
	 * @param prima
	 * @param iddivisaprima
	 * @param observaciones
	 * @param fechaalta
	 * @param fechamodificacioncarga
	 * @param operacionsustituye
	 * @param fechabaja
	 * @param nif
	 * @param intermediario
	 * @param intermediariodescripcion
	 * @param estado
	 * @param contrato
	 * @param residente
	 * @param estilo
	 * @param tipoopcion
	 * @param tipoproceso
	 * @param historico
	 * @param fechamovimiento
	 * @param usuariocarga
	 * @param codigooperacion
	 * @param importeusd
	 * @param codigoreporte
	 * @param tasamonedanacional
	 * @param montomonedaextranjera
	 * @param tasadiferencial
	 * @param delta
	 * @param tasamonedaextranjera
	 * @param idmonedaextranjera
	 * @param montopen
	 * @param tipocambiospot
	 * @param tipocambiopactado
	 * @param tipocambiovencimiento
	 * @param validacion
	 * @param codigoagrupacion
	 * @param tipocliente
	 * @param idfilaarchivo
	 * @param mensajeerror
	 * @param correlativo
	 * @param producto
	 * @param recibetasafijaspread
	 * @param recibetfija
	 * @param recibeidentificadorfrecuencia
	 * @param pagatasafijaspread
	 * @param pagatfija
	 * @param pagaidentificadorfrecuencia
	 * @param volatilidad
	 * @param intencioncontratacion
	 * @param tipoaccion
	 */
	public OperacionDerivadoDTO(String id, String idCarga, Calendar fechareporte, String numerooperacion, String cliente,
			String tipooperacion, String iddivisa,  BigDecimal importedivisa, BigDecimal cotizacion, BigDecimal puntosswap, String basica,
			BigDecimal cambioref, Calendar fechavalor, Calendar fechavencimiento, Integer plazo,
			Calendar fechaejercicio, String callput, String plaza, String paisresidencia, String riesgopais,
			BigDecimal prima, String iddivisaprima, String observacion, Calendar fechaalta,
			Calendar fechamodificacioncarga, String operacionsustituye, Calendar fechabaja, String nif,
			String intermediario, String intermediariodescripcion, String estado, String contrato, String residente,
			String estilo, String tipoopcion, String tipoproceso, Integer historico, Calendar fechamovimiento,
			String usuariocarga, String codigooperacion, BigDecimal importeusd, String codigoreporte,
			BigDecimal tasamonedanacional, BigDecimal montomonedaextranjera, BigDecimal tasadiferencial,
			BigDecimal delta, BigDecimal tasamonedaextranjera, String idmonedaextranjera, BigDecimal montopen,
			BigDecimal tipocambiospot, BigDecimal tipocambiopactado, BigDecimal tipocambiovencimiento,
			String validacion, String codigoagrupacion, String tipocliente, Integer idfilaarchivo, String mensajeerror,
			String correlativo, String producto, BigDecimal recibetasafijaspread, String recibetfija,
			String recibeidentificadorfrecuencia, BigDecimal pagatasafijaspread, String pagatfija,
			String pagaidentificadorfrecuencia, BigDecimal volatilidad, String intencioncontratacion,
			String tipoaccion) {
		super(id);
		this.idCarga = idCarga;
		this.fechareporte = fechareporte;
		this.numerooperacion = numerooperacion;
		this.idCliente = cliente;
		this.tipooperacion = tipooperacion;
		this.iddivisa = iddivisa;
		this.importedivisa = importedivisa;
		this.cotizacion = cotizacion;
		this.puntosswap = puntosswap;
		this.basica = basica;
		this.cambioref = cambioref;
		this.fechavalor = fechavalor;
		this.fechavencimiento = fechavencimiento;
		this.plazo = plazo;
		this.fechaejercicio = fechaejercicio;
		this.callput = callput;
		this.plaza = plaza;
		this.paisresidencia = paisresidencia;
		this.riesgopais = riesgopais;
		this.prima = prima;
		this.iddivisaprima = iddivisaprima;
		this.observacion = observacion;
		this.fechaalta = fechaalta;
		this.fechamodificacioncarga = fechamodificacioncarga;
		this.operacionsustituye = operacionsustituye;
		this.fechabaja = fechabaja;
		this.nif = nif;
		this.intermediario = intermediario;
		this.intermediariodescripcion = intermediariodescripcion;
		this.estado = estado;
		this.contrato = contrato;
		this.residente = residente;
		this.estilo = estilo;
		this.tipoopcion = tipoopcion;
		this.tipoproceso = tipoproceso;
		this.historico = historico;
		this.fechamovimiento = fechamovimiento;
		this.usuariocarga = usuariocarga;
		this.codigooperacion = codigooperacion;
		this.importeusd = importeusd;
		this.codigoreporte = codigoreporte;
		this.tasamonedanacional = tasamonedanacional;
		this.montomonedaextranjera = montomonedaextranjera;
		this.tasadiferencial = tasadiferencial;
		this.delta = delta;
		this.tasamonedaextranjera = tasamonedaextranjera;
		this.idmonedaextranjera = idmonedaextranjera;
		this.montopen = montopen;
		this.tipocambiospot = tipocambiospot;
		this.tipocambiopactado = tipocambiopactado;
		this.tipocambiovencimiento = tipocambiovencimiento;
		this.validacion = validacion;
		this.codigoagrupacion = codigoagrupacion;
		this.tipocliente = tipocliente;
		this.idfilaarchivo = idfilaarchivo;
		this.mensajeerror = mensajeerror;
		this.correlativo = correlativo;
		this.idProducto = producto;
		this.recibetasafijaspread = recibetasafijaspread;
		this.recibetfija = recibetfija;
		this.recibeidentificadorfrecuencia = recibeidentificadorfrecuencia;
		this.pagatasafijaspread = pagatasafijaspread;
		this.pagatfija = pagatfija;
		this.pagaidentificadorfrecuencia = pagaidentificadorfrecuencia;
		this.volatilidad = volatilidad;
		this.intencioncontratacion = intencioncontratacion;
		this.tipoaccion = tipoaccion;
	}

	
	public OperacionDerivadoDTO( String idCarga, Calendar fechareporte, String numerooperacion, String cliente,
			String tipooperacion, String iddivisa,  BigDecimal importedivisa,
			BigDecimal importedivisasalida, BigDecimal cotizacion, BigDecimal puntosswap, String basica,
			BigDecimal cambioref, Calendar fechavalor, Calendar fechavencimiento, Integer plazo,
			Calendar fechaejercicio, String callput, String plaza, String paisresidencia, String riesgopais,
			BigDecimal prima, String iddivisaprima, String observacion, Calendar fechaalta,
			Calendar fechamodificacioncarga, String operacionsustituye, Calendar fechabaja, String nif,
			String intermediario, String intermediariodescripcion, String estado, String contrato, String residente,
			String estilo, String tipoopcion, String tipoproceso, Integer historico, Calendar fechamovimiento,
			String usuariocarga, String codigooperacion, BigDecimal importeusd, String codigoreporte,
			BigDecimal tasamonedanacional, BigDecimal montomonedaextranjera, BigDecimal tasadiferencial,
			BigDecimal delta, BigDecimal tasamonedaextranjera, String idmonedaextranjera, BigDecimal montopen,
			BigDecimal tipocambiospot, BigDecimal tipocambiopactado, BigDecimal tipocambiovencimiento,
			String validacion, String codigoagrupacion, String tipocliente, Integer idfilaarchivo, String mensajeerror,
			String correlativo, String producto, BigDecimal recibetasafijaspread, String recibetfija,
			String recibeidentificadorfrecuencia, BigDecimal pagatasafijaspread, String pagatfija,
			String pagaidentificadorfrecuencia, BigDecimal volatilidad, String intencioncontratacion,
			String tipoaccion) {
		super();
		this.idCarga = idCarga;
		this.fechareporte = fechareporte;
		this.numerooperacion = numerooperacion;
		this.idCliente = cliente;
		this.tipooperacion = tipooperacion;
		this.iddivisa = iddivisa;
		this.importedivisa = importedivisa;
		this.cotizacion = cotizacion;
		this.puntosswap = puntosswap;
		this.basica = basica;
		this.cambioref = cambioref;
		this.fechavalor = fechavalor;
		this.fechavencimiento = fechavencimiento;
		this.plazo = plazo;
		this.fechaejercicio = fechaejercicio;
		this.callput = callput;
		this.plaza = plaza;
		this.paisresidencia = paisresidencia;
		this.riesgopais = riesgopais;
		this.prima = prima;
		this.iddivisaprima = iddivisaprima;
		this.observacion = observacion;
		this.fechaalta = fechaalta;
		this.fechamodificacioncarga = fechamodificacioncarga;
		this.operacionsustituye = operacionsustituye;
		this.fechabaja = fechabaja;
		this.nif = nif;
		this.intermediario = intermediario;
		this.intermediariodescripcion = intermediariodescripcion;
		this.estado = estado;
		this.contrato = contrato;
		this.residente = residente;
		this.estilo = estilo;
		this.tipoopcion = tipoopcion;
		this.tipoproceso = tipoproceso;
		this.historico = historico;
		this.fechamovimiento = fechamovimiento;
		this.usuariocarga = usuariocarga;
		this.codigooperacion = codigooperacion;
		this.importeusd = importeusd;
		this.codigoreporte = codigoreporte;
		this.tasamonedanacional = tasamonedanacional;
		this.montomonedaextranjera = montomonedaextranjera;
		this.tasadiferencial = tasadiferencial;
		this.delta = delta;
		this.tasamonedaextranjera = tasamonedaextranjera;
		this.idmonedaextranjera = idmonedaextranjera;
		this.montopen = montopen;
		this.tipocambiospot = tipocambiospot;
		this.tipocambiopactado = tipocambiopactado;
		this.tipocambiovencimiento = tipocambiovencimiento;
		this.validacion = validacion;
		this.codigoagrupacion = codigoagrupacion;
		this.tipocliente = tipocliente;
		this.idfilaarchivo = idfilaarchivo;
		this.mensajeerror = mensajeerror;
		this.correlativo = correlativo;
		this.idProducto = producto;
		this.recibetasafijaspread = recibetasafijaspread;
		this.recibetfija = recibetfija;
		this.recibeidentificadorfrecuencia = recibeidentificadorfrecuencia;
		this.pagatasafijaspread = pagatasafijaspread;
		this.pagatfija = pagatfija;
		this.pagaidentificadorfrecuencia = pagaidentificadorfrecuencia;
		this.volatilidad = volatilidad;
		this.intencioncontratacion = intencioncontratacion;
		this.tipoaccion = tipoaccion;
	}

	

	
}
