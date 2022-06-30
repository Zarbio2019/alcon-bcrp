package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CfgRCD02;

@Data
public class CfgRCD02DTO extends AbstractDTO<CfgRCD02> {
	private String filainicio;
	private String filafin;
	private String divisa;
	private String cuenta;
	
	public CfgRCD02DTO() {
		super();
	}
	public CfgRCD02DTO(String id) {
		super(id);
	}
	public CfgRCD02DTO(String id, String filainicio, String filafin, String divisa, String cuenta) {
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
	public CfgRCD02 fromDTO(CfgRCD02 entity) {
		// TODO Auto-generated method stub
		if(entity == null) {
			entity = new CfgRCD02();
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
