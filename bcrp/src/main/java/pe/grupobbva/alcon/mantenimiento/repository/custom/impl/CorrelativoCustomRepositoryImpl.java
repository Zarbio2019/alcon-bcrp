package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.mantenimiento.repository.custom.CorrelativoCustomRepository;

public class CorrelativoCustomRepositoryImpl implements CorrelativoCustomRepository {
	
	@Autowired
	private EntityManager em;

	@Override
	public String generaCorrelativoCompuesto(String nombre) {
		
		StoredProcedureQuery sq = em.createNamedStoredProcedureQuery("SP_BCR_CORREL_GENCOMPUESTO")
		   .setParameter("P_NOMBRECORRELATIVO", nombre);
		
		sq.execute();
		
		return (String) sq.getOutputParameterValue("VALORCORRELATIVO_");
		//return "000000000";
	}
	
}
