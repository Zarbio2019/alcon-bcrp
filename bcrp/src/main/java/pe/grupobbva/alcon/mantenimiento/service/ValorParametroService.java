package pe.grupobbva.alcon.mantenimiento.service;

import java.util.List;

import pe.grupobbva.alcon.mantenimiento.entity.ValorParametro;

public interface ValorParametroService extends AbstractService<ValorParametro> {

	public ValorParametro obtenerParametroPorCodigo(String codigo, String descripcion);
	public ValorParametro obtenerParametroCurvaDivisaCodigo(String descripcion, String valor);
	public ValorParametro obtenerParametroDivisaCodigo(String descripcion, String valor);
	public List<ValorParametro> listarDivisasCurvas(String codigo);
	public ValorParametro obtenerDescripcionTenor(String descripcion, String codigo);
	public List<ValorParametro> obtenerCredenciales(String codigo);
	public ValorParametro obtenerParametroValorPais(String descripcion, String valor);

	
}
