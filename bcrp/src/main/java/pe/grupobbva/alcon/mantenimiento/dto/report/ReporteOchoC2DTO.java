package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;

@Data
public class ReporteOchoC2DTO {

	private String id;
	private String codigooperacion;
	private String descripcion;
	private Calendar fecha;
	private BigDecimal monto;
	private String editar;
	
	public ReporteOchoC2DTO(String id, String codigooperacion, String descripcion,Calendar fecha, BigDecimal monto, String editar) {
		super();
		this.id = id;
		this.codigooperacion = codigooperacion;
		this.descripcion = descripcion;
		this.fecha = fecha;
		this.monto = monto;
		this.editar = editar;
	}


	public ReporteOchoC2DTO() {
		super();
	}
	
	
}
