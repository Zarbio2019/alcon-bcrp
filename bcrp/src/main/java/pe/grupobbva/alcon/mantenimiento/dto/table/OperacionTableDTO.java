package pe.grupobbva.alcon.mantenimiento.dto.table;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Operacion;

@Data
public class OperacionTableDTO extends OperacionDTO {
		
	private String productoCodigo;
	private String clienteCodigo;
	private String clienteNombre;
	private String divisaEntradaCodigo;
	private String divisaSalidaCodigo;
	private String tipoOperacionDescripcion;
	private String tipoProcesoDescripcion;
	private String estadoOperacionDescripcion;
	private String divisaPrimaCodigo;
	private String sectorCliente;
	private String tipoClienteDescripcion;
	private String divisaMonedaeExtCodigo;
	private String tipoentrega;
	
	public OperacionTableDTO() {
		super();
	}
	
	public OperacionTableDTO(String id) {
		super(id);
	}

	public OperacionTableDTO(Operacion entity) {
		super(entity);
	}

	public OperacionTableDTO(String id, String idcarga, Calendar fechacontratacion, String idProducto,
			String numerooperacion, String idCliente, String tipooperacion, String iddivisaentrada,
			String iddivisasalida, BigDecimal importedivisaentrada, BigDecimal importedivisasalida,
			BigDecimal cotizacion, BigDecimal puntosswap, String basica, BigDecimal cambioref, Calendar fechavalor,
			Calendar fechavencimiento, Integer plazo, Calendar fechaejercicio, String callput, String plaza,
			String paisresidencia, String riesgopais, BigDecimal prima, String iddivisaprima, String observaciones,
			Calendar fechaalta, Calendar fechamodificacioncarga, String operacionsustituye, Calendar fechabaja,
			String nif, String intermediario, String intermediariodescripcion, String estado, String contrato,
			String residente, String estilo, String tipoopcion, String tipoproceso, Integer historico,
			Calendar fechamovimiento, String usuariocarga, String codigooperacion, BigDecimal importeusd,
			String codigoreporte, BigDecimal tasamonedanacional, BigDecimal montomonedaextranjera,
			BigDecimal tasadiferencial, BigDecimal delta, BigDecimal tasamonedaextranjera, String idmonedaextranjera,
			BigDecimal montopen, BigDecimal tipocambiospot, BigDecimal tipocambiopactado,
			BigDecimal tipocambiovencimiento, String validacion, String codigoagrupacion, String tipocliente,
			Integer idfilaarchivo, String mensajeerror, String correlativo, Integer codigoestado,
			BigDecimal volatilidad, String intencioncontratacion, String tipoaccion,
			String productoCodigo, String clienteCodigo,String clienteNombre,String divisaEntradaCodigo,String divisaSalidaCodigo,
			String tipoOperacionDescripcion,String tipoProcesoDescripcion,String estadoOperacionDescripcion,String divisaPrimaCodigo) {
		
		super(id, idcarga, fechacontratacion, idProducto, numerooperacion, idCliente, tipooperacion, iddivisaentrada,
				iddivisasalida, importedivisaentrada, importedivisasalida, cotizacion, puntosswap, basica, cambioref,
				fechavalor, fechavencimiento, plazo, fechaejercicio, callput, plaza, paisresidencia, riesgopais, prima,
				iddivisaprima, observaciones, fechaalta, fechamodificacioncarga, operacionsustituye, fechabaja, nif,
				intermediario, intermediariodescripcion, estado, contrato, residente, estilo, tipoopcion, tipoproceso,
				historico, fechamovimiento, usuariocarga, codigooperacion, importeusd, codigoreporte, tasamonedanacional,
				montomonedaextranjera, tasadiferencial, delta, tasamonedaextranjera, idmonedaextranjera, montopen,
				tipocambiospot, tipocambiopactado, tipocambiovencimiento, validacion, codigoagrupacion, tipocliente,
				idfilaarchivo, mensajeerror, correlativo, codigoestado, volatilidad, intencioncontratacion, tipoaccion);
		
		this.productoCodigo = productoCodigo;
		this.clienteCodigo = clienteCodigo;
		this.clienteNombre = clienteNombre;
		this.divisaEntradaCodigo = divisaEntradaCodigo;
		this.divisaSalidaCodigo = divisaSalidaCodigo;
		this.tipoOperacionDescripcion = tipoOperacionDescripcion;
		this.tipoProcesoDescripcion = tipoProcesoDescripcion;
		this.estadoOperacionDescripcion = estadoOperacionDescripcion;
		this.divisaPrimaCodigo = divisaPrimaCodigo;
		
	}

