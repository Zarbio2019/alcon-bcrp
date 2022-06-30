package pe.grupobbva.alcon.mantenimiento.service.process.impl;

import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.beans.Codigoestado;
import pe.grupobbva.alcon.core.beans.TimeFormat;
import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.dto.FeriadoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.process.FilaEstado;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionCargaExtranjeroType;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionOTFXCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.OperacionTasasMXCargaType;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.entity.Ejecutado;
import pe.grupobbva.alcon.mantenimiento.entity.Estado;
import pe.grupobbva.alcon.mantenimiento.entity.Estilo;
import pe.grupobbva.alcon.mantenimiento.entity.IntencionContratacion;
import pe.grupobbva.alcon.mantenimiento.entity.Operacion;
import pe.grupobbva.alcon.mantenimiento.entity.Operacioncarga;
import pe.grupobbva.alcon.mantenimiento.entity.Producto;
import pe.grupobbva.alcon.mantenimiento.entity.Residente;
import pe.grupobbva.alcon.mantenimiento.entity.Tasa;
import pe.grupobbva.alcon.mantenimiento.entity.TasaCurva;
import pe.grupobbva.alcon.mantenimiento.entity.TasaInteres;
import pe.grupobbva.alcon.mantenimiento.entity.TipoAccion;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCarga;
import pe.grupobbva.alcon.mantenimiento.entity.TipoOperacion;
import pe.grupobbva.alcon.mantenimiento.entity.TipoProceso;
import pe.grupobbva.alcon.mantenimiento.entity.ValorParametro;
import pe.grupobbva.alcon.mantenimiento.repository.OperacionCargaRepository;
import pe.grupobbva.alcon.mantenimiento.service.CargaService;
import pe.grupobbva.alcon.mantenimiento.service.ClienteService;
import pe.grupobbva.alcon.mantenimiento.service.CorrelativoService;
import pe.grupobbva.alcon.mantenimiento.service.DeltaService;
import pe.grupobbva.alcon.mantenimiento.service.DivisaService;
import pe.grupobbva.alcon.mantenimiento.service.FeriadoService;
import pe.grupobbva.alcon.mantenimiento.service.OperacionCargaService;
import pe.grupobbva.alcon.mantenimiento.service.OperacionService;
import pe.grupobbva.alcon.mantenimiento.service.ProductoService;
import pe.grupobbva.alcon.mantenimiento.service.SaldoContableService;
import pe.grupobbva.alcon.mantenimiento.service.TasaCurvaService;
import pe.grupobbva.alcon.mantenimiento.service.TasaInteresService;
import pe.grupobbva.alcon.mantenimiento.service.TasaService;
import pe.grupobbva.alcon.mantenimiento.service.TipoCambioService;
import pe.grupobbva.alcon.mantenimiento.service.ValorParametroService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaCalculoTasasService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaInforReportDiarioService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaTasaCurvaService;
import pe.grupobbva.alcon.mantenimiento.service.process.util.BcrpReader;
import pe.grupobbva.alcon.mantenimiento.util.ReportUtils;

@Service
public class CargaInforReportDiarioServiceImpl implements CargaInforReportDiarioService {

	private static final Logger log = LogManager.getLogger();

	private static final String COD_PROD_SPOT = "SPOT";
	private static final String COD_PROD_OUTRIGHT = "OUTRIGHT";
	private static final String COD_PROD_NDF = "NDF";
	
	private static final String PRODUCTOOTFX = "OTFX";
	//private static final String PRODUCTOOTFX2 = "FX Simple Std"; //PSDAEMF2-167: OTFX (Opciones)
	private static final String PRODUCTONDFY = "NDFY";
	private static final String PRODUCTOFXC = "FXC";
	private static final String PRODUCTOFUT = "FUT";
	private static final String PRODUCTOFXW = "FXW";
	private static final String PRODUCTOFXP = "FXP";
	private static final String PRODUCTOFXP2 = "Fx Flex American"; //PSDAEMF2-167: OTFX a FXP (Forward Americano)
	private static final String PRODUCTOFXSW = "FXSW";
	private static final String PRODUCTOIRC = "IRC";
	private static final String PRODUCTOIRD = "IRD";
	private static final String PRODUCTOIRCM = "IRCM";
	private static final String PRODUCTOIRCNF = "IRCNF";
	private static final String PRODUCTOCCSX = "CCSX";
	
	private static final String TFIJA = "F";
	private static final String BENCHMARK_IONXX = "IONXX";
	private static final String BENCHMARK_TIBOX = "TIBOX";
	private static final String BENCHMARK_TPMXX = "TPMXX";
	private static final String BENCHMARK_LIBOR = "LIBOR";
	private static final String BENCHMARK_FFERX = "FFERX";
	private static final String BENCHMARK_SOFRX = "SOFRX";
	private static final String BENCHMARK_EURIB = "EURIB";
	private static final String BENCHMARK_ESTRX = "ESTRX";
	private static final String BENCHMARK_EONIA = "EONIA";
	private static final String BENCHMARK_SONIA = "SONIA";
	private static final String BENCHMARK_TONIA = "TONIA";
	private static final String BENCHMARK_CAMXX = "CAMXX";
	private static final String BENCHMARK_CAMRE = "CAMRE";
	private static final String BENCHMARK_IBRXX = "IBRXX";
	private static final String BENCHMARK_IBR3M = "IBR3M";
	private static final String BENCHMARK_TIIEX = "TIIEX";
	private static final String BENCHMARK_XXXXX = "XXXXX";
	
	
	
	private static final String MENSAJE_REPROCESANDO = "REPROCESANDO";
	public static final String MENSAJE_PROCESANDO = "PROCESANDO";

	@Value("${app.valorescargaoperacion.pais_peru}")
	private String paisPeru;

	@Value("${app.valorescargaoperacion.estado_c}")
	private String cargaoperacionC;

	@Value("${app.valorescargaoperacion.estado_l}")
	private String cargaoperacionL;

	@Value("${app.valorescargaoperacion.estado_a}")
	private String cargaoperacionA;

	@Value("${app.valorescargaoperacion.moneda.pen}")
	private String monedaPEN;

	@Value("${app.valorescargaoperacion.moneda.dollar}")
	private String monedaDOL;

	@Value("${app.valorescargaoperacion.contrato_uno}")
	private String contratoUNO;

	@Value("${app.valorescargaoperacion.valor_inforeport_carga_archivo}")
	private String VALOR_INFOREPORT_CARGA_ARCHIVO;

	@Value("${app.valorescargaoperacion.valor_inforeport_extranjero_carga_archivo}")
	private String VALOR_INFOREPORT_EXTRANJERO_CARGA_ARCHIVO;

	@Value("${app.valorescargaoperacion.valor_inforeport_irc_carga_archivo}")
	private String VALOR_INFOREPORT_IRC_CARGA_ARCHIVO;

	@Value("${app.valorescargaoperacion.valor_inforeport_tasas_mx_carga_archivo}")
	private String VALOR_INFOREPORT_TASAS_MX_CARGA_ARCHIVO;
	
	
	@Value("${app.valorescargaoperacion.valor_inforeportspectrum_carga_archivo}")
	private String VALOR_INFOREPORTSPECTRUM_CARGA_ARCHIVO;

	@Value("${app.valorescargaoperacion.mensaje_advertencia_fecha_feriado}")
	private String MENSAJE_ADVERTENCIA_FECHA_FERIADO;

	@Value("${app.valorescargaoperacion.mensaje_error_fecha}")
	private String MENSAJE_ERROR_FECHA;

	@Value("${app.valorescargaoperacion.mensaje_error_definitivo}")
	private String MENSAJE_ERROR_DEFINITIVO;

	@Value("${app.valorescargaoperacion.mensaje_error_cliente}")
	private String MENSAJE_ERROR_CLIENTE;

	@Value("${app.valorescargaoperacion.mensaje_error_carga_irc}")
	private String MENSAJE_ERROR_CARGA_IRC;
	
	@Value("${app.valorescargaoperacion.mensaje_error_carga_tasasmx}")
	private String MENSAJE_ERROR_CARGA_INFOREPORTASASMX;
	
	@Value("${app.valorescargaoperacion.mensaje_error_tasasircmurex}")
	private String MENSAJE_ERROR_INFOREPORTASASMX;

	@Value("${app.valorescargaoperacion.mensaje_error_importe_cero}")
	private String MENSAJE_ERROR_IMPORTE_CERO;

	@Value("${app.valorescargaoperacion.mensaje_error_carga_inforeport}")
	private String MENSAJE_ERROR_CARGA_INFOREPORT;

	@Value("${app.valorescargaoperacion.mensaje_error_carga_generico}")
	private String MENSAJE_ERROR_CARGA_GENERICO;

