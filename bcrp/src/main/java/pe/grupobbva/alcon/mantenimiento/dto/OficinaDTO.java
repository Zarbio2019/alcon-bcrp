package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Oficina;

@Data
public class OficinaDTO extends AbstractDTO<Oficina> {

	private String codigo;
	private String descripcion;
	private String posicioncambiaria;

	public OficinaDTO() {
		super();
	}

	public OficinaDTO(Oficina entity) {
		super(entity);
		this.codigo = entity.getCodigo();
		this.descripcion = entity.getDescripcion();
		this.posicioncambiaria = entity.getPosicioncambiaria().trim();
		this.codigoestado = entity.getCodigoestado();
	}

	@Override
	public Oficina fromDTO(Oficina entity) {
		
		if (entity == null) {
			entity = new Oficina();
		}
		
		if (codigo != null) {
			entity.setCodigo(this.codigo);
		}

		if (descripcion != null) {
			entity.setDescripcion(this.descripcion);
		}
		
		if (posicioncambiaria != null) {
			entity.setPosicioncambiaria(this.posicioncambiaria.trim());
		}

		if (codigoestado != null) {
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
	 * @param posicioncambiaria
	 * @param codigoestado
	 */
	public OficinaDTO(String id, String codigo, String descripcion, String posicioncambiaria, Integer codigoestado) {
		super(id);
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.posicioncambiaria = posicioncambiaria.trim();
		this.codigoestado = codigoestado;

	}

	public OficinaDTO(String codigo, String descripcion, String posicioncambiaria, Integer codigoestado) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.posicioncambiaria = posicioncambiaria.trim();
		this.codigoestado = codigoestado;
	}
	
	public OficinaDTO(String id) {
		super(id);
	}

}
