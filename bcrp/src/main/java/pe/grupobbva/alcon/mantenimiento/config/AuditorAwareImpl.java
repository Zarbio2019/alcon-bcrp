package pe.grupobbva.alcon.mantenimiento.config;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareImpl implements AuditorAware<String>{
	
	@Autowired
	private UsuarioActivo usuarioActivo;
	
	private static final Logger log = LogManager.getLogger();

	
	@Override
	public Optional<String> getCurrentAuditor() {
		try {
			return Optional.of(usuarioActivo.getUser());
		} catch (Exception e) {
			return Optional.of("System");
		} 
		
		
		
	}
	

	
}
