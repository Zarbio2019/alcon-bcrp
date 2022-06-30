package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuadreDiarioExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteCuadreDiarioRepository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteCuadreDiarioService;

@Service
public class ReporteCuadreDiarioServiceImpl implements ReporteCuadreDiarioService{

	@Autowired
	private ReporteCuadreDiarioRepository reporteCuadreDiarioRepository;
	
	@Override
	public TablaDinamica<ReporteCuadreDiarioExcelDTO> getExcelReport(ReporteSearch reporteSearch) {
		return reporteCuadreDiarioRepository.getExcelReport(reporteSearch);
	}

}
