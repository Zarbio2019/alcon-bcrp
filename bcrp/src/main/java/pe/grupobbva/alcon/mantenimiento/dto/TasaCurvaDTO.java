package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.TasaCurva;

@Data
public class TasaCurvaDTO extends AbstractDTO<TasaCurva> {

	private String curva;
	private String iddivisa;
	private String divisacurva;
	private Calendar fechaproceso;
	private Calendar fecha;
	private String tenor;
	private BigDecimal plazo; // x
	private BigDecimal tasa1;
	private BigDecimal tasa2;
	private BigDecimal tasa3;
	private String datofijo1; // y
	private String datofijo2;
	private Calendar fechainicio;
	private Calendar fechafin;

	public TasaCurvaDTO(String id) {
		super(id);
	}

	public TasaCurvaDTO() {
		super();
	}

	public TasaCurvaDTO(TasaCurva entity) {
		super(entity);
	}

	@Override
	public TasaCurva fromDTO(TasaCurva entity) {

		if (entity == null) {
			entity = new TasaCurva();
		}

		if (curva != null) {
			entity.setCurva(curva);
		}

		if (iddivisa != null) {
			entity.setIddivisa(iddivisa);
		}

		if (divisacurva != null) {
			entity.setDivisacurva(divisacurva);
		}

		if (fechaproceso != null) {
			entity.setFechaproceso(fechaproceso);
		}

		if (fecha != null) {
			entity.setFecha(fecha);
		}

		if (tenor != null) {
			entity.setTenor(tenor);
		}

		if (plazo != null) {
			entity.setPlazo(plazo);
		}

		if (tasa1 != null) {
			entity.setTasa1(tasa1);
		}

		if (tasa2 != null) {
			entity.setTasa2(tasa1);
		}

		if (tasa3 != null) {
			entity.setTasa3(tasa1);
		}

		if (datofijo1 != null) {
			entity.setDatofijo1(datofijo1);
		}

		if (datofijo2 != null) {
			entity.setDatofijo2(datofijo2);
		}

		if (fechainicio != null) {
			entity.setFechainicio(fechainicio);
		}

		if (fechafin != null) {
			entity.setFechafin(fechafin);
		}

		if (codigoestado != null) {
			entity.setCodigoestado(codigoestado);
		}

		return entity;
	}

	@Override
	public void preactualizar() {
		super.preactualizar();
	}

	public TasaCurvaDTO(String id, String curva, String iddivisa, String divisacurva, Calendar fechaproceso,
			Calendar fecha, String tenor, BigDecimal plazo, BigDecimal tasa1, BigDecimal tasa2, BigDecimal tasa3,
			String datofijo1, String datofijo2, Calendar fechainicio, Calendar fechafin, Integer codigoestado) {

		super(id);
		this.curva = curva;
		this.iddivisa = iddivisa;
		this.divisacurva = divisacurva;
		this.fechaproceso = fechaproceso;
		this.fecha = fecha;
		this.tenor = tenor;
		this.plazo = plazo;
		this.tasa1 = tasa1;
		this.tasa2 = tasa2;
		this.tasa3 = tasa3;
		this.datofijo1 = datofijo1;
		this.datofijo2 = datofijo2;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
		this.codigoestado = codigoestado;
	}

}
