package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CfgFxVigente;

@Data
public class CfgFxVigenteDTO extends AbstractDTO<CfgFxVigente> {

	private String subproducto;
	private String operacion;
	private String fechaVencimiento;
	private String divisa;
	private String cuenta;
	
	public CfgFxVigenteDTO(String id, String subproducto, String operacion, String fechaVencimiento, String divisa, String cuenta) {
		super(id);
		this.subproducto = subproducto;
		this.operacion = operacion;
		this.fechaVencimiento = fechaVencimiento;
		this.divisa = divisa;
		this.cuenta = cuenta;
	}
	
	public CfgFxVigenteDTO() {
		super();
	}
	
	public CfgFxVigenteDTO(String id) {
		super(id);
	}
	
	public CfgFxVigenteDTO(CfgFxVigente entity) {
		
		super(entity);
		this.subproducto = entity.getSubproducto();
		this.operacion = entity.getOperacion();
		this.fechaVencimiento = entity.getFecha_vencimiento();
		this.divisa = entity.getDivisa();
		this.cuenta = entity.getCuenta();
	}

	@Override
	public CfgFxVigente fromDTO(CfgFxVigente entity) {
		// TODO Auto-generated method stub
		
		if(entity == null) {
			entity = new CfgFxVigente();
		}
		
		if(subproducto != null) {
			entity.setSubproducto(subproducto);
		}
		if(operacion != null) {
			entity.setOperacion(operacion);
		}
		if(fechaVencimiento != null) {
			entity.setFecha_vencimiento(fechaVencimiento);
		}
		if(divisa != null) {
			entity.setDivisa(divisa);
		}
		if(cuenta != null) {
			entity.setCuenta(cuenta);
		}
		return entity;
	}
	
	@Override
	public void preactualizar() {
		super.preactualizar();
	}
}
