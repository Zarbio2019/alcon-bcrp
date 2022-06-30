package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;

@Data
public class DivisaDTO extends AbstractDTO<Divisa> {
	
	private String codigo;
	private String descripcion;

	
	public DivisaDTO() {
		super();
	}
	
	public DivisaDTO(String id) {
		super(id);
	}
	
	
	public DivisaDTO(Divisa entity) {
		super(entity);
		this.codigo = entity.getCodigo();
		this.descripcion = entity.getDescripcion();
		this.codigoestado = entity.getCodigoestado();
	}

	@Override
	public Divisa fromDTO(Divisa entity) {
				
		if (entity == null) {
			entity = new Divisa();
		}
		
		if(codigo != null) {
			entity.setCodigo(this.codigo);
		}
		
		if(descripcion != null) {
			entity.setDescripcion(this.descripcion);
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
	 * @param codigo
	 * @param descripcion
	 * @param codigoestado
	 */
	public DivisaDTO(String id, String codigo, String descripcion, Integer codigoestado) {
		super(id);
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.codigoestado = codigoestado;
	}
	
}
