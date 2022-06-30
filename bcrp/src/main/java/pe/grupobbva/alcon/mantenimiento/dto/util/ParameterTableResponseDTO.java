package pe.grupobbva.alcon.mantenimiento.dto.util;

import java.util.List;
import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.ParametroResponse;

@Data
public class ParameterTableResponseDTO {
	private ParameterColumnsDTO columnas;
	private List<ParametroResponse> registros;
	
	public ParameterTableResponseDTO(ParameterColumnsDTO columnas, List<ParametroResponse> registros) {
		super();
		this.columnas = columnas;
		this.registros = registros;
	}
	
	public ParameterTableResponseDTO() {
		super();
	}
	


	
	
}
