package pe.grupobbva.alcon.mantenimiento.repository.custom;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.SaldoContableSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.SaldoContableTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;

public interface SaldoContableCustomRepository {
	
	public DatatableDTO<SaldoContableTableDTO> search(SaldoContableSearch saldoContableSearch);
	public void saldoContableActualizarEstadoGrupo(Carga carga, Integer codigoestado);
}
