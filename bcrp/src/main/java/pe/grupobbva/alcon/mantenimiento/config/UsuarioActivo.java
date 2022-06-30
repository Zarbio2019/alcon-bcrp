package pe.grupobbva.alcon.mantenimiento.config;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class UsuarioActivo {
	
	private String user;
	private Set<String> roles=new HashSet<>();
}
