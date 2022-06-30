package pe.grupobbva.alcon.mantenimiento.dto.search;

import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

public class CfgSpeFrairSearch extends QueryDatatable{

	public CfgSpeFrairSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}
	private String subproducto = "";
	private String operacion = "";
	private String divisa = "";
	private String importe = "";
	private String recibo = "";
	private String cuenta = "";
}
