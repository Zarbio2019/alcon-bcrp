package pe.grupobbva.alcon.mantenimiento.dto.report;

import lombok.Data;

/**
 * clase DTO para reporte 4
 */
@Data
public class PosicionCambioContableDTO {

	
	private String codigo;
	private String rubro;
	private String descripcion;
	private String importeAnual;
	private String importeDelta;
	
}
