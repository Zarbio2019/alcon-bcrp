package pe.grupobbva.alcon.core.utils.dto;

import java.util.List;

public class SelectOptions<T> {
	private List<T> data;

	public SelectOptions() {

	}

	/**
	 * @param data
	 */
	
	public SelectOptions(List<T> data) {
		super();
		this.data = data;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
