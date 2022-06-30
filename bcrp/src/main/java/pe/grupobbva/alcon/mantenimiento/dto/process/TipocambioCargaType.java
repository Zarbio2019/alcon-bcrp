package pe.grupobbva.alcon.mantenimiento.dto.process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;

public @Data class TipocambioCargaType extends AbstractType {

	/**
	 * @param idFilaArchivo
	 * @param tipoProceso
	 */
	public TipocambioCargaType(Carga carga, Long rownum, String row) {

		super();
		
		this.fecha = carga.getFecha();
		this.codigoDivisa = row.substring(1, 4);
		this.importe = (new BigDecimal(row.substring(4, 15))).divide(BigDecimal.valueOf(10000000),7 , RoundingMode.HALF_EVEN).setScale(7, BigDecimal.ROUND_HALF_EVEN);

		this.row = row;
	}

	@Override
	public Boolean validar() {
		return !row.substring(0, 1).equals("1")
				&& (new BigDecimal(row.substring(4, 13)).compareTo(BigDecimal.ZERO) != 0);
	}

	private Calendar fecha;
	private String codigoDivisa;
	private BigDecimal importe;

	private String row;

}
