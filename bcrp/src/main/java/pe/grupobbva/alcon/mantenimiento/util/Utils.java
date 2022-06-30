package pe.grupobbva.alcon.mantenimiento.util;

import pe.grupobbva.alcon.mantenimiento.entity.Operacion;
import pe.grupobbva.alcon.mantenimiento.entity.TipoProceso;

public class Utils {

	public static Boolean validarOperacionUnwindAnular(Operacion operacion) {
		Boolean valor = false;
		
		if (operacion.getEstado().equals("L") && operacion.getTipoproceso().equals(TipoProceso.D.name())
				&& (operacion.getFechamovimiento().before(operacion.getFechavencimiento())
						|| (operacion.getFechamovimiento().compareTo(operacion.getFechavencimiento()) == 0))

		) {
			valor = true;
		}else if (operacion.getEstado().equals("L") && operacion.getTipoproceso().equals(TipoProceso.A.name())
				&& (operacion.getFechamovimiento().before(operacion.getFechavencimiento())
						|| (operacion.getFechamovimiento().compareTo(operacion.getFechavencimiento()) == 0))

		) {
			valor = true;
		}
		
		return valor;
	}
	

}
