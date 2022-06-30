package pe.grupobbva.alcon.mantenimiento.dto.table;

import pe.grupobbva.alcon.mantenimiento.dto.CfgFxVigenteDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CfgFxVigente;

public class CfgFxVigenteTableDTO extends CfgFxVigenteDTO {
	public CfgFxVigenteTableDTO() {
		super();
	}
	public CfgFxVigenteTableDTO(String id) {
		super(id);
	}
	public CfgFxVigenteTableDTO(CfgFxVigente entity) {
		super(entity);
	}
}
