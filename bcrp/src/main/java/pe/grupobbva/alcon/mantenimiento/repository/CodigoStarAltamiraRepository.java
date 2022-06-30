package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.CodigoStarAltamira;

public interface CodigoStarAltamiraRepository extends AbstractRepository<CodigoStarAltamira> {
	
	@Modifying
	@Query(value = "delete from CodigoStarAltamira CA")
	public void eliminarCodigoStarAltamira();
	
	@Query(value = "from CodigoStarAltamira CA")
	public List<CodigoStarAltamira> getCodigosStarAltamira();
	
	@Query("from CodigoStarAltamira CA where CA.codigo = :codigo and CA.codigoestado = :codigoestado")
	public CodigoStarAltamira obtenerCodigoAltamiraPorCliente(@Param("codigo") String codigo, @Param("codigoestado") Integer codigoestado);

}
