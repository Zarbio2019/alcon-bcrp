package pe.grupobbva.alcon.mantenimiento.dto.search;

import lombok.Data;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

@Data
public class CierreDiarioSearch extends QueryDatatable {

	public CierreDiarioSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}
	
	private Integer anio;
	private Integer mes;

}
