package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CodigoStarAltamira;

@Data
public class CodigoStarAltamiraDTO extends AbstractDTO<CodigoStarAltamira> {

	private String codigo;
	private String altamira;

	public CodigoStarAltamiraDTO() {
		super();
	}
	
	public CodigoStarAltamiraDTO(String id) {
		super(id);
	}

	public CodigoStarAltamiraDTO(CodigoStarAltamira entity) {
		super(entity);

		this.codigo = entity.getCodigo();
		this.altamira = entity.getAltamira();
		this.codigoestado = entity.getCodigoestado();

	}

	@Override
	public CodigoStarAltamira fromDTO(CodigoStarAltamira entity) {
		if (entity == null) {
			entity = new CodigoStarAltamira();
		}

		if (codigo != null) {
			entity.setCodigo(this.codigo);
		}

		if (altamira != null) {
			entity.setAltamira(this.altamira);
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

	public CodigoStarAltamiraDTO(String id, String codigo, String altamira, Integer codigoestado) {
		super(id);
		this.codigo = codigo;
		this.altamira = altamira;
		this.codigoestado = codigoestado;

	}
	
	public CodigoStarAltamiraDTO(String codigo, String altamira, Integer codigoestado) {
		super();
		this.codigo = codigo;
		this.altamira = altamira;
		this.codigoestado = codigoestado;

	}

}
