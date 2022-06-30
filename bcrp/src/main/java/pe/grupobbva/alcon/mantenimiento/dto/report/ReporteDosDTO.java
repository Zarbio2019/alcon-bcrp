package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;

@Data
public class ReporteDosDTO {
	private String id; 
	private String idcarga; 
	private Calendar fechacontratacion; 
	private String idProducto;
	private String productodescripcion;
	private String numerooperacion; 
	private String idCliente; 
	private String clientecodigo;
	private String clientenombre;
	private String sectorcliente;
	private String clientepaisresidencia;
	private String tipoentrega;
	private String tipooperacion;
	private String tipooperaciondescripcion;
	private String iddivisaentrada;
	private String divisaentradadescripcion;
	private String iddivisasalida; 
	private String divisasalidadescripcion;
	private BigDecimal importedivisaentrada; 
	private BigDecimal importedivisasalida;
	private BigDecimal cotizacion; 
	private BigDecimal puntosswap; 
	private String basica; 
	private BigDecimal cambioref; 
	private Calendar fechavalor;
	private Calendar fechavencimiento; 
	private Integer plazo; 
	private Calendar fechaejercicio; 
	private String callput; 
	private String plaza;
	private String paisresidencia; 
	private String riesgopais; 
	private BigDecimal prima; 
	private String iddivisaprima; 
	private String divisaprimadescripcion;
	private String observaciones;
	private Calendar fechaalta; 
	private Calendar fechamodificacioncarga; 
	private String operacionsustituye; 
	private Calendar fechabaja;
	private String nif; 
	private String intermediario; 
	private String intermediariodescripcion; 
	private String estado; 
	private String contrato;
	private String residente; 
	private String estilo; 
	private String tipoopcion; 
	private String tipoproceso; 
	private Integer historico;
	private Calendar fechamovimiento; 
	private String usuariocarga; 
	private String codigooperacion; 
	private BigDecimal importeusd = BigDecimal.ZERO;
	private String codigoreporte; 
	private BigDecimal tasamonedanacional; 
	private BigDecimal tasamonedaextranjera;
	private BigDecimal delta; 
	private BigDecimal montomonedaextranjera;
	private String idmonedaextranjera;
	private String monedaextranjeradescripcion;
	private BigDecimal montopen; 
	private BigDecimal tipocambiospot; 
	private BigDecimal tipocambiopactado;
	private BigDecimal tipocambiovencimiento; 
	private String validacion; 
	private String codigoagrupacion; 
	private String tipocliente;
	private String tipoclientedescripcion;
	private BigDecimal tasadiferencial;
	private Integer idfilaarchivo;
	private String mensajeerror;
	private Integer codigoestado;

	public ReporteDosDTO() {
		super();

	}


