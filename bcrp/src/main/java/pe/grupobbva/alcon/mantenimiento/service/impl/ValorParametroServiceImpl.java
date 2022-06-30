package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.entity.ValorParametro;
import pe.grupobbva.alcon.mantenimiento.repository.ValorParametroRepository;
import pe.grupobbva.alcon.mantenimiento.service.ValorParametroService;

@Service
public class ValorParametroServiceImpl extends AbstractServiceImpl<ValorParametro> implements ValorParametroService{

	@Override
	public ValorParametro obtenerParametroPorCodigo(String codigo, String descripcion) {
		return ((ValorParametroRepository) repository).obtenerParametroPorCodigo(codigo, descripcion);
	}
	
	@Override
	public ValorParametro obtenerParametroCurvaDivisaCodigo(String descripcion, String valor) {
		return ((ValorParametroRepository) repository).obtenerParametroCurvaDivisaCodigo(descripcion, valor);
	}
	
	@Override
	public ValorParametro obtenerParametroDivisaCodigo(String descripcion, String valor) {
		return ((ValorParametroRepository) repository).obtenerParametroDivisaCodigo(descripcion, valor);
	}
	
	@Override
	public List<ValorParametro> listarDivisasCurvas(String codigo) {
		return ((ValorParametroRepository) repository).listarDivisasCurvas(codigo);
	}
	
	@Override
	public ValorParametro obtenerDescripcionTenor(String descripcion, String codigo) {
		return ((ValorParametroRepository) repository).obtenerDescripcionTenor(descripcion, codigo);
	}
	
	public List<ValorParametro> obtenerCredenciales(String codigo) {
		return ((ValorParametroRepository) repository).obtenerCredenciales(codigo);
	}

	public ValorParametro obtenerParametroValorPais(String codigo, String descripcion) {
		return ((ValorParametroRepository) repository).obtenerParametroValorPais(codigo, descripcion);

	}
	
}
