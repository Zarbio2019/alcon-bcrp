package pe.grupobbva.alcon.mantenimiento.service.impl;

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
import pe.grupobbva.alcon.mantenimiento.dto.OperacionTasaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.TasaInteresSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.TasaInteres;
import pe.grupobbva.alcon.mantenimiento.entity.TipoAccion;
import pe.grupobbva.alcon.mantenimiento.repository.TasaInteresRepository;
import pe.grupobbva.alcon.mantenimiento.service.FeriadoService;
import pe.grupobbva.alcon.mantenimiento.service.TasaInteresService;

@Service
public class TasaInteresServiceImpl extends AbstractServiceImpl<TasaInteres> implements TasaInteresService {
	
	private static final Logger log = LogManager.getLogger();
	
	@Autowired
	private TasaInteresService tasaInteresService;
	
	@Autowired
	private FeriadoService feriadoService;
	
	@Autowired
	private UsuarioActivo usuarioActivo;
	
	@Value("${app.valorescargaoperacion.estado_a}")
	private String estadoAnulado;

	@Value("${app.valorescargaoperacion.mensaje_unwind}")
	private String MENSAJE_UNWIND;

	@Value("${app.valorescargaoperacion.mensaje_anulacion}")
	private String MENSAJE_ANULACION;
	
	@Override
	public DatatableDTO<OperacionTasaDTO> search(TasaInteresSearch tasaInteresSearch) {
		return ((TasaInteresRepository) repository).search(tasaInteresSearch);
	}
	
	@Override
	public List<OperacionTasaDTO> listarOperaciones(TasaInteresSearch tasaInteresSearch) {
		return ((TasaInteresRepository) repository).listarOperaciones(tasaInteresSearch);
	}

	
	@Override
	public void unwindTasas(TasaInteresSearch tasaInteresSearch) {

		List<OperacionTasaDTO> operaciones = listarOperaciones(tasaInteresSearch);

		Calendar fechasistema = Calendar.getInstance();
		fechasistema.set(Calendar.HOUR_OF_DAY, 0);
		fechasistema.set(Calendar.MINUTE, 0);
		fechasistema.set(Calendar.SECOND, 0);
		fechasistema.set(Calendar.MILLISECOND, 0);

		for (OperacionTasaDTO operacion : operaciones) {

			TasaInteres nuevaOperacion = tasaInteresService.buscarId(operacion.getId());


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
					((TasaInteresRepository) repository).unwindOperacion(nuevaOperacion);
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
//			}
		}
	}

