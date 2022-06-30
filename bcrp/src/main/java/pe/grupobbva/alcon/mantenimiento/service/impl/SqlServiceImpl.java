package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.repository.SqlRepository;
import pe.grupobbva.alcon.mantenimiento.service.SqlService;

@Service
public class SqlServiceImpl implements SqlService{
	
	@Autowired
	private SqlRepository sqlRepository;

	@Override
	public List<Object> select(String query) {
		return sqlRepository.select(query);
	}

	@Override
	public void query(String... querys) {
		for(String query:querys) {
			sqlRepository.query(query);	
		}
		
		
	}
	
	
	

}
