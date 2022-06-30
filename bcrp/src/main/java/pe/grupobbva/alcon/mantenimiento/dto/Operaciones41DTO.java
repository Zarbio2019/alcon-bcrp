package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Operaciones41;
import pe.grupobbva.alcon.mantenimiento.entity.TipoOperacion;

@Data
public class Operaciones41DTO extends AbstractDTO<Operaciones41> {
	
//	private Integer id;
	private String idoperacion;
	private BigDecimal importeusd;
	private TipoOperacion tipooperacion;
	private Calendar fechacontratacion;
	private Calendar fechavencimiento;
	private Calendar fechamovimiento;
	private Integer idproducto;

	public Operaciones41DTO() {
		super();
	}
	
	public Operaciones41DTO(Operaciones41 entity) {
		super(entity);
	}

	@Override
	public Operaciones41 fromDTO(Operaciones41 entity) {
		if (entity == null) {
			entity = new Operaciones41();
		}
		return entity;
	}

}
