package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.repository.CfgFxVigenteRepository;
import pe.grupobbva.alcon.mantenimiento.dto.CfgFxVigenteDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgFxVigenteSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CfgFxVigente;
import pe.grupobbva.alcon.mantenimiento.service.CfgFxVigenteService;

@Service
public class CfgFxVigenteServiceImpl extends AbstractServiceImpl<CfgFxVigente> implements CfgFxVigenteService{

	@Override
	public DatatableDTO<CfgFxVigenteDTO> search(CfgFxVigenteSearch cfgFxVigenteSearch) {
		// TODO Auto-generated method stub
		return ((CfgFxVigenteRepository) repository).search(cfgFxVigenteSearch); 
	}

	@Override
	public void guardar(CfgFxVigente entity) {
		super.guardar(entity);
	}
	
	@Override
	public void actualizar(CfgFxVigente entity) {
		super.actualizar(entity);
	}
	
	@Override
	public void eliminar(CfgFxVigente entity) {
		super.eliminar(entity);
	}
}
