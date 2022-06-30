package pe.grupobbva.alcon.mantenimiento.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.Parametro;
import pe.grupobbva.alcon.mantenimiento.repository.custom.ParametroCustomRepository;

public interface ParametroRepository extends AbstractRepository<Parametro>, ParametroCustomRepository {

	@Query(value = "SELECT p.ID FROM PCBCRP.PARAMETRO p WHERE p.CODIGO=:codigo", nativeQuery = true)
	public String getParametroId(@Param("codigo") String codigo);
	
}
