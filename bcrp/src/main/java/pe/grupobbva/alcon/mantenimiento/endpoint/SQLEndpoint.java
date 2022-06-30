package pe.grupobbva.alcon.mantenimiento.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;
import pe.grupobbva.alcon.mantenimiento.service.SqlService;

@RestController
@RequestMapping("/sqltemporal")
public class SQLEndpoint extends ReportFilter {

	@Autowired
	private SqlService sqlservice;
	
	@PostMapping(path = "/select", produces = "application/json")
	public List<Object> from(@RequestBody String query){
		return sqlservice.select(query);
	}
	
	@PostMapping(path = "/insert")
	public void insertUpdate(@RequestBody String query){
		sqlservice.query(query.split(";"));
	}
	
}
