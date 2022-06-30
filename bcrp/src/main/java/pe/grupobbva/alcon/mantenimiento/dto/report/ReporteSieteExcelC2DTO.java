package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lombok.Data;

@Data
public class ReporteSieteExcelC2DTO {
	private String productodescripcion;
	private String numerooperacion;
	private String codigoreporte;
	private String clientecodigo;
	private String clientenombre;
	private String tipooperaciondescripcion;
	private String divisadescripcion;
	private BigDecimal importedivisa;
	private BigDecimal volatilidad;
	private BigDecimal prima;
	private BigDecimal delta;
	private String intencioncontratacion;
	private Calendar fechatermino;
	private String tipoaccion;
	private BigDecimal importeusd = new BigDecimal(0);

	public ReporteSieteExcelC2DTO(ReporteSieteC2DTO dto) {
		super();
		this.productodescripcion = dto.getProductodescripcion();
		this.numerooperacion = dto.getNumerooperacion();
		this.codigoreporte = dto.getCodigoreporte();
		this.clientecodigo = dto.getClientecodigo();
		this.clientenombre = dto.getClientenombre();
		this.tipooperaciondescripcion = dto.getTipooperaciondescripcion();
		this.divisadescripcion = dto.getDivisadescripcion();
		this.importedivisa = dto.getImportedivisa();
		this.volatilidad = dto.getVolatilidad();
		this.prima = dto.getPrima();
		this.delta = dto.getDelta();
		this.intencioncontratacion = dto.getIntencioncontratacion();
		this.fechatermino = dto.getFechatermino();
		this.tipoaccion = dto.getTipoaccion();
		this.importeusd = dto.getImporteusd();
	}

	public ReporteSieteExcelC2DTO() {
		super();
	}

	public ReporteSieteExcelC2DTO(String productodescripcion, String numerooperacion, String codigoreporte,
			String clientecodigo, String clientenombre, String tipooperaciondescripcion,
			String divisadescripcion, BigDecimal importedivisa,
			 BigDecimal volatilidad, BigDecimal prima, BigDecimal delta,
			 String intencioncontratacion, Calendar fechatermino, String tipoaccion, BigDecimal importeusd) {
		super();
		this.productodescripcion = productodescripcion;
		this.numerooperacion = numerooperacion;
		this.codigoreporte = codigoreporte;
		this.clientecodigo = clientecodigo;
		this.clientenombre = clientenombre;
		this.tipooperaciondescripcion = tipooperaciondescripcion;
		this.divisadescripcion = divisadescripcion;
		this.importedivisa = importedivisa;
		this.volatilidad = volatilidad;
		this.prima = prima;
		this.delta = delta;
		this.intencioncontratacion = intencioncontratacion;
		this.fechatermino = fechatermino;
		this.tipoaccion = tipoaccion;
		this.importeusd = importeusd;
	}

	public List<String> headExcel() {
		List<String> columns = new ArrayList<String>();
		columns.add("Producto");
		columns.add("Operación");
		columns.add("Código Reporte");
		columns.add("Cliente");
		columns.add("Nombre");
		columns.add("Tipo");
		columns.add("Divisa");
		columns.add("Imp. Divisa");
		columns.add("Volatilidad");
		columns.add("Prima");
		columns.add("Delta");
		columns.add("Intenc. Contrat.");
		columns.add("Fecha Termino");
		columns.add("Tip. Acción");
		columns.add("Importe USD");

		return columns;
	}
}

