package pe.grupobbva.alcon.mantenimiento.dto.report;

import lombok.Data;

/**
 * clase DTO para reporte 6
 */
@Data
public class OpcionesDivisasVigentesDTO {
	
	private String operacion;
	private String codigo;
	private String tipoOperacion;
	private String contrapartida;
	private String tipoProceso;
	private String importeUSD;
	private String delta;
	private String importeDelta;
	private String estado;
	
	
}
