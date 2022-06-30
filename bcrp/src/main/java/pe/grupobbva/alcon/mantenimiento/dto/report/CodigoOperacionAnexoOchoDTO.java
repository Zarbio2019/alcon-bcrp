package pe.grupobbva.alcon.mantenimiento.dto.report;

import lombok.Data;


@Data
public class CodigoOperacionAnexoOchoDTO {
	private String numerooperacion;
	private String codigooperacion;
	
	public CodigoOperacionAnexoOchoDTO(String numerooperacion, String codigooperacion) {
		super();
		this.numerooperacion = numerooperacion;
		this.codigooperacion = codigooperacion;
	}

	public CodigoOperacionAnexoOchoDTO() {
		super();
	}

}
