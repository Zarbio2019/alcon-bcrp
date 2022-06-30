package pe.grupobbva.alcon.mantenimiento.service.impl;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.DivisaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.DivisaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.repository.DivisaRepository;
import pe.grupobbva.alcon.mantenimiento.service.DivisaService;

@Service
public class DivisaServiceImpl extends AbstractServiceImpl<Divisa> implements DivisaService {
	
	private static final Logger log = LogManager.getLogger();
	
	@Override
	public DatatableDTO<DivisaDTO> search(DivisaSearch divisaSearch) {
		return ((DivisaRepository)repository).search(divisaSearch);
	}

	@Override
	public SelectOptions<SelectOptionsDTO> listOptions() {
		return ((DivisaRepository)repository).listOptions();
	}
	
	@Override
	public Divisa obtenerDivisaPorCodigo(String codigo) {
		return ((DivisaRepository) repository).obtenerDivisaPorCodigo(codigo);
	}
	
	@Override
	public Long divisaExistentes(String codigo) {
		return ((DivisaRepository) repository).divisaExistentes(codigo);
	}

	@Override
	public Divisa obtenerDivisaPorId(String id) {
		return ((DivisaRepository) repository).obtenerDivisaPorId(id);
	}
	
	@Override
	public void guardar(Divisa entity) {
		Long registros = ((DivisaRepository)repository).divisaExistentes(entity.getCodigo());
		log.info("Numero de registros: " + registros);
		if(registros > 0l) {
			ValidatorUtil.validateMessage("codigo", "Código Duplicado");
		}		
		super.guardar(entity);
	}
	
	@Override
	public void actualizar(Divisa entity) {
		Long registros = ((DivisaRepository)repository).divisaExistenteActualizar(entity.getCodigo(), entity.getId());
		
		if(registros > 0l) {
			ValidatorUtil.validateMessage("codigo", "Código Duplicado");
		}
		super.actualizar(entity);
	}
}
