package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionOtrosDerivadosDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionDerivado;

public interface OperacionDerivadoService extends AbstractService<OperacionDerivado> {
	
	public DatatableDTO<OperacionOtrosDerivadosDTO> search(OperacionSearch operacionSearch);
	public TablaDinamica<OperacionOtrosDerivadosDTO> generarexcel(OperacionSearch operacionSearch);
	
	public void generarCodigoReporteDerivados(Carga carga);
	public void generaUsuariosDivas(Carga carga);
	public void eliminarOperacionDerivadoPorIdCarga(String idcarga);
	
}
