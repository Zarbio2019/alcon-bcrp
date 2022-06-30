package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteTresC2Repository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteTresC2Service;

@Service
public class ReporteTresC2ServiceImpl implements ReporteTresC2Service {

	@Autowired
	private ReporteTresC2Repository reporteTresC2Repository;
	
	@Override
	public DatatableDTO<ReporteTresC2DTO> searchReportThreeC2(ReporteSearch reporteSearch) {
		return reporteTresC2Repository.searchReportThreeC2(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteTresExcelC2DTO> getExcelReportThreeC2(ReporteSearch reporteSearch) {
		return reporteTresC2Repository.getExcelReportThreeC2(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteTresTxtC2DTO> getTxtReportThreeC2(ReporteSearch reporteSearch) {
		return reporteTresC2Repository.getTxtReportThreeC2(reporteSearch);
	}
	
	@Override
	public List<ReporteTresTxtC2DTO> viewTxtReportThreeC2(ReporteSearch reporteSearch) {
		return reporteTresC2Repository.viewTxtReportThreeC2(reporteSearch);
	}
	
	@Override
	public TablaDinamica<ReporteTresTxtC2DTO> getTxtToExcelReportThreeC2(ReporteSearch reporteSearch) {
		return reporteTresC2Repository.getTxtToExcelReportThreeC2(reporteSearch);
	}
}
