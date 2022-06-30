package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.MovimientoPosicionCambiaria;
import pe.grupobbva.alcon.mantenimiento.entity.PosicionCambiaria;
import pe.grupobbva.alcon.mantenimiento.entity.TipoProceso;

@Data
public class MovimientoPosicionCambiariaDTO extends AbstractDTO<MovimientoPosicionCambiaria> {
	
	private TipoProceso tipoProceso;
	private String idPosicionCambiaria;
	private BigDecimal importedelta;
	private BigDecimal importeactual;
	private Calendar fecha;
	private Integer codigoestado;
	
	public MovimientoPosicionCambiariaDTO() {
		super();
	}
	
	public MovimientoPosicionCambiariaDTO(String id) {
		super(id);
	}
	
	public MovimientoPosicionCambiariaDTO(MovimientoPosicionCambiaria entity) {
		super(entity);
		this.tipoProceso = entity.getTipoproceso();
		this.idPosicionCambiaria = entity.getPosicionCambiaria().getId();
		this.importedelta = entity.getImportedelta();
		this.importeactual = entity.getImporteactual();
		this.fecha = entity.getFecha();
		this.codigoestado = entity.getCodigoestado();
	}

	@Override
	public MovimientoPosicionCambiaria fromDTO(MovimientoPosicionCambiaria entity) {
		if (entity == null) {
			entity = new MovimientoPosicionCambiaria();
		}
		
		if(tipoProceso !=null) {
			entity.setTipoproceso(this.tipoProceso);
		}
		
		if(idPosicionCambiaria != null) {
			entity.setPosicionCambiaria(new PosicionCambiaria(this.idPosicionCambiaria));
		}
		if(importedelta != null) {
			entity.setImportedelta(this.importedelta);;
		}
		if(importeactual != null) {
			entity.setImporteactual(this.importeactual);
		}
		if(fecha != null) {
			entity.setFecha(this.fecha);
		}
		if(codigoestado != null) {
			entity.setCodigoestado(this.codigoestado);
		}
		
		return entity;
	}
	
	@Override
	public void preactualizar() {
		super.preactualizar();
	}
	
	public MovimientoPosicionCambiariaDTO(String id,TipoProceso tipoProceso, String idPosicionCambiaria, BigDecimal importedelta,
			BigDecimal importeactual, Calendar fecha, Integer codigoestado) {
		super(id);
		this.tipoProceso = tipoProceso;
		this.idPosicionCambiaria = idPosicionCambiaria;
		this.importedelta = importedelta;
		this.importeactual = importeactual;
		this.fecha = fecha;
		this.codigoestado = codigoestado;
	}

	public MovimientoPosicionCambiariaDTO(TipoProceso tipoProceso, String idPosicionCambiaria, BigDecimal importedelta,
			BigDecimal importeactual, Calendar fecha, Integer codigoestado) {
		super();
		this.tipoProceso = tipoProceso;
		this.idPosicionCambiaria = idPosicionCambiaria;
		this.importedelta = importedelta;
		this.importeactual = importeactual;
		this.fecha = fecha;
		this.codigoestado = codigoestado;
	}
	
}
