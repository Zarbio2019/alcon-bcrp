package pe.grupobbva.alcon.mantenimiento.repository.custom;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ClienteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.ClienteTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;

public interface ClienteCustomRepository {

	public DatatableDTO<ClienteTableDTO> search(ClienteSearch clientSearch);
	public String insertarClienteCarga(Cliente cliente);

}