	@Value("${app.valorescargaoperacion.mensaje_omision}")
	private String MENSAJE_OMISION;
	
	@Value("${app.valorescargaoperacion.mensaje_pactado}")
	private String MENSAJE_PACTADO;

	@Value("${app.valorescargaoperacion.mensaje_anulacion}")
	private String MENSAJE_ANULACION;

	@Value("${app.valorescargaoperacion.error_tc_cotizacion}")
	private String ERROR_TC_COTIZACION;

	@Value("${app.valorescargaoperacion.error_tc_calculado}")
	private String ERROR_TC_CALCULADO;

	@Autowired
	private OperacionCargaRepository operacionCargaRepository;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private CorrelativoService correlativoService;

	@Autowired
	private ProductoService productoService;

	@Autowired
	private DivisaService divisaService;

	@Autowired
	private ValorParametroService valorParametroService;

	@Autowired
	private FeriadoService feriadoService;

	@Autowired
	private TipoCambioService tipocambioService;

	@Autowired
	private SaldoContableService saldoContableService;

	@Autowired
	private DeltaService deltaService;

	@Autowired
	private OperacionCargaService operacionCargaService;
	
	@Autowired
	private TasaInteresService tasaInteresService;

	@Autowired
	private OperacionService operacionService;

	@Autowired
	private CargaService cargaService;

	@Autowired
	private TasaService tasaService;

	@Autowired
	private CargaCalculoTasasService cargaCalculoTasasService;
	
	@Autowired
	private TasaCurvaService tasaCurvaService;
	
	@Autowired
	private CargaTasaCurvaService cargaTasaCurvaService;

	private void loadOperacionCarga(Carga carga, InputStream file, String filename, List<OperacionCargaType> registros,
			List<Operacioncarga> operacioncargas, Map<String, FilaEstado> errores) {

		if (carga.getTipocarga().equals(String.valueOf(
				TipoCarga.INFOREPORTEXTRANJERO.getNumeroTipoCarga()))
				) {
			List<OperacionCargaExtranjeroType> registrosExtranjero = new ArrayList<>();
			BcrpReader.infoExtranjeroCarga().read(carga, file, filename, registrosExtranjero, errores);
			registros = (List) registrosExtranjero;
		}
		else if (carga.getTipocarga().equals(String.valueOf(TipoCarga.INFOREPORTOTFX.getNumeroTipoCarga()))) {
			
			List<OperacionOTFXCargaType> registrosOTFX = new ArrayList<>();
			BcrpReader.infoOTFXCarga().read(carga, file, filename, registrosOTFX, errores);
			registros = (List) registrosOTFX;
		}
		else if (carga.getTipocarga().equals(String.valueOf(TipoCarga.INFOREPORTASASMX.getNumeroTipoCarga()))) {
			
			List<OperacionTasasMXCargaType> registrosTasasMX = new ArrayList<>();
			BcrpReader.infoTasasMXCarga().read(carga, file, filename, registrosTasasMX, errores);
			registros = (List) registrosTasasMX;
		} 		
		else {
			BcrpReader.inforeportCarga().read(carga, file, filename, registros, errores);
		}

		// PSDAEMF2-168: Excluir los siguientes codigos de Forward Mejorados (Spot, Outright, NDF)
		List<OperacionCargaType> registrosFiltrados = new ArrayList<OperacionCargaType>();
		
		for (OperacionCargaType registroFiltrado: registros)
		{
			String codProd = registroFiltrado.getCodigoproducto().toLowerCase();
			
			if(!codProd.equals(COD_PROD_SPOT.toLowerCase()) && 
			   !codProd.equals(COD_PROD_OUTRIGHT.toLowerCase()) &&
			   !codProd.equals(COD_PROD_NDF.toLowerCase())) {
				
				if(codProd.equals(PRODUCTOFXP2.toLowerCase())) {
					registroFiltrado.setProducto(PRODUCTOFXP);
				}
			
				registrosFiltrados.add(registroFiltrado);
			}
		}

		carga.setTotalreg(registrosFiltrados.size());

		registrosFiltrados.stream().forEach(registro -> {

			try {
				Operacioncarga operacioncarga = new Operacioncarga(registro);
					operacionCargaRepository.save(operacioncarga);
					operacioncargas.add(operacioncarga);

			} catch (ParseException | IllegalArgumentException e) {
				log.error("failed!", e);
			}

		});
	}

	@Override
	public void procesarCarga(Carga carga, InputStream file, String filename, Integer opcionTipoCarga) {
		List<OperacionCargaType> registros = new ArrayList<>();
		List<Operacioncarga> operacioncargas = new ArrayList<>();
		Map<String, FilaEstado> errores = new HashMap<>();

		loadOperacionCarga(carga, file, filename, registros, operacioncargas, errores);
		procesar(carga, operacioncargas, opcionTipoCarga);
	}

	@Override
	public void reprocesar(String cargaId) {

		Carga carga = cargaService.buscarId(cargaId);
		List<Carga> cargasReprocesar = cargaService.listarCargasPosteriores(cargaId, carga.getTipoproceso(),
				carga.getFecha());

		
		
		
		carga.setTotalreg(0);
		carga.setTotalcargado(0);
		carga.setCondicion(true);
		carga.setEjecutado("N");
		carga.setHorafin("");
		carga.setNotaerror(MENSAJE_REPROCESANDO);
		cargaService.guardar(carga);
		
		for (Carga cargaitem : cargasReprocesar) {
			if (cargaitem.getTipocarga().equals("6") || cargaitem.getTipocarga().equals("7") || cargaitem.getTipocarga().equals("16") || cargaitem.getTipocarga().equals("18")) {
				cargaitem.setTotalreg(0);
				cargaitem.setTotalcargado(0);
				cargaitem.setCondicion(true);
				cargaitem.setEjecutado("N");
				cargaitem.setHorafin("");
				cargaitem.setNotaerror(MENSAJE_REPROCESANDO);
				cargaService.guardar(cargaitem);
			}
			else if (cargaitem.getTipocarga().equals("8")  ) {
				cargaitem.setNotaerror(MENSAJE_REPROCESANDO);
				cargaService.guardar(cargaitem);
			}
		}
		
		reproceso(carga);
		
		if (carga.getNotaerror() != null && carga.getNotaerror().equals(MENSAJE_REPROCESANDO)) {
			carga.setNotaerror(null);
			cargaService.guardar(carga);
		}
		
		for (Carga cargaitem : cargasReprocesar) {
			reproceso(cargaitem);
			
			if (cargaitem.getNotaerror() != null && cargaitem.getNotaerror().equals(MENSAJE_REPROCESANDO)) {
				cargaitem.setNotaerror(null);
				cargaService.guardar(cargaitem);
			}
		}

	}

	private void reproceso(Carga carga) {
		if (carga.getTipocarga().equals("6") || carga.getTipocarga().equals("7") || carga.getTipocarga().equals("16") || carga.getTipocarga().equals("18")) {

			operacionService.eliminarOperacionPorIdCarga(carga.getId());

			operacionCargaService.restaurarestadoOperacionCargaPorIdCarga(carga.getId());
			List<Operacioncarga> operacioncargas = operacionCargaRepository.loadOperacionCarga(carga.getId());
			
			carga.setTotalreg(operacioncargas.size());
			try {
				procesar(carga, operacioncargas, Integer.valueOf(carga.getTipocarga()));
			} catch (Exception e) {
				log.error("Error", e);
			} finally {
				DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
				carga.setEjecutado(Ejecutado.S.name());
				carga.setHorafin(dateFormat.format(Calendar.getInstance().getTime()));
				cargaService.guardar(carga);
			}
		} else if(carga.getTipocarga().equals("8") ) {
			cargaCalculoTasasService.reprocesar(carga, new StringBuilder());
			if(carga.getNotaerror().equals(MENSAJE_REPROCESANDO)) {
				carga.setNotaerror(null);	
			}
			
		}

	}

