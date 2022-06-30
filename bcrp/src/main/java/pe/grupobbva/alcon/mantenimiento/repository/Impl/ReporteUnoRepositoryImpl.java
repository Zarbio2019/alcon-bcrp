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
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteUnoRepository;

@Repository
public class ReporteUnoRepositoryImpl implements ReporteUnoRepository {

	@Autowired
	private EntityManager em;
	
	private static final Logger log = LogManager.getLogger();
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ReporteUnoDTO> searchReportOne(ReporteSearch reporteSearch) {
		List<ReporteUnoDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE1_LISTAR")
				.setParameter("P_FECHACONTRATACION", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		
	
		ReporteUnoDTO totales = new ReporteUnoDTO();
		
		Iterator<ReporteUnoDTO> ReporteUno = resultados.iterator();
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
				Long.valueOf(resultados.size()),
				resultados
				);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteUnoExcelDTO> getExcelReportOne(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteUnoExcelDTO> consultaDinamica = new TablaDinamica<ReporteUnoExcelDTO>();
		
		List<ReporteUnoExcelDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE1_EXCEL")
				.setParameter("P_FECHACONTRATACION", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		 
		ReporteUnoExcelDTO totales = new ReporteUnoExcelDTO();
		
		Iterator<ReporteUnoExcelDTO> ReporteUno = resultados.iterator();
		int numregistros=0;
		while(ReporteUno.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteUno.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
		
		 consultaDinamica.setColumnas(new ReporteUnoExcelDTO().headExcel());
		 consultaDinamica.setRegistros(resultados);
		return consultaDinamica;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteUnoTxtDTO> getTxtReportOne(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteUnoTxtDTO> consultaDinamica = new TablaDinamica<ReporteUnoTxtDTO>();
		
		List<ReporteUnoDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE1_LISTAR")
				.setParameter("P_FECHACONTRATACION", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		List<ReporteUnoTxtDTO> ReporteTxt = new ArrayList<ReporteUnoTxtDTO>();
		
		Iterator<ReporteUnoDTO> ReporteUno = resultados.iterator();
		while(ReporteUno.hasNext()) {
			ReporteUnoTxtDTO newRegister = new ReporteUnoTxtDTO(ReporteUno.next());
			if(!StringUtils.isBlank(newRegister.getCodigoreporte())) {
				ReporteTxt.add(newRegister);
			}
		}
		
		 consultaDinamica.setColumnas(
				 new ReporteUnoTxtDTO()
				 .headTxt(reporteSearch.getFecha(), StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				 );
		 
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteUnoTxtDTO> viewTxtReportOne(ReporteSearch reporteSearch) {
		
		List<ReporteUnoDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE1_LISTAR")
				.setParameter("P_FECHACONTRATACION", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.setParameter("P_PRODUCTO", StringUtils.isBlank(reporteSearch.getProducto())?"-2":reporteSearch.getProducto())
				.setParameter("P_DIVISA", StringUtils.isBlank(reporteSearch.getDivisa())?"-2":reporteSearch.getDivisa())
				.getResultList();
		List<ReporteUnoTxtDTO> ReporteTxt = new ArrayList<ReporteUnoTxtDTO>();
		
		Iterator<ReporteUnoDTO> ReporteUno = resultados.iterator();
		while(ReporteUno.hasNext()) {
			ReporteUnoTxtDTO newRegister = new ReporteUnoTxtDTO(ReporteUno.next());
			if(!StringUtils.isBlank(newRegister.getCodigoreporte())) {
				ReporteTxt.add(newRegister);
			}
		}
		
		return ReporteTxt;
	}

}
