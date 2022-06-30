package pe.grupobbva.alcon.mantenimiento.service.impl;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgSpeFrairDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.CfgSpeFrairSearch;
import pe.grupobbva.alcon.mantenimiento.entity.CfgSpeFrair;
import pe.grupobbva.alcon.mantenimiento.service.CfgSpeFrairService;
import pe.grupobbva.alcon.mantenimiento.repository.CfgSpeFrairRepository;

@Service
public class CfgSpeFrairServiceImpl extends AbstractServiceImpl<CfgSpeFrair> implements CfgSpeFrairService{

	@Override
	public DatatableDTO<CfgSpeFrairDTO> search(CfgSpeFrairSearch search) {
		// TODO Auto-generated method stub
		return ((CfgSpeFrairRepository) repository).search(search);
	}

	@Override
	public void guardar(CfgSpeFrair entity) {
		super.guardar(entity);
	}
	
	@Override
	public void actualizar(CfgSpeFrair entity) {
		super.actualizar(entity);
	}
	
	@Override
	public void eliminar(CfgSpeFrair entity) {
		super.eliminar(entity);
	}
}
