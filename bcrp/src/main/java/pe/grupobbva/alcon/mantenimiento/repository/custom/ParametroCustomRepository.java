package pe.grupobbva.alcon.mantenimiento.repository.custom;

import org.springframework.http.ResponseEntity;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.DetalleParametroDTO;
import pe.grupobbva.alcon.mantenimiento.dto.ParametroDTO;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.ParametroResponse;
import pe.grupobbva.alcon.mantenimiento.dto.search.ParametroSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.ParametroTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterCode;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterRequestBody;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterTableResponseDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public interface ParametroCustomRepository {

	public ParameterTableResponseDTO search(ParametroSearch parametroSearch);
	public SelectOptions<SelectOptionsDTO> type(String codigo);
	public SelectOptions<SelectOptionsDTO> typeParameter();
	public ParameterTableResponseDTO getParameter(String id);
	public ResponseEntity<Void> create(ParameterRequestBody data);
	public ResponseEntity<Void> update(ParameterRequestBody data);
}
