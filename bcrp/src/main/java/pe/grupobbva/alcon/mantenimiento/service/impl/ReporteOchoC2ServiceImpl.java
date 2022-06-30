package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoAnexo8DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoDetalleC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteOchoC2Repository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteOchoC2Service;

@Service
public class ReporteOchoC2ServiceImpl implements ReporteOchoC2Service{

	@Autowired
	private ReporteOchoC2Repository reporteOchoC2Repository;
	
	@Override
	public DatatableDTO<ReporteOchoC2DTO> searchReportEightC2(ReporteSearch reporteSearch) {
		return reporteOchoC2Repository.searchReportEightC2(reporteSearch);
	}

	@Override
	public void generateReportEightC2(ReporteSearch reporteSearch) {
		reporteOchoC2Repository.generateReportEightC2(reporteSearch);
		
	}

	@Override
	public TablaDinamica<ReporteOchoExcelC2DTO> getExcelReportEightC2(ReporteSearch reporteSearch) {
		return reporteOchoC2Repository.getExcelReportEightC2(reporteSearch);
	}

	@Override
	public TablaDinamica<ReporteOchoTxtC2DTO> getTxtReportEightC2(ReporteSearch reporteSearch) {
		return reporteOchoC2Repository.getTxtReportEightC2(reporteSearch);
	}

	@Override
	public List<ReporteOchoTxtC2DTO> viewTxtReportEightC2(ReporteSearch reporteSearch) {
		return reporteOchoC2Repository.viewTxtReportEightC2(reporteSearch);
	}

	@Override
	public List<ReporteOchoDetalleC2DTO> viewDetailReportEightC2(ReporteSearch reporteSearch, String id) {
		return reporteOchoC2Repository.viewDetailReportEightC2(reporteSearch, id);
	}

	@Override
	public TablaDinamica<ReporteOchoDetalleC2DTO> getExcelDetailReportEightC2(ReporteSearch reporteSearch, String id) {
		return reporteOchoC2Repository.getExcelDetailReportEightC2(reporteSearch, id);
	}

	@Override
	public TablaDinamica<ReporteOchoAnexo8DTO> getExcelAnexo8(ReporteSearch reporteSearch, String id) {
		return reporteOchoC2Repository.getExcelAnexo8(reporteSearch, id);
	}
}
