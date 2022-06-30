package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.repository.custom.CargaCustomRepository;

public interface CargaRepository extends AbstractRepository<Carga>, CargaCustomRepository {

	@Query(value = "from Carga C where C.tipocarga = :tipocarga and C.ejecutado = 'S' and trunc(C.fecha) = trunc(:fecha)")
	public List<Carga> listarCargaPorFechaProceso(@Param("tipocarga") String tipocarga, @Param("fecha") Calendar fecha);

	@Query(value = "from Carga C  where C.fechaCreacion>(select C1.fechaCreacion from Carga C1 where C1.id=:id) and C.tipoproceso=:tipoproceso and trunc(C.fecha) = trunc(:fecha) order by C.fechaCreacion asc")
	public List<Carga> listarCargasPosteriores( @Param("id") String id,@Param("tipoproceso")String tipoproceso,@Param("fecha")Calendar fecha);

	@Modifying
	@Query(value = "delete from Carga C where C.id = :id")
	public void eliminarCarga(@Param("id") String id);

	
	@Query(value = "from Carga C where C.tipocarga in :tipocarga and C.ejecutado = 'S' and trunc(C.fecha) = trunc(:fecha) and C.tipoproceso=:tipoproceso")
	public List<Carga> buscarTipoFechaProceso(@Param("fecha")Calendar fecha,@Param("tipoproceso")String proceso ,@Param("tipocarga")List<String> inforeportdiario);
	
	@Query("select coalesce(C.tipocarga, 0) from Carga C where C.id = :id")
	public String obtenerTipoCargaPorIdCarga(@Param("id") String id);
	
}
