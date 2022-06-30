package pe.grupobbva.alcon.mantenimiento.dto.table;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.SaldoContableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.SaldoContable;

@Data
public class SaldoContableTableDTO extends SaldoContableDTO {
	private String divisacodigo;
	private String oficinacodigo;
	
	public SaldoContableTableDTO() {
		super();
	}
	
	public SaldoContableTableDTO(String id) {
		super(id);
	}

	public SaldoContableTableDTO(SaldoContable entity) {
		super(entity);
	}

	public SaldoContableTableDTO(String id, String idDivisa, String idOficina, Calendar fecha, BigDecimal importe,
			String divisacodigo, String oficinacodigo, Integer codigoestado) {
		
		super(id, idDivisa, idOficina, fecha, importe, codigoestado);
		
		this.divisacodigo = divisacodigo;
		this.oficinacodigo = oficinacodigo;
	}
	
	

	
}
