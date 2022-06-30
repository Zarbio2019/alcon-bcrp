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
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.dto.process.FilaEstado;
import pe.grupobbva.alcon.mantenimiento.dto.process.TasaCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.table.TasaTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.entity.Operacion;
import pe.grupobbva.alcon.mantenimiento.entity.Tasa;
import pe.grupobbva.alcon.mantenimiento.service.CargaService;
import pe.grupobbva.alcon.mantenimiento.service.DivisaService;
import pe.grupobbva.alcon.mantenimiento.service.OperacionService;
import pe.grupobbva.alcon.mantenimiento.service.TasaService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaCalculoTasasService;
import pe.grupobbva.alcon.mantenimiento.service.process.util.BcrpReader;

@Service
public class CargaCalculoTasasServiceImpl implements CargaCalculoTasasService{

	private static final Logger log = LogManager.getLogger();
	
	@Autowired
	private OperacionService operacionService;

	@Autowired
	private TasaService tasaService;
	
	@Autowired
	private DivisaService divisaService;
	
	@Autowired
	private CargaService cargaService;

	@Override
	public List<Carga> calcularTasas(Carga carga, List<Tasa> tasas) {

		Carga cargaFin = new Carga();
		List<Carga> cargas = new ArrayList<>();
		List<Operacion> cargasoperaciones = operacionService.tasaDevolverOperaciones(carga.getFecha(),	carga.getTipoproceso());

		double plazoOperacion = 0;

		try {

			for (Operacion operacioncarga : cargasoperaciones) {

				plazoOperacion = Utils.obtenerPlazo(operacioncarga.getFechacontratacion(), operacioncarga.getFechavencimiento());

				Operacion operacion = buscarOperacion(operacioncarga.getId());
				operacion.setTasamonedanacional(tasaService.obtenerTasaOperacionInterpolada(BigDecimal.valueOf(plazoOperacion), tasas));
				operacion.setTasamonedaextranjera(tasaService.obtenerTasaMonedaExtranjera(operacion, BigDecimal.valueOf(plazoOperacion)));
				operacion.setTasadiferencial(tasaService.obtenerTasaDiferencial(operacion));

				operacionService.actualizarTasas(operacion);
			}

		} catch (Exception ex) {
			cargaFin.setNotaerror("Calcular Tasas: " + ex.getMessage());
			cargas.add(cargaFin);
		}

		return cargas;
	}
	
	@Override
	public void calcularTasasPredatadas(Carga carga) {
		
		Carga cargaFin = new Carga();
		List<Carga> cargas = new ArrayList<>();
		List<Tasa> tasas = new ArrayList<>();
		List<Operacion> cargasoperaciones = operacionService.tasaDevolverOperacionesPredatadas(carga.getFecha(), carga.getTipoproceso());

		double plazoOperacion = 0;

		try {

			for (Operacion operacioncarga : cargasoperaciones) {

				plazoOperacion = Utils.obtenerPlazo(operacioncarga.getFechacontratacion(), operacioncarga.getFechavencimiento());

				Operacion operacion = buscarOperacion(operacioncarga.getId());
				
				tasas = tasaService.listarTasaFechaContratacion(operacioncarga.getFechacontratacion());
				
				operacion.setTasamonedanacional(tasaService.obtenerTasaOperacionInterpolada(BigDecimal.valueOf(plazoOperacion), tasas));
				operacion.setTasamonedaextranjera(tasaService.obtenerTasaMonedaExtranjera(operacion, BigDecimal.valueOf(plazoOperacion)));
				operacion.setTasadiferencial(tasaService.obtenerTasaDiferencial(operacion));

				operacionService.actualizarTasas(operacion);
			}

		} catch (Exception ex) {
			cargaFin.setNotaerror("Calcular Tasas Predatadas: " + ex.getMessage());
			cargas.add(cargaFin);
		}

	}
	
	@Override
	public void procesarCarga(Carga carga, InputStream file,String filename, Integer opcionTipoCarga) {
		
		List<TasaCargaType> registros = new ArrayList<>();
		List<TasaTableDTO> tasas = new ArrayList<>();
		
		Map<String, FilaEstado> errores = new HashMap<>();
		
		StringBuilder notaerror = new StringBuilder();
		List<Carga> cargas;
		
		cargas = cargaService.listarCargaPorFechaProceso(carga.getTipocarga(), carga.getFecha());
		
		if (!cargas.isEmpty()) {
			Tasa tasa = new Tasa();
			tasa.setFechaproceso(carga.getFecha());
			tasa.setActualizadoPor(carga.getCreadoPor());
			
			tasaService.eliminarPorFechaProceso(tasa);	
		}		
 
		BcrpReader.tasaCarga().read(carga, file,filename, registros, errores);
		
		carga.setTotalreg(registros.size());
		
		registros.stream().forEach(registro -> {

			try {
				TasaTableDTO tasa = new TasaTableDTO(registro);
				tasa.setIddivisa(divisaService.obtenerDivisaPorCodigo(registro.getCodigoDivisa()).getId());
				tasa.setDivisacodigo(registro.getCodigoDivisa());
				tasas.add(tasa);
				
			} catch (ParseException e) {
				log.error("failed!",e);
			}

		});
		
		for (TasaTableDTO tasa : tasas) {		
			try {
				
				if (tasa.getIddivisa() == null) {
					Divisa divisa = new Divisa();
					divisa.setCodigo(tasa.getDivisacodigo());
					divisa.setDescripcion(tasa.getDivisacodigo());
					divisaService.guardar(divisa);
				}
				
				Tasa entity = new Tasa();
				
				tasa.fromDTO(entity);
				tasaService.guardar(entity);
				carga.setTotalcargado(carga.getTotalcargado()+1);
			} catch (Exception ex) {
				notaerror.append("Fila :  Divisa > " + tasa.getDivisacodigo() + " : " + ex.getMessage() + ". ");
			}	
		}
		
		reprocesar(carga, notaerror);
		
		
	}
	
	public void reprocesar(Carga carga,StringBuilder notaerror) {
		List<Tasa> calcularTasas = tasaService.listarTasaFechaProceso(carga.getFecha());
		
		if (!calcularTasas.isEmpty()) {
			calcularTasas(carga, calcularTasas);
			calcularTasasPredatadas(carga);
		}
		
		
		carga.setNotaerror(notaerror.toString());
		
		cargaService.guardar(carga);
	}

	private Operacion buscarOperacion(String idOperacion) {
		return operacionService.buscarId(idOperacion);
	}

}
