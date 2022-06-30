package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionSearch;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacioncargaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacionTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacioncargaTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Feriado;
import pe.grupobbva.alcon.mantenimiento.entity.Operacion;
import pe.grupobbva.alcon.mantenimiento.entity.TipoProceso;
import pe.grupobbva.alcon.mantenimiento.repository.custom.OperacionCustomRepository;

public class OperacionCustomRepositoryImpl implements OperacionCustomRepository {
	
	@Autowired
	private EntityManager em;
	
	private static final Logger log = LogManager.getLogger();
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OperacionTableDTO> searchList(OperacionSearch operacionSearch) {
		log.info(operacionSearch);
		return em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_LISTAR")
				.setParameter("P_CODIGOREPORTE", operacionSearch.getCodigoreporte())
				.setParameter("P_NUMEROOPERACION", operacionSearch.getNumerooperacion())
				.setParameter("P_FECHACONTRATACION", operacionSearch.getFechacontratacion())
				.setParameter("P_FECHAMOVIMIENTO", operacionSearch.getFechamovimiento())
				.setParameter("P_FECHAVALOR", operacionSearch.getFechavalor())
				.setParameter("P_FECHAVENCIMIENTO", operacionSearch.getFechavencimiento())
				.setParameter("P_IDPRODUCTO", StringUtils.isBlank(operacionSearch.getProducto())?"-2":operacionSearch.getProducto())
				.setParameter("P_CODIGOCLIENTE", operacionSearch.getCodigocliente())
				.setParameter("P_NOMBRECLIENTE", operacionSearch.getNombrecliente())
				.setParameter("P_IMPORTEUSDINICIAL", operacionSearch.getImporteusdinicial() == null ? new BigDecimal(0) : operacionSearch.getImporteusdinicial())
				.setParameter("P_IMPORTEUSDFINAL", operacionSearch.getImporteusdfinal() == null ? new BigDecimal(0) : operacionSearch.getImporteusdfinal())
				.setParameter("P_OBSERVACIONES", operacionSearch.getEstado().equals("-2")?" ":operacionSearch.getEstado())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(operacionSearch.getTipoproceso())?"-2":operacionSearch.getTipoproceso())
				.setParameter("P_INTENCIONDECONTRATACION", StringUtils.isBlank(operacionSearch.getIntenciondecontratacion())?"-2":operacionSearch.getIntenciondecontratacion())
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<OperacionTableDTO> search(OperacionSearch operacionSearch){
		
		List<OperacionTableDTO> resultados = searchList(operacionSearch);
				
		
		return new DatatableDTO<>(
				operacionSearch.getDraw(), 
					Long.valueOf(resultados != null ? resultados.size(): 0 ),
					Utils.paginador(resultados, operacionSearch)
				);
	}
	
