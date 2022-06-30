package pe.grupobbva.alcon.mantenimiento.dto.util;

import java.util.Map;

import lombok.Data;

@Data
public abstract class AbstractFile {

	
	private String filename;
	
	private String contenttype;
	
	private Map<String, String> metadata;
	
	
}
