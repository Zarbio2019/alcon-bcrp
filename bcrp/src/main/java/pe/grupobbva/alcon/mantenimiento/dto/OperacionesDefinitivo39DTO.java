package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CallPut;
import pe.grupobbva.alcon.mantenimiento.entity.Estado;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionesDefinitivo39;
import pe.grupobbva.alcon.mantenimiento.entity.Residente;
import pe.grupobbva.alcon.mantenimiento.entity.TipoEntrega;
import pe.grupobbva.alcon.mantenimiento.entity.TipoOperacion;

@Data
public class OperacionesDefinitivo39DTO extends AbstractDTO<OperacionesDefinitivo39> {

//	private Integer id;
	private BigDecimal importeusd;
	private String codigobcr;
	private TipoOperacion tipooperacion;
	private String tipocliente;
	private Residente residente;
	private TipoEntrega tipoentrega;
	private CallPut callput;
	private Calendar fechacontratacion;
	private Calendar fechavencimiento;
	private Integer iddivisaentrada;
	private String numerooperacion;
	private Estado estado;
	private Calendar fechamovimiento;

	public OperacionesDefinitivo39DTO() {
		super();
	}

	public OperacionesDefinitivo39DTO(OperacionesDefinitivo39 entity) {
		super(entity);
	}

	@Override
	public OperacionesDefinitivo39 fromDTO(OperacionesDefinitivo39 entity) {
		if (entity == null) {
			entity = new OperacionesDefinitivo39();
		}
		return entity;
	}

}
