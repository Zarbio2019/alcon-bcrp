package pe.grupobbva.alcon.mantenimiento.dto.process;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;

public @Data class TasaCurvaCargaType extends AbstractType {
	
	public TasaCurvaCargaType(Carga carga, Long rownum, String row) {
		super();

		this.row = row;

		this.fechaproceso = carga.getFecha();
		this.fecha = row.substring(0, 8).trim();
		this.curva = row.substring(8, 12).trim();
		this.codigoCurvaDivisa = row.substring(12, 15).trim();
		this.tenor = row.substring(15, 18).trim();
		this.tasa1 = (new BigDecimal(row.substring(18, 34).trim())).divide(BigDecimal.valueOf(1000000));
		this.tasa2 = (new BigDecimal(row.substring(34, 50).trim())).divide(BigDecimal.valueOf(1000000));
		this.tasa3 = (new BigDecimal(row.substring(50, 66).trim())).divide(BigDecimal.valueOf(1000000));
		this.datofijo1 = row.substring(66, 74).trim();
		this.fechainicio = row.substring(74, 82).trim();
		this.datofijo2 = row.substring(82, 88).trim();
		this.fechafin = row.substring(88, 96).trim();

	}

	private String row;

	private Calendar fechaproceso;
	private String fecha;
	private String curva;
	private String codigoCurvaDivisa;
	private String tenor;
	private BigDecimal tasa1;
	private BigDecimal tasa2;
	private BigDecimal tasa3;
	private String datofijo1;
	private String fechainicio;
	private String datofijo2;
	private String fechafin;
	
}
