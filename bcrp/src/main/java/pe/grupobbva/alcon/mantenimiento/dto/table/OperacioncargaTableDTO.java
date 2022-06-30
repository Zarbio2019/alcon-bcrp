package pe.grupobbva.alcon.mantenimiento.dto.table;

import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.OperacioncargaDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Operacioncarga;
import pe.grupobbva.alcon.mantenimiento.entity.TipoOperacion;
import pe.grupobbva.alcon.mantenimiento.entity.TipoProceso;

@Data
public class OperacioncargaTableDTO extends OperacioncargaDTO {

	private String estadoOperacionDescripcion;
	private String tipoOperacionDescripcion;

	public OperacioncargaTableDTO() {
		super();
	}

	public OperacioncargaTableDTO(String id) {
		super(id);
	}

	public OperacioncargaTableDTO(Operacioncarga entity) {
		super(entity);
	}

	public OperacioncargaTableDTO(String id, String idcarga, Calendar fechacarga, Integer idfilaarchivo,
			String fechacontratacion, String producto, String numerooperacion, String codigocliente,
			String nombrecliente, String divisaentrada, String divisasalida, String importedivisaentrada,
			String importedivisasalida, String cotizacion, String puntosswap, String basica, String cambioref,
			String fechavalor, String fechavencimiento, String plazo, String fechaejercicio, String callput,
			String plaza, String paisresidencia, String paisriesgo, String prima, String divisaprima,
			String observacioncarga, String fechaalta, String fechamodificacioncarga, String operacionsustituye,
			String fechabaja, String nif, String intermediario, String intermediariodescripcion, String usuario,
			String nombreusuario, String estado, String fechafixing, String tasapen, String tasausd, String delta,
			String basicaauxiliar, String tipopperacionauxiliar, String mensajeerror, String tipoproceso,
			String tipooperacion, String estadoOperacionDescripcion, String tipoOperacionDescripcion) {

		super(id, idcarga, fechacarga, idfilaarchivo, fechacontratacion, producto, numerooperacion, codigocliente,
				nombrecliente, divisaentrada, divisasalida, importedivisaentrada, importedivisasalida, cotizacion,
				puntosswap, basica, cambioref, fechavalor, fechavencimiento, plazo, fechaejercicio, callput, plaza,
				paisresidencia, paisriesgo, prima, divisaprima, observacioncarga, fechaalta, fechamodificacioncarga,
				operacionsustituye, fechabaja, nif, intermediario, intermediariodescripcion, usuario, nombreusuario,
				estado, fechafixing, tasapen, tasausd, delta, basicaauxiliar, tipopperacionauxiliar, mensajeerror,
				TipoProceso.valueOf(tipoproceso), TipoOperacion.valueOf(tipooperacion));
		
		this.estadoOperacionDescripcion = estadoOperacionDescripcion;
		this.tipoOperacionDescripcion = tipoOperacionDescripcion;

	}

}
