package pe.grupobbva.alcon.mantenimiento.repository;

import java.math.BigDecimal;
import java.util.Calendar;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.grupobbva.alcon.mantenimiento.entity.TasaInteres;
import pe.grupobbva.alcon.mantenimiento.repository.custom.TasaInteresCustomRepository;

public interface TasaInteresRepository extends AbstractRepository<TasaInteres>, TasaInteresCustomRepository {

	@Modifying
	@Query(value = "delete from TasaInteres TI where TI.idCarga = :idcarga")
	public void eliminarTasaInteresPorIdCarga(@Param("idcarga") String idcarga);
	
	@Query(value = "select coalesce(max(TI.historico), 0) from TasaInteres TI where TI.numerooperacion = :numerooperacion and TI.tipoproceso = :tipoproceso")
	public Integer obtenerMaximoHistoricoDerivadoTasaInteres(@Param("numerooperacion") String numerooperacion, @Param("tipoproceso") String tipoproceso);	
	
	@Query(value = "select coalesce(TI.codigoestado, 0) from TasaInteres TI where TI.numerooperacion = :numerooperacion and TI.tipoproceso = :tipoproceso and TI.historico = :historico")
	public Integer obtenerCodigoEstado(@Param("numerooperacion") String numerooperacion, @Param("tipoproceso") String tipoproceso, @Param("historico") Integer historico);
	
