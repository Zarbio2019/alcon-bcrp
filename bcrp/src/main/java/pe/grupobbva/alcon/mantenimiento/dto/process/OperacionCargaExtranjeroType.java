package pe.grupobbva.alcon.mantenimiento.dto.process;

import java.math.BigDecimal;

import pe.grupobbva.alcon.core.beans.TimeFormat;
import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;


/**
 * @author P027968
 *
 */
public class OperacionCargaExtranjeroType extends OperacionCargaType {
	
	public OperacionCargaExtranjeroType(Carga carga, Long rownum, String row) {
		super(carga,rownum,row.split(";", -1));
		setImportedivisaentrada(new BigDecimal(getImportedivisaentrada()).toPlainString());
		setImportedivisasalida(new BigDecimal(getImportedivisasalida()).toPlainString());
		this.setCodigocliente("00000000");
		this.setNombrecliente("Extranjero");
		this.setProducto("FXC");
		this.setPlaza("LIMA");
		this.setPaisresidencia("PERU");
		this.setPaisriesgo("PERU");
		this.setFechacontratacion( Utils.calendartoString(carga.getFecha(), TimeFormat.DATEFORMAT2));
		setEstado("L");
		
	}

	@Override
	public Boolean validar() {
		if(getEstado()!=null 
				&& (getEstado().toUpperCase().trim().equals("L")
				|| getEstado().toUpperCase().trim().equals("M")
				|| getEstado().toUpperCase().trim().equals("A")
				|| getEstado().toUpperCase().trim().equals("U")
				| getEstado().toUpperCase().trim().equals("R"))
				) {
			return true;
		}
		
		return false;
	}
	
	
	@Override
		public void merge(AbstractType row) {
		OperacionCargaExtranjeroType rowM  = (OperacionCargaExtranjeroType)row;
		setImportedivisaentrada((new BigDecimal(getImportedivisaentrada())).add(new BigDecimal(rowM.getImportedivisaentrada())).toPlainString());
		setImportedivisasalida((new BigDecimal(getImportedivisasalida())).add(new BigDecimal(rowM.getImportedivisasalida())).toPlainString());
		
	}
	
	
	@Override
	public Boolean agrupar() {
		return true;
	}

	
	@Override
	public void loadKey() {
		this.setKey(this.getTipooperacion()+"-"+this.getDivisaentrada()+"-"+this.getDivisasalida());
	}

}
