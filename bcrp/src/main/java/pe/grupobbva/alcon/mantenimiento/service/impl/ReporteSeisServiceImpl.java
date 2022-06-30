package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteSeisRepository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteSeisService;

@Service
public class ReporteSeisServiceImpl implements ReporteSeisService {

	@Autowired
	private ReporteSeisRepository reporteSeisRepository;

	@Override
	public DatatableDTO<ReporteSeisDTO> searchReportSix(ReporteSearch reporteSearch) {
		return reporteSeisRepository.searchReportSix(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteSeisExcelDTO> getExcelReportSix(ReporteSearch reporteSearch) {
		return reporteSeisRepository.getExcelReportSix(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteSeisTxtDTO> getTxtReportSix(ReporteSearch reporteSearch) {
		return reporteSeisRepository.getTxtReportSix(reporteSearch);
	}
}
