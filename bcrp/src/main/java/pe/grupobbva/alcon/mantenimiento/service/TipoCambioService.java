package pe.grupobbva.alcon.mantenimiento.service;

import java.math.BigDecimal;
import java.util.Calendar;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.TipoCambioSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.TipoCambioTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCambio;

public interface TipoCambioService extends AbstractService<TipoCambio> {

	public DatatableDTO<TipoCambioTableDTO> search(TipoCambioSearch tipoCambioSearch);
	public void copiarUltimo(Calendar fecha);
	public BigDecimal listarFechaDivisa(Calendar fecha, String codigoDivisa);
	public void actualizarInsertar(TipoCambio tipocambio);
}
