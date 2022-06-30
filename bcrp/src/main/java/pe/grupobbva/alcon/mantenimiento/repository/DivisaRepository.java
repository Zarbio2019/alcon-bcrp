package pe.grupobbva.alcon.mantenimiento.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.repository.custom.DivisaCustomRepository;

public interface DivisaRepository extends AbstractRepository<Divisa>, DivisaCustomRepository {
	
	@Query("select coalesce(count(*), 0) from Divisa D where D.codigoestado = 1 and D.codigo = :codigo")
	public Long divisaExistentes(@Param("codigo") String codigo);
	
	@Query("select coalesce(count(*),0) from Divisa D where D.codigo=:codigo and D.codigoestado = 1 and D.id != :id")
	public Long divisaExistenteActualizar(@Param("codigo") String codigo, @Param("id") String id);
	
	@Query("select coalesce(D.id, 0) from Divisa D where D.codigoestado = 1 and D.codigo = :codigo")
	public String divisaObtenerId(@Param("codigo") String codigo);
	
	@Query(value = "from Divisa D where D.codigoestado = 1 and D.codigo = :codigo")
	public Divisa obtenerDivisaPorCodigo(@Param("codigo") String codigo);
	
	@Query(value = "from Divisa D where D.codigoestado = 1 and D.id = :id")
	public Divisa obtenerDivisaPorId(@Param("id") String id);

}
