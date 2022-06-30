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

import pe.grupobbva.alcon.mantenimiento.dto.process.CampanaDepositoCargaType;
import pe.grupobbva.alcon.mantenimiento.dto.process.FilaEstado;
import pe.grupobbva.alcon.mantenimiento.entity.CampanaDeposito;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.repository.ClienteRepository;
import pe.grupobbva.alcon.mantenimiento.repository.DivisaRepository;
import pe.grupobbva.alcon.mantenimiento.service.CampanaDepositoService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaCampanaDepositoService;
import pe.grupobbva.alcon.mantenimiento.service.process.util.BcrpReader;

@Service
public class CargaCampanaDepositoServiceImpl implements CargaCampanaDepositoService  {
	
	private static final Logger log = LogManager.getLogger();
	
	@Autowired
	private CampanaDepositoService campanaDepositoService;
	
	@Autowired
	DivisaRepository divisaRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Override
	public void procesarCarga(Carga carga, InputStream file,String filename, Integer opcionTipoCarga) {
		
		List<CampanaDepositoCargaType> registros = new ArrayList<>();
		List<CampanaDeposito> campanasdepositos = new ArrayList<>();
		Map<String, FilaEstado> errores = new HashMap<>();
		
		
		Map<String, Divisa> mapDivisas = new HashMap<>();
		Map<String, Cliente> mapClientes = new HashMap<>();
		Long cont = 0L;
		
		StringBuilder notaerror = new StringBuilder();
 
		BcrpReader.campanaDepositoCarga().read(carga, file, filename, registros, errores);
		
		carga.setTotalreg(registros.size() + carga.getTotalreg());
		
		registros.stream().forEach(registro -> {

			try {
				CampanaDeposito campanadeposito = new CampanaDeposito(registro);
				campanasdepositos.add(campanadeposito);
				
			} catch (ParseException e) {
				log.error("failed!",e);
			}

		});
		
		for (CampanaDeposito campanadeposito : campanasdepositos) {		
			try {
				
				Divisa divisa = null;

				if (mapDivisas.containsKey(campanadeposito.getDivisa().getCodigo())) {
					divisa = mapDivisas.get(campanadeposito.getDivisa().getCodigo());
				} else {
					divisa = divisaRepository.obtenerDivisaPorCodigo(campanadeposito.getDivisa().getCodigo());
					mapDivisas.put(campanadeposito.getDivisa().getCodigo(), divisa);
				}
				
				if (divisa != null) {
					campanadeposito.setDivisa(divisa);
				}
				
				Cliente cliente = null;
				
				if (mapClientes.containsKey(campanadeposito.getCliente().getAltamira())) {
					cliente = mapClientes.get(campanadeposito.getCliente().getAltamira());
				} else {
					cont = clienteRepository.clienteAltamira(campanadeposito.getCliente().getAltamira().trim());
					
					if (cont > 0l) {
						cliente = clienteRepository.obtenerClientePorCodigoAltamira(campanadeposito.getCliente().getAltamira());
						mapClientes.put(campanadeposito.getCliente().getAltamira(), cliente);
					} else {
						campanadeposito.getCliente().setCodigo(campanadeposito.getCliente().getAltamira());
						campanadeposito.getCliente().setEntidad("BBVA");
						campanadeposito.getCliente().setRechazarcarga("N");
						campanadeposito.getCliente().setTipocliente("P");
						campanadeposito.getCliente().setCodigoestado(1);
						clienteRepository.save(campanadeposito.getCliente());

					}
				}
				
				if (cliente != null) {
					campanadeposito.setCliente(cliente);
				}
				
				campanaDepositoService.guardar(campanadeposito);
				carga.setTotalcargado(carga.getTotalcargado() + 1);
			} catch (Exception e) {
				log.error("failed!", e);
			}	
		}
		
		carga.setNotaerror(notaerror.toString());
		
	}
}
