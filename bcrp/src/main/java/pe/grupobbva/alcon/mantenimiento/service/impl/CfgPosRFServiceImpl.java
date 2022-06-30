package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRFDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgPosRFSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CfgPosRF;
import pe.grupobbva.alcon.mantenimiento.repository.CfgPosRFRepository;
import pe.grupobbva.alcon.mantenimiento.service.CfgPosRFService;

@Service
public class CfgPosRFServiceImpl extends AbstractServiceImpl<CfgPosRF> implements CfgPosRFService{

	@Override
	public DatatableDTO<CfgPosRFDTO> search(CfgPosRFSearch search) {
		// TODO Auto-generated method stub
		return ((CfgPosRFRepository) repository).search(search);
	}
	@Override
	public void guardar(CfgPosRF entity) {
		super.guardar(entity);
	}
	
	@Override
	public void actualizar(CfgPosRF entity) {
		super.actualizar(entity);
	}
	
	@Override
	public void eliminar(CfgPosRF entity) {
		super.eliminar(entity);
	}
}
