package pe.grupobbva.alcon.mantenimiento.dto.process;

import java.math.BigDecimal;
import java.text.ParseException;

import lombok.Data;
import pe.grupobbva.alcon.core.beans.TimeFormat;
import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;

@Data
public class OperacionDivaCargaType extends OperacionDerivadoCargaType {

	public OperacionDivaCargaType(Carga carga, Long rownum, String[] cells) throws ParseException {
		super(carga, rownum, cells);
		
		if(getTipoaccion().equalsIgnoreCase("FIXING") 
				|| getTipoaccion().equalsIgnoreCase("REFRESH")
				|| getTipoaccion().toUpperCase().contains("MODIFY USER FIE")) {

			return;
		}

		setProducto("ODIV");

		if (getTiposubyacente().equalsIgnoreCase("INDEX")) {
			this.setTiposubyacente("04");
		} else if (getTiposubyacente().equalsIgnoreCase("BASKET")) {
			this.setTiposubyacente("05");
		} else if (getTiposubyacente().equalsIgnoreCase("EQUITY")) {
			setTiposubyacente("02");
		}

		if (getFechareporte().equals(this.getFechaefectiva())) {
			setTipoaccion("P");
		} else if (Utils.stringtoCalendar(getFechaefectiva(), TimeFormat.DATEFORMAT)
				.compareTo(Utils.stringtoCalendar(getFechareporte(), TimeFormat.DATEFORMAT)) < 0) {
			setTipoaccion("O");
		}

//		if(getTipoaccion().equalsIgnoreCase("NEW TRADE")) {
//			setTipoaccion("P");
//		}else 
			if(getTipoaccion().equalsIgnoreCase("CANCEL")) {
			setTipoaccion("A");
		}else if(getTipoaccion().equalsIgnoreCase("EXPIRY")) {
			setTipoaccion("U");
		}
		
		setImporteusd(new BigDecimal(getImporteusd()).abs().toPlainString());
		setImportedivisa(new BigDecimal(getImportedivisa()).abs().toPlainString());

		if (getCodigocliente().equals("1820002") || getCodigocliente().equals("001820002") || getCodigocliente().equals("BBVAMAD")) {
			setCodigodiva("");
		}

	}

	@Override
	public Boolean validar() {

		return !(getTipoaccion().equalsIgnoreCase("FIXING") 
				|| getTipoaccion().equalsIgnoreCase("REFRESH")
				|| getTipoaccion().toUpperCase().contains("MODIFY USER FIE"));

	}

}