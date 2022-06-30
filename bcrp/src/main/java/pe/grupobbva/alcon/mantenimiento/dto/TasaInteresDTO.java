package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.TasaInteres;

@Data
public class TasaInteresDTO extends AbstractDTO<TasaInteres>{
	
	private String id;
	private String idCarga;
	private Calendar fechacontratacion;
	private String numerooperacion;
	private String idCliente;
	private String tipooperacion;
	private String iddivisaentrada;
	private String iddivisasalida;
	private BigDecimal importedivisaentrada;
	private BigDecimal importedivisasalida;
	private BigDecimal cotizacion;
	private BigDecimal puntosswap;
	private String basica;
	private BigDecimal cambioref;
	private Calendar fechavalor;
	private Calendar fechavencimiento;
	private Integer plazo;
	private Calendar fechaejercicio;
	private String callput;
	private String plaza;
	private String paisresidencia;
	private String riesgopais;
	private BigDecimal prima;
	private String iddivisaprima;
	private String observaciones;
	private Calendar fechaalta;
	private Calendar fechamodificacioncarga;
	private String operacionsustituye;
	private Calendar fechabaja;
	private String nif;
	private String intermediario;
	private String intermediariodescripcion;
	private String estado;
	private String contrato;
	private String residente;
	private String estilo;
	private String tipoopcion;
	private String tipoproceso;
	private Integer historico;
	private Calendar fechamovimiento;
	private String usuariocarga;
	private String codigooperacion;
	private BigDecimal importeusd;
	private String codigoreporte;
	private BigDecimal tasamonedanacional;
	private BigDecimal montomonedaextranjera;
	private BigDecimal tasadiferencial;
	private BigDecimal delta;
	private BigDecimal tasamonedaextranjera;
	private String idmonedaextranjera;
	private BigDecimal montopen;
	private BigDecimal tipocambiospot;
	private BigDecimal tipocambiopactado;
	private BigDecimal tipocambiovencimiento;
	private String validacion;
	private String codigoagrupacion;
	private String tipocliente;
	private Integer idfilaarchivo;
	private String mensajeerror;
	private String correlativo;
	private String idProducto;
	private BigDecimal recibetasafijaspread;
	private String recibetfija;
	private String recibeidentificadorfrecuencia;
	private BigDecimal pagatasafijaspread;
	private String pagatfija;
	private String pagaidentificadorfrecuencia;
	private BigDecimal volatilidad;
	private String intencioncontratacion;
	private String tipoaccion;
	
	public TasaInteresDTO(String id) {
		super(id);
	}
	
	public TasaInteresDTO() {
		super();
	}
	
	public TasaInteresDTO(TasaInteres entity) {
		super(entity);
		this.codigoreporte= entity.getCodigoreporte();
		this.numerooperacion= entity.getNumerooperacion();
		this.importedivisaentrada= entity.getImportedivisaentrada();
		this.importedivisasalida = entity.getImportedivisasalida();
		this.fechavencimiento= entity.getFechavencimiento();
		this.tipocambiospot= entity.getTipocambiospot();
		this.tipocambiopactado = entity.getTipocambiopactado();
		this.validacion= entity.getValidacion();
		this.tasamonedanacional = entity.getTasamonedanacional();
		this.tasamonedaextranjera = entity.getTasamonedaextranjera();
		this.delta= entity.getDelta();
		this.importeusd = entity.getImporteusd();
		this.volatilidad= entity.getVolatilidad();
		this.intencioncontratacion = entity.getIntencioncontratacion();
		this.tipoaccion = entity.getTipoaccion();
	}
	
