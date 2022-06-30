package pe.grupobbva.alcon.mantenimiento.dto.util;

public class SelectOptionsDTO {

	private String value;
	private String detail;
	/**
	 * @param value
	 * @param detail
	 */
	public SelectOptionsDTO(String value, String detail) {
		super();
		this.value = value;
		this.detail = detail;
	}
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	
	
}
