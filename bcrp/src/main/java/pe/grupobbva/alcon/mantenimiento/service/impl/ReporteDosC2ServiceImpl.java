package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteDosC2Repository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteDosC2Service;


@Service
public class ReporteDosC2ServiceImpl implements ReporteDosC2Service{

	@Autowired
	private ReporteDosC2Repository reporteDosC2Repository;
	
	@Override
	public DatatableDTO<ReporteDosC2DTO> searchReportTwoC2(ReporteSearch reporteSearch) {
		return reporteDosC2Repository.searchReportTwoC2(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteDosExcelC2DTO> getExcelReportTwoC2(ReporteSearch reporteSearch) {
		return reporteDosC2Repository.getExcelReportTwoC2(reporteSearch); 
	}

	@Override
	public List<ReporteDosTxtC2DTO> viewTxtReportTwoC2(ReporteSearch reporteSearch) {
		return reporteDosC2Repository.viewTxtReportTwoC2(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteDosTxtC2DTO> getTxtReportTwoC2(ReporteSearch reporteSearch) {
		return reporteDosC2Repository.getTxtReportTwoC2(reporteSearch);
	}
	
	@Override
	public TablaDinamica<ReporteDosTxtC2DTO> getTxtToExcelReportTwoC2(ReporteSearch reporteSearch) {
		return reporteDosC2Repository.getTxtToExcelReportTwoC2(reporteSearch);
	}
}
