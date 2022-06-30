package pe.grupobbva.alcon.mantenimiento.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.Feriado;
import pe.grupobbva.alcon.mantenimiento.repository.custom.FeriadoCustomRepository;

public interface FeriadoRepository extends AbstractRepository<Feriado>, FeriadoCustomRepository {
	
	@Query(value = "SELECT COALESCE(COUNT(f.ID), 0) FROM PCBCRP.FERIADO f WHERE f.CODIGOESTADO= :codigoestado"
			+ " AND EXTRACT(DAY FROM f.fecha)=:dia AND EXTRACT(MONTH FROM f.fecha)=:mes"
			+ " AND EXTRACT(YEAR FROM f.fecha)=:anio", nativeQuery = true)
	public Long feriadosDuplicados(@Param("codigoestado") Integer codigoestado,	 @Param("dia") Integer dia,
			@Param("mes") Integer mes, @Param("anio") Integer anio);
	
	@Query(value = "SELECT COALESCE(COUNT(f.ID),0) FROM PCBCRP.FERIADO f WHERE f.CODIGOESTADO=:codigoestado"
			+ " AND EXTRACT(DAY FROM f.fecha)=:dia AND EXTRACT(MONTH FROM f.fecha)=:mes"
			+ " AND EXTRACT(YEAR FROM f.fecha)=:anio AND f.ID!=:id", nativeQuery = true)
	public Long feriadosDuplicadosActualizar(@Param("codigoestado") Integer codigoestado, @Param("dia") Integer dia, 
			@Param("mes") Integer mes, @Param("anio") Integer anio, @Param("id") String id);
	
	@Query("SELECT COALESCE(COUNT(F),0) from Feriado F where F.id=:id")
	public Long feriadosExistentesActualizar(@Param("id") String id);
	
	@Query(value = "from Feriado F where F.codigoestado = 1 and F.id = :id")
	public Feriado obtenerFeriadoPorId(@Param("id") String id);
	
	@Query(value="update Feriado F set F.operacion = 0 where F.id = :id ")
	@Modifying
	public void actualizarOperacionFeriado(@Param("id") String id);

}
