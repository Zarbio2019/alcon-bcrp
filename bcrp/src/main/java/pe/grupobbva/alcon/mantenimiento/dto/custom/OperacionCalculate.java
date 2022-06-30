package pe.grupobbva.alcon.mantenimiento.dto.custom;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class OperacionCalculate {
	private String tipoOperacion;
	private BigDecimal cambioReferencial;
	private BigDecimal importeEntrada;


	public OperacionCalculate(String tipoOperacion, BigDecimal cambioReferencial, BigDecimal importeEntrada) {
		super();
		this.tipoOperacion = tipoOperacion;
		this.cambioReferencial = cambioReferencial;
		this.importeEntrada = importeEntrada;
	}
	

	public OperacionCalculate() {
		super();
	}

}
