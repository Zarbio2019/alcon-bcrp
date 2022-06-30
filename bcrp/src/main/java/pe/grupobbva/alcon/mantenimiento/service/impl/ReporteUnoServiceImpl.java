package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteUnoRepository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteUnoService;

@Service
public class ReporteUnoServiceImpl implements ReporteUnoService {

	@Autowired
	private ReporteUnoRepository reporteUnoRepository;
	
	@Override
	public DatatableDTO<ReporteUnoDTO> searchReportOne(ReporteSearch reporteSearch) {
		return reporteUnoRepository.searchReportOne(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteUnoExcelDTO> getExcelReportOne(ReporteSearch reporteSearch) {
		return reporteUnoRepository.getExcelReportOne(reporteSearch); 
	}

	@Override
	public TablaDinamica<ReporteUnoTxtDTO> getTxtReportOne(ReporteSearch reporteSearch) {
		return reporteUnoRepository.getTxtReportOne(reporteSearch);
	}

	@Override
	public List<ReporteUnoTxtDTO> viewTxtReportOne(ReporteSearch reporteSearch) {
		return reporteUnoRepository.viewTxtReportOne(reporteSearch);
	}

}
