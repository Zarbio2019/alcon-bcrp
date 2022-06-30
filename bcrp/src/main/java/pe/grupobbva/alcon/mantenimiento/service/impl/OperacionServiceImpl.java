package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jfree.util.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.config.UsuarioActivo;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.FeriadoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacionTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Feriado;
import pe.grupobbva.alcon.mantenimiento.entity.Operacion;
import pe.grupobbva.alcon.mantenimiento.entity.TipoAccion;
import pe.grupobbva.alcon.mantenimiento.repository.OperacionRepository;
import pe.grupobbva.alcon.mantenimiento.service.CorrelativoService;
import pe.grupobbva.alcon.mantenimiento.service.FeriadoService;
import pe.grupobbva.alcon.mantenimiento.service.OperacionService;
import pe.grupobbva.alcon.mantenimiento.util.Utils;

@Service
public class OperacionServiceImpl extends AbstractServiceImpl<Operacion> implements OperacionService {

	private static final Logger log = LogManager.getLogger();

	@Value("${app.valorescargaoperacion.estado_a}")
	private String estadoAnulado;

	@Value("${app.valorescargaoperacion.mensaje_unwind}")
	private String MENSAJE_UNWIND;

	@Value("${app.valorescargaoperacion.mensaje_anulacion}")
	private String MENSAJE_ANULACION;

	@Value("${app.valoresobservacion.mensaje_modificada}")
	private String MENSAJE_MODIFICADA;

	@Autowired
	private UsuarioActivo usuarioActivo;

	@Autowired
	private OperacionService operacionService;

	@Autowired
	private FeriadoService feriadoService;

	@Autowired
	private CorrelativoService correlativoService;

	@Override
	public DatatableDTO<OperacionTableDTO> search(OperacionSearch operacionSearch) {
		return ((OperacionRepository) repository).search(operacionSearch);
	}

	@Override
	public void actualizarEstadoIRC(Carga carga, int codigoestado) {
		((OperacionRepository) repository).actualizarEstadoIRC(carga, codigoestado);
	}

	@Override
	public void actualizarFechaEfectiva(Carga carga) {
		((OperacionRepository) repository).actualizarFechaEfectiva(carga);
	}

	@Override
	public void eliminarOperaciones(Carga carga) {
		((OperacionRepository) repository).eliminarOperaciones(carga);
	}

	@Override
	@Transactional
	public void generarCodigoReporte1(Carga carga) {
		((OperacionRepository) repository).generarCodigoReporte1(carga);
	}

	@Override
	@Transactional
	public void generarCodigoReporte3(Carga carga) {
		((OperacionRepository) repository).generarCodigoReporte3(carga);
	}

	@Override
	@Transactional
	public void generarOperacionesMenoresQuinientosMil(Carga carga) {
		((OperacionRepository) repository).generarOperacionesMenoresQuinientosMil(carga);
	}

	@Override
	@Transactional
	public void generarCodigoReporte2Adelantado(Carga carga) {
		((OperacionRepository) repository).generarCodigoReporte2Adelantado(carga);
	}

	@Override
	public List<OperacionTableDTO> listarOperaciones(OperacionSearch operacionSearch) {
		return ((OperacionRepository) repository).listarOperaciones(operacionSearch);
	}

