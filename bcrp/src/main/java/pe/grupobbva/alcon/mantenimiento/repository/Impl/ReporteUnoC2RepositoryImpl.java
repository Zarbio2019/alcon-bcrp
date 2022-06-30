package pe.grupobbva.alcon.mantenimiento.repository.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteUnoC2Repository;

@Repository
public class ReporteUnoC2RepositoryImpl implements ReporteUnoC2Repository {
	
	@Autowired
	private EntityManager em;
	
	private static final Logger log = LogManager.getLogger();
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ReporteUnoC2DTO> searchReportOneC2(ReporteSearch reporteSearch) {
		List<ReporteUnoC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE1_LISTAR_C2")
				.setParameter("P_FECHACONTRATACION", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		
	
		ReporteUnoC2DTO totales = new ReporteUnoC2DTO();
		
		Iterator<ReporteUnoC2DTO> ReporteUno = resultados.iterator();
		int numregistros=0;
		while(ReporteUno.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteUno.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
		
		return new DatatableDTO<>(
				reporteSearch.getDraw(),
				Long.valueOf( resultados.size() ),
				resultados
				);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteUnoExcelC2DTO> getExcelReportOneC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteUnoExcelC2DTO> consultaDinamica = new TablaDinamica<ReporteUnoExcelC2DTO>();
		
		List<ReporteUnoExcelC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE1_EXCEL_C2")
				.setParameter("P_FECHACONTRATACION", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		 
		ReporteUnoExcelC2DTO totales = new ReporteUnoExcelC2DTO();
		
		Iterator<ReporteUnoExcelC2DTO> ReporteUno = resultados.iterator();
		int numregistros=0;
		while(ReporteUno.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteUno.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
		
		 consultaDinamica.setColumnas(new ReporteUnoExcelC2DTO().headExcel());
		 consultaDinamica.setRegistros(resultados);
		return consultaDinamica;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteUnoTxtC2DTO> getTxtReportOneC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteUnoTxtC2DTO> consultaDinamica = new TablaDinamica<ReporteUnoTxtC2DTO>();
		
		List<ReporteUnoC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE1_LISTAR_C2")
				.setParameter("P_FECHACONTRATACION", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		List<ReporteUnoTxtC2DTO> ReporteTxt = new ArrayList<ReporteUnoTxtC2DTO>();
		
		Iterator<ReporteUnoC2DTO> ReporteUno = resultados.iterator();
		while(ReporteUno.hasNext()) {
			ReporteUnoTxtC2DTO newRegister = new ReporteUnoTxtC2DTO(ReporteUno.next());
			if(!StringUtils.isBlank(newRegister.getCodigoreporte())) {
				ReporteTxt.add(newRegister);
			}
		}
		
		 consultaDinamica.setColumnas(
				 new ReporteUnoTxtC2DTO()
				 .headTxt(reporteSearch.getFecha(), StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				 );
		 
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteUnoTxtC2DTO> viewTxtReportOneC2(ReporteSearch reporteSearch) {
		
		List<ReporteUnoC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE1_LISTAR_C2")
				.setParameter("P_FECHACONTRATACION", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		List<ReporteUnoTxtC2DTO> ReporteTxt = new ArrayList<ReporteUnoTxtC2DTO>();
		
		Iterator<ReporteUnoC2DTO> ReporteUno = resultados.iterator();
		while(ReporteUno.hasNext()) {
			ReporteUnoTxtC2DTO newRegister = new ReporteUnoTxtC2DTO(ReporteUno.next());
			if(!StringUtils.isBlank(newRegister.getCodigoreporte())) {
				ReporteTxt.add(newRegister);
			}
		}
		
		return ReporteTxt;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteUnoTxtC2DTO> getTxtToExcelReportOneC2(ReporteSearch reporteSearch) {
		
		TablaDinamica<ReporteUnoTxtC2DTO> consultaDinamica = new TablaDinamica<ReporteUnoTxtC2DTO>();
		
		List<ReporteUnoC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE1_LISTAR_C2")
				.setParameter("P_FECHACONTRATACION", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		List<ReporteUnoTxtC2DTO> ReporteTxt = new ArrayList<ReporteUnoTxtC2DTO>();
		
		Iterator<ReporteUnoC2DTO> ReporteUno = resultados.iterator();
		while(ReporteUno.hasNext()) {
			ReporteUnoTxtC2DTO newRegister = new ReporteUnoTxtC2DTO(ReporteUno.next());
			if(!StringUtils.isBlank(newRegister.getCodigoreporte())) {
				ReporteTxt.add(newRegister);
			}
		}
		
		 consultaDinamica.setColumnas(new ReporteUnoTxtC2DTO().headExcel());
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteUnoC2DTO> listReportOneC2(ReporteSearch reporteSearch) {
		List<ReporteUnoC2DTO> resultados;
		
		resultados = em.createNamedStoredProcedureQuery("SP_BCR_REPORTE1_LISTAR_C2")
					.setParameter("P_FECHACONTRATACION", reporteSearch.getFecha())
					.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso())
					.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto()) ? "-2" : reporteSearch.getProducto())
					.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa()) ? "-2" : reporteSearch.getDivisa())
					.getResultList();
		
		return resultados;
	}

}
