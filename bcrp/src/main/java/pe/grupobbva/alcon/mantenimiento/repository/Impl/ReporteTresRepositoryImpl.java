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
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteTresTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteTresRepository;

@Repository
public class ReporteTresRepositoryImpl implements ReporteTresRepository{
	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ReporteTresDTO> searchReportThree(ReporteSearch reporteSearch) {
		
		List<ReporteTresDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE3_LISTAR")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		
		ReporteTresDTO totales = new ReporteTresDTO();
		
		Iterator<ReporteTresDTO> ReporteTres = resultados.iterator();
		int numregistros=0;
		
		while(ReporteTres.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteTres.next().getImporteusd()));
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
	public TablaDinamica<ReporteTresExcelDTO> getExcelReportThree(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteTresExcelDTO> consultaDinamica = new TablaDinamica<ReporteTresExcelDTO>();
		
		List<ReporteTresExcelDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE3_EXCEL")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		 
		ReporteTresExcelDTO totales = new ReporteTresExcelDTO();
		
		Iterator<ReporteTresExcelDTO> ReporteTres = resultados.iterator();
		int numregistros=0;
		
		while(ReporteTres.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteTres.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
		
		 consultaDinamica.setColumnas(new ReporteTresExcelDTO().headExcel());
		 consultaDinamica.setRegistros(resultados);
		return consultaDinamica;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteTresTxtDTO> getTxtReportThree(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteTresTxtDTO> consultaDinamica = new TablaDinamica<ReporteTresTxtDTO>();
		
		List<ReporteTresDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE3_LISTAR")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		List<ReporteTresTxtDTO> ReporteTxt = new ArrayList<ReporteTresTxtDTO>();
		
		Iterator<ReporteTresDTO> ReporteTres = resultados.iterator();
		while(ReporteTres.hasNext()) {
			ReporteTresTxtDTO newRegister = new ReporteTresTxtDTO(ReporteTres.next());
			ReporteTxt.add(newRegister);
		}
		
		 consultaDinamica.setColumnas(
				 new ReporteTresTxtDTO()
				 .headTxt(reporteSearch.getFecha(), StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				 );
		 
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteTresTxtDTO> viewTxtReportThree(ReporteSearch reporteSearch) {
		List<ReporteTresDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE3_LISTAR")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		List<ReporteTresTxtDTO> ReporteTxt = new ArrayList<ReporteTresTxtDTO>();
		
		Iterator<ReporteTresDTO> ReporteTres = resultados.iterator();
		while(ReporteTres.hasNext()) {
			ReporteTresTxtDTO newRegister = new ReporteTresTxtDTO(ReporteTres.next());
			ReporteTxt.add(newRegister);
		}
		return ReporteTxt;
	}

}
