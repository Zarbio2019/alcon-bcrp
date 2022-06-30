package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;

@Data
public class ReporteSeisUpdateDeltaDTO {
	private String id;
	private String numerooperacion;
	private Calendar fechaproceso;
	private BigDecimal deltas;
	private String descripcion;
	private BigDecimal cobertura;
	private String estado;
	public ReporteSeisUpdateDeltaDTO(String id, String numerooperacion, Calendar fechaproceso, BigDecimal deltas,
			String descripcion, BigDecimal cobertura, String estado) {
		super();
		this.id = id;
		this.numerooperacion = numerooperacion;
		this.fechaproceso = fechaproceso;
		this.deltas = deltas;
		this.descripcion = descripcion;
		this.cobertura = cobertura;
		this.estado = estado;
	}
	public ReporteSeisUpdateDeltaDTO() {
		super();
	}
}
