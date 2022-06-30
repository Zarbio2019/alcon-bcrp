package pe.grupobbva.alcon.mantenimiento.repository.custom;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.search.ProductoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.ProductoTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;

public interface ProductoCustomRepository {

	public DatatableDTO<ProductoTableDTO> search(ProductoSearch productoSearch);

	public SelectOptions<SelectOptionsDTO> listOptions();

}
