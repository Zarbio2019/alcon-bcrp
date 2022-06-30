package pe.grupobbva.alcon.core.utils.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryDatatable {
	
	public QueryDatatable() {
		super();
		
		this.order= new ArrayList<>();
		Map<OrderCriterias,String> order1= new HashMap<>();
		order1.put(OrderCriterias.name, "id");
		order1.put(OrderCriterias.dir, "asc");
		order.add(order1);
	}
	
	
	public QueryDatatable(Long draw, Integer start, Integer length) {
		super();
		this.draw = draw;
		this.start = start;
		this.length = length;

		this.order= new ArrayList<>();
		Map<OrderCriterias,String> order1= new HashMap<>();
		order1.put(OrderCriterias.name, "id");
		order1.put(OrderCriterias.dir, "asc");
		order.add(order1);
	}

	/**
	 * Registro de consulta
	 */
	protected Long draw;

	/**
	 * Pagina que se desea mostrar
	 */
	protected Integer start;

	/**
	 * Tamanho de la pagina
	 */
	protected Integer length;

	/**
	 * Campos de busqueda
	 * 
	 */
	//private Map<SearchCriterias, String> search;
	/**
	 * Columnas a mostrar
	 * 
	 */
	//private List<Map<ColumnCriterias, String>> columns;

	/**
	 * Orden de los datos
	 * 
	 */
	private List<Map<OrderCriterias, String>> order;


	

	public Long getDraw() {
		return draw;
	}

	public void setDraw(Long draw) {
		this.draw = draw;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public List<Map<OrderCriterias, String>> getOrder() {
		return order;
	}

	public void setOrder(List<Map<OrderCriterias, String>> order) {
		this.order = order;
	}

	public enum SearchCriterias {
		value, regex;
	}

	public enum OrderCriterias {
		column, dir, name;
	}

	public enum ColumnCriterias {
		data, name, searchable, orderable, searchValue, searchRegex, searchName;
	}
	
}
