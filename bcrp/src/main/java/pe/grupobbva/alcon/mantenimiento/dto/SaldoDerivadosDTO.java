package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.SaldoDerivados;

@Data
public class SaldoDerivadosDTO extends AbstractDTO<SaldoDerivados>{
	
	private String codigooperacion;
	private String descripcion;

	
	public SaldoDerivadosDTO() {
		super();
	}

	public SaldoDerivadosDTO(String id) {
		super(id);
	}
	
	public SaldoDerivadosDTO(SaldoDerivados entity) {
		super(entity);
		this.codigooperacion = entity.getCodigooperacion();
		this.descripcion = entity.getDescripcion();
	}
	
	@Override
	public SaldoDerivados fromDTO(SaldoDerivados entity) {
		if (entity == null) {
			entity = new SaldoDerivados();
		}
		
		if(codigooperacion!=null) {
			entity.setCodigooperacion(this.codigooperacion);	
		}
		
		if(descripcion!=null) {
			entity.setDescripcion(this.descripcion);
		}
		
		if(codigoestado!=null) {
			entity.setCodigoestado(this.codigoestado);
		}
		
		return null;
	}

	@Override
	public void preactualizar() {
		super.preactualizar();
	}

	/**
	 * 
	 * @param id
	 * @param codigooperacion
	 * @param descripcion
	 */

	public SaldoDerivadosDTO(String id, String codigooperacion, String descripcion) {
		super(id);
		this.codigooperacion = codigooperacion;
		this.descripcion = descripcion;
	}

	public SaldoDerivadosDTO(String codigooperacion, String descripcion) {
		super();
		this.codigooperacion = codigooperacion;
		this.descripcion = descripcion;
	}
	
}
