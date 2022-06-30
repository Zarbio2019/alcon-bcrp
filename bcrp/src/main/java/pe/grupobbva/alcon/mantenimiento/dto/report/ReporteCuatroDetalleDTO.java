package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lombok.Data;

@Data
public class ReporteCuatroDetalleDTO {
	private String producto;
	private String numerooperacion;
	private String codigoreporte;
	private String cliente;
    private String nombre;
    private String tipo;
    private String diventrada;
    private String divsalida;
    private BigDecimal impentrada;
    private BigDecimal impsalida;
    private BigDecimal tipocambio;
    private String validacion;
    private String contratacion;
    private String valor;
    private String vencimiento;
    private BigDecimal importeusd =  BigDecimal.ZERO;
    private String tipocliente;
    


	public ReporteCuatroDetalleDTO() {
		super();
	}



	
	
	public List<String> headExcel(){
		List<String> columns = new ArrayList<String>();
		 columns.add("Producto");
		 columns.add("Operación");
		 columns.add("Código Reporte");
		 columns.add("Cliente");
		 columns.add("Nombre");
		 columns.add("Tipo");
		 columns.add("Div. Entrada");
		 columns.add("Div. Salida");
		 columns.add("Imp. Entrada");
		 columns.add("Imp. Salida");
		 columns.add("Tipo Cambio");
		 columns.add("Validación");
		 columns.add("Contratación");
		 columns.add("Valor");
		 columns.add("Vencimiento");
		 columns.add("Importe USD");
		 columns.add("Tipo Cliente");
		
		return columns;
	}





	public ReporteCuatroDetalleDTO(String producto, String numerooperacion, String codigoreporte, String cliente,
			String nombre, String tipo, String diventrada, String divsalida, BigDecimal impentrada, BigDecimal impsalida,
			BigDecimal tipocambio, String validacion, String contratacion, String valor, String vencimiento,
			BigDecimal importeusd, String tipocliente) {
		super();
		this.producto = producto;
		this.numerooperacion = numerooperacion;
		this.codigoreporte = codigoreporte;
		this.cliente = cliente;
		this.nombre = nombre;
		this.tipo = tipo;
		this.diventrada = diventrada;
		this.divsalida = divsalida;
		this.impentrada = impentrada;
		this.impsalida = impsalida;
		this.tipocambio = tipocambio;
		this.validacion = validacion;
		this.contratacion = contratacion;
		this.valor = valor;
		this.vencimiento = vencimiento;
		this.importeusd = importeusd;
		this.tipocliente = tipocliente;
	}



}
