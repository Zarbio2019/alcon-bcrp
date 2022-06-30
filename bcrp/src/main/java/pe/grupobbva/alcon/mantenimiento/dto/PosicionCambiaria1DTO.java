package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CallPut;
import pe.grupobbva.alcon.mantenimiento.entity.PosicionCambiaria1;
import pe.grupobbva.alcon.mantenimiento.entity.Residente;
import pe.grupobbva.alcon.mantenimiento.entity.TipoEntrega;
import pe.grupobbva.alcon.mantenimiento.entity.TipoOperacion;

@Data
public class PosicionCambiaria1DTO extends AbstractDTO<PosicionCambiaria1> {
	
	private Integer idposicioncambiaria;
	private String codigo;
	private String rubro;
	private String descripcion;
	private Integer idproducto;
	private String codigobcr;
	private TipoOperacion tipooperacion;
	private String tipocliente;
	private Residente residente;
	private TipoEntrega tipoentrega;
	private CallPut callput;
	private String padrerubro;
	private Integer codigoestado;
	
	public PosicionCambiaria1DTO() {
		super();
	}

	public PosicionCambiaria1DTO(PosicionCambiaria1 entity) {
		super(entity);
	}

	@Override
	public PosicionCambiaria1 fromDTO(PosicionCambiaria1 entity) {
		if (entity == null) {
			entity = new PosicionCambiaria1();
		}
		return entity;
	}
	
}
