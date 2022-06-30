package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.entity.Saldo;
import pe.grupobbva.alcon.mantenimiento.entity.Signo;
import pe.grupobbva.alcon.mantenimiento.repository.SaldoRepository;
import pe.grupobbva.alcon.mantenimiento.service.SaldoService;

@Service
public class SaldoServiceImpl extends AbstractServiceImpl<Saldo> implements SaldoService {

	public Long saldosDuplicados(String idoficina, String numerocuenta, String iddivisa, BigDecimal saldo,
			Signo signosaldo, BigDecimal saldomedio, Signo signosaldomedio, Calendar fecha) {
		return ((SaldoRepository) repository).saldosDuplicados(idoficina, numerocuenta, iddivisa, saldo,
				signosaldo, saldomedio, signosaldomedio, fecha);
	}
	
	public String obtenerSaldoId(String idoficina, String numerocuenta, String iddivisa, BigDecimal saldo,
			Signo signosaldo, BigDecimal saldomedio, Signo signosaldomedio, Calendar fecha) {
		return ((SaldoRepository) repository).obtenerSaldoId(idoficina, numerocuenta, iddivisa, saldo,
				signosaldo, saldomedio, signosaldomedio, fecha);
	}

}
