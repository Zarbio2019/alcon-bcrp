package pe.grupobbva.alcon.mantenimiento.dto.process;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;

public @Data class SaldoContableCargaType extends AbstractType {

	public SaldoContableCargaType(Carga carga, Long rownum, String row) {

		super();
		
		this.fecha = carga.getFecha();
		this.codigoOficina = row.substring(1, 5);
		this.codigoDivisa = row.substring(5, 8);
		this.importe = (new BigDecimal(row.substring(8, 26))).divide(BigDecimal.valueOf(100));

		this.row = row;
	}

	@Override
	public Boolean validar() {
		return row.substring(0, 1).equals("1");
	}

	private Calendar fecha;
	private String codigoOficina;
	private String codigoDivisa;
	private BigDecimal importe;
	private String row;

}
