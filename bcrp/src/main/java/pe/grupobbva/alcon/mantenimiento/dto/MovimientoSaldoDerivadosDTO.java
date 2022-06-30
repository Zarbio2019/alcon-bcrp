package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.MovimientoSaldoDerivados;
import pe.grupobbva.alcon.mantenimiento.entity.SaldoDerivados;

@Data
public class MovimientoSaldoDerivadosDTO extends AbstractDTO<MovimientoSaldoDerivados> {
	
	private String idSaldoDerivados;
	private Calendar fecha;
	private BigDecimal monto;
	
	public MovimientoSaldoDerivadosDTO() {
		super();
	}


	public MovimientoSaldoDerivadosDTO(String id) {
		super(id);
	}
	
	public MovimientoSaldoDerivadosDTO(MovimientoSaldoDerivados entity) {
		super(entity);
		this.idSaldoDerivados = entity.getSaldoDerivados().getId();
		this.fecha = entity.getFecha();
		this.monto = entity.getMonto();
	}
	
	@Override
	public MovimientoSaldoDerivados fromDTO(MovimientoSaldoDerivados entity) {
		if(entity == null) {
			entity = new MovimientoSaldoDerivados();
		}
		
		if(idSaldoDerivados != null) {
			entity.setSaldoDerivados(new SaldoDerivados(this.idSaldoDerivados));
		}
		
		if(fecha != null) {
			entity.setFecha(this.fecha);
		}
		
		if(monto!= null) {
			entity.setMonto(this.monto);
		}
		
		return entity;
	}


	@Override
	public void preactualizar() {
		super.preactualizar();
	}
	
	public MovimientoSaldoDerivadosDTO(String id, String idSaldoDerivados, Calendar fecha, BigDecimal monto) {
		super(id);
		this.idSaldoDerivados = idSaldoDerivados;
		this.fecha = fecha;
		this.monto = monto;
	}


	public MovimientoSaldoDerivadosDTO( String idSaldoDerivados, Calendar fecha, BigDecimal monto) {
		super();
		this.idSaldoDerivados = idSaldoDerivados;
		this.fecha = fecha;
		this.monto = monto;
	}




}