	@Override
	public void unwindOperacion(OperacionSearch operacionSearch) {

		List<OperacionTableDTO> operaciones = listarOperaciones(operacionSearch);

		Calendar fechasistema = Calendar.getInstance();
		fechasistema.set(Calendar.HOUR_OF_DAY, 0);
		fechasistema.set(Calendar.MINUTE, 0);
		fechasistema.set(Calendar.SECOND, 0);
		fechasistema.set(Calendar.MILLISECOND, 0);

		for (OperacionTableDTO operacion : operaciones) {

			Operacion nuevaOperacion = operacionService.buscarId(operacion.getId());

			if (Utils.validarOperacionUnwindAnular(nuevaOperacion).equals(Boolean.TRUE)) {

				nuevaOperacion.setFechamovimiento(devuelveFechaProceso());
				nuevaOperacion.setFechaalta(fechasistema);
				nuevaOperacion.setFechaejercicio(fechasistema);
				nuevaOperacion.setFechabaja(fechasistema);
				nuevaOperacion.setEstado(estadoAnulado);
				nuevaOperacion.setObservaciones(MENSAJE_UNWIND);
				nuevaOperacion.setTipoaccion(TipoAccion.U.name());
				nuevaOperacion.setHistorico(1);
				nuevaOperacion.setCreadoPor(usuarioActivo.getUser());
				

				try {
					((OperacionRepository) repository).unwindOperacion(nuevaOperacion);
				} catch (JpaSystemException ex) {
					log.error("failed!", ex);
					SQLException ge = (SQLException) (ex.getCause().getCause());

					String mensaje = ge.getMessage();
					if (mensaje == null) {
						mensaje = "";
					} else {
						mensaje = mensaje.substring(11);
						mensaje = mensaje.split("\\n")[0];
						mensaje = mensaje.substring(0, mensaje.length() < 254 ? mensaje.length() - 1 : 254);

						ValidatorUtil.validateMessage("codigo", mensaje);
					}
				}
			}
		}
	}

	@Override
	public void anularOperacion(OperacionSearch operacionSearch) {

		List<OperacionTableDTO> operaciones = listarOperaciones(operacionSearch);

		Calendar fechasistema = Calendar.getInstance();
		fechasistema.set(Calendar.HOUR_OF_DAY, 0);
		fechasistema.set(Calendar.MINUTE, 0);
		fechasistema.set(Calendar.SECOND, 0);
		fechasistema.set(Calendar.MILLISECOND, 0);

		for (OperacionTableDTO operacion : operaciones) {

			Operacion nuevaOperacion = operacionService.buscarId(operacion.getId());

			if (Utils.validarOperacionUnwindAnular(nuevaOperacion).equals(Boolean.TRUE)) {

				nuevaOperacion.setFechamovimiento(devuelveFechaProceso());
				nuevaOperacion.setFechaalta(fechasistema);
				nuevaOperacion.setFechaejercicio(fechasistema);
				nuevaOperacion.setFechabaja(fechasistema);
				nuevaOperacion.setEstado(estadoAnulado);
				nuevaOperacion.setObservaciones(MENSAJE_ANULACION);
				nuevaOperacion.setTipoaccion(TipoAccion.A.name());
				nuevaOperacion.setHistorico(1);
				nuevaOperacion.setCreadoPor(usuarioActivo.getUser());

				try {
					((OperacionRepository) repository).anularOperacion(nuevaOperacion);
				} catch (JpaSystemException ex) {
					log.error("failed!", ex);
					SQLException ge = (SQLException) (ex.getCause().getCause());

					String mensaje = ge.getMessage();
					if (mensaje == null) {
						mensaje = "";
					} else {
						mensaje = mensaje.substring(11);
						mensaje = mensaje.split("\\n")[0];
						mensaje = mensaje.substring(0, mensaje.length() < 254 ? mensaje.length() - 1 : 254);

						ValidatorUtil.validateMessage("codigo", mensaje);
					}
				}

			}
		}

	}

	public Calendar devuelveFechaProceso() {
		Calendar fecha = Calendar.getInstance();
		fecha.add(Calendar.DAY_OF_YEAR, -1);

		List<FeriadoDTO> feriados = feriadoService.listarFeriados();

		if (feriadoService.esDiaUtil(fecha, feriados).equals(Boolean.FALSE)) {
			fecha = feriadoService.obtenerAnteriorDiaUtil(fecha, feriados);
		}

		return fecha;
	}

	@Override
	public List<Operacion> tasaDevolverOperaciones(Calendar fecha, String tipoproceso) {
		return ((OperacionRepository) repository).tasaDevolverOperaciones(fecha, tipoproceso);
	}

	@Override
	public List<Operacion> tasaDevolverOperacionesPredatadas(Calendar fecha, String tipoproceso) {
		return ((OperacionRepository) repository).tasaDevolverOperacionesPredatadas(fecha, tipoproceso);
	}

