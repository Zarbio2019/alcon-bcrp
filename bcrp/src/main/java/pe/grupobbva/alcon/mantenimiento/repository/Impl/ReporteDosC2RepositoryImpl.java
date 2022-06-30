package pe.grupobbva.alcon.mantenimiento.repository.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteDosC2Repository;

@Repository
public class ReporteDosC2RepositoryImpl implements ReporteDosC2Repository {
	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ReporteDosC2DTO> searchReportTwoC2(ReporteSearch reporteSearch) {
		List<ReporteDosC2DTO> resultados = em.createNamedStoredProcedureQuery("SP_BCR_REPORTE2_LISTAR_C2")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso())
				.setParameter("P_PRODUCTO",	StringUtils.isBlank(reporteSearch.getProducto()) ? "-2" : reporteSearch.getProducto())
				.setParameter("P_DIVISA",StringUtils.isBlank(reporteSearch.getDivisa()) ? "-2" : reporteSearch.getDivisa())
				.getResultList();

		ReporteDosC2DTO totales = new ReporteDosC2DTO();

		Iterator<ReporteDosC2DTO> ReporteDos = resultados.iterator();
		int numregistros = 0;
		while (ReporteDos.hasNext()) {
			numregistros = numregistros + 1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteDos.next().getImporteusd()));
		}

		totales.setImporteusd(totales.getImporteusd().setScale(2, BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= " + numregistros);
		resultados.add(totales);

		return new DatatableDTO<>(reporteSearch.getDraw(), Long.valueOf(resultados.size()),
				resultados);
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteDosExcelC2DTO> getExcelReportTwoC2(ReporteSearch reporteSearch) {

		TablaDinamica<ReporteDosExcelC2DTO> consultaDinamica = new TablaDinamica<ReporteDosExcelC2DTO>();

		List<ReporteDosExcelC2DTO> resultados = em.createNamedStoredProcedureQuery("SP_BCR_REPORTE2_EXCEL_C2")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso())
				.setParameter("P_PRODUCTO",StringUtils.isBlank(reporteSearch.getProducto()) ? "-2" : reporteSearch.getProducto())
				.setParameter("P_DIVISA",StringUtils.isBlank(reporteSearch.getDivisa()) ? "-2" : reporteSearch.getDivisa())
				.getResultList();

		ReporteDosExcelC2DTO totales = new ReporteDosExcelC2DTO();

		Iterator<ReporteDosExcelC2DTO> ReporteDos = resultados.iterator();
		int numregistros = 0;
		while (ReporteDos.hasNext()) {
			numregistros = numregistros + 1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteDos.next().getImporteusd()));
		}

		totales.setImporteusd(totales.getImporteusd().setScale(2, BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= " + numregistros);
		resultados.add(totales);

		consultaDinamica.setColumnas(new ReporteDosExcelC2DTO().headExcel());
		consultaDinamica.setRegistros(resultados);
		return consultaDinamica;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteDosTxtC2DTO> getTxtReportTwoC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteDosTxtC2DTO> consultaDinamica = new TablaDinamica<ReporteDosTxtC2DTO>();

		List<ReporteDosC2DTO> resultados = em.createNamedStoredProcedureQuery("SP_BCR_REPORTE2_LISTAR_C2")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO",
						StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso())
				.setParameter("P_PRODUCTO",
						StringUtils.isBlank(reporteSearch.getProducto()) ? "-2" : reporteSearch.getProducto())
				.setParameter("P_DIVISA",
						StringUtils.isBlank(reporteSearch.getDivisa()) ? "-2" : reporteSearch.getDivisa())
				.getResultList();

		List<ReporteDosTxtC2DTO> ReporteTxt = new ArrayList<ReporteDosTxtC2DTO>();

		Iterator<ReporteDosC2DTO> ReporteDos = resultados.iterator();
		while (ReporteDos.hasNext()) {
			ReporteDosTxtC2DTO newRegister = new ReporteDosTxtC2DTO(ReporteDos.next());
			ReporteTxt.add(newRegister);
		}

		consultaDinamica.setColumnas(new ReporteDosTxtDTO().headTxt(reporteSearch.getFecha(),
				StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso()));

		consultaDinamica.setRegistros(ReporteTxt);

		return consultaDinamica;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteDosTxtC2DTO> viewTxtReportTwoC2(ReporteSearch reporteSearch) {
		List<ReporteDosC2DTO> resultados = em.createNamedStoredProcedureQuery("SP_BCR_REPORTE2_LISTAR_C2")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso())
				.setParameter("P_PRODUCTO",	StringUtils.isBlank(reporteSearch.getProducto()) ? "-2" : reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa()) ? "-2" : reporteSearch.getDivisa())
				.getResultList();

		List<ReporteDosTxtC2DTO> ReporteTxt = new ArrayList<ReporteDosTxtC2DTO>();
		Iterator<ReporteDosC2DTO> ReporteDos = resultados.iterator();
		while (ReporteDos.hasNext()) {
			ReporteDosTxtC2DTO newRegister = new ReporteDosTxtC2DTO(ReporteDos.next());
			ReporteTxt.add(newRegister);
		}
		return ReporteTxt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteDosTxtC2DTO> getTxtToExcelReportTwoC2(ReporteSearch reporteSearch) {
		
		TablaDinamica<ReporteDosTxtC2DTO> consultaDinamica = new TablaDinamica<ReporteDosTxtC2DTO>();
		
		List<ReporteDosC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE2_LISTAR_C2")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso())
				.setParameter("P_PRODUCTO",	StringUtils.isBlank(reporteSearch.getProducto()) ? "-2" : reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa()) ? "-2" : reporteSearch.getDivisa())
				.getResultList();
		List<ReporteDosTxtC2DTO> ReporteTxt = new ArrayList<ReporteDosTxtC2DTO>();
		
		Iterator<ReporteDosC2DTO> ReporteDos = resultados.iterator();
		while(ReporteDos.hasNext()) {
			ReporteDosTxtC2DTO newRegister = new ReporteDosTxtC2DTO(ReporteDos.next());
			if(!StringUtils.isBlank(newRegister.getCodigoreporte())) {
				ReporteTxt.add(newRegister);
			}
		}
		
		 consultaDinamica.setColumnas(new ReporteDosTxtC2DTO().headExcel());
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}

}
