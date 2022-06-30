package pe.grupobbva.alcon.mantenimiento.service.process.util;

import pe.grupobbva.alcon.mantenimiento.dto.process.AbstractType;

public class BcrpReaderBuilder<T extends AbstractType> extends GenericReader<T> {

	public BcrpReaderBuilder(Class<T> aClass) {
		super(aClass);
	}

	public static <T extends AbstractType> BcrpReaderBuilder<T> create(final Class<T> aClass) {
		return new BcrpReaderBuilder<>(aClass);
	}

}
