package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCincoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCincoExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCincoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteCincoC2Repository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteCincoC2Service;

@Service
public class ReporteCincoC2ServiceImpl implements ReporteCincoC2Service {

	@Autowired
	private ReporteCincoC2Repository reporteCincoC2Repository;

	@Override
	public DatatableDTO<ReporteCincoC2DTO> searchReportFiveC2(ReporteSearch reporteSearch) {
		return reporteCincoC2Repository.searchReportFiveC2(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteCincoExcelC2DTO> getExcelReportFiveC2(ReporteSearch reporteSearch) {
		return reporteCincoC2Repository.getExcelReportFiveC2(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteCincoTxtC2DTO> getTxtReportFiveC2(ReporteSearch reporteSearch) {
		return reporteCincoC2Repository.getTxtReportFiveC2(reporteSearch);
	}
	
	@Override
	public TablaDinamica<ReporteCincoTxtC2DTO> getTxtToExcelReportFiveC2(ReporteSearch reporteSearch) {
		return reporteCincoC2Repository.getTxtToExcelReportFiveC2(reporteSearch);
	}
}
