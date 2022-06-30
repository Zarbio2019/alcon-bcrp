package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRVDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgPosRVSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CfgPosRV;
import pe.grupobbva.alcon.mantenimiento.service.CfgPosRVService;
import pe.grupobbva.alcon.mantenimiento.repository.CfgPosRVRepository;

@Service
public class CfgPosRVServiceImpl extends AbstractServiceImpl<CfgPosRV> implements CfgPosRVService {

	@Override
	public DatatableDTO<CfgPosRVDTO> search(CfgPosRVSearch search) {
		// TODO Auto-generated method stub
		return ((CfgPosRVRepository) repository).search(search);
	}

	@Override
	public void guardar(CfgPosRV entity) {
		super.guardar(entity);
	}
	
	@Override
	public void actualizar(CfgPosRV entity) {
		super.actualizar(entity);
	}
	
	@Override
	public void eliminar(CfgPosRV entity) {
		super.eliminar(entity);
	}
}
