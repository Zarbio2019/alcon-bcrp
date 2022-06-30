package pe.grupobbva.alcon.mantenimiento.dto.report;

import lombok.Data;

@Data
public class ReporteCuatroPosicionCambiariaDTO {
	
	private String idposicioncambiaria;

	public ReporteCuatroPosicionCambiariaDTO(String idposicioncambiaria) {
		super();
		this.idposicioncambiaria = idposicioncambiaria;
	}

	public ReporteCuatroPosicionCambiariaDTO() {
		super();
	}
	
}
