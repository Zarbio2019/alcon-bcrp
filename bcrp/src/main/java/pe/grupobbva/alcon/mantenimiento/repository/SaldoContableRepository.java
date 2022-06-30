package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.SaldoContable;
import pe.grupobbva.alcon.mantenimiento.repository.custom.SaldoContableCustomRepository;

public interface SaldoContableRepository extends AbstractRepository<SaldoContable>, SaldoContableCustomRepository {

	@Query(value = "select coalesce(count(SC), 0) from SaldoContable SC where SC.codigoestado = :codigoestado and SC.divisa.id = :iddivisa and SC.oficina.id = :idoficina and trunc(SC.fecha) = trunc(:fecha)")
	public Long saldoscontablesDuplicados(@Param("codigoestado") Integer codigoestado,
			@Param("iddivisa") String iddivisa, @Param("idoficina") String idoficina, @Param("fecha") Calendar fecha);

	@Query(value = "SELECT COALESCE(COUNT(sc.ID),0) FROM PCBCRP.SALDO_CONTABLE sc WHERE sc.CODIGOESTADO=:codigoestado AND sc.ID_DIVISA= :id_divisa"
			+ " AND sc.ID_OFICINA= :id_oficina AND EXTRACT(DAY FROM sc.fecha)=:dia "
			+ " AND EXTRACT(MONTH FROM sc.fecha)=:mes AND EXTRACT(YEAR FROM sc.fecha)=:anio "
			+ " AND sc.ID!=:id", nativeQuery = true)
	public Long saldoscontablesDuplicadosActualizar(@Param("codigoestado") Integer codigoestado,
			@Param("id_divisa") String iddivisa, @Param("id_oficina") String idoficina, @Param("dia") Integer dia,
			@Param("mes") Integer mes, @Param("anio") Integer anio, @Param("id") String id);

	@Query("select coalesce(count(SC),0) from SaldoContable SC where SC.id = :id")
	public Long saldoscontablesExistentesActualizar(@Param("id") String id);

	@Query(value = "from SaldoContable SC where trunc(SC.fecha) = trunc(:fecha)")
	public List<SaldoContable> tipoCambioPorfecha(@Param("fecha") Calendar fecha);

	@Query(value = "from SaldoContable SC where trunc(SC.fecha) = (Select trunc(max(SC1.fecha)) from SaldoContable SC1 where trunc(SC1.fecha) < trunc(:fecha))")
	public List<SaldoContable> ultimoTipoCambioPorfecha(@Param("fecha") Calendar fecha);

}
