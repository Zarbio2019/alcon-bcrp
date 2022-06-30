package pe.grupobbva.alcon.mantenimiento.repository.custom;

import org.springframework.http.ResponseEntity;

import pe.grupobbva.alcon.mantenimiento.dto.CuadreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.DetalleCuadreDiarioDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CuadreDiarioSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.DetallePlantillaCalculoTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.PersonalizeDTO;

public interface CuadreDiarioCustomRepository {
	
	public PersonalizeDTO<CuadreDiarioDTO, DetallePlantillaCalculoTableDTO> search(CuadreDiarioSearch cuadreDiarioSearch);
	public ResponseEntity<Void> create(PersonalizeDTO<CuadreDiarioDTO, DetalleCuadreDiarioDTO> data);
	public ResponseEntity<Void> update(PersonalizeDTO<CuadreDiarioDTO, DetalleCuadreDiarioDTO> data);

}
