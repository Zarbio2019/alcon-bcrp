package pe.grupobbva.alcon.mantenimiento.dto.process;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;

public @Data class CodigoStarAltamiraCargaType extends AbstractType {

	public CodigoStarAltamiraCargaType(Carga carga, Long rownum, String[] row) {
		super();

		String[] cells = row[0].split(";", -1);
		this.codigo = cells[0].trim();
		this.altamira = cells[1].trim();

	}
	
	private String codigo;
	private String altamira;
	
}
