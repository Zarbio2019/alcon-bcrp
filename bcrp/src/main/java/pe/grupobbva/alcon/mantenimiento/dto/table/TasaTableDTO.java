package pe.grupobbva.alcon.mantenimiento.dto.table;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.core.beans.TimeFormat;
import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.dto.TasaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.process.TasaCargaType;
import pe.grupobbva.alcon.mantenimiento.entity.Tasa;

@Data
public class TasaTableDTO extends TasaDTO {

	/**
	 * @param registro
	 * @throws ParseException
	 */
	public TasaTableDTO(TasaCargaType registro) throws ParseException {

		setCurva(registro.getCurva());

		if (registro.getFechavencimiento() != null) {
			setFechavencimiento(Utils.stringtoCalendar(registro.getFechavencimiento(), TimeFormat.DATEFORMAT));
		}

		setPar(registro.getPar());
		setCoordenaday(registro.getCoordenaday());

		if (registro.getFechainicio() != null) {
			setFechainicio(Utils.stringtoCalendar(registro.getFechainicio(), TimeFormat.DATEFORMAT));
		}

		if (registro.getFechavencimiento() != null) {
			setPlazo((int) Utils.obtenerPlazo(registro.getFechaproceso(), getFechavencimiento()));
		}

		setCoordenadax(BigDecimal.valueOf(Utils.obtenerPlazo(registro.getFechaproceso(), getFechavencimiento())));
		setFechaproceso(registro.getFechaproceso());

	}

	private String divisacodigo;

	public TasaTableDTO() {
		super();
	}

	public TasaTableDTO(String id) {
		super(id);
	}

	public TasaTableDTO(Tasa entity) {
		super(entity);
	}

	@Override
	public Tasa fromDTO(Tasa entity) {

		if (entity == null) {
			entity = new Tasa();
		}

		if (getCurva() != null) {
			entity.setCurva(getCurva());
		}

		if (getIddivisa() != null) {
			entity.setIddivisa(getIddivisa());
		}

		if (getFechavencimiento() != null) {
			entity.setFechavencimiento(getFechavencimiento());
		}

		if (getPar() != null) {
			entity.setPar(getPar());
		}

		if (getCoordenaday() != null) {
			entity.setCoordenaday(getCoordenaday());
		}

		if (getCoordenadax() != null) {
			entity.setCoordenadax(getCoordenadax());
		}

		if (getFechainicio() != null) {
			entity.setFechainicio(getFechainicio());
		}

		if (getPlazo() != null) {
			entity.setPlazo(getPlazo());
		}

		if (getFechaproceso() != null) {
			entity.setFechaproceso(getFechaproceso());
		}

		if (getCodigoestado() != null) {
			entity.setCodigoestado(getCodigoestado());
		}

		return entity;
	}

	public TasaTableDTO(String id, String curva, String iddivisa, Calendar fechavencimiento, String par,
			BigDecimal coordenaday, BigDecimal coordenadax, Calendar fechainicio, Integer plazo, Calendar fechaproceso,
			Integer codigoestado, String divisacodigo) {
		
		super(id, curva, iddivisa, fechavencimiento, par, coordenaday, coordenadax, fechainicio, plazo, fechaproceso,
				codigoestado);
		this.divisacodigo = divisacodigo;
		
	}

}
