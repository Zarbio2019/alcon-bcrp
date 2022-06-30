package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.ParametroDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ParametroSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterCode;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterRequestBody;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterTableResponseDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Parametro;
import pe.grupobbva.alcon.mantenimiento.service.ParametroService;

@RestController
@RequestMapping("/parametro")
public class ParametroEndpoint extends AbstractRestController<Parametro, ParametroDTO> {

	public ParametroEndpoint() {
		super(Parametro.class, ParametroDTO.class);
	}
	
	@GetMapping(produces = "application/json")
	public ParameterTableResponseDTO search(ParametroSearch parametroSearch) {
		return ((ParametroService) service).search(parametroSearch);
	}
	
	@GetMapping(path = "detalleparametro/{id}", produces = "application/json")
	public ParameterTableResponseDTO getParameter(@PathVariable String id) {
		return ((ParametroService)service).getParameter(id);
	}
	
	@GetMapping(path = "/nuevaplantilla", produces = "application/json")
	public ParameterTableResponseDTO getTeplateParameter(ParametroSearch parametroSearch) {
		return ((ParametroService)service).getTemplateParameter(parametroSearch);
	} 
	
	@GetMapping("/tipoParametro")
	public SelectOptions<SelectOptionsDTO> typeParameter(){
		return ((ParametroService)service).typeParameter();
	}
	
	/** Crear y editar: detalle y valores de parametros**/
	
	@PostMapping(path="/create", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Void> updatecreate (@RequestBody ParameterRequestBody data){
		return ((ParametroService)service).create(data);
	}
	
	@PutMapping(path = "/update",consumes = "application/json",produces = "application/json" )
	public ResponseEntity<Void> update(@RequestBody ParameterRequestBody data) {
		return ((ParametroService)service).update(data);
	}
	
	/** List para combo **/ 
	
	ParameterCode codigo = new ParameterCode();

	@GetMapping("/posicionCambiaria")
	public SelectOptions<SelectOptionsDTO> exchangePosition(){
		//001
		return ((ParametroService)service).type(codigo.getPosicionCambiaria());
	}
	
	@GetMapping("/tipooperacion")
	public SelectOptions<SelectOptionsDTO> operationType(){	
		//002
		return ((ParametroService)service).type(codigo.getTipoOperacion());
	}
	
	@GetMapping("/tipoentrega")
	public SelectOptions<SelectOptionsDTO> deliveryType(){	
		//003
		return ((ParametroService)service).type(codigo.getTipoEntrega());
	}
	
	@GetMapping("/tipocliente")
	public SelectOptions<SelectOptionsDTO> clientType(){	
		//004
		return ((ParametroService)service).type(codigo.getTipoCliente());
	}
	
	@GetMapping("/tipoResidente")
	public SelectOptions<SelectOptionsDTO> residentType(){	
		//005
		return ((ParametroService)service).type(codigo.getTipoResidente());
	}
	
	@GetMapping("/tipoCallPut")
	public SelectOptions<SelectOptionsDTO> callPutType(){	
		//006
		return ((ParametroService)service).type(codigo.getTipoCallPut());
	}
	
	@GetMapping("/pais")
	public SelectOptions<SelectOptionsDTO> country(){	
		//007
		return ((ParametroService)service).type(codigo.getPais());
	}
	

	@GetMapping("/entidadcliente")
	public SelectOptions<SelectOptionsDTO> entityClient(){	
		//008
		return ((ParametroService)service).type(codigo.getEntidadCliente());
	}
	
	@GetMapping("/cargacliente")
	public SelectOptions<SelectOptionsDTO> loadClient(){	
		//009
		return ((ParametroService)service).type(codigo.getCargaCliente());
	}
	
	@GetMapping("/meses")
	public SelectOptions<SelectOptionsDTO> months(){	
		//010
		return ((ParametroService)service).type(codigo.getMeses());
	}
	
	@GetMapping("/anios")
	public SelectOptions<SelectOptionsDTO> years(){	
		//011
		return ((ParametroService)service).type(codigo.getAnios());
	}
	
	@GetMapping("/tipoferiado")
	public SelectOptions<SelectOptionsDTO> holidayType(){	
		//012
		return ((ParametroService)service).type(codigo.getTipoFeriado());
	}
	
	@GetMapping("/tipoproceso")
	public SelectOptions<SelectOptionsDTO> processType(){	
		//013
		return ((ParametroService)service).type(codigo.getTipoProceso());
	}
	
	@GetMapping("/estadoOperacion")
	public SelectOptions<SelectOptionsDTO> state(){	
		//014
		return ((ParametroService)service).type(codigo.getEstadoOperacion());
	}
	
	@GetMapping("/tipocarga")
	public SelectOptions<SelectOptionsDTO> fileUpload(){	
		//017
		return ((ParametroService)service).type(codigo.getCargaArchivos());
	}

	@GetMapping("/tipoDatoPlantilla")
	public SelectOptions<SelectOptionsDTO> dataTypeTemplate(){	
		//018
		return ((ParametroService)service).type(codigo.getTipoDatoPlantilla());
	}
	
	@GetMapping("/signoPlantilla")
	public SelectOptions<SelectOptionsDTO> templateSign(){	
		//019
		return ((ParametroService)service).type(codigo.getSignoPlantilla());
	}
	
	@GetMapping("/divisa")
	public SelectOptions<SelectOptionsDTO> badge(){	
		//029
		return ((ParametroService)service).type(codigo.getDivisa());
	}
	
	@GetMapping("/tipodocumento")
	public SelectOptions<SelectOptionsDTO> documentType(){	
		//039
		return ((ParametroService)service).type(codigo.getTipoDocumento());
	}
	
	@GetMapping("/archivosanexoocho")
	public SelectOptions<SelectOptionsDTO> annexed(){	
		//048
		return ((ParametroService)service).type(codigo.getArchivosAnexoOcho());
	}
	
}
