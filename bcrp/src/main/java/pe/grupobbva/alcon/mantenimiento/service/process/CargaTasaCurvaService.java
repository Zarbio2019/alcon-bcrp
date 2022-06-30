package pe.grupobbva.alcon.mantenimiento.service.process;

import java.util.List;

import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.TasaCurva;

public interface CargaTasaCurvaService extends CargaProcessService {
	
	public List<Carga> calcularTasasCurvas(Carga carga, List<TasaCurva> tasas);

}
