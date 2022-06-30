package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.mantenimiento.entity.Correlativo;

public interface CorrelativoService extends AbstractService<Correlativo> {
	
	public String generaCorrelativoCompuesto(String nombre);

}
