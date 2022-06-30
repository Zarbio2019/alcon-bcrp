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
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroDetalleDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoAnexo8DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoDetalleC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoTxtC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteOchoC2Repository;

@Repository
public class ReporteOchoC2RepositoryImpl implements ReporteOchoC2Repository{

	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ReporteOchoC2DTO> searchReportEightC2(ReporteSearch reporteSearch) {
		List<ReporteOchoC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE8_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.getResultList();
		
		return new DatatableDTO<>(
				reporteSearch.getDraw(),
				Long.valueOf(resultados.size()),
				resultados
				);
	}

	@Override
	public void generateReportEightC2(ReporteSearch reporteSearch) {

		em.createNamedStoredProcedureQuery("SP_BCR_MSD_INICIALIZAR")
		  .setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
		  .setParameter("P_USUARIO", "System") 
		  .execute();
		
		em.createNamedStoredProcedureQuery("SP_BCR_MSD_CALCULOMONTOS")
		  .setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
		  .execute();
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteOchoExcelC2DTO> getExcelReportEightC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteOchoExcelC2DTO> consultaDinamica = new TablaDinamica<ReporteOchoExcelC2DTO>();
		List<ReporteOchoC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE8_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.getResultList();
		 
		List<ReporteOchoExcelC2DTO> ReporteExcel = new ArrayList<ReporteOchoExcelC2DTO>();
		Iterator<ReporteOchoC2DTO> ReporteOcho = resultados.iterator();
		
		while(ReporteOcho.hasNext()) {
			ReporteOchoExcelC2DTO newRegister = new ReporteOchoExcelC2DTO(ReporteOcho.next());
			ReporteExcel.add(newRegister);
		}
		
		 consultaDinamica.setColumnas(new ReporteOchoExcelC2DTO().headExcel());
		 consultaDinamica.setRegistros(ReporteExcel);
		 
		return consultaDinamica;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteOchoTxtC2DTO> getTxtReportEightC2(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteOchoTxtC2DTO> consultaDinamica = new TablaDinamica<ReporteOchoTxtC2DTO>();
		List<ReporteOchoC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE8_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.getResultList();
		
		List<ReporteOchoTxtC2DTO> ReporteTxt = new ArrayList<ReporteOchoTxtC2DTO>();
		Iterator<ReporteOchoC2DTO> ReporteOcho = resultados.iterator();
		
		while(ReporteOcho.hasNext()) {
			ReporteOchoTxtC2DTO newRegister = new ReporteOchoTxtC2DTO(ReporteOcho.next());
			ReporteTxt.add(newRegister);
		}
		
		 consultaDinamica.setColumnas(
				 new ReporteOchoTxtC2DTO()
				 .headTxt(reporteSearch.getFecha())
				 );
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteOchoTxtC2DTO> viewTxtReportEightC2(ReporteSearch reporteSearch) {
		List<ReporteOchoC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE8_LISTAR_C2")
				.setParameter("P_FECHAMOVIMIENTO", reporteSearch.getFecha())
				.getResultList();
		
		List<ReporteOchoTxtC2DTO> listTxtDTO = new ArrayList<ReporteOchoTxtC2DTO>();
		Iterator<ReporteOchoC2DTO> ReporteOcho = resultados.iterator();
		
		while(ReporteOcho.hasNext()) {
			ReporteOchoTxtC2DTO newRegister = new ReporteOchoTxtC2DTO(ReporteOcho.next());
			listTxtDTO.add(newRegister);
		}
		
		 return listTxtDTO;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteOchoDetalleC2DTO> viewDetailReportEightC2(ReporteSearch reporteSearch, String id) {
		List<ReporteOchoDetalleC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE8_OPERACIONES")
				.setParameter("P_IDSALDODERIVADOS", StringUtils.isBlank(id)?"0":id)
				.setParameter("P_FECHA", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", "D")
				.getResultList();
		
		ReporteOchoDetalleC2DTO totales = new ReporteOchoDetalleC2DTO();
		
		Iterator<ReporteOchoDetalleC2DTO> ReporteCuatro = resultados.iterator();
		int numregistros=0;
		while(ReporteCuatro.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteCuatro.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
		
		return resultados;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteOchoDetalleC2DTO> getExcelDetailReportEightC2(ReporteSearch reporteSearch, String id) {

		TablaDinamica<ReporteOchoDetalleC2DTO> consultaDinamica = new TablaDinamica<ReporteOchoDetalleC2DTO>();
		
		List<ReporteOchoDetalleC2DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE8_OPERACIONES")
				.setParameter("P_IDSALDODERIVADOS", StringUtils.isBlank(id)?"0":id)
				.setParameter("P_FECHA", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.getResultList();
		
		ReporteOchoDetalleC2DTO totales = new ReporteOchoDetalleC2DTO();
		
		Iterator<ReporteOchoDetalleC2DTO> ReporteCuatro = resultados.iterator();
		int numregistros=0;
		while(ReporteCuatro.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteCuatro.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
		
		consultaDinamica.setColumnas(new ReporteOchoDetalleC2DTO().headExcel());
		consultaDinamica.setRegistros(resultados);
		
		return consultaDinamica;
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteOchoAnexo8DTO> getExcelAnexo8(ReporteSearch reporteSearch, String id) {
		
		TablaDinamica<ReporteOchoAnexo8DTO> consultaDinamica = new TablaDinamica<ReporteOchoAnexo8DTO>();
		
		List<ReporteOchoAnexo8DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE8_ANEXO8")
				.setParameter("P_IDSALDODERIVADOS", StringUtils.isBlank(id)?"0":id)
				.setParameter("P_FECHA", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
				.getResultList();
		
		ReporteOchoAnexo8DTO totales = new ReporteOchoAnexo8DTO();
		
		Iterator<ReporteOchoAnexo8DTO> ReporteCuatro = resultados.iterator();
		int numregistros=0;
		while(ReporteCuatro.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteCuatro.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
		
		consultaDinamica.setColumnas(new ReporteOchoAnexo8DTO().headExcel());
		consultaDinamica.setRegistros(resultados);
		
		return consultaDinamica;
	}
	
}
