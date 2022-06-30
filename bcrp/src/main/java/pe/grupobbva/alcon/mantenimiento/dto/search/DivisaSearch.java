package pe.grupobbva.alcon.mantenimiento.dto.search;

import lombok.Data;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

@Data
public class DivisaSearch extends QueryDatatable {

	public DivisaSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}

	private String descripcion;
	
}