	@Override
	public void actualizarOperacionFeriado(Feriado entity) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_FERIADO_UPD")
		   .setParameter("P_IDFERIADO", entity.getId())
		   .setParameter("P_CODIGOESTADO", entity.getCodigoestado())
		   .setParameter("P_USUARIOMODIFICACION", entity.getActualizadoPor())
		   .execute();
		
	}
	
	@Override
	public void actualizarEstadoIRC(Carga carga, int codigoestado) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_UPDESTADOIRC")
		   .setParameter("P_FECHAPROCESO", new Date(carga.getFecha().getTimeInMillis()))
		   .setParameter("P_CODIGOESTADO", codigoestado)
		   .setParameter("P_TIPOPROCESO", carga.getTipoproceso())
		   .setParameter("P_USUARIOMODIFICACION", carga.getActualizadoPor())
		   .execute();
		
	}
	
	@Override
	public void actualizarFechaEfectiva(Carga carga) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_UPDFECHAEFECT")
		   .setParameter("P_FECHAPROCESO", new Date(carga.getFecha().getTimeInMillis()))
		   .setParameter("P_TIPOPROCESO", carga.getTipoproceso())
		   .setParameter("P_USUARIOMODIFICACION", carga.getActualizadoPor())
		   .execute();
		
	}
	
	@Override
	public void eliminarOperaciones(Carga carga) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_DELOPERACION")
		   .setParameter("P_IDCARGA", carga.getId())
		   .setParameter("P_TIPOPROCESO", carga.getTipoproceso())
		   .setParameter("P_FECHAPROCESO", new Date(carga.getFecha().getTimeInMillis()))
		   .execute();
		
	}
	
	@Override
	public void generarCodigoReporte1(Carga carga) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_GENERACODREP1")
		   .setParameter("P_FECHAPROCESO", new Date(carga.getFecha().getTimeInMillis()))
		   .setParameter("P_TIPOPROCESO", carga.getTipoproceso())
		   .execute();
		
	}
	
	@Override
	public void generarCodigoReporte3(Carga carga) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_GENERACODREP3")
		   .setParameter("P_FECHAPROCESO", new Date(carga.getFecha().getTimeInMillis()))
		   .setParameter("P_TIPOPROCESO", carga.getTipoproceso())
		   .execute();
		
	}
	
	@Override
	public void generarOperacionesMenoresQuinientosMil(Carga carga) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_GENERAMEQUMIL")
		   .setParameter("P_FECHAPROCESO", new Date(carga.getFecha().getTimeInMillis()))
		   .setParameter("P_TIPOPROCESO", carga.getTipoproceso())
		   .setParameter("P_USUARIOCREACION", carga.getCreadoPor())
		   .execute();
		
	}
	
	@Override
	public void generarCodigoReporte2Adelantado(Carga carga) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_GENERAREP2AD")
		   .setParameter("P_TIPOPROCESO", TipoProceso.A.name())	
		   .setParameter("P_FECHAPROCESO", new Date(carga.getFecha().getTimeInMillis()))
		   .execute();
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OperacionTableDTO> listarOperaciones(OperacionSearch operacionSearch) {
		
		List<OperacionTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_LISTAR")
				.setParameter("P_CODIGOREPORTE", operacionSearch.getCodigoreporte())
				.setParameter("P_NUMEROOPERACION", operacionSearch.getNumerooperacion())
				.setParameter("P_FECHACONTRATACION", operacionSearch.getFechacontratacion())
				.setParameter("P_FECHAMOVIMIENTO", operacionSearch.getFechamovimiento())
				.setParameter("P_FECHAVALOR", operacionSearch.getFechavalor())
				.setParameter("P_FECHAVENCIMIENTO", operacionSearch.getFechavencimiento())
				.setParameter("P_IDPRODUCTO", StringUtils.isBlank(operacionSearch.getProducto())?"-2":operacionSearch.getProducto())
				.setParameter("P_CODIGOCLIENTE", operacionSearch.getCodigocliente())
				.setParameter("P_NOMBRECLIENTE", operacionSearch.getNombrecliente())
				.setParameter("P_IMPORTEUSDINICIAL", operacionSearch.getImporteusdinicial() == null ? new BigDecimal(0) : operacionSearch.getImporteusdinicial())
				.setParameter("P_IMPORTEUSDFINAL", operacionSearch.getImporteusdfinal() == null ? new BigDecimal(0) : operacionSearch.getImporteusdfinal())
				.setParameter("P_OBSERVACIONES", operacionSearch.getEstado().equals("-2")?" ":operacionSearch.getEstado())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(operacionSearch.getTipoproceso())?"-2":operacionSearch.getTipoproceso())
				.setParameter("P_INTENCIONDECONTRATACION", StringUtils.isBlank(operacionSearch.getIntenciondecontratacion())?"-2":operacionSearch.getIntenciondecontratacion())
				.getResultList();
		
		return resultados;	
	}
	
	@Override
	public void unwindOperacion(Operacion operacion) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_UNWIND")
		   .setParameter("P_IDCARGA", operacion.getIdCarga())
		   .setParameter("P_FECHACONTRATACION", new Date(operacion.getFechacontratacion().getTimeInMillis()))
		   .setParameter("P_IDPRODUCTO", operacion.getProducto().getId())
		   .setParameter("P_NUMEROOPERACION", operacion.getNumerooperacion())
		   .setParameter("P_IDCLIENTE", operacion.getCliente().getId())
		   .setParameter("P_TIPOOPERACION", operacion.getTipooperacion())
		   .setParameter("P_IDDIVISAENTRADA", operacion.getIddivisaentrada())
		   .setParameter("P_IDDIVISASALIDA", operacion.getIddivisasalida())
		   .setParameter("P_IMPORTEDIVISAENTRADA", operacion.getImportedivisaentrada())
		   .setParameter("P_IMPORTEDIVISASALIDA", operacion.getImportedivisasalida())
		   
		   .setParameter("P_COTIZACION", operacion.getCotizacion())
		   .setParameter("P_PUNTOSSWAP", operacion.getPuntosswap())
		   .setParameter("P_BASICA", operacion.getBasica())
		   .setParameter("P_CAMBIOREF", operacion.getCambioref())
		   .setParameter("P_FECHAVALOR", new Date(operacion.getFechavalor().getTimeInMillis()))
		   .setParameter("P_FECHAVENCIMIENTO", new Date(operacion.getFechavencimiento().getTimeInMillis()))
		   .setParameter("P_PLAZO", operacion.getPlazo())
		   .setParameter("P_FECHAEJERCICIO", new Date(operacion.getFechaejercicio().getTimeInMillis()))
		   .setParameter("P_CALLPUT", operacion.getCallput())
		   .setParameter("P_PLAZA", operacion.getPlaza())
		   
		   
		   .setParameter("P_PAISRESIDENCIA", operacion.getPaisresidencia())
		   .setParameter("P_RIESGOPAIS", operacion.getRiesgopais())
		   .setParameter("P_PRIMA", operacion.getPrima())
		   .setParameter("P_IDDIVISAPRIMA", operacion.getIddivisaprima())
		   .setParameter("P_OBSERVACIONES", operacion.getObservaciones())
		   .setParameter("P_FECHAALTA", new Date(operacion.getFechaalta().getTimeInMillis()))
		   .setParameter("P_FECHAMODIFICACIONCARGA", operacion.getFechamodificacioncarga() == null ? operacion.getFechamodificacioncarga() : new Date(operacion.getFechamodificacioncarga().getTimeInMillis()))
		   .setParameter("P_OPERACIONSUSTITUYE", operacion.getOperacionsustituye())
		   .setParameter("P_FECHABAJA", new Date(operacion.getFechabaja().getTimeInMillis()))
		   .setParameter("P_NIF", operacion.getNif())
		   
		   
		   .setParameter("P_INTERMEDIARIO", operacion.getIntermediario())
		   .setParameter("P_INTERMEDIARIODESCRIPCION", operacion.getIntermediariodescripcion())
		   .setParameter("P_ESTADO", operacion.getEstado())
		   .setParameter("P_CONTRATO", operacion.getContrato())
		   .setParameter("P_RESIDENTE", operacion.getResidente())
		   .setParameter("P_ESTILO", operacion.getEstilo())
		   .setParameter("P_TIPOOPCION", operacion.getTipoopcion())
		   .setParameter("P_TIPOPROCESO", operacion.getTipoproceso())
		   .setParameter("P_HISTORICO", operacion.getHistorico())
		   .setParameter("P_FECHAMOVIMIENTO", new Date(operacion.getFechamovimiento().getTimeInMillis()))
		   
		   
		   .setParameter("P_USUARIOCARGA", operacion.getUsuariocarga())
		   .setParameter("P_CODIGOOPERACION", operacion.getCodigooperacion())
		   .setParameter("P_IMPORTEUSD", operacion.getImporteusd())
		   .setParameter("P_CODIGOREPORTE", operacion.getCodigoreporte())
		   .setParameter("P_TASAMONEDANACIONAL", operacion.getTasamonedanacional())
		   .setParameter("P_MONTOMONEDAEXTRAJERA", operacion.getMontomonedaextranjera())
		   .setParameter("P_TASADIFERENCIAL", operacion.getTasadiferencial())
		   .setParameter("P_DELTA", operacion.getDelta())
		   .setParameter("P_TASAMONEDAEXTRANJERA", operacion.getTasamonedaextranjera())
		   .setParameter("P_IDMONEDAEXTRANJERA", operacion.getIdmonedaextranjera())
		   
		   
		   .setParameter("P_MONTOPEN", operacion.getMontopen())
		   .setParameter("P_TIPOCAMBIOSPOT", operacion.getTipocambiospot())
		   .setParameter("P_TIPOCAMBIOPACTADO", operacion.getTipocambiopactado())
		   .setParameter("P_TIPOCAMBIOVENCIMIENTO", operacion.getTipocambiovencimiento())
		   .setParameter("P_VALIDACION", operacion.getValidacion())
		   .setParameter("P_CODIGOAGRUPACION", operacion.getCodigoagrupacion())
		   .setParameter("P_TIPOCLIENTE", operacion.getTipocliente())
		   .setParameter("P_IDFILAARCHIVO", operacion.getIdfilaarchivo())
		   .setParameter("P_TIPOCARGA", 0) // TO DO OBTENER TIPO CARGA  ?????
		   .setParameter("P_TIPOACCION", operacion.getTipoaccion())
		   .setParameter("P_USUARIOCREACION", operacion.getCreadoPor())
		   
		   .setParameter("P_INTENCIONCONTRATACION", operacion.getIntencioncontratacion())
		   .setParameter("P_PAGAIDENTIFICFRECUENCIA", operacion.getPagaidentificadorfrecuencia())
		   .setParameter("P_PAGATASAFIJASPREAD", operacion.getPagatasafijaspread())
		   .setParameter("P_PAGATFIJA", operacion.getPagatfija())
		   .setParameter("P_RECIBEIDENTIFICFRECUENCIA", operacion.getRecibeidentificadorfrecuencia())
		   .setParameter("P_RECIBETASAFIJASPREAD", operacion.getRecibetasafijaspread())
		   .setParameter("P_RECIBETFIJA", operacion.getRecibetfija())
		   
		   .execute();
		
	}
	
	@Override
	public void anularOperacion(Operacion operacion) {

		em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_UNWIND")
		   .setParameter("P_IDCARGA", operacion.getIdCarga())
		   .setParameter("P_FECHACONTRATACION", new Date(operacion.getFechacontratacion().getTimeInMillis()))
		   .setParameter("P_IDPRODUCTO", operacion.getProducto().getId())
		   .setParameter("P_NUMEROOPERACION", operacion.getNumerooperacion())
		   .setParameter("P_IDCLIENTE", operacion.getCliente().getId())
		   .setParameter("P_TIPOOPERACION", operacion.getTipooperacion())
		   .setParameter("P_IDDIVISAENTRADA", operacion.getIddivisaentrada())
		   .setParameter("P_IDDIVISASALIDA", operacion.getIddivisasalida())
		   .setParameter("P_IMPORTEDIVISAENTRADA", operacion.getImportedivisaentrada())
		   .setParameter("P_IMPORTEDIVISASALIDA", operacion.getImportedivisasalida())
		   
		   .setParameter("P_COTIZACION", operacion.getCotizacion())
		   .setParameter("P_PUNTOSSWAP", operacion.getPuntosswap())
		   .setParameter("P_BASICA", operacion.getBasica())
		   .setParameter("P_CAMBIOREF", operacion.getCambioref())
		   .setParameter("P_FECHAVALOR", new Date(operacion.getFechavalor().getTimeInMillis()))
		   .setParameter("P_FECHAVENCIMIENTO", new Date(operacion.getFechavencimiento().getTimeInMillis()))
		   .setParameter("P_PLAZO", operacion.getPlazo())
		   .setParameter("P_FECHAEJERCICIO", new Date(operacion.getFechaejercicio().getTimeInMillis()))
		   .setParameter("P_CALLPUT", operacion.getCallput())
		   .setParameter("P_PLAZA", operacion.getPlaza())
		   
		   
		   .setParameter("P_PAISRESIDENCIA", operacion.getPaisresidencia())
		   .setParameter("P_RIESGOPAIS", operacion.getRiesgopais())
		   .setParameter("P_PRIMA", operacion.getPrima())
		   .setParameter("P_IDDIVISAPRIMA", operacion.getIddivisaprima())
		   .setParameter("P_OBSERVACIONES", operacion.getObservaciones())
		   .setParameter("P_FECHAALTA", new Date(operacion.getFechaalta().getTimeInMillis()))
		   .setParameter("P_FECHAMODIFICACIONCARGA", operacion.getFechamodificacioncarga() == null ? operacion.getFechamodificacioncarga() : new Date(operacion.getFechamodificacioncarga().getTimeInMillis()))
		   .setParameter("P_OPERACIONSUSTITUYE", operacion.getOperacionsustituye())
		   .setParameter("P_FECHABAJA", new Date(operacion.getFechabaja().getTimeInMillis()))
		   .setParameter("P_NIF", operacion.getNif())
		   
		   
		   .setParameter("P_INTERMEDIARIO", operacion.getIntermediario())
		   .setParameter("P_INTERMEDIARIODESCRIPCION", operacion.getIntermediariodescripcion())
		   .setParameter("P_ESTADO", operacion.getEstado())
		   .setParameter("P_CONTRATO", operacion.getContrato())
		   .setParameter("P_RESIDENTE", operacion.getResidente())
		   .setParameter("P_ESTILO", operacion.getEstilo())
		   .setParameter("P_TIPOOPCION", operacion.getTipoopcion())
		   .setParameter("P_TIPOPROCESO", operacion.getTipoproceso())
		   .setParameter("P_HISTORICO", operacion.getHistorico())
		   .setParameter("P_FECHAMOVIMIENTO", new Date(operacion.getFechamovimiento().getTimeInMillis()))
		   
		   
		   .setParameter("P_USUARIOCARGA", operacion.getUsuariocarga())
		   .setParameter("P_CODIGOOPERACION", operacion.getCodigooperacion())
		   .setParameter("P_IMPORTEUSD", operacion.getImporteusd())
		   .setParameter("P_CODIGOREPORTE", operacion.getCodigoreporte())
		   .setParameter("P_TASAMONEDANACIONAL", operacion.getTasamonedanacional())
		   .setParameter("P_MONTOMONEDAEXTRAJERA", operacion.getMontomonedaextranjera())
		   .setParameter("P_TASADIFERENCIAL", operacion.getTasadiferencial())
		   .setParameter("P_DELTA", operacion.getDelta())
		   .setParameter("P_TASAMONEDAEXTRANJERA", operacion.getTasamonedaextranjera())
		   .setParameter("P_IDMONEDAEXTRANJERA", operacion.getIdmonedaextranjera())
		   
		   
		   .setParameter("P_MONTOPEN", operacion.getMontopen())
		   .setParameter("P_TIPOCAMBIOSPOT", operacion.getTipocambiospot())
		   .setParameter("P_TIPOCAMBIOPACTADO", operacion.getTipocambiopactado())
		   .setParameter("P_TIPOCAMBIOVENCIMIENTO", operacion.getTipocambiovencimiento())
		   .setParameter("P_VALIDACION", operacion.getValidacion())
		   .setParameter("P_CODIGOAGRUPACION", operacion.getCodigoagrupacion())
		   .setParameter("P_TIPOCLIENTE", operacion.getTipocliente())
		   .setParameter("P_IDFILAARCHIVO", operacion.getIdfilaarchivo())
		   .setParameter("P_TIPOCARGA", 0) // TO DO OBTENER TIPO CARGA  ?????
		   .setParameter("P_TIPOACCION", operacion.getTipoaccion())
		   .setParameter("P_USUARIOCREACION", operacion.getCreadoPor())
		   
		   .setParameter("P_INTENCIONCONTRATACION", operacion.getIntencioncontratacion())
		   .setParameter("P_PAGAIDENTIFICFRECUENCIA", operacion.getPagaidentificadorfrecuencia())
		   .setParameter("P_PAGATASAFIJASPREAD", operacion.getPagatasafijaspread())
		   .setParameter("P_PAGATFIJA", operacion.getPagatfija())
		   .setParameter("P_RECIBEIDENTIFICFRECUENCIA", operacion.getRecibeidentificadorfrecuencia())
		   .setParameter("P_RECIBETASAFIJASPREAD", operacion.getRecibetasafijaspread())
		   .setParameter("P_RECIBETFIJA", operacion.getRecibetfija())
		   
		   .execute();
	}
	
	@Override
	public void actualizarTasas(Operacion operacion) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_UPDTASAS")
		   .setParameter("P_IDOPERACION", operacion.getId())
		   .setParameter("P_TASAMONEDANACIONAL", operacion.getTasamonedanacional())
		   .setParameter("P_TASAMONEDAEXTRANJERA", operacion.getTasamonedaextranjera())
		   .setParameter("P_TASADIFERENCIAL", operacion.getTasadiferencial())
		   .execute();
		
	}
	
	@Override
	public String generaIRC(String codigo, String numerooperacion) {
		
		StoredProcedureQuery sq = em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_GENERAIRC")
		   .setParameter("P_CODIGO", codigo)
		   .setParameter("P_NROOPERACION", numerooperacion);
		sq.execute();
		
		return (String) sq.getOutputParameterValue("NROOPERACIONIRC_");
	 
	}

	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<OperacionTableDTO> feriadoListarOperaciones(OperacionSearch operacionSearch) {

		List<OperacionTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_FERIADO_LIST_OPER")
				.setParameter("P_FECHA", operacionSearch.getFechamovimiento())
				.getResultList();

		return new DatatableDTO<>(
				operacionSearch.getDraw(), 
				Long.valueOf(resultados != null ? resultados.size() : 0),
				resultados
			);

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OperacionTableDTO> listarOperacionesFeriado(Calendar fecha) {

		List<OperacionTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_FERIADO_LIST_OPER")
				.setParameter("P_FECHA", new Date(fecha.getTimeInMillis()))
				.getResultList();

		return resultados;	

	}
	
}
