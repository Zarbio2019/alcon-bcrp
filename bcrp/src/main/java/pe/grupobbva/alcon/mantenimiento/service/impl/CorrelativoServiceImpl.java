package pe.grupobbva.alcon.mantenimiento.service.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.entity.Correlativo;
import pe.grupobbva.alcon.mantenimiento.repository.CorrelativoRepository;
import pe.grupobbva.alcon.mantenimiento.service.CorrelativoService;

@Service
public class CorrelativoServiceImpl extends AbstractServiceImpl<Correlativo> implements CorrelativoService {
	
	@Override
	@Transactional
	public String generaCorrelativoCompuesto(String nombre) {
		return ((CorrelativoRepository) repository).generaCorrelativoCompuesto(nombre);
	}

}
