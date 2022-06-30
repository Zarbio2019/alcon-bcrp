package pe.grupobbva.alcon.mantenimiento.service;

import java.util.List;

import pe.grupobbva.alcon.mantenimiento.entity.CodigoStarAltamira;

public interface CodigoStarAltamiraService extends AbstractService<CodigoStarAltamira> {
	
	public void eliminarCodigoStarAltamira();
	public List<CodigoStarAltamira> getCodigosStarAltamira();
	public CodigoStarAltamira obtenerCodigoAltamiraPorCliente(String codigo, Integer codigoestado);

}
