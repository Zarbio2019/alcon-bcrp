package pe.grupobbva.alcon.mantenimiento.service;

import java.util.Calendar;
import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionTasaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.TasaInteresSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.TasaInteres;

public interface TasaInteresService extends AbstractService<TasaInteres> {
	
	public DatatableDTO<OperacionTasaDTO> search(TasaInteresSearch tasaInteresSearch);
	public TablaDinamica<OperacionTasaDTO> generarexcel(TasaInteresSearch tasaInteresSearch);
	public void unwindTasas(TasaInteresSearch tasaInteresSearch);
	public void anularTasas(TasaInteresSearch tasaInteresSearch);
	public List<OperacionTasaDTO> listarOperaciones(TasaInteresSearch tasaInteresSearch);
	
	public void eliminarTasaInteresPorIdCarga(String idcarga);
	public String generaIRD(String codigo, String numerooperacion);
	public Integer obtenerMaximoHistoricoDerivadoTasaInteres(String numerooperacion, String tipoproceso);
	public Integer obtenerCodigoEstado(String numerooperacion, String tipoproceso, Integer historico);
	public Long verificarCambioUltimaOperacionDerivadoTasaInteres(TasaInteres tasainteres);
	public void eliminarOperacionDerivadoTasaInteresFechaMovimiento(String numerooperacion, String tipoproceso, Calendar fecha, Integer historico);
	public void actualizarFechaEfectiva(Carga carga);
	public void generarCodigoReporte6(Carga carga);

}
