package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacioncargaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacioncargaTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Operacion;
import pe.grupobbva.alcon.mantenimiento.entity.Operacioncarga;

public interface OperacionCargaService extends AbstractService<Operacioncarga> {
	
	public void actualizarMensajeError(Operacion operacion);
	public void eliminarOperacionCargaPorIdCarga(String idcarga);
	public DatatableDTO<OperacioncargaTableDTO> listarErrores(OperacioncargaSearch operacioncarga);
	public void restaurarestadoOperacionCargaPorIdCarga(String idcarga);
	
}
