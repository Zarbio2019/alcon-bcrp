package pe.grupobbva.alcon.mantenimiento.service;

import org.springframework.http.ResponseEntity;

import pe.grupobbva.alcon.mantenimiento.dto.CuadreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.DetalleCuadreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CuadreDiarioSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.DetallePlantillaCalculoTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.PersonalizeDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CuadreDiario;

public interface CuadreDiarioService extends AbstractService<CuadreDiario> {
	
	public PersonalizeDTO<CuadreDiarioDTO, DetallePlantillaCalculoTableDTO> search(CuadreDiarioSearch cuadreDiarioSearch);

	public ResponseEntity<Void> update(PersonalizeDTO<CuadreDiarioDTO, DetalleCuadreDiarioDTO> data);

	public ResponseEntity<Void> create(PersonalizeDTO<CuadreDiarioDTO, DetalleCuadreDiarioDTO> data);

}
