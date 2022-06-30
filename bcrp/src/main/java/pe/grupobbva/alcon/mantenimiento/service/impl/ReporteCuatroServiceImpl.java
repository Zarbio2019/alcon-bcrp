package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroDetalleDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteCuatroRepository;
import pe.grupobbva.alcon.mantenimiento.service.ReporteCuatroService;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.Circular;

@Service
public class ReporteCuatroServiceImpl implements ReporteCuatroService {

	@Autowired
	private ReporteCuatroRepository reporteCuatroRepository;

	@Override
	public DatatableDTO<ReporteCuatroDTO> searchReportFour(ReporteSearch reporteSearch, Circular circular) {
		return reporteCuatroRepository.searchReportFour(reporteSearch,circular);
	}

	@Override
	public ReporteCuatroDTO getReportFour(String id) {
		return reporteCuatroRepository.getReportFour(id);
	}

	@Override
	public void generar(ReporteSearch reporteSearch) {
		reporteCuatroRepository.generar(reporteSearch);
	}
	
	@Override
	public TablaDinamica<ReporteCuatroExcelDTO> getExcelReportFour(ReporteSearch reporteSearch , Circular circular) {
	    return reporteCuatroRepository.getExcelReportFour(reporteSearch,circular);
	}

	@Override
	public TablaDinamica<ReporteCuatroExcelDTO> getPdfReportFour(ReporteSearch reporteSearch, Circular circular) {
		return reporteCuatroRepository.getPdfReportFour(reporteSearch,circular);
	}

	@Override
	public TablaDinamica<ReporteCuatroTxtDTO> getTxtReportFour(ReporteSearch reporteSearch, Circular circular) {
		return reporteCuatroRepository.getTxtReportFour(reporteSearch,circular);
	}

	@Override
	public List<ReporteCuatroTxtDTO> viewTxtReportFour(ReporteSearch reporteSearch, Circular circular) {
		return reporteCuatroRepository.viewTxtReportFour(reporteSearch,circular);
	}

	@Override
	public List<ReporteCuatroDetalleDTO> viewDetailReportFour(ReporteSearch reporteSearch, String id, Circular circular) {
		return reporteCuatroRepository.viewDetailReportFour(reporteSearch, id,circular);
	}

	@Override
	public TablaDinamica<ReporteCuatroDetalleDTO> getExcelDetailReportFour(ReporteSearch reporteSearch, String id, Circular circular) {
		return reporteCuatroRepository.getExcelDetailReportFour(reporteSearch, id,circular);
	}

	@Override
	public TablaDinamica<ReporteCuatroDetalleDTO> getExcelAnexo8(ReporteSearch reporteSearch, String id,
			Circular circular) {
		return reporteCuatroRepository.getExcelAnexo8(reporteSearch, id,circular);
	}
	
}
