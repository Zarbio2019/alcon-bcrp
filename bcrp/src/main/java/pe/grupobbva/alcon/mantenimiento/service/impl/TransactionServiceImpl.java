package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.dto.TransactionDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.entity.Transaction;
import pe.grupobbva.alcon.mantenimiento.repository.TransactionRepository;
import pe.grupobbva.alcon.mantenimiento.service.TransactionService;

@Service
public class TransactionServiceImpl extends AbstractServiceImpl<Transaction> implements TransactionService{

	@Override
	public TransactionDTO search(ReporteSearch reporteSearch) {
		return ((TransactionRepository) repository).search(reporteSearch);
	}

}
