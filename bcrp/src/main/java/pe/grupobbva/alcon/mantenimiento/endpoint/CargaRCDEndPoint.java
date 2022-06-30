package pe.grupobbva.alcon.mantenimiento.endpoint;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgFxVigenteDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRFDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRVDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD02DTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD07DTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgSpeFrairDTO;
import pe.grupobbva.alcon.mantenimiento.dto.PreprocesoRCDDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgFxVigenteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgPosRFSearch;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgPosRVSearch;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgRCD02Search;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgRCD07Search;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgSpeFrairSearch;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.RCDpreproceso;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.RcdTxtView;
import pe.grupobbva.alcon.mantenimiento.service.CfgFxVigenteService;
import pe.grupobbva.alcon.mantenimiento.service.CfgPosRFService;
import pe.grupobbva.alcon.mantenimiento.service.CfgPosRVService;
import pe.grupobbva.alcon.mantenimiento.service.CfgRCD02Service;
import pe.grupobbva.alcon.mantenimiento.service.CfgRCD07Service;
import pe.grupobbva.alcon.mantenimiento.service.CfgSpeFrairService;

@RestController
@RequestMapping("/generarRCD")
public class CargaRCDEndPoint {
	
	@Autowired
	private CfgFxVigenteService service;
	
	@Autowired
	private CfgSpeFrairService servicespefrair;
	
	@Autowired
	private CfgPosRVService servicerv;
	
	@Autowired
	private CfgPosRFService servicerf;
	
	@Autowired
	private CfgRCD07Service serviceoptasas;
	
	@Autowired
	private CfgRCD02Service serviceopfx;

	private static final Logger log = LogManager.getLogger();
	
	@PostMapping(path = "upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public  ModelAndView  upload(@RequestParam("fxvigente") MultipartFile fxvigente, @RequestParam("rf") MultipartFile rf,
			@RequestParam("rv") MultipartFile rv, @RequestParam("spefrair") MultipartFile spefrair,
			@RequestParam("optasas") MultipartFile optasas, @RequestParam("opfx") MultipartFile opfx) {
		CfgFxVigenteSearch search = new CfgFxVigenteSearch(0L,0,0);
		CfgSpeFrairSearch searchspefrair = new CfgSpeFrairSearch(0L,0,0);
		CfgPosRVSearch searchrv = new CfgPosRVSearch(0L,0,0);
		CfgPosRFSearch searchrf = new CfgPosRFSearch(0L,0,0);
		CfgRCD07Search searchoptasas = new CfgRCD07Search(0L,0,0);
		CfgRCD02Search searchopfx = new CfgRCD02Search(0L,0,0);
		
		DatatableDTO <CfgFxVigenteDTO> dto = service.search(search);
		DatatableDTO <CfgSpeFrairDTO> dto1 = servicespefrair.search(searchspefrair);
		DatatableDTO <CfgPosRVDTO> dto2 = servicerv.search(searchrv);
		DatatableDTO <CfgPosRFDTO> dto3 = servicerf.search(searchrf);
		DatatableDTO <CfgRCD07DTO> dto4 = serviceoptasas.search(searchoptasas);
		DatatableDTO <CfgRCD02DTO> dto5 = serviceopfx.search(searchopfx);
		// Test
		
		return new ModelAndView(new RcdTxtView(fxvigente,  dto.getData(), spefrair, dto1.getData(),
				rv, dto2.getData(), rf, dto3.getData(), optasas, dto4.getData(), opfx, dto5.getData()));
	}
	
	@PostMapping(path="preprocesoRCD",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<Object> preproc(@RequestParam("fxvigente") MultipartFile fxvigente, @RequestParam("rf") MultipartFile rf,
			@RequestParam("rv") MultipartFile rv, @RequestParam("spefrair") MultipartFile spefrair,
			@RequestParam("optasas") MultipartFile optasas, @RequestParam("opfx") MultipartFile opfx) throws Exception{
		
		CfgFxVigenteSearch search = new CfgFxVigenteSearch(0L,0,0);
		CfgSpeFrairSearch searchspefrair = new CfgSpeFrairSearch(0L,0,0);
		CfgPosRVSearch searchrv = new CfgPosRVSearch(0L,0,0);
		CfgPosRFSearch searchrf = new CfgPosRFSearch(0L,0,0);
		CfgRCD07Search searchoptasas = new CfgRCD07Search(0L,0,0);
		CfgRCD02Search searchopfx = new CfgRCD02Search(0L,0,0);
		
		DatatableDTO <CfgFxVigenteDTO> dto = service.search(search);
		DatatableDTO <CfgSpeFrairDTO> dto1 = servicespefrair.search(searchspefrair);
		DatatableDTO <CfgPosRVDTO> dto2 = servicerv.search(searchrv);
		DatatableDTO <CfgPosRFDTO> dto3 = servicerf.search(searchrf);
		DatatableDTO <CfgRCD07DTO> dto4 = serviceoptasas.search(searchoptasas);
		DatatableDTO <CfgRCD02DTO> dto5 = serviceopfx.search(searchopfx);
		
		RCDpreproceso pre = new RCDpreproceso(fxvigente,  dto.getData(), spefrair, dto1.getData(),
				rv, dto2.getData(), rf, dto3.getData(), optasas, dto4.getData(), opfx, dto5.getData());
		
		
		
		return new ResponseEntity<Object>(pre.getListPreproceso(),HttpStatus.OK);
	}
	
}

