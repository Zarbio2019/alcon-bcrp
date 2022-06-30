package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleParametro;
import pe.grupobbva.alcon.mantenimiento.entity.Parametro;
@Data
public class DetalleParametroDTO extends AbstractDTO<DetalleParametro> {

	private String codigo;
	private String descripcion;
	private Boolean visible;
	private String idParametro;
	private Integer codigoestado;
	public DetalleParametroDTO() {
		super();
	}

	public DetalleParametroDTO(DetalleParametro entity) {
		super(entity);
		this.codigo=entity.getCodigo();
		this.descripcion=entity.getDescripcion();
		this.visible=entity.getVisible();
		this.idParametro = entity.getParametro().getId();
		this.codigoestado=entity.getCodigoestado();
	}

	@Override
	public DetalleParametro fromDTO(DetalleParametro entity) {
		if (entity == null) {
			entity = new DetalleParametro();
		}
		if(codigo!=null) {
			entity.setCodigo(this.codigo);
		}
		if(descripcion!=null) {
			entity.setDescripcion(this.descripcion);
		}
		if(visible!=null) {
			entity.setVisible(this.visible);
		}
		if(idParametro!=null) {
			entity.setParametro(new Parametro(this.idParametro));
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
	 * @param codigo
	 * @param descripcion
	 * @param visible
	 * @param idParametro
	 */
	public DetalleParametroDTO(String id, String codigo, String descripcion, Boolean visible, String idParametro) {
		super(id);
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.visible = visible;
		this.idParametro = idParametro;
	}
	
	public DetalleParametroDTO(String id, String codigo, String descripcion, Boolean visible, String idParametro,Integer codigoestado) {
		super(id);
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.visible = visible;
		this.idParametro = idParametro;
		this.codigoestado=codigoestado;
	}
	
	
}
