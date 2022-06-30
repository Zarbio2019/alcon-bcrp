package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ReporteOchoExcelC2DTO {

	private String codigooperacion;
	private String descripcion;
	private BigDecimal monto;
	
	public ReporteOchoExcelC2DTO(ReporteOchoC2DTO dto) {
		super();
		this.codigooperacion = dto.getCodigooperacion();
		this.descripcion = dto.getDescripcion();
		this.monto = dto.getMonto();
	}
	
	public ReporteOchoExcelC2DTO() {
		super();
	}

	public ReporteOchoExcelC2DTO(String codigooperacion, String descripcion, BigDecimal monto) {
		super();
		this.codigooperacion = codigooperacion;
		this.descripcion = descripcion;
		this.monto = monto;
	}
	
	public List<String> headExcel(){
		List<String> columns = new ArrayList<String>();
		 columns.add("Código de Operación");
		 columns.add("Descripción");
		 columns.add("Monto");
		
		return columns;
	}
	
}
