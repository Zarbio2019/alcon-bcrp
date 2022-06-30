package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.beans.Codigoestado;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.custom.OperacionCalculate;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.OperacionCalculateResponse;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionInternaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.OperacionInternaTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionInterna;
import pe.grupobbva.alcon.mantenimiento.entity.Producto;
import pe.grupobbva.alcon.mantenimiento.repository.OperacionInternaRepository;
import pe.grupobbva.alcon.mantenimiento.service.ClienteService;
import pe.grupobbva.alcon.mantenimiento.service.CorrelativoService;
import pe.grupobbva.alcon.mantenimiento.service.OperacionInternaService;

@Service
public class OperacionInternaServiceImpl extends AbstractServiceImpl<OperacionInterna> implements OperacionInternaService {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CorrelativoService correlativoService;
	
	@Override
	public DatatableDTO<OperacionInternaTableDTO> search(OperacionInternaSearch operacionSearch){
		return ((OperacionInternaRepository)repository).search(operacionSearch);
	}

	@Override
	public OperacionCalculateResponse calculate(OperacionCalculate calculate) {
		
		return ((OperacionInternaRepository)repository).calculate(calculate);
	}
	
	@Override
	public void guardar(OperacionInterna entity) {
		Long registros = ((OperacionInternaRepository)repository).operacionesCierreDiarioVerificar(entity.getCodigoestado(), 
				entity.getFechamovimiento().get(Calendar.DAY_OF_MONTH),	entity.getFechamovimiento().get(Calendar.MONTH) + 1, 
				entity.getFechamovimiento().get(Calendar.YEAR));
		
		String idCliente = ((OperacionInternaRepository)repository).operacionesObtenerIdCliente("INTERNO");
		String idProducto = ((OperacionInternaRepository)repository).operacionesObtenerIdProducto("FXC");
		String codigoBCR = ((OperacionInternaRepository)repository).operacionesObtenerCodigoBCR("FXC");
		
		String codigoReporte = ((OperacionInternaRepository)repository).operacionesObtenerCodigoReporte(entity.getCodigoestado(), "L", "D",
				entity.getFechamovimiento().get(Calendar.DAY_OF_MONTH),	entity.getFechamovimiento().get(Calendar.MONTH) + 1, 
				entity.getFechamovimiento().get(Calendar.YEAR));
		

		String anio = String.format("%04d", entity.getFechamovimiento().get(Calendar.YEAR));
		String mes = String.format("%02d", entity.getFechamovimiento().get(Calendar.MONTH) + 1);
		String dia = String.format("%02d", entity.getFechamovimiento().get(Calendar.DAY_OF_MONTH));
		
		codigoReporte = anio + mes + dia + codigoBCR + (codigoReporte == null  ? "" : codigoReporte);
		
		String correlativo = correlativoService.generaCorrelativoCompuesto("Operacion");
		String correlativointerno = correlativoService.generaCorrelativoCompuesto("OperacionInterna");
//		String nroOperacion = ((OperacionInternaRepository)repository).operacionesObtenerNumeroOperacion();
		
		if(registros > 0l) {
			ValidatorUtil.validateMessage("operación", "No se puede realizar cambios debido que la fecha seleccionada ya fue cerrada.");
		}	

		entity.setCliente(new Cliente(idCliente));
		entity.setProducto(new Producto(idProducto));
		entity.setCodigooperacion(codigoBCR);
		entity.setCodigoreporte(codigoReporte);
//		entity.setNumerooperacion(nroOperacion);
		entity.setNumerooperacion(correlativointerno);
		
		entity.setFechacontratacion(entity.getFechamovimiento());
		entity.setFechavalor(entity.getFechamovimiento());
		entity.setFechavencimiento(entity.getFechamovimiento());
		entity.setTipocambiospot(entity.getCambioref());
		entity.setCotizacion(entity.getCambioref());
		entity.setMontopen(entity.getImporteusd().multiply(entity.getCambioref()));
		entity.setHistorico(1);
		entity.setPaisresidencia("PE");
		entity.setRiesgopais("PE");
		entity.setTipoproceso(entity.getTipoproceso());
		entity.setResidente("R");
		entity.setEstado("L");
		entity.setTipocliente(clienteService.buscarId(idCliente).getTipocliente());
		entity.setCorrelativo(correlativo);
		
		super.guardar(entity);
	}
	
	@Override
	public void actualizar(OperacionInterna entity) {
		Long registros = ((OperacionInternaRepository)repository).operacionesDuplicadasActualizar(entity.getCodigoestado(), entity.getId());
		
		if(registros < 1l) {
			ValidatorUtil.validateMessage("operación", "Operación No Existe");
		}
		
		entity.setFechacontratacion(entity.getFechamovimiento());
		entity.setFechavalor(entity.getFechamovimiento());
		entity.setFechavencimiento(entity.getFechamovimiento());
		entity.setTipocambiospot(entity.getCambioref());
		entity.setCotizacion(entity.getCambioref());
		entity.setMontopen(entity.getImporteusd().multiply(entity.getCambioref()));
		
		super.actualizar(entity);
	}
	
	@Override
	public void eliminar(OperacionInterna entity) {
		Long registros = ((OperacionInternaRepository)repository).operacionesExistentesActualizar(entity.getId());
		
		if(registros < 1l) {
			ValidatorUtil.validateMessage("id", "id No Existe");
		}
		if(entity.getCodigoestado().equals(Codigoestado.INACTIVO.getCodigoestado())) {
			ValidatorUtil.validateMessage("codigoestado", "El registro ya fue borrado");
		}
		
		
		super.eliminar(entity);
	}
}
