package pe.grupobbva.alcon.mantenimiento.dto.table;

import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.FeriadoDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Feriado;

@Data
public class FeriadoTableDTO extends FeriadoDTO {
	
	private String tipoFeriadoDescripcion;
	
	public FeriadoTableDTO() {
		super();
	}
	
	public FeriadoTableDTO(String id) {
		super(id);
	}

	public FeriadoTableDTO(Feriado entity) {
		super(entity);
	}
	
	public FeriadoTableDTO(String id, String tipo, Calendar fecha, String operacion, Integer codigoestado,
			String tipoFeriadoDescripcion) {

		super(id, tipo, fecha, operacion, codigoestado);

		this.tipoFeriadoDescripcion = tipoFeriadoDescripcion;
	}

}
