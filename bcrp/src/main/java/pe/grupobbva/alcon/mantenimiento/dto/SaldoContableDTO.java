package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.entity.Oficina;
import pe.grupobbva.alcon.mantenimiento.entity.SaldoContable;

@Data
public class SaldoContableDTO extends AbstractDTO<SaldoContable> {

	private String idDivisa;
	private String idOficina;
	private Calendar fecha;
	private BigDecimal importe;
	
	public SaldoContableDTO(String id) {
		super(id);
	}

	public SaldoContableDTO() {
		super();	
	}

	public SaldoContableDTO(SaldoContable entity) {
		super(entity);
		this.idDivisa = entity.getDivisa().getId();
		this.idOficina = entity.getOficina().getId();
		this.fecha = entity.getFecha();
		this.importe = entity.getImporte();
		this.codigoestado = entity.getCodigoestado();
	}

	@Override
	public SaldoContable fromDTO(SaldoContable entity) {
		if (entity == null) {
			entity = new SaldoContable();
		}
		
		if (idDivisa != null) {
			entity.setDivisa(new Divisa(idDivisa));
		}
		
		if (idOficina != null) {
			entity.setOficina(new Oficina(idOficina));
		}
		
		if (fecha != null) {
			entity.setFecha(fecha);
		}
		
		if (importe != null) {
			entity.setImporte(importe);
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
	 * @param idDivisa
	 * @param idOficina
	 * @param fecha
	 * @param importe
	 * @param codigoestado
	 */

	public SaldoContableDTO(String id, String idDivisa, String idOficina, Calendar fecha, BigDecimal importe,
			Integer codigoestado) {
		super(id);
		this.idDivisa = idDivisa;
		this.idOficina = idOficina;
		this.fecha = fecha;
		this.importe = importe;
		this.codigoestado = codigoestado;
	}

}
