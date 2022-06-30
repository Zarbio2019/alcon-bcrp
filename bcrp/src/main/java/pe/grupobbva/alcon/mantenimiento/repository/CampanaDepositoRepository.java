package pe.grupobbva.alcon.mantenimiento.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.CampanaDeposito;
import pe.grupobbva.alcon.mantenimiento.repository.custom.CampanaDepositoCustomRepository;

public interface CampanaDepositoRepository extends AbstractRepository<CampanaDeposito>, CampanaDepositoCustomRepository {

	@Modifying
	@Query(value = "delete from CampanaDeposito CD where CD.idCarga = :idcarga")
	public void eliminarCampanaDepositoPorIdCarga(@Param("idcarga") String idcarga);
	
}