	public OperacionTableDTO(String id, String idcarga, Calendar fechacontratacion, String idProducto,
			String numerooperacion, String idCliente, String tipooperacion, String iddivisaentrada,
			String iddivisasalida, BigDecimal importedivisaentrada, BigDecimal importedivisasalida,
			BigDecimal cotizacion, BigDecimal puntosswap, String basica, BigDecimal cambioref, Calendar fechavalor,
			Calendar fechavencimiento, Integer plazo, Calendar fechaejercicio, String callput, String plaza,
			String paisresidencia, String riesgopais, BigDecimal prima, String iddivisaprima, String observaciones,
			Calendar fechaalta, Calendar fechamodificacioncarga, String operacionsustituye, Calendar fechabaja,
			String nif, String intermediario, String intermediariodescripcion, String estado, String contrato,
			String residente, String estilo, String tipoopcion, String tipoproceso, Integer historico,
			Calendar fechamovimiento, String usuariocarga, String codigooperacion, BigDecimal importeusd,
			String codigoreporte, BigDecimal tasamonedanacional, BigDecimal montomonedaextranjera,
			BigDecimal tasadiferencial, BigDecimal delta, BigDecimal tasamonedaextranjera, String idmonedaextranjera,
			BigDecimal montopen, BigDecimal tipocambiospot, BigDecimal tipocambiopactado,
			BigDecimal tipocambiovencimiento, String validacion, String codigoagrupacion, String tipocliente,
			Integer idfilaarchivo, String mensajeerror, String correlativo, Integer codigoestado,
			String productoCodigo, String clienteCodigo,String clienteNombre,String divisaEntradaCodigo,String divisaSalidaCodigo,
			String tipoOperacionDescripcion,String tipoProcesoDescripcion,String estadoOperacionDescripcion,String divisaPrimaCodigo) {
		
		super(id, idcarga, fechacontratacion, idProducto, numerooperacion, idCliente, tipooperacion, iddivisaentrada,
				iddivisasalida, importedivisaentrada, importedivisasalida, cotizacion, puntosswap, basica, cambioref,
				fechavalor, fechavencimiento, plazo, fechaejercicio, callput, plaza, paisresidencia, riesgopais, prima,
				iddivisaprima, observaciones, fechaalta, fechamodificacioncarga, operacionsustituye, fechabaja, nif,
				intermediario, intermediariodescripcion, estado, contrato, residente, estilo, tipoopcion, tipoproceso,
				historico, fechamovimiento, usuariocarga, codigooperacion, importeusd, codigoreporte, tasamonedanacional,
				montomonedaextranjera, tasadiferencial, delta, tasamonedaextranjera, idmonedaextranjera, montopen,
				tipocambiospot, tipocambiopactado, tipocambiovencimiento, validacion, codigoagrupacion, tipocliente,
				idfilaarchivo, mensajeerror, correlativo, codigoestado);
		
		this.productoCodigo = productoCodigo;
		this.clienteCodigo = clienteCodigo;
		this.clienteNombre = clienteNombre;
		this.divisaEntradaCodigo = divisaEntradaCodigo;
		this.divisaSalidaCodigo = divisaSalidaCodigo;
		this.tipoOperacionDescripcion = tipoOperacionDescripcion;
		this.tipoProcesoDescripcion = tipoProcesoDescripcion;
		this.estadoOperacionDescripcion = estadoOperacionDescripcion;
		this.divisaPrimaCodigo = divisaPrimaCodigo;
		
	}
	