	@Override
	public void actualizarTasas(Operacion operacion) {
		((OperacionRepository) repository).actualizarTasas(operacion);
	}

	@Override
	@Transactional
	public void eliminarOperacionPorIdCarga(String idcarga) {
		((OperacionRepository) repository).eliminarOperacionPorIdCarga(idcarga);
	}

	@Override
	@Transactional
	public String generaIRC(String codigo, String numerooperacion) {
		return ((OperacionRepository) repository).generaIRC(codigo, numerooperacion);
	}

	@Override
	public Integer obtenerMaximoHistorico(String numerooperacion, String tipoproceso) {
		return ((OperacionRepository) repository).obtenerMaximoHistorico(numerooperacion, tipoproceso);
	}

	@Override
	public Integer obtenerCodigoEstado(String numerooperacion, String tipoproceso, Integer historico) {
		return ((OperacionRepository) repository).obtenerCodigoEstado(numerooperacion, tipoproceso, historico);
	}

	@Override
	public Long verificarCambioUltimaOperacion(Operacion operacion) {
		return ((OperacionRepository) repository).verificarCambioUltimaOperacion(operacion.getFechacontratacion(),
				operacion.getProducto().getId(), operacion.getNumerooperacion(), operacion.getCliente().getId(),
				operacion.getTipooperacion(), operacion.getIddivisaentrada(), operacion.getIddivisasalida(),
				operacion.getImportedivisaentrada(), operacion.getImportedivisasalida(), operacion.getCotizacion(),
				operacion.getPuntosswap(), operacion.getBasica(), operacion.getCambioref(), operacion.getFechavalor(),
				operacion.getFechavencimiento(), operacion.getPlazo(), operacion.getFechaejercicio(),
				operacion.getCallput(), operacion.getPlaza(), operacion.getPaisresidencia(), operacion.getRiesgopais(),
				operacion.getPrima(), operacion.getIddivisaprima(), operacion.getObservaciones(),
				operacion.getFechaalta(), operacion.getFechamodificacioncarga(), operacion.getOperacionsustituye(),
				operacion.getFechabaja(), operacion.getNif(), operacion.getIntermediario(),
				operacion.getIntermediariodescripcion(), operacion.getEstado(), operacion.getContrato(),
				operacion.getResidente(), operacion.getEstilo(), operacion.getFechamovimiento(),
				operacion.getUsuariocarga(), operacion.getCodigooperacion(), operacion.getImporteusd(),
				operacion.getCodigoreporte(), operacion.getTasamonedanacional(), operacion.getTasamonedaextranjera(),
				operacion.getDelta(), operacion.getMontomonedaextranjera(), operacion.getIdmonedaextranjera(),
				operacion.getMontopen(), operacion.getTipocambiospot(), operacion.getTipocambiopactado(),
				operacion.getTipocambiovencimiento(), operacion.getValidacion(), operacion.getTipocliente(),
				operacion.getTipoopcion(), operacion.getTasadiferencial(), operacion.getHistorico(),
				operacion.getTipoproceso());
	}

	@Override
	@Transactional
	public void eliminarOperacionFechaMovimiento(String numerooperacion, String tipoproceso, Calendar fecha,
			Integer historico) {
		((OperacionRepository) repository).eliminarOperacionFechaMovimiento(numerooperacion, tipoproceso, fecha,
				historico);
	}

	@Override
	public Operacion obtenerTasasMonedas(String numerooperacion) {
		return ((OperacionRepository) repository).obtenerTasasMonedas(numerooperacion);
	}

	@Override
	public TablaDinamica<OperacionTableDTO> generarexcel(OperacionSearch operacionSearch) {
		TablaDinamica<OperacionTableDTO> consultaDinamica = new TablaDinamica<OperacionTableDTO>();

		List<OperacionTableDTO> resultados = ((OperacionRepository) repository).searchList(operacionSearch);
		
		Log.info("Se obtuvo los resultados");
		consultaDinamica.setColumnas(headExcel());
		consultaDinamica.setRegistros(resultados);
		consultaDinamica.setOrden(loadOrden());
		return consultaDinamica;
	}

