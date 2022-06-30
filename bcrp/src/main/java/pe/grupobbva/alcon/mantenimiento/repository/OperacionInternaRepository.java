package pe.grupobbva.alcon.mantenimiento.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.OperacionInterna;
import pe.grupobbva.alcon.mantenimiento.repository.custom.OperacionInternaCustomRepository;

public interface OperacionInternaRepository extends AbstractRepository<OperacionInterna>, OperacionInternaCustomRepository {

	@Query(value = "SELECT COALESCE(COUNT(cd.ID), 0) FROM PCBCRP.CIERRE_DIARIO cd WHERE cd.CODIGOESTADO=:codigoestado"
			+ " AND EXTRACT(DAY FROM cd.fecha)=:dia AND EXTRACT(MONTH FROM cd.fecha)=:mes"
			+ " AND EXTRACT(YEAR FROM cd.fecha)=:anio", nativeQuery = true)
	public Long operacionesCierreDiarioVerificar(@Param("codigoestado") Integer codigoestado, @Param("dia") Integer dia, 
			@Param("mes") Integer mes, @Param("anio") Integer anio);
	

	@Query(value = "SELECT c.ID FROM PCBCRP.CLIENTE c WHERE c.CODIGO=:codigo", nativeQuery = true)
	public String operacionesObtenerIdCliente(@Param("codigo") String codigo);
	
	
	@Query(value = "SELECT p.ID FROM PCBCRP.PRODUCTO p WHERE p.CODIGO=:codigo and p.CODIGOESTADO=1", nativeQuery = true)
	public String operacionesObtenerIdProducto(@Param("codigo") String codigo);
	
	
	@Query(value = "SELECT p.CODIGOBCR FROM PCBCRP.PRODUCTO p WHERE p.CODIGO=:codigo and p.CODIGOESTADO=1", nativeQuery = true)
	public String operacionesObtenerCodigoBCR(@Param("codigo") String codigo);
	

	@Query(value = "SELECT LPAD(MAX(SUBSTR(o.CODIGOREPORTE, length(o.CODIGOREPORTE) - 5, 6)) + 1 , 6, '0')"
			+ " FROM PCBCRP.OPERACION o WHERE o.CODIGOESTADO=:codigoestado AND o.ESTADO=:estado AND o.TIPOPROCESO=:tipoproceso"
			+ " AND SUBSTR(o.CODIGOREPORTE, 1, 8)= LPAD(:anio, 4,'0') || LPAD(:mes, 2,'0') || LPAD(:dia, 2,'0')"
			+ " AND EXTRACT(DAY FROM o.FECHAMOVIMIENTO)=:dia AND EXTRACT(MONTH FROM o.FECHAMOVIMIENTO)=:mes"
			+ " AND EXTRACT(YEAR FROM o.FECHAMOVIMIENTO)=:anio", nativeQuery = true)
	public String operacionesObtenerCodigoReporte(@Param("codigoestado") Integer codigoestado, @Param("estado") String estado,
			@Param("tipoproceso") String tipoProceso/*, @Param("codigobcr") String codigoBCR*/,	@Param("dia") Integer dia, 
			@Param("mes") Integer mes, @Param("anio") Integer anio);
	
	
	@Query(value = "SELECT LPAD( EXTRACT(YEAR FROM SYSDATE), 4, '0') || LPAD( EXTRACT(MONTH FROM SYSDATE), 2, '0') ||"
			+ " LPAD( EXTRACT(DAY FROM SYSDATE), 2, '0') FROM DUAL", nativeQuery = true)
	public String operacionesObtenerNumeroOperacion();
	
	
	@Query("SELECT COALESCE(COUNT(P),0) from Producto P where P.codigo=:codigo and P.codigoestado=:codigoestado")
	public Long operacionesDuplicadas(@Param("codigo") String codigo,@Param("codigoestado") Integer  codigoestado);

	
	@Query("SELECT COALESCE(COUNT(O),0) from Operacion O where O.codigoestado=:codigoestado and O.id=:id")
	public Long operacionesDuplicadasActualizar(@Param("codigoestado") Integer codigoestado, @Param("id") String id);
	
	@Query("SELECT COALESCE(COUNT(O),0) from Operacion O where O.id=:id")
	public Long operacionesExistentesActualizar(@Param("id") String id);
	
}
