package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCambioSbs;

@Data
public class TipoCambioSbsDTO extends AbstractDTO<TipoCambioSbs> {

	private Calendar fecha;
	private String divisa;
	private BigDecimal tcfix;

	public TipoCambioSbsDTO() {
		super();
	}

	public TipoCambioSbsDTO(TipoCambioSbs entity) {
		super(entity);
	}

	@Override
	public TipoCambioSbs fromDTO(TipoCambioSbs entity) {
		if (entity == null) {
			entity = new TipoCambioSbs();
		}
		return entity;
	}

}
