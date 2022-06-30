package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.CargaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.process.TipoArchivo;
import pe.grupobbva.alcon.mantenimiento.dto.search.CargaSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.CargaTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Configuracion;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCarga;
import pe.grupobbva.alcon.mantenimiento.repository.CargaRepository;
import pe.grupobbva.alcon.mantenimiento.service.CampanaDepositoService;
import pe.grupobbva.alcon.mantenimiento.service.CargaService;
import pe.grupobbva.alcon.mantenimiento.service.ConfiguracionService;
import pe.grupobbva.alcon.mantenimiento.service.OperacionCargaService;
import pe.grupobbva.alcon.mantenimiento.service.OperacionDerivadoCargaService;
import pe.grupobbva.alcon.mantenimiento.service.OperacionDerivadoService;
import pe.grupobbva.alcon.mantenimiento.service.OperacionService;
import pe.grupobbva.alcon.mantenimiento.service.TasaInteresService;

@Service
public class CargaServiceImpl extends AbstractServiceImpl<Carga> implements CargaService {

	@Autowired
	private ConfiguracionService configuracionService;

	@Autowired
	private OperacionCargaService operacionCargaService;

	@Autowired
	private OperacionDerivadoCargaService operacionDerivadoCargaService;
	
	@Autowired
	private OperacionDerivadoService operacionDerivadoService;
	
	@Autowired
	private TasaInteresService tasaInteresService;
	
	@Autowired
	private CampanaDepositoService campanaDepositoService;
	
	@Autowired
	private OperacionService operacionService;

	@Value("${configuracion.id}")
	private String configuracionId;
	
	@Override
	public void cargarDatosAdicionales(CargaDTO cargaDTO) {
		validar(cargaDTO);
		
		Configuracion configuracion = configuracionService.buscarId(configuracionId);
		cargaDTO.setRutaarchivo(configuracion.getCarpetadestino() + UUID.randomUUID().toString() + "/");

	}
	
	private void validar(CargaDTO cargaDTO) {
		
		//Boolean validaDiaHora = configuracionService.valida(uploadCarga.getFecha().DAY_OF_WEEK, uploadCarga.getFecha().HOUR_OF_DAY+":"+uploadCarga.getFecha().MINUTE);
		

		
		
		// TASAS
		if(cargaDTO.getTipocarga().equals(String.valueOf(TipoCarga.TASAS.getNumeroTipoCarga()))) {
			
			List<Carga> cargas  = ((CargaRepository) repository).buscarTipoFechaProceso(cargaDTO.getFecha(),"D",Arrays.asList("6","7"));
			
			Optional<Carga> cargaIDIO = cargas.stream().filter(carga->carga.getTipocarga().equals("6")).findAny();
			//Optional<Carga> cargaIRCO = cargas.stream().filter(carga->carga.getTipocarga().equals("7")).findAny();
			
			if(!(cargaIDIO.isPresent() 
					//&& cargaIRCO.isPresent()
					)) {
				ValidatorUtil.validateMessage("filename", "No se puede realizar la carga debido a que debe haber el inforeport de la fecha a procesar");
				
				
			}
			
			
			
		// verificar que se cargo inforeport	
		}else if(cargaDTO.getTipocarga().equals(String.valueOf(TipoCarga.DELTA.getNumeroTipoCarga()))) {
			String originalName = cargaDTO.getNombrearchivo();
			String[] words = originalName.split("\\.");
			String extension = words[words.length-1];
			if (
					!(TipoArchivo.XLS.getExtension().equalsIgnoreCase(extension) 	|| 
					TipoArchivo.XLSX.getExtension().equalsIgnoreCase(extension)   ) 
					) {
				ValidatorUtil.validateMessage("filename", "Formato de archivo incorrecto , por favor ingrese un archivo excel");
			}
		}
		
		
	}

	@Override
	public List<CargaDTO> listarCargaPorReprocesar(Calendar fecha) {
		return ((CargaRepository) repository).listarCargaPorReprocesar(fecha);
	}

	@Override
	public void reprocesar(String idcarga) {
		((CargaRepository) repository).reprocesar(idcarga);
	}

	@Override
	public List<Carga> listarCargaPorFechaProceso(String tipocarga, Calendar fecha) {
		return ((CargaRepository) repository).listarCargaPorFechaProceso(tipocarga, fecha);
	}

	@Override
	public DatatableDTO<CargaTableDTO> search(CargaSearch search) {
		return ((CargaRepository) repository).search(search);
	}
	
	@Override
	public String obtenerTipoCargaPorIdCarga(String idcarga) {
		return ((CargaRepository) repository).obtenerTipoCargaPorIdCarga(idcarga);
	}

	@Override
	@Transactional
	public void eliminar(String idcarga) {
		
		String tipocarga = obtenerTipoCargaPorIdCarga(idcarga);
		
		if (tipocarga.equals("13") || tipocarga.equals("17")) {
			operacionDerivadoCargaService.eliminarOperacionDerivadoCargaPorIdCarga(idcarga);
			operacionDerivadoService.eliminarOperacionDerivadoPorIdCarga(idcarga);
			
		} else if (tipocarga.equals("14")) {
			campanaDepositoService.eliminarCampanaDepositoPorIdCarga(idcarga);
		} else {
			operacionCargaService.eliminarOperacionCargaPorIdCarga(idcarga);
			operacionService.eliminarOperacionPorIdCarga(idcarga);
			tasaInteresService.eliminarTasaInteresPorIdCarga(idcarga);
		}

		((CargaRepository) repository).eliminarCarga(idcarga);
	}
	
	
	@Override
	@Transactional
	public void eliminarOperacionesReprocesar(String idcarga) {
		operacionService.eliminarOperacionPorIdCarga(idcarga);
		operacionCargaService.restaurarestadoOperacionCargaPorIdCarga(idcarga);
	}

	@Override
	public List<Carga> listarCargasPosteriores(String idcarga,String tipoproceso,Calendar fecha) {
		return ((CargaRepository) repository).listarCargasPosteriores(idcarga,tipoproceso,fecha);
	}

	
	
	

}
