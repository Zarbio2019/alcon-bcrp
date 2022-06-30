package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionTasaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.TasaInteresSearch;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.TasaInteres;
import pe.grupobbva.alcon.mantenimiento.repository.custom.TasaInteresCustomRepository;

public class TasaInteresCustomRepositoryImpl implements TasaInteresCustomRepository {
	
	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<OperacionTasaDTO> search(TasaInteresSearch tasaInteresSearch){
		List<OperacionTasaDTO> resultados =
				em.createNamedStoredProcedureQuery("SP_BCR_TASAINTERES_LISTAR")
				.setParameter("P_CODIGOREPORTE", tasaInteresSearch.getCodigoreporte())
				.setParameter("P_NUMEROOPERACION", tasaInteresSearch.getNumerooperacion())
				.setParameter("P_FECHAMOVIMIENTO", tasaInteresSearch.getFechamovimiento())
				.setParameter("P_IDPRODUCTO", tasaInteresSearch.getProducto())
				.setParameter("P_CODIGOCLIENTE", tasaInteresSearch.getCodigocliente())
				.setParameter("P_NOMBRECLIENTE", tasaInteresSearch.getNombrecliente())
				.setParameter("P_OBSERVACIONES", tasaInteresSearch.getEstado().equals("-2")?" ":tasaInteresSearch.getEstado())
				.setParameter("P_TIPOPROCESO", "D")
				.getResultList();
		
		return new DatatableDTO<>(
				tasaInteresSearch.getDraw(), 
					Long.valueOf(resultados != null ? resultados.size(): 0 ),
					Utils.paginador(resultados, tasaInteresSearch)
				);
		
	}

	@SuppressWarnings("unchecked")
	@Override
public List<OperacionTasaDTO> listarOperaciones(TasaInteresSearch tasaInteresSearch){
		List<OperacionTasaDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_TASAINTERES_LISTAR")
				.setParameter("P_CODIGOREPORTE", tasaInteresSearch.getCodigoreporte())
				.setParameter("P_NUMEROOPERACION", tasaInteresSearch.getNumerooperacion())
				.setParameter("P_FECHAMOVIMIENTO", tasaInteresSearch.getFechamovimiento())
				.setParameter("P_CODIGOCLIENTE", tasaInteresSearch.getCodigocliente())
				.setParameter("P_NOMBRECLIENTE", tasaInteresSearch.getNombrecliente())
				.setParameter("P_OBSERVACIONES", tasaInteresSearch.getEstado().equals("-2")?" ":tasaInteresSearch.getEstado())
				.setParameter("P_TIPOPROCESO","D")
				.getResultList();
		return resultados;
		
	}
	
	@Override
	public void unwindOperacion(TasaInteres operacion) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_TASAS_UNWIND")
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
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OperacionTasaDTO> searchList(TasaInteresSearch tasaInteresSearch){
		return em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_LISTAR")
				.setParameter("P_CODIGOREPORTE", tasaInteresSearch.getCodigoreporte())
				.setParameter("P_NUMEROOPERACION", tasaInteresSearch.getNumerooperacion())
				.setParameter("P_FECHAMOVIMIENTO", tasaInteresSearch.getFechamovimiento())
				.setParameter("P_CODIGOCLIENTE", tasaInteresSearch.getCodigocliente())
				.setParameter("P_NOMBRECLIENTE", tasaInteresSearch.getNombrecliente())
				.setParameter("P_OBSERVACIONES", tasaInteresSearch.getEstado().equals("-2")?" ":tasaInteresSearch.getEstado())
				.setParameter("P_TIPOPROCESO","D")
				.getResultList();
	}
	
	
	@Override
	public void anularOperacion(TasaInteres operacion) {

		em.createNamedStoredProcedureQuery("SP_BCR_TASAS_UNWIND")
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
	public String generaIRD(String codigo, String numerooperacion) {
		
		StoredProcedureQuery sq = em.createNamedStoredProcedureQuery("SP_BCR_TASAINTERES_GENERAIRD")
		   .setParameter("P_CODIGO", codigo)
		   .setParameter("P_NROOPERACION", numerooperacion);
		sq.execute();
		
		return (String) sq.getOutputParameterValue("NROOPERACIONIRD_");
	 
	}
	
	@Override
	public void actualizarFechaEfectiva(Carga carga) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_TASINT_UPDFECEFECT_IRD")
		   .setParameter("P_FECHAPROCESO", new Date(carga.getFecha().getTimeInMillis()))
		   .setParameter("P_TIPOPROCESO", carga.getTipoproceso())
		   .setParameter("P_USUARIOMODIFICACION", carga.getActualizadoPor())
		   .execute();
		
	}
	
	@Override
	public void generarCodigoReporte6(Carga carga) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_TASAINT_GENCODREPIRD")
		   .setParameter("P_FECHAPROCESO", new Date(carga.getFecha().getTimeInMillis()))
		   .setParameter("P_TIPOPROCESO", carga.getTipoproceso())
		   .execute();
		
	}
	
}
