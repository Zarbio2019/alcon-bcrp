package pe.grupobbva.alcon.mantenimiento.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.Oficina;
import pe.grupobbva.alcon.mantenimiento.repository.custom.OficinaCustomRepository;

public interface OficinaRepository extends AbstractRepository<Oficina> , OficinaCustomRepository {

	@Query("select coalesce(count(*),0) from Oficina O where O.codigo = :codigo and O.codigoestado = :codigoestado")
	public Long oficinasDuplicados(@Param("codigo") String codigo, @Param("codigoestado") Integer codigoestado);
	
	@Query("select coalesce(count(*),0) from Oficina O where O.codigo=:codigo and O.codigoestado = :codigoestado and O.id != :id")
	public Long oficinasDuplicadosActualizar(@Param("codigo") String codigo, @Param("codigoestado") Integer  codigoestado, @Param("id") String id);
	
	@Query("select coalesce(count(*),0) from Oficina O where O.id = :id")
	public Long oficinasExistentesActualizar(@Param("id") String id);
	
	@Query(value="select coalesce(count(SC), 0) FROM SaldoContable SC where SC.oficina.id = :id AND SC.codigoestado = :codigoestado")
	public Long oficinasUtilizadasSaldoContable(@Param("codigoestado") Integer  codigoestado, @Param("id") String id);
	
	@Query("select coalesce(O.id, 0) from Oficina O where O.codigoestado = 1 and O.codigo = :codigo")
	public String oficinaObtenerId(@Param("codigo") String codigo);
	
	@Query(value = "from Oficina O where O.codigoestado = 1 and O.codigo = :codigo")
	public Oficina obtenerOficinaPorCodigo(@Param("codigo") String codigo);
	
}
