package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Perfil;

@Data
public class PerfilDTO extends AbstractDTO<Perfil> {
	
	private String descripcion;
	private String hostperfil;
	private Integer codigoestado;
	
	public PerfilDTO() {
		super();
	}

	public PerfilDTO(Perfil entity) {
		super(entity);
	}

	@Override
	public Perfil fromDTO(Perfil entity) {
		if (entity == null) {
			entity = new Perfil();
		}
		return entity;
	}

}
