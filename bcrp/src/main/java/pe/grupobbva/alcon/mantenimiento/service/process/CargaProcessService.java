package pe.grupobbva.alcon.mantenimiento.service.process;

import java.io.InputStream;

import pe.grupobbva.alcon.mantenimiento.entity.Carga;

/**
 * @author P027968
 * 
 * 
 * 
 */
public interface CargaProcessService {
	
	public void procesarCarga(Carga carga, InputStream file,String filename, Integer tipoCarga);
	
}
