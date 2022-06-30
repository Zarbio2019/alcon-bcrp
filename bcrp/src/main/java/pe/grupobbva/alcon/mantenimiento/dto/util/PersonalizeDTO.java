package pe.grupobbva.alcon.mantenimiento.dto.util;

import java.util.List;

import lombok.Data;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

@Data
public class PersonalizeDTO<K,T>{
	private K primaryData;
	private List<T> secondaryData;
	
	public PersonalizeDTO() {
		super();
	}
	
	/**
	 * @param primaryData
	 * @param decondaryData
	 */
	public PersonalizeDTO(K primaryData, List<T> secondaryData) {
		this.primaryData = primaryData;
		this.secondaryData = secondaryData;
	}

	
}
