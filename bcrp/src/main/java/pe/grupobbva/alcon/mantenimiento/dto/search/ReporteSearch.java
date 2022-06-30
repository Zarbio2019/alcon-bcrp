package pe.grupobbva.alcon.mantenimiento.dto.search;

import java.util.Date;

import lombok.Data;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

@Data
public class ReporteSearch  extends QueryDatatable{
	
	public ReporteSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}

	private Date fecha = new Date();
	private String tipoproceso;
	private String producto;
	private String divisa;
	
	/*public Date previusDateDefault() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(calendar.DAY_OF_WEEK, -1);
		return calendar.getTime();
	}*/
}
