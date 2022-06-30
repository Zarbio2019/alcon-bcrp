package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteSeisC2Repository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteSeisC2Service;

@Service
public class ReporteSeisC2ServiceImpl implements ReporteSeisC2Service {
	
	@Autowired
	private ReporteSeisC2Repository reporteSeisC2Repository;
	
	@Override
	public DatatableDTO<ReporteSeisC2DTO> searchReportSixC2(ReporteSearch reporteSearch) {
		return reporteSeisC2Repository.searchReportSixC2(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteSeisExcelC2DTO> getExcelReportSixC2(ReporteSearch reporteSearch) {
		return reporteSeisC2Repository.getExcelReportSixC2(reporteSearch); 
	}
	
	@Override
	public TablaDinamica<ReporteSeisTxtC2DTO> getTxtReportSixC2(ReporteSearch reporteSearch) {
		return reporteSeisC2Repository.getTxtReportSixC2(reporteSearch);
	}
	
	@Override
	public List<ReporteSeisTxtC2DTO> viewTxtReportSixC2(ReporteSearch reporteSearch) {
		return reporteSeisC2Repository.viewTxtReportSixC2(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteSeisTxtC2DTO> getTxtToExcelReportSixC2(ReporteSearch reporteSearch) {
		return reporteSeisC2Repository.getTxtToExcelReportSixC2(reporteSearch);
	}
	
	@Override
	public List<ReporteSeisC2DTO> listReportSixC2(ReporteSearch reporteSearch) {
		return reporteSeisC2Repository.listReportSixC2(reporteSearch);
	}
}

