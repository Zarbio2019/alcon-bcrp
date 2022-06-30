package pe.grupobbva.alcon.mantenimiento.service;

import java.util.Calendar;
import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CargaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CargaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.CargaTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;

public interface CargaService extends AbstractService<Carga> {

	public void cargarDatosAdicionales(CargaDTO cargaDTO);
	public List<CargaDTO> listarCargaPorReprocesar(Calendar fecha);
	public void reprocesar(String idcarga);
	public List<Carga> listarCargaPorFechaProceso(String tipocarga, Calendar fecha);
	public DatatableDTO<CargaTableDTO> search(CargaSearch search);
	public void eliminar(String idcarga);
	public String obtenerTipoCargaPorIdCarga(String idcarga);
	public void eliminarOperacionesReprocesar(String idcarga);
	
	public List<Carga> listarCargasPosteriores(String idcarga,String tipoproceso,Calendar fecha);

	
}
