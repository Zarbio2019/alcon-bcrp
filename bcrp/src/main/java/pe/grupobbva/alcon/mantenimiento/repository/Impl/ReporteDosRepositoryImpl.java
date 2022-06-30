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
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteDosRepository;

@Repository
public class ReporteDosRepositoryImpl implements ReporteDosRepository{
	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ReporteDosDTO> searchReportTwo(ReporteSearch reporteSearch) {
		List<ReporteDosDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE2_LISTAR")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		
		ReporteDosDTO totales = new ReporteDosDTO();
		
		Iterator<ReporteDosDTO> ReporteDos = resultados.iterator();
		int numregistros=0;
		while(ReporteDos.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteDos.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
		
		return new DatatableDTO<>(
				reporteSearch.getDraw(),
				Long.valueOf(resultados.size()),
					resultados
				);
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteDosExcelDTO> getExcelReportTwo(ReporteSearch reporteSearch) {
		
		TablaDinamica<ReporteDosExcelDTO> consultaDinamica = new TablaDinamica<ReporteDosExcelDTO>();
		
		List<ReporteDosExcelDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE2_EXCEL")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		
		ReporteDosExcelDTO totales = new ReporteDosExcelDTO();
		
		Iterator<ReporteDosExcelDTO> ReporteDos = resultados.iterator();
		int numregistros=0;
		while(ReporteDos.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteDos.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
		
		consultaDinamica.setColumnas(new ReporteDosExcelDTO().headExcel());
		 consultaDinamica.setRegistros(resultados);
		return consultaDinamica;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteDosTxtDTO> getTxtReportTwo(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteDosTxtDTO> consultaDinamica = new TablaDinamica<ReporteDosTxtDTO>();
		
		List<ReporteDosDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE2_LISTAR")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		
		List<ReporteDosTxtDTO> ReporteTxt = new ArrayList<ReporteDosTxtDTO>();
		
		Iterator<ReporteDosDTO> ReporteDos = resultados.iterator();
		while(ReporteDos.hasNext()) {
			ReporteDosTxtDTO newRegister = new ReporteDosTxtDTO(ReporteDos.next());
			ReporteTxt.add(newRegister);
		}
		
		 consultaDinamica.setColumnas(
				 new ReporteDosTxtDTO()
				 .headTxt(reporteSearch.getFecha(), StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				 );
		 
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteDosTxtDTO> viewTxtReportTwo(ReporteSearch reporteSearch) {
		List<ReporteDosDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE2_LISTAR")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		
		List<ReporteDosTxtDTO> ReporteTxt = new ArrayList<ReporteDosTxtDTO>();
		Iterator<ReporteDosDTO> ReporteDos = resultados.iterator();
		while(ReporteDos.hasNext()) {
			ReporteDosTxtDTO newRegister = new ReporteDosTxtDTO(ReporteDos.next());
			ReporteTxt.add(newRegister);
		}
		return ReporteTxt;
	}
	
}
