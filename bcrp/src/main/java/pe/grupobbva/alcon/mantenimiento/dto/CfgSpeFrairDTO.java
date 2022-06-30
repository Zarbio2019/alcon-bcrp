package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CfgSpeFrair;

@Data
public class CfgSpeFrairDTO extends AbstractDTO<CfgSpeFrair> {
	private String subproducto;
	private String operacion;
	private String divisa;
	private String importe;
	private String recibo;
	private String cuenta;
	
	public CfgSpeFrairDTO() {
		super();
	}
	public CfgSpeFrairDTO(String id) {
		super(id);
	}
	public CfgSpeFrairDTO(String id, String subproducto,String operacion, String divisa, String importe, String recibo, String cuenta) {
		super(id);
		this.subproducto = subproducto;
		this.operacion = operacion;
		this.divisa = divisa;
		this.importe = importe;
		this.recibo = recibo;
		this.cuenta = cuenta;
	}
	public CfgSpeFrairDTO(CfgSpeFrair entity) {
		super(entity);
		this.subproducto = entity.getSubproducto();
		this.operacion = entity.getOperacion();
		this.divisa = entity.getDivisa();
		this.importe = entity.getImporte();
		this.recibo = entity.getRecibo();
		this.cuenta = entity.getCuenta();
	}
	@Override
	public CfgSpeFrair fromDTO(CfgSpeFrair entity) {
		if(entity == null) {
			entity = new CfgSpeFrair();
		}
		
		if(subproducto != null) {
			entity.setSubproducto(subproducto);
		}
		if(operacion != null) {
			entity.setOperacion(operacion);
		}
		if(divisa != null) {
			entity.setDivisa(divisa);
		}
		if(importe != null) {
			entity.setImporte(importe);
		}
		if(recibo != null) {
			entity.setRecibo(recibo);
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
