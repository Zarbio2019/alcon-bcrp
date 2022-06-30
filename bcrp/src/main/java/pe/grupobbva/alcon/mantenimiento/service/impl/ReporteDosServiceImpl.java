package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteDosRepository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteDosService;


@Service
public class ReporteDosServiceImpl implements ReporteDosService{

	@Autowired
	private ReporteDosRepository reporteDosRepository;
	
	@Override
	public DatatableDTO<ReporteDosDTO> searchReportTwo(ReporteSearch reporteSearch) {
		return reporteDosRepository.searchReportTwo(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteDosExcelDTO> getExcelReportTwo(ReporteSearch reporteSearch) {
		return reporteDosRepository.getExcelReportTwo(reporteSearch); 
	}

	@Override
	public TablaDinamica<ReporteDosTxtDTO> getTxtReportTwo(ReporteSearch reporteSearch) {
		return reporteDosRepository.getTxtReportTwo(reporteSearch);
	}

	@Override
	public List<ReporteDosTxtDTO> viewTxtReportTwo(ReporteSearch reporteSearch) {
		return reporteDosRepository.viewTxtReportTwo(reporteSearch);
	}
	
}
