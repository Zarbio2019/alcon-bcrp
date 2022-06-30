package pe.grupobbva.alcon.mantenimiento.repository.custom;

import java.util.Calendar;
import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CargaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CargaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.CargaTableDTO;

public interface CargaCustomRepository {

	public List<CargaDTO> listarCargaPorReprocesar(Calendar fecha);
	public void reprocesar(String idcarga);
	public DatatableDTO<CargaTableDTO> search(CargaSearch search);
	
}
