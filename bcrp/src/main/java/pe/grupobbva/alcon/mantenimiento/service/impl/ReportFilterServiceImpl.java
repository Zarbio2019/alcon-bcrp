package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.dto.custom.FiltroReporte;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.FiltroReporteResponse;
import pe.grupobbva.alcon.mantenimiento.repository.ReportFilterRepository;
import pe.grupobbva.alcon.mantenimiento.service.ReportFilterService;

@Service
public class ReportFilterServiceImpl implements ReportFilterService{

	@Autowired
	private ReportFilterRepository reportFilterRepository;
	
	@Override
	public FiltroReporteResponse getFilter(FiltroReporte filtro) {
		return reportFilterRepository.getFilter(filtro);
	}

}
