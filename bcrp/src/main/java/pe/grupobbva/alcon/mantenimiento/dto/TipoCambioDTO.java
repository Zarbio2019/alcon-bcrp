package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCambio;

@Data
public class TipoCambioDTO extends AbstractDTO<TipoCambio> {
	
	private String idDivisa;
	private Calendar fecha;
	private BigDecimal importe;
	private Integer codigoestado;
	
	public TipoCambioDTO() {
		super();
	}

	public TipoCambioDTO(TipoCambio entity) {
		super(entity);
		this.idDivisa = entity.getDivisa().getId();
		this.fecha = entity.getFecha();
		this.importe = entity.getImporte();
		this.codigoestado = entity.getCodigoestado();
	}

	@Override
	public TipoCambio fromDTO(TipoCambio entity) {
		
		if (entity == null) {
			entity = new TipoCambio();
		}
		
		if (idDivisa != null) {
			entity.setDivisa(new Divisa(this.idDivisa));
		}
		
		if (fecha != null) {
			entity.setFecha(this.fecha);
		}
		
		if (importe != null) {
			entity.setImporte(this.importe);
		}
		
		if (codigoestado != null) {
			entity.setCodigoestado(this.codigoestado);
		}
		
		return entity;
	}

	/**
	 * @param id
	 * @param idDivisa
	 * @param fecha
	 * @param importe
	 * @param codigoestado
	 */
	public TipoCambioDTO(String id, String idDivisa, Calendar fecha, BigDecimal importe, Integer codigoestado) {
		super(id);
		this.idDivisa = idDivisa;
		this.fecha = fecha;
		this.importe = importe;
		this.codigoestado = codigoestado;
	}

}
