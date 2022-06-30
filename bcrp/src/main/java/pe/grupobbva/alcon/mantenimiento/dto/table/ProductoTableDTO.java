package pe.grupobbva.alcon.mantenimiento.dto.table;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.ProductoDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Producto;

@Data
public class ProductoTableDTO extends ProductoDTO {
	
	private String tipoEntregaDescripcion;
	
	public ProductoTableDTO() {
		super();
	}
	
	public ProductoTableDTO(String id) {
		super(id);
	}

	public ProductoTableDTO(Producto entity) {
		super(entity);
	}

	
	public ProductoTableDTO(String id, String codigo, String descripcion, String nombreproducto, String codigobcr,
			String tipooperacion, String tipoentrega, String rechazarcarga, Integer codigoestado,
			String tipoEntregaDescripcion) {

		super(id, codigo, descripcion, nombreproducto, codigobcr, tipooperacion, tipoentrega, rechazarcarga,
				codigoestado);

		this.tipoEntregaDescripcion = tipoEntregaDescripcion;
	}

}
