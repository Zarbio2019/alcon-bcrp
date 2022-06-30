package pe.grupobbva.alcon.mantenimiento.dto.search;

import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

public class CfgPosRFSearch extends QueryDatatable{
	public CfgPosRFSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}
	private String cartera ="";
	private String clase ="";
	private String divisa = "";	
	private String cuenta = "";
	private String importe = "";
}
