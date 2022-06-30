package pe.grupobbva.alcon.mantenimiento.endpoint.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pe.grupobbva.alcon.mantenimiento.dto.custom.FiltroReporte;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.FiltroReporteResponse;
import pe.grupobbva.alcon.mantenimiento.service.ReportFilterService;

public class ReportFilter  {
	
	@Autowired
	private ReportFilterService reportFilterService;
	
	@GetMapping(path = "/filtros", produces = "application/json")
	public FiltroReporteResponse getFilter(FiltroReporte filtro) {
		return reportFilterService.getFilter(filtro);
	}
	
}
