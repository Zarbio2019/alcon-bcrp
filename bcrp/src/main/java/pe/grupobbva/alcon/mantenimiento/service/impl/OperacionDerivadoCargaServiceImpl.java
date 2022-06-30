package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.entity.OperacionDerivadoCarga;
import pe.grupobbva.alcon.mantenimiento.repository.OperacionDerivadoCargaRepository;
import pe.grupobbva.alcon.mantenimiento.service.OperacionDerivadoCargaService;

@Service
public class OperacionDerivadoCargaServiceImpl extends AbstractServiceImpl<OperacionDerivadoCarga> implements OperacionDerivadoCargaService {

	@Override
	public void eliminarOperacionDerivadoCargaPorIdCarga(String idcarga) {
		((OperacionDerivadoCargaRepository) repository).eliminarOperacionDerivadoCargaPorIdCarga(idcarga);
	}
	
}
