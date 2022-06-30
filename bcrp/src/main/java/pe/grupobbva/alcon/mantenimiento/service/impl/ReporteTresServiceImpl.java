package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteTresRepository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteTresService;

@Service
public class ReporteTresServiceImpl implements ReporteTresService {

	@Autowired
	private ReporteTresRepository reporteTresRepository;
	
	@Override
	public DatatableDTO<ReporteTresDTO> searchReportThree(ReporteSearch reporteSearch) {
		return reporteTresRepository.searchReportThree(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteTresExcelDTO> getExcelReportThree(ReporteSearch reporteSearch) {
		return reporteTresRepository.getExcelReportThree(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteTresTxtDTO> getTxtReportThree(ReporteSearch reporteSearch) {
		return reporteTresRepository.getTxtReportThree(reporteSearch);
	}

	@Override
	public List<ReporteTresTxtDTO> viewTxtReportThree(ReporteSearch reporteSearch) {
		return reporteTresRepository.viewTxtReportThree(reporteSearch);
	}

}
