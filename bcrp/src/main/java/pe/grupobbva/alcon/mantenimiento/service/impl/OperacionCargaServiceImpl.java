package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacioncargaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacioncargaTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Operacion;
import pe.grupobbva.alcon.mantenimiento.entity.Operacioncarga;
import pe.grupobbva.alcon.mantenimiento.repository.OperacionCargaRepository;
import pe.grupobbva.alcon.mantenimiento.service.OperacionCargaService;

@Service
public class OperacionCargaServiceImpl extends AbstractServiceImpl<Operacioncarga> implements OperacionCargaService {

	@Override
	@Transactional
	public void actualizarMensajeError(Operacion operacion) {
		((OperacionCargaRepository) repository).actualizarMensajeError(operacion.getIdCarga(), operacion.getNumerooperacion(),
				operacion.getMensajeerror(), operacion.getIdfilaarchivo(), operacion.getActualizadoPor(), Calendar.getInstance());
	}
	
	@Override
	public void eliminarOperacionCargaPorIdCarga(String idcarga) {
		((OperacionCargaRepository) repository).eliminarOperacionCargaPorIdCarga(idcarga);
	}
	
	@Override
	public DatatableDTO<OperacioncargaTableDTO> listarErrores(OperacioncargaSearch search) {
		return ((OperacionCargaRepository) repository).listarErrores(search);
	}

	@Override
	@Transactional
	public void restaurarestadoOperacionCargaPorIdCarga(String idcarga) {
		((OperacionCargaRepository) repository).restaurarestadoOperacionCargaPorIdCarga(idcarga);
		
	}

	
}