	public List<String> headExcel() {
		List<String> columns = new ArrayList<String>();
		columns.add("Historico");
		columns.add("Contratación");
		columns.add("Movimiento");
		columns.add("Valor");
		columns.add("Vencimiento");
		columns.add("Proceso");
		columns.add("Estado");
		columns.add("Producto");
		columns.add("Operación");
		columns.add("Reporte");
		columns.add("Sustituye");
		columns.add("Cliente");
		columns.add("Nombre Cliente");
		columns.add("Tipo");
		columns.add("Divisa E.");
		columns.add("Divisa S.");

		columns.add("Importe E.");
		columns.add("Importe S.");
		columns.add("Cambio Ref.");
		columns.add("Cambio Pac");
		columns.add("Importe USD");

		columns.add("Observaciones");
		columns.add("CallPut");
		columns.add("Divisa Prima");
		columns.add("Importe Prima");
		columns.add("Tasa MN");
		columns.add("Tasa ME");

		return columns;
	}

	public List<String> loadOrden() {
		List<String> columns = new ArrayList<String>();
		columns.add("historico");
		columns.add("fechacontratacion");
		columns.add("fechamovimiento");
		columns.add("fechavalor");
		columns.add("fechavencimiento");
		columns.add("tipoProcesoDescripcion");
		columns.add("estadoOperacionDescripcion");
		columns.add("productoCodigo");
		columns.add("numerooperacion");
		columns.add("codigoreporte");
		columns.add("operacionsustituye");
		columns.add("clienteCodigo");
		columns.add("clienteNombre");
		columns.add("tipoOperacionDescripcion");
		columns.add("divisaEntradaCodigo");
		columns.add("divisaSalidaCodigo");

		columns.add("importedivisaentrada");
		columns.add("importedivisasalida");
		columns.add("cambioref");
		columns.add("tipocambiopactado");
		columns.add("importeusd");
		columns.add("observaciones");
		columns.add("callput");
		columns.add("divisaPrimaCodigo");
		columns.add("prima");
		columns.add("tasamonedanacional");
		columns.add("tasamonedaextranjera");

		return columns;
	}

	@Override
	public DatatableDTO<OperacionTableDTO> feriadoListarOperaciones(OperacionSearch search) {
		return ((OperacionRepository) repository).feriadoListarOperaciones(search);
	}

	@Override
	public List<OperacionTableDTO> listarOperacionesFeriado(Calendar fecha) {
		return ((OperacionRepository) repository).listarOperacionesFeriado(fecha);
	}

