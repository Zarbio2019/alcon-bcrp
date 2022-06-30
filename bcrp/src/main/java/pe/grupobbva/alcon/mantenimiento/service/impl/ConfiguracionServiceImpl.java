package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.entity.Configuracion;
import pe.grupobbva.alcon.mantenimiento.repository.ConfiguracionRepository;
import pe.grupobbva.alcon.mantenimiento.service.ConfiguracionService;

@Service
public class ConfiguracionServiceImpl extends AbstractServiceImpl<Configuracion> implements ConfiguracionService{

	@Override
	public Boolean valida(Integer dia, String hora) {
		Long valida = ((ConfiguracionRepository) repository).valida(hora, dia);
		return valida == 0l ? true : false;
	}

}
