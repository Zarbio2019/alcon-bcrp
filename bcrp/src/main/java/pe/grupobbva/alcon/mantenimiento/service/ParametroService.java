package pe.grupobbva.alcon.mantenimiento.service;

import org.springframework.http.ResponseEntity;

import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.search.ParametroSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterRequestBody;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterTableResponseDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Parametro;

public interface ParametroService extends AbstractService<Parametro> {

	public SelectOptions<SelectOptionsDTO> type(String codigo);

	public SelectOptions<SelectOptionsDTO> typeParameter();

	public ParameterTableResponseDTO search(ParametroSearch parametroSearch);

	public ParameterTableResponseDTO getParameter(String id);
	
	public ParameterTableResponseDTO getTemplateParameter(ParametroSearch parametroSearch);

	public ResponseEntity<Void> create(ParameterRequestBody data);
	
	public ResponseEntity<Void> update(ParameterRequestBody data);

}
