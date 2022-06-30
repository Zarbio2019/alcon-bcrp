package pe.grupobbva.alcon.mantenimiento.service.process.impl;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.beans.TimeFormat;
import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.dto.process.FilaEstado;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionDerivadoCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionDivaCargaType;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.entity.IntencionContratacion;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionDerivado;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionDerivadoCarga;
import pe.grupobbva.alcon.mantenimiento.entity.Producto;
import pe.grupobbva.alcon.mantenimiento.entity.Residente;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCarga;
import pe.grupobbva.alcon.mantenimiento.entity.TipoProceso;
import pe.grupobbva.alcon.mantenimiento.repository.OperacionDerivadoCargaRepository;
import pe.grupobbva.alcon.mantenimiento.service.ClienteService;
import pe.grupobbva.alcon.mantenimiento.service.CorrelativoService;
import pe.grupobbva.alcon.mantenimiento.service.DivisaService;
import pe.grupobbva.alcon.mantenimiento.service.OperacionDerivadoService;
import pe.grupobbva.alcon.mantenimiento.service.ProductoService;
import pe.grupobbva.alcon.mantenimiento.service.TipoCambioService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaInfoReportDerivadoService;
import pe.grupobbva.alcon.mantenimiento.service.process.util.BcrpReader;
import pe.grupobbva.alcon.mantenimiento.util.ReportUtils;

@Service
public class CargaInfoReportDerivadoServiceImpl implements CargaInfoReportDerivadoService {
	
	@Value("${app.valorescargaoperacion.pais_peru}")
	private String paisPeru;
	
	@Value("${app.valorescargaoperacion.mensaje_error_carga_generico}")
	private String MENSAJE_ERROR_CARGA_GENERICO;
	
	@Value("${app.valorescargaoperacion.moneda.dollar}")
	private String monedaDOL;
	
	@Value("${app.valorescargaoperacion.moneda.pen}")
	private String monedaPEN;
	
	private static final Logger log = LogManager.getLogger();
	
	@Autowired
	private OperacionDerivadoCargaRepository operacionDerivadoCargaRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CorrelativoService correlativoService;

	@Autowired
	private ProductoService productoService;
	
	@Autowired
	private DivisaService divisaService;
	
	@Autowired
	private TipoCambioService tipocambioService;
	
	@Autowired
	private OperacionDerivadoService operacionDerivadoService;
	
	private void loadOperacionDerivadoCarga(Carga carga, InputStream file, String filename, List<OperacionDerivadoCargaType> registros,

			
		List<OperacionDerivadoCarga> operacionderivadocargas, Map<String, FilaEstado> errores) {
		
		if (carga.getTipocarga().equals(String.valueOf(
				TipoCarga.INFOREPORTDIVAS.getNumeroTipoCarga()))
				) {
			List<OperacionDivaCargaType> registrosDivas = new ArrayList<>();
			BcrpReader.infoDivaCarga().read(carga, file, filename, registrosDivas, errores);
			registros = (List) registrosDivas;
		}else {
			BcrpReader.inforeportDerivadoCarga().read(carga, file, filename, registros, errores);	
		}
		

		
		

		carga.setTotalreg(registros.size());

		registros.stream().forEach(registro -> {

			try {
				OperacionDerivadoCarga operacionderivadocarga = new OperacionDerivadoCarga(registro);
				operacionDerivadoCargaRepository.save(operacionderivadocarga);
				operacionderivadocargas.add(operacionderivadocarga);

			} catch (ParseException | IllegalArgumentException e) {
				log.error("failed!", e);
			}

		});
	}
	
	@Override
	public void procesarCarga(Carga carga, InputStream file, String filename, Integer opcionTipoCarga) {
		List<OperacionDerivadoCargaType> registros = new ArrayList<>();
		List<OperacionDerivadoCarga> operacionderivadocargas = new ArrayList<>();
		Map<String, FilaEstado> errores = new HashMap<>();

		loadOperacionDerivadoCarga(carga, file, filename, registros, operacionderivadocargas, errores);
		procesar(carga, operacionderivadocargas, opcionTipoCarga);
	}
	
