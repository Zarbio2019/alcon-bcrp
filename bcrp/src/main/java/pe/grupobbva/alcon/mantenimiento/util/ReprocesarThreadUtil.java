package pe.grupobbva.alcon.mantenimiento.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.grupobbva.alcon.mantenimiento.service.process.CargaInforReportDiarioService;

@Component
@Scope("prototype") 
//@Transactional
public class ReprocesarThreadUtil implements Runnable {
	
	private static final Logger log = LogManager.getLogger();
	
	private String idcarga;
	
	
	@Autowired
	private CargaInforReportDiarioService cargaInforReportDiarioService;
	
	public void load(String idcarga) {
		this.idcarga=idcarga;
		
	}
	
	@Override
	public void run() {
		log.info("Reprocesando : "+idcarga);
		cargaInforReportDiarioService.reprocesar(idcarga);
    }



	

}