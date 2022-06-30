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

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCincoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCincoExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCincoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCincoUpdateDeltaC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteCincoC2Repository;

@Repository
public class ReporteCincoC2RepositoryImpl implements ReporteCincoC2Repository{
	@Autowired
	private EntityManager em;

	private static final Logger log = LogManager.getLogger();
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ReporteCincoC2DTO> searchReportFiveC2(ReporteSearch reporteSearch) {
		List<ReporteCincoC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE5_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				.getResultList();
		
		List<ReporteCincoUpdateDeltaC2DTO> resultadosUpdateDelta = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE5_UPDATEDELTA_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.getResultList();
		
		//Actualizamos Los Delta
		for(ReporteCincoC2DTO reportecincoc2:resultados ) {
			for(ReporteCincoUpdateDeltaC2DTO reportecincoupdt:resultadosUpdateDelta) {
				if(reportecincoc2.getNumerooperacion().equals(reportecincoupdt.getNumerooperacion())) {
					reportecincoc2.updtReporteCincoC2DTO(reportecincoupdt);
				}
			}
		}
		
		return new DatatableDTO<>(
				reporteSearch.getDraw(),
				Long.valueOf(resultados != null ? resultados.size(): 0),
				Utils.paginador(resultados, reporteSearch)
				);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteCincoExcelC2DTO> getExcelReportFiveC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCincoExcelC2DTO> consultaDinamica = new TablaDinamica<ReporteCincoExcelC2DTO>();
		
		List<ReporteCincoC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE5_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				.getResultList();
		
		List<ReporteCincoUpdateDeltaC2DTO> resultadosUpdateDelta = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE5_UPDATEDELTA_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.getResultList();
		
		//Actualizamos Los Delta
		for(ReporteCincoC2DTO reportecincoc2:resultados ) {
			for(ReporteCincoUpdateDeltaC2DTO reportecincoupdt:resultadosUpdateDelta) {
				if(reportecincoc2.getNumerooperacion().equals(reportecincoupdt.getNumerooperacion())) {
					reportecincoc2.updtReporteCincoC2DTO(reportecincoupdt);
				}
			}
		}
		
		//Agrego totales 
		
		ReporteCincoC2DTO totales = new ReporteCincoC2DTO();
						
		Iterator<ReporteCincoC2DTO> ReporteCincoTotal = resultados.iterator();
		int numregistros=0;
		while(ReporteCincoTotal.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteCincoTotal.next().getImporteusd()));
		}
						
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
				
		//Agrego resultados a Excel
		List<ReporteCincoExcelC2DTO> ReporteTxt = new ArrayList<ReporteCincoExcelC2DTO>();
		
		Iterator<ReporteCincoC2DTO> ReporteCinco= resultados.iterator();
		while(ReporteCinco.hasNext()) {
			ReporteCincoExcelC2DTO newRegister = new ReporteCincoExcelC2DTO(ReporteCinco.next());
			ReporteTxt.add(newRegister);
		}
		
		log.info("respuesta: "+ ReporteTxt);
		consultaDinamica.setColumnas(new ReporteCincoExcelC2DTO().headerExcel());
		 consultaDinamica.setRegistros(ReporteTxt);
		
		return consultaDinamica;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteCincoTxtC2DTO> getTxtReportFiveC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCincoTxtC2DTO> consultaDinamica = new TablaDinamica<ReporteCincoTxtC2DTO>();
		
		List<ReporteCincoC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE5_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				.getResultList();
		
		List<ReporteCincoUpdateDeltaC2DTO> resultadosUpdateDelta = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE5_UPDATEDELTA_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.getResultList();
		
		//Actualizamos Los Delta
		for(ReporteCincoC2DTO reportecincoc2:resultados ) {
			for(ReporteCincoUpdateDeltaC2DTO reportecincoupdt:resultadosUpdateDelta) {
				if(reportecincoc2.getNumerooperacion().equals(reportecincoupdt.getNumerooperacion())) {
					reportecincoc2.updtReporteCincoC2DTO(reportecincoupdt);
				}
			}
		}
				
		//Agrego formato TXT
		List<ReporteCincoTxtC2DTO> ReporteTxt = new ArrayList<ReporteCincoTxtC2DTO>();
		
		Iterator<ReporteCincoC2DTO> ReporteCincoC2 = resultados.iterator();
		while(ReporteCincoC2.hasNext()) {
			ReporteCincoTxtC2DTO newRegister = new ReporteCincoTxtC2DTO(ReporteCincoC2.next());
			ReporteTxt.add(newRegister);
		}
		
		consultaDinamica.setColumnas(
				 new ReporteCincoTxtC2DTO()
				 .headTxt(reporteSearch.getFecha(), StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				 );
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteCincoTxtC2DTO> getTxtToExcelReportFiveC2(ReporteSearch reporteSearch) {
		
		TablaDinamica<ReporteCincoTxtC2DTO> consultaDinamica = new TablaDinamica<ReporteCincoTxtC2DTO>();
		
		List<ReporteCincoC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE5_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				.getResultList();
		List<ReporteCincoTxtC2DTO> ReporteTxt = new ArrayList<ReporteCincoTxtC2DTO>();
		
		Iterator<ReporteCincoC2DTO> ReporteCinco= resultados.iterator();
		while(ReporteCinco.hasNext()) {
			ReporteCincoTxtC2DTO newRegister = new ReporteCincoTxtC2DTO(ReporteCinco.next());
			if(!StringUtils.isBlank(newRegister.getCodigoreporte())) {
				ReporteTxt.add(newRegister);
			}
		}
		
		 consultaDinamica.setColumnas(new ReporteCincoTxtC2DTO().headExcel());
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}

}
