package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ReporteOchoAnexo8DTO {

	private String producto;
	private String numerooperacion;
	private String codigoreporte;
	private String cliente;
    private String nombre;
    private String tipodocumento;
    private String tipocliente;
    private String validacion;
    private String contratacion;
    private String vencimiento;
    private BigDecimal importeusd =  BigDecimal.ZERO;
    private String estado;


	public ReporteOchoAnexo8DTO() {
		super();
	}



	
	
	public List<String> headExcel(){
		List<String> columns = new ArrayList<String>();
		 columns.add("Producto");
		 columns.add("Operación");
		 columns.add("Código Reporte");
		 columns.add("Cliente");
		 columns.add("Nombre");
		 columns.add("Tipo documento");
		 columns.add("Tipo cliente");
		 columns.add("Validación");
		 columns.add("Contratación");
		 columns.add("Vencimiento");
		 columns.add("Importe USD");
		 columns.add("estado");
		
		return columns;
	}

	public ReporteOchoAnexo8DTO(String producto, String numerooperacion, String codigoreporte, String cliente,
			String nombre, String tipodocumento, String tipocliente, String validacion, String contratacion,
			String vencimiento, BigDecimal importeusd, String estado) {
		super();
		this.producto = producto;
		this.numerooperacion = numerooperacion;
		this.codigoreporte = codigoreporte;
		this.cliente = cliente;
		this.nombre = nombre;
		this.tipodocumento = tipodocumento;
		this.tipocliente = tipocliente;
		this.validacion = validacion;
		this.contratacion = contratacion;
		this.vencimiento = vencimiento;
		this.importeusd = importeusd;
		this.estado = estado;
	}

}
