package pe.grupobbva.alcon.mantenimiento.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.dto.TransactionDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.Transaction;
import pe.grupobbva.alcon.mantenimiento.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionEndpoint extends AbstractRestController<Transaction, TransactionDTO>{

	public TransactionEndpoint() {
		super(Transaction.class, TransactionDTO.class);
	}

	@GetMapping(produces = "application/json")
	public TransactionDTO search(ReporteSearch reporteSearch){
		return  ((TransactionService)service).search(reporteSearch);
	}
}
