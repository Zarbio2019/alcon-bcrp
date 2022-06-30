package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CfgRCD07;

@Data
public class CfgRCD07DTO extends AbstractDTO<CfgRCD07> {
	private String filainicio;
	private String filafin;
	private String divisa;
	private String cuenta;
	
	public CfgRCD07DTO() {
		super();
	}
	public CfgRCD07DTO(String id) {
		super(id);
	}
	public CfgRCD07DTO(String id, String filainicio, String filafin, String divisa, String cuenta) {
		super(id);
		this.filainicio = filainicio;
		this.filafin = filafin;
		this.divisa =divisa;
		this.cuenta = cuenta;
	}
	@Override
	public void preactualizar() {
		super.preactualizar();
	}
	@Override
	public CfgRCD07 fromDTO(CfgRCD07 entity) {
		// TODO Auto-generated method stub
		if(entity == null) {
			entity = new CfgRCD07();
		}
		if(filainicio != null) {
			entity.setFilainicio(filainicio);
		}
		if(filafin != null) {
			entity.setFilafin(filafin);
		}
		if(divisa != null) {
			entity.setDivisa(divisa);
		}
		if(cuenta != null) {
			entity.setCuenta(cuenta);
		}
		return entity;
	}
}
