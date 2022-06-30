package pe.grupobbva.alcon.mantenimiento.dto.util;

import java.util.List;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.DetalleParametroDTO;
import pe.grupobbva.alcon.mantenimiento.dto.ParametroDTO;
import pe.grupobbva.alcon.mantenimiento.dto.ValorParametroDTO;

@Data
public class ParameterRequestBody {
	private ParametroDTO parametro;
	private DetalleParametroDTO detalleparametro;
	private List<ValorParametroDTO> valorparametro;
	
	public ParameterRequestBody(ParametroDTO parametro, DetalleParametroDTO detalleparametro,
			List<ValorParametroDTO> valorparametro) {
		super();
		this.parametro = parametro;
		this.detalleparametro = detalleparametro;
		this.valorparametro = valorparametro;
	}
	
	public ParameterRequestBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
