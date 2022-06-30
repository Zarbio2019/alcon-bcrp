package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.beans.Codigoestado;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.core.utils.dto.SelectOptions;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.OficinaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OficinaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OficinaTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.SelectOptionsDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Oficina;
import pe.grupobbva.alcon.mantenimiento.repository.OficinaRepository;
import pe.grupobbva.alcon.mantenimiento.service.OficinaService;

@Service
public class OficinaServiceImpl extends AbstractServiceImpl<Oficina> implements OficinaService{
	
	private static final Logger log = LogManager.getLogger();
	
	@Override
	public DatatableDTO<OficinaTableDTO> search(OficinaSearch oficinaSearch){
		return  ((OficinaRepository)repository).search(oficinaSearch);
	}
	
	@Override
	public SelectOptions<SelectOptionsDTO> listOptions() {
		return ((OficinaRepository)repository).listOptions();
	}
	
	@Override
	public void guardar(Oficina entity) {
		Long registros = ((OficinaRepository)repository).oficinasDuplicados(entity.getCodigo(), entity.getCodigoestado());
		log.info("Numero de registros: " + registros);
		if(registros > 0l) {
			ValidatorUtil.validateMessage("codigo", "Código Duplicado");
		}		
		super.guardar(entity);
	}
	
	@Override
	public void actualizar(Oficina entity) {
		Long registros = ((OficinaRepository)repository).oficinasDuplicadosActualizar(entity.getCodigo(),entity.getCodigoestado(),entity.getId());
		
		if(registros > 0l) {
			ValidatorUtil.validateMessage("codigo", "Código Duplicado");
		}
		super.actualizar(entity);
	}
	
	@Override
	public void eliminar(Oficina entity) {
		Long registros = ((OficinaRepository)repository).oficinasUtilizadasSaldoContable(entity.getCodigoestado(), entity.getId());
		
		if(registros > 0l) {
			ValidatorUtil.validateMessage("Oficina", "Oficina utilizada en el saldo contable.");
		}
		
		registros = ((OficinaRepository)repository).oficinasExistentesActualizar(entity.getId());
		
		if(registros < 1l) {
			ValidatorUtil.validateMessage("Oficina", "No existe la oficina que desea eliminar.");
		}
		
		if(entity.getCodigoestado().equals(Codigoestado.INACTIVO.getCodigoestado())) {
			ValidatorUtil.validateMessage("codigoestado", "El registro ya fue borrado");
		}
		
		super.eliminar(entity);
	}
	
	@Override
	public Oficina obtenerOficinaPorCodigo(String codigo) {
		return ((OficinaRepository) repository).obtenerOficinaPorCodigo(codigo);
	}
	
	@Override
	public List<OficinaDTO> listarOficinas() {
		return ((OficinaRepository) repository).listarOficinas();
	}
}
