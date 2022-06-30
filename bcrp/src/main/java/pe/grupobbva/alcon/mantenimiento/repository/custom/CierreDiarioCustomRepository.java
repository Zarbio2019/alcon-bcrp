package pe.grupobbva.alcon.mantenimiento.repository.custom;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CierreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CierreDiarioSearch;

public interface CierreDiarioCustomRepository {
	public DatatableDTO<CierreDiarioDTO> search(CierreDiarioSearch cierreDiarioSearch);
}
