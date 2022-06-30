package pe.grupobbva.alcon.mantenimiento.repository.Impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.DetalleParametroDTO;
import pe.grupobbva.alcon.mantenimiento.dto.TransactionDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroDetalleDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroPosicionCambiariaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroTxtDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteCuatroRepository;
import pe.grupobbva.alcon.mantenimiento.repository.TransactionRepository;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.Circular;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleParametro;
import pe.grupobbva.alcon.mantenimiento.entity.Transaction;

@Repository
public class ReporteCuatroRepositoryImpl implements ReporteCuatroRepository{
	
	private static final Logger log = LogManager.getLogger();
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private AbstractRestController<Transaction, TransactionDTO> Transaction;
	@Autowired
	private TransactionRepository transactionRepository;
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ReporteCuatroDTO> searchReportFour(ReporteSearch reporteSearch, Circular circular) {
		List<ReporteCuatroDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_LISTAR")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				.setParameter("P_CIRCULAR", circular.toString())
				.getResultList();
		
		return new DatatableDTO<>(
				reporteSearch.getDraw(),
				Long.valueOf(resultados.size()),
				resultados
				);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ReporteCuatroDTO getReportFour(String id) {
		List<ReporteCuatroDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_ID")
				.setParameter("P_ID", id)
				.getResultList();
		return resultados.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteCuatroExcelDTO> getExcelReportFour(ReporteSearch reporteSearch, Circular circular) {
		TablaDinamica<ReporteCuatroExcelDTO> consultaDinamica = new TablaDinamica<ReporteCuatroExcelDTO>();
		List<ReporteCuatroExcelDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_EXCEL")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				.setParameter("P_CIRCULAR", circular.toString())
				.getResultList();
		 
		 consultaDinamica.setColumnas(new ReporteCuatroExcelDTO().head());
		 consultaDinamica.setRegistros(resultados);
		 
		return consultaDinamica;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteCuatroExcelDTO> getPdfReportFour(ReporteSearch reporteSearch, Circular circular) {
		TablaDinamica<ReporteCuatroExcelDTO> consultaDinamica = new TablaDinamica<ReporteCuatroExcelDTO>();
		List<ReporteCuatroExcelDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_EXCEL")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				.setParameter("P_CIRCULAR", circular.toString())
				.getResultList();
		 
		 consultaDinamica.setColumnas(new ReporteCuatroExcelDTO().head());
		 consultaDinamica.setRegistros(resultados);
		 
		return consultaDinamica;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteCuatroTxtDTO> getTxtReportFour(ReporteSearch reporteSearch, Circular circular) {
		
		TablaDinamica<ReporteCuatroTxtDTO> consultaDinamica = new TablaDinamica<ReporteCuatroTxtDTO>();
		List<ReporteCuatroExcelDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_EXCEL")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				.setParameter("P_CIRCULAR", circular.toString())
				.getResultList();
		
		List<ReporteCuatroTxtDTO> ReporteTxt = new ArrayList<ReporteCuatroTxtDTO>();
		Iterator<ReporteCuatroExcelDTO> ReporteCuatro = resultados.iterator();
		
		while(ReporteCuatro.hasNext()) {
			ReporteCuatroTxtDTO newRegister = new ReporteCuatroTxtDTO(ReporteCuatro.next(), circular);
			
			if(circular.equals(Circular.C1) && !newRegister.getCodigo().equals("10000099") && !newRegister.getCodigo().equals("09400099")) {
				ReporteTxt.add(newRegister);
			}else if(circular.equals(Circular.C2)){
				ReporteTxt.add(newRegister);
			}
			
		}
		
		 consultaDinamica.setColumnas(
				 new ReporteCuatroTxtDTO()
				 .headTxt(reporteSearch.getFecha(), StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				 );
		 consultaDinamica.setRegistros(ReporteTxt);
		 
		return consultaDinamica;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteCuatroTxtDTO> viewTxtReportFour(ReporteSearch reporteSearch, Circular circular) {
		
		List<ReporteCuatroExcelDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_EXCEL")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso())
				.setParameter("P_CIRCULAR", circular.toString())
				.getResultList();
		
		
		List<ReporteCuatroTxtDTO> listTxtDTO = new ArrayList<ReporteCuatroTxtDTO>();
		Iterator<ReporteCuatroExcelDTO> ReporteCuatro = resultados.iterator();
		
		while(ReporteCuatro.hasNext()) {
			
			ReporteCuatroTxtDTO newRegister = new ReporteCuatroTxtDTO(ReporteCuatro.next(), circular);
			
			if(circular.equals(Circular.C1) && !newRegister.getCodigo().equals("10000099") && !newRegister.getCodigo().equals("09400099")) {
				listTxtDTO.add(newRegister);
			}else if(circular.equals(Circular.C2)){
				listTxtDTO.add(newRegister);
			}
		}
		
		 return listTxtDTO;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ReporteCuatroDetalleDTO> viewDetailReportFour(ReporteSearch reporteSearch, String id, Circular circular) {
		List<ReporteCuatroDetalleDTO> resultados = new ArrayList<ReporteCuatroDetalleDTO>();
		
		if(circular.equals(Circular.C1)) {
			resultados = 
					em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_OPERACIONES")
					.setParameter("P_IDPOSICIONCAMBIARIA", StringUtils.isBlank(id)?"0":id)
					.setParameter("P_FECHA", reporteSearch.getFecha())
					.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
					.getResultList();
			
		}else if(circular.equals(Circular.C2)) {
			List<ReporteCuatroPosicionCambiariaDTO> listpc = 
					em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_IDPC")
					.setParameter("P_IDPOSICIONCAMBIARIA", StringUtils.isBlank(id)?"0":id)
					.getResultList();
			
			Iterator<ReporteCuatroPosicionCambiariaDTO> pc = listpc.iterator();
			
			while(pc.hasNext()) {
				String idpc = pc.next().getIdposicioncambiaria();
				resultados.addAll(
						em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_OPERACIONES")
						.setParameter("P_IDPOSICIONCAMBIARIA", StringUtils.isBlank(idpc)?"0":idpc)
						.setParameter("P_FECHA", reporteSearch.getFecha())
						.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
						.getResultList()
						);
			}
		}
		
		ReporteCuatroDetalleDTO totales = new ReporteCuatroDetalleDTO();
		
		Iterator<ReporteCuatroDetalleDTO> ReporteCuatro = resultados.iterator();
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
	public TablaDinamica<ReporteCuatroDetalleDTO> getExcelDetailReportFour(ReporteSearch reporteSearch, String id, Circular circular) {

		TablaDinamica<ReporteCuatroDetalleDTO> consultaDinamica = new TablaDinamica<ReporteCuatroDetalleDTO>();
		
		List<ReporteCuatroDetalleDTO> resultados = new ArrayList<ReporteCuatroDetalleDTO>();
		
		if(circular.equals(Circular.C1)) {
			resultados = 
					em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_OPERACIONES")
					.setParameter("P_IDPOSICIONCAMBIARIA", StringUtils.isBlank(id)?"0":id)
					.setParameter("P_FECHA", reporteSearch.getFecha())
					.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
					.getResultList();
			
		}else if(circular.equals(Circular.C2)) {
			List<ReporteCuatroPosicionCambiariaDTO> listpc = 
					em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_IDPC")
					.setParameter("P_IDPOSICIONCAMBIARIA", StringUtils.isBlank(id)?"0":id)
					.getResultList();
			
			Iterator<ReporteCuatroPosicionCambiariaDTO> pc = listpc.iterator();
			
			while(pc.hasNext()) {
				String idpc = pc.next().getIdposicioncambiaria();
				resultados.addAll(
						em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_OPERACIONES")
						.setParameter("P_IDPOSICIONCAMBIARIA", StringUtils.isBlank(idpc)?"0":idpc)
						.setParameter("P_FECHA", reporteSearch.getFecha())
						.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
						.getResultList()
						);
			}
		}
		
		ReporteCuatroDetalleDTO totales = new ReporteCuatroDetalleDTO();
		
		Iterator<ReporteCuatroDetalleDTO> ReporteCuatro = resultados.iterator();
		int numregistros=0;
		while(ReporteCuatro.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteCuatro.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
		
		consultaDinamica.setColumnas(new ReporteCuatroDetalleDTO().headExcel());
		consultaDinamica.setRegistros(resultados);
		
		return consultaDinamica;
	}

	private String createTransaction(ReporteSearch reporteSearch){
		TransactionDTO dto = new TransactionDTO();
		
		Calendar cal = Calendar.getInstance();
		Calendar today = Calendar.getInstance();
		cal.setTime(reporteSearch.getFecha());	  
		dto.setFechaproceso(cal);
		dto.setTabla("MSD");
		dto.setTipoproceso(reporteSearch.getTipoproceso());
		dto.setProcesosactuales(0);
		dto.setDescripcion("Creando plantilla con importe en 0");
		dto.setProcesostotales(11);
		dto.setInicia(today);
		dto.setEstado(1);
		
		ResponseEntity<Void> response = Transaction.create(dto);
		
		String uri = ServletUriComponentsBuilder.fromCurrentRequest().toUriString();
		String[] parts = uri.replace("?"," ").split(" ");
		String part1 = parts[0]; // uri
		String part2 = parts[1]; // filter
		
		String id = response.getHeaders()
				.getLocation()
				.toString()
				.replace(part1+"/","").replace("?"+part2,"");	
		return id;
		
	}
	
	private Integer updateTransaction(String id, String msj, Integer process, Integer state) {
		TransactionDTO dto = new TransactionDTO();
		Calendar today = Calendar.getInstance();
		dto.setId(id);
		dto.setDescripcion(msj);
		dto.setProcesosactuales(process);
		dto.setTermina(today);
		if(state != null) {
			dto.setEstado(state);
		}
		ResponseEntity<Void> response =  Transaction.update(dto, id);
		return process+1;
	}
	
	
	@Override
	public void generar(ReporteSearch reporteSearch) {
		TransactionDTO dto = transactionRepository.search(reporteSearch);
		if (dto == null) {
			String id = this.createTransaction(reporteSearch);
			Integer process = 0;
			
			try {
				
				/* 
				 * Crea plantilla con importes en 0
				 */
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_INICIALIZAR")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .setParameter("P_USUARIO", "System") 
				  .execute();
				
				process = this.updateTransaction(id, "Calculando Letras P3 y R3", process, null);
				/*
				 * Calcula las letras P3 y R3
				 */
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALCULOCOBERTURA")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				process = this.updateTransaction(id, "Calculando suma de importes historicos", process, null);
				/*
				 * Suma importes historicos con los actuales
				 * K1.1.2, K1.2.1, K1.2.2, K2.1, K2.2
				 * L1.1, L1.2, L2
				 * M1.1.1, M1.1.2, M1.2.1, M1.2.2, M2.1, M2.2
				 * N2.1, N2.2
				 * O1.1, O1.2, O2
				 * P1, P2
				 * Q1, Q2
				 * R1, R2
				 * S1, S2
				 * F1.1.1, F1.1.2, F1.2.1, F1.2.2, F2.1, F2.2
				 * G1.1, G1.2, G2
				 * H1.1.1, H1.1.2, H1.2.1, H1.2.2, H2.1, H2.2
				 * I2.1, I2.2
				 * J1.1, J1.2
				 * 
				 */
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALIMPORTEACTUAL")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				/*
				process = this.updateTransaction(id, "Calculando Deltas", process, null);
				
				 *Calcula importes y deltas
				 *N1.1.1, N1.1.2, N1.2.1, N1.2.2
				 *I1.1.1, I1.1.2, I1.2.1, I1.2.2 
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALIMPORTEDELTA")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				*/
				process = this.updateTransaction(id, "Calculando Compra venta del dia", process, null);
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALCOMPRAVENTADIA")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				process = this.updateTransaction(id, "Calculando Posicion Estructural Nivel 1 y 2", process, null);
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALPOSESTRUCNIV_1")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_RUBRO", "P1") 
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALPOSESTRUCNIV_2")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_RUBRO", "P2") 
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				/*
				 * Q1 SIEMPRE EN 0
				 */
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALPOSESTRUCNIV_1")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_RUBRO", "Q1") 
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				/*
				 * Q2 SIEMPRE EN 0
				 */
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALPOSESTRUCNIV_2")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_RUBRO", "Q2") 
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALPOSESTRUCNIV_1")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_RUBRO", "R1") 
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALPOSESTRUCNIV_2")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_RUBRO", "R2") 
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				process = this.updateTransaction(id, "Calculo de compras V", process, null);
				/*
				 * Calculo de compras v
				 * */
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALCULOCOMPRAS")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				process = this.updateTransaction(id, "Calculo de ventas W", process, null);
				/*
				 * Calculo de ventas W
				 * */
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALCULOVENTAS")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				process = this.updateTransaction(id, "Calculo de letra C", process, null);
				/*
				 * Suma de rubro A y B para la letra C
				 * */
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_SUMAPOSCAMBIARIA")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				
				process = this.updateTransaction(id, "Calculando Suma de totales para las letras P,Q,R y S", process, null);
				/* 
				 * Suma de totales para las letras
				 * P,Q,R,S
				 * */
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALPOSESTRUCCOBERT")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_RUBRO", "P") 
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALPOSESTRUCCOBERT")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_RUBRO", "Q") 
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALPOSESTRUCCOBERT")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_RUBRO", "R") 
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALPOSESTRUCCOBERT")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_RUBRO", "S") 
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_SUMADETOTALES")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .setParameter("P_HIJO", "B") 
				  .setParameter("P_PADRE", "A") 
				  .execute();
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_SUMADETOTALES")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .setParameter("P_HIJO", "C") 
				  .setParameter("P_PADRE", "B") 
				  .execute();
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_SUMADETOTALES")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .setParameter("P_HIJO", "C") 
				  .setParameter("P_PADRE", "A") 
				  .execute();
				
				process = this.updateTransaction(id, "Calculando Saldo Nominal de compra y venta de Opciones", process, null);
				
				/*
				 *Saldo Nominal de compra y venta de Opciones en Call y Put
				 *N1, N2
				 *I1, I2*/
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALIMPORTEOPCIONES")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_SUMADETOTALES")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .setParameter("P_HIJO", "D") 
				  .setParameter("P_PADRE", "C") 
				  .execute();
				
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALPOSLARGDERIVCIER")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALPOSCORGDERIVCIER")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute();
				
