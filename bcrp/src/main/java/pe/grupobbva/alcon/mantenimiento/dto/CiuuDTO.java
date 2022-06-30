package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Ciuu;

@Data
public class CiuuDTO extends AbstractDTO<Ciuu> {
	
	private String central;
	private String ciuu;
	private Integer codigoestado;
	
	public CiuuDTO() {
		super();
	}

	public CiuuDTO(Ciuu entity) {
		super(entity);
	}

	@Override
	public Ciuu fromDTO(Ciuu entity) {
		if (entity == null) {
			entity = new Ciuu();
		}
		return entity;
	}
	
}
