package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.entity.CodigoStarAltamira;
import pe.grupobbva.alcon.mantenimiento.repository.CodigoStarAltamiraRepository;
import pe.grupobbva.alcon.mantenimiento.service.CodigoStarAltamiraService;

@Service
public class CodigoStarAltamiraServiceImpl extends AbstractServiceImpl<CodigoStarAltamira> implements CodigoStarAltamiraService {

	@Override
	@Transactional
	public void eliminarCodigoStarAltamira() {
		((CodigoStarAltamiraRepository) repository).eliminarCodigoStarAltamira();
	}
	
	@Override
	public List<CodigoStarAltamira> getCodigosStarAltamira() {
		return ((CodigoStarAltamiraRepository) repository).getCodigosStarAltamira();
	}
	
	@Override
	public CodigoStarAltamira obtenerCodigoAltamiraPorCliente(String codigo, Integer codigoestado) {
		return ((CodigoStarAltamiraRepository) repository).obtenerCodigoAltamiraPorCliente(codigo, codigoestado);
	}

}
