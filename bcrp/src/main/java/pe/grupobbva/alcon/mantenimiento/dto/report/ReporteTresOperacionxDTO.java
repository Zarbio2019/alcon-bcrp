package pe.grupobbva.alcon.mantenimiento.dto.report;

import lombok.Data;

@Data
public class ReporteTresOperacionxDTO {

	private Integer cant;
	private String codigoreporte;
	
	public ReporteTresOperacionxDTO(Integer cant, String codigoreporte) {
		super();
		this.cant = cant;
		this.codigoreporte = codigoreporte;
	}
	
	public ReporteTresOperacionxDTO() {
		super();

	}
	
	
}
