package pe.grupobbva.alcon.mantenimiento.dto.search;

import lombok.Data;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

@Data
public class PosicionCambiariaSearch  extends QueryDatatable{

	public PosicionCambiariaSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}
	private String descripcion;
	private String rubro;
	private String rubropadre;
}
