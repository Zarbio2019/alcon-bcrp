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
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteTresC2Repository;

@Repository
public class ReporteTresC2RepositoryImpl implements ReporteTresC2Repository{
	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ReporteTresC2DTO> searchReportThreeC2(ReporteSearch reporteSearch) {
		
		List<ReporteTresC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE3_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto()) ? "-2" : reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa()) ? "-2" : reporteSearch.getDivisa())
				.setParameter("P_TIPOVISTA", 0)
				.getResultList();
		
		ReporteTresC2DTO totales = new ReporteTresC2DTO();
		
		Iterator<ReporteTresC2DTO> ReporteTresC2 = resultados.iterator();
		int numregistros=0;
		
		while(ReporteTresC2.hasNext()) {
			numregistros = numregistros + 1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteTresC2.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2, BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= " + numregistros);
		resultados.add(totales);
		
		return new DatatableDTO<>(
				reporteSearch.getDraw(),
				Long.valueOf(resultados.size()),
				resultados
				);
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteTresExcelC2DTO> getExcelReportThreeC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteTresExcelC2DTO> consultaDinamica = new TablaDinamica<ReporteTresExcelC2DTO>();
		
		List<ReporteTresExcelC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE3_EXCEL_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso())
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto()) ? "-2" : reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa()) ? "-2" : reporteSearch.getDivisa())
				.getResultList();
		 
		ReporteTresExcelC2DTO totales = new ReporteTresExcelC2DTO();
		
		Iterator<ReporteTresExcelC2DTO> ReporteTresC2 = resultados.iterator();
		int numregistros = 0;
		
		while(ReporteTresC2.hasNext()) {
			numregistros = numregistros + 1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteTresC2.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2, BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= " + numregistros);
		resultados.add(totales);
		
		 consultaDinamica.setColumnas(new ReporteTresExcelC2DTO().headExcel());
		 consultaDinamica.setRegistros(resultados);
		return consultaDinamica;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteTresTxtC2DTO> getTxtReportThreeC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteTresTxtC2DTO> consultaDinamica = new TablaDinamica<ReporteTresTxtC2DTO>();
		
		List<ReporteTresC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE3_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso())
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto()) ? "-2" : reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa()) ? "-2" :reporteSearch.getDivisa())
				.setParameter("P_TIPOVISTA", 1)
				.getResultList();
		List<ReporteTresTxtC2DTO> ReporteTxt = new ArrayList<ReporteTresTxtC2DTO>();
		
		Iterator<ReporteTresC2DTO> ReporteTres = resultados.iterator();
		while(ReporteTres.hasNext()) {
			ReporteTresTxtC2DTO newRegister = new ReporteTresTxtC2DTO(ReporteTres.next());
			ReporteTxt.add(newRegister);
		}
		
		 consultaDinamica.setColumnas(
				 new ReporteTresTxtDTO()
				 .headTxt(reporteSearch.getFecha(), StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso())
				 );
		 
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteTresTxtC2DTO> viewTxtReportThreeC2(ReporteSearch reporteSearch) {
		List<ReporteTresC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE3_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso())
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto()) ? "-2" : reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa()) ? "-2" : reporteSearch.getDivisa())
				.setParameter("P_TIPOVISTA", 1)
				.getResultList();
		List<ReporteTresTxtC2DTO> ReporteTxt = new ArrayList<ReporteTresTxtC2DTO>();
		
		Iterator<ReporteTresC2DTO> ReporteTres = resultados.iterator();
		while(ReporteTres.hasNext()) {
			ReporteTresTxtC2DTO newRegister = new ReporteTresTxtC2DTO(ReporteTres.next());
			ReporteTxt.add(newRegister);
		}
		return ReporteTxt;
	}
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteTresTxtC2DTO> getTxtToExcelReportThreeC2(ReporteSearch reporteSearch) {
		
		TablaDinamica<ReporteTresTxtC2DTO> consultaDinamica = new TablaDinamica<ReporteTresTxtC2DTO>();
		
		List<ReporteTresC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE3_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto()) ? "-2" : reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa()) ? "-2" : reporteSearch.getDivisa())
				.setParameter("P_TIPOVISTA", 1)
				.getResultList();
		List<ReporteTresTxtC2DTO> ReporteTxt = new ArrayList<ReporteTresTxtC2DTO>();
		
		Iterator<ReporteTresC2DTO> ReporteTres = resultados.iterator();
		while(ReporteTres.hasNext()) {
			ReporteTresTxtC2DTO newRegister = new ReporteTresTxtC2DTO(ReporteTres.next());
			if(!StringUtils.isBlank(newRegister.getCodigoreporte())) {
				ReporteTxt.add(newRegister);
			}
		}
		
		 consultaDinamica.setColumnas(new ReporteTresTxtC2DTO().headExcel());
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}

}
