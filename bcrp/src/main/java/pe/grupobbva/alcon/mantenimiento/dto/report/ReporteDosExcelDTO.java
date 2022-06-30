package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ReporteDosExcelDTO {

	private String productodescripcion;
	private String numerooperacion; 
	private String codigoreporte;
	private String clientecodigo;
	private String clientenombre;
	private String tipooperaciondescripcion;
	private String divisaentradadescripcion;
	private String divisasalidadescripcion;
	private BigDecimal importedivisaentrada;
	private BigDecimal importedivisasalida;
	private BigDecimal tipocambiospot;
	private String validacion; 
	private BigDecimal delta; 
	private BigDecimal tasamonedanacional; 
	private BigDecimal tasamonedaextranjera;
	private BigDecimal importeusd= new BigDecimal(0);
	
	public ReporteDosExcelDTO(ReporteDosDTO dto) {
		super();
		this.productodescripcion = dto.getProductodescripcion();
		this.numerooperacion = dto.getNumerooperacion();
		this.codigoreporte = dto.getCodigoreporte();
		this.clientecodigo = dto.getClientecodigo();
		this.clientenombre = dto.getClientenombre();
		this.tipooperaciondescripcion = dto.getTipooperaciondescripcion();
		this.divisaentradadescripcion = dto.getDivisaentradadescripcion();
		this.divisasalidadescripcion = dto.getDivisasalidadescripcion();
		this.importedivisaentrada = dto.getImportedivisaentrada();
		this.importedivisasalida = dto.getImportedivisasalida();
		this.tipocambiospot = dto.getTipocambiospot();
		this.validacion = dto.getValidacion();
		this.delta = dto.getDelta();
		this.tasamonedanacional = dto.getTasamonedanacional();
		this.tasamonedaextranjera = dto.getTasamonedaextranjera();
		this.importeusd = dto.getImporteusd();
	}
	
	public ReporteDosExcelDTO() {
		super();
	}

	
	public ReporteDosExcelDTO(String productodescripcion, String numerooperacion, String codigoreporte,
			String clientecodigo, String clientenombre, String tipooperaciondescripcion,
			String divisaentradadescripcion, String divisasalidadescripcion, BigDecimal importedivisaentrada,
			BigDecimal importedivisasalida, BigDecimal tipocambiospot, String validacion, BigDecimal delta,
			BigDecimal tasamonedanacional, BigDecimal tasamonedaextranjera, BigDecimal importeusd) {
		super();
		this.productodescripcion = productodescripcion;
		this.numerooperacion = numerooperacion;
		this.codigoreporte = codigoreporte;
		this.clientecodigo = clientecodigo;
		this.clientenombre = clientenombre;
		this.tipooperaciondescripcion = tipooperaciondescripcion;
		this.divisaentradadescripcion = divisaentradadescripcion;
		this.divisasalidadescripcion = divisasalidadescripcion;
		this.importedivisaentrada = importedivisaentrada;
		this.importedivisasalida = importedivisasalida;
		this.tipocambiospot = tipocambiospot;
		this.validacion = validacion;
		this.delta = delta;
		this.tasamonedanacional = tasamonedanacional;
		this.tasamonedaextranjera = tasamonedaextranjera;
		this.importeusd = importeusd;
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
		 columns.add("TC Spot");
		 columns.add("Validación");
		 columns.add("Delta");
		 columns.add("Tasa MN");
		 columns.add("Tasa ME");
		 columns.add("Importe USD");
		
		return columns;
	}
	
}
