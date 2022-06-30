package pe.grupobbva.alcon.mantenimiento.dto.process;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;


@Data
public class OperacionOTFXCargaType extends OperacionCargaType {

	public OperacionOTFXCargaType(Carga carga, Long rownum, String[] cells) {
		super(carga, rownum, cells);
		setProducto("OTFX");
		
		
		
	}

}