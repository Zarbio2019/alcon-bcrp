package pe.grupobbva.alcon.mantenimiento.dto.process;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Signo;

public @Data class SaldoCargaType extends AbstractType {

	private static final String VALORITEM = "04";
	private static final int LONGDIVISOR = 2;
	private static final int LONGCODIGOOFICINA = 6;
	private static final int LONGNROCUENTA = 21;
	private static final int LONGCODIGODIVISA = 24;
	private static final int LONGSALDO = 41;
	private static final int LONGSIGNOSALDO = 42;
	private static final int LONGSALDOMEDIO = 59;
	private static final int LONGSIGNOSALDOMEDIO = 60;
	private static final int LONGENTEROSALDO = 39;
	private static final int LONGDECIMALSALDO = 39;
	private static final int LONGENTEROSALDOMEDIO = 57;
	private static final int LONGDECIMALSALDOMEDIO = 57;

	public SaldoCargaType(Carga carga, Long rownum, String row) {

		super();

		this.row = row;

		if (row.substring(0, LONGDIVISOR).equals(VALORITEM)) {
			
			this.codigoOficina = row.substring(LONGDIVISOR, LONGCODIGOOFICINA);
			this.numerocuenta = Utils.formatearCuenta(row.substring(LONGCODIGOOFICINA, LONGNROCUENTA));
			this.codigoDivisa = row.substring(LONGNROCUENTA, LONGCODIGODIVISA);

			if (!row.substring(LONGCODIGODIVISA, LONGSALDO).isEmpty()) {
				this.saldo = new BigDecimal(row.substring(LONGCODIGODIVISA, LONGENTEROSALDO).concat(".")
						.concat(row.substring(LONGDECIMALSALDO, LONGSALDO)));
			} else {
				this.saldo = BigDecimal.ZERO;
			}

			this.signosaldo = row.substring(LONGSALDO, LONGSIGNOSALDO).equals("1") ? Signo.POSITIVO : Signo.NEGATIVO;

			if (!row.substring(LONGSIGNOSALDO, LONGSALDOMEDIO).isEmpty()) {
				this.saldomedio = new BigDecimal(row.substring(LONGSIGNOSALDO, LONGENTEROSALDOMEDIO).concat(".")
						.concat(row.substring(LONGDECIMALSALDOMEDIO, LONGSALDOMEDIO)));
			} else {
				this.saldomedio = BigDecimal.ZERO;
			}

			this.signosaldomedio = row.substring(LONGSALDOMEDIO, LONGSIGNOSALDOMEDIO).equals("1") ? Signo.POSITIVO : Signo.NEGATIVO;
			this.fechaproceso = carga.getFecha();
			this.numerolinea = rownum.intValue();
			
		}
	}

	@Override
	public Boolean validar() {
		return row.substring(0, LONGDIVISOR).equals(VALORITEM);
	}

	private String row;

	private String codigoOficina;
	private String numerocuenta;
	private String codigoDivisa;
	private BigDecimal saldo;
	private Signo signosaldo;
	private BigDecimal saldomedio;
	private Signo signosaldomedio;
	private Calendar fechaproceso;
	private Integer numerolinea;

}