	public void procesar(Carga carga, List<OperacionDerivadoCarga> operacionderivadocargas, Integer opcionTipoCarga) {
		
		int regCargado = 0;
		ReportUtils utils = new ReportUtils();
		
		List<OperacionDerivado> operacionesderivados = new ArrayList<>();
		List<OperacionDerivado> operacionesderivadoslogs = new ArrayList<>();
		
		for (OperacionDerivadoCarga operacionderivadocarga : operacionderivadocargas) {
			
			OperacionDerivado operacionderivado = new OperacionDerivado();
			
			try {
				operacionderivado.setIdfilaarchivo(operacionderivadocarga.getIdfilaarchivo());
				operacionderivado.setIdCarga(carga.getId());
				operacionderivado.setCreadoPor(carga.getCreadoPor());
				operacionderivado.setActualizadoPor(carga.getActualizadoPor());
				operacionderivado.setFechamovimiento(carga.getFecha());
				operacionderivado.setTipoproceso(TipoProceso.D.name());
				
				operacionderivado.setFechareporte(Utils.stringtoCalendar(operacionderivadocarga.getFechareporte(), TimeFormat.DATEFORMAT));
				operacionderivado.setNumerooperacion(operacionderivadocarga.getNumerooperacion().trim());
				operacionderivado.setCodigodiva(operacionderivadocarga.getCodigodiva().trim());
				
				/** Manejo de producto */
				Producto producto = buscarProducto(operacionderivadocarga.getProducto());
				/** asignamos el valor de codigo de operacion */
				operacionderivado.setProducto(producto);
				
				operacionderivado.setTipooperacion(operacionderivadocarga.getTipooperacion().name());
				
				/** Recuperando o creando objetos */
				/** Manejo de cliente */
				Cliente cliente = new Cliente();
				cliente.setCodigo(operacionderivadocarga.getCodigocliente().trim());
				cliente.setNombre(operacionderivadocarga.getNombrecliente().trim());
				cliente.setCreadoPor(carga.getCreadoPor());
				

				cliente = buscarCliente(clienteService.insertarClienteCarga(cliente));
				operacionderivado.setCliente(cliente);
				
				operacionderivado.setTipocliente(cliente.getTipocliente());
				operacionderivado.setPaisresidencia(cliente.getPaisresidencia());

				
				// se agrega el id divisa a insertar en operacion
				operacionderivado.setIddivisa(buscarDivisa(operacionderivadocarga.getDivisa(), carga.getCreadoPor()).getId());
				operacionderivado.setImportedivisa(new BigDecimal(operacionderivadocarga.getImportedivisa()));
				operacionderivado.setFechaefectiva((Utils.stringtoCalendar(operacionderivadocarga.getFechaefectiva(), TimeFormat.DATEFORMAT)));
				operacionderivado.setFechatermino(Utils.stringtoCalendar(operacionderivadocarga.getFechatermino(), TimeFormat.DATEFORMAT));
				
				if (operacionderivadocarga.getDivisa().equals(monedaPEN)) {
					BigDecimal valorTipoCambio = tipocambioService.listarFechaDivisa(operacionderivado.getFechaefectiva(), monedaDOL);
					
					operacionderivado.setImporteusd(operacionderivado.getImportedivisa()
							 .divide(valorTipoCambio, 6, RoundingMode.HALF_EVEN)
							 .setScale(6, BigDecimal.ROUND_HALF_EVEN));
					
					operacionderivado.setPrima(operacionderivadocarga.getPrima().equals("") ? BigDecimal.ZERO : 
							new BigDecimal(operacionderivadocarga.getPrima())
							.divide(valorTipoCambio, 6, RoundingMode.HALF_EVEN)
							.setScale(6, BigDecimal.ROUND_HALF_EVEN) );
					
				}else if(operacionderivadocarga.getDivisa().equals(monedaDOL)) {
					operacionderivado.setImporteusd(operacionderivado.getImportedivisa());	
					operacionderivado.setPrima(operacionderivadocarga.getPrima().equals("") ? BigDecimal.ZERO : new BigDecimal(operacionderivadocarga.getPrima()));
				}else {
					String codigoMonedaExtranjera = "";
					
					// operaciones entre monedas diferentes a USD y PEN
					BigDecimal tipoCambioMonedaExtranjera;
					BigDecimal tipoCambioUSD;

					codigoMonedaExtranjera = operacionderivadocarga.getDivisa();
					operacionderivado.setImporteusd(operacionderivado.getImportedivisa());
					tipoCambioMonedaExtranjera = tipocambioService.listarFechaDivisa(operacionderivado.getFechaefectiva(), codigoMonedaExtranjera);
					tipoCambioUSD = tipocambioService.listarFechaDivisa(operacionderivado.getFechaefectiva(), monedaDOL);

					// dolarizamos el monto
					operacionderivado.setImporteusd((operacionderivado.getImportedivisa()
									.multiply(tipoCambioMonedaExtranjera.setScale(4 ,BigDecimal.ROUND_HALF_UP)))
									.divide(tipoCambioUSD, 6, RoundingMode.HALF_EVEN)
									.setScale(6, BigDecimal.ROUND_HALF_EVEN));
					
					operacionderivado.setPrima(operacionderivadocarga.getPrima().equals("") ? BigDecimal.ZERO : 
						(new BigDecimal(operacionderivadocarga.getPrima())
						.multiply(tipoCambioMonedaExtranjera.setScale(4 ,BigDecimal.ROUND_HALF_UP)))
						.divide(tipoCambioUSD, 6, RoundingMode.HALF_EVEN)
						.setScale(6, BigDecimal.ROUND_HALF_EVEN) );
				}
				
				//operacionderivado.setImporteusd(new BigDecimal(operacionderivadocarga.getImporteusd()));
				//operacionderivado.setCallput(operacionderivadocarga.getCallput().trim().equals("CALL") ? "C": operacionderivadocarga.getCallput().trim().equals("PUT")? "P" : "");
				operacionderivado.setCallput(operacionderivadocarga.getCallput().trim());
				operacionderivado.setEstilo(operacionderivadocarga.getEstilo().trim());

				operacionderivado.setStrikerate(operacionderivadocarga.getStrikerate().equals("") ? BigDecimal.ZERO : new BigDecimal(operacionderivadocarga.getStrikerate()));
				operacionderivado.setBenchmark(operacionderivadocarga.getBenchmark());
				operacionderivado.setTiposubyacente(operacionderivadocarga.getTiposubyacente().trim());
				operacionderivado.setDescripcionsubyacente(operacionderivadocarga.getDescripcionsubyacente().trim());
				operacionderivado.setPreciopactado(operacionderivadocarga.getPreciopactado().equals("") ? BigDecimal.ZERO : new BigDecimal(operacionderivadocarga.getPreciopactado()));
				operacionderivado.setCommoditytamanocontratounid(operacionderivadocarga.getCommoditytamanocontratounid().equals("") ? BigDecimal.ZERO : new BigDecimal(operacionderivadocarga.getCommoditytamanocontratounid()));
				operacionderivado.setCommoditytamanounidmedida(operacionderivadocarga.getCommoditytamanounidmedida());
				operacionderivado.setBenchmarkfrecuencia(operacionderivadocarga.getBenchmarkfrecuencia());
				operacionderivado.setVolatilidad(operacionderivadocarga.getVolatilidad().equals("") ? BigDecimal.ZERO : new BigDecimal(operacionderivadocarga.getVolatilidad()));
				
				operacionderivado.setDelta(operacionderivadocarga.getDelta().equals("") ? BigDecimal.ZERO : (new BigDecimal(operacionderivadocarga.getDelta())).divide(BigDecimal.valueOf(100)));
				operacionderivado.setIntencioncontratacion(IntencionContratacion.N.name());
			
				operacionderivado.setTipoaccion(operacionderivadocarga.getTipoaccion());
				operacionderivado.setObservacion(operacionderivadocarga.getObservacion());
				

				/** Determinar valor Residente */
				if (cliente.getPaisresidencia().equals(paisPeru)) {
					operacionderivado.setResidente(Residente.R.name());
				} else {
					operacionderivado.setResidente(Residente.N.name());
				}
				
				String correlativo = correlativoService.generaCorrelativoCompuesto("OperacionDerivado");
				operacionderivado.setCorrelativo(correlativo);
				
				operacionesderivados.add(operacionderivado);
				

			} catch (JpaSystemException ex) {
				log.error("Error! ",ex);
				SQLException ge = (SQLException)(ex.getCause().getCause());
				
				String mensaje = ge.getMessage();
				if(mensaje == null) {
					mensaje = "";
				}else {
					mensaje = mensaje.substring(11);
					mensaje = mensaje.split("\\n")[0];
					mensaje = mensaje.substring(0, mensaje.length() < 254 ? mensaje.length()-1 : 254);
				}
				
				operacionderivado.setMensajeerror(((operacionderivado.getMensajeerror() == null) ? "" : operacionderivado.getMensajeerror()) + mensaje + ". ");
				// se agrega el objeto a insertar al log
				operacionesderivadoslogs.add(operacionderivado);
			} catch (Exception ex) {
				log.error("Error! ", ex);
				operacionderivado.setMensajeerror(((operacionderivado.getMensajeerror() == null) ? "" : operacionderivado.getMensajeerror()) + ((ex.getMessage() == null) ? "" : ex.getMessage()) + ". ");
				// se agrega el objeto a insertar al log
				operacionesderivadoslogs.add(operacionderivado);
			}
			
		}
		
		// inserta en la tabla de operaciones
		for (OperacionDerivado operacionderivado : operacionesderivados) {
			try {
//				if (operacionderivado.getCodigodiva().equals("")) {
//					operacionderivado.setCodigoreporte(Utils.calendartoString(operacionderivado.getFechamovimiento(), TimeFormat.DATEFORMAT3) + operacionderivado.getProducto().getCodigobcr() + utils.completeZeros(new BigDecimal(regCargado + 1), 0, 6));
//				}
				
				operacionDerivadoService.guardar(operacionderivado);
				
				regCargado++;
			} catch (Exception ex) {
				operacionderivado.setMensajeerror(((operacionderivado.getMensajeerror() == null) ? "" : operacionderivado.getMensajeerror()) + ex.getMessage() + ". ");
				operacionesderivadoslogs.add(operacionderivado);
			}
		}
		
		try {
			operacionDerivadoService.generarCodigoReporteDerivados(carga);
		} catch (Exception ex) {
			carga.setNotaerror(((carga.getNotaerror() == null) ? "" : carga.getNotaerror()) + ex.getMessage() + ". ");
		}
		
		try {
			operacionDerivadoService.generaUsuariosDivas(carga);
		} catch (Exception ex) {
			carga.setNotaerror(((carga.getNotaerror() == null) ? "" : carga.getNotaerror()) + ex.getMessage() + ". ");
		}
		
		// actualizar valores de carga
		Integer totalArchivo = operacionderivadocargas.size();
		carga.setTotalcargado(regCargado);
		carga.setCondicion(totalArchivo == regCargado);

		
		if (carga.getCondicion().equals(Boolean.FALSE)) {
			carga.setNotaerror(MENSAJE_ERROR_CARGA_GENERICO);
		}
	}
	
	private Cliente buscarCliente(String idCliente) {
		return clienteService.buscarId(idCliente);
	}

	private Producto buscarProducto(String codigoproducto) {
		return productoService.obtenerProductoPorCodigo(codigoproducto);
	}
	
	private Divisa buscarDivisa(String codigoDivisa, String usuario) {

		Long cantidad = divisaService.divisaExistentes(codigoDivisa);

		if (cantidad < 1 && !codigoDivisa.isEmpty()) {
			Divisa divisa = new Divisa();

			divisa.setCodigo(codigoDivisa);
			divisa.setDescripcion(codigoDivisa);
			divisa.setCreadoPor(usuario);

			divisaService.guardar(divisa);
		}

		return divisaService.obtenerDivisaPorCodigo(codigoDivisa);
	}

}
