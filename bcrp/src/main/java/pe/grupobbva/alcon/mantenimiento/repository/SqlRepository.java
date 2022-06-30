package pe.grupobbva.alcon.mantenimiento.repository;

import java.util.List;

public interface SqlRepository {

	public List<Object> select(String sqlSelect);

	public void query(String query);
}
