package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;
import pe.grupobbva.alcon.mantenimiento.entity.Operacion;
import pe.grupobbva.alcon.mantenimiento.entity.Producto;

@Data
public class OperacionDTO extends AbstractDTO<Operacion>{

	private String idcarga;
	private Calendar fechacontratacion;
	private String idProducto;
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
	
	private BigDecimal recibetasafijaspread;
	private String recibetfija;
	private String recibeidentificadorfrecuencia;
	
	private BigDecimal pagatasafijaspread;
	private String pagatfija;
	private String pagaidentificadorfrecuencia;
	
	private BigDecimal volatilidad;
	private String intencioncontratacion;
	private String tipoaccion;

	
	public OperacionDTO(String id) {
		super(id);
	}

	public OperacionDTO() {
		super();
	}

	public OperacionDTO(Operacion entity) {
		super(entity);
		
		this.idcarga = entity.getIdCarga();
		this.fechacontratacion = entity.getFechacontratacion();
		this.idProducto = entity.getProducto().getId();
		this.numerooperacion = entity.getNumerooperacion();
		this.idCliente = entity.getCliente().getId();
		this.tipooperacion = entity.getTipooperacion().toString();
		this.iddivisaentrada = entity.getIddivisaentrada();
		this.iddivisasalida = entity.getIddivisasalida();
		this.importedivisaentrada = entity.getImportedivisaentrada();
		this.importedivisasalida = entity.getImportedivisasalida();
		this.cotizacion = entity.getCotizacion();
		this.puntosswap = entity.getPuntosswap();
		this.basica = entity.getBasica();
		this.cambioref = entity.getCambioref();
		this.fechavalor = entity.getFechavalor();
		this.fechavencimiento = entity.getFechavencimiento();
		this.plazo = entity.getPlazo();
		this.fechaejercicio = entity.getFechaejercicio();
		this.callput = entity.getCallput();
		this.plaza = entity.getPlaza();
		this.paisresidencia = entity.getPaisresidencia();
		this.riesgopais = entity.getRiesgopais();
		this.prima = entity.getPrima();
		this.iddivisaprima = entity.getIddivisaprima();
		this.observaciones = entity.getObservaciones();
		this.fechaalta = entity.getFechaalta();
		this.fechamodificacioncarga = entity.getFechamodificacioncarga();
		this.operacionsustituye = entity.getOperacionsustituye();
		this.fechabaja = entity.getFechabaja();
		this.nif = entity.getNif();
		this.intermediario = entity.getIntermediario();
		this.intermediariodescripcion = entity.getIntermediariodescripcion();
		this.estado = entity.getEstado();
		this.contrato = entity.getContrato();
		this.residente = entity.getResidente();

		if (entity.getEstilo() != null) {
			this.estilo = entity.getEstilo().toString();
		}

		if (entity.getTipoopcion() != null) {
			this.tipoopcion = entity.getTipoopcion().toString();
		}

		this.tipoproceso = entity.getTipoproceso();
		this.historico = entity.getHistorico();
		this.fechamovimiento = entity.getFechamovimiento();
		this.usuariocarga = entity.getUsuariocarga();
		this.codigooperacion = entity.getCodigooperacion();
		this.importeusd = entity.getImporteusd();
		this.codigoreporte = entity.getCodigoreporte();
		this.tasamonedanacional = entity.getTasamonedanacional();
		this.montomonedaextranjera = entity.getMontomonedaextranjera();
		this.tasadiferencial = entity.getTasadiferencial();
		this.delta = entity.getDelta();
		this.tasamonedaextranjera = entity.getTasamonedaextranjera();
		this.idmonedaextranjera = entity.getIdmonedaextranjera();
		this.montopen = entity.getMontopen();
		this.tipocambiospot = entity.getTipocambiospot();
		this.tipocambiopactado = entity.getTipocambiopactado();
		this.tipocambiovencimiento = entity.getTipocambiovencimiento();
		this.validacion = entity.getValidacion();
		this.codigoagrupacion = entity.getCodigoagrupacion();
		this.tipocliente = entity.getTipocliente();
		this.idfilaarchivo = entity.getIdfilaarchivo();
		this.mensajeerror = entity.getMensajeerror();
		this.correlativo = entity.getCorrelativo();
		this.codigoestado = entity.getCodigoestado();
		this.volatilidad =entity.getVolatilidad();
		this.intencioncontratacion = entity.getIntencioncontratacion();
		this.tipoaccion = entity.getTipoaccion();
		
		this.recibetasafijaspread = entity.getRecibetasafijaspread();
		this.recibetfija = entity.getRecibetfija();
		this.recibeidentificadorfrecuencia = entity.getRecibeidentificadorfrecuencia();

		
		this.pagatasafijaspread = entity.getPagatasafijaspread();
		this.pagatfija = entity.getPagatfija();
		this.pagaidentificadorfrecuencia = entity.getPagaidentificadorfrecuencia();
		
	}

