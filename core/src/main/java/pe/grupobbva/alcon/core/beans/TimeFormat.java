package pe.grupobbva.alcon.core.beans;

public enum TimeFormat {

	DATEFORMAT("dd/MM/yyyy"),
	DATEFORMAT2("yyyy-MM-dd"),
	DATEFORMAT3("yyyyMMdd"),
	TIMESTAMPFORMAT("dd/MM/yyyy HH:mm:ss"),
	TIMEFORMAT("HH:mm:ss");
	
	private String format;
	
	private TimeFormat(String format) {
		this.format=format;
	}
	
	public String getFormat() {
		return format;
	}
}
