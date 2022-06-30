package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.custom.FiltroReporte;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.FiltroReporteResponse;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSeisC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteSieteC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteUnoC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ClienteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.ClienteTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;
import pe.grupobbva.alcon.mantenimiento.entity.CodigoStarAltamira;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCliente;
import pe.grupobbva.alcon.mantenimiento.entity.ValorParametro;
import pe.grupobbva.alcon.mantenimiento.repository.ClienteRepository;
import pe.grupobbva.alcon.mantenimiento.service.ClienteService;
import pe.grupobbva.alcon.mantenimiento.service.ReportFilterService;
import pe.grupobbva.alcon.mantenimiento.service.ReporteSeisC2Service;
import pe.grupobbva.alcon.mantenimiento.service.ReporteSieteC2Service;
import pe.grupobbva.alcon.mantenimiento.service.ReporteUnoC2Service;
import pe.grupobbva.alcon.mantenimiento.service.ValorParametroService;
import pe.grupobbva.alcon.mantenimiento.service.ws.TransaccionClient;

@Service
public class ClienteServiceImpl extends AbstractServiceImpl<Cliente> implements ClienteService {

	private static final Logger log = LogManager.getLogger();
	
	@Value("${app.ws.str_idlogin}")
	private String stridlogin;
	
	@Value("${app.ws.str_idtrama}")
	private String stridtrama;
	
	@Value("${app.ws.str_trama_entidad}")
	private String strtramaentidad;
	
	@Value("${app.ws.str_trama_cod_cliente}")
	private String strtramacodcliente;
	
	@Value("${app.ws.str_trama_ind_continu}")
	private String strtramaindcontinu;
	
	@Value("${app.ws.str_trama_num_cta_cliente}")
	private String strtramanumctacliente;
	
	@Value("${app.ws.str_trama_num_tip_moneda}")
	private String strtramanumtipmoneda;
	
	@Value("${app.ws.str_trama_cod_usuario}")
	private String strtramacodusuario;
	
	@Value("${app.ws.str_ambiente_host}")
	private String strambientehost;
	
	@Value("${app.ws.str_sesion}")
	private String strsesion;
	
	@Value("${app.ws.str_cod_sistema}")
	private String strcodsistema;
	
	@Value("${app.valoresparametro.credenciales_interfaz}")
	private String credencialesinterfaz;

	@Value("${app.valoresparametro.pais}")
	private String codigopais;

	@Autowired
	private ReporteUnoC2Service reporteUnoC2Service;
	
	@Autowired
	private ReporteSeisC2Service reporteSeisC2Service;
	
	@Autowired
	private ReporteSieteC2Service reporteSieteC2Service;
	
	@Autowired
	private TransaccionClient transaccionClient;
	
	@Autowired
	private ReportFilterService reportFilterService;
	
	@Autowired
	private ValorParametroService valorParametroService;

	@Override
	public DatatableDTO<ClienteTableDTO> search(ClienteSearch clientSearch) {
		return ((ClienteRepository) repository).search(clientSearch);
	}

	@Override
	public void guardar(Cliente entity) {

		Long registros = ((ClienteRepository) repository).clientesDuplicados(entity.getCodigo(),
				entity.getCodigoestado());

		if (registros > 0l) {
			ValidatorUtil.validateMessage("codigo", "Código Duplicado");
		}

		super.guardar(entity);
	}

	@Override
	public void actualizar(Cliente entity) {
		Long registros = ((ClienteRepository) repository).clientesDuplicadosActualizar(entity.getCodigo(),
				entity.getCodigoestado(), entity.getId());

		if (registros > 0l) {
			ValidatorUtil.validateMessage("codigo", "Código Duplicado");
		}
		super.actualizar(entity);
	}

	@Override
	public void eliminar(Cliente entity) {
		Long registros = ((ClienteRepository) repository).clientesExistentesActualizar(entity.getId());

		if (registros < 1l) {
			ValidatorUtil.validateMessage("id", "id No Existe");
		}

		super.eliminar(entity);
	}

	@Override
	public List<Cliente> listarRechazarCarga() {
		return ((ClienteRepository) repository).listarRechazarCarga();
	}

	@Override
	@Transactional
	public String insertarClienteCarga(Cliente cliente) {
		return ((ClienteRepository) repository).insertarClienteCarga(cliente);
	}

	@Override
	@Transactional
	public void actualizarClientesCodigoCentralAltamira(CodigoStarAltamira entity) {
		((ClienteRepository) repository).actualizarClientesCodigoCentralAltamira(entity.getCodigo(), entity.getAltamira());
	}
	
	@Override
	@Transactional
	public void actualizarClienteHost(Cliente entity) {
		((ClienteRepository) repository).actualizarClienteHost(entity.getId(), entity.getNombrecorto(), entity.getTipocliente(), entity.getTipodocumento(),
				entity.getNumerodocumento(), entity.getSector());
	}

