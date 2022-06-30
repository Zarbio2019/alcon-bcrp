package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.DetalleParametro;
import pe.grupobbva.alcon.mantenimiento.repository.custom.DetalleParametroCustomRepository;

public interface DetalleParametroRepository extends AbstractRepository<DetalleParametro>,DetalleParametroCustomRepository{

	@Query(value = "from DetalleParametro DT where DT.parametro.codigo = :codigo and DT.visible is true")
	public List<DetalleParametro> listarCuentas(@Param("codigo") String codigo);
	
	@Query(value = "select coalesce(DT.descripcion, 0) from DetalleParametro DT where DT.parametro.codigo = :codigo and DT.visible is true group by DT.descripcion")
	public List<String> listarCurvas(@Param("codigo") String codigo);
	
	@Query(value = "from DetalleParametro DT where DT.parametro.codigo = :codigo and DT.visible is true")
	public List<DetalleParametro> listarTenor(@Param("codigo") String codigo);
	
}
