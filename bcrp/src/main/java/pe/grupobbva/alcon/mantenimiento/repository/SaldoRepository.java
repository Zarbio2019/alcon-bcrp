package pe.grupobbva.alcon.mantenimiento.repository;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.Saldo;
import pe.grupobbva.alcon.mantenimiento.entity.Signo;

public interface SaldoRepository extends AbstractRepository<Saldo> {

	@Query(value = "select coalesce(count(S), 0) from Saldo S where S.idoficina = :idoficina"
			+ " and S.numerocuenta = :numerocuenta and S.iddivisa = :iddivisa and S.saldo = :saldo"
			+ " and S.signosaldo = :signosaldo and S.saldomedio = :saldomedio and S.signosaldomedio = :signosaldomedio" 
			+ " and  trunc(S.fechaproceso) =  trunc(:fecha)")
	public Long saldosDuplicados(@Param("idoficina") String idoficina, @Param("numerocuenta") String numerocuenta,
			@Param("iddivisa") String iddivisa, @Param("saldo") BigDecimal saldo, @Param("signosaldo") Signo signosaldo,
			@Param("saldomedio") BigDecimal saldomedio, @Param("signosaldomedio") Signo signosaldomedio,
			@Param("fecha") Calendar fecha);
	
	@Query(value = "select coalesce(S.id, 0) from Saldo S where S.idoficina = :idoficina"
			+ " and S.numerocuenta = :numerocuenta and S.iddivisa = :iddivisa and S.saldo = :saldo"
			+ " and S.signosaldo = :signosaldo and S.saldomedio = :saldomedio and S.signosaldomedio = :signosaldomedio" 
			+ " and  trunc(S.fechaproceso) =  trunc(:fecha)")
	public String obtenerSaldoId(@Param("idoficina") String idoficina, @Param("numerocuenta") String numerocuenta,
			@Param("iddivisa") String iddivisa, @Param("saldo") BigDecimal saldo, @Param("signosaldo") Signo signosaldo,
			@Param("saldomedio") BigDecimal saldomedio, @Param("signosaldomedio") Signo signosaldomedio,
			@Param("fecha") Calendar fecha);

}
