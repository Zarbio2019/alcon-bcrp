package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Correlativo;

@Data
public class CorrelativoDTO extends AbstractDTO<Correlativo> {

	private String nombrecorrelativo;
	private String mescorrelativo;
	private String aniocorrelativo;
	private String diacorrelativo;
	private Integer valorcorrelativo;
	
	public CorrelativoDTO() {
		super();
	}
	
	public CorrelativoDTO(Correlativo entity) {
		super(entity);
	}

	@Override
	public Correlativo fromDTO(Correlativo entity) {
		if (entity == null) {
			entity = new Correlativo();
		}
		return entity;
	}

}
