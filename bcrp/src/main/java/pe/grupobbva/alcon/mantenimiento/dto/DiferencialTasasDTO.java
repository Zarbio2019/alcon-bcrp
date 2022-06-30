package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.DiferencialTasas;

@Data
public class DiferencialTasasDTO extends AbstractDTO<DiferencialTasas> {
	
	private Calendar fecha;
	private Integer plazo;
	private BigDecimal diferencialcompra;
	private BigDecimal  diferencialventa;
	private Integer codigoestado;
	
	public DiferencialTasasDTO() {
		super();
	}
	
	public DiferencialTasasDTO(DiferencialTasas entity) {
		super(entity);
	}

	@Override
	public DiferencialTasas fromDTO(DiferencialTasas entity) {
		if (entity == null) {
			entity = new DiferencialTasas();
		}
		return entity;
	}

}
