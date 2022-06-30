package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD02DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgRCD02Search;
import pe.grupobbva.alcon.mantenimiento.entity.CfgRCD02;
import pe.grupobbva.alcon.mantenimiento.service.CfgRCD02Service;
import pe.grupobbva.alcon.mantenimiento.repository.CfgRCD02Repository;

@Service
public class CfgRCD02ServiceImpl extends AbstractServiceImpl<CfgRCD02> implements CfgRCD02Service{

	@Override
	public DatatableDTO<CfgRCD02DTO> search(CfgRCD02Search search) {
		// TODO Auto-generated method stub
		return ((CfgRCD02Repository) repository).search(search);
	}

	@Override
	public void guardar(CfgRCD02 entity) {
		super.guardar(entity);
	}
	
	@Override
	public void actualizar(CfgRCD02 entity) {
		super.actualizar(entity);
	}
	
	@Override
	public void eliminar(CfgRCD02 entity) {
		super.eliminar(entity);
	}
}
