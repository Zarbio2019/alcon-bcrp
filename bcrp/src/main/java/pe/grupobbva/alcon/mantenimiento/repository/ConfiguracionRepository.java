package pe.grupobbva.alcon.mantenimiento.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.Configuracion;

public interface ConfiguracionRepository extends AbstractRepository<Configuracion> {
	
	@Query(value = "SELECT COALESCE(COUNT(C.ID), 0) FROM PCBCRP.CONFIGURACION C WHERE"
			+ " CASE WHEN 1 = :dia THEN C.LUNES"
			+ " WHEN 2 = :dia THEN C.MARTES"
			+ " WHEN 3 = :dia THEN C.MIERCOLES"
			+ " WHEN 4 = :dia THEN C.JUEVES"
			+ " WHEN 5 = :dia THEN C.VIERNES"
			+ " WHEN 6 = :dia THEN C.SABADO"
			+ " WHEN 0 = :dia THEN C.DOMINGO END = '1' "
			+ " AND TO_NUMBER(substr(:hora, 1, 2) || substr(:hora, 4, 2))"
			+ " BETWEEN TO_NUMBER(substr(C.HORAINICIALEJECUCION, 1, 2) || substr(C.HORAINICIALEJECUCION, 4, 2))"
			+ " AND TO_NUMBER(substr(C.HORAFINALEJECUCION, 1, 2) || substr(C.HORAFINALEJECUCION, 4, 2))", nativeQuery = true)
	public Long valida(@Param("hora") String hora, @Param("dia") Integer dia);
	
}
