package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lombok.Data;

@Data
public class ReporteTresExcelC2DTO {

	private String productodescripcion;
	private String numerooperacion; 
	private String estado;
	private String codigoreporte;
	private String clientecodigo;
	private String clientenombre;
	private String tipooperaciondescripcion;
	private String divisaentradadescripcion;
	private String divisasalidadescripcion;
	private String observaciones;
	private BigDecimal importedivisaentrada;
	private BigDecimal importedivisasalida;
	private BigDecimal tipocambiospot;
	private Calendar fechavencimiento; 
	private BigDecimal delta; 
	private BigDecimal tasamonedanacional; 
	private BigDecimal tasamonedaextranjera;
	private BigDecimal recibetasafijaspread;
	private BigDecimal pagatasafijaspread;
	private BigDecimal importeusd = new BigDecimal(0);
	
	public ReporteTresExcelC2DTO(ReporteTresC2DTO dto) {
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
		this.fechavencimiento = dto.getFechavencimiento();
		this.delta = dto.getDelta();
		this.tasamonedanacional = dto.getTasamonedanacional();
		this.tasamonedaextranjera = dto.getTasamonedaextranjera();
		this.recibetasafijaspread = dto.getRecibetasafijaspread();
		this.pagatasafijaspread = dto.getPagatasafijaspread();
		this.importeusd = dto.getImporteusd();
	}
	
	public ReporteTresExcelC2DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReporteTresExcelC2DTO(String productodescripcion, String numerooperacion, String estado, String codigoreporte,
			String clientecodigo, String clientenombre, String tipooperaciondescripcion,
			String divisaentradadescripcion, String divisasalidadescripcion, String observaciones,
			BigDecimal importedivisaentrada, BigDecimal importedivisasalida, BigDecimal tipocambiospot,
			Calendar fechavencimiento, BigDecimal delta, BigDecimal tasamonedanacional, BigDecimal tasamonedaextranjera,
		    BigDecimal recibetasafijaspread, BigDecimal pagatasafijaspread, BigDecimal importeusd) {
		super();
		this.productodescripcion = productodescripcion;
		this.numerooperacion = numerooperacion;
		this.estado = estado;
		this.codigoreporte = codigoreporte;
		this.clientecodigo = clientecodigo;
		this.clientenombre = clientenombre;
		this.tipooperaciondescripcion = tipooperaciondescripcion;
		this.divisaentradadescripcion = divisaentradadescripcion;
		this.divisasalidadescripcion = divisasalidadescripcion;
		this.observaciones = observaciones;
		this.importedivisaentrada = importedivisaentrada;
		this.importedivisasalida = importedivisasalida;
		this.tipocambiospot = tipocambiospot;
		this.fechavencimiento = fechavencimiento;
		this.delta = delta;
		this.tasamonedanacional = tasamonedanacional;
		this.tasamonedaextranjera = tasamonedaextranjera;
		this.recibetasafijaspread = recibetasafijaspread;
		this.pagatasafijaspread = pagatasafijaspread;
		this.importeusd = importeusd;
	}
	
	
	public List<String> headExcel(){
		List<String> columns = new ArrayList<String>();
		 columns.add("Producto");
		 columns.add("Operación");
		 columns.add("Estado");
		 columns.add("Código Reporte");
		 columns.add("Cliente");
		 columns.add("Nombre");
		 columns.add("Tipo");
		 columns.add("Div. Entrada");
		 columns.add("Div. Salida");
		 columns.add("Observación");
		 columns.add("Imp. Entrada");
		 columns.add("Imp. Salida");
		 columns.add("TC Spot");
		 columns.add("Vencimiento");
		 columns.add("Delta");
		 columns.add("Tasa MN");
		 columns.add("Tasa ME");
		 columns.add("Rec. tFija spread");
		 columns.add("Paga tfija spread");
		 columns.add("Importe USD");
		
		return columns;
	}
	
}
