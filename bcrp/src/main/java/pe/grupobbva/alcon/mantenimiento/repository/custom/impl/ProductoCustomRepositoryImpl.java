package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.search.ProductoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.ProductoTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Producto;
import pe.grupobbva.alcon.mantenimiento.repository.custom.ProductoCustomRepository;

public class ProductoCustomRepositoryImpl implements ProductoCustomRepository {

	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ProductoTableDTO> search(ProductoSearch productoSearch) {

		List<ProductoTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_PRODUCTO_LISTAR")
				.setParameter("P_DESCRIPCION", productoSearch.getDescripcion())
				.getResultList();
		
		return new DatatableDTO<>(
				productoSearch.getDraw(), 
					Long.valueOf(resultados != null ? resultados.size(): 0 ),
					Utils.paginador(resultados, productoSearch)
				);

	}
	
	public SelectOptions<SelectOptionsDTO> listOptions(){
		
		CriteriaBuilder cb = em.getCriteriaBuilder();

		/** Begin create query */
		CriteriaQuery<SelectOptionsDTO> cq = cb.createQuery(SelectOptionsDTO.class);
		
		/** Begin FROM Y JOINS */
		Root<Producto> producto = cq.from(Producto.class);
		
		/** Begin where */
		
		cq.where(cb.equal(producto.get("codigoestado"), 1));
		
		/** Begin orderBy */
		cq.orderBy(cb.asc(producto.get("codigo")));
		
		/** Begin Select */
		cq.select(cb.construct(SelectOptionsDTO.class,
				producto.get("id")	,
				producto.get("codigo")
						
			));
		
		TypedQuery<SelectOptionsDTO> query = em.createQuery(cq);
		
		return new SelectOptions<>(query.getResultList()) ;
	}
}
