package pe.grupobbva.alcon.mantenimiento.repository;

import pe.grupobbva.alcon.mantenimiento.entity.Transaction;
import pe.grupobbva.alcon.mantenimiento.repository.custom.TransactionCustomRepository;

public interface TransactionRepository  extends AbstractRepository<Transaction>, TransactionCustomRepository{
	
}
