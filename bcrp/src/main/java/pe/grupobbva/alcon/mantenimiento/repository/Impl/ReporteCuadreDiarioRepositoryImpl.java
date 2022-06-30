package pe.grupobbva.alcon.mantenimiento.repository.Impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.grupobbva.alcon.mantenimiento.dto.custom.ImportesReporteCuadreDiario;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.ParametroResponse;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.ValorParametroResponse;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuadreDiarioExcelDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.ParametroTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterCode;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.repository.ReporteCuadreDiarioRepository;
import pe.grupobbva.alcon.mantenimiento.repository.custom.impl.ParametroCustomRepositoryImpl;
import pe.grupobbva.alcon.mantenimiento.service.DetalleParametroService;
import pe.grupobbva.alcon.mantenimiento.service.ValorParametroService;

@Repository
public class ReporteCuadreDiarioRepositoryImpl implements ReporteCuadreDiarioRepository {

	@Autowired
	private EntityManager em;
	
	@Autowired 
	private DetalleParametroService detalleParametroService;
	
	@Autowired
	private ValorParametroService valorParametroService;
	
	private static final Logger log = LogManager.getLogger();
	
	@SuppressWarnings("unchecked")
	@Override
	public TablaDinamica<ReporteCuadreDiarioExcelDTO> getExcelReport(ReporteSearch reporteSearch) {
		TablaDinamica<ReporteCuadreDiarioExcelDTO> consultaDinamica = new TablaDinamica<ReporteCuadreDiarioExcelDTO>();
		
		ParameterCode parametercode = new ParameterCode();
		
		// CUENTAS 
		List<ParametroResponse> Cuentas = new ArrayList<ParametroResponse>();
		Cuentas = this.getParameters(parametercode.getCuentas());
		Collections.sort( Cuentas);
		
		// ESTADO DE OPERACIONES
		List<ParametroResponse> EstadoOperaciones = new ArrayList<ParametroResponse>();
		EstadoOperaciones = this.getParameters(parametercode.getEstadoOperaciones());
		Collections.sort( EstadoOperaciones);
		
		// Columnas de reporte Excel
		List<ReporteCuadreDiarioExcelDTO> listReporteCuadreDiario = new ArrayList<ReporteCuadreDiarioExcelDTO>();
		
		
		for(int c = 0;c<Cuentas.size();c++) {
			if(Cuentas.get(c).getVisibledetalleparametro().equals("1")) {
				ReporteCuadreDiarioExcelDTO totales = new ReporteCuadreDiarioExcelDTO();
				ReporteCuadreDiarioExcelDTO diferencia = new ReporteCuadreDiarioExcelDTO();
				ReporteCuadreDiarioExcelDTO importesaldo = new ReporteCuadreDiarioExcelDTO();
				ReporteCuadreDiarioExcelDTO diffinal = new ReporteCuadreDiarioExcelDTO();
				
				ReporteCuadreDiarioExcelDTO reporteCuadreDiario = new ReporteCuadreDiarioExcelDTO(Cuentas.get(c));
				listReporteCuadreDiario.add(reporteCuadreDiario);
				
				for(int e = 0; e<EstadoOperaciones.size() ; e++) {
					ImportesReporteCuadreDiario importes = new ImportesReporteCuadreDiario();
					importes = this.getAmounts(
							reporteSearch, 
							EstadoOperaciones.get(e).getDescripciondetalleparametro(),
							Cuentas.get(c).getDescripciondetalleparametro(),
							Cuentas.get(c).getValorparametro1(), //tipooperacion
							EstadoOperaciones.get(e).getValorparametro1(),//codigooficina
							Cuentas.get(c).getValorparametro2(),//codigoproducto
							Cuentas.get(c).getValorparametro3() == null? "-2":Cuentas.get(c).getValorparametro3(),//codigocallput
							Cuentas.get(c).getValorparametro4(),//rubro1
							Cuentas.get(c).getValorparametro5());//rubro2
					
					ReporteCuadreDiarioExcelDTO detalleReporteCuadreDiario = new ReporteCuadreDiarioExcelDTO(EstadoOperaciones.get(e), importes);
					listReporteCuadreDiario.add(detalleReporteCuadreDiario);

					if(!EstadoOperaciones.get(e).getDescripciondetalleparametro().equals("OTRAS DIVISAS")) {
						totales.sumatotales(importes);
						importesaldo.sumatoriaimportesaldo(importes);
					}
					
					if(EstadoOperaciones.get(e).getDescripciondetalleparametro().equals("MODIFICADAS")) {
						diferencia.diferencia(totales, importesaldo);
						listReporteCuadreDiario.add(totales);
						listReporteCuadreDiario.add(diferencia);
					}
					
					if(EstadoOperaciones.get(e).getDescripciondetalleparametro().equals("OTRAS DIVISAS")) {
						diffinal.diffinal(diferencia, detalleReporteCuadreDiario);
						listReporteCuadreDiario.add(diffinal);
					}
				}
				
				ReporteCuadreDiarioExcelDTO espace = new ReporteCuadreDiarioExcelDTO();
				listReporteCuadreDiario.add(espace);
			}
		}
		
		Iterator<ReporteCuadreDiarioExcelDTO> list = listReporteCuadreDiario.iterator();
		
		while(list.hasNext()) {
			list.next().numberFormat();
		}
		
		 consultaDinamica.setRegistros(listReporteCuadreDiario);
		 return consultaDinamica;
	}
	
	@SuppressWarnings("unchecked")
	private ImportesReporteCuadreDiario getAmounts(ReporteSearch reporteSearch, String operacion, String numerocuenta,
			String tipooperacion, String codigooficina, String codigoproducto, String codigocallput,String rubro1, String rubro2) {
		List<ImportesReporteCuadreDiario> importesReporteCuadreDiario = new ArrayList<ImportesReporteCuadreDiario>();
			importesReporteCuadreDiario = 
					em.createNamedStoredProcedureQuery("SP_BCR_REPORTECUADREDIARIO")
					.setParameter("P_FECHAPROCESO",reporteSearch.getFecha())
					.setParameter("P_OPERACION",operacion)
					.setParameter("P_NUMEROCUENTA",numerocuenta)
					.setParameter("P_TIPOOPERACION", tipooperacion)
					.setParameter("P_VALOR1",codigooficina)
					.setParameter("P_VALOR2",codigoproducto)
					.setParameter("P_VALOR3",codigocallput.equals("CALL")?"C":codigocallput.equals("PUT")?"P":"-2")
					.setParameter("P_VALOR4",rubro1)
					.setParameter("P_VALOR5",rubro2)
					.getResultList();
		
		return importesReporteCuadreDiario.size()==0? new ImportesReporteCuadreDiario():importesReporteCuadreDiario.get(0);
	}
	
	@SuppressWarnings("unchecked")
	private List<ParametroResponse> getParameters(String codigo) {
		ParametroCustomRepositoryImpl parametro = new ParametroCustomRepositoryImpl();
		
		List<ParametroTableDTO> detalle = 
				em.createNamedStoredProcedureQuery("SP_BCR_PARAMETRO_LISTAR")
				.setParameter("P_CODIGO",codigo)
				.setParameter("P_DETALLE_ID",null)
				.getResultList();
		
		List<ValorParametroResponse> valores = 
				em.createNamedStoredProcedureQuery("SP_BCR_PARAMETRO_LISTARVALORES")
				.setParameter("P_CODIGO",codigo)
				.setParameter("P_DETALLE_ID",null)
				.getResultList();
		log.info("Parametros: "+ parametro.getParameters(detalle, valores));
		return parametro.getParameters(detalle, valores);
	}
	
}
