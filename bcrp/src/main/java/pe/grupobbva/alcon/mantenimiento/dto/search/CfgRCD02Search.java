package pe.grupobbva.alcon.mantenimiento.dto.search;

import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

public class CfgRCD02Search extends QueryDatatable{
	public CfgRCD02Search(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}
	private String filainicio="";
	private String filafin="";
	private String divisa ="";
	private String cuenta="";
}
