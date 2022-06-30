package pe.grupobbva.alcon.mantenimiento.dto;

import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Transaction;

@Data
public class TransactionDTO extends AbstractDTO<Transaction>{
	
	private Calendar fechaproceso;
	private String tipoproceso;
	private String tabla;
	private Calendar inicia;
	private Calendar termina;
	private Integer procesostotales;
	private Integer procesosactuales;
	private String descripcion;
	private Integer estado;
	
	public TransactionDTO() {
		super();
	}
	
	public TransactionDTO(String id) {
		super(id);
	}
	
	public TransactionDTO(Transaction entity) {
		super(entity);
		this.fechaproceso = entity.getFechaProceso();
		this.tipoproceso = entity.getTipoProceso();
		this.tabla = entity.getTabla();
		this.inicia = entity.getInicia();
		this.termina = entity.getTermina();
		this.procesostotales = entity.getProcesosTotales();
		this.procesosactuales = entity.getProcesosActuales();
		this.descripcion = entity.getDescripcion();
		this.estado = entity.getEstado();
	}
	
	
	@Override
	public Transaction fromDTO(Transaction entity) {
		if(entity == null) {
			entity = new  Transaction();
		}
		
		if(fechaproceso != null) {
			entity.setFechaProceso(this.fechaproceso);
		}
		
		if(tipoproceso != null) {
			entity.setTipoProceso(this.tipoproceso);
		}
		
		if(tabla != null) {
			entity.setTabla(this.tabla);
		}
		
		if(inicia != null) {
			entity.setInicia(this.inicia);
		}
		
		if(termina != null) {
			entity.setTermina(this.termina);
		}
		
		if(procesostotales != null) {
			entity.setProcesosTotales(this.procesostotales);
		}
		
		if(procesosactuales != null) {
			entity.setProcesosActuales(this.procesosactuales);
		}
		
		if(descripcion != null) {
			entity.setDescripcion(this.descripcion);
		}
		
		if(estado != null) {
			entity.setEstado(this.estado);
		}
		
		return entity;
	}


	@Override
	public void preactualizar() {
		super.preactualizar();
	}
	

	public TransactionDTO(String id,Calendar fechaproceso, String tipoproceso, String tabla, Calendar inicia, Calendar termina,
			Integer procesostotales, Integer procesosactuales, String descripcion, Integer estado) {
		super(id);
		this.fechaproceso = fechaproceso;
		this.tipoproceso = tipoproceso;
		this.tabla = tabla;
		this.inicia = inicia;
		this.termina = termina;
		this.procesostotales = procesostotales;
		this.procesosactuales = procesosactuales;
		this.descripcion = descripcion;
		this.estado = estado;
	}
	
	public TransactionDTO(Calendar fechaproceso, String tipoproceso, String tabla, Calendar inicia, Calendar termina,
			Integer procesostotales, Integer procesosactuales, String descripcion, Integer estado) {
		super();
		this.fechaproceso = fechaproceso;
		this.tipoproceso = tipoproceso;
		this.tabla = tabla;
		this.inicia = inicia;
		this.termina = termina;
		this.procesostotales = procesostotales;
		this.procesosactuales = procesosactuales;
		this.descripcion = descripcion;
		this.estado = estado;
	}

}
