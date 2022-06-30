package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.search.ProductoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.ProductoTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Producto;
import pe.grupobbva.alcon.mantenimiento.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoEndpoint extends AbstractRestController<Producto, ProductoTableDTO> {
	
	public ProductoEndpoint() {
		super(Producto.class, ProductoTableDTO.class);
	}
	
	@GetMapping(produces = "application/json" )
	public DatatableDTO<ProductoTableDTO> search(ProductoSearch productoSearch){
		return  ((ProductoService)service).search(productoSearch);
		
	}
	
	@GetMapping("/listar")
	public SelectOptions<SelectOptionsDTO> listOptions(){	
		return ((ProductoService)service).listOptions();
	}
}
