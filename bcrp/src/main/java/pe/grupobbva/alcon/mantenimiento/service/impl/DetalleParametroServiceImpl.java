package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.entity.DetalleParametro;
import pe.grupobbva.alcon.mantenimiento.repository.DetalleParametroRepository;
import pe.grupobbva.alcon.mantenimiento.service.DetalleParametroService;

@Service
public class DetalleParametroServiceImpl extends AbstractServiceImpl<DetalleParametro> implements DetalleParametroService{

	@Override
	public List<DetalleParametro> listarCuentas(String codigo) {
		return ((DetalleParametroRepository) repository).listarCuentas(codigo);
	}
	
	@Override
	public List<String> listarCurvas(String codigo) {
		return ((DetalleParametroRepository) repository).listarCurvas(codigo);
	}
	
	@Override
	public List<DetalleParametro> listarTenor(String codigo) {
		return ((DetalleParametroRepository) repository).listarTenor(codigo);
	}
	
}
