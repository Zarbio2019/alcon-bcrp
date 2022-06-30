package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CierreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CierreDiarioSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CierreDiario;
import pe.grupobbva.alcon.mantenimiento.repository.CierreDiarioRepository;
import pe.grupobbva.alcon.mantenimiento.service.CierreDiarioService;

@Service
public class CierreDiarioServiceImpl extends AbstractServiceImpl<CierreDiario> implements CierreDiarioService {
	
	@Override
	public DatatableDTO<CierreDiarioDTO> search(CierreDiarioSearch cierrediarioSearch) {
		return ((CierreDiarioRepository)repository).search(cierrediarioSearch);
	}


}
