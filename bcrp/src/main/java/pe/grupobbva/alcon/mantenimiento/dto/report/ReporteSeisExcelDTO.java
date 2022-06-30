package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class ReporteSeisExcelDTO {

	private String numerooperacion;
	private String codigoreporte;
	private String tipooperacion;
	private String descripcion;
	private String tipoproceso;
	private BigDecimal importeusd = new BigDecimal(0);
	private String deltad;
	private BigDecimal importedelta;
	private String estado;
	 
	public ReporteSeisExcelDTO(ReporteSeisDTO dto) {
		this.numerooperacion = dto.getNumerooperacion();
		this.codigoreporte = dto.getCodigoreporte();
		this.tipooperacion = dto.getTipooperacion();
		this.descripcion = dto.getClientenombre();
		this.tipoproceso = dto.getTipoproceso();
		this.importeusd = dto.getImporteusd();
		this.deltad = dto.getDeltad()==null?"":dto.getDeltad().toString();;
		this.importedelta = dto.getImportedelta();
		this.estado = dto.getEstado();
	}
	
	public List<String> headerExcel(){
		List<String> columns = new ArrayList<String>();
		 columns.add("Operación");
		 columns.add("Código Reporte");
		 columns.add("Tipo Operación");
		 columns.add("Contrapartida");
		 columns.add("Tipo Proceso");
		 columns.add("Importe USD");
		 columns.add("Delta");
		 columns.add("Importe Delta");
		 columns.add("Estado");
		
		return columns;
	}




	public ReporteSeisExcelDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
