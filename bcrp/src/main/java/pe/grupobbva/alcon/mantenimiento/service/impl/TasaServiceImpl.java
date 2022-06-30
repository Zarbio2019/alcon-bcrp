package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.entity.Operacion;
import pe.grupobbva.alcon.mantenimiento.entity.Tasa;
import pe.grupobbva.alcon.mantenimiento.repository.TasaRepository;
import pe.grupobbva.alcon.mantenimiento.service.TasaService;

@Service
public class TasaServiceImpl extends AbstractServiceImpl<Tasa> implements TasaService {

	@Override
	public List<Tasa> listarTasaFechaMaximaContratacion() {
		return ((TasaRepository) repository).listarTasaFechaMaximaContratacion();
	}
	
	@Override
	public List<Tasa> listarTasaFechaContratacion(Calendar fecha) {
		return ((TasaRepository) repository).listarTasaFechaContratacion(fecha);
	}

	@Override
	public BigDecimal obtenerTasaOperacionInterpolada(BigDecimal plazo, List<Tasa> tasas) {

		int elementos = 0;
		BigDecimal xElementoMayor = BigDecimal.ZERO;
		BigDecimal xElementoMenor = BigDecimal.ZERO;
		BigDecimal yElementoMayor = BigDecimal.ZERO;
		BigDecimal yElementoMenor = BigDecimal.ZERO;

		BigDecimal retornoTasaOperacionInterpolada = BigDecimal.ZERO;
		Boolean encontrado = false;

		try {
			while (elementos < tasas.size() && encontrado.equals(Boolean.FALSE)) {

				xElementoMayor = tasas.get(elementos).getCoordenadax();

				if (xElementoMayor.compareTo(plazo) > 0) {

					if ((elementos - 1) >= 0) {
						xElementoMenor = tasas.get(elementos - 1).getCoordenadax();

						if (xElementoMenor.compareTo(plazo) < 0 && plazo.compareTo(xElementoMayor) < 0) {

							yElementoMenor = tasas.get(elementos - 1).getCoordenaday();
							yElementoMayor = tasas.get(elementos).getCoordenaday();
							retornoTasaOperacionInterpolada = obtenerTasaMonedaNacional(plazo, xElementoMayor,
									xElementoMenor, yElementoMayor, yElementoMenor);
							encontrado = true;

						}

					} else {
						encontrado = true;
					}

				} else if (xElementoMayor == plazo) {
					retornoTasaOperacionInterpolada = tasas.get(elementos).getCoordenaday();
					encontrado = true;
				}

				elementos++;
			}

			if (encontrado.equals(Boolean.FALSE)) {
				retornoTasaOperacionInterpolada = BigDecimal.ZERO;
			}

		} catch (Exception ex) {
			ex.getMessage();
		}

		return retornoTasaOperacionInterpolada;
	}

	@Override
	public BigDecimal obtenerTasaMonedaNacional(BigDecimal plazo, BigDecimal x2, BigDecimal x1, BigDecimal y2,
			BigDecimal y1) {

		BigDecimal tasaOperacionInterpolada;
		BigDecimal y2Menosy1;
		BigDecimal x2Menosx1;

		y2Menosy1 = y2.subtract(y1);
		x2Menosx1 = x2.subtract(x1);

		if (x2Menosx1.compareTo(BigDecimal.ZERO) != 0) {
			tasaOperacionInterpolada = ((y2Menosy1.divide(x2Menosx1, 6, RoundingMode.HALF_EVEN).setScale(6,
					BigDecimal.ROUND_HALF_EVEN)).multiply(plazo.subtract(x1))).add(y1);
		} else {
			return BigDecimal.ZERO;
		}

		return tasaOperacionInterpolada;
	}

	@Override
	public BigDecimal obtenerTasaMonedaExtranjera(Operacion operacion, BigDecimal plazo) {

		BigDecimal tasaMonedaExtranjera;

		try {

			if ((operacion.getCotizacion().compareTo(BigDecimal.ZERO) != 0)
					&& (plazo.compareTo(BigDecimal.ZERO) != 0)) {

				tasaMonedaExtranjera = (((BigDecimal.ONE.add(
						operacion.getTasamonedanacional().divide(BigDecimal.valueOf(100), 6, RoundingMode.HALF_EVEN)
								.setScale(6, BigDecimal.ROUND_HALF_EVEN)))
										.multiply((operacion.getTipocambiospot()
												.divide(operacion.getCotizacion(), 6, RoundingMode.HALF_EVEN)
												.setScale(6, BigDecimal.ROUND_HALF_EVEN)).pow(
														BigDecimal.valueOf(360).divide(plazo, 6, RoundingMode.HALF_EVEN)
																.setScale(6, BigDecimal.ROUND_HALF_EVEN).intValue())))
																		.subtract(BigDecimal.ONE))
																				.multiply(BigDecimal.valueOf(100));
			} else {
				tasaMonedaExtranjera = BigDecimal.ZERO;
			}

		} catch (Exception e) {
			e.getMessage();
			tasaMonedaExtranjera = BigDecimal.ZERO;
		}

		return tasaMonedaExtranjera;
	}

	@Override
	public BigDecimal obtenerTasaDiferencial(Operacion operacion) {

		BigDecimal tasaDiferencial;

		try {

			if ((operacion.getTasamonedanacional().compareTo(BigDecimal.ZERO) != 0)
					&& (operacion.getTasamonedaextranjera().compareTo(BigDecimal.ZERO) != 0)) {

				tasaDiferencial = (((BigDecimal.ONE.add(
						operacion.getTasamonedanacional().divide(BigDecimal.valueOf(100), 6, RoundingMode.HALF_EVEN)
								.setScale(6, BigDecimal.ROUND_HALF_EVEN)))
										.divide(BigDecimal.ONE.add(operacion.getTasamonedaextranjera()
												.divide(BigDecimal.valueOf(100), 6, RoundingMode.HALF_EVEN)
												.setScale(6, BigDecimal.ROUND_HALF_EVEN)))).subtract(BigDecimal.ONE))
														.multiply(BigDecimal.valueOf(100));
			} else {
				tasaDiferencial = BigDecimal.ZERO;
			}

		} catch (Exception e) {
			e.getMessage();
			tasaDiferencial = BigDecimal.ZERO;
		}

		return tasaDiferencial;
	}
	
	@Override
	public void eliminarPorFechaProceso(Tasa tasa) {
		((TasaRepository) repository).eliminarPorFechaProceso(tasa);
	}
	
	@Override
	public List<Tasa> listarTasaFechaProceso(Calendar fecha) {
		return ((TasaRepository) repository).listarTasaFechaProceso(fecha);
	}

}
