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
import pe.grupobbva.alcon.mantenimiento.dto.process.SaldoContableCargaType;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.SaldoContable;
import pe.grupobbva.alcon.mantenimiento.service.SaldoContableService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaSaldoContableService;
import pe.grupobbva.alcon.mantenimiento.service.process.util.BcrpReader;

@Service
public class CargaSaldoContableServiceImpl implements CargaSaldoContableService {
	
	private static final Logger log = LogManager.getLogger();
	
	@Autowired
	private SaldoContableService saldoContableService;
	
	@Override
	public void procesarCarga(Carga carga, InputStream file,String filename, Integer opcionTipoCarga) {
		
		List<SaldoContableCargaType> registros = new ArrayList<>();
		List<SaldoContable> saldoscontables = new ArrayList<>();
		Map<String, FilaEstado> errores = new HashMap<>();
		
		StringBuilder notaerror = new StringBuilder();
 
		BcrpReader.saldoContableCarga().read(carga, file,filename, registros, errores);
		
		carga.setTotalreg(registros.size()+carga.getTotalreg());
		
		registros.stream().forEach(registro -> {

			try {
				SaldoContable saldocontable = new SaldoContable(registro);
				saldoscontables.add(saldocontable);
				
			} catch (ParseException e) {
				log.error("failed!",e);
			}

		});
		
		saldoContableService.saldoContableActualizarEstadoGrupo(carga, 2);
		
		for (SaldoContable saldocontable : saldoscontables) {		
			try {
				saldoContableService.guardar(saldocontable);
				carga.setTotalcargado(carga.getTotalcargado()+1);
			} catch (Exception ex) {
				notaerror.append("Fila : " + saldocontable.getDivisa().getCodigo() + " : " + ex.getMessage() + ". ");
			}	
		}
		
		carga.setNotaerror(notaerror.toString());
		
	}

}
