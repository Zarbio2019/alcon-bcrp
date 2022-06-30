package pe.grupobbva.alcon.mantenimiento.dto.search;

import lombok.Data;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

@Data
public class ProductoSearch extends QueryDatatable {

	public ProductoSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}
	
	private String descripcion = "";

}
