package pe.grupobbva.alcon.mantenimiento.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import pe.grupobbva.alcon.mantenimiento.entity.Operacion;
import pe.grupobbva.alcon.mantenimiento.entity.Tasa;

public interface TasaService extends AbstractService<Tasa> {
	
	public List<Tasa> listarTasaFechaMaximaContratacion();
	public List<Tasa> listarTasaFechaContratacion(Calendar fecha);
	public BigDecimal obtenerTasaOperacionInterpolada(BigDecimal plazo, List<Tasa> tasas);
	public BigDecimal obtenerTasaMonedaNacional(BigDecimal plazo, BigDecimal x2, BigDecimal x1, BigDecimal y2, BigDecimal y1);
	public BigDecimal obtenerTasaMonedaExtranjera(Operacion operacion, BigDecimal plazo);
	public BigDecimal obtenerTasaDiferencial(Operacion operacion);
	public void eliminarPorFechaProceso(Tasa tasa);
	public List<Tasa> listarTasaFechaProceso(Calendar fecha);

}
