package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.mantenimiento.entity.Tasa;
import pe.grupobbva.alcon.mantenimiento.repository.custom.TasaCustomRepository;

public class TasaCustomRepositoryImpl implements TasaCustomRepository {
	
	@Autowired
	private EntityManager em;
	
	@Override
	public void eliminarPorFechaProceso(Tasa tasa) {
		
		 em.createNamedStoredProcedureQuery("SP_BCR_TASAS_DELFECHAPROCESO")
		   .setParameter("P_FECHAPROCESO", tasa.getFechaproceso())
		   .setParameter("P_USUARIOMODIFICACION", tasa.getActualizadoPor())
		   .execute();
		
	}
	
}