	@Override
	@Transactional
	public void procesarClientesInforeport() {
		List<ReporteUnoC2DTO> registrosuno = new ArrayList<>();
		List<ReporteSeisC2DTO> registrosseis = new ArrayList<>();
		List<ReporteSieteC2DTO> registrossiete = new ArrayList<>();
		List<String> clientesIdProceso = new ArrayList<>();
		
		FiltroReporte filtroReporte = new FiltroReporte();
		filtroReporte.setFecha(new Date());
		FiltroReporteResponse filtroReporteResponse = reportFilterService.getFilter(filtroReporte);
		ReporteSearch reporteSearch = new ReporteSearch(null, null, null);
		
		reporteSearch.setFecha(filtroReporteResponse.getFecha().getTime());
		reporteSearch.setTipoproceso(filtroReporteResponse.getTipoproceso());
		reporteSearch.setDivisa(filtroReporteResponse.getDivisa());
		reporteSearch.setProducto(filtroReporteResponse.getProducto());
		
		registrosuno = reporteUnoC2Service.listReportOneC2(reporteSearch);
		
		List<ValorParametro> listatenor = valorParametroService.obtenerCredenciales(credencialesinterfaz);
		String usuario = listatenor.get(0).getValor();
		String password = listatenor.get(1).getValor();
		String ip = "";
		
		try {
			ip = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e1) {
			log.error("failed!", e1);
			ip = "";
		}

		for (ReporteUnoC2DTO registrouno : registrosuno) {

			if (registrouno.getSectorcliente() == null || registrouno.getClientenombre() == null
					|| registrouno.getTipodocumento() == null || registrouno.getClientepaisresidencia() == null) {
				
				clientesIdProceso.add(registrouno.getIdCliente());
			}

		}
		
		registrosseis = reporteSeisC2Service.listReportSixC2(reporteSearch);
		
		for (ReporteSeisC2DTO registroseis : registrosseis) {

			if (registroseis.getSectorcliente() == null || registroseis.getClientenombre() == null
					|| registroseis.getTipodocumento() == null || registroseis.getClientepaisresidencia() == null) {
				
				clientesIdProceso.add(registroseis.getIdCliente());
			}

		}
		
		registrossiete = reporteSieteC2Service.listReportSevenC2(reporteSearch);
		
		for (ReporteSieteC2DTO registrosiete : registrossiete) {

			if (registrosiete.getSectorcliente() == null || registrosiete.getClientenombre() == null
					|| registrosiete.getTipodocumento() == null || registrosiete.getClientepaisresidencia() == null) {
				
				clientesIdProceso.add(registrosiete.getIdcliente());
			}

		}
		
		clientesIdProceso = clientesIdProceso.stream().distinct().collect(Collectors.toList());
		
		for (String clienteIdProceso : clientesIdProceso) {
			//Llamada al servicio HOST
			log.info("ID : {} ", clienteIdProceso);
			Cliente cliente = super.buscarId(clienteIdProceso);
			String resultado = "";
			int cont = 0;

			try {
				
				if (cliente.getAltamira() != null && !cliente.getAltamira().trim().equals("")) {
					log.info("ALTAMIRA : {} ", cliente.getAltamira());
									
					resultado = transaccionClient.enviaTramas(stridlogin, stridtrama, 
							strtramaentidad.concat("|")
										   .concat(strtramacodcliente).concat(cliente.getAltamira().trim().substring(cliente.getAltamira().trim().length() - 8, cliente.getAltamira().trim().length()))
							               .concat("|")
							               .concat(strtramaindcontinu)
							               .concat("|")
							               .concat(strtramanumctacliente)
							               .concat("|")
							               .concat(strtramanumtipmoneda)
							               .concat("|")
							               .concat(strtramacodusuario).concat(usuario), 
							strambientehost, 
							ip, 
							strsesion, 
							usuario, 
							password, 
							strcodsistema);
					
					log.info("Resultado Servicio : {} ", resultado);
					
					cont = resultado.split("\\[", 25).length;
					
					if (!resultado.equals("") && cont > 1) {
						cliente = establecerDatosCliente(resultado, cliente);
						actualizarClienteHost(cliente);
					}

				}
				
			} catch (Exception e) {
				log.error("failed!", e);
			}

		}

	}
	
	public Cliente establecerDatosCliente(String resultado, Cliente cliente) {
		
		String nombrecorto = "";
		ValorParametro paisobj;
		String [] valores = resultado.split("\\[", 25);
		
		log.info("Tamaño valores : {} ", valores.length);
		
		nombrecorto = valores[3].substring(6, valores[3].length());
		
		if (nombrecorto.length() > 20) {
			nombrecorto = nombrecorto.substring(0, 20);
		}
		
		cliente.setNombrecorto(nombrecorto);
		
		if (valores[9].substring(6, valores[9].length()).equals("M03") || valores[9].substring(6, valores[9].length()).equals("M04")) {
			cliente.setTipocliente(TipoCliente.F.toString());
		} else {
			cliente.setTipocliente(TipoCliente.P.toString());
		}
		
		switch (valores[19].substring(6, valores[19].length())) {
			case "L":
				cliente.setTipodocumento(1);
				break;
			case "R":
				cliente.setTipodocumento(2);
				break;
			case "E":
				cliente.setTipodocumento(3);
				break;
			case "P":
				cliente.setTipodocumento(4);
				break;
			default:
				break;
		}
			
		cliente.setNumerodocumento(valores[20].substring(6, valores[20].length()));
		cliente.setSector(valores[21].length() > 13 ? valores[21].substring(13, valores[21].length()) : "");
		
		paisobj = valorParametroService.obtenerParametroValorPais(codigopais, valores[23].substring(6, valores[23].length()));
		cliente.setPaisresidencia(paisobj != null ? paisobj.getValor() : "");
		
		return cliente;
	}
	
	@Override
	public List<Cliente> obtenerClientesSinAltamira() {
		return ((ClienteRepository) repository).obtenerClientesSinAltamira();
	}

}
