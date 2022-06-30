package pe.grupobbva.alcon.mantenimiento.service.impl;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.search.PosicionCambiariaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.PosicionCambiariaTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.PosicionCambiaria;
import pe.grupobbva.alcon.mantenimiento.repository.PosicionCambiariaRepository;
import pe.grupobbva.alcon.mantenimiento.service.PosicionCambiariaService;

@Service
public class PosicionCambiariaServiceImpl extends AbstractServiceImpl<PosicionCambiaria> implements PosicionCambiariaService {

	private static final Logger log = LogManager.getLogger();
	
	@Override
	public DatatableDTO<PosicionCambiariaTableDTO> search(PosicionCambiariaSearch posicionCambiariaSearch) {
		return ((PosicionCambiariaRepository)repository).search(posicionCambiariaSearch);
	}

	@Override
	public void guardar(PosicionCambiaria entity) {
		Long registros = ((PosicionCambiariaRepository)repository).posicionCambiariaExistentes(entity.getCodigo());
		log.info("Numero de registros: " + registros);
		if(registros > 0l) {
			ValidatorUtil.validateMessage("codigo", "Código Duplicado");
		}		
		super.guardar(entity);
	}
	
	@Override
	public void actualizar(PosicionCambiaria entity) {
		Long registros = ((PosicionCambiariaRepository)repository).posicionCambiariaExistenteActualizar(entity.getCodigo(), entity.getId());
		
		if(registros > 0l) {
			ValidatorUtil.validateMessage("codigo", "Código Duplicado");
		}
		super.actualizar(entity);
	}
}
