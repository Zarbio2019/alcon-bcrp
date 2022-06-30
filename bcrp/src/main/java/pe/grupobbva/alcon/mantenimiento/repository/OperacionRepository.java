package pe.grupobbva.alcon.mantenimiento.repository;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.Operacion;
import pe.grupobbva.alcon.mantenimiento.repository.custom.OperacionCustomRepository;

public interface OperacionRepository extends AbstractRepository<Operacion>, OperacionCustomRepository {

	@Query(value = "from Operacion O where trunc(O.fechamovimiento)= trunc(:fecha) and O.codigoestado = 1 and O.estado = 'L' and O.tipoproceso = :tipoproceso and O.producto.codigo in ('FXP', 'NDFY', 'IRC', 'OTFX')")
	public List<Operacion> tasaDevolverOperaciones(@Param("fecha") Calendar fecha, @Param("tipoproceso") String tipoproceso);

	@Query(value = "from Operacion O where trunc(O.fechamovimiento)= trunc(:fecha) and trunc(O.fechacontratacion) < trunc(O.fechamovimiento)  and O.codigoestado = 1 and O.estado = 'L' and O.tipoproceso = :tipoproceso and O.producto.codigo in ('FXP', 'NDFY', 'IRC', 'OTFX')")
	public List<Operacion> tasaDevolverOperacionesPredatadas(@Param("fecha") Calendar fecha, @Param("tipoproceso") String tipoproceso);

	@Modifying
	@Query(value = "delete from Operacion O where O.idCarga = :idcarga")
	public void eliminarOperacionPorIdCarga(@Param("idcarga") String idcarga);

	@Query(value = "select coalesce(max(O.historico), 0) from Operacion O where O.numerooperacion = :numerooperacion and O.tipoproceso = :tipoproceso")
	public Integer obtenerMaximoHistorico(@Param("numerooperacion") String numerooperacion,	@Param("tipoproceso") String tipoproceso);

	@Query(value = "select coalesce(O.codigoestado, 0) from Operacion O where O.numerooperacion = :numerooperacion and O.tipoproceso = :tipoproceso and O.historico = :historico")
	public Integer obtenerCodigoEstado(@Param("numerooperacion") String numerooperacion, @Param("tipoproceso") String tipoproceso, @Param("historico") Integer historico);

	@Query(value = "select coalesce(count(O), 0) from Operacion O where ("
			+ " trunc(O.fechacontratacion) != trunc(:fechacontratacion) " + " or O.producto.id != :idproducto "
			+ " or O.numerooperacion != :numerooperacion " + " or O.cliente.id != :idcliente "
			+ " or O.tipooperacion != :tipooperacion " + " or O.iddivisaentrada != :iddivisaentrada "
			+ " or O.iddivisasalida != :iddivisasalida " + " or O.importedivisaentrada != :importedivisaentrada "
			+ " or O.importedivisasalida != :importedivisasalida " + " or O.cotizacion != :cotizacion "
			+ " or O.puntosswap != :puntosswap " + " or O.basica != :basica " + " or O.cambioref != :cambioref "
			+ " or trunc(O.fechavalor) != trunc(:fechavalor) "
			+ " or trunc(O.fechavencimiento) != trunc(:fechavencimiento) " + " or O.plazo != :plazo "
			+ " or trunc(O.fechaejercicio) != trunc(to_date(:fechaejercicio)) " + " or O.callput != :callput "
			+ " or O.plaza != :plaza " + " or O.paisresidencia != :paisresidencia " + " or O.riesgopais != :riesgopais "
			+ " or O.prima != :prima " + " or O.iddivisaprima != :iddivisaprima "
			+ " or O.observaciones != :observaciones " + " or trunc(O.fechaalta) != trunc(:fechaalta) "
			+ " or trunc(O.fechamodificacioncarga) != trunc(:fechamodificacioncarga) "
			+ " or O.operacionsustituye != :operacionsustituye " + " or trunc(O.fechabaja) != trunc(:fechabaja) "
			+ " or O.nif != :nif " + " or O.intermediario != :intermediario "
			+ " or O.intermediariodescripcion != :intermediariodescripcion " + " or O.estado != :estado "
			+ " or O.contrato != :contrato" + " or O.residente != :residente " + " or O.estilo != :estilo "
			+ " or trunc(O.fechamovimiento) != trunc(:fechamovimiento) " + " or O.usuariocarga != :usuariocarga "
			+ " or O.codigooperacion != :codigooperacion " + " or O.importeusd != :importeusd "
			+ " or O.codigoreporte != :codigoreporte " + " or O.tasamonedanacional != :tasamonedanacional "
			+ " or O.tasamonedaextranjera != :tasamonedaextranjera " + " or O.delta != :delta "
			+ " or O.montomonedaextranjera != :montomonedaextranjera "
			+ " or O.idmonedaextranjera != :idmonedaextranjera " + " or O.montopen != :montopen "
			+ " or O.tipocambiospot != :tipocambiospot " + " or O.tipocambiopactado != :tipocambiopactado "
			+ " or O.tipocambiovencimiento != :tipocambiovencimiento " + " or O.validacion != :validacion "
			+ " or O.tipocliente != :tipocliente " + " or O.tipoopcion != :tipoopcion "
			+ " or O.tasadiferencial != :tasadiferencial " + " )"
			+ " and O.historico = :historico and O.numerooperacion = :numerooperacion and O.tipoproceso = :tipoproceso")
	public Long verificarCambioUltimaOperacion(@Param("fechacontratacion") Calendar fechacontratacion,
			@Param("idproducto") String idproducto, @Param("numerooperacion") String numerooperacion,
			@Param("idcliente") String idcliente, @Param("tipooperacion") String tipooperacion,
			@Param("iddivisaentrada") String iddivisaentrada, @Param("iddivisasalida") String iddivisasalida,
			@Param("importedivisaentrada") BigDecimal importedivisaentrada,
			@Param("importedivisasalida") BigDecimal importedivisasalida, @Param("cotizacion") BigDecimal cotizacion,
			@Param("puntosswap") BigDecimal puntosswap, @Param("basica") String basica,
			@Param("cambioref") BigDecimal cambioref, @Param("fechavalor") Calendar fechavalor,
			@Param("fechavencimiento") Calendar fechavencimiento, @Param("plazo") Integer plazo,
			@Param("fechaejercicio") Calendar fechaejercicio, @Param("callput") String callput,
			@Param("plaza") String plaza, @Param("paisresidencia") String paisresidencia,
			@Param("riesgopais") String riesgopais, @Param("prima") BigDecimal prima,
			@Param("iddivisaprima") String iddivisaprima, @Param("observaciones") String observaciones,
			@Param("fechaalta") Calendar fechaalta, @Param("fechamodificacioncarga") Calendar fechamodificacioncarga,
			@Param("operacionsustituye") String operacionsustituye, @Param("fechabaja") Calendar fechabaja,
			@Param("nif") String nif, @Param("intermediario") String intermediario,
			@Param("intermediariodescripcion") String intermediariodescripcion, @Param("estado") String estado,
			@Param("contrato") String contrato, @Param("residente") String residente, @Param("estilo") String estilo,
			@Param("fechamovimiento") Calendar fechamovimiento, @Param("usuariocarga") String usuariocarga,
			@Param("codigooperacion") String codigooperacion, @Param("importeusd") BigDecimal importeusd,
			@Param("codigoreporte") String codigoreporte, @Param("tasamonedanacional") BigDecimal tasamonedanacional,
			@Param("tasamonedaextranjera") BigDecimal tasamonedaextranjera, @Param("delta") BigDecimal delta,
			@Param("montomonedaextranjera") BigDecimal montomonedaextranjera,
			@Param("idmonedaextranjera") String idmonedaextranjera, @Param("montopen") BigDecimal montopen,
			@Param("tipocambiospot") BigDecimal tipocambiospot,
			@Param("tipocambiopactado") BigDecimal tipocambiopactado,
			@Param("tipocambiovencimiento") BigDecimal tipocambiovencimiento, @Param("validacion") String validacion,
			@Param("tipocliente") String tipocliente, @Param("tipoopcion") String tipoopcion,
			@Param("tasadiferencial") BigDecimal tasadiferencial, @Param("historico") Integer historico,
			@Param("tipoproceso") String tipoproceso);

