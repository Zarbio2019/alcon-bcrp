package pe.grupobbva.alcon.mantenimiento.service;

import java.util.Calendar;

import pe.grupobbva.alcon.mantenimiento.entity.Delta;

public interface DeltaService extends AbstractService<Delta> {

	public void copiarUltimo(Calendar fecha);
	public void eliminarCarga(Calendar fecha);
	
}
