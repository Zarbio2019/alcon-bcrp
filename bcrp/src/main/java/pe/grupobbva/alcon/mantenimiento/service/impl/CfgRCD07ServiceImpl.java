package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD07DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgRCD07Search;

import pe.grupobbva.alcon.mantenimiento.entity.CfgRCD07;
import pe.grupobbva.alcon.mantenimiento.repository.CfgRCD07Repository;
import pe.grupobbva.alcon.mantenimiento.service.CfgRCD07Service;

@Service
public class CfgRCD07ServiceImpl extends AbstractServiceImpl<CfgRCD07> implements CfgRCD07Service{
	@Override
	public DatatableDTO<CfgRCD07DTO> search(CfgRCD07Search search) {
		// TODO Auto-generated method stub
		return ((CfgRCD07Repository) repository).search(search);
	}

	@Override
	public void guardar(CfgRCD07 entity) {
		super.guardar(entity);
	}
	
	@Override
	public void actualizar(CfgRCD07 entity) {
		super.actualizar(entity);
	}
	
	@Override
	public void eliminar(CfgRCD07 entity) {
		super.eliminar(entity);
	}
}
