package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.Delta;

public interface DeltaRepository extends AbstractRepository<Delta>{

	
	@Query(value="from Delta D where trunc(D.fechaproceso) = trunc(:fecha)")
	public List<Delta> tipoCambioPorfecha(@Param("fecha") Calendar fecha);	
	
	@Query(value="from Delta D where trunc(D.fechaproceso) = (Select trunc(max(D1.fechaproceso)) from Delta D1)")
	public List<Delta> ultimoTipoCambioPorfecha();	
	
	@Query(value="from Delta D where trunc(D.fechaproceso) = (Select trunc(max(D1.fechaproceso)) from Delta D1 where trunc(D1.fechaproceso) < trunc(:fecha))")
	public List<Delta> ultimoTipoCambioPorfecha(@Param("fecha") Calendar fecha);

	@Query(value="delete from Delta D where trunc(D.fechaproceso) = trunc(:fecha)")
	@Modifying
	public void eliminarCarga(@Param("fecha")Calendar fecha);	

}
