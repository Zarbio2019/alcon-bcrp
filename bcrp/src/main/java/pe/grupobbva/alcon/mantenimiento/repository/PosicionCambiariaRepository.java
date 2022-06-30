package pe.grupobbva.alcon.mantenimiento.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.PosicionCambiariaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.PosicionCambiariaSearch;
import pe.grupobbva.alcon.mantenimiento.entity.PosicionCambiaria;
import pe.grupobbva.alcon.mantenimiento.repository.custom.PosicionCambiariaCustomRepository;

public interface PosicionCambiariaRepository extends AbstractRepository<PosicionCambiaria>, PosicionCambiariaCustomRepository {

	@Query("select coalesce(count(*), 0) from PosicionCambiaria PC where PC.codigoestado = 1 and PC.codigo = :codigo")
	public Long posicionCambiariaExistentes(@Param("codigo") String codigo);
	
	@Query("select coalesce(count(*), 0) from PosicionCambiaria PC where PC.codigo=:codigo and PC.codigoestado = 1 and PC.id != :id")
	public Long posicionCambiariaExistenteActualizar(@Param("codigo") String codigo, @Param("id") String id);
	
}
