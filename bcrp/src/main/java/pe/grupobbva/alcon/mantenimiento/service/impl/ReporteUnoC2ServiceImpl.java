package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteUnoC2Repository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteUnoC2Service;

@Service
public class ReporteUnoC2ServiceImpl  implements ReporteUnoC2Service {
	
	@Autowired
	private ReporteUnoC2Repository reporteUnoC2Repository;
	
	@Override
	public DatatableDTO<ReporteUnoC2DTO> searchReportOneC2(ReporteSearch reporteSearch) {
		return reporteUnoC2Repository.searchReportOneC2(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteUnoExcelC2DTO> getExcelReportOneC2(ReporteSearch reporteSearch) {
		return reporteUnoC2Repository.getExcelReportOneC2(reporteSearch); 
	}
	
	@Override
	public TablaDinamica<ReporteUnoTxtC2DTO> getTxtReportOneC2(ReporteSearch reporteSearch) {
		return reporteUnoC2Repository.getTxtReportOneC2(reporteSearch);
	}
	
	@Override
	public List<ReporteUnoTxtC2DTO> viewTxtReportOneC2(ReporteSearch reporteSearch) {
		return reporteUnoC2Repository.viewTxtReportOneC2(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteUnoTxtC2DTO> getTxtToExcelReportOneC2(ReporteSearch reporteSearch) {
		return reporteUnoC2Repository.getTxtToExcelReportOneC2(reporteSearch);
	}
	
	@Override
	public List<ReporteUnoC2DTO> listReportOneC2(ReporteSearch reporteSearch) {
		return reporteUnoC2Repository.listReportOneC2(reporteSearch);
	}

}
