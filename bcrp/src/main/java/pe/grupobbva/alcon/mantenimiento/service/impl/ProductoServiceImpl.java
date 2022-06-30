package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.beans.Codigoestado;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.search.ProductoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.ProductoTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Producto;
import pe.grupobbva.alcon.mantenimiento.repository.ProductoRepository;
import pe.grupobbva.alcon.mantenimiento.service.ProductoService;

@Service
public class ProductoServiceImpl extends AbstractServiceImpl<Producto> implements ProductoService {
	
	@Override
	public DatatableDTO<ProductoTableDTO> search(ProductoSearch productoSearch) {
		return ((ProductoRepository)repository).search(productoSearch);
	}

	@Override
	public SelectOptions<SelectOptionsDTO> listOptions() {
		return ((ProductoRepository)repository).listOptions();
	}
	
	@Override
	public void guardar(Producto entity) {
		Long registros = ((ProductoRepository)repository).productosDuplicados(entity.getCodigo(),entity.getCodigoestado());
		
		if(registros>0l) {
			ValidatorUtil.validateMessage("codigo", "Código Duplicado");
		}		
		super.guardar(entity);
	}
	
	@Override
	public void actualizar(Producto entity) {
		Long registros = ((ProductoRepository)repository).productosDuplicadosActualizar(entity.getCodigo(),entity.getCodigoestado(),entity.getId());
		
		if(registros>0l) {
			ValidatorUtil.validateMessage("codigo", "Código Duplicado");
		}
		super.actualizar(entity);
	}
	
	@Override
	public void eliminar(Producto entity) {
		Long registros = ((ProductoRepository)repository).productosExistentesActualizar(entity.getId());
		
		if(registros < 1l) {
			ValidatorUtil.validateMessage("id", "id No Existe");
		}
		
		if(entity.getCodigoestado().equals(Codigoestado.INACTIVO.getCodigoestado())) {
			ValidatorUtil.validateMessage("codigoestado", "El registro ya fue borrado");
		}
		
		
		super.eliminar(entity);
	}

	@Override
	public Producto obtenerProductoPorCodigo(String codigo) {
		Long registros = ((ProductoRepository)repository).productosExistentesPorCodigo(codigo);
		
		if(registros < 1l) {
			ValidatorUtil.validateMessage("producto", "Producto " + codigo + " no existe");
		}
		
		return ((ProductoRepository) repository).obtenerProductoPorCodigo(codigo);
	}

}
