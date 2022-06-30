package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Opcion;

@Data
public class OpcionDTO extends AbstractDTO<Opcion> {
	
	private String nombre;
	private Integer nivel;
	private Integer codigoopcpadre;
	private String url;
	private Integer orden;
	private Integer codigoestado;
	private Boolean visible;
	
	public OpcionDTO() {
		super();
	}
	
	public OpcionDTO(Opcion entity) {
		super(entity);
	}

	@Override
	public Opcion fromDTO(Opcion entity) {
		if (entity == null) {
			entity = new Opcion();
		}
		return entity;
	}

}