	@Override
	public TasaInteres fromDTO(TasaInteres entity) {
		if(entity == null) {
			entity = new TasaInteres();
		}
		
		if(codigoreporte != null) {
			entity.setCodigoreporte(this.codigoreporte);
		}
		
		if(numerooperacion != null) {
			entity.setNumerooperacion(this.numerooperacion);
		}
		
		if(importedivisaentrada != null) {
			entity.setImportedivisaentrada(this.importedivisaentrada);
		}
		
		if(importedivisasalida != null) {
			entity.setImportedivisasalida(this.importedivisasalida);
		}
		
		if(fechavencimiento!= null) {
			entity.setFechavencimiento(this.fechavencimiento);
		}
		
		if(tipocambiospot != null) {
			entity.setTipocambiospot(this.tipocambiospot);
		}
		
		if(tipocambiopactado != null) {
			entity.setTipocambiopactado(this.tipocambiopactado);
		}
		
		if(tasamonedanacional != null) {
			entity.setTasamonedanacional(this.tasamonedanacional);
		}
		
		if(tasamonedaextranjera != null) {
			entity.setTasamonedaextranjera(this.tasamonedaextranjera);
		}
		
		if(delta != null) {
			entity.setDelta(this.delta);
		}
		
		if(importeusd != null) {
			entity.setImporteusd(this.importeusd);
		}
		
		if(validacion != null) {
			entity.setValidacion(this.validacion);
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
	public TasaInteresDTO(String id, String idCarga, Calendar fechacontratacion, String numerooperacion, String cliente,
			String tipooperacion, String iddivisaentrada, String iddivisasalida, BigDecimal importedivisaentrada,
			BigDecimal importedivisasalida, BigDecimal cotizacion, BigDecimal puntosswap, String basica,
			BigDecimal cambioref, Calendar fechavalor, Calendar fechavencimiento, Integer plazo,
			Calendar fechaejercicio, String callput, String plaza, String paisresidencia, String riesgopais,
			BigDecimal prima, String iddivisaprima, String observaciones, Calendar fechaalta,
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
		this.fechacontratacion = fechacontratacion;
		this.numerooperacion = numerooperacion;
		this.idCliente = cliente;
		this.tipooperacion = tipooperacion;
		this.iddivisaentrada = iddivisaentrada;
		this.iddivisasalida = iddivisasalida;
		this.importedivisaentrada = importedivisaentrada;
		this.importedivisasalida = importedivisasalida;
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
		this.observaciones = observaciones;
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

	
	public TasaInteresDTO( String idCarga, Calendar fechacontratacion, String numerooperacion, String cliente,
			String tipooperacion, String iddivisaentrada, String iddivisasalida, BigDecimal importedivisaentrada,
			BigDecimal importedivisasalida, BigDecimal cotizacion, BigDecimal puntosswap, String basica,
			BigDecimal cambioref, Calendar fechavalor, Calendar fechavencimiento, Integer plazo,
			Calendar fechaejercicio, String callput, String plaza, String paisresidencia, String riesgopais,
			BigDecimal prima, String iddivisaprima, String observaciones, Calendar fechaalta,
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
		this.fechacontratacion = fechacontratacion;
		this.numerooperacion = numerooperacion;
		this.idCliente = cliente;
		this.tipooperacion = tipooperacion;
		this.iddivisaentrada = iddivisaentrada;
		this.iddivisasalida = iddivisasalida;
		this.importedivisaentrada = importedivisaentrada;
		this.importedivisasalida = importedivisasalida;
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
		this.observaciones = observaciones;
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

	public TasaInteresDTO(String id, String idcarga, Calendar fechacontratacion, String idProducto,
			String numerooperacion, String idCliente, String tipooperacion, String iddivisaentrada,
			String iddivisasalida, BigDecimal importedivisaentrada, BigDecimal importedivisasalida,
			BigDecimal cotizacion, BigDecimal puntosswap, String basica, BigDecimal cambioref, Calendar fechavalor,
			Calendar fechavencimiento, Integer plazo, Calendar fechaejercicio, String callput, String plaza,
			String paisresidencia, String riesgopais, BigDecimal prima, String iddivisaprima, String observaciones,
			Calendar fechaalta, Calendar fechamodificacioncarga, String operacionsustituye, Calendar fechabaja,
			String nif, String intermediario, String intermediariodescripcion, String estado, String contrato,
			String residente, String estilo, String tipoopcion, String tipoproceso, Integer historico,
			Calendar fechamovimiento, String usuariocarga, String codigooperacion, BigDecimal importeusd,
			String codigoreporte, BigDecimal tasamonedanacional, BigDecimal montomonedaextranjera,
			BigDecimal tasadiferencial, BigDecimal delta, BigDecimal tasamonedaextranjera, String idmonedaextranjera,
			BigDecimal montopen, BigDecimal tipocambiospot, BigDecimal tipocambiopactado,
			BigDecimal tipocambiovencimiento, String validacion, String codigoagrupacion, String tipocliente,
			Integer idfilaarchivo, String mensajeerror, String correlativo, Integer codigoestado) {
		super(id);
		this.idCarga = idcarga;
		this.fechacontratacion = fechacontratacion;
		this.idProducto = idProducto;
		this.numerooperacion = numerooperacion;
		this.idCliente = idCliente;
		this.tipooperacion = tipooperacion;
		this.iddivisaentrada = iddivisaentrada;
		this.iddivisasalida = iddivisasalida;
		this.importedivisaentrada = importedivisaentrada;
		this.importedivisasalida = importedivisasalida;
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
		this.observaciones = observaciones;
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
		this.codigoestado = codigoestado;

	}

	
}
