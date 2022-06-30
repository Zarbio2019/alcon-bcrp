package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CfgPosRF;

@Data
public class CfgPosRFDTO extends AbstractDTO<CfgPosRF>{
	private String cartera;
	private String clase;
	private String divisa;
	private String importe;
	private String cuenta;

	public CfgPosRFDTO() {
		super();
	}
	public CfgPosRFDTO(String id) {
		super(id);
	}
	
	public CfgPosRFDTO(String id, String cartera, String clase, String divisa, String importe, String cuenta ) {
		super(id);
		this.cartera = cartera;
		this.clase = clase;
		this.divisa = divisa;
		this.importe = importe;
		this.cuenta = cuenta;
	}
	
	@Override
	public CfgPosRF fromDTO(CfgPosRF entity) {
		
		if(entity == null) {
			entity = new CfgPosRF();
		}
		
		if(cartera != null) {
			entity.setCartera(cartera);
		}
		if(clase != null) {
			entity.setClase(clase);
		}
		if(divisa != null) {
			entity.setDivisa(divisa);
		}
		if(importe != null) {
			entity.setImporte(importe);
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