	public OperacionTableDTO(String id, String idcarga, Calendar fechacontratacion, String idProducto,
			String numerooperacion, String idCliente, String tipooperacion, 
			String iddivisaentrada,	String iddivisasalida, BigDecimal importedivisaentrada, BigDecimal importedivisasalida,
			BigDecimal cotizacion, BigDecimal puntosswap, String basica, BigDecimal cambioref, Calendar fechavalor,
			Calendar fechavencimiento, Integer plazo, Calendar fechaejercicio, String callput, String plaza,
			String paisresidencia, String riesgopais, BigDecimal prima, String iddivisaprima, String observaciones,
			Calendar fechaalta, Calendar fechamodificacioncarga, String operacionsustituye, Calendar fechabaja,
			String nif, String intermediario, String intermediariodescripcion, String estado, String contrato,
			String residente, String estilo, String tipoopcion, String tipoproceso, Integer historico,
			Calendar fechamovimiento, String usuariocarga, String codigooperacion, BigDecimal importeusd,
			String codigoreporte, BigDecimal tasamonedanacional, BigDecimal montomonedaextranjera,
			BigDecimal tasadiferencial, BigDecimal delta, BigDecimal tasamonedaextranjera, String idmonedaextranjera,
			BigDecimal montopen, BigDecimal tipocambiospot, BigDecimal tipocambiopactado,
			BigDecimal tipocambiovencimiento, String validacion, String codigoagrupacion, String tipocliente,
			BigDecimal recibetasafijaspread, String recibetfija, String recibeidentificadorfrecuencia,
			BigDecimal pagatasafijaspread, String pagatfija, String pagaidentificadorfrecuencia,
			BigDecimal volatilidad, String intencioncontratacion, String tipoaccion,
			String productoCodigo, String clienteCodigo ,String clienteNombre, String sectorCliente, 
			String divisaEntradaCodigo, String divisaSalidaCodigo, String tipoOperacionDescripcion,
			String tipoClienteDescripcion, String divisaPrimaCodigo, String divisaMonedaeExtCodigo, String tipoentrega) {
		
		super(id, idcarga, fechacontratacion, idProducto, numerooperacion, idCliente, tipooperacion, 
				iddivisaentrada, iddivisasalida, importedivisaentrada, importedivisasalida, cotizacion, puntosswap, basica, 
				cambioref, fechavalor, fechavencimiento, plazo, fechaejercicio, callput, plaza, paisresidencia, riesgopais, 
				prima, iddivisaprima, observaciones, fechaalta, fechamodificacioncarga, operacionsustituye, fechabaja, nif,
				intermediario, intermediariodescripcion, estado, contrato, residente, estilo, tipoopcion, tipoproceso,
				historico, fechamovimiento, usuariocarga, codigooperacion, importeusd, codigoreporte, tasamonedanacional,
				montomonedaextranjera, tasadiferencial, delta, tasamonedaextranjera, idmonedaextranjera, montopen,
				tipocambiospot, tipocambiopactado, tipocambiovencimiento, validacion, codigoagrupacion, tipocliente,
				recibetasafijaspread, recibetfija, recibeidentificadorfrecuencia, pagatasafijaspread, 
				pagatfija, pagaidentificadorfrecuencia,	volatilidad, intencioncontratacion, tipoaccion);

		this.productoCodigo = productoCodigo;
		this.clienteCodigo = clienteCodigo;
		this.clienteNombre = clienteNombre;
		this.sectorCliente = sectorCliente;
		this.divisaEntradaCodigo = divisaEntradaCodigo;
		this.divisaSalidaCodigo = divisaSalidaCodigo;
		this.tipoOperacionDescripcion = tipoOperacionDescripcion;
		this.tipoClienteDescripcion = tipoClienteDescripcion;
		this.divisaPrimaCodigo = divisaPrimaCodigo;
		this.divisaMonedaeExtCodigo = divisaMonedaeExtCodigo;
		this.tipoentrega = tipoentrega;
		
		
	}
	

}
