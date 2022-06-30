package pe.grupobbva.alcon.mantenimiento.dto.search;

import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

public class CfgFxVigenteSearch extends QueryDatatable {
	
	public CfgFxVigenteSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}
	private String subproducto = "";
	private String operacion = "";
	private String fecha_vencimiento = "";
	private String divisa = "";
	private String cuenta = "";
}