	public ReporteDosDTO(
			String id, 
			String idcarga, 
			Calendar fechacontratacion, 
			String idProducto,
			String productodescripcion,
			String numerooperacion, 
			String idCliente, 
			String clientecodigo,
			String clientenombre,
			String sectorcliente,
			String clientepaisresidencia,
			String tipoentrega,
			String tipooperacion,
			String tipooperaciondescripcion,
			String iddivisaentrada,
			String divisaentradadescripcion,
			String iddivisasalida, 
			String divisasalidadescripcion,
			BigDecimal importedivisaentrada, 
			BigDecimal importedivisasalida,
			BigDecimal cotizacion, 
			BigDecimal puntosswap, 
			String basica, 
			BigDecimal cambioref, 
			Calendar fechavalor,
			Calendar fechavencimiento, 
			Integer plazo, 
			Calendar fechaejercicio, 
			String callput, 
			String plaza,
			String paisresidencia, 
			String riesgopais, 
			BigDecimal prima, 
			String iddivisaprima, 
			String divisaprimadescripcion,
			String observaciones,
			Calendar fechaalta, 
			Calendar fechamodificacioncarga, 
			String operacionsustituye, 
			Calendar fechabaja,
			String nif, 
			String intermediario, 
			String intermediariodescripcion, 
			String estado, 
			String contrato,
			String residente, 
			String estilo, 
			String tipoopcion, 
			String tipoproceso, 
			Integer historico,
			Calendar fechamovimiento, 
			String usuariocarga, 
			String codigooperacion, 
			BigDecimal importeusd,
			String codigoreporte, 
			BigDecimal tasamonedanacional, 
			BigDecimal tasamonedaextranjera,
			BigDecimal delta, 
			BigDecimal montomonedaextranjera,
			String idmonedaextranjera,
			String monedaextranjeradescripcion,
			BigDecimal montopen, 
			BigDecimal tipocambiospot, 
			BigDecimal tipocambiopactado,
			BigDecimal tipocambiovencimiento, 
			String validacion, 
			String codigoagrupacion, 
			String tipocliente,
			String tipoclientedescripcion,
			BigDecimal tasadiferencial,
			Integer idfilaarchivo,
			Integer codigoestado) {
		super();
		
		this.id= id; 
		this.idcarga=idcarga; 
		this.fechacontratacion=fechacontratacion; 
		this.idProducto=idProducto;
		this.productodescripcion =productodescripcion;
		this.numerooperacion = numerooperacion; 
		this.idCliente = idCliente; 
		this.clientecodigo = clientecodigo;
		this.clientenombre = clientenombre;
		this.sectorcliente = sectorcliente;
		this.clientepaisresidencia= clientepaisresidencia;
		this.tipoentrega = tipoentrega;
		this.tipooperacion = tipooperacion;
		this.tipooperaciondescripcion = tipooperaciondescripcion;
		this.iddivisaentrada= iddivisaentrada;
		this.divisaentradadescripcion= divisaentradadescripcion;
		this.iddivisasalida=iddivisasalida; 
		this.divisasalidadescripcion=divisasalidadescripcion;
		this.importedivisaentrada=importedivisaentrada; 
		this.importedivisasalida=importedivisasalida;
		this.cotizacion=cotizacion; 
		this.puntosswap=puntosswap; 
		this.basica=basica; 
		this.cambioref=cambioref; 
		this.fechavalor=fechavalor;
		this.fechavencimiento=fechavencimiento; 
		this.plazo=plazo; 
		this.fechaejercicio=fechaejercicio; 
		this.callput=callput; 
		this.plaza=plaza;
		this.paisresidencia=paisresidencia; 
		this.riesgopais=riesgopais; 
		this.prima=prima; 
		this.iddivisaprima=iddivisaprima; 
		this.divisaprimadescripcion=divisaprimadescripcion;
		this.observaciones=observaciones;
		this.fechaalta=fechaalta; 
		this.fechamodificacioncarga=fechamodificacioncarga; 
		this.operacionsustituye=operacionsustituye; 
		this.fechabaja=fechabaja;
		this.nif=nif; 
		this.intermediario=intermediario; 
		this.intermediariodescripcion=intermediariodescripcion; 
		this.estado=estado; 
		this.contrato=contrato;
		this.residente= residente; 
		this.estilo=estilo; 
		this.tipoopcion=tipoopcion; 
		this.tipoproceso=tipoproceso; 
		this.historico=historico;
		this.fechamovimiento=fechamovimiento; 
		this.usuariocarga=usuariocarga; 
		this.codigooperacion=codigooperacion; 
		this.importeusd=importeusd;
		this.codigoreporte=codigoreporte; 
		this.tasamonedanacional=tasamonedanacional; 
		this.tasamonedaextranjera=tasamonedaextranjera;
		this.delta=delta; 
		this.montomonedaextranjera=montomonedaextranjera;
		this.idmonedaextranjera=idmonedaextranjera;
		this.monedaextranjeradescripcion=monedaextranjeradescripcion;
		this.montopen=montopen; 
		this.tipocambiospot=tipocambiospot; 
		this.tipocambiopactado=tipocambiopactado;
		this.tipocambiovencimiento=tipocambiovencimiento; 
		this.validacion=validacion; 
		this.codigoagrupacion=codigoagrupacion; 
		this.tipocliente=tipocliente;
		this.tipoclientedescripcion=tipoclientedescripcion;
		this.tasadiferencial=tasadiferencial;
		this.idfilaarchivo=idfilaarchivo;
		this.codigoestado=codigoestado;
	}
	
	
	
}
