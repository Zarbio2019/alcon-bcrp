package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionOtrosDerivadosDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionSearch;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.repository.custom.OperacionDerivadoCustomRepository;

public class OperacionDerivadoCustomRepositoryImpl implements OperacionDerivadoCustomRepository{
	
	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<OperacionOtrosDerivadosDTO> search(OperacionSearch operacionSearch){
		List<OperacionOtrosDerivadosDTO> resultados =
				em.createNamedStoredProcedureQuery("SP_BCR_OPE_DERIVADO_LISTAR")
				.setParameter("P_CODIGOREPORTE", operacionSearch.getCodigoreporte())
				.setParameter("P_NUMEROOPERACION", operacionSearch.getNumerooperacion())
				.setParameter("P_FECHAPROCESO", operacionSearch.getFechavalor())
				.setParameter("P_IDPRODUCTO", "c9668b69-6e9c-43fd-8747-f4f76b1b8def")
				.setParameter("P_CODIGOCLIENTE", operacionSearch.getCodigocliente())
				.setParameter("P_NOMBRECLIENTE", operacionSearch.getNombrecliente())
				.setParameter("P_OBSERVACIONES", operacionSearch.getEstado().equals("-2")?" ":operacionSearch.getEstado())
				.setParameter("P_TIPOPROCESO", "D")
				.getResultList();				
		
		return new DatatableDTO<>(
				operacionSearch.getDraw(), 
					Long.valueOf(resultados != null ? resultados.size(): 0 ),
					Utils.paginador(resultados, operacionSearch)
				);
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OperacionOtrosDerivadosDTO> searchList(OperacionSearch operacionSearch){
		return 	em.createNamedStoredProcedureQuery("SP_BCR_OPE_DERIVADO_LISTAR")
				.setParameter("P_CODIGOREPORTE", operacionSearch.getCodigoreporte())
				.setParameter("P_NUMEROOPERACION", operacionSearch.getNumerooperacion())
				.setParameter("P_FECHAPROCESO", operacionSearch.getFechavalor())
				.setParameter("P_IDPRODUCTO", "c9668b69-6e9c-43fd-8747-f4f76b1b8def")
				.setParameter("P_CODIGOCLIENTE", operacionSearch.getCodigocliente())
				.setParameter("P_NOMBRECLIENTE", operacionSearch.getNombrecliente())
				.setParameter("P_OBSERVACIONES", operacionSearch.getEstado().equals("-2")?" ":operacionSearch.getEstado())
				.setParameter("P_TIPOPROCESO", "D")
				.getResultList();			
	}	
	
	@Override
	public void generarCodigoReporteDerivados(Carga carga) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_OPE_DERI_GENCODREP")
		   .setParameter("P_FECHAPROCESO", new Date(carga.getFecha().getTimeInMillis()))
		   .setParameter("P_TIPOPROCESO", carga.getTipoproceso())
		   .setParameter("P_USUARIOMODIFICACION", carga.getCreadoPor())
		   .execute();	
	}
	
	@Override
	public void generaUsuariosDivas(Carga carga) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_OPE_DERI_DETALLECODDIVA")
		   .setParameter("P_FECHAPROCESO", new Date(carga.getFecha().getTimeInMillis()))
		   .setParameter("P_TIPOPROCESO", carga.getTipoproceso())
		   .setParameter("P_USUARIOCREACION", carga.getCreadoPor())
		   .execute();
		
	}
}
