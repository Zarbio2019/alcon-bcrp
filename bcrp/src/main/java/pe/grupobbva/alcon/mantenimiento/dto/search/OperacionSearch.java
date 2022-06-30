package pe.grupobbva.alcon.mantenimiento.dto.search;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

@Data
public class OperacionSearch extends QueryDatatable {
	
	public OperacionSearch(Long draw, Integer start, Integer length) {
		super(draw, start, length);
	}

	private String numerooperacion = "";
	private String nombrecliente = "";
	private Date fechacontratacion;
	private String codigoreporte = "";
	private String codigocliente = "";
	private Date fechamovimiento;
	private String producto = "";
	private BigDecimal importeusdinicial = new BigDecimal(0);
	private BigDecimal importeusdfinal = new BigDecimal(0);
	private Date fechavencimiento;
	private String estado = "";
	private String tipoproceso = "";
	private Date fechavalor;
	private String intenciondecontratacion;
	
}
