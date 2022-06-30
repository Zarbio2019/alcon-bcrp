package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.RutaCarpeta;

@Data
public class RutaCarpetaDTO extends AbstractDTO<RutaCarpeta> {

	private String rutacarpeta;

	public RutaCarpetaDTO() {
		super();
	}

	public RutaCarpetaDTO(RutaCarpeta entity) {
		super(entity);
	}

	@Override
	public RutaCarpeta fromDTO(RutaCarpeta entity) {
		if (entity == null) {
			entity = new RutaCarpeta();
		}
		return entity;
	}
	
}