	@Override
	public void anularTasas(TasaInteresSearch tasaInteresSearch) {

		List<OperacionTasaDTO> operaciones = listarOperaciones(tasaInteresSearch);

		Calendar fechasistema = Calendar.getInstance();
		fechasistema.set(Calendar.HOUR_OF_DAY, 0);
		fechasistema.set(Calendar.MINUTE, 0);
		fechasistema.set(Calendar.SECOND, 0);
		fechasistema.set(Calendar.MILLISECOND, 0);

		for (OperacionTasaDTO operacion : operaciones) {
			
			TasaInteres nuevaOperacion = tasaInteresService.buscarId(operacion.getId());


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
					((TasaInteresRepository) repository).anularOperacion(nuevaOperacion);
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
//		}

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
	public TablaDinamica<OperacionTasaDTO> generarexcel(TasaInteresSearch tasaInteresSearch) {
		TablaDinamica<OperacionTasaDTO> consultaDinamica = new TablaDinamica<OperacionTasaDTO>();

		List<OperacionTasaDTO> resultados = ((TasaInteresRepository) repository).listarOperaciones(tasaInteresSearch);
		
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
		columns.add("tipoprocesodesc");
		columns.add("estadodesc");
		columns.add("productodescripcion");
		columns.add("numerooperacion");
		columns.add("codigoreporte");
		columns.add("operacionsustituye");
		columns.add("clientecodigo");
		columns.add("clientenombre");
		columns.add("tipooperaciondescripcion");
		columns.add("divisaentradadescripcion");
		columns.add("divisasalidadescripcion");

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
	@Transactional
	public void eliminarTasaInteresPorIdCarga(String idcarga) {
		((TasaInteresRepository) repository).eliminarTasaInteresPorIdCarga(idcarga);
	}
	
	@Override
	@Transactional
	public String generaIRD(String codigo, String numerooperacion) {
		return ((TasaInteresRepository) repository).generaIRD(codigo, numerooperacion);
	}
	
	@Override
	public Integer obtenerMaximoHistoricoDerivadoTasaInteres(String numerooperacion, String tipoproceso) {
		return ((TasaInteresRepository) repository).obtenerMaximoHistoricoDerivadoTasaInteres(numerooperacion, tipoproceso);
	}
	
	@Override
	public Integer obtenerCodigoEstado(String numerooperacion, String tipoproceso, Integer historico) {
		return ((TasaInteresRepository) repository).obtenerCodigoEstado(numerooperacion, tipoproceso, historico);
	}
	
	@Override
	public Long verificarCambioUltimaOperacionDerivadoTasaInteres(TasaInteres tasainteres) {
		return ((TasaInteresRepository) repository).verificarCambioUltimaOperacionDerivadoTasaInteres(
				tasainteres.getFechacontratacion(),
				tasainteres.getProducto().getId(),
				tasainteres.getNumerooperacion(),
				tasainteres.getCliente().getId(),
				tasainteres.getTipooperacion(),
				tasainteres.getIddivisaentrada(),
				tasainteres.getIddivisasalida(),
				tasainteres.getImportedivisaentrada(),
				tasainteres.getImportedivisasalida(),
				tasainteres.getCotizacion(),
				tasainteres.getPuntosswap(),
				tasainteres.getBasica(),
				tasainteres.getCambioref(),
				tasainteres.getFechavalor(),
				tasainteres.getFechavencimiento(),
				tasainteres.getPlazo(),
				tasainteres.getFechaejercicio(),
				tasainteres.getCallput(),
				tasainteres.getPlaza(),
				tasainteres.getPaisresidencia(),
				tasainteres.getRiesgopais(),
				tasainteres.getPrima(),
				tasainteres.getIddivisaprima(),
				tasainteres.getObservaciones(),
				tasainteres.getFechaalta(),
				tasainteres.getFechamodificacioncarga(),
				tasainteres.getOperacionsustituye(),
				tasainteres.getFechabaja(),
				tasainteres.getNif(),
				tasainteres.getIntermediario(),
				tasainteres.getIntermediariodescripcion(),
				tasainteres.getEstado(),
				tasainteres.getContrato(),
				tasainteres.getResidente(),
				tasainteres.getEstilo(),
				tasainteres.getFechamovimiento(),
				tasainteres.getUsuariocarga(),
				tasainteres.getCodigooperacion(),
				tasainteres.getImporteusd(),
				tasainteres.getCodigoreporte(),
				tasainteres.getTasamonedanacional(),
				tasainteres.getTasamonedaextranjera(),
				tasainteres.getDelta(),
				tasainteres.getMontomonedaextranjera(),
				tasainteres.getIdmonedaextranjera(),
				tasainteres.getMontopen(),
				tasainteres.getTipocambiospot(),
				tasainteres.getTipocambiopactado(),
				tasainteres.getTipocambiovencimiento(),
				tasainteres.getValidacion(),
				tasainteres.getTipocliente(),
				tasainteres.getTipoopcion(),
				tasainteres.getTasadiferencial(),
				tasainteres.getHistorico(),
				tasainteres.getTipoproceso());
	}
	
	@Override
	@Transactional
	public void eliminarOperacionDerivadoTasaInteresFechaMovimiento(String numerooperacion, String tipoproceso, Calendar fecha, Integer historico) {
		((TasaInteresRepository) repository).eliminarOperacionDerivadoTasaInteresFechaMovimiento(numerooperacion, tipoproceso, fecha, historico);
	}
	
	@Override
	public void actualizarFechaEfectiva(Carga carga) {
		((TasaInteresRepository) repository).actualizarFechaEfectiva(carga);
	}
	
	@Override
	@Transactional
	public void generarCodigoReporte6(Carga carga) {
		((TasaInteresRepository) repository).generarCodigoReporte6(carga);
	}
	
}
