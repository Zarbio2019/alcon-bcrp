package pe.grupobbva.alcon.mantenimiento.dto.process;

public enum TipoArchivo {

	XLS("xls"),
	XLSX("xlsx"),
	CSV("csv");
	
	
	/**
	 * @param mime
	 */
	private TipoArchivo(String extension) {
		this.extension = extension;
	}

	
	private String extension;

	public String getExtension() {
		return extension;
	}


	
	
	
	
	
}
