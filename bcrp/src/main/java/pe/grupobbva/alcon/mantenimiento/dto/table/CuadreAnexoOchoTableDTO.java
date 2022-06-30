package pe.grupobbva.alcon.mantenimiento.dto.table;

import lombok.Data;

@Data
public class CuadreAnexoOchoTableDTO {
	private String id;
	private String fuente;
	private String tipooperacion;
	private String montoposicioncambiaria;
	private String montoanexo;
	private String diferencia;
	private String progreso;
	private String descripcion;
	
	public CuadreAnexoOchoTableDTO(String id, String fuente, String tipooperacion, String montoposicioncambiaria,
			String montoanexo, String diferencia, String progreso, String descripcion) {
		super();
		this.id = id;
		this.fuente = fuente;
		this.tipooperacion = tipooperacion;
		this.montoposicioncambiaria = montoposicioncambiaria;
		this.montoanexo = montoanexo;
		this.diferencia = diferencia;
		this.progreso = progreso;
		this.descripcion = descripcion;
	}
	
	public CuadreAnexoOchoTableDTO() {
		super();
	}
	
	
}
