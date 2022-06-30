package pe.grupobbva.alcon.mantenimiento.service;

import java.util.List;

import pe.grupobbva.alcon.mantenimiento.entity.DetalleParametro;

public interface DetalleParametroService extends AbstractService<DetalleParametro>{
	
	public List<DetalleParametro> listarCuentas(String codigo);
	public List<String> listarCurvas(String codigo);
	public List<DetalleParametro> listarTenor(String codigo);

}
