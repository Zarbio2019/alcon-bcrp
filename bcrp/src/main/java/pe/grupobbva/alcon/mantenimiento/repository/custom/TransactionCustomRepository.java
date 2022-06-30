package pe.grupobbva.alcon.mantenimiento.repository.custom;

import pe.grupobbva.alcon.mantenimiento.dto.TransactionDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;

public interface TransactionCustomRepository {
	public TransactionDTO search(ReporteSearch reporteSearch);
}
