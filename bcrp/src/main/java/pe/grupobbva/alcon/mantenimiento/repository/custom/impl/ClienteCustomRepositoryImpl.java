package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ClienteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.ClienteTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;
import pe.grupobbva.alcon.mantenimiento.repository.custom.ClienteCustomRepository;


public class ClienteCustomRepositoryImpl implements ClienteCustomRepository {

	@Autowired
	private EntityManager em;

	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<ClienteTableDTO> search(ClienteSearch clienteSearch) {

		List<ClienteTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_CLIENTE_LISTAR")
				.setParameter("P_CODIGO", clienteSearch.getCodigo())
				.setParameter("P_NOMBRE", clienteSearch.getNombre())
				.setParameter("P_TIPOCLIENTE", StringUtils.isBlank(clienteSearch.getTipocliente())?"-2":clienteSearch.getTipocliente())
				.setParameter("P_CLIENTENOREGISTRADO", clienteSearch.getClienteregistrado())
				.getResultList();
		
		return new DatatableDTO<>(
					clienteSearch.getDraw(), 
					Long.valueOf(resultados!=null ? resultados.size(): 0 ),
					Utils.paginador(resultados, clienteSearch)
				);

	}


	@Override
	public String insertarClienteCarga(Cliente cliente) {
		
		StoredProcedureQuery sq = em.createNamedStoredProcedureQuery("SP_BCR_CLIENTE_INSERTARCARGA")
		   .setParameter("P_CODIGO", cliente.getCodigo())
		   .setParameter("P_NOMBRE", cliente.getNombre())
		   .setParameter("P_ENTIDAD", cliente.getEntidad())
		   .setParameter("P_PAISRESIDENCIA", cliente.getPaisresidencia())
		   .setParameter("P_RIESGOPAIS", cliente.getRiesgopais())
		   .setParameter("P_ALTAMIRA", cliente.getAltamira())
		   .setParameter("P_PLAZA", cliente.getPlaza())
		   .setParameter("P_SECTOR", cliente.getSector())
		   .setParameter("P_NOMBRECORTO", cliente.getNombrecorto())
		   .setParameter("P_RECHAZARCARGA", cliente.getRechazarcarga())
		   .setParameter("P_TIPOCLIENTE", cliente.getTipocliente())
		   .setParameter("P_USUARIOCREACION", cliente.getCreadoPor());
		
		sq.execute();
		
		return (String) sq.getOutputParameterValue("IDCLIENTEOUT_");
	 
	}
}
