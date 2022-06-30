package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.custom.OperacionCalculate;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.OperacionCalculateResponse;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionInternaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacionInternaTableDTO;
import pe.grupobbva.alcon.mantenimiento.repository.custom.OperacionInternaCustomRepository;

public class OperacionInternaCustomRepositoryImpl implements OperacionInternaCustomRepository {
	
	@Autowired
	private EntityManager em;
	
	private static final Logger log = LogManager.getLogger();
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<OperacionInternaTableDTO> search(OperacionInternaSearch operacionSearch){
		
		List<OperacionInternaTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_OPERACION_LISTARINTERNA")
				.setParameter("P_FECHACONTRATACION", operacionSearch.getFechacontratacion())
				.getResultList();
		
		return new DatatableDTO<>(
				operacionSearch.getDraw(), 
					Long.valueOf(resultados != null ? resultados.size(): 0 ),
					Utils.paginador(resultados, operacionSearch)
				);
	}
	
	public OperacionCalculateResponse calculate(OperacionCalculate calculate) {
		OperacionCalculateResponse response = new OperacionCalculateResponse();
		BigDecimal cambioRef = calculate.getCambioReferencial();
		BigDecimal importeEnt = calculate.getImporteEntrada();
		
		if (calculate.getTipoOperacion().equals("Compra")) {
			response.setImporteSalida(importeEnt.multiply(cambioRef).setScale(2, BigDecimal.ROUND_HALF_EVEN));
			response.setImporteDolares(importeEnt);
		} else if (calculate.getTipoOperacion().equals("Venta")) {
			response.setImporteSalida( importeEnt.divide(cambioRef, 2 , BigDecimal.ROUND_HALF_EVEN));
			response.setImporteDolares(response.getImporteSalida());
		}
		
		return new OperacionCalculateResponse(response.getImporteSalida(), response.getImporteDolares());
	}
	
}
