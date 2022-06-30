package pe.grupobbva.alcon.mantenimiento.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.Producto;
import pe.grupobbva.alcon.mantenimiento.repository.custom.ProductoCustomRepository;

public interface ProductoRepository extends AbstractRepository<Producto>, ProductoCustomRepository {
	
	@Query("SELECT COALESCE(COUNT(P),0) from Producto P where P.codigo=:codigo and P.codigoestado=:codigoestado")
	public Long productosDuplicados(@Param("codigo") String codigo,@Param("codigoestado") Integer  codigoestado);
	
	@Query("SELECT COALESCE(COUNT(P),0) from Producto P where P.codigo=:codigo and P.codigoestado=:codigoestado and P.id!=:id")
	public Long productosDuplicadosActualizar(@Param("codigo") String codigo,@Param("codigoestado") Integer  codigoestado,@Param("id") String id);
	
	@Query("SELECT COALESCE(COUNT(P),0) from Producto P where P.codigo=:codigo and P.codigoestado = 1")
	public Long productosExistentesPorCodigo(@Param("codigo") String codigo);
	
	@Query("SELECT COALESCE(COUNT(P),0) from Producto P where P.id=:id")
	public Long productosExistentesActualizar(@Param("id") String id);
	
	@Query(value = "from Producto P where P.codigoestado = 1 and P.codigo=:codigo")
	public Producto obtenerProductoPorCodigo(@Param("codigo") String codigo);

}
