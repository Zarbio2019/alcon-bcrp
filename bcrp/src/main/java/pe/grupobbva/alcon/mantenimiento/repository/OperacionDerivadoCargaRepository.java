package pe.grupobbva.alcon.mantenimiento.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.OperacionDerivadoCarga;
import pe.grupobbva.alcon.mantenimiento.repository.custom.OperacionDerivadoCargaCustomRepository;

public interface OperacionDerivadoCargaRepository extends AbstractRepository<OperacionDerivadoCarga>, OperacionDerivadoCargaCustomRepository {

	@Modifying
	@Query(value = "delete from OperacionDerivadoCarga ODC where ODC.carga.id = :idcarga")
	public void eliminarOperacionDerivadoCargaPorIdCarga(@Param("idcarga") String idcarga);
	
}
