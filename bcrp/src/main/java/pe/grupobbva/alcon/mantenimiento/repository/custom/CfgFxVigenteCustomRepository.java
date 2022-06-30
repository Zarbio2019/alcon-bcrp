package pe.grupobbva.alcon.mantenimiento.repository.custom;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgFxVigenteDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgFxVigenteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.CfgFxVigenteTableDTO;

public interface CfgFxVigenteCustomRepository {
	public DatatableDTO<CfgFxVigenteDTO> search(CfgFxVigenteSearch cfgFxVigenteSearch);
}
