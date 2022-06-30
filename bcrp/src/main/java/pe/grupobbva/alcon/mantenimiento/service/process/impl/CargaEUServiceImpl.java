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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.dto.OficinaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.process.FilaEstado;
import pe.grupobbva.alcon.mantenimiento.dto.process.SaldoCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.table.SaldoTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleParametro;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.entity.Oficina;
import pe.grupobbva.alcon.mantenimiento.entity.Saldo;
import pe.grupobbva.alcon.mantenimiento.service.DetalleParametroService;
import pe.grupobbva.alcon.mantenimiento.service.DivisaService;
import pe.grupobbva.alcon.mantenimiento.service.OficinaService;
import pe.grupobbva.alcon.mantenimiento.service.SaldoService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaEUService;
import pe.grupobbva.alcon.mantenimiento.service.process.util.BcrpReader;

@Service
public class CargaEUServiceImpl implements CargaEUService {

	private static final Logger log = LogManager.getLogger();

	@Value("${app.valoresparametro.codigo_cuentas}")
	private String codigocuentas;

	@Autowired
	private DivisaService divisaService;

	@Autowired
	private OficinaService oficinaService;

	@Autowired
	private SaldoService saldoService;

	@Autowired
	private DetalleParametroService detalleParametroService;

	@Override
	public void procesarCarga(Carga carga, InputStream file, String filename, Integer tipoCarga) {

		List<SaldoCargaType> registros = new ArrayList<>();
		List<SaldoTableDTO> saldosdto = new ArrayList<>();
		List<Saldo> saldos;
		Map<String, FilaEstado> errores = new HashMap<>();
		Map<String, Oficina> mapOficinas = new HashMap<>();
		Map<String, Divisa> mapDivisas = new HashMap<>();

		BcrpReader.saldoCarga().read(carga, file, filename, registros, errores);

		carga.setTotalreg(registros.size());

		registros.stream().forEach(registro -> {

			try {

				SaldoTableDTO saldodto = new SaldoTableDTO(registro);
				saldodto.setOficinacodigo(registro.getCodigoOficina());
				saldodto.setDivisacodigo(registro.getCodigoDivisa());

				Oficina oficina = null;

				if (mapOficinas.containsKey(registro.getCodigoOficina())) {
					oficina = mapOficinas.get(registro.getCodigoOficina());
				} else {
					oficina = oficinaService.obtenerOficinaPorCodigo(registro.getCodigoOficina());
					mapOficinas.put(registro.getCodigoOficina(), oficina);
				}

				if (oficina != null) {
					saldodto.setIdoficina(oficina.getId());
				}

				Divisa divisa = null;

				if (mapDivisas.containsKey(registro.getCodigoDivisa())) {
					divisa = mapDivisas.get(registro.getCodigoDivisa());
				} else {
					divisa = divisaService.obtenerDivisaPorCodigo(registro.getCodigoDivisa());
					mapDivisas.put(registro.getCodigoDivisa(), divisa);
				}

				if (divisa != null) {
					saldodto.setIddivisa(divisa.getId());
				}

				saldosdto.add(saldodto);
			} catch (ParseException e) {
				log.error("failed!", e);
			}

		});

		saldos = obtenerDatosDescargadosSA(saldosdto);

		for (Saldo saldo : saldos) {
			Long cantidad = saldoService.saldosDuplicados(saldo.getIdoficina(), saldo.getNumerocuenta(),
					saldo.getIddivisa(), saldo.getSaldo(), saldo.getSignosaldo(), saldo.getSaldomedio(),
					saldo.getSignosaldomedio(), saldo.getFechaproceso());

			if (cantidad < 1L) {
				saldoService.guardar(saldo);
			} else {
				String idsaldo = saldoService.obtenerSaldoId(saldo.getIdoficina(), saldo.getNumerocuenta(),
						saldo.getIddivisa(), saldo.getSaldo(), saldo.getSignosaldo(), saldo.getSaldomedio(),
						saldo.getSignosaldomedio(), saldo.getFechaproceso());

				Saldo saldoactualizar = saldoService.buscarId(idsaldo);

				saldoactualizar.setIdoficina(saldo.getIdoficina());
				saldoactualizar.setNumerocuenta(saldo.getNumerocuenta());
				saldoactualizar.setIddivisa(saldo.getIddivisa());
				saldoactualizar.setSaldo(saldo.getSaldo());
				saldoactualizar.setSignosaldo(saldo.getSignosaldo());
				saldoactualizar.setSaldomedio(saldo.getSaldomedio());
				saldoactualizar.setSignosaldomedio(saldo.getSignosaldomedio());
				saldoactualizar.setFechaproceso(saldo.getFechaproceso());

				saldoService.actualizar(saldoactualizar);
			}
			carga.setTotalcargado(carga.getTotalcargado() + 1);

		}
	}

	List<Saldo> obtenerDatosDescargadosSA(List<SaldoTableDTO> saldosdto) {

		List<Saldo> saldos = new ArrayList<>();
		List<DetalleParametro> cuentas = detalleParametroService.listarCuentas(codigocuentas);
		List<OficinaDTO> oficinas = oficinaService.listarOficinas();
		boolean existingAccount = false;

		try {

			for (SaldoTableDTO saldodto : saldosdto) {
				for (DetalleParametro cuenta : cuentas) {

					if (cuenta.getDescripcion().equals(saldodto.getNumerocuenta())) {

						for (OficinaDTO oficina : oficinas) {
							if (oficina.getCodigo().equals(saldodto.getOficinacodigo())) {
								existingAccount = true;
								break;
							}
						}

						break;
					}
				}

				if (existingAccount) {
					Saldo saldo = new Saldo();
					saldodto.fromDTO(saldo);
					saldos.add(saldo);
					existingAccount = false;
				}

			}
		} catch (Exception e) {
			log.error("failed!", e);
		}

		return saldos;

	}

}
