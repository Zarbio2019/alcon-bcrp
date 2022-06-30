package pe.grupobbva.alcon.mantenimiento.service;

import java.util.Calendar;
import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacionTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Operacion;

public interface OperacionService extends AbstractService<Operacion> {
	
	public DatatableDTO<OperacionTableDTO> search(OperacionSearch operacionSearch);
	public void actualizarEstadoIRC(Carga carga, int codigoestado);
	public void actualizarFechaEfectiva(Carga carga);
	public void eliminarOperaciones(Carga carga);
	public void generarCodigoReporte1(Carga carga);
	public void generarCodigoReporte3(Carga carga);
	public void generarOperacionesMenoresQuinientosMil(Carga carga);
	public void generarCodigoReporte2Adelantado(Carga carga);
	public void unwindOperacion(OperacionSearch operacionSearch);
	public void anularOperacion(OperacionSearch operacionSearch);
	public List<OperacionTableDTO> listarOperaciones(OperacionSearch operacionSearch);
	public List<Operacion> tasaDevolverOperaciones(Calendar fecha, String tipoproceso);
	public List<Operacion> tasaDevolverOperacionesPredatadas(Calendar fecha, String tipoproceso);
	public void actualizarTasas(Operacion operacion);
	public void eliminarOperacionPorIdCarga(String idcarga);
	public String generaIRC(String codigo, String numerooperacion);
	public Integer obtenerMaximoHistorico(String numerooperacion, String tipoproceso);
	public Integer obtenerCodigoEstado(String numerooperacion, String tipoproceso, Integer historico);
	public Long verificarCambioUltimaOperacion(Operacion operacion);
	public void eliminarOperacionFechaMovimiento(String numerooperacion, String tipoproceso, Calendar fecha, Integer historico);
	public Operacion obtenerTasasMonedas(String numerooperacion);
	public TablaDinamica<OperacionTableDTO> generarexcel(OperacionSearch operacionSearch);
	public DatatableDTO<OperacionTableDTO> feriadoListarOperaciones(OperacionSearch operacionSearch);
	public void procesarOperacionFeriado(String idferiado);
	public List<OperacionTableDTO> listarOperacionesFeriado(Calendar fecha);
	public void actualizarEstado(Operacion operacion);
	public void actualizarUsuarioCreador(Operacion operacion);
	public void actualizarTasasCurvas(Operacion operacion);
	public List<Operacion> tasaCurvaDevolverOperaciones(Calendar fecha, String tipoproceso, String codigo);
	
}
