package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.ValorParametro;
import pe.grupobbva.alcon.mantenimiento.repository.custom.ValorParametroCustomRepository;

public interface ValorParametroRepository extends AbstractRepository<ValorParametro>, ValorParametroCustomRepository {

	@Query(value = "from ValorParametro VP where VP.codigoestado = 1 and VP.detalleParametro.parametro.codigo = :codigo and VP.detalleParametro.descripcion = :descripcion")
	public ValorParametro obtenerParametroPorCodigo(@Param("codigo") String codigo, @Param("descripcion") String descripcion);
	
	@Query(value = "from ValorParametro VP where VP.codigoestado = 1 and VP.detalleParametro.id in (select VP.detalleParametro.id from ValorParametro VP where VP.detalleParametro.descripcion = :descripcion and VP.valor = :valor) and VP.orden = 2")
	public ValorParametro obtenerParametroCurvaDivisaCodigo(@Param("descripcion") String descripcion, @Param("valor") String valor);
	
	@Query(value = "from ValorParametro VP where VP.codigoestado = 1 and VP.detalleParametro.visible is true and VP.detalleParametro.id in (select VP.detalleParametro.id from ValorParametro VP where VP.detalleParametro.descripcion = :descripcion and VP.valor = :valor) and VP.orden = 1")
	public ValorParametro obtenerParametroDivisaCodigo(@Param("descripcion") String descripcion, @Param("valor") String valor);
	
	@Query(value = "from ValorParametro VP where VP.detalleParametro.id in (select VP.detalleParametro.id from ValorParametro VP where VP.detalleParametro.parametro.codigo = :codigo) and VP.detalleParametro.visible is true and VP.orden = 1")
	public List<ValorParametro> listarDivisasCurvas(@Param("codigo") String codigo);
	
	@Query(value = "from ValorParametro VP where VP.codigoestado = 1 and VP.detalleParametro.parametro.codigo = :codigo and VP.detalleParametro.descripcion = :descripcion and VP.detalleParametro.visible is true")
	public ValorParametro obtenerDescripcionTenor(@Param("descripcion") String descripcion, @Param("codigo") String codigo);
	
	@Query(value = "from ValorParametro VP where VP.detalleParametro.id in (select VP.detalleParametro.id from ValorParametro VP where VP.detalleParametro.parametro.codigo = :codigo) and VP.detalleParametro.visible is true")
	public List<ValorParametro> obtenerCredenciales(@Param("codigo") String codigo);

	@Query(value = "from ValorParametro VP where VP.codigoestado = 1 and VP.detalleParametro.parametro.codigo = :codigo and VP.detalleParametro.descripcion = :descripcion")
	public ValorParametro obtenerParametroValorPais(@Param("codigo") String codigo, @Param("descripcion") String descripcion);
	
}
