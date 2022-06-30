package pe.grupobbva.alcon.mantenimiento.endpoint;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.mantenimiento.endpoint.util.RfCsvView;

@RestController
@RequestMapping("/generarRF")
public class GenerarRFEndPoint {
	
	private static final Logger log = LogManager.getLogger();
	
	@PostMapping(path = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ModelAndView generarRF(@RequestParam("rfespana") MultipartFile rfespana, @RequestParam("rf") MultipartFile rf)  {
			
	       
	       
		return new ModelAndView(new RfCsvView(rfespana, rf));
	}

}
