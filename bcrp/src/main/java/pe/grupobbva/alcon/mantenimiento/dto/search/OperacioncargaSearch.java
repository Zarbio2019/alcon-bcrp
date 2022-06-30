package pe.grupobbva.alcon.mantenimiento.dto.search;

import lombok.Data;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

@Data
public class OperacioncargaSearch extends QueryDatatable {

	public OperacioncargaSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}

	private String id = "";

}
