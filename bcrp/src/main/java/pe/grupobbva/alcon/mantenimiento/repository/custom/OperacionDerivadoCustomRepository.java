package pe.grupobbva.alcon.mantenimiento.repository.custom;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionOtrosDerivadosDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionSearch;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;

public interface OperacionDerivadoCustomRepository {
	
	public DatatableDTO<OperacionOtrosDerivadosDTO> search(OperacionSearch operacionSearch);
	public List<OperacionOtrosDerivadosDTO> searchList(OperacionSearch operacionSearch);
	
	public void generarCodigoReporteDerivados(Carga carga);
	public void generaUsuariosDivas(Carga carga);

}
