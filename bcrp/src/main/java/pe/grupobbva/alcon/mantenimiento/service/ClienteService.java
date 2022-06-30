package pe.grupobbva.alcon.mantenimiento.service;

import java.util.List;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ClienteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.ClienteTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;
import pe.grupobbva.alcon.mantenimiento.entity.CodigoStarAltamira;

public interface ClienteService extends AbstractService<Cliente> {
	
	public DatatableDTO<ClienteTableDTO> search(ClienteSearch client);
	public List<Cliente> listarRechazarCarga();
	public String insertarClienteCarga(Cliente cliente);
	public void actualizarClientesCodigoCentralAltamira(CodigoStarAltamira codigoCentralAltamira);
	public void actualizarClienteHost(Cliente cliente);
	public void procesarClientesInforeport();
	public List<Cliente> obtenerClientesSinAltamira();
}
