package pe.grupobbva.alcon.mantenimiento.dto.table;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.OficinaDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Oficina;

@Data
public class OficinaTableDTO extends OficinaDTO {

	private String detalleposicioncambiaria;

	public OficinaTableDTO() {
		super();
	}
	
	public OficinaTableDTO(String id) {
		super(id);
	}

	public OficinaTableDTO(Oficina entity) {
		super(entity);
	}

	/**
	 * 
	 * @param id
	 * @param codigo
	 * @param descripcion
	 * @param posicioncambiaria
	 * @param codigoestado
	 * @param detalledescripcion
	 */
	public OficinaTableDTO(String id, String codigo, String descripcion, String posicioncambiaria, Integer codigoestado,
			String detalleposicioncambiaria) {

		super(id, codigo, descripcion, posicioncambiaria, codigoestado);

		this.detalleposicioncambiaria = detalleposicioncambiaria;
	}

}
