package pe.grupobbva.alcon.core.utils.dto;

import java.util.ArrayList;
import java.util.List;

public class DatatableDTO<T> {
	/**
	 * Pagina actual
	 * 
	 */
	private Long draw;

	/**
	 * Total registros
	 * 
	 */
	private Long recordsTotal;

	/**
	 * Cantidad por pagina
	 * 
	 */
	private Integer recordsFiltered;

	/**
	 * Coleccion de registros
	 * 
	 */

	private List<T> data;

	public DatatableDTO() {

	}

	public DatatableDTO(Long draw) {
		this.draw = draw;
		this.recordsTotal = 0l;
		this.recordsFiltered = 0;
		this.data = new ArrayList<>();
	}

	/**
	 * <h1>Objeto base para crear el paginador de tablas
	 * <h1>
	 * <p>
	 * Objeto para crear las tablas dinamicas
	 * </p>
	 * 
	 * @author Frerly Hinojosa
	 * @see 20/11/2018
	 * 
	 * @param draw            id de consulta
	 * @param recordsTotal    total de registros
	 * @param recordsFiltered registros filtrados
	 * @param data            registros a dibujar
	 */
	public DatatableDTO(Long draw, Long recordsTotal, List<T> data) {
		super();

		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsTotal.intValue();
		this.data = data;
	}

	/**
	 * @return the draw
	 */
	public Long getDraw() {
		return draw;
	}

	/**
	 * @param draw the draw to set
	 */
	public void setDraw(Long draw) {
		this.draw = draw;
	}

	/**
	 * @return the recordsTotal
	 */
	public Long getRecordsTotal() {
		return recordsTotal;
	}

	/**
	 * @param recordsTotal the recordsTotal to set
	 */
	public void setRecordsTotal(Long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	/**
	 * @return the recordsFiltered
	 */
	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}

	/**
	 * @param recordsFiltered the recordsFiltered to set
	 */
	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
	}
}
