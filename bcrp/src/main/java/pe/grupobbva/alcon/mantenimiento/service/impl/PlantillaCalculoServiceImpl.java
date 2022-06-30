package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.PlantillaCalculoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.PlantillaCalculoTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.PlantillaCalculo;
import pe.grupobbva.alcon.mantenimiento.repository.PlantillaCalculoRepository;
import pe.grupobbva.alcon.mantenimiento.service.PlantillaCalculoService;

@Service
public class PlantillaCalculoServiceImpl extends AbstractServiceImpl<PlantillaCalculo> implements PlantillaCalculoService {
	
	@Override
	public DatatableDTO<PlantillaCalculoTableDTO> search(PlantillaCalculoSearch plantillaCalculoSearch) {
		return ((PlantillaCalculoRepository)repository).search(plantillaCalculoSearch);
	}

}