	@Override
	public Operacion fromDTO(Operacion entity) {
		if (entity == null) {
			entity = new Operacion();
		}
		
		if(idcarga != null) {
			entity.setIdCarga(this.idcarga);
		}
		
		if(fechacontratacion != null) {
			entity.setFechacontratacion(this.fechacontratacion);
		}
		
		if(idProducto != null) {
			entity.setProducto(new Producto(this.idProducto));
		}
		
		if(numerooperacion != null) {
			entity.setNumerooperacion(this.numerooperacion);
		}
		
		if(idCliente != null) {
			entity.setCliente(new Cliente(this.idCliente));
		}
		
		if(tipooperacion != null) {
			entity.setTipooperacion(this.tipooperacion);
		}
		
		if(iddivisaentrada != null) {
			entity.setIddivisaentrada(this.iddivisaentrada);
		}
		
		if(iddivisasalida != null) {
			entity.setIddivisasalida(this.iddivisasalida);
		}
		
		if(importedivisaentrada != null) {
			entity.setImportedivisaentrada(this.importedivisaentrada);
		}
		
		if(importedivisasalida != null) {
			entity.setImportedivisasalida(this.importedivisasalida);
		}
		
		if(cotizacion != null) {
			entity.setCotizacion(this.cotizacion);
		}
		
		if(puntosswap != null) {
			entity.setPuntosswap(this.puntosswap);
		}
		
		if(basica != null) {
			entity.setBasica(this.basica);
		}
		
		if(cambioref != null) {
			entity.setCambioref(this.cambioref);
		}
		
		if(fechavalor != null) {
			entity.setFechavalor(this.fechavalor);
		}
		
		if(fechavencimiento != null) {
			entity.setFechavencimiento(this.fechavencimiento);
		}
		
		if(plazo != null) {
			entity.setPlazo(this.plazo);
		}
		
		if(fechaejercicio != null) {
			entity.setFechaejercicio(this.fechaejercicio);
		}
		
		if(callput != null) {
			entity.setCallput(this.callput);
		}
		
		if(plaza != null) {
			entity.setPlaza(this.plaza);
		}

		if(paisresidencia != null) {
			entity.setPaisresidencia(this.paisresidencia);
		}
		
		if(riesgopais != null) {
			entity.setRiesgopais(this.riesgopais);
		}
		
		if(prima != null) {
			entity.setPrima(this.prima);
		}
		
		if(iddivisaprima != null) {
			entity.setIddivisaprima(this.iddivisaprima);
		}
		
		if(validacion!=null) {
			entity.setValidacion(this.validacion);
		}
		
		if(contrato != null) {
			entity.setContrato(this.contrato);
		}
		
		if(observaciones != null) {
			entity.setObservaciones(this.observaciones);
		}
		
		if(fechaalta != null) {
			entity.setFechaalta(this.fechaalta);
		}
		
		if(fechamodificacioncarga != null) {
			entity.setFechamodificacioncarga(this.fechamodificacioncarga);
		}
		
		if(operacionsustituye != null) {
			entity.setOperacionsustituye(this.operacionsustituye);
		}
		
		if(fechabaja != null) {
			entity.setFechabaja(this.fechabaja);
		}
		
		if(nif != null) {
			entity.setNif(this.nif);
		}
		
		if(intermediario != null) {
			entity.setIntermediario(this.intermediario);
		}
		
		if(intermediariodescripcion != null) {
			entity.setIntermediariodescripcion(this.intermediariodescripcion);
		}
		
		if(estado != null) {
			entity.setEstado(this.estado);
		}
		
		if(residente != null) {
			entity.setResidente(this.residente);
		}
		
		if(estilo != null) {
			entity.setEstilo(this.estilo);
		}
		
		if(tipoopcion != null) {
			entity.setTipoopcion(this.tipoopcion);
		}
		
		if(tipoproceso != null) {
			entity.setTipoproceso(this.tipoproceso);
		}
		
		if(historico != null) {
			entity.setHistorico(this.historico);
		}
		
		if(fechamovimiento != null) {
			entity.setFechamovimiento(this.fechamovimiento);
		}
		
		if(usuariocarga != null) {
			entity.setUsuariocarga(this.usuariocarga);
		}
		
		if(codigooperacion != null) {
			entity.setCodigooperacion(this.codigooperacion);
		}
		
		if(importeusd != null) {
			entity.setImporteusd(this.importeusd);
		}
		
		if(codigoreporte != null) {
			entity.setCodigoreporte(this.codigoreporte);
		}
		
		if(tasamonedanacional != null) {
			entity.setTasamonedanacional(this.tasamonedanacional);
		}

		if(montomonedaextranjera != null) {
			entity.setMontomonedaextranjera(this.montomonedaextranjera);
		}
		
		if(tasadiferencial != null) {
			entity.setTasadiferencial(this.tasadiferencial);
		}
		
		if(delta != null) {
			entity.setDelta(this.delta);
		}
		
		if(tasamonedaextranjera != null) {
			entity.setTasamonedaextranjera(this.tasamonedaextranjera);
		}
		
		if(idmonedaextranjera != null) {
			entity.setIdmonedaextranjera(this.idmonedaextranjera);
		}
		
		if(montopen != null) {
			entity.setMontopen(this.montopen);
		}
		
		if(tipocambiospot != null) {
			entity.setTipocambiospot(this.tipocambiospot);
		}
		
		if(tipocambiopactado != null) {
			entity.setTipocambiopactado(this.tipocambiopactado);
		}
		
		if(tipocambiovencimiento != null) {
			entity.setTipocambiovencimiento(this.tipocambiovencimiento);
		}
		
		if(codigoagrupacion != null) {
			entity.setCodigoagrupacion(this.codigoagrupacion);
		}
		
		if(tipocliente != null) {
			entity.setTipocliente(this.tipocliente);
		}
		
		if(idfilaarchivo != null) {
			entity.setIdfilaarchivo(this.idfilaarchivo);
		}
		
		if(mensajeerror != null) {
			entity.setMensajeerror(this.mensajeerror);
		}
		
		if(correlativo != null) {
			entity.setCorrelativo(this.correlativo);
		}
		
		if(codigoestado != null) {
			entity.setCodigoestado(this.codigoestado);
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

		if(recibetasafijaspread != null) {
			entity.setRecibetasafijaspread(this.recibetasafijaspread);
		}
		
		if(recibetfija != null) {
			entity.setRecibetfija(this.recibetfija);
		}
		
		if(recibeidentificadorfrecuencia != null) {
			entity.setRecibeidentificadorfrecuencia(this.recibeidentificadorfrecuencia);
		}
		
		if(pagatasafijaspread != null) {
			entity.setPagatasafijaspread(this.pagatasafijaspread);
		}
		
		if(pagatfija != null) {
			entity.setPagatfija(this.pagatfija);
		}
		
		if(pagaidentificadorfrecuencia != null) {
			entity.setPagaidentificadorfrecuencia(this.pagaidentificadorfrecuencia);
		}

		
		return entity;
	}
	
	@Override
	public void preactualizar() {
		super.preactualizar();
	}

	public OperacionDTO(String id, String idcarga, Calendar fechacontratacion, String idProducto,
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
			Integer idfilaarchivo, String mensajeerror, String correlativo, Integer codigoestado,
			BigDecimal volatilidad, String intencioncontratacion, String tipoaccion) {
		super(id);
		this.idcarga = idcarga;
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
		this.volatilidad = volatilidad;
		this.intencioncontratacion = intencioncontratacion;
		this.tipoaccion = tipoaccion;

	}
	
	public OperacionDTO(String id, String idcarga, Calendar fechacontratacion, String idProducto,
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
		this.idcarga = idcarga;
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
	
	public OperacionDTO(String id, String idcarga, Calendar fechacontratacion, String idProducto,
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
			BigDecimal recibetasafijaspread, String recibetfija, String recibeidentificadorfrecuencia,
			BigDecimal pagatasafijaspread, String pagatfija, String pagaidentificadorfrecuencia,
			BigDecimal volatilidad, String intencioncontratacion, String tipoaccion) {
		super(id);
		this.idcarga = idcarga;
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
