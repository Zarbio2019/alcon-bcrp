package pe.grupobbva.alcon.mantenimiento.dto.search;

import lombok.Data;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

@Data
public class FeriadoSearch extends QueryDatatable {

	public FeriadoSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}
	
	private Integer anio = 0;
	private Integer mes = 0;
	private String tipo = "";

}
