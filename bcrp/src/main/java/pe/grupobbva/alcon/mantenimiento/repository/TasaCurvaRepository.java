package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.TasaCurva;
import pe.grupobbva.alcon.mantenimiento.repository.custom.TasaCurvaCustomRepository;

public interface TasaCurvaRepository extends AbstractRepository<TasaCurva>, TasaCurvaCustomRepository {
	
	@Query(value = "update TasaCurva TC set TC.codigoestado = 2 where trunc(TC.fechaproceso) = trunc(:fecha) ")
	@Modifying
	public void eliminarPorFechaProceso(@Param("fecha") Calendar fecha);
	
	@Query(value="from TasaCurva TC where TC.codigoestado = 1 and trunc(TC.fechaproceso) = trunc(:fecha) order by TC.plazo asc")	
	public List<TasaCurva> listarTasaCurvaFechaProceso(@Param("fecha") Calendar fecha);
	
	@Query(value="from TasaCurva TC where TC.codigoestado = 1 and trunc(TC.fechaproceso) = (Select trunc(max(TC1.fechaproceso)) from TasaCurva TC1) order by TC.plazo asc")	
	public List<TasaCurva> listarTasaCurvaFechaMaximaContratacion();

}
