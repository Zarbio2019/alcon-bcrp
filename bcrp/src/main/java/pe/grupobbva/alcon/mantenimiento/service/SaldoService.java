package pe.grupobbva.alcon.mantenimiento.service;

import java.math.BigDecimal;
import java.util.Calendar;

import pe.grupobbva.alcon.mantenimiento.entity.Saldo;
import pe.grupobbva.alcon.mantenimiento.entity.Signo;


public interface SaldoService extends AbstractService<Saldo> {
	
	public Long saldosDuplicados(String idoficina, String numerocuenta, String iddivisa, BigDecimal saldo,
			Signo signosaldo, BigDecimal saldomedio, Signo signosaldomedio, Calendar fecha);
	
	public String obtenerSaldoId(String idoficina, String numerocuenta, String iddivisa, BigDecimal saldo,
			Signo signosaldo, BigDecimal saldomedio, Signo signosaldomedio, Calendar fecha);

}
