package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.beans.Codigoestado;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.search.SaldoContableSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.SaldoContableTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Divisa;
import pe.grupobbva.alcon.mantenimiento.entity.Oficina;
import pe.grupobbva.alcon.mantenimiento.entity.SaldoContable;
import pe.grupobbva.alcon.mantenimiento.repository.DivisaRepository;
import pe.grupobbva.alcon.mantenimiento.repository.OficinaRepository;
import pe.grupobbva.alcon.mantenimiento.repository.SaldoContableRepository;
import pe.grupobbva.alcon.mantenimiento.service.DivisaService;
import pe.grupobbva.alcon.mantenimiento.service.OficinaService;
import pe.grupobbva.alcon.mantenimiento.service.SaldoContableService;

@Service
public class SaldoContableServiceImpl extends AbstractServiceImpl<SaldoContable> implements SaldoContableService {
	
	@Autowired
	DivisaRepository divisaRepository;
	
	@Autowired
	DivisaService divisaService;
	
	@Autowired
	OficinaRepository oficinaRepository;
	
	@Autowired
	OficinaService oficinaService;

	@Override
	public DatatableDTO<SaldoContableTableDTO> search(SaldoContableSearch saldoContableSearch) {
		return ((SaldoContableRepository) repository).search(saldoContableSearch);

	}

	@Override
	public void guardar(SaldoContable entity) {
		
		Long cantidad;
		String idDivisa;
		String idOficina;
		
		if (entity.getDivisa().getId() == null) {
			
			cantidad = divisaRepository.divisaExistentes(entity.getDivisa().getCodigo());
			
			if (cantidad < 1) {
				Divisa divisa = new Divisa();
				
				divisa.setCodigo(entity.getDivisa().getCodigo());
				divisa.setDescripcion(entity.getDivisa().getCodigo());
				divisa.setCreadoPor(entity.getCreadoPor());
				
				divisaService.guardar(divisa);
			}
			
			idDivisa = divisaRepository.divisaObtenerId(entity.getDivisa().getCodigo());
			entity.getDivisa().setId(idDivisa);
			
			cantidad = oficinaRepository.oficinasDuplicados(entity.getOficina().getCodigo(), 1);
			
			if (cantidad < 1) {
				Oficina oficina = new Oficina();
				
				oficina.setCodigo(entity.getOficina().getCodigo());
				oficina.setDescripcion(entity.getOficina().getCodigo());
				oficina.setPosicioncambiaria("I");
				oficina.setCreadoPor(entity.getCreadoPor());
				
				oficinaService.guardar(oficina);
			}
			
			idOficina = oficinaRepository.oficinaObtenerId(entity.getOficina().getCodigo());
			entity.getOficina().setId(idOficina);
				
		}
		
		Long registros = ((SaldoContableRepository) repository).saldoscontablesDuplicados(1,
				entity.getDivisa().getId(), entity.getOficina().getId(), entity.getFecha());

		if (registros > 0l) {
			ValidatorUtil.validateMessage("saldo contable", "Saldo Contable Duplicado");
		}
		
		super.guardar(entity);
		
	}

	@Override
	public void actualizar(SaldoContable entity) {
		Long registros = ((SaldoContableRepository) repository).saldoscontablesDuplicadosActualizar(
				entity.getCodigoestado(), entity.getDivisa().getId(), entity.getOficina().getId(),
				entity.getFecha().get(Calendar.DAY_OF_MONTH), entity.getFecha().get(Calendar.MONTH) + 1,
				entity.getFecha().get(Calendar.YEAR), entity.getId());

		if (registros > 0l) {
			ValidatorUtil.validateMessage("saldo contable", "Saldo Contable Duplicado");
		}
		super.actualizar(entity);
	}

	@Override
	public void eliminar(SaldoContable entity) {
		Long registros = ((SaldoContableRepository)repository).saldoscontablesExistentesActualizar(entity.getId());
		
		if(registros < 1l) {
			ValidatorUtil.validateMessage("saldo contable", "Saldo Contable No Existe");
		}
		
		if(entity.getCodigoestado().equals(Codigoestado.INACTIVO.getCodigoestado())) {
			ValidatorUtil.validateMessage("codigoestado", "El registro ya fue borrado");
		}

		super.eliminar(entity);
	}
	
	@Override
	public void copiarUltimo(Calendar fecha) {
		SaldoContableRepository saldoContableRepository = (SaldoContableRepository) repository;

		List<SaldoContable> saldocontables = saldoContableRepository.tipoCambioPorfecha(fecha);

		if (saldocontables.isEmpty()) {

			saldocontables = saldoContableRepository.ultimoTipoCambioPorfecha(fecha);

			for (SaldoContable saldoContable : saldocontables) {
				SaldoContable nuevoSaldoContable = new SaldoContable();
				nuevoSaldoContable.setFecha(fecha);
				nuevoSaldoContable.setImporte(saldoContable.getImporte());
				nuevoSaldoContable.setDivisa(saldoContable.getDivisa());
				nuevoSaldoContable.setOficina(saldoContable.getOficina());
				nuevoSaldoContable.setCodigoestado(saldoContable.getCodigoestado());
				
				saldoContableRepository.save(nuevoSaldoContable);
			}
		}

	}
	
	@Override
	public void saldoContableActualizarEstadoGrupo(Carga carga, Integer codigoestado) {
		((SaldoContableRepository) repository).saldoContableActualizarEstadoGrupo(carga, codigoestado);
	}

}
