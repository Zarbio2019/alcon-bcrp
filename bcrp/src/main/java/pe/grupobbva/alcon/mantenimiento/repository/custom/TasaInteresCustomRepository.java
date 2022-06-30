package pe.grupobbva.alcon.mantenimiento.repository.custom;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionTasaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.TasaInteresSearch;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.TasaInteres;

public interface TasaInteresCustomRepository {

	public DatatableDTO<OperacionTasaDTO> search(TasaInteresSearch tasaInteresSearch);
	public List<OperacionTasaDTO> listarOperaciones(TasaInteresSearch tasaInteresSearch);
	public void unwindOperacion(TasaInteres tasaInteres);
	public void anularOperacion(TasaInteres tasaInteres);
	public List<OperacionTasaDTO> searchList(TasaInteresSearch tasaInteresSearch);
	public String generaIRD(String codigo, String numerooperacion);
	public void actualizarFechaEfectiva(Carga carga);
	public void generarCodigoReporte6(Carga carga);
	
}