				process =  this.updateTransaction(id, "Calculando letra T", process, null);
				/*
				 * Sumatoria de P,Q,R,S para la letra T
				 * Modificacion calculo Q1
				 * */
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALTOTPOSCAMBIOBAL")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute(); 
				
				process =  this.updateTransaction(id, "Finalizando...", process, null);
				em.createNamedStoredProcedureQuery("SP_BCR_MPC_CALPOSCAMBIOGLOBAL")
				  .setParameter("P_FECHA", reporteSearch.getFecha())
				  .setParameter("P_TIPOPROCESO", reporteSearch.getTipoproceso())
				  .execute(); 
				this.updateTransaction(id, "Reporte 4 Generado Correctamente", process, 2);
				
				
			} catch (Exception e) {
				this.updateTransaction(id, "Ocurrió un error al generar reporte: Falta ingresar el tipo de cambio", process, null);
				Transaction.delete(id);
			}
		}
	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteCuatroDetalleDTO> getExcelAnexo8(ReporteSearch reporteSearch, String id,
			Circular circular) {
		TablaDinamica<ReporteCuatroDetalleDTO> consultaDinamica = new TablaDinamica<ReporteCuatroDetalleDTO>();
		
		List<ReporteCuatroDetalleDTO> resultados = new ArrayList<ReporteCuatroDetalleDTO>();
		List<ReporteCuatroDetalleDTO> resultadosIrc = new ArrayList<ReporteCuatroDetalleDTO>();
		
		if(circular.equals(Circular.C1)) {
			
			resultados = 
					em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_ANEXO8")
					.setParameter("P_IDPOSICIONCAMBIARIA", StringUtils.isBlank(id)?"0":id)
					.setParameter("P_FECHA", reporteSearch.getFecha())
					.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
					.getResultList();
			
			resultados.addAll(
					em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_ANEXO8_IRC")
					.setParameter("P_IDPOSICIONCAMBIARIA", StringUtils.isBlank(id)?"0":id)
					.setParameter("P_FECHA", reporteSearch.getFecha())
					.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
					.getResultList());
			
			
		}else if(circular.equals(Circular.C2)) {

				resultados.addAll(
						em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_ANEXO8")
						.setParameter("P_IDPOSICIONCAMBIARIA", StringUtils.isBlank(id)?"0":id)
						.setParameter("P_FECHA", reporteSearch.getFecha())
						.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
						.getResultList()
						);
				
			    resultados.addAll(
						em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_ANEXO8_IRC")
						.setParameter("P_IDPOSICIONCAMBIARIA", StringUtils.isBlank(id)?"0":id)
						.setParameter("P_FECHA", reporteSearch.getFecha())
						.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso())?"D":reporteSearch.getTipoproceso() )
						.getResultList());
				
		}
		
		ReporteCuatroDetalleDTO totales = new ReporteCuatroDetalleDTO();
		
		Iterator<ReporteCuatroDetalleDTO> ReporteCuatro = resultados.iterator();
		int numregistros=0;
		while(ReporteCuatro.hasNext()) {
			numregistros = numregistros+1;
			totales.setImporteusd(totales.getImporteusd().add(ReporteCuatro.next().getImporteusd()));
		}
		
		totales.setImporteusd(totales.getImporteusd().setScale(2 ,BigDecimal.ROUND_HALF_UP));
		totales.setNumerooperacion("N° Reg= "+ numregistros);
		resultados.add(totales);
		
		consultaDinamica.setColumnas(new ReporteCuatroDetalleDTO().headExcel());
		consultaDinamica.setRegistros(resultados);
		
		return consultaDinamica;
	}
	
}
