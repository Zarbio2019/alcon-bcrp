package pe.grupobbva.alcon.mantenimiento.quartz;

import java.io.FileInputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.service.ValorParametroService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaCodigoStarAltamiraService;

public class ExecuteJob extends QuartzJobBean {

	protected final Logger log = LogManager.getLogger(getClass());

	@Autowired
	private CargaCodigoStarAltamiraService cargaCodigoCentralAltamiraService;
	
	@Autowired
	private ValorParametroService valorParametroService;

	@Override
	protected void executeInternal(JobExecutionContext arg) throws JobExecutionException {
		log.info("Inicio de Job");
		
		String rutacarpeta = valorParametroService.obtenerParametroPorCodigo("045", "Ruta Carpeta").getValor();
		String filename = valorParametroService.obtenerParametroPorCodigo("046", "Nombre Archivo").getValor();

		try (FileInputStream file = new FileInputStream(rutacarpeta.concat(filename))){
			Carga carga = new Carga();

			cargaCodigoCentralAltamiraService.procesarCarga(carga, file, filename, 0);
		} catch (Exception e) {
			log.error("descargarArchivo - error : {} ", e.getMessage());

		} 
		
	}

}
