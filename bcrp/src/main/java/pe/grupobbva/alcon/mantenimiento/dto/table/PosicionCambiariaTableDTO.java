package pe.grupobbva.alcon.mantenimiento.dto.table;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.PosicionCambiariaDTO;
import pe.grupobbva.alcon.mantenimiento.entity.PosicionCambiaria;

@Data
public class PosicionCambiariaTableDTO extends PosicionCambiariaDTO {
	private String tipooperaciondescripcion;
	private String tipoclientedescripcion;
	private String residentedescripcion;
	private String tipoentregadescripcion;
	private String tipocallputdescripcion;
	public PosicionCambiariaTableDTO() {
		super();
	}

	public PosicionCambiariaTableDTO(PosicionCambiaria entity) {
		super(entity);
	}

	public PosicionCambiariaTableDTO(
			String id,
			String codigo, 
			String rubro, 
			String descripcion,
			Integer idproducto,
			String codigobcr,
			String tipooperacion,
			String tipooperaciondescripcion,
			String tipocliente,
			String tipoclientedescripcion,
			String residente, 
			String residentedescripcion, 
			String tipoentrega,
			String tipoentregadescripcion, 
			String callput, 
			String tipocallputdescripcion, 
			String padrerubro,
			Boolean editar, 
			Boolean detalle,
			String descripcionc2) {
		super(id, codigo, rubro, descripcion, idproducto, codigobcr,
				tipooperacion, tipocliente,
				residente,
				tipoentrega,
				callput, padrerubro, editar, detalle,descripcionc2);

		this.tipooperaciondescripcion = tipooperaciondescripcion;
		this.tipoclientedescripcion = tipoclientedescripcion;
		this.residentedescripcion = residentedescripcion;
		this.tipoentregadescripcion = tipoentregadescripcion;
		this.tipocallputdescripcion = tipocallputdescripcion;
	}

}
