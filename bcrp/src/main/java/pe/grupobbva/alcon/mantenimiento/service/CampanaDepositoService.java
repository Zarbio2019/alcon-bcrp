package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.mantenimiento.entity.CampanaDeposito;

public interface CampanaDepositoService extends AbstractService<CampanaDeposito> {

	public void eliminarCampanaDepositoPorIdCarga(String idcarga);
	
}
