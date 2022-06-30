package pe.grupobbva.alcon.mantenimiento.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import pe.grupobbva.alcon.mantenimiento.entity.TasaCurva;

public interface TasaCurvaService extends AbstractService<TasaCurva> {
	
	public BigDecimal obtenerTasaOperacionInterpolada(BigDecimal plazo, String iddivisa, List<TasaCurva> tasas);
	public BigDecimal obtenerTasaCurvaInterpolada(BigDecimal plazo, BigDecimal x2, BigDecimal x1, BigDecimal y2, BigDecimal y1);
	public void eliminarPorFechaProceso(TasaCurva tasa);
	public List<TasaCurva> listarTasaCurvaFechaProceso(Calendar fecha);
	public List<TasaCurva> listarTasaCurvaFechaMaximaContratacion();
	
}