	@Override
	@Transactional
	public void procesarOperacionFeriado(String idferiado) {

		String mensajeerror = "";
		Feriado feriado = feriadoService.obtenerFeriadoPorId(idferiado);

		List<FeriadoDTO> feriados = feriadoService.listarFeriados();
		List<OperacionTableDTO> operacionesdto = listarOperacionesFeriado(feriado.getFecha());

		for (OperacionTableDTO operaciondto : operacionesdto) {
			Operacion operacion = new Operacion();
			Operacion operacionanular = new Operacion();

			try {

				operaciondto.fromDTO(operacion);

				operacionanular.setId(operaciondto.getId());
				operacionanular.setActualizadoPor(usuarioActivo.getUser());

				operacion.setFechavencimiento(
						feriadoService.obtenerSiguienteDiaUtil(operacion.getFechavencimiento(), feriados));
				operacion.setPlazo(pe.grupobbva.alcon.core.utils.Utils
						.obtenerDirefenciaFechaDias(operacion.getFechacontratacion(), operacion.getFechavencimiento()));
				operacion.setObservaciones(MENSAJE_MODIFICADA);
				operacion.setFechamovimiento(operacion.getFechavencimiento());
				operacion.setCreadoPor("MOD_FERIADO");

				actualizarEstado(operacionanular);

				Operacion operaciontmp = obtenerHistoricoNumeroOperacion(operacion);
				operacion.setNumerooperacion(operaciontmp.getNumerooperacion());
				operacion.setHistorico(operaciontmp.getHistorico());
				operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror())
						+ operaciontmp.getMensajeerror());
				mensajeerror = (operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror();

				if (operacion.getHistorico() != 0) {
					String correlativo = correlativoService.generaCorrelativoCompuesto("Operacion");
					operacion.setCorrelativo(correlativo);

					operaciontmp = obtenerTasasMonedas(operacion.getNumerooperacion());

					if (operaciontmp != null) {
						operacion.setTasamonedanacional(operaciontmp.getTasamonedanacional() == null ? BigDecimal.ZERO
								: operaciontmp.getTasamonedanacional());
						operacion.setTasamonedaextranjera(
								operaciontmp.getTasamonedaextranjera() == null ? BigDecimal.ZERO
										: operaciontmp.getTasamonedaextranjera());
					}

//					operacion.setCodigoestado(1);
					operacionService.guardar(operacion);
					operacionService.actualizarUsuarioCreador(operacion);
				}

			} catch (Exception ex) {
				operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror())
						+ ex.getMessage() + ". ");
			}

		}

		if (mensajeerror.equals("")) {
			feriadoService.actualizarOperacionFeriado(feriado.getId());
		}

	}

	@Override
	@Transactional
	public void actualizarEstado(Operacion entity) {
		Long registros = ((OperacionRepository) repository).existeOperacionActualizar(entity.getId());

		if (registros < 1l) {
			ValidatorUtil.validateMessage("operacion", "No existe la operación que desea eliminar.");
		}

		((OperacionRepository) repository).operacionActualizarEstado(entity.getId(), entity.getActualizadoPor(),
				Calendar.getInstance());

	}

	@Override
	@Transactional
	public void actualizarUsuarioCreador(Operacion entity) {
		((OperacionRepository) repository).actualizarUsuarioCreador(entity.getId());
	}

	private Operacion obtenerHistoricoNumeroOperacion(Operacion operacion) {
		Integer historico = 0;
		String numerooperacion;
		Integer codigoestado;
		Long cantidad;
		String errorop = "";

		Operacion operaciontmp = new Operacion();

		numerooperacion = operacion.getNumerooperacion();
		historico = operacionService.obtenerMaximoHistorico(numerooperacion, operacion.getTipoproceso());

		if (historico == 0) {
			historico = 1;
		} else {
			codigoestado = operacionService.obtenerCodigoEstado(numerooperacion, operacion.getTipoproceso(), historico);

			if (codigoestado == 2) {
				historico = historico + 1;
			} else {
				operacion.setHistorico(historico);
				operacion.setNumerooperacion(numerooperacion);
				cantidad = operacionService.verificarCambioUltimaOperacion(operacion);

				if (cantidad > 0) {
					// para evitar q inserte el mismo registro 2 veces ya no se inserta
					operacionService.eliminarOperacionFechaMovimiento(numerooperacion, operacion.getTipoproceso(),
							operacion.getFechamovimiento(), historico);
					historico = historico + 1;
				} else {
					historico = null;
					errorop = "Existe un registro idéntico para la operación " + numerooperacion;
				}
			}
		}

		operaciontmp.setNumerooperacion(numerooperacion);
		operaciontmp.setHistorico(historico);
		operaciontmp.setMensajeerror(errorop);

		return operaciontmp;
	}

	@Override
	@Transactional
	public void actualizarTasasCurvas(Operacion operacion) {
		((OperacionRepository) repository).actualizarTasasCurvas(operacion.getId(), operacion.getRecibetasafijaspread(),
				operacion.getRecibetfija(), operacion.getRecibeidentificadorfrecuencia(),
				operacion.getPagatasafijaspread(), operacion.getPagatfija(),
				operacion.getPagaidentificadorfrecuencia());
	}
	
	@Override
	public List<Operacion> tasaCurvaDevolverOperaciones(Calendar fecha, String tipoproceso, String codigo) {
		return ((OperacionRepository) repository).tasaCurvaDevolverOperaciones(fecha, tipoproceso, codigo);
	}

}
