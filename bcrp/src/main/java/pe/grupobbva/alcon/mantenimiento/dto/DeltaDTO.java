package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Delta;

@Data
public class DeltaDTO extends AbstractDTO<Delta> {
	
	private String numerooperacion;
	private BigDecimal deltas;
	private String descripcion;
	private BigDecimal importe;
	private Calendar fechaproceso;
	private BigDecimal cobertura;
	
	public DeltaDTO() {
		super();
	}
	
	public DeltaDTO(String id) {
		super(id);
	}
	
	public DeltaDTO(Delta entity) {
		super(entity);
		this.numerooperacion= entity.getNumerooperacion();
		this.deltas = entity.getDeltas();
		this.descripcion = entity.getDescripcion();
		this.importe = entity.getImporte();
		this.fechaproceso = entity.getFechaproceso();
		this.cobertura = entity.getCobertura();
	}

	@Override
	public Delta fromDTO(Delta entity) {
		if (entity == null) {
			entity = new Delta();
		}
		
		if(numerooperacion != null) {
			entity.setNumerooperacion(this.numerooperacion);
		}
		
		if(deltas!= null) {
			entity.setDeltas(this.deltas);
		}
		
		if(descripcion!=null) {
			entity.setDescripcion(this.descripcion);
		}
		
		if(importe!=null) {
			entity.setImporte(this.importe);
		}
		
		if(fechaproceso!=null) {
			entity.setFechaproceso(this.fechaproceso);
		}
		
		if(cobertura!=null) {
			entity.setCobertura(this.cobertura);
		}
		
		return entity;
	}
	@Override
	public void preactualizar() {
		super.preactualizar();
	}
/**
 * 
 * @param id
 * @param numerooperacion
 * @param deltas
 * @param descripcion
 * @param importe
 * @param fechaproceso
 * @param cobertura
 */
	public DeltaDTO(String id,String numerooperacion, BigDecimal deltas, String descripcion, BigDecimal importe,
			Calendar fechaproceso, BigDecimal cobertura) {
		super(id);
		this.numerooperacion = numerooperacion;
		this.deltas = deltas;
		this.descripcion = descripcion;
		this.importe = importe;
		this.fechaproceso = fechaproceso;
		this.cobertura = cobertura;
	}
	

}
