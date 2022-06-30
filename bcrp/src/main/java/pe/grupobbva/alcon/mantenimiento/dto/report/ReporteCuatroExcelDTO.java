package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class ReporteCuatroExcelDTO {
	private String codigo;
	private String rubro;
	private String descripcion;
	private BigDecimal importeactual;
	private BigDecimal importedelta;
	
	public ReporteCuatroExcelDTO(String codigo, String rubro, String descripcion, BigDecimal importeactual,
			BigDecimal importedelta) {
		super();
		this.codigo = codigo;
		this.rubro = rubro;
		this.descripcion = descripcion;
		this.importeactual = importeactual.setScale(2 ,BigDecimal.ROUND_HALF_UP);
		this.importedelta = importedelta.setScale(2 ,BigDecimal.ROUND_HALF_UP);
	}

	public ReporteCuatroExcelDTO() {
		super();
	}

	public List<String> head(){
		List<String> columns = new ArrayList<String>();
		columns.add("Código");
		 columns.add("Rubro");
		 columns.add("Descripción");
		 columns.add("Importe Actual");
		 columns.add("Importe Delta");
		
		return columns;
	}
}
