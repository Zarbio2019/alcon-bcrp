package pe.grupobbva.alcon.mantenimiento.dto.table;

import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.CargaDTO;

@Data
public class CargaTableDTO extends CargaDTO {

	public CargaTableDTO(String id, String creadoPor, String actualizadoPor, Calendar fechaCreacion,
			Calendar fechaModificacion, Integer codigoestado, Boolean condicion, String tipocarga, String rutaarchivo,
			Calendar fecha, String nombrearchivo, String ejecutado, String horainicio, String horafin, Integer totalreg,
			Integer totalcargado, String notaerror, String codigoinicio, String codigofinal, String anio, String mes,
			String tipo, String tipoproceso, String tipoCargaDescripcion, String condicionDescripcion, String ejecutadoDescripcion) {

		super(id, creadoPor, actualizadoPor, fechaCreacion, fechaModificacion, codigoestado,
				condicion , tipocarga, fecha, rutaarchivo, nombrearchivo, ejecutado,
				horainicio, horafin, totalreg, totalcargado, notaerror, codigoinicio, codigofinal, anio, mes, tipo,
				tipoproceso);

		this.tipoCargaDescripcion = tipoCargaDescripcion;
		this.condicionDescripcion = condicionDescripcion;
		this.ejecutadoDescripcion = ejecutadoDescripcion;
		
	}

	private String tipoCargaDescripcion;
	private String condicionDescripcion;
	private String ejecutadoDescripcion;
}
