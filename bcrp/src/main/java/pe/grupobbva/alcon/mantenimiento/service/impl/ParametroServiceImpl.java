package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.ParametroResponse;
import pe.grupobbva.alcon.mantenimiento.dto.search.ParametroSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterCode;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterRequestBody;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterTableResponseDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Parametro;
import pe.grupobbva.alcon.mantenimiento.repository.ParametroRepository;
import pe.grupobbva.alcon.mantenimiento.service.ParametroService;

@Service
public class ParametroServiceImpl extends AbstractServiceImpl<Parametro> implements ParametroService {	
	
	@Override
	public SelectOptions<SelectOptionsDTO> type(String codigo) {
		return ((ParametroRepository)repository).type(codigo);
	}

	@Override
	public SelectOptions<SelectOptionsDTO> typeParameter() {
		return ((ParametroRepository)repository).typeParameter();
	}

	@Override
	public ParameterTableResponseDTO search(ParametroSearch parametroSearch) {
		return ((ParametroRepository)repository).search(parametroSearch);
	}

	@Override
	public ParameterTableResponseDTO getParameter(String id) {
		return ((ParametroRepository)repository).getParameter(id);
	}

	@Override
	public ParameterTableResponseDTO getTemplateParameter(ParametroSearch parametroSearch) {
		
		ParameterTableResponseDTO parametroTableResponse = new ParameterTableResponseDTO();
		ParametroResponse newparametroResponse = new ParametroResponse();
		List<ParametroResponse> parametroResponse = new ArrayList<ParametroResponse>();
		
		//Busca idparametroporcodigo
		String idparametro = ((ParametroRepository)repository).getParametroId(parametroSearch.getCodigo()); 
		newparametroResponse.setIdparametro(idparametro);
		
		//Agrega idparametro a la plantilla
		parametroResponse.add(newparametroResponse);
		
		ParameterCode parametercode = new ParameterCode();
		parametroTableResponse.setColumnas(parametercode.getColumns(parametroSearch.getCodigo()));
		parametroTableResponse.setRegistros(parametroResponse);
		
		return parametroTableResponse;
	}
	
	@Override
	public ResponseEntity<Void> create(ParameterRequestBody data) {
		return ((ParametroRepository)repository).create(data);
	}

	@Override
	public ResponseEntity<Void> update(ParameterRequestBody data) {
		return ((ParametroRepository)repository).update(data);
	}
	
}
