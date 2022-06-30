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
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSieteC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSieteExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSieteTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteSieteC2Repository;

@Repository
public class ReporteSieteC2RepositoryImpl implements ReporteSieteC2Repository {
	
	@Autowired
	private EntityManager em;
	
	private static final Logger log = LogManager.getLogger();
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ReporteSieteC2DTO> searchReportSevenC2(ReporteSearch reporteSearch) {
		List<ReporteSieteC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE7_LISTAR_C2")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", "D")
				.getResultList();
		
	
		ReporteSieteC2DTO totales = new ReporteSieteC2DTO();
		
		Iterator<ReporteSieteC2DTO> ReporteSiete = resultados.iterator();
		int numregistros = 0;
		while(ReporteSiete.hasNext()) {
			numregistros = numregistros + 1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteSiete.next().getImporteusd()));
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
	public TablaDinamica<ReporteSieteExcelC2DTO> getExcelReportSevenC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSieteExcelC2DTO> consultaDinamica = new TablaDinamica<ReporteSieteExcelC2DTO>();
		
		List<ReporteSieteExcelC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE7_EXCEL_C2")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.getResultList();
		 
		ReporteSieteExcelC2DTO totales = new ReporteSieteExcelC2DTO();
		
		Iterator<ReporteSieteExcelC2DTO> ReporteSiete = resultados.iterator();
		int numregistros=0;
		while(ReporteSiete.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteSiete.next().getImporteusd()));
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
	public TablaDinamica<ReporteSieteTxtC2DTO> getTxtReportSevenC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSieteTxtC2DTO> consultaDinamica = new TablaDinamica<ReporteSieteTxtC2DTO>();
		
		List<ReporteSieteC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE7_LISTAR_C2")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.getResultList();
		List<ReporteSieteTxtC2DTO> ReporteTxt = new ArrayList<ReporteSieteTxtC2DTO>();
		
		Iterator<ReporteSieteC2DTO> ReporteSiete = resultados.iterator();
		while(ReporteSiete.hasNext()) {
			ReporteSieteTxtC2DTO newRegister = new ReporteSieteTxtC2DTO(ReporteSiete.next());
			if(!StringUtils.isBlank(newRegister.getCodigoreporte())) {
				ReporteTxt.add(newRegister);
			}
		}
		
		 consultaDinamica.setColumnas(
				 new ReporteSieteTxtC2DTO()
				 .headTxt(reporteSearch.getFecha())
				 );
		 
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteSieteTxtC2DTO> viewTxtReportSevenC2(ReporteSearch reporteSearch) {
		
		List<ReporteSieteC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE7_LISTAR_C2")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.getResultList();
		List<ReporteSieteTxtC2DTO> ReporteTxt = new ArrayList<ReporteSieteTxtC2DTO>();
		
		Iterator<ReporteSieteC2DTO> ReporteSeis = resultados.iterator();
		while(ReporteSeis.hasNext()) {
			ReporteSieteTxtC2DTO newRegister = new ReporteSieteTxtC2DTO(ReporteSeis.next());
			if(!StringUtils.isBlank(newRegister.getCodigoreporte())) {
				ReporteTxt.add(newRegister);
			}
		}
		
		return ReporteTxt;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteSieteTxtC2DTO> getTxtToExcelReportSevenC2(ReporteSearch reporteSearch) {
		
		TablaDinamica<ReporteSieteTxtC2DTO> consultaDinamica = new TablaDinamica<ReporteSieteTxtC2DTO>();
		
		List<ReporteSieteC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE7_LISTAR_C2")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", "D")
				.getResultList();
		List<ReporteSieteTxtC2DTO> ReporteTxt = new ArrayList<ReporteSieteTxtC2DTO>();
		
		Iterator<ReporteSieteC2DTO> ReporteSiete = resultados.iterator();
		while(ReporteSiete.hasNext()) {
			ReporteSieteTxtC2DTO newRegister = new ReporteSieteTxtC2DTO(ReporteSiete.next());
			if(!StringUtils.isBlank(newRegister.getCodigoreporte())) {
				ReporteTxt.add(newRegister);
			}
		}
		
		 consultaDinamica.setColumnas(new ReporteSieteTxtC2DTO().headExcel());
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteSieteC2DTO> listReportSevenC2(ReporteSearch reporteSearch) {
		List<ReporteSieteC2DTO> resultados;
		
		resultados = em.createNamedStoredProcedureQuery("SP_BCR_REPORTE7_LISTAR_C2")
					.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
					.setParameter("P_TIPOPROCESO", "D")
					.getResultList();
		
		return resultados;
	}

}
