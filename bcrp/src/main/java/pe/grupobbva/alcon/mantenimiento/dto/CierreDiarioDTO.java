package pe.grupobbva.alcon.mantenimiento.dto;

import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CierreDiario;

@Data
public class CierreDiarioDTO extends AbstractDTO<CierreDiario> {

	private Calendar fecha;
	private Integer codigoestado;

	public CierreDiarioDTO() {
		super();
	}

	public CierreDiarioDTO(CierreDiario entity) {
		super(entity);
		this.fecha = entity.getFecha();
		this.codigoestado = entity.getCodigoestado();
	}

	@Override
	public CierreDiario fromDTO(CierreDiario entity) {
		if (entity == null) {
			entity = new CierreDiario();
		}
		
		if(fecha != null) {
			entity.setFecha(this.fecha);
		}
		
		if(codigoestado != null) {
			entity.setCodigoestado(this.codigoestado);
		}
		
		return entity;
	}
	
	@Override
	public void preactualizar() {
		super.preactualizar();
	}

	/**
	 * @param id
	 * @param fecha
	 * @param codigoestado
	 */
	public CierreDiarioDTO(String id, Calendar fecha, Integer codigoestado) {
		super(id);
		this.fecha = fecha;
		this.codigoestado = codigoestado;
	}

}
