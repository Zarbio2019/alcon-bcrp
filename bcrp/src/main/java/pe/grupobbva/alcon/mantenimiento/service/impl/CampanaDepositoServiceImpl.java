package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.entity.CampanaDeposito;
import pe.grupobbva.alcon.mantenimiento.repository.CampanaDepositoRepository;
import pe.grupobbva.alcon.mantenimiento.service.CampanaDepositoService;

@Service
public class CampanaDepositoServiceImpl extends AbstractServiceImpl<CampanaDeposito> implements CampanaDepositoService {

	@Override
	public void eliminarCampanaDepositoPorIdCarga(String idcarga) {
		((CampanaDepositoRepository) repository).eliminarCampanaDepositoPorIdCarga(idcarga);
	}
	
}
