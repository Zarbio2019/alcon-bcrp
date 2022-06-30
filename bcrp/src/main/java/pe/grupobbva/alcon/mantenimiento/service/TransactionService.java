package pe.grupobbva.alcon.mantenimiento.service;

import pe.grupobbva.alcon.mantenimiento.dto.TransactionDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.entity.Transaction;

public interface TransactionService extends AbstractService<Transaction>{
	public TransactionDTO search(ReporteSearch reporteSearch);
}
