package pe.grupobbva.alcon.mantenimiento.dto.search;

import java.util.Date;

import lombok.Data;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

@Data
public class OperacionInternaSearch extends QueryDatatable {

	public OperacionInternaSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}

	private Date fechacontratacion = new Date();

}
