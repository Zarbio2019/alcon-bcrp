package pe.grupobbva.alcon.mantenimiento.service.process.impl;

import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.dto.process.FilaEstado;
import pe.grupobbva.alcon.mantenimiento.dto.process.TasaCurvaCargaType;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleParametro;
import pe.grupobbva.alcon.mantenimiento.entity.Operacion;
import pe.grupobbva.alcon.mantenimiento.entity.TasaCurva;
import pe.grupobbva.alcon.mantenimiento.entity.ValorParametro;
import pe.grupobbva.alcon.mantenimiento.service.CargaService;
import pe.grupobbva.alcon.mantenimiento.service.DetalleParametroService;
import pe.grupobbva.alcon.mantenimiento.service.DivisaService;
import pe.grupobbva.alcon.mantenimiento.service.OperacionService;
import pe.grupobbva.alcon.mantenimiento.service.TasaCurvaService;
import pe.grupobbva.alcon.mantenimiento.service.ValorParametroService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaTasaCurvaService;
import pe.grupobbva.alcon.mantenimiento.service.process.util.BcrpReader;

@Service
public class CargaTasaCurvaServiceImpl implements CargaTasaCurvaService {
	private static final Logger log = LogManager.getLogger();
	
	@Value("${app.valoresparametro.codigo_curvas}")
	private String codigocurvas;
	
	@Value("${app.valoresparametro.codigo_curva_producto}")
	private String codigocurvaproducto;
	
	@Value("${app.valoresparametro.codigo_tenor}")
	private String codigotenor;

	@Autowired
	private OperacionService operacionService;

	@Autowired
	private TasaCurvaService tasaCurvaService;

	@Autowired
	private DivisaService divisaService;

	@Autowired
	private CargaService cargaService;
	
	@Autowired
	private ValorParametroService valorParametroService;
	
	@Autowired
	private DetalleParametroService detalleParametroService;

	@Override
	public List<Carga> calcularTasasCurvas(Carga carga, List<TasaCurva> tasas) {

		Carga cargaFin = new Carga();
		List<Carga> cargas = new ArrayList<>();
		List<Operacion> cargasoperaciones = operacionService.tasaCurvaDevolverOperaciones(carga.getFecha(), carga.getTipoproceso(), codigocurvaproducto);
		String curvadivisaentrada = "";
		ValorParametro objcurvadivisaentrada;
		String codigodivisaentrada = "";
		String curvadivisasalida = "";
		ValorParametro objcurvadivisasalida;
		String codigodivisasalida = "";

		double plazoOperacion = 0;

		try {

			for (Operacion operacioncarga : cargasoperaciones) {

				plazoOperacion = Utils.obtenerPlazo(operacioncarga.getFechacontratacion(), operacioncarga.getFechavencimiento());

				Operacion operacion = buscarOperacion(operacioncarga.getId());
				
				
				codigodivisaentrada = divisaService.obtenerDivisaPorId(operacioncarga.getIddivisaentrada()).getCodigo();
				objcurvadivisaentrada = valorParametroService.obtenerParametroDivisaCodigo("SW", codigodivisaentrada);
				
				if (objcurvadivisaentrada != null) {
					curvadivisaentrada = objcurvadivisaentrada.getValor();
					operacion.setRecibetasafijaspread(tasaCurvaService.obtenerTasaOperacionInterpolada(BigDecimal.valueOf(plazoOperacion), curvadivisaentrada, tasas));
					operacion.setRecibetfija("TFIJA");
					operacion.setRecibeidentificadorfrecuencia("01T");
				}
				
				codigodivisasalida = divisaService.obtenerDivisaPorId(operacioncarga.getIddivisasalida()).getCodigo();
				objcurvadivisasalida = valorParametroService.obtenerParametroDivisaCodigo("SW", codigodivisasalida);
				
				if (objcurvadivisasalida != null) {
					curvadivisasalida = objcurvadivisasalida.getValor();
					operacion.setPagatasafijaspread(tasaCurvaService.obtenerTasaOperacionInterpolada(BigDecimal.valueOf(plazoOperacion), curvadivisasalida, tasas));
					operacion.setPagatfija("TFIJA");
					operacion.setPagaidentificadorfrecuencia("01T");
				}
				
				operacionService.actualizarTasasCurvas(operacion);
			}

		} catch (Exception ex) {
			cargaFin.setNotaerror("Calcular Tasas: " + ex.getMessage());
			cargas.add(cargaFin);
		}

		return cargas;
	}

