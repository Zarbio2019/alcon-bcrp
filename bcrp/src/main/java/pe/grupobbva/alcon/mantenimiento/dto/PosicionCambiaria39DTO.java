package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CallPut;
import pe.grupobbva.alcon.mantenimiento.entity.PosicionCambiaria39;
import pe.grupobbva.alcon.mantenimiento.entity.Residente;
import pe.grupobbva.alcon.mantenimiento.entity.TipoEntrega;
import pe.grupobbva.alcon.mantenimiento.entity.TipoOperacion;

@Data
public class PosicionCambiaria39DTO extends AbstractDTO<PosicionCambiaria39> {
	
//	private Integer id;
	private Integer idposicioncambiaria;
	private String codigobcr;
	private TipoOperacion tipooperacion;
	private String tipocliente;
	private Residente residente;
	private TipoEntrega tipoentrega;
	private CallPut callput;

	public PosicionCambiaria39DTO() {
		super();
	}

	public PosicionCambiaria39DTO(PosicionCambiaria39 entity) {
		super(entity);
	}

	@Override
	public PosicionCambiaria39 fromDTO(PosicionCambiaria39 entity) {
		if (entity == null) {
			entity = new PosicionCambiaria39();
		}
		return entity;
	}
	
}
