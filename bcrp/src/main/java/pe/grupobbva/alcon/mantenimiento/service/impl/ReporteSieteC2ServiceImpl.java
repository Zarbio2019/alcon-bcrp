package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSieteC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSieteExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSieteTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteSieteC2Repository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteSieteC2Service;

@Service
public class ReporteSieteC2ServiceImpl implements ReporteSieteC2Service {
	
	@Autowired
	private ReporteSieteC2Repository reporteSieteC2Repository;
	
	@Override
	public DatatableDTO<ReporteSieteC2DTO> searchReportSevenC2(ReporteSearch reporteSearch) {
		return reporteSieteC2Repository.searchReportSevenC2(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteSieteExcelC2DTO> getExcelReportSevenC2(ReporteSearch reporteSearch) {
		return reporteSieteC2Repository.getExcelReportSevenC2(reporteSearch); 
	}
	
	@Override
	public TablaDinamica<ReporteSieteTxtC2DTO> getTxtReportSevenC2(ReporteSearch reporteSearch) {
		return reporteSieteC2Repository.getTxtReportSevenC2(reporteSearch);
	}
	
	@Override
	public List<ReporteSieteTxtC2DTO> viewTxtReportSevenC2(ReporteSearch reporteSearch) {
		return reporteSieteC2Repository.viewTxtReportSevenC2(reporteSearch);
	}
	
	@Override
	public TablaDinamica<ReporteSieteTxtC2DTO> getTxtToExcelReportSevenC2(ReporteSearch reporteSearch) {
		return reporteSieteC2Repository.getTxtToExcelReportSevenC2(reporteSearch);
	}
	
	@Override
	public List<ReporteSieteC2DTO> listReportSevenC2(ReporteSearch reporteSearch) {
		return reporteSieteC2Repository.listReportSevenC2(reporteSearch);
	}

}