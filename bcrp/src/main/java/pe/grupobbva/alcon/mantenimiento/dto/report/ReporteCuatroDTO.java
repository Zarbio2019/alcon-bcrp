package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;

@Data
public class ReporteCuatroDTO {
	private String id;
	private Calendar fecha;
	private String tipoproceso;
	private String codigocompuesto;
	private String idposicioncambiaria;
	private String codigo;
	private String rubro;
	private String descripcion;
	private BigDecimal importeactual;
	private BigDecimal importedelta;
	private String editar;
	private String detalle;
	
	public ReporteCuatroDTO(String id, Calendar fecha, String tipoproceso, String codigocompuesto,
			String idposicioncambiaria, String codigo, String rubro, String descripcion, BigDecimal importeactual,
			BigDecimal importedelta, String editar, String detalle) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.tipoproceso = tipoproceso;
		this.codigocompuesto = codigocompuesto;
		this.idposicioncambiaria = idposicioncambiaria;
		this.codigo = codigo;
		this.rubro = rubro;
		this.descripcion = descripcion;
		this.importeactual = importeactual;
		this.importedelta = importedelta;
		this.editar = editar;
		this.detalle = detalle;
	}

	public ReporteCuatroDTO() {
		super();
	}
	
}