	@Query(value = "select coalesce(count(TI), 0) from TasaInteres TI where ("
			+ " trunc(TI.fechacontratacion) != trunc(:fechacontratacion) "
			+ " or TI.producto.id != :idproducto "
			+ " or TI.numerooperacion != :numerooperacion "
			+ " or TI.cliente.id != :idcliente "
			+ " or TI.tipooperacion != :tipooperacion "
			+ " or TI.iddivisaentrada != :iddivisaentrada "
			+ " or TI.iddivisasalida != :iddivisasalida "
			+ " or TI.importedivisaentrada != :importedivisaentrada "
			+ " or TI.importedivisasalida != :importedivisasalida "
			+ " or TI.cotizacion != :cotizacion "
			+ " or TI.puntosswap != :puntosswap "
			+ " or TI.basica != :basica "
			+ " or TI.cambioref != :cambioref "
			+ " or trunc(TI.fechavalor) != trunc(:fechavalor) "
			+ " or trunc(TI.fechavencimiento) != trunc(:fechavencimiento) "
			+ " or TI.plazo != :plazo "
			+ " or trunc(TI.fechaejercicio) != trunc(:fechaejercicio) "
			+ " or TI.callput != :callput "
			+ " or TI.plaza != :plaza "
			+ " or TI.paisresidencia != :paisresidencia "
			+ " or TI.riesgopais != :riesgopais "
			+ " or TI.prima != :prima "
			+ " or TI.iddivisaprima != :iddivisaprima "
			+ " or TI.observaciones != :observaciones "
			+ " or trunc(TI.fechaalta) != trunc(:fechaalta) "
			+ " or trunc(TI.fechamodificacioncarga) != trunc(:fechamodificacioncarga) "
			+ " or TI.operacionsustituye != :operacionsustituye "
			+ " or trunc(TI.fechabaja) != trunc(:fechabaja) "
			+ " or TI.nif != :nif "
			+ " or TI.intermediario != :intermediario "
			+ " or TI.intermediariodescripcion != :intermediariodescripcion "
			+ " or TI.estado != :estado "
			+ " or TI.contrato != :contrato"
			+ " or TI.residente != :residente "
			+ " or TI.estilo != :estilo "
			+ " or trunc(TI.fechamovimiento) != trunc(:fechamovimiento) "
			+ " or TI.usuariocarga != :usuariocarga "
			+ " or TI.codigooperacion != :codigooperacion "
			+ " or TI.importeusd != :importeusd "
			+ " or TI.codigoreporte != :codigoreporte "
			+ " or TI.tasamonedanacional != :tasamonedanacional "
			+ " or TI.tasamonedaextranjera != :tasamonedaextranjera "
			+ " or TI.delta != :delta "
			+ " or TI.montomonedaextranjera != :montomonedaextranjera "
			+ " or TI.idmonedaextranjera != :idmonedaextranjera "
			+ " or TI.montopen != :montopen "
			+ " or TI.tipocambiospot != :tipocambiospot "
			+ " or TI.tipocambiopactado != :tipocambiopactado "
			+ " or TI.tipocambiovencimiento != :tipocambiovencimiento "
			+ " or TI.validacion != :validacion "
			+ " or TI.tipocliente != :tipocliente "
			+ " or TI.tipoopcion != :tipoopcion "
			+ " or TI.tasadiferencial != :tasadiferencial "
			+ " )"
			+ " and TI.historico = :historico and TI.numerooperacion = :numerooperacion and TI.tipoproceso = :tipoproceso"
			)
		public Long verificarCambioUltimaOperacionDerivadoTasaInteres(
				@Param("fechacontratacion") Calendar fechacontratacion,
				@Param("idproducto") String idproducto,
				@Param("numerooperacion") String numerooperacion,
				@Param("idcliente") String idcliente,
				@Param("tipooperacion") String tipooperacion,
				@Param("iddivisaentrada") String iddivisaentrada,
				@Param("iddivisasalida") String iddivisasalida,
				@Param("importedivisaentrada") BigDecimal importedivisaentrada,
				@Param("importedivisasalida") BigDecimal importedivisasalida, 
				@Param("cotizacion") BigDecimal cotizacion, 
				@Param("puntosswap") BigDecimal puntosswap,
				@Param("basica") String basica, 
				@Param("cambioref") BigDecimal cambioref,
				@Param("fechavalor") Calendar fechavalor,
				@Param("fechavencimiento") Calendar fechavencimiento, 
				@Param("plazo") Integer plazo, 
				@Param("fechaejercicio") Calendar fechaejercicio,
				@Param("callput") String callput, 
				@Param("plaza") String plaza,
				@Param("paisresidencia") String paisresidencia, 
				@Param("riesgopais") String riesgopais, 
				@Param("prima") BigDecimal prima,
				@Param("iddivisaprima") String iddivisaprima,
				@Param("observaciones") String observaciones, 
				@Param("fechaalta") Calendar fechaalta,
				@Param("fechamodificacioncarga") Calendar fechamodificacioncarga, 
				@Param("operacionsustituye") String operacionsustituye, 
				@Param("fechabaja") Calendar fechabaja,
				@Param("nif") String nif, 
				@Param("intermediario") String intermediario,
				@Param("intermediariodescripcion") String intermediariodescripcion, 
				@Param("estado") String estado, 
				@Param("contrato") String contrato,
				@Param("residente") String residente, 
				@Param("estilo") String estilo, 
				@Param("fechamovimiento") Calendar fechamovimiento,
				@Param("usuariocarga") String usuariocarga, 
				@Param("codigooperacion") String codigooperacion, 
				@Param("importeusd") BigDecimal importeusd,
				@Param("codigoreporte") String codigoreporte, 
				@Param("tasamonedanacional") BigDecimal tasamonedanacional,
				@Param("tasamonedaextranjera") BigDecimal tasamonedaextranjera, 
				@Param("delta") BigDecimal delta, 
				@Param("montomonedaextranjera") BigDecimal montomonedaextranjera,
				@Param("idmonedaextranjera") String idmonedaextranjera, 
				@Param("montopen") BigDecimal montopen, 
				@Param("tipocambiospot") BigDecimal tipocambiospot,
				@Param("tipocambiopactado") BigDecimal tipocambiopactado, 
				@Param("tipocambiovencimiento") BigDecimal tipocambiovencimiento,
				@Param("validacion") String validacion,
				@Param("tipocliente") String tipocliente, 
				@Param("tipoopcion") String tipoopcion,
				@Param("tasadiferencial") BigDecimal tasadiferencial,
				@Param("historico") Integer historico, 
				@Param("tipoproceso") String tipoproceso
			);
	
	@Query(value="update TasaInteres TI set TI.codigoestado = 2 where TI.numerooperacion = :numerooperacion and TI.tipoproceso = :tipoproceso and trunc(TI.fechamovimiento) = trunc(:fecha) and TI.historico = :historico")
	@Modifying
	public void eliminarOperacionDerivadoTasaInteresFechaMovimiento(@Param("numerooperacion") String numerooperacion, @Param("tipoproceso") String tipoproceso, @Param("fecha") Calendar fecha, @Param("historico") Integer historico);
	
	
	
}
