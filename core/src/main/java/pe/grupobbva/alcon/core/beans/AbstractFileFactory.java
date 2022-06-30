package pe.grupobbva.alcon.core.beans;

import java.io.InputStream;

public abstract class AbstractFileFactory {

	/**
	 * @param fileName
	 * @return
	 */
	public static InputStream getFileFromResource(String fileName) {
		try {
			return Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
		} catch (Exception e) {
			throw new IllegalStateException(
					"Valor incorrecto definido para el campo: valor pero el campo se marcó como requerido.");

		}

	}

}