	@Query(value = "update Operacion O set O.codigoestado = 2 where O.numerooperacion = :numerooperacion and O.tipoproceso = :tipoproceso and trunc(O.fechamovimiento) = trunc(:fecha) and O.historico = :historico")
	@Modifying
	public void eliminarOperacionFechaMovimiento(@Param("numerooperacion") String numerooperacion,
			@Param("tipoproceso") String tipoproceso, @Param("fecha") Calendar fecha,
			@Param("historico") Integer historico);

	@Query(value = "from Operacion O where rownum = 1 and  O.correlativo = (select max(OP.correlativo) from Operacion OP where OP.numerooperacion = :numerooperacion )")
	public Operacion obtenerTasasMonedas(@Param("numerooperacion") String numerooperacion);

	@Query("select coalesce(count(O),0) from Operacion O where O.id = :id")
	public Long existeOperacionActualizar(@Param("id") String id);

	@Query(value = "update Operacion O set O.codigoestado = 2, O.actualizadoPor = :actualizadoPor, O.fechaModificacion = :fechaModificacion where O.id = :id ")
	@Modifying
	public void operacionActualizarEstado(@Param("id") String id, @Param("actualizadoPor") String actualizadoPor,
			@Param("fechaModificacion") Calendar fechaModificacion);

	@Query(value = "update Operacion O set O.creadoPor = 'MOD_FERIADO' where O.id = :id ")
	@Modifying
	public void actualizarUsuarioCreador(@Param("id") String id);

	@Query(value = "update Operacion O set O.recibetasafijaspread = :recibetasafijaspread, "
			+ "O.recibetfija = :recibetfija, O.recibeidentificadorfrecuencia = :recibeidentificadorfrecuencia, "
			+ "O.pagatasafijaspread = :pagatasafijaspread, O.pagatfija = :pagatfija, "
			+ "O.pagaidentificadorfrecuencia = :pagaidentificadorfrecuencia "
			+ "where O.id = :id and O.codigoestado = 1")
	@Modifying
	public void actualizarTasasCurvas(@Param("id") String id,
			@Param("recibetasafijaspread") BigDecimal recibetasafijaspread, @Param("recibetfija") String recibetfija,
			@Param("recibeidentificadorfrecuencia") String recibeidentificadorfrecuencia,
			@Param("pagatasafijaspread") BigDecimal pagatasafijaspread, @Param("pagatfija") String pagatfija,
			@Param("pagaidentificadorfrecuencia") String pagaidentificadorfrecuencia);
	
	@Query(value = "from Operacion O where trunc(O.fechamovimiento) = trunc(:fecha) and O.codigoestado = 1 and O.estado = 'L' and O.tipoproceso = :tipoproceso and " 
	+ " O.producto.codigo in (select VP.valor from ValorParametro VP where VP.detalleParametro.parametro.codigo = :codigo and VP.detalleParametro.visible is true)")
	public List<Operacion> tasaCurvaDevolverOperaciones(@Param("fecha") Calendar fecha, @Param("tipoproceso") String tipoproceso, @Param("codigo") String codigo);

}
