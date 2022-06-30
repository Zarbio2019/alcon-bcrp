package pe.grupobbva.alcon.mantenimiento.service;

import java.util.List;

public interface SqlService {

	public List<Object> select(String query);

	public void query(String... query);



}
