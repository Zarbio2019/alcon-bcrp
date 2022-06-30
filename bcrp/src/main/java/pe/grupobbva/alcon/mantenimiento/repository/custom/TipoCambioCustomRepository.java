package pe.grupobbva.alcon.mantenimiento.repository.custom;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.TipoCambioSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.TipoCambioTableDTO;

public interface TipoCambioCustomRepository {
	
	public DatatableDTO<TipoCambioTableDTO> search(TipoCambioSearch tipoCambioSearch );

}
