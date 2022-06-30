package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.search.ProductoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.ProductoTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Producto;

public interface ProductoService extends AbstractService<Producto> {
	
	public DatatableDTO<ProductoTableDTO> search(ProductoSearch productoSearch);
	public SelectOptions<SelectOptionsDTO> listOptions();
	public Producto obtenerProductoPorCodigo(String codigo);

}
