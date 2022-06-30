package pe.grupobbva.alcon.mantenimiento.dto.custom.response;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OperacionCalculateResponse {

	private BigDecimal importeSalida;
	private BigDecimal importeDolares;
	
	public OperacionCalculateResponse(BigDecimal importeSalida, BigDecimal importeDolares) {
		super();
		this.importeSalida = importeSalida;
		this.importeDolares = importeDolares;
	}

	public OperacionCalculateResponse() {
		super();
	}
	
	
}