	public void procesar(Carga carga, List<Operacioncarga> operacioncargas, Integer opcionTipoCarga) {

		boolean fechaC2 = Utils.validarFechaNuevaCircular(buscarParametro("039", "FECHA C0002").getValor());
		
		int regCargado = 0;
		ReportUtils utils = new ReportUtils();
		TimeFormat dateformat = Integer.valueOf(carga.getTipocarga()).equals(TipoCarga.INFOREPORTEXTRANJERO.getNumeroTipoCarga()) 
						? TimeFormat.DATEFORMAT2 
						: TimeFormat.DATEFORMAT;

		List<Cliente> clientes = clienteService.listarRechazarCarga();
		List<FeriadoDTO> feriados = feriadoService.listarFeriados();
		List<Operacion> operaciones = new ArrayList<>();
		List<Operacion> operacioneslogs = new ArrayList<>();

		if (carga.getTipoproceso().equals(TipoProceso.A.name())) {
			tipocambioService.copiarUltimo(carga.getFecha());
			saldoContableService.copiarUltimo(carga.getFecha());
			deltaService.copiarUltimo(carga.getFecha());
		}

		for (Operacioncarga operacioncarga : operacioncargas) {

			String codigoDivisaEntrada = operacioncarga.getDivisaentrada();
			String codigoDivisaSalida = operacioncarga.getDivisasalida();
			String codigoDivisaPrima = operacioncarga.getDivisaprima();
			String codigoMonedaExtranjera = "";
			Boolean flgRechazarOperacion = false;

			Operacion operacion = new Operacion();

			try {

				operacion.setIdfilaarchivo(operacioncarga.getIdfilaarchivo());
				operacion.setIdCarga(carga.getId());
				operacion.setCreadoPor(carga.getCreadoPor());
				operacion.setActualizadoPor(carga.getActualizadoPor());
				operacion.setFechamovimiento(carga.getFecha());
				operacion.setFechacontratacion(Utils.stringtoCalendar(operacioncarga.getFechacontratacion(), dateformat));

				operacion.setNumerooperacion(operacioncarga.getNumerooperacion().trim());
				operacion.setImportedivisaentrada(new BigDecimal(operacioncarga.getImportedivisaentrada()));
				operacion.setImportedivisasalida(new BigDecimal(operacioncarga.getImportedivisasalida()));
				operacion.setCotizacion(operacioncarga.getCotizacion().equals("") ? BigDecimal.ZERO : new BigDecimal(operacioncarga.getCotizacion()));
				operacion.setPuntosswap(operacioncarga.getPuntosswap().equals("") ? BigDecimal.ZERO	: new BigDecimal(operacioncarga.getPuntosswap()));
				operacion.setBasica(operacioncarga.getBasica().trim());
				operacion.setCambioref(operacioncarga.getCambioref().equals("") ? BigDecimal.ZERO : new BigDecimal(operacioncarga.getCambioref()));
				operacion.setFechaejercicio(operacioncarga.getFechaejercicio().equals("") ? null : Utils.stringtoCalendar(operacioncarga.getFechaejercicio(), dateformat));
				operacion.setCallput(operacioncarga.getCallput().trim());
				operacion.setPlaza(operacioncarga.getPlaza().trim());
				operacion.setPrima(operacioncarga.getPrima().equals("") ? BigDecimal.ZERO : new BigDecimal(operacioncarga.getPrima()));
				operacion.setFechaalta(operacioncarga.getFechaalta().equals("") ? null : Utils.stringtoCalendar(operacioncarga.getFechaalta(), dateformat));
				operacion.setFechamodificacioncarga(operacioncarga.getFechamodificacioncarga().equals("") ? null : Utils.stringtoCalendar(operacioncarga.getFechamodificacioncarga(), dateformat));
				operacion.setOperacionsustituye(operacioncarga.getOperacionsustituye());
				operacion.setFechabaja(operacioncarga.getFechabaja().equals("") ? null : Utils.stringtoCalendar(operacioncarga.getFechabaja(), dateformat));
				operacion.setNif(operacioncarga.getNif().trim());
				operacion.setIntermediario(operacioncarga.getIntermediario().trim());
				operacion.setIntermediariodescripcion(operacioncarga.getIntermediariodescripcion().trim());
				operacion.setTipoproceso(carga.getTipoproceso());
				operacion.setUsuariocarga(operacioncarga.getUsuario().trim());
				
				if (!operacioncarga.getPaisriesgo().equals("")) {
					operacion.setRiesgopais(buscarParametro("007", operacioncarga.getPaisriesgo().trim()).getValor());
				}

				/** Recuperando o creando objetos */
				/** Manejo de cliente */
				Cliente cliente = new Cliente();
				cliente.setCodigo(operacioncarga.getCodigocliente().trim());
				cliente.setNombre(operacioncarga.getNombrecliente().trim());
				cliente.setPaisresidencia(operacioncarga.getPaisresidencia().trim());
				cliente.setRiesgopais(operacioncarga.getPaisriesgo().trim());
				cliente.setPlaza(operacioncarga.getPlaza().trim());
				cliente.setCreadoPor(carga.getCreadoPor());

				cliente = buscarCliente(clienteService.insertarClienteCarga(cliente));
				operacion.setCliente(cliente);

				operacion.setTipocliente(cliente.getTipocliente());
				operacion.setPaisresidencia(cliente.getPaisresidencia());

				/** Manejo de producto */
				
				String codigoproducto = "";
				
				if (operacioncarga.getProducto().equals(PRODUCTOFXW)) {
					codigoproducto = definirProducto(Utils.stringtoCalendar(operacioncarga.getFechacontratacion(), dateformat), Utils.stringtoCalendar(operacioncarga.getFechavencimiento(), dateformat), feriados);
				} else {
					codigoproducto = operacioncarga.getProducto();
				}
				
				Producto producto = buscarProducto(codigoproducto);
				/** asignamos el valor de codigo de operacion */
				operacion.setCodigooperacion(producto.getCodigobcr());
				operacion.setProducto(producto);
				
				// Inicio cambio nueva circular 0002-2020
				// Recibe TFIJA o spread - Paga TFIJA o spread
				
				if (fechaC2) {
					if (operacion.getProducto().getCodigo().equals(PRODUCTOIRC) 
							|| operacion.getProducto().getCodigo().equals(PRODUCTOIRCNF) 
							|| operacion.getProducto().getCodigo().equals(PRODUCTOCCSX)
							|| operacion.getProducto().getCodigo().equals(PRODUCTOIRD)
							|| operacion.getProducto().getCodigo().equals(PRODUCTOIRCM)) {
						operacion.setRecibetasafijaspread((operacioncarga.getRecibetasafijaspread() == null || operacioncarga.getRecibetasafijaspread().equals("")) ? BigDecimal.ZERO : new BigDecimal(operacioncarga.getRecibetasafijaspread()));
						operacion.setRecibetfija(operacioncarga.getRecibetasafijaspread() == null ? "" : obtenerTFijaCodigoBenchmark(operacioncarga.getRecibetfija()));
						
						if (operacioncarga.getRecibeidentificadorfrecuencia() != null && !operacioncarga.getRecibeidentificadorfrecuencia().equals("")) {
							operacion.setRecibeidentificadorfrecuencia(Utils.padLeftZeros(operacioncarga.getRecibeidentificadorfrecuencia(), 3));
						}
						
						operacion.setPagatasafijaspread((operacioncarga.getPagatasafijaspread() == null || operacioncarga.getPagatasafijaspread().equals("")) ? BigDecimal.ZERO : new BigDecimal(operacioncarga.getPagatasafijaspread()));
						operacion.setPagatfija(operacioncarga.getPagatfija() == null ? "" : obtenerTFijaCodigoBenchmark(operacioncarga.getPagatfija()));
						
						if (operacioncarga.getPagaidentificadorfrecuencia() != null && !operacioncarga.getPagaidentificadorfrecuencia().equals("")) {
							operacion.setPagaidentificadorfrecuencia(Utils.padLeftZeros(operacioncarga.getPagaidentificadorfrecuencia(), 3));
						}
					}
					
					operacion.setIntencioncontratacion(IntencionContratacion.N.name());
				}
				
				// Fin cambio nueva circular 0002-2020

				/** Determinar valor Residente */
				if (cliente.getPaisresidencia().equals(paisPeru)) {
					operacion.setResidente(Residente.R.name());
				} else {
					operacion.setResidente(Residente.N.name());
				}

				/** Verificacion si el estado es C */
				if (operacioncarga.getEstado().equals(cargaoperacionC)) {
					operacion.setEstado(Estado.L.name());
				} else {
					operacion.setEstado(operacioncarga.getEstado());
				}
				
				if (carga.getTipocarga().equals("12")) {
					//String correlativo = correlativoService.generaCorrelativoCompuesto("Operacion");
					//operacion.setCodigoreporte("E"+correlativo);
					if(operacion.getImportedivisaentrada().compareTo(operacion.getImportedivisasalida()) > 0) {
						operacion.setCotizacion(operacion.getImportedivisaentrada().divide(operacion.getImportedivisasalida(), 4, RoundingMode.HALF_UP));
					} else {
						operacion.setCotizacion(operacion.getImportedivisasalida().divide(operacion.getImportedivisaentrada(), 4, RoundingMode.HALF_UP));
					}

				
				}
				/** divide el valor de TasaPEN y TasaUSD entre 100 ya que se en porcentual */

				operacion.setTasamonedanacional(Utils.obtenerNumerico(operacioncarga.getTasapen())
						.divide(BigDecimal.valueOf(100), 6, RoundingMode.HALF_EVEN)
						.setScale(6, BigDecimal.ROUND_HALF_EVEN));
				operacion.setTasamonedaextranjera(Utils.obtenerNumerico(operacioncarga.getTasausd())
						.divide(BigDecimal.valueOf(100), 6, RoundingMode.HALF_EVEN)
						.setScale(6, BigDecimal.ROUND_HALF_EVEN));

				BigDecimal tcDivisaentrada = tipocambioService.listarFechaDivisa(carga.getFecha(), codigoDivisaEntrada);
				BigDecimal tcDivisasalida = tipocambioService.listarFechaDivisa(carga.getFecha(), codigoDivisaSalida);

				if (codigoDivisaEntrada.equals(monedaPEN) && !codigoDivisaSalida.equals(monedaPEN)) {

					operacion.setTipooperacion(TipoOperacion.V.name());
					operacion.setTipocambiovencimiento(tcDivisasalida.divide(tcDivisaentrada, 6, RoundingMode.HALF_EVEN)
							.setScale(6, BigDecimal.ROUND_HALF_EVEN));

				} else if (!codigoDivisaEntrada.equals(monedaPEN) && codigoDivisaSalida.equals(monedaPEN)) {

					operacion.setTipooperacion(TipoOperacion.C.name());
					operacion.setTipocambiovencimiento(tcDivisaentrada.divide(tcDivisasalida));

				} else if (codigoDivisaEntrada.equals(monedaDOL) && !codigoDivisaSalida.equals(monedaDOL)) {

					operacion.setTipooperacion(TipoOperacion.C.name());

					if (!codigoDivisaSalida.equals(monedaPEN)) {
						operacion.setTipocambiovencimiento(tcDivisasalida
								.divide(tcDivisaentrada, 6, RoundingMode.HALF_EVEN)
								.setScale(6, BigDecimal.ROUND_HALF_EVEN));
					}

				} else if (!codigoDivisaEntrada.equals(monedaDOL) && codigoDivisaSalida.equals(monedaDOL)) {

					operacion.setTipooperacion(TipoOperacion.V.name());

					if (!codigoDivisaEntrada.equals(monedaPEN)) {
						operacion.setTipocambiovencimiento(tcDivisaentrada
								.divide(tcDivisasalida, 6, RoundingMode.HALF_EVEN)
								.setScale(6, BigDecimal.ROUND_HALF_EVEN));
					}

				} else if (fechaC2) {
					// cambio nueva circular 0002-2020
					if (operacion.getProducto().getCodigo().equals(PRODUCTOIRD)
						|| operacion.getProducto().getCodigo().equals(PRODUCTOIRCM)) {
						operacion.setTipooperacion(operacioncarga.getTipooperacion().name());
					} else {
						operacion.setTipooperacion(TipoOperacion.N.name());
					}
					operacion.setTipocambiovencimiento(BigDecimal.ZERO);
				}

				// calculamos estilo y tipo de opción
				if (operacion.getProducto().getCodigo().equals(PRODUCTOOTFX)) {
					operacion.setEstilo(Estilo.E.name());
					operacion.setTipoopcion(operacion.getCallput());
				}

				// CALCULAMOS LA FECHA DE VENCIMIENTO Y VALOR
				if(fechaC2) {
					// Verificamos si el producto es NDFY
					if (operacion.getProducto().getCodigo().equals(PRODUCTONDFY)) {
						operacion.setFechavencimiento(Utils.stringtoCalendar(operacioncarga.getFechafixing(), dateformat));						
					} else {
						operacion.setFechavencimiento(Utils.stringtoCalendar(operacioncarga.getFechavencimiento(), dateformat));						
					}
					
					if (operacion.getProducto().getCodigo().equals(PRODUCTOFXC)) {
						operacion.setFechavalor((Utils.stringtoCalendar(operacioncarga.getFechavalor(), dateformat)));					
					} 
					
					if (operacion.getProducto().getCodigo().equals(PRODUCTOIRD) 
							|| operacion.getProducto().getCodigo().equals(PRODUCTOIRCM)) {
						operacion.setFechavalor((Utils.stringtoCalendar(operacioncarga.getFechavalor(), dateformat)));					
					}
					
					if(operacion.getProducto().getCodigo().equals(PRODUCTOFXP) 
							|| operacion.getProducto().getCodigo().equals(PRODUCTOFXSW)
							|| operacion.getProducto().getCodigo().equals(PRODUCTONDFY)
							|| operacion.getProducto().getCodigo().equals(PRODUCTOFUT)
							|| operacion.getProducto().getCodigo().equals(PRODUCTOOTFX)) {
						operacion.setFechavalor((Utils.stringtoCalendar(operacioncarga.getFechacontratacion(), dateformat)));
					}
					
				} else {
					// Verificamos si el producto es NDFY
					if (operacion.getProducto().getCodigo().equals(PRODUCTONDFY)) {
						operacion.setFechavencimiento(Utils.stringtoCalendar(operacioncarga.getFechafixing(), dateformat));
						operacion.setFechavalor((Utils.stringtoCalendar(operacioncarga.getFechafixing(), dateformat)));
					} else {
						operacion.setFechavencimiento(Utils.stringtoCalendar(operacioncarga.getFechavencimiento(), dateformat));
						operacion.setFechavalor(Utils.stringtoCalendar(operacioncarga.getFechavalor(), dateformat));
					}
				}
				
				// verificamos si la fecha de vencimiento es un día util
				if (feriadoService.esDiaUtil(operacion.getFechavencimiento(), feriados).equals(Boolean.FALSE)) {
					Calendar fechaAnterior = operacion.getFechavencimiento();
					operacion.setFechavencimiento(feriadoService.obtenerSiguienteDiaUtil(operacion.getFechavencimiento(), feriados));
					operacion.setValidacion((operacion.getValidacion() == null 
							? "" : operacion.getValidacion()) 
							+ MENSAJE_ADVERTENCIA_FECHA_FERIADO + " "
							+ Utils.calendartoString(fechaAnterior, TimeFormat.DATEFORMAT) 
							+ " - " + Utils.calendartoString(operacion.getFechavencimiento(), TimeFormat.DATEFORMAT) + ". ");
				}

				// Calculo del plazo
				if (operacion.getProducto().getCodigo().equals(PRODUCTOFXC)) {

					operacion.setPlazo(0);
					operacion.setFechacontratacion(carga.getFecha());

					if (operacion.getFechavencimiento().before(operacion.getFechacontratacion())) {
						operacion.setFechavencimiento(carga.getFecha());
						operacion.setFechavalor(carga.getFecha());
					}

				} else {
					// se resta la FechaVencimiento - FechaContratacion
					operacion.setPlazo(Utils.obtenerDirefenciaFechaDias(operacion.getFechacontratacion(), operacion.getFechavencimiento()));
				}

				// clasificar contrato
				if (operacion.getProducto().getCodigo().equals(PRODUCTOOTFX) ||
					operacion.getProducto().getCodigo().equals(PRODUCTOFUT)) {
					operacion.setContrato(contratoUNO);
				} else {
					operacion.setContrato("");
				}

				// calcular tipo cambio SPOT y PACTADO
				switch (operacion.getProducto().getCodigo()) {
				case PRODUCTOFXC:
					operacion.setTipocambiospot(operacion.getCotizacion());
					operacion.setTipocambiopactado(BigDecimal.valueOf(0));
					break;
				case PRODUCTOFXP:
				case PRODUCTOFXSW:	
				case PRODUCTOIRC:
				case PRODUCTOIRCNF:
				case PRODUCTOCCSX:
				case PRODUCTONDFY:
				case PRODUCTOFUT:
				case PRODUCTOOTFX:
					operacion.setTipocambiospot(operacion.getCambioref());
					operacion.setTipocambiopactado(operacion.getCotizacion());
					break;
				default:
					break;

				}

				// calcular Tasa Diferencial
				if (operacion.getTasamonedaextranjera().compareTo(BigDecimal.valueOf(0)) != 0
						&& operacion.getTasamonedanacional().compareTo(new BigDecimal(0)) != 0) {

					BigDecimal tcPactado;
					operacion.setTasadiferencial((((operacion.getTasamonedanacional().add(BigDecimal.valueOf(1)))
							.divide((operacion.getTasamonedaextranjera().add(BigDecimal.valueOf(1))), 6, RoundingMode.HALF_EVEN)
							.setScale(6, BigDecimal.ROUND_HALF_EVEN)).add(BigDecimal.valueOf(-1)))
							.multiply(BigDecimal.valueOf(100)));

					tcPactado = operacion.getTipocambiospot()
							.multiply(((operacion.getTasadiferencial()
							.divide(BigDecimal.valueOf(100), 6, RoundingMode.HALF_EVEN)
							.setScale(6, BigDecimal.ROUND_HALF_EVEN)).add(BigDecimal.valueOf(1)))
							.pow(operacion.getPlazo() / 360));

					// se redondea a 4 decimales para la comparación
					if (tcPactado.setScale(4, BigDecimal.ROUND_HALF_EVEN).compareTo(operacion.getCotizacion().setScale(4, BigDecimal.ROUND_HALF_EVEN)) != 0) {
						operacion.setValidacion(operacion.getValidacion() + ERROR_TC_COTIZACION	+ operacion.getCotizacion() + ERROR_TC_CALCULADO + tcPactado + ". ");
					}
				}

				// CALCULAR VALORES DE LA OPERACION
				String codigoDivisaTemp;
				BigDecimal importeDivisaTemp;

				// verificamos si la divisa Entrada o Salida es USD (USD - contra cualquier moneda)
				if (codigoDivisaEntrada.equals(monedaDOL) || codigoDivisaSalida.equals(monedaDOL)) {

					if (codigoDivisaEntrada.equals(monedaDOL)) {
						operacion.setImporteusd(operacion.getImportedivisaentrada());
						codigoDivisaTemp = codigoDivisaSalida;
						importeDivisaTemp = operacion.getImportedivisasalida();
					} else {
						operacion.setImporteusd(operacion.getImportedivisasalida());
						codigoDivisaTemp = codigoDivisaEntrada;
						importeDivisaTemp = operacion.getImportedivisaentrada();
					}

					// verificamos divisaTemp(Entrada o Salida) es PEN
					if (codigoDivisaTemp.equals(monedaPEN)) {
						operacion.setMontopen(importeDivisaTemp);
					} else {
						// es otra moneda distinta a PEN
						codigoMonedaExtranjera = codigoDivisaTemp;
						operacion.setMontomonedaextranjera(importeDivisaTemp);
					}

				} else {
					// verificamos si la divisa Entrada o Salida es PEN (PEN - Contra cualquier moneda menos USD)
					if (codigoDivisaEntrada.equals(monedaPEN) || codigoDivisaSalida.equals(monedaPEN)) {

						BigDecimal valorTipoCambio = tipocambioService.listarFechaDivisa(operacion.getFechacontratacion(), monedaDOL);

						// si la divisa entrada es PEN
						if (codigoDivisaEntrada.equals(monedaPEN)) {

							operacion.setImporteusd(operacion.getImportedivisaentrada()
									 .divide(valorTipoCambio, 6, RoundingMode.HALF_EVEN)
									 .setScale(6, BigDecimal.ROUND_HALF_EVEN));
							
							operacion.setMontopen(operacion.getImportedivisaentrada());
							codigoDivisaTemp = codigoDivisaSalida;
							importeDivisaTemp = operacion.getImportedivisasalida();

						} else {

							operacion.setImporteusd(operacion.getImportedivisasalida()
									 .divide(valorTipoCambio, 6, RoundingMode.HALF_EVEN)
									 .setScale(6, BigDecimal.ROUND_HALF_EVEN));
							
							operacion.setMontopen(operacion.getImportedivisasalida());
							codigoDivisaTemp = codigoDivisaEntrada;
							importeDivisaTemp = operacion.getImportedivisaentrada();

						}

						// es una moneda distinta a USD
						codigoMonedaExtranjera = codigoDivisaTemp;
						operacion.setMontomonedaextranjera(importeDivisaTemp);

					} else {
						// operaciones entre monedas diferentes a USD y PEN
						BigDecimal tipoCambioMonedaExtranjera;
						BigDecimal tipoCambioUSD;

						codigoMonedaExtranjera = codigoDivisaEntrada;
						operacion.setMontomonedaextranjera(operacion.getImportedivisaentrada());
						tipoCambioMonedaExtranjera = tipocambioService.listarFechaDivisa(operacion.getFechamovimiento(), codigoMonedaExtranjera);
						tipoCambioUSD = tipocambioService.listarFechaDivisa(operacion.getFechacontratacion(), monedaDOL);

						// dolarizamos el monto
						operacion.setImporteusd((operacion.getImportedivisaentrada()
										.multiply(tipoCambioMonedaExtranjera))
										.divide(tipoCambioUSD, 6, RoundingMode.HALF_EVEN)
										.setScale(6, BigDecimal.ROUND_HALF_EVEN));
					}
				}
				
				if ((operacion.getProducto().getCodigo().equals(PRODUCTOIRD) || operacion.getProducto().getCodigo().equals(PRODUCTOIRCM)) 
						&& Utils.truncateToDay(operacion.getFechacontratacion()).compareTo(Utils.truncateToDay(operacion.getFechamovimiento())) == 0) {
					operacion.setTipoaccion(TipoAccion.P.name());
				}

				// Ingresando comentario que sirve para el reporte 3

				if (Utils.truncateToDay(operacion.getFechacontratacion()).compareTo(Utils.truncateToDay(operacion.getFechamovimiento())) != 0) {
					
					log.info("Ingresando comentario que sirve para el reporte 3");
					log.info("Id Fila Archivo --> {}", operacion.getIdfilaarchivo());
					log.info("Fecha Contratacion --> {} || Milisegundos --> {}", operacion.getFechacontratacion().getTime() ,operacion.getFechacontratacion().getTimeInMillis());
					log.info("Fecha Movimiento --> {} || Milisegundos --> {}", operacion.getFechamovimiento().getTime(), operacion.getFechamovimiento().getTimeInMillis());
					log.info("Estado --> {}", operacion.getEstado());
					
					if (operacion.getEstado().equals(cargaoperacionL)) {
						operacion.setObservaciones(((operacion.getObservaciones() == null) ? "" : operacion.getObservaciones()) + MENSAJE_OMISION + ". ");
						operacion.setTipoaccion(TipoAccion.O.name());
					} else {
						operacion.setObservaciones(((operacion.getObservaciones() == null) ? "" : operacion.getObservaciones()) + MENSAJE_ANULACION + ". ");
						operacion.setTipoaccion(TipoAccion.A.name());
					}
				}

				// RECHAZAR OPERACIONES
				// rechazamos las operaciones por fecha y por estado
				if ((Utils.truncateToDay(operacion.getFechacontratacion()).compareTo(Utils.truncateToDay(operacion.getFechamovimiento())) == 0) && !operacion.getEstado().equals(cargaoperacionL)) {
					flgRechazarOperacion = true;
					operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror()) + MENSAJE_ERROR_FECHA + ". ");
				} else {

					// rechazar operaciones para el proceso definitivo
					if (operacion.getTipoproceso().equals(TipoProceso.D.name())
							&& (Utils.truncateToDay(operacion.getFechacontratacion()).compareTo(Utils.truncateToDay(operacion.getFechamovimiento())) != 0)
							&& operacion.getProducto().getCodigo().equals(PRODUCTOFXC)
							&& operacion.getEstado().equals(cargaoperacionA)) {
						flgRechazarOperacion = true;
						operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror()) + MENSAJE_ERROR_DEFINITIVO + ". ");
					}
					// rechazar operaciones para el tipo de carga TASAS-IRC MUREX
					if (carga.getTipocarga().equals(String.valueOf(TipoCarga.INFOREPORTASASMX.getNumeroTipoCarga()))
							&& (Utils.truncateToDay(operacion.getFechacontratacion()).compareTo(Utils.truncateToDay(operacion.getFechamovimiento())) != 0)
							&& !operacion.getEstado().equals(cargaoperacionL)) {
						flgRechazarOperacion = true;
						operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror()) + MENSAJE_ERROR_INFOREPORTASASMX + ". ");
					}
				}

				// rechazar operaciones por cliente
				if (verificarUsuarioListaRechazo(clientes, operacioncarga.getCodigocliente().trim()).equals(Boolean.TRUE)) {
					flgRechazarOperacion = true;
					operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror()) + MENSAJE_ERROR_CLIENTE + ". ");
				}

				String codigoProductoTemp = "";
				if (operacion.getProducto().getCodigo().equals(PRODUCTOIRCNF) || operacion.getProducto().getCodigo().equals(PRODUCTOCCSX)) {
					codigoProductoTemp = PRODUCTOIRC;
				} else {
					codigoProductoTemp = operacion.getProducto().getCodigo();
				}

				// rechazar operaciones por Tipo de carga y producto

                if (TipoCarga.INFOREPORTIRC.getNumeroTipoCarga() == opcionTipoCarga    && !(codigoProductoTemp.equals(PRODUCTOIRC) || codigoProductoTemp.equals(PRODUCTOIRD) || codigoProductoTemp.equals(PRODUCTOIRCM))) {
                    flgRechazarOperacion = true;
                    operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror()) + MENSAJE_ERROR_CARGA_IRC + ". ");
                }

                if ((TipoCarga.INFOREPORTDIARIO.getNumeroTipoCarga() == opcionTipoCarga || TipoCarga.INFOREPORTOTFX.getNumeroTipoCarga() == opcionTipoCarga || TipoCarga.INFOREPORTEXTRANJERO.getNumeroTipoCarga() == opcionTipoCarga) && codigoProductoTemp.equals(PRODUCTOIRC)) {
                    flgRechazarOperacion = true;
                    operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror()) + MENSAJE_ERROR_CARGA_INFOREPORT + ". ");
                }
                
                if (TipoCarga.INFOREPORTASASMX.getNumeroTipoCarga() == opcionTipoCarga     && (operacion.getProducto().getCodigo().equals(PRODUCTOIRCM))) {
                    flgRechazarOperacion = true;
                    operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror()) + MENSAJE_ERROR_CARGA_INFOREPORTASASMX + ". ");
                }
                

				//Inicio Mejora para nueva circular 0002
				if (TipoCarga.INFOREPORTIRC.getNumeroTipoCarga() == opcionTipoCarga 
						&& (operacion.getImportedivisaentrada().compareTo(BigDecimal.ZERO) == 0)
						&& (operacion.getImportedivisasalida().compareTo(BigDecimal.ZERO) == 0)) {
					flgRechazarOperacion = true;
					operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror()) + MENSAJE_ERROR_IMPORTE_CERO + ". ");
				}
				//Fin Mejora para nueva circular 0002

				// agregar a la lista
				if (flgRechazarOperacion) {
					// se agrega el objeto a insertar al log de operacion
					operacioneslogs.add(operacion);
				} else {
					// se agrega el objeto a insertar en operacion
					operacion.setIddivisaentrada(buscarDivisa(codigoDivisaEntrada, carga.getCreadoPor()).getId());
					operacion.setIddivisasalida(buscarDivisa(codigoDivisaSalida, carga.getCreadoPor()).getId());

					if (!codigoDivisaPrima.equals("")) {
						operacion.setIddivisaprima(buscarDivisa(codigoDivisaPrima, carga.getCreadoPor()).getId());
					}

					if (!codigoMonedaExtranjera.isEmpty()) {
						operacion.setIdmonedaextranjera(buscarDivisa(codigoMonedaExtranjera, carga.getCreadoPor()).getId());
					}

					/*********************************************************************************************/
//					Operacion operaciontmp = obtenerHistoricoNumeroOperacion(operacion, carga);
//					operacion.setNumerooperacion(operaciontmp.getNumerooperacion());
//					operacion.setHistorico(operaciontmp.getHistorico());
//					operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror()) + operaciontmp.getMensajeerror());

//					if (operacion.getHistorico() != 0) {
//						String correlativo = correlativoService.generaCorrelativoCompuesto("Operacion");
//						operacion.setCorrelativo(correlativo);
//						
//						if(!carga.getTipocarga().equals("12")) {
//							
//							operaciontmp = obtenerTasasMonedas(operacion.getNumerooperacion());
//	
//							if (operaciontmp != null) {
//								operacion.setTasamonedanacional(operaciontmp.getTasamonedanacional() == null 
//												? BigDecimal.ZERO
//												: operaciontmp.getTasamonedanacional());
//								operacion.setTasamonedaextranjera(operaciontmp.getTasamonedaextranjera() == null 
//												? BigDecimal.ZERO
//												: operaciontmp.getTasamonedaextranjera());
//							}
//						} else {
//							operacion.setNumerooperacion(correlativo);
//							operacion.setCodigoreporte("E" + correlativo);		
//						}

						operaciones.add(operacion);
//					}
					
					/*********************************************************************************************/
				}


			} catch(JpaSystemException ex) {
				log.error("failed!", ex);
				SQLException ge= (SQLException)(ex.getCause().getCause());

				
				String mensaje = ge.getMessage();
				if(mensaje == null) {
					mensaje = "";
				} else {
					mensaje = mensaje.substring(11);
					mensaje = mensaje.split("\\n")[0];
					mensaje = mensaje.substring(0, mensaje.length() < 254 ? mensaje.length() - 1 : 254);
				}
				
				
				operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror()) + mensaje + ". ");
				// se agrega el objeto a insertar al log
				operacioneslogs.add(operacion);
				
			} catch (Exception ex) {
				log.error("failed!", ex);
				
				operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror())
						+ ((ex.getMessage() == null) ? "" : ex.getMessage()) + ". ");

				// se agrega el objeto a insertar al log
				operacioneslogs.add(operacion);
			}
		}

		// Proceso en la tabla principal de operaciones
		// ELIMINAMOS las operaciones de inforeport IRC ANTERIORES para el proceso de
		// carga
		if (String.valueOf(carga.getTipocarga()).equals(VALOR_INFOREPORT_IRC_CARGA_ARCHIVO)) {
			operacionService.actualizarEstadoIRC(carga, Codigoestado.INACTIVO.getCodigoestado());
		}

		// ELIMINA las Operaciones que se van a volver a cargar en la misma fecha de
		// proceso
		if(!Integer.valueOf(carga.getTipocarga()).equals(TipoCarga.INFOREPORTEXTRANJERO.getNumeroTipoCarga())) {
			operacionService.eliminarOperaciones(carga);
		}
		

		// inserta en la tabla de operaciones
		for (Operacion operacion : operaciones) {
			try {
				if(operacion.getProducto().getCodigo().equals(PRODUCTOIRD) || operacion.getProducto().getCodigo().equals(PRODUCTOIRCM)) {
					
					TasaInteres tasainteres = cargaTasaInteres(operacion);
					
					TasaInteres tasainterestmp = obtenerHistoricoNumeroOperacionDerivadoTasaInteres(tasainteres, carga);
					tasainteres.setNumerooperacion(tasainterestmp.getNumerooperacion());
					tasainteres.setHistorico(tasainterestmp.getHistorico());
					tasainteres.setMensajeerror(((tasainteres.getMensajeerror() == null) ? "" : tasainteres.getMensajeerror()) + tasainterestmp.getMensajeerror());
					
					//operacion.setCodigoreporte(Utils.calendartoString(operacion.getFechamovimiento(), TimeFormat.DATEFORMAT3) + operacion.getProducto().getCodigobcr() + utils.completeZeros(new BigDecimal(regCargado + 1), 0, 6));
					
					if (tasainteres.getHistorico() != 0) {
						String correlativo = correlativoService.generaCorrelativoCompuesto("TasaInteres");
						tasainteres.setCorrelativo(correlativo);
					}
					
					tasaInteresService.guardar(tasainteres);
					
				} else {
					
					Operacion operaciontmp = obtenerHistoricoNumeroOperacion(operacion, carga);
					operacion.setNumerooperacion(operaciontmp.getNumerooperacion());
					operacion.setHistorico(operaciontmp.getHistorico());
					operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror()) + operaciontmp.getMensajeerror());

					if (operacion.getHistorico() != 0) {
						String correlativo = correlativoService.generaCorrelativoCompuesto("Operacion");
						operacion.setCorrelativo(correlativo);
						
						if(!carga.getTipocarga().equals("12")) {
							
							operaciontmp = obtenerTasasMonedas(operacion.getNumerooperacion());
	
							if (operaciontmp != null) {
								operacion.setTasamonedanacional(operaciontmp.getTasamonedanacional() == null 
												? BigDecimal.ZERO
												: operaciontmp.getTasamonedanacional());
								operacion.setTasamonedaextranjera(operaciontmp.getTasamonedaextranjera() == null 
												? BigDecimal.ZERO
												: operaciontmp.getTasamonedaextranjera());
							}
						} else {
							operacion.setNumerooperacion(correlativo);
							//operacion.setCodigoreporte("E" + correlativo);		
						}
					}
					
					operacionService.guardar(operacion);
				}
				
				regCargado++;
			} catch (Exception ex) {
				operacion.setMensajeerror(((operacion.getMensajeerror() == null) ? "" : operacion.getMensajeerror()) + ex.getMessage() + ". ");
				operacioneslogs.add(operacion);
			}
		}
		
		//Inicio Cambios para nueva circular 0002
		//Calculo de fecha efectiva para IRC bullet e IRC amortizable
		if (fechaC2 && (String.valueOf(carga.getTipocarga()).equals(VALOR_INFOREPORT_IRC_CARGA_ARCHIVO)||String.valueOf(carga.getTipocarga()).equals(VALOR_INFOREPORT_TASAS_MX_CARGA_ARCHIVO))) {
			//Calculo de fecha efectiva para IRC bullet e IRC amortizable
			operacionService.actualizarFechaEfectiva(carga);
			
			//Calculo de fecha efectiva para IRD amortizable
			tasaInteresService.actualizarFechaEfectiva(carga);
		}
		//Fin Cambios para nueva circular 0002

		// GENERAR OPERACIONES MENORES A 500 MIL - INFOREPORT
		if (carga.getTipocarga().equals(VALOR_INFOREPORT_CARGA_ARCHIVO)
			//	|| carga.getTipocarga().equals(VALOR_INFOREPORT_EXTRANJERO_CARGA_ARCHIVO)
				) {

			try {
				operacionService.generarOperacionesMenoresQuinientosMil(carga);
			} catch (Exception ex) {
				carga.setNotaerror(((carga.getNotaerror() == null) ? "" : carga.getNotaerror()) + ex.getMessage() + ". ");
			}
		}

		// GENERAR OPERACIONES MENORES A 500 MIL - INFOREPORT para spectrum!!!
		if (String.valueOf(carga.getTipocarga()).equals(VALOR_INFOREPORTSPECTRUM_CARGA_ARCHIVO)) {
			try {
				operacionService.generarOperacionesMenoresQuinientosMil(carga);
			} catch (Exception ex) {
				carga.setNotaerror(((carga.getNotaerror() == null) ? "" : carga.getNotaerror()) + ex.getMessage() + ". ");
			}
		}

		// GENERAR CODIGO REPORTE PARA LAS OPERACIONES DEL REPORTE 1
		try {
			//if(!carga.getTipocarga().equals("12")) {
				operacionService.generarCodigoReporte1(carga);
			//}	
		} catch (Exception ex) {
			carga.setNotaerror(((carga.getNotaerror() == null) ? "" : carga.getNotaerror()) + ex.getMessage() + ". ");
		}
		
		// GENERAR CODIGO REPORTE PARA LAS OPERACIONES DEL REPORTE 6
		try {
			tasaInteresService.generarCodigoReporte6(carga);	
		} catch (Exception ex) {
			carga.setNotaerror(((carga.getNotaerror() == null) ? "" : carga.getNotaerror()) + ex.getMessage() + ". ");
		}

		// GENERAR CODIGO REPORTE PARA LAS OPERACIONES DEL REPORTE 3
		try {
			operacionService.generarCodigoReporte3(carga);
		} catch (Exception ex) {
			carga.setNotaerror(((carga.getNotaerror() == null) ? "" : carga.getNotaerror()) + ex.getMessage() + ". ");
		}

		if (carga.getTipoproceso().equals(TipoProceso.A.name())) {
			// ACTUALIZA TASAS
			List<Tasa> tasas = tasaService.listarTasaFechaMaximaContratacion();
			Carga cargatasa = carga;

			if (!tasas.isEmpty()) {
				cargaCalculoTasasService.calcularTasas(cargatasa, tasas);
				cargaCalculoTasasService.calcularTasasPredatadas(cargatasa);
			}
			
			// ACTUALIZA TASAS CURVAS
			List<TasaCurva> tasascurvas = tasaCurvaService.listarTasaCurvaFechaMaximaContratacion();
			
			if (!tasascurvas.isEmpty()) {
				cargaTasaCurvaService.calcularTasasCurvas(cargatasa, tasascurvas);
				
			}
			
			// TRAE LAS OPERACIONES QUE LA FECHA DE VENCIMIENTO SEA IGUAL
			operacionService.generarCodigoReporte2Adelantado(carga);
		}

		// Actualizamos el estado de error de las operaciones que no se cargaron
		for (Operacion operacionlog : operacioneslogs) {
			operacionCargaService.actualizarMensajeError(operacionlog);
		}

		// actualizar valores de carga
		Integer totalArchivo = operacioncargas.size();
		carga.setTotalcargado(regCargado);
		carga.setCondicion(totalArchivo == regCargado);

		
		if (carga.getCondicion().equals(Boolean.FALSE)) {
			carga.setNotaerror(MENSAJE_ERROR_CARGA_GENERICO);
		}
		

		/* Comento el reproceso de manera manual
		List<CargaDTO> cargasreprocesar = cargaService.listarCargaPorReprocesar(carga.getFecha());
		for (CargaDTO cargareprocesar : cargasreprocesar) {
			cargaService.reprocesar(cargareprocesar.getId());
		}*/

	} // fin de la carga de la lista de operaciones

	private Cliente buscarCliente(String idCliente) {
		return clienteService.buscarId(idCliente);
	}

	private Producto buscarProducto(String codigoproducto) {
		return productoService.obtenerProductoPorCodigo(codigoproducto);
	}
	
	private String definirProducto(Calendar fechaContratacion, Calendar fechaVencimiento, List<FeriadoDTO> feriados) {
		String codigoProducto = "";

		int plazo = feriadoService.diasHabiles(fechaContratacion, fechaVencimiento, feriados);
		
		if (plazo > 3) {
			codigoProducto = PRODUCTOFXP;
		} else {
			codigoProducto = PRODUCTOFXC;
		}
		
		return codigoProducto;
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

	private ValorParametro buscarParametro(String codigoParametro, String descripcion) {
		return valorParametroService.obtenerParametroPorCodigo(codigoParametro, descripcion);
	}
	
	private TasaInteres obtenerHistoricoNumeroOperacionDerivadoTasaInteres(TasaInteres tasainteres, Carga carga) {
		Integer historico = 0;
		String numerooperacion;
		Integer codigoestado;
		Long cantidad;
		String errorop = "";
		
		TasaInteres operacionTasaInteres = new TasaInteres();
		

		if ((Integer.valueOf(carga.getTipocarga()).equals(TipoCarga.INFOREPORTIRC.getNumeroTipoCarga()) ||Integer.valueOf(carga.getTipocarga()).equals(TipoCarga.INFOREPORTASASMX.getNumeroTipoCarga())) && !tasainteres.getEstado().equals(cargaoperacionA)) {

			numerooperacion = tasaInteresService.generaIRD(tasainteres.getProducto().getCodigo(), tasainteres.getNumerooperacion());
		} else {
			numerooperacion = operacionTasaInteres.getNumerooperacion();
			historico = tasaInteresService.obtenerMaximoHistoricoDerivadoTasaInteres(numerooperacion, operacionTasaInteres.getTipoproceso());
		}
		
		if (historico == 0) {
			historico = 1;
		} else {
			codigoestado = tasaInteresService.obtenerCodigoEstado(numerooperacion, tasainteres.getTipoproceso(), historico);

			if (codigoestado == 2) {
				historico = historico + 1;
			} else {
				tasainteres.setHistorico(historico);
				tasainteres.setNumerooperacion(numerooperacion);
				cantidad = tasaInteresService.verificarCambioUltimaOperacionDerivadoTasaInteres(tasainteres);

				if (cantidad > 0) {
					// para evitar q inserte el mismo registro 2 veces ya no se inserta
					tasaInteresService.eliminarOperacionDerivadoTasaInteresFechaMovimiento(numerooperacion, tasainteres.getTipoproceso(), tasainteres.getFechamovimiento(), historico);
					historico = historico + 1;
				} else {
					historico = null;
					errorop = "Existe un registro idéntico para la operación de derivado tasa interés " + numerooperacion;
				}
			}
		}
		
		operacionTasaInteres.setNumerooperacion(numerooperacion);
		operacionTasaInteres.setHistorico(historico);
		operacionTasaInteres.setMensajeerror(errorop);

		return operacionTasaInteres;
		
	}

	private Operacion obtenerHistoricoNumeroOperacion(Operacion operacion, Carga carga) {
		Integer historico = 0;
		String numerooperacion;
		Integer codigoestado;
		Long cantidad;
		String errorop = "";

		Operacion operaciontmp = new Operacion();

        if ((Integer.valueOf(carga.getTipocarga()).equals(TipoCarga.INFOREPORTIRC.getNumeroTipoCarga())||(Integer.valueOf(carga.getTipocarga()).equals(TipoCarga.INFOREPORTASASMX.getNumeroTipoCarga()))) && !operacion.getEstado().equals(cargaoperacionA)) {        
            numerooperacion = operacionService.generaIRC("IRC", operacion.getNumerooperacion());
        } else if(carga.getTipocarga().equals("12")) {
            historico=0;
            numerooperacion = operacion.getNumerooperacion();
        } else {
            numerooperacion = operacion.getNumerooperacion();
            historico = operacionService.obtenerMaximoHistorico(numerooperacion, operacion.getTipoproceso());
        }

		if (historico == 0) {
			historico = 1;
		} else {
			codigoestado = operacionService.obtenerCodigoEstado(numerooperacion, operacion.getTipoproceso(), historico);

			if (codigoestado == 2) {
				historico = historico + 1;
			} else {
				operacion.setHistorico(historico);
				operacion.setNumerooperacion(numerooperacion);
				cantidad = operacionService.verificarCambioUltimaOperacion(operacion);

				if (cantidad > 0) {
					// para evitar q inserte el mismo registro 2 veces ya no se inserta
					operacionService.eliminarOperacionFechaMovimiento(numerooperacion, operacion.getTipoproceso(), operacion.getFechamovimiento(), historico);
					historico = historico + 1;
				} else {
					historico = null;
					errorop = "Existe un registro idéntico para la operación " + numerooperacion;
				}
			}
		}

		operaciontmp.setNumerooperacion(numerooperacion);
		operaciontmp.setHistorico(historico);
		operaciontmp.setMensajeerror(errorop);

		return operaciontmp;
	}

	private Operacion obtenerTasasMonedas(String numerooperacion) {
		return operacionService.obtenerTasasMonedas(numerooperacion);
	}

	private Boolean verificarUsuarioListaRechazo(List<Cliente> clientes, String codigoCliente) {
		Boolean flag = false;

		for (Cliente cliente : clientes) {
			if (cliente.getCodigo().equals(codigoCliente)) {
				flag = true;
				break;
			}
		}

		return flag;
	}
	
	private String obtenerTFijaCodigoBenchmark(String nombre) {
		String resultado = "";
		
		if (nombre.equals(TFIJA)) {
			resultado = "TFIJA";
		} else if (nombre.contains(BENCHMARK_IONXX)) {
			resultado = BENCHMARK_IONXX;
		} else if (nombre.contains(BENCHMARK_TIBOX)) {
			resultado = BENCHMARK_TIBOX;
		} else if (nombre.contains(BENCHMARK_TPMXX)) {
			resultado = BENCHMARK_TPMXX;
		} else if (nombre.contains(BENCHMARK_LIBOR)) {
			resultado = BENCHMARK_LIBOR;
		} else if (nombre.contains(BENCHMARK_FFERX)) {
			resultado = BENCHMARK_FFERX;
		} else if (nombre.contains(BENCHMARK_SOFRX)) {
			resultado = BENCHMARK_SOFRX;
		} else if (nombre.contains(BENCHMARK_EURIB)) {
			resultado = BENCHMARK_EURIB;
		} else if (nombre.contains(BENCHMARK_ESTRX)) {
			resultado = BENCHMARK_ESTRX;
		} else if (nombre.contains(BENCHMARK_EONIA)) {
			resultado = BENCHMARK_EONIA;
		} else if (nombre.contains(BENCHMARK_SONIA)) {
			resultado = BENCHMARK_SONIA;
		} else if (nombre.contains(BENCHMARK_TONIA)) {
			resultado = BENCHMARK_TONIA;
		} else if (nombre.contains(BENCHMARK_CAMXX)) {
			resultado = BENCHMARK_CAMXX;
		} else if (nombre.contains(BENCHMARK_CAMRE)) {
			resultado = BENCHMARK_CAMRE;
		} else if (nombre.contains(BENCHMARK_IBRXX)) {
			resultado = BENCHMARK_IBRXX;
		} else if (nombre.contains(BENCHMARK_IBR3M)) {
			resultado = BENCHMARK_IBR3M;
		} else if (nombre.contains(BENCHMARK_TIIEX)) {
			resultado = BENCHMARK_TIIEX;
		} else {
			resultado = BENCHMARK_XXXXX;
		}
		
		return resultado;
	}
	
	private TasaInteres cargaTasaInteres(Operacion operacion) {
		TasaInteres tasainteres = new TasaInteres();
		
		tasainteres.setFechacontratacion(operacion.getFechacontratacion());
		tasainteres.setProducto(operacion.getProducto());
		tasainteres.setNumerooperacion(operacion.getNumerooperacion());
		tasainteres.setCliente(operacion.getCliente());
		tasainteres.setTipooperacion(operacion.getTipooperacion());
		tasainteres.setIddivisaentrada(operacion.getIddivisaentrada());
		tasainteres.setIddivisasalida(operacion.getIddivisasalida());
		tasainteres.setImportedivisaentrada(operacion.getImportedivisaentrada());
		tasainteres.setImportedivisasalida(operacion.getImportedivisasalida());
		tasainteres.setCotizacion(operacion.getCotizacion());
		tasainteres.setPuntosswap(operacion.getPuntosswap());
		tasainteres.setBasica(operacion.getBasica());
		tasainteres.setCambioref(operacion.getCambioref());
		tasainteres.setFechavalor(operacion.getFechavalor());
		tasainteres.setFechavencimiento(operacion.getFechavencimiento());
		tasainteres.setPlazo(operacion.getPlazo());
		tasainteres.setFechaejercicio(operacion.getFechaejercicio());
		tasainteres.setCallput(operacion.getCallput());
		tasainteres.setPlaza(operacion.getPlaza());
		tasainteres.setPaisresidencia(operacion.getPaisresidencia());
		tasainteres.setRiesgopais(operacion.getRiesgopais());
		tasainteres.setPrima(operacion.getPrima());
		tasainteres.setIddivisaprima(operacion.getIddivisaprima());
		tasainteres.setObservaciones(operacion.getObservaciones());
		tasainteres.setFechaalta(operacion.getFechaalta());
		tasainteres.setFechamodificacioncarga(operacion.getFechamodificacioncarga());
		tasainteres.setOperacionsustituye(operacion.getOperacionsustituye());
		tasainteres.setFechabaja(operacion.getFechabaja());
		tasainteres.setNif(operacion.getNif());
		tasainteres.setIntermediario(operacion.getIntermediario());
		tasainteres.setIntermediariodescripcion(operacion.getIntermediariodescripcion());
		tasainteres.setUsuariocarga(operacion.getUsuariocarga());
		tasainteres.setEstado(operacion.getEstado());
		tasainteres.setRecibetasafijaspread(operacion.getRecibetasafijaspread());
		tasainteres.setRecibetfija(operacion.getRecibetfija());
		tasainteres.setRecibeidentificadorfrecuencia(operacion.getRecibeidentificadorfrecuencia());
		tasainteres.setPagatasafijaspread(operacion.getPagatasafijaspread());
		tasainteres.setPagatfija(operacion.getPagatfija());
		tasainteres.setPagaidentificadorfrecuencia(operacion.getPagaidentificadorfrecuencia());
		tasainteres.setVolatilidad(operacion.getVolatilidad());
		tasainteres.setIntencioncontratacion(operacion.getIntencioncontratacion());
		tasainteres.setTipoaccion(operacion.getTipoaccion());
		tasainteres.setCodigoagrupacion(operacion.getCodigoagrupacion());
		tasainteres.setCodigooperacion(operacion.getCodigooperacion());
		tasainteres.setCodigoreporte(operacion.getCodigoreporte());
		tasainteres.setContrato(operacion.getContrato());
		tasainteres.setCorrelativo(operacion.getCorrelativo());
		tasainteres.setDelta(operacion.getDelta());
		tasainteres.setEstilo(operacion.getEstilo());
		tasainteres.setFechamovimiento(operacion.getFechamovimiento());
		tasainteres.setHistorico(operacion.getHistorico());
		tasainteres.setIdCarga(operacion.getIdCarga());
		tasainteres.setIdfilaarchivo(operacion.getIdfilaarchivo());
		tasainteres.setIdmonedaextranjera(operacion.getIdmonedaextranjera());
		tasainteres.setImporteusd(operacion.getImporteusd());
		tasainteres.setMensajeerror(operacion.getMensajeerror());
		
		if (!operacion.getProducto().getCodigo().equals(PRODUCTOIRCM)) {
			tasainteres.setMontomonedaextranjera(operacion.getMontomonedaextranjera());
		}
		
		tasainteres.setMontopen(operacion.getMontopen());
		tasainteres.setResidente(operacion.getResidente());
		tasainteres.setTasadiferencial(operacion.getTasadiferencial());
		tasainteres.setTasamonedaextranjera(operacion.getTasamonedaextranjera());
		tasainteres.setTasamonedanacional(operacion.getTasamonedanacional());
		tasainteres.setTipocambiopactado(operacion.getTipocambiopactado());
		tasainteres.setTipocambiospot(operacion.getTipocambiospot());
		tasainteres.setTipocambiovencimiento(operacion.getTipocambiovencimiento());
		tasainteres.setTipocliente(operacion.getTipocliente());
		tasainteres.setTipoopcion(operacion.getTipoopcion());
		tasainteres.setTipoproceso(operacion.getTipoproceso());
		tasainteres.setValidacion(operacion.getValidacion());
		
		return tasainteres;
		
	}

}