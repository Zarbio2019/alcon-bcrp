package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionTasaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.TasaInteresDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.TasaInteresSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportExcelView;
import pe.grupobbva.alcon.mantenimiento.entity.TasaInteres;
import pe.grupobbva.alcon.mantenimiento.service.TasaInteresService;

@RestController
@RequestMapping("/tasainteres")
public class TasaInteresEndpoint extends AbstractRestController<TasaInteres, TasaInteresDTO>{
	
	public TasaInteresEndpoint() {
		super(TasaInteres.class, TasaInteresDTO.class);
	}

	@GetMapping(produces = "application/json")
	public DatatableDTO<OperacionTasaDTO> search(TasaInteresSearch tasaInteresSearch) {
		return ((TasaInteresService) service).search(tasaInteresSearch);
	}
	
	@GetMapping("/unwind")
	public void unwindTasas(TasaInteresSearch tasaInteresSearch) {
		((TasaInteresService) service).unwindTasas(tasaInteresSearch);		
	}
	
	@GetMapping("/anular")
	public void anularTasas(TasaInteresSearch tasaInteresSearch) {
		((TasaInteresService) service).anularTasas(tasaInteresSearch);		
	}

	@GetMapping(path="/generarexcel")
	public ModelAndView generarexcel(TasaInteresSearch tasaInteresSearch) {
		TablaDinamica<OperacionTasaDTO> consulta = ((TasaInteresService) service).generarexcel(tasaInteresSearch);
		return new ModelAndView(new ReportExcelView<OperacionTasaDTO>(consulta, "tasasinteres"));
	}
}
