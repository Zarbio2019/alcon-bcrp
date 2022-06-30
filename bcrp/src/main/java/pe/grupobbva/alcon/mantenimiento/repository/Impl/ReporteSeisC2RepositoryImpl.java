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
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteSeisC2Repository;

@Repository
public class ReporteSeisC2RepositoryImpl implements ReporteSeisC2Repository {
	
	@Autowired
	private EntityManager em;
	
	private static final Logger log = LogManager.getLogger();
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ReporteSeisC2DTO> searchReportSixC2(ReporteSearch reporteSearch) {
		List<ReporteSeisC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE6_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO","D")
				.getResultList();

		ReporteSeisC2DTO totales = new ReporteSeisC2DTO();
		
		Iterator<ReporteSeisC2DTO> ReporteSeis = resultados.iterator();
		int numregistros=0;
		while(ReporteSeis.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteSeis.next().getImporteusd()));
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
	public TablaDinamica<ReporteSeisExcelC2DTO> getExcelReportSixC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSeisExcelC2DTO> consultaDinamica = new TablaDinamica<ReporteSeisExcelC2DTO>();
		
		List<ReporteSeisExcelC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE6_EXCEL_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", "D")
				.getResultList();
		 
		ReporteSeisExcelC2DTO totales = new ReporteSeisExcelC2DTO();
		
		Iterator<ReporteSeisExcelC2DTO> ReporteSeis = resultados.iterator();
		int numregistros=0;
		while(ReporteSeis.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteSeis.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
		
		 consultaDinamica.setColumnas(new ReporteSeisExcelC2DTO().headExcel());
		 consultaDinamica.setRegistros(resultados);
		return consultaDinamica;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteSeisTxtC2DTO> getTxtReportSixC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSeisTxtC2DTO> consultaDinamica = new TablaDinamica<ReporteSeisTxtC2DTO>();
		
		List<ReporteSeisC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE6_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", "D")
				.getResultList();
		List<ReporteSeisTxtC2DTO> ReporteTxt = new ArrayList<ReporteSeisTxtC2DTO>();
		
		Iterator<ReporteSeisC2DTO> ReporteSeis = resultados.iterator();
		while(ReporteSeis.hasNext()) {
			ReporteSeisTxtC2DTO newRegister = new ReporteSeisTxtC2DTO(ReporteSeis.next());
			ReporteTxt.add(newRegister);
		}
		
		 consultaDinamica.setColumnas(
				 new ReporteSeisTxtC2DTO()
				 .headTxt(reporteSearch.getFecha())
				 );
		 
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteSeisTxtC2DTO> viewTxtReportSixC2(ReporteSearch reporteSearch) {
		
		List<ReporteSeisC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE6_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", "D")
				.getResultList();
		List<ReporteSeisTxtC2DTO> ReporteTxt = new ArrayList<ReporteSeisTxtC2DTO>();
		
		Iterator<ReporteSeisC2DTO> ReporteSeis = resultados.iterator();
		while(ReporteSeis.hasNext()) {
			ReporteSeisTxtC2DTO newRegister = new ReporteSeisTxtC2DTO(ReporteSeis.next());
			ReporteTxt.add(newRegister);
		}
		
		return ReporteTxt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteSeisTxtC2DTO> getTxtToExcelReportSixC2(ReporteSearch reporteSearch) {
		
		TablaDinamica<ReporteSeisTxtC2DTO> consultaDinamica = new TablaDinamica<ReporteSeisTxtC2DTO>();
		
		List<ReporteSeisC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE6_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", "D")
				.getResultList();
		List<ReporteSeisTxtC2DTO> ReporteTxt = new ArrayList<ReporteSeisTxtC2DTO>();
		
		Iterator<ReporteSeisC2DTO> ReporteSeis = resultados.iterator();
		while(ReporteSeis.hasNext()) {
			ReporteSeisTxtC2DTO newRegister = new ReporteSeisTxtC2DTO(ReporteSeis.next());
			if(!StringUtils.isBlank(newRegister.getCodigoreporte())) {
				ReporteTxt.add(newRegister);
			}
		}
		
		 consultaDinamica.setColumnas(new ReporteSeisTxtC2DTO().headExcel());
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteSeisC2DTO> listReportSixC2(ReporteSearch reporteSearch) {
		List<ReporteSeisC2DTO> resultados;
		
		resultados = em.createNamedStoredProcedureQuery("SP_BCR_REPORTE6_LISTAR_C2")
					.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
					.setParameter("P_TIPOPROCESO", "D")
					.getResultList();
		
		return resultados;
	}

}
