package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.entity.Delta;
import pe.grupobbva.alcon.mantenimiento.repository.DeltaRepository;
import pe.grupobbva.alcon.mantenimiento.service.DeltaService;

@Service
public class DeltaServiceImpl extends AbstractServiceImpl<Delta> implements DeltaService {

	
	
	@Override
	public void copiarUltimo(Calendar fecha) {
		DeltaRepository deltaRepository = (DeltaRepository) repository;

		List<Delta> deltas = deltaRepository.tipoCambioPorfecha(fecha);

		if (deltas.isEmpty()) {

			deltas = deltaRepository.ultimoTipoCambioPorfecha(fecha);
			
			for (Delta delta : deltas) {
				Delta nuevoDelta = new Delta();
				nuevoDelta.setNumerooperacion(delta.getNumerooperacion());
				nuevoDelta.setDescripcion(delta.getDescripcion());
				nuevoDelta.setCobertura(delta.getCobertura());
				nuevoDelta.setDeltas(delta.getDeltas());
				nuevoDelta.setImporte(delta.getImporte());
				nuevoDelta.setFechaproceso(fecha);
				nuevoDelta.setCodigoestado(delta.getCodigoestado());
				
				deltaRepository.save(nuevoDelta);
			}
		}

	}

	@Override
	@Transactional
	public void eliminarCarga(Calendar fecha) {
		DeltaRepository deltaRepository = (DeltaRepository) repository;
		deltaRepository.eliminarCarga(fecha);
		
	}
}
