package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.Cliente;
import pe.grupobbva.alcon.mantenimiento.repository.custom.ClienteCustomRepository;

public interface ClienteRepository extends AbstractRepository<Cliente>, ClienteCustomRepository {

	
	@Query("SELECT COALESCE(COUNT(C),0) from Cliente C where C.codigo=:codigo and C.codigoestado=:codigoestado")
	public Long clientesDuplicados(@Param("codigo") String codigo,@Param("codigoestado") Integer  codigoestado);

	@Query("SELECT COALESCE(COUNT(C),0) from Cliente C where C.codigo=:codigo and C.codigoestado=:codigoestado and C.id!=:id")
	public Long clientesDuplicadosActualizar(@Param("codigo") String codigo, @Param("codigoestado") Integer codigoestado, @Param("id") String id);
	
	@Query("SELECT COALESCE(COUNT(C),0) from Cliente C where C.id=:id")
	public Long clientesExistentesActualizar(@Param("id") String id);
	
	@Query(value = "from Cliente C where C.codigoestado = 1 and C.rechazarcarga = 'S'")
	public List<Cliente> listarRechazarCarga();
	
	@Query("SELECT COALESCE(COUNT(C),0) from Cliente C where trim(C.altamira) = :altamira and C.codigoestado = 1")
	public Long clienteAltamira(@Param("altamira") String altamira);
	
	@Query(value = "SELECT * FROM PCBCRP.CLIENTE c WHERE TRIM(c.ALTAMIRA) = :altamira AND ROWNUM = 1", nativeQuery = true)
	public Cliente obtenerClientePorCodigoAltamira(@Param("altamira") String altamira);
		
	@Query(value="update Cliente C set C.altamira = :altamira where C.codigo = :codigo ")
	@Modifying
	public void actualizarClientesCodigoCentralAltamira(@Param("codigo") String codigo, @Param("altamira") String altamira);
	
	@Query(value="update Cliente C set C.nombrecorto = :nombrecorto, C.tipocliente = :tipocliente, C.tipodocumento = :tipodocumento, C.numerodocumento = :numerodocumento, C.sector = :sector where C.id = :id")
	@Modifying
	public void actualizarClienteHost(@Param("id") String id, @Param("nombrecorto") String nombrecorto, @Param("tipocliente") String tipocliente, 
			@Param("tipodocumento") Integer tipodocumento, @Param("numerodocumento") String numerodocumento, @Param("sector") String sector);
	
	@Query(value = "from Cliente C where C.codigoestado = 1 and C.altamira is null")
	public List<Cliente> obtenerClientesSinAltamira();
	
}
