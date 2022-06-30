package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.mantenimiento.dto.CuadreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.DetalleCuadreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CuadreDiarioSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.DetallePlantillaCalculoTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.PersonalizeDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CuadreDiario;
import pe.grupobbva.alcon.mantenimiento.repository.CuadreDiarioRepository;
import pe.grupobbva.alcon.mantenimiento.service.CuadreDiarioService;

@Service
public class CuadreDiarioServiceImpl extends AbstractServiceImpl<CuadreDiario> implements CuadreDiarioService {

	@Override
	public PersonalizeDTO<CuadreDiarioDTO, DetallePlantillaCalculoTableDTO> search(CuadreDiarioSearch cuadreDiarioSearch) {
		return ((CuadreDiarioRepository)repository).search(cuadreDiarioSearch);
	}

	@Override
	public ResponseEntity<Void> create(PersonalizeDTO<CuadreDiarioDTO, DetalleCuadreDiarioDTO> data) {
		return ((CuadreDiarioRepository)repository).create(data);
	}

	@Override
	public ResponseEntity<Void> update(PersonalizeDTO<CuadreDiarioDTO, DetalleCuadreDiarioDTO> data) {
		return ((CuadreDiarioRepository)repository).update(data);
	}
	
}
