package pe.grupobbva.alcon.mantenimiento.dto.table;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.TipoCambioDTO;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCambio;

@Data
public class TipoCambioTableDTO extends TipoCambioDTO {

	public TipoCambioTableDTO() {
		super();
	}

	public TipoCambioTableDTO(TipoCambio entity) {
		super(entity);
	}

	public TipoCambioTableDTO(String id, String idDivisa, Calendar fecha, BigDecimal importe, Integer codigoestado,
			String formatoFecha,String divisaCodigo) {
		
		super(id, idDivisa, fecha, importe, codigoestado);
		this.formatoFecha= formatoFecha;
		this.divisaCodigo = divisaCodigo;
	}

	private String formatoFecha;
	private String divisaCodigo;
	

}
