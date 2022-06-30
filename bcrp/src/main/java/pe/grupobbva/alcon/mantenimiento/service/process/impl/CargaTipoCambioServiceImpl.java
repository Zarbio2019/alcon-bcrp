package pe.grupobbva.alcon.mantenimiento.service.process.impl;

import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.dto.process.FilaEstado;
import pe.grupobbva.alcon.mantenimiento.dto.process.TipocambioCargaType;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCambio;
import pe.grupobbva.alcon.mantenimiento.service.DivisaService;
import pe.grupobbva.alcon.mantenimiento.service.TipoCambioService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaTipoCambioService;
import pe.grupobbva.alcon.mantenimiento.service.process.util.BcrpReader;

@Service
public class CargaTipoCambioServiceImpl implements CargaTipoCambioService {
	
	private static final Logger log = LogManager.getLogger();

	
	@Autowired
	private TipoCambioService tipoCambioService;
	
	@Autowired
	private DivisaService divisaService;
	
	@Override
	public void procesarCarga(Carga carga, InputStream file,String filename, Integer opcionTipoCarga) {
		
		List<TipocambioCargaType> registros = new ArrayList<>();
		List<TipoCambio> tiposcambios = new ArrayList<>();
		Map<String, FilaEstado> errores = new HashMap<>();
		
		StringBuilder notaerror = new StringBuilder();

		BcrpReader.tipoCambioCarga().read(carga, file,filename, registros, errores);
		
		carga.setTotalreg(registros.size()+carga.getTotalreg());
		
		registros.stream().forEach(registro -> {

			try {
				
				Divisa divisa = divisaService.obtenerDivisaPorCodigo(registro.getCodigoDivisa());
				if(divisa==null) {
					divisa = new Divisa();
					divisa.setCodigo(registro.getCodigoDivisa());
					divisa.setDescripcion(registro.getCodigoDivisa());
					divisa.setCodigoestado(1);
					divisaService.guardar(divisa);
				}
				
				TipoCambio tipocambio = new TipoCambio(registro);
				
				tipocambio.setDivisa(divisa);
				
				tiposcambios.add(tipocambio);
				
			} catch (ParseException e) {
				log.error("failed!",e);
			}

			
			
		});
		
		for (TipoCambio tipocambio : tiposcambios) {
			try {
				tipoCambioService.actualizarInsertar(tipocambio);
				carga.setTotalcargado(carga.getTotalcargado()+1);
			} catch (Exception ex) {
				notaerror.append("Fila : Divisa : " + tipocambio.getDivisa().getCodigo() + " : " + ex.getMessage() + ". ");
			}	
		}
		
	}

}
