package pe.grupobbva.alcon.mantenimiento.dto.search;

import lombok.Data;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

@Data
public class ClienteSearch extends QueryDatatable{

	public ClienteSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}
	
	private String nombre="";
	
	private String tipocliente="";
	
	private String codigo="";
	
	private String clienteregistrado="";
	
	
	
}
