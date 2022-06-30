package pe.grupobbva.alcon.mantenimiento.dto.report;

import lombok.Data;

/**
 * clase DTO para vista previa reporte 4
 */
@Data
public class OperacionesPrevias {

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
	private String tipoCambio;
	private String validacion;
	private String contratacion;
	private String valor;
	private String vencimiento;
	private String importeUSD;
	private String tipoCliente;
	
}
