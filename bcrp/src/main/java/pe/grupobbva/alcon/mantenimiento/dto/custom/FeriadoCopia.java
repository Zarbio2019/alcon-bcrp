package pe.grupobbva.alcon.mantenimiento.dto.custom;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.entity.AbstractEntity;

@Data
public class FeriadoCopia extends AbstractEntity {
	private String tipo;
	private Integer anio;
//	private String usuario;

	public FeriadoCopia(String tipo, Integer anio/*, String usuario*/) {
		super();
		this.tipo = tipo;
		this.anio = anio;
//		this.usuario = usuario;
	}
	
	public FeriadoCopia() {
		super();
	}
}
