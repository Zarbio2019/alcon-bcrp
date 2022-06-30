package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.mantenimiento.entity.OperacionDerivadoCarga;

public interface OperacionDerivadoCargaService extends AbstractService<OperacionDerivadoCarga> {

	public void eliminarOperacionDerivadoCargaPorIdCarga(String idcarga);
	
}
