package pe.grupobbva.alcon.mantenimiento.dto.report;

import lombok.Data;

/**
 * clase DTO para reporte 3
 */
@Data
public class OperacionesCambiariasAnuladasDTO {
	
	private String producto;
	private String operacion;
	private String estado;
	private String codigo;
	private String cliente;
	private String nombre;
	private String tipo;
	private String divisaEntrada;
	private String divisaSalida;
	private String observacion;
	private String importeEntrada;
	private String importeSalida;
	private String tcSpot;
	private String vencimiento;
	private String delta;
	private String tasaMN;
	private String tasaME;
	private String importeUSD;
	
}
