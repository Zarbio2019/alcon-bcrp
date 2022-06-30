package pe.grupobbva.alcon.mantenimiento.repository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.TipoCambio;
import pe.grupobbva.alcon.mantenimiento.repository.custom.TipoCambioCustomRepository;

public interface TipoCambioRepository extends AbstractRepository<TipoCambio>, TipoCambioCustomRepository {

	@Query(value="from TipoCambio TC where trunc(TC.fecha) = trunc(:fecha)")
	public List<TipoCambio> tipoCambioPorfecha(@Param("fecha") Calendar fecha);	
	
	@Query(value="from TipoCambio TC where trunc(TC.fecha) = (Select trunc(max(TC.fecha)) from TipoCambio TC)")
	public List<TipoCambio> ultimoTipoCambioPorfecha();	
	
	@Query(value = "from TipoCambio TC where trunc(TC.fecha) = (Select trunc(max(TC1.fecha)) from TipoCambio TC1 where trunc(TC1.fecha) < trunc(:fecha))")
	public List<TipoCambio> ultimoTipoCambioPorfecha(@Param("fecha") Calendar fecha);

	@Query(value="select coalesce(TC.importe, 0) from TipoCambio TC where TC.codigoestado = 1 and TC.divisa.codigo = :codigoDivisa and trunc(TC.fecha) = trunc(:fecha)")
	public BigDecimal listarFechaDivisa(@Param("fecha") Calendar fecha, @Param("codigoDivisa") String codigoDivisa);
	
	@Query(value="select TC from TipoCambio TC where TC.codigoestado = 1 and TC.divisa.id = :idDivisa and trunc(TC.fecha) = trunc(:fecha)")
	public TipoCambio tipocambioObtenerId(@Param("fecha") Calendar fecha, @Param("idDivisa") String idDivisa);
	
	@Query("select coalesce(count(TC), 0) from TipoCambio TC where TC.codigoestado = :codigoestado and TC.divisa.id = :idDivisa and trunc(TC.fecha) = trunc(:fecha)")
	public Long tipocambiosDuplicados(@Param("codigoestado") Integer codigoestado, @Param("idDivisa") String idDivisa, @Param("fecha") Calendar fecha);
	
	@Query("select coalesce(count(TC), 0) from TipoCambio TC where TC.codigoestado = :codigoestado and TC.divisa.id = :idDivisa and trunc(TC.fecha) = trunc(:fecha) and TC.id != :id")
	public Long tipocambiosDuplicadosActualizar(@Param("codigoestado") Integer codigoestado, @Param("idDivisa") String idDivisa, @Param("fecha") Calendar fecha, @Param("id") String id);
	
}
