package pe.grupobbva.alcon.mantenimiento.service.process.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.dto.process.DeltaCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.FilaEstado;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Delta;
import pe.grupobbva.alcon.mantenimiento.service.DeltaService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaDeltaService;
import pe.grupobbva.alcon.mantenimiento.service.process.util.BcrpReader;

@Service
public class CargaDeltaServiceImpl implements CargaDeltaService {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	private DeltaService deltaService;

	@Override
	public void procesarCarga(Carga carga, InputStream file, String filename, Integer tipoCarga) {
		deltaService.eliminarCarga(carga.getFecha());

		List<DeltaCargaType> registros = new ArrayList<>();
		Map<String, FilaEstado> errores = new HashMap<>();

		BcrpReader.deltaCarga().read(carga, file, filename, registros, errores);

		carga.setTotalreg(registros.size());

		registros.stream().forEach(registro -> {

			try {
				Delta delta = new Delta(registro);
				delta.setFechaproceso(carga.getFecha());
				deltaService.guardar(delta);
				carga.setTotalcargado(carga.getTotalcargado() + 1);
			} catch (Exception e) {
				log.error("failed!", e);
			}

		});

	}

}
