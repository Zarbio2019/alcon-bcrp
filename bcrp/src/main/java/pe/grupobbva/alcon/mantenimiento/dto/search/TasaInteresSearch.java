package pe.grupobbva.alcon.mantenimiento.dto.search;

import java.util.Date;

import lombok.Data;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

@Data
public class TasaInteresSearch extends QueryDatatable{
	
	public TasaInteresSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}

	private String numerooperacion;
	private String codigocliente;
	private String nombrecliente;
	private String codigoreporte;
	private String producto;
	private Date fechavencimiento;
	private Date fechamovimiento;
	private String estado;
	private String tipoproceso;
	
	
}
