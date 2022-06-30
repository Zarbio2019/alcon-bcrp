package pe.grupobbva.alcon.mantenimiento.dto.table;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionInternaDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CallPut;
import pe.grupobbva.alcon.mantenimiento.entity.Estado;
import pe.grupobbva.alcon.mantenimiento.entity.Estilo;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionInterna;
import pe.grupobbva.alcon.mantenimiento.entity.Residente;
import pe.grupobbva.alcon.mantenimiento.entity.TipoOpcion;
import pe.grupobbva.alcon.mantenimiento.entity.TipoOperacion;
import pe.grupobbva.alcon.mantenimiento.entity.TipoProceso;

@Data
public class OperacionInternaTableDTO extends OperacionInternaDTO {
	
	private String productoCodigo;
	private String clienteCodigo;
	private String clienteNombre;
	private String divisaEntradaCodigo;
	private String divisaSalidaCodigo;
	private String tipoOperacionDescripcion;

	public OperacionInternaTableDTO() {
		super();
	}
	
	public OperacionInternaTableDTO(String id) {
		super(id);
	}

	public OperacionInternaTableDTO(OperacionInterna entity) {
		super(entity);
	}

	public OperacionInternaTableDTO(String id, String idcarga, Calendar fechacontratacion, String idProducto,
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
			Integer idfilaarchivo, Integer codigoestado, String productoCodigo, String clienteCodigo,
			String clienteNombre, String divisaEntradaCodigo, String divisaSalidaCodigo,
			String tipoOperacionDescripcion) {
		
		super(id, idcarga, fechacontratacion, idProducto, numerooperacion, idCliente, tipooperacion, iddivisaentrada,
				iddivisasalida, importedivisaentrada, importedivisasalida, cotizacion, puntosswap, basica, cambioref,
				fechavalor, fechavencimiento, plazo, fechaejercicio, callput, plaza, paisresidencia, riesgopais, prima,
				iddivisaprima, observaciones, fechaalta, fechamodificacioncarga, operacionsustituye, fechabaja, nif,
				intermediario, intermediariodescripcion, estado, contrato, residente, estilo, tipoopcion, tipoproceso,
				historico, fechamovimiento, usuariocarga, codigooperacion, importeusd, codigoreporte,
				tasamonedanacional, montomonedaextranjera, tasadiferencial, delta, tasamonedaextranjera,
				idmonedaextranjera, montopen, tipocambiospot, tipocambiopactado, tipocambiovencimiento, validacion,
				codigoagrupacion, tipocliente, idfilaarchivo, codigoestado);
		
		this.productoCodigo = productoCodigo;
		this.clienteCodigo = clienteCodigo;
		this.clienteNombre = clienteNombre;
		this.divisaEntradaCodigo = divisaEntradaCodigo;
		this.divisaSalidaCodigo = divisaSalidaCodigo;
		this.tipoOperacionDescripcion = tipoOperacionDescripcion;
	}

}
