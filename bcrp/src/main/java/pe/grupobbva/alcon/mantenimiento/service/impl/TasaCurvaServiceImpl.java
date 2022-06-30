package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.entity.TasaCurva;
import pe.grupobbva.alcon.mantenimiento.repository.TasaCurvaRepository;
import pe.grupobbva.alcon.mantenimiento.service.TasaCurvaService;

@Service
public class TasaCurvaServiceImpl extends AbstractServiceImpl<TasaCurva> implements TasaCurvaService {
	
	@Override
	public BigDecimal obtenerTasaOperacionInterpolada(BigDecimal plazo, String curvadivisa, List<TasaCurva> tasas) {

		int elementos = 0;
		BigDecimal xElementoMayor = BigDecimal.ZERO;
		BigDecimal xElementoMenor = BigDecimal.ZERO;
		BigDecimal yElementoMayor = BigDecimal.ZERO;
		BigDecimal yElementoMenor = BigDecimal.ZERO;

		BigDecimal retornoTasaOperacionInterpolada = BigDecimal.ZERO;
		Boolean encontrado = false;
		
		List<TasaCurva> tasasdivisas = tasas.stream().filter(lista -> curvadivisa.equals(lista.getDivisacurva())).collect(Collectors.toList());

		try {
			while (elementos < tasasdivisas.size() && encontrado.equals(Boolean.FALSE)) {

				xElementoMayor = tasasdivisas.get(elementos).getPlazo();

				if (xElementoMayor.compareTo(plazo) > 0) {

					if ((elementos - 1) >= 0) {
						xElementoMenor = tasasdivisas.get(elementos - 1).getPlazo();

						if (xElementoMenor.compareTo(plazo) < 0 && plazo.compareTo(xElementoMayor) < 0) {

							yElementoMenor = tasasdivisas.get(elementos - 1).getTasa1();
							yElementoMayor = tasasdivisas.get(elementos).getTasa1();
							retornoTasaOperacionInterpolada = obtenerTasaCurvaInterpolada(plazo, xElementoMayor,
									xElementoMenor, yElementoMayor, yElementoMenor);
							encontrado = true;

						}

					} else {
						encontrado = true;
					}

				} else if (xElementoMayor.compareTo(plazo) == 0) {
					retornoTasaOperacionInterpolada = tasasdivisas.get(elementos).getTasa1();
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
	public BigDecimal obtenerTasaCurvaInterpolada(BigDecimal plazo, BigDecimal x2, BigDecimal x1, BigDecimal y2,
			BigDecimal y1) {

		BigDecimal tasaOperacionInterpolada;
		BigDecimal y2Menosy1;
		BigDecimal x2Menosx1;

		y2Menosy1 = y2.subtract(y1);
		x2Menosx1 = x2.subtract(x1);

		if (x2Menosx1.compareTo(BigDecimal.ZERO) != 0) {
			tasaOperacionInterpolada = ((y2Menosy1.divide(x2Menosx1, 7, RoundingMode.HALF_EVEN).setScale(7,
					BigDecimal.ROUND_HALF_EVEN)).multiply(plazo.subtract(x1))).add(y1);
		} else {
			return BigDecimal.ZERO;
		}

		return tasaOperacionInterpolada;
	}
	
	@Override
	@Transactional
	public void eliminarPorFechaProceso(TasaCurva tasa) {
		((TasaCurvaRepository) repository).eliminarPorFechaProceso(tasa.getFechaproceso());
	}
	
	@Override
	public List<TasaCurva> listarTasaCurvaFechaProceso(Calendar fecha) {
		return ((TasaCurvaRepository) repository).listarTasaCurvaFechaProceso(fecha);
	}
	
	@Override
	public List<TasaCurva> listarTasaCurvaFechaMaximaContratacion() {
		return ((TasaCurvaRepository) repository).listarTasaCurvaFechaMaximaContratacion();
	}

}
