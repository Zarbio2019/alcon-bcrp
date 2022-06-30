package pe.grupobbva.alcon.mantenimiento.service.process;

import java.util.List;

import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Tasa;

public interface CargaCalculoTasasService extends CargaProcessService {
	
	public void calcularTasasPredatadas(Carga carga);
	public List<Carga> calcularTasas(Carga carga, List<Tasa> tasas);
	
	public void reprocesar(Carga carga,StringBuilder notaerror);
	
}
