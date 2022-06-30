package pe.grupobbva.alcon.mantenimiento.dto;

import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Feriado;

@Data
public class FeriadoDTO extends AbstractDTO<Feriado> {

	private String tipo;
	private Calendar fecha;
	private String operacion;

	public FeriadoDTO() {
		super();	
	}
	
	public FeriadoDTO(String id) {
		super(id);
	}

	public FeriadoDTO(Feriado entity) {
		super(entity);
		this.tipo = entity.getTipo();
		this.fecha = entity.getFecha();
		this.operacion = entity.getOperacion();
		this.codigoestado = entity.getCodigoestado();
	}

	@Override
	public Feriado fromDTO(Feriado entity) {
		if (entity == null) {
			entity = new Feriado();
		}
		
		if(tipo != null) {
			entity.setTipo(this.tipo);
		}
		
		if(fecha != null) {
			entity.setFecha(this.fecha);
		}
		
		if(operacion != null) {
			entity.setOperacion(this.operacion);
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
	 * @param tipo
	 * @param fecha
	 * @param operacion
	 * @param codigoestado
	 */
	public FeriadoDTO(String id, String tipo, Calendar fecha, String operacion, Integer codigoestado) {
		super(id);
		this.tipo = tipo;
		this.fecha = fecha;
		this.operacion = operacion;
		this.codigoestado = codigoestado;
	}

}
