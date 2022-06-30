package pe.grupobbva.alcon.mantenimiento.service;

import java.util.Calendar;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.SaldoContableSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.SaldoContableTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.SaldoContable;

public interface SaldoContableService extends AbstractService<SaldoContable> {

	public DatatableDTO<SaldoContableTableDTO> search(SaldoContableSearch saldoContableSearch);
	public void copiarUltimo(Calendar fecha);
	public void saldoContableActualizarEstadoGrupo(Carga carga, Integer codigoestado);
	
}
