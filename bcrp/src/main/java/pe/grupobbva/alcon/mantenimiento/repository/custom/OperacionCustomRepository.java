package pe.grupobbva.alcon.mantenimiento.repository.custom;

import java.util.Calendar;
import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacionTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Feriado;
import pe.grupobbva.alcon.mantenimiento.entity.Operacion;

public interface OperacionCustomRepository {
	
	public DatatableDTO<OperacionTableDTO> search(OperacionSearch operacionSearch);
	public void actualizarOperacionFeriado(Feriado entity);
	public void actualizarEstadoIRC(Carga carga, int codigoestado);
	public void actualizarFechaEfectiva(Carga carga);
	public void eliminarOperaciones(Carga carga);
	public void generarCodigoReporte1(Carga carga);
	public void generarCodigoReporte3(Carga carga);
	public void generarOperacionesMenoresQuinientosMil(Carga carga);
	public void generarCodigoReporte2Adelantado(Carga carga);
	public void unwindOperacion(Operacion operacion);
	public void anularOperacion(Operacion operacion);
	public List<OperacionTableDTO> listarOperaciones(OperacionSearch operacionSearch);
	public void actualizarTasas(Operacion operacion);
	public String generaIRC(String codigo, String numerooperacion);
	public List<OperacionTableDTO> searchList(OperacionSearch operacionSearch);
	public DatatableDTO<OperacionTableDTO> feriadoListarOperaciones(OperacionSearch search);
	public List<OperacionTableDTO> listarOperacionesFeriado(Calendar fecha);
	
}
