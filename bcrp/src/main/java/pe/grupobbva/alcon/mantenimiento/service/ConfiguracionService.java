package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.mantenimiento.entity.Configuracion;

public interface ConfiguracionService extends AbstractService<Configuracion> {

	public Boolean valida(Integer dia, String hora);
}
