package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class BooleanConverter implements AttributeConverter<Boolean, String> {

	@Override
	public String convertToDatabaseColumn(Boolean field) {
		return field ? "1" : "0";
	}

	@Override
	public Boolean convertToEntityAttribute(String field) {
		if (field.equals("1"))
			return true;
		else
			return false;

	}

}
