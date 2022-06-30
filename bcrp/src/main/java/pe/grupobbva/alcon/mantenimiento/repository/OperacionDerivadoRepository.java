package pe.grupobbva.alcon.mantenimiento.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.OperacionDerivado;
import pe.grupobbva.alcon.mantenimiento.repository.custom.OperacionDerivadoCustomRepository;

public interface OperacionDerivadoRepository extends AbstractRepository<OperacionDerivado>, OperacionDerivadoCustomRepository {

	@Modifying
	@Query(value = "delete from OperacionDerivado OD where OD.idCarga = :idcarga")
	public void eliminarOperacionDerivadoPorIdCarga(@Param("idcarga") String idcarga);
	
}
