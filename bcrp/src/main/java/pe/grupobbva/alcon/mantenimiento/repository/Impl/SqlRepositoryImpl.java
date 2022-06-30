package pe.grupobbva.alcon.mantenimiento.repository.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.grupobbva.alcon.mantenimiento.repository.SqlRepository;

@Repository
public class SqlRepositoryImpl implements SqlRepository {

	@Autowired
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> select(String sqlSelect){
		return em.createNativeQuery(sqlSelect).getResultList();
	}

	@Override
	@Transactional
	public void query(String query) {
		 em.createNativeQuery(query).executeUpdate();
	}
	
}