	@Override
	public void procesarCarga(Carga carga, InputStream file, String filename, Integer opcionTipoCarga) {

		List<TasaCurvaCargaType> registros = new ArrayList<>();
		List<TasaCurva> tasas = new ArrayList<>();
		List<TasaCurva> tasasconfig;

		Map<String, FilaEstado> errores = new HashMap<>();

		StringBuilder notaerror = new StringBuilder();
		List<Carga> cargas;

		cargas = cargaService.listarCargaPorFechaProceso(carga.getTipocarga(), carga.getFecha());

		if (!cargas.isEmpty()) {
			TasaCurva tasa = new TasaCurva();
			tasa.setFechaproceso(carga.getFecha());
			tasa.setActualizadoPor(carga.getCreadoPor());

			tasaCurvaService.eliminarPorFechaProceso(tasa);
		}

		BcrpReader.tasaCurvaCarga().read(carga, file, filename, registros, errores);

		carga.setTotalreg(registros.size());

		registros.stream().forEach(registro -> {

			try {
				TasaCurva tasa = new TasaCurva(registro);
				tasas.add(tasa);

			} catch (ParseException e) {
				log.error("failed!", e);
			}

		});
		
		List<TasaCurva> tasasfechaproceso = tasaCurvaService.listarTasaCurvaFechaProceso(carga.getFecha());
		
		if (!tasasfechaproceso.isEmpty()) {
			TasaCurva tasa = new TasaCurva();
			tasa.setFechaproceso(carga.getFecha());
			tasa.setActualizadoPor(carga.getCreadoPor());

			tasaCurvaService.eliminarPorFechaProceso(tasa);
		}
		
		tasasconfig = obtenerTasasConfiguracion(tasas);

		for (TasaCurva tasa : tasasconfig) {
			try {
				tasaCurvaService.guardar(tasa);
				carga.setTotalcargado(carga.getTotalcargado() + 1);
			} catch (Exception ex) {
				notaerror.append("Fila :  Divisa > " + tasa.getDivisacurva() + " : " + ex.getMessage() + ". ");
			}
		}

		reprocesar(carga, notaerror);

	}
	
	List<TasaCurva> obtenerTasasConfiguracion(List<TasaCurva> tasas) {
		
		List<TasaCurva> tasascurvas = new ArrayList<>();
		List<String> curvas = detalleParametroService.listarCurvas(codigocurvas);
		List<ValorParametro> divisascurvas = valorParametroService.listarDivisasCurvas(codigocurvas);
		List<DetalleParametro> listatenor = detalleParametroService.listarTenor(codigotenor);
		boolean existeCurvaDivisa = false;
		String divisacodigo = "";
		
		try {
			for (TasaCurva tasa : tasas) {
				for (String curva : curvas) {
					if (curva.equals(tasa.getCurva())) {
						for (ValorParametro divisacurva : divisascurvas) {
							if (divisacurva.getValor().equals(tasa.getDivisacurva())) {
								divisacodigo = valorParametroService.obtenerParametroCurvaDivisaCodigo(tasa.getCurva(), tasa.getDivisacurva()).getValor();
								tasa.setIddivisa(divisaService.obtenerDivisaPorCodigo(divisacodigo).getId());
								tasa.setPlazo(obtenerPlazoTenor(tasa, listatenor, codigotenor));
								existeCurvaDivisa = true;
								break;
							}
						}
						break;
					}
				}

				if (existeCurvaDivisa) {
					tasascurvas.add(tasa);
					existeCurvaDivisa = false;
				}

			}
		} catch (Exception e) {
			log.error("failed!", e);
		}
		
		return tasascurvas;
		
	}
	
	public BigDecimal obtenerPlazoTenor(TasaCurva tasa, List<DetalleParametro> listatenor, String codigotenor) {
		BigDecimal plazo = BigDecimal.ZERO;
		String tenorplazo = "";

		for (DetalleParametro tenor : listatenor) {
			
			if (tenor.getDescripcion().equals(tasa.getTenor())) {
				tenorplazo = valorParametroService.obtenerDescripcionTenor(tenor.getDescripcion(), codigotenor).getValor();
				plazo = new BigDecimal(tenorplazo);
				break;
			}
		}

		return plazo;
	}

	public void reprocesar(Carga carga, StringBuilder notaerror) {
		List<TasaCurva> calcularTasas = tasaCurvaService.listarTasaCurvaFechaProceso(carga.getFecha());

		if (!calcularTasas.isEmpty()) {
			calcularTasasCurvas(carga, calcularTasas);
		}

		carga.setNotaerror(notaerror.toString());

		cargaService.guardar(carga);
	}

	private Operacion buscarOperacion(String idOperacion) {
		return operacionService.buscarId(idOperacion);
	}
}
