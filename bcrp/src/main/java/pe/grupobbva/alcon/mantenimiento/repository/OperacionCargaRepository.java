package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.Operacioncarga;
import pe.grupobbva.alcon.mantenimiento.repository.custom.OperacionCargaCustomRepository;

public interface OperacionCargaRepository extends AbstractRepository<Operacioncarga>, OperacionCargaCustomRepository{

	@Modifying
	@Query(value = "update Operacioncarga OC set OC.mensajeerror = :mensajeerror, OC.actualizadoPor = :actualizadoPor, OC.fechaModificacion = :fecha " 
			+ " where OC.carga.id = :idcarga and (OC.numerooperacion = :numerooperacion or concat(OC.numerooperacion,'000') = :numerooperacion) and OC.idfilaarchivo = :idfilaarchivo")
	public void actualizarMensajeError(@Param("idcarga") String idcarga, @Param("numerooperacion") String numerooperacion,
			@Param("mensajeerror") String mensajeerror, @Param("idfilaarchivo") Integer idfilaarchivo, 
			@Param("actualizadoPor") String actualizadoPor, @Param("fecha") Calendar fecha);
	
	@Modifying
	@Query(value = "delete from Operacioncarga OC where OC.carga.id = :idcarga")
	public void eliminarOperacionCargaPorIdCarga(@Param("idcarga") String idcarga);
	
	
	
	@Query(value = "select OC from Operacioncarga OC where OC.carga.id = :idcarga order by OC.idfilaarchivo asc")
	public List<Operacioncarga>loadOperacionCarga(@Param("idcarga") String idcarga);

	@Modifying
	@Query(value = "update Operacioncarga  OC set OC.mensajeerror=null where OC.carga.id = :idcarga")
	public void restaurarestadoOperacionCargaPorIdCarga(@Param("idcarga")String idcarga);
	
	
}
