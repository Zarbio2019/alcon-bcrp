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

import pe.grupobbva.alcon.mantenimiento.dto.process.CodigoStarAltamiraCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.FilaEstado;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;
import pe.grupobbva.alcon.mantenimiento.entity.CodigoStarAltamira;
import pe.grupobbva.alcon.mantenimiento.service.ClienteService;
import pe.grupobbva.alcon.mantenimiento.service.CodigoStarAltamiraService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaCodigoStarAltamiraService;
import pe.grupobbva.alcon.mantenimiento.service.process.util.BcrpReader;

@Service
public class CargaCodigoStarAltamiraServiceImpl implements CargaCodigoStarAltamiraService {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	private CodigoStarAltamiraService codigoStarAltamiraService;

	@Autowired
	private ClienteService clienteService;

	@Override
	public void procesarCarga(Carga carga, InputStream file, String filename, Integer opcionTipoCarga) {

		log.info("INICIO procesarCarga STAR - ALTAMIRA");

		List<CodigoStarAltamiraCargaType> registros = new ArrayList<>();
		List<CodigoStarAltamira> codigoscentralesaltamiras = new ArrayList<>();
		Map<String, FilaEstado> errores = new HashMap<>();

		List<Cliente> clientesSinAltamira = new ArrayList<>();
		CodigoStarAltamira codigoStarAltamira = new CodigoStarAltamira();

		BcrpReader.codigoCentralAltamiraCarga().read(carga, file, filename, registros, errores);

		registros.stream().forEach(registro -> {

			try {

				CodigoStarAltamira codigocentralaltamira = new CodigoStarAltamira(registro);
				codigoscentralesaltamiras.add(codigocentralaltamira);

			} catch (Exception e) {
				log.error("failed!", e);
			}

		});

		// Se elimina toda la data de la tabla
		codigoStarAltamiraService.eliminarCodigoStarAltamira();

		for (CodigoStarAltamira codigocentralaltamira : codigoscentralesaltamiras) {
			try {
				log.info("LLenado de tabla CODIGO STAR ALTAMIRA");
				codigoStarAltamiraService.guardar(codigocentralaltamira);

			} catch (Exception ex) {
				log.error("failed!", ex);
			}
		}

		// Se obtiene los clientes con campo altamira vacio
		clientesSinAltamira = clienteService.obtenerClientesSinAltamira();
		log.info("clientes Sin Altamira {}", clientesSinAltamira.size());

		for (Cliente clienteSinAltamira : clientesSinAltamira) {
			try {
				log.info("Actualizacion de codigo ALTAMIRA");

				codigoStarAltamira = codigoStarAltamiraService.obtenerCodigoAltamiraPorCliente(clienteSinAltamira.getCodigo(), clienteSinAltamira.getCodigoestado());

				if (codigoStarAltamira != null) {
					clienteService.actualizarClientesCodigoCentralAltamira(codigoStarAltamira);
				}
				

			} catch (Exception ex) {
				log.error("failed!", ex);
			}
		}

		log.info("FIN procesarCarga STAR - ALTAMIRA");

	}

}
