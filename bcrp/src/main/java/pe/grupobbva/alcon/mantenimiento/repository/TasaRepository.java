package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.Tasa;
import pe.grupobbva.alcon.mantenimiento.repository.custom.TasaCustomRepository;

public interface TasaRepository extends AbstractRepository<Tasa>, TasaCustomRepository {

	@Query(value="from Tasa T where T.codigoestado = 1 and T.iddivisa = (Select D.id from Divisa D where D.codigo = 'PEN') and trunc(T.fechaproceso) = (Select trunc(max(T1.fechaproceso)) from Tasa T1) order by T.coordenadax asc")	
	public List<Tasa> listarTasaFechaMaximaContratacion();
	
	@Query(value="from Tasa T where T.codigoestado = 1 and T.iddivisa = (Select D.id from Divisa D where D.codigo = 'PEN') and trunc(T.fechaproceso) = trunc(:fecha)")	
	public List<Tasa> listarTasaFechaContratacion(@Param("fecha") Calendar fecha);
	
	@Query(value="from Tasa T where T.codigoestado = 1 and T.iddivisa = (Select D.id from Divisa D where D.codigo = 'PEN') and trunc(T.fechaproceso) = trunc(:fecha) order by T.coordenadax asc")	
	public List<Tasa> listarTasaFechaProceso(@Param("fecha") Calendar fecha);
	
}
