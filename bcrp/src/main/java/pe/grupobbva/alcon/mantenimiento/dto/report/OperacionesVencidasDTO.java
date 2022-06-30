package pe.grupobbva.alcon.mantenimiento.dto.report;

import lombok.Data;

/**
 * clase DTO para reporte 2
 */
@Data
public class OperacionesVencidasDTO {

	private String producto;
	private String operacion;
	private String codigo;
	private String cliente;
	private String nombre;
	private String tipo;
	private String divisaEntrada;
	private String divisaSalida;
	private String importeEntrada;
	private String importeSalida;
	private String tcSpot;
	private String validacion;
	private String delta;
	private String tasaMN;
	private String tasaME;
	private String importeUSD;
	
}
