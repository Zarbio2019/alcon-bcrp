package pe.grupobbva.alcon.mantenimiento.dto.custom.response;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.ValorParametroDTO;
import pe.grupobbva.alcon.mantenimiento.dto.table.ParametroTableDTO;

@Data
public class ValorParametroResponse {
	
	private String idvalorparametro;
	private Integer orden;
	private String valorparametro;
	private String iddetalleparametro;
	
	public ValorParametroResponse(String idvalorparametro,Integer orden, String valorparametro, String iddetalleparametro) {
		super();
		this.idvalorparametro = idvalorparametro;
		this.orden = orden;
		this.valorparametro = valorparametro;
		this.iddetalleparametro = iddetalleparametro;
	}
	public ValorParametroResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
