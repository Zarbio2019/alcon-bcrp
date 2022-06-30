package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.beans.TimeFormat;
import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.search.TipoCambioSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.TipoCambioTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCambio;
import pe.grupobbva.alcon.mantenimiento.repository.DivisaRepository;
import pe.grupobbva.alcon.mantenimiento.repository.TipoCambioRepository;
import pe.grupobbva.alcon.mantenimiento.service.DivisaService;
import pe.grupobbva.alcon.mantenimiento.service.TipoCambioService;

@Service
public class TipoCambioServiceImpl extends AbstractServiceImpl<TipoCambio> implements TipoCambioService {

	@Autowired
	DivisaRepository divisaRepository;

	@Autowired
	DivisaService divisaService;

	@Override
	public DatatableDTO<TipoCambioTableDTO> search(TipoCambioSearch tipoCambioSearch) {
		return ((TipoCambioRepository) repository).search(tipoCambioSearch);
	}

	@Override
	public void guardar(TipoCambio entity) {
		Long registros = ((TipoCambioRepository) repository).tipocambiosDuplicados(1, entity.getDivisa().getId(), entity.getFecha());

		if (registros > 0l) {
			ValidatorUtil.validateMessage("Tipo Cambio Insertar", "No se ha realizado el registro, debido a que el tipo de cambio a registrar ya existe para la fecha indicada.");
		}

		super.guardar(entity);
	}
	
	@Override
	public void actualizar(TipoCambio entity) {
		Long registros = ((TipoCambioRepository)repository).tipocambiosDuplicadosActualizar(1, entity.getDivisa().getId(), entity.getFecha(), entity.getId());
		
		if(registros > 0l) {
			ValidatorUtil.validateMessage("Tipo Cambio Actualizar", "No se puede modificar el tipo de cambio, debido a que el tipo de cambio a actualizar ya existe para la fecha indicada.");
		}
		
		super.actualizar(entity);
	}

	@Override
	public void copiarUltimo(Calendar fecha) {
		TipoCambioRepository tipoCambioRepository = (TipoCambioRepository) repository;

		List<TipoCambio> tipoCambios = tipoCambioRepository.tipoCambioPorfecha(fecha);

		if (tipoCambios.isEmpty()) {

			tipoCambios = tipoCambioRepository.ultimoTipoCambioPorfecha(fecha);

			for (TipoCambio tipoCambio : tipoCambios) {
				TipoCambio nuevoTipoCambio = new TipoCambio();
				nuevoTipoCambio.setFecha(fecha);
				nuevoTipoCambio.setImporte(tipoCambio.getImporte());
				nuevoTipoCambio.setDivisa(tipoCambio.getDivisa());
				nuevoTipoCambio.setCodigoestado(tipoCambio.getCodigoestado());

				tipoCambioRepository.save(nuevoTipoCambio);
			}
		}

	}

	@Override
	public BigDecimal listarFechaDivisa(Calendar fecha, String codigoDivisa) {
		
		BigDecimal importe = ((TipoCambioRepository) repository).listarFechaDivisa(fecha, codigoDivisa);
		
		if(importe == null) {
			ValidatorUtil.validateMessage("Fecha Divisa", "No existe tipo de cambio para la fecha " + Utils.calendartoString(fecha, TimeFormat.DATEFORMAT) + " y " + "la divisa "+ codigoDivisa);
		}
		
		return importe;
	}

	@Override
	public void actualizarInsertar(TipoCambio entity) {
		TipoCambio entity2 = ((TipoCambioRepository) repository).tipocambioObtenerId(entity.getFecha(),
				entity.getDivisa().getId()); 
		
		if(entity2!=null) {
			entity2.setImporte(entity.getImporte());
			super.guardar(entity2);
		}
		else {
			super.guardar(entity);
		}
	}

}
