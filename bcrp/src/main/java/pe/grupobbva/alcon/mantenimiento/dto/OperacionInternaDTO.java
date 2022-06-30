package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;
import pe.grupobbva.alcon.mantenimiento.entity.Estilo;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionInterna;
import pe.grupobbva.alcon.mantenimiento.entity.Producto;
import pe.grupobbva.alcon.mantenimiento.entity.TipoOpcion;

@Data
public class OperacionInternaDTO extends AbstractDTO<OperacionInterna> {

	Estilo estiloEnum;

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

	public OperacionInternaDTO(String id) {
		super(id);
	}

	public OperacionInternaDTO() {
		super();
	}

	public OperacionInternaDTO(OperacionInterna entity) {
		super(entity);
		this.idcarga = entity.getIdCarga();
		this.fechacontratacion = entity.getFechacontratacion();
		this.idProducto = entity.getProducto().getId();
		this.numerooperacion = entity.getNumerooperacion();
		this.idCliente = entity.getCliente().getId();
		this.tipooperacion = entity.getTipooperacion();
		this.iddivisaentrada = entity.getIddivisaentrada();
		this.iddivisasalida = entity.getIddivisasalida();
		this.importedivisaentrada = entity.getImportedivisaentrada();
		this.importedivisasalida = entity.getImportedivisasalida();
		this.cotizacion = entity.getCotizacion();
		this.puntosswap = entity.getPuntosswap();
		this.basica = entity.getBasica();
		this.cambioref = entity.getCambioref();
		this.fechavalor = entity.getFechavalor();
		this.fechavencimiento = entity.getFechamovimiento();
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
		this.codigoestado = entity.getCodigoestado();

	}

