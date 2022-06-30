package pe.grupobbva.alcon.mantenimiento.dto.process;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;


@Data
public class OperacionTasasMXCargaType extends OperacionCargaType {

	String PRODUCTOIRDCS = "IRD  CS";
	String PRODUCTOIRDIRS = "IRD  IRS";
	String PRODUCTOIRC = "IRC";
	String PRODUCTOIRD = "IRD";
	String PRODUCTOIRCNF = "IRCNF";
	String COD_BBVA = "1820001";
	String COD_BCRP = "2CRPLIA";
	String BBVA = "BBVA";
	String BCRP = "BANCO CENTRAL DE RESERVA DEL PERU";

	public OperacionTasasMXCargaType(Carga carga, Long rownum, String[] cells) {
		super(carga, rownum, cells);	

		/*Condiciones para considerar los tipos de productos que trabaja MUREX a la nomenclatura de BCRP*/
		if (this.getProducto().equalsIgnoreCase(PRODUCTOIRDCS)) {
			
			if (this.getCodigocliente().contains(COD_BBVA)||this.getCodigocliente().contains(COD_BCRP)||this.getNombrecliente().contains(BBVA)||this.getNombrecliente().equalsIgnoreCase(BCRP)) {
				this.setProducto(PRODUCTOIRCNF);
			}else {
				this.setProducto(PRODUCTOIRC);
			}
		} else {
			if (this.getProducto().equalsIgnoreCase(PRODUCTOIRDIRS)) {
				this.setProducto(PRODUCTOIRD);
			}
		}
			
	}

}