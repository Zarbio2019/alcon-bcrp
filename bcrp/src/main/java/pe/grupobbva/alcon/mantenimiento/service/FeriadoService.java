package pe.grupobbva.alcon.mantenimiento.service;

import java.util.Calendar;
import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.FeriadoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.custom.FeriadoCopia;
import pe.grupobbva.alcon.mantenimiento.dto.search.FeriadoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.FeriadoTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Feriado;

public interface FeriadoService extends AbstractService<Feriado> {

	public DatatableDTO<FeriadoTableDTO> search(FeriadoSearch feriadoSearch);
	public void copiarFeriado(FeriadoCopia feriadoCopia);
	public List<FeriadoDTO> listarFeriados();
	public Boolean esDiaUtil(Calendar fecha, List<FeriadoDTO> feriados);
	public Calendar obtenerSiguienteDiaUtil(Calendar fecha, List<FeriadoDTO> feriados);
	public Calendar obtenerAnteriorDiaUtil(Calendar fecha, List<FeriadoDTO> feriados);
	public Feriado obtenerFeriadoPorId(String id);
	public void actualizarOperacionFeriado(String id);
	public int diasHabiles(Calendar fechaInicial, Calendar fechaFinal, List<FeriadoDTO> feriados);
	
}
