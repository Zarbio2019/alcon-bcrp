package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Tasa;

@Data
public class TasaDTO extends AbstractDTO<Tasa> {

	private String curva;
	private String iddivisa;
	private Calendar fechavencimiento;
	private String par;
	private BigDecimal coordenaday;
	private BigDecimal coordenadax;
	private Calendar fechainicio;
	private Integer plazo;
	private Calendar fechaproceso;

	public TasaDTO(String id) {
		super(id);
	}

	public TasaDTO() {
		super();
	}

	public TasaDTO(Tasa entity) {
		super(entity);
	}

	@Override
	public Tasa fromDTO(Tasa entity) {

		if (entity == null) {
			entity = new Tasa();
		}

		if (curva != null) {
			entity.setCurva(curva);
		}

		if (iddivisa != null) {
			entity.setIddivisa(iddivisa);
		}

		if (fechavencimiento != null) {
			entity.setFechavencimiento(fechavencimiento);
		}

		if (par != null) {
			entity.setPar(par);
		}

		if (coordenaday != null) {
			entity.setCoordenaday(coordenaday);
		}

		if (coordenadax != null) {
			entity.setCoordenadax(coordenadax);
		}

		if (fechainicio != null) {
			entity.setFechainicio(fechainicio);
		}

		if (plazo != null) {
			entity.setPlazo(plazo);
		}

		if (fechaproceso != null) {
			entity.setFechaproceso(fechaproceso);
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

	/**
	 * @param id
	 * @param curva
	 * @param iddivisa
	 * @param fechavencimiento
	 * @param par
	 * @param coordenaday
	 * @param coordenadax
	 * @param fechainicio
	 * @param plazo
	 * @param fechaproceso
	 * @param codigoestado
	 */

	public TasaDTO(String id, String curva, String iddivisa, Calendar fechavencimiento, String par,
			BigDecimal coordenaday, BigDecimal coordenadax, Calendar fechainicio, Integer plazo, Calendar fechaproceso,
			Integer codigoestado) {
		
		super(id);
		this.curva = curva;
		this.iddivisa = iddivisa;
		this.fechavencimiento = fechavencimiento;
		this.par = par;
		this.coordenaday = coordenaday;
		this.coordenadax = coordenadax;
		this.fechainicio = fechainicio;
		this.plazo = plazo;
		this.fechaproceso = fechaproceso;		
		this.codigoestado = codigoestado;
	}

}
