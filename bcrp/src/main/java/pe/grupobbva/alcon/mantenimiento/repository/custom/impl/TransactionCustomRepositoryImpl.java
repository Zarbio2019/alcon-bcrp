package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.mantenimiento.dto.TransactionDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteDosExcelC2DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.repository.custom.TransactionCustomRepository;

public class TransactionCustomRepositoryImpl implements TransactionCustomRepository{
	
	@Autowired
	private EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	public TransactionDTO search(ReporteSearch reporteSearch) {
		
		List<TransactionDTO> resultados = em.createNamedStoredProcedureQuery("SP_BCR_TRANSACTION")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.setParameter("P_TIPOPROCESO", StringUtils.isBlank(reporteSearch.getTipoproceso()) ? "D" : reporteSearch.getTipoproceso())
				.getResultList();
		
		return resultados.size() == 0 ? null : resultados.get(0);
		
	}

}