	@Override
	public OperacionInterna fromDTO(OperacionInterna entity) {
		if (entity == null) {
			entity = new OperacionInterna();
		}

		if (idcarga != null) {
			entity.setIdCarga(idcarga);
		}

		if (fechacontratacion != null) {
			entity.setFechacontratacion(fechacontratacion);
		}

		if (idProducto != null) {
			entity.setProducto(new Producto(idProducto));
		}

		if (numerooperacion != null) {
			entity.setNumerooperacion(numerooperacion);
		}

		if (idCliente != null) {
			entity.setCliente(new Cliente(idCliente));
		}

		if (tipooperacion != null) {
			entity.setTipooperacion(tipooperacion);
		}

		if (iddivisaentrada != null) {
			entity.setIddivisaentrada(iddivisaentrada);
		}

		if (iddivisasalida != null) {
			entity.setIddivisasalida(iddivisasalida);
		}

		if (importedivisaentrada != null) {
			entity.setImportedivisaentrada(importedivisaentrada);
		}

		if (importedivisasalida != null) {
			entity.setImportedivisasalida(importedivisasalida);
		}

		if (cotizacion != null) {
			entity.setCotizacion(cotizacion);
		}

		if (puntosswap != null) {
			entity.setPuntosswap(puntosswap);
		}

		if (basica != null) {
			entity.setBasica(basica);
		}

		if (cambioref != null) {
			entity.setCambioref(cambioref);
		}

		if (fechavalor != null) {
			entity.setFechavalor(fechavalor);
		}

		if (fechavencimiento != null) {
			entity.setFechavencimiento(fechavencimiento);
		}

		if (plazo != null) {
			entity.setPlazo(plazo);
		}

		if (iddivisasalida != null) {
			entity.setIddivisasalida(iddivisasalida);
		}

		if (importedivisaentrada != null) {
			entity.setImportedivisaentrada(importedivisaentrada);
		}

		if (plaza != null) {
			entity.setPlaza(plaza);
		}

		if (paisresidencia != null) {
			entity.setPaisresidencia(paisresidencia);
		}

		if (riesgopais != null) {
			entity.setRiesgopais(riesgopais);
		}

		if (prima != null) {
			entity.setPrima(prima);
		}

		if (iddivisaprima != null) {
			entity.setIddivisaprima(iddivisaprima);
		}

		if (observaciones != null) {
			entity.setObservaciones(observaciones);
		}

		if (fechaalta != null) {
			entity.setFechaalta(fechaalta);
		}

		if (fechamodificacioncarga != null) {
			entity.setFechamodificacioncarga(fechamodificacioncarga);
		}

		if (operacionsustituye != null) {
			entity.setOperacionsustituye(operacionsustituye);
		}

		if (fechabaja != null) {
			entity.setFechabaja(fechabaja);
		}

		if (nif != null) {
			entity.setNif(nif);
		}

		if (intermediario != null) {
			entity.setIntermediario(intermediario);
		}

		if (intermediariodescripcion != null) {
			entity.setIntermediariodescripcion(intermediariodescripcion);
		}

		if (estado != null) {
			entity.setEstado(estado);
		}

		if (contrato != null) {
			entity.setContrato(contrato);
		}

		if (residente != null) {
			entity.setResidente(residente);
		}

		if (estilo != null) {
			switch (estilo) {
				case "C":
					entity.setEstilo(Estilo.C);
					break;
	
				case "E":
					entity.setEstilo(Estilo.E);
					break;
	
				case "P":
					entity.setEstilo(Estilo.P);
					break;
			}
		}

		if (tipoopcion != null) {
			switch (tipoopcion) {
				case "C":
					entity.setTipoopcion(TipoOpcion.C);
					break;
	
				case "E":
					entity.setTipoopcion(TipoOpcion.E);
					break;
	
				case "P":
					entity.setTipoopcion(TipoOpcion.P);
					break;
			}

		}

		if (tipoproceso != null) {
			entity.setTipoproceso(tipoproceso);
		}

		if (historico != null) {
			entity.setHistorico(historico);
		}
		
		if (fechamovimiento != null) {
			entity.setFechamovimiento(fechamovimiento);
		}

		if (usuariocarga != null) {
			entity.setUsuariocarga(usuariocarga);
		}
		
		if (codigooperacion != null) {
			entity.setCodigooperacion(codigooperacion);
		}

		if (importeusd != null) {
			entity.setImporteusd(importeusd);
		}
		
		if (codigoreporte != null) {
			entity.setCodigoreporte(codigoreporte);
		}

		if (tasamonedanacional != null) {
			entity.setTasamonedanacional(tasamonedanacional);
		}
		
		if (montomonedaextranjera != null) {
			entity.setMontomonedaextranjera(montomonedaextranjera);
		}

		if (tasadiferencial != null) {
			entity.setTasadiferencial(tasadiferencial);
		}
		
		if (delta != null) {
			entity.setDelta(delta);
		}

		if (tasamonedaextranjera != null) {
			entity.setTasamonedaextranjera(tasamonedaextranjera);
		}
		
		if (idmonedaextranjera != null) {
			entity.setIdmonedaextranjera(idmonedaextranjera);
		}

		if (montopen != null) {
			entity.setMontopen(montopen);
		}
		
		if (tipocambiospot != null) {
			entity.setTipocambiospot(tipocambiospot);
		}

		if (tipocambiopactado != null) {
			entity.setTipocambiopactado(tipocambiopactado);
		}
		
		if (tipocambiovencimiento != null) {
			entity.setTipocambiovencimiento(tipocambiovencimiento);
		}

		if (validacion != null) {
			entity.setValidacion(validacion);
		}
		
		if (codigoagrupacion != null) {
			entity.setCodigoagrupacion(codigoagrupacion);
		}

		if (tipocliente != null) {
			entity.setTipocliente(tipocliente);
		}
		
		if (idfilaarchivo != null) {
			entity.setIdfilaarchivo(idfilaarchivo);
		}
		
		if (codigoestado != null) {
			entity.setCodigoestado(codigoestado);
		}
		
		return entity;
	}

	@Override
	public void preactualizar() {
		super.preactualizar();
	}

	/**
	 * @param idcarga
	 * @param fechacontratacion
	 * @param idProducto
	 * @param numerooperacion
	 * @param idCliente
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
	 * @param montomonedaextrajera
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
	 * @param codigoestado
	 */
	public OperacionInternaDTO(String id, String idcarga, Calendar fechacontratacion, String idProducto,
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
			Integer idfilaarchivo, Integer codigoestado) {
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
		this.codigoestado = codigoestado;

	}

}
