package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Parametro;

@Data
public class ParametroDTO extends AbstractDTO<Parametro> {

	private String codigo;
	private String descripcion;
	private Integer codigoestado;
	
	public ParametroDTO() {
		super();
	}

	public ParametroDTO(Parametro entity) {
		super(entity);
		this.codigo=entity.getCodigo();
		this.descripcion=entity.getDescripcion();
		this.codigoestado=entity.getCodigoestado();
	}

	@Override
	public Parametro fromDTO(Parametro entity) {
		if (entity == null) {
			entity = new Parametro();
		}
		if(codigo!=null) {
			entity.setCodigo(this.codigo);
		}
		if(descripcion !=null) {
			entity.setDescripcion(this.descripcion);
		}
		if(codigoestado!=null) {
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
	 * @param codigo
	 * @param descripcion
	 */

	public ParametroDTO(String id, String codigo, String descripcion) {
		super(id);
		this.codigo = codigo;
		this.descripcion = descripcion;
	}
	public ParametroDTO(String id, String codigo, String descripcion,Integer codigoestado) {
		super(id);
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.codigoestado=codigoestado;
	}
}
