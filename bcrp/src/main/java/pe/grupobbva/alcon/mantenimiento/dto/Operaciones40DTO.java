package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Operaciones40;
import pe.grupobbva.alcon.mantenimiento.entity.TipoOperacion;

@Data
public class Operaciones40DTO extends AbstractDTO<Operaciones40> {
	
//	private Integer id;
	private String idoperacion;
	private BigDecimal importeusd;
	private TipoOperacion tipooperacion;
	private Calendar fechacontratacion;
	private Calendar fechavencimiento;
	private Calendar fechamovimiento;
	private Integer idproducto;

	public Operaciones40DTO() {
		super();
	}
	
	public Operaciones40DTO(Operaciones40 entity) {
		super(entity);
	}

	@Override
	public Operaciones40 fromDTO(Operaciones40 entity) {
		if (entity == null) {
			entity = new Operaciones40();
		}
		return entity;
	}

}
