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
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisUpdateDeltaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteSeisRepository;

@Repository
public class ReporteSeisRepositoryImpl  implements ReporteSeisRepository{

	@Autowired
	private EntityManager em;

	private static final Logger log = LogManager.getLogger();
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ReporteSeisDTO> searchReportSix(ReporteSearch reporteSearch) {
		List<ReporteSeisDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE6_LISTAR")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				.getResultList();
		
		List<ReporteSeisUpdateDeltaDTO> resultadosUpdateDelta = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE6_UPDATEDELTA")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.getResultList();
		
		//Actualizamos Los Delta
		for(ReporteSeisDTO reporteseis:resultados ) {
			for(ReporteSeisUpdateDeltaDTO reporteseisupdt:resultadosUpdateDelta) {
				if(reporteseis.getNumerooperacion().equals(reporteseisupdt.getNumerooperacion())) {
					reporteseis.updtReporteSeisDTO(reporteseisupdt);
				}
			}
		}
		
		ReporteSeisDTO totales = new ReporteSeisDTO();
		
		Iterator<ReporteSeisDTO> ReporteSeis = resultados.iterator();
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
	public TablaDinamica<ReporteSeisExcelDTO> getExcelReportSix(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSeisExcelDTO> consultaDinamica = new TablaDinamica<ReporteSeisExcelDTO>();
		
		List<ReporteSeisDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE6_LISTAR")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				.getResultList();
		
		List<ReporteSeisUpdateDeltaDTO> resultadosUpdateDelta = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE6_UPDATEDELTA")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.getResultList();
		
		//Actualizamos Los Delta
		for(ReporteSeisDTO reporteseis:resultados ) {
			for(ReporteSeisUpdateDeltaDTO reporteseisupdt:resultadosUpdateDelta) {
				if(reporteseis.getNumerooperacion().equals(reporteseisupdt.getNumerooperacion())) {
					reporteseis.updtReporteSeisDTO(reporteseisupdt);
				}
			}
		}
		
		
		//Agrego totales 
		
		ReporteSeisDTO totales = new ReporteSeisDTO();
		
		Iterator<ReporteSeisDTO> ReporteSeisTotal = resultados.iterator();
		int numregistros=0;
		while(ReporteSeisTotal.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteSeisTotal.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
		
		//Agrego resultados a Excel
		List<ReporteSeisExcelDTO> ReporteExcel = new ArrayList<ReporteSeisExcelDTO>();
		
		Iterator<ReporteSeisDTO> ReporteSeis= resultados.iterator();
		while(ReporteSeis.hasNext()) {
			ReporteSeisExcelDTO newRegister = new ReporteSeisExcelDTO(ReporteSeis.next());
			ReporteExcel.add(newRegister);
		}
		
		log.info("respuesta: "+ ReporteExcel);
		consultaDinamica.setColumnas(new ReporteSeisExcelDTO().headerExcel());
		 consultaDinamica.setRegistros(ReporteExcel);
		
		return consultaDinamica;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteSeisTxtDTO> getTxtReportSix(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteSeisTxtDTO> consultaDinamica = new TablaDinamica<ReporteSeisTxtDTO>();
		
		List<ReporteSeisDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE6_LISTAR")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				.getResultList();
		
		List<ReporteSeisUpdateDeltaDTO> resultadosUpdateDelta = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE6_UPDATEDELTA")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.getResultList();
		
		//Actualizamos Los Delta
		for(ReporteSeisDTO reporteseis:resultados ) {
			for(ReporteSeisUpdateDeltaDTO reporteseisupdt:resultadosUpdateDelta) {
				if(reporteseis.getNumerooperacion().equals(reporteseisupdt.getNumerooperacion())) {
					reporteseis.updtReporteSeisDTO(reporteseisupdt);
				}
			}
		}
		
		//Agrego formato TXT
		List<ReporteSeisTxtDTO> ReporteTxt = new ArrayList<ReporteSeisTxtDTO>();
		
		Iterator<ReporteSeisDTO> ReporteSeis = resultados.iterator();
		while(ReporteSeis.hasNext()) {
			ReporteSeisTxtDTO newRegister = new ReporteSeisTxtDTO(ReporteSeis.next());
			ReporteTxt.add(newRegister);
		}
		
		consultaDinamica.setColumnas(
				 new ReporteSeisTxtDTO()
				 .headTxt(reporteSearch.getFecha(), StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				 );
		 
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
		
	}
}
