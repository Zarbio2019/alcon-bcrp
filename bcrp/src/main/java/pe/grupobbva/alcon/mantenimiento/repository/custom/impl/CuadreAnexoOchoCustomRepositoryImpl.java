package pe.grupobbva.alcon.mantenimiento.repository.custom.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.DetalleAnexoOchoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.ParametrosAnexoOchoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.UploadCargaAnexoOchoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.CodigoOperacionAnexoOchoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroDetalleDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteCuatroPosicionCambiariaDTO;
import pe.grupobbva.alcon.mantenimiento.dto.report.ReporteOchoAnexo8DTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.ReporteSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.CuadreAnexoOchoTableDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.AbstractRestController;
import pe.grupobbva.alcon.mantenimiento.entity.CuadreAnexoOcho;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleAnexoOcho;
import pe.grupobbva.alcon.mantenimiento.repository.custom.CuadreAnexoOchoCustomRepository;
import pe.grupobbva.alcon.mantenimiento.service.CuadreAnexoOchoService;

public class CuadreAnexoOchoCustomRepositoryImpl implements CuadreAnexoOchoCustomRepository{

	private static final Logger log = LogManager.getLogger();
	
	@Autowired
	private EntityManager em;
	
	@Autowired
	private CuadreAnexoOchoService cuadreAnexoOchoService;
	
	@Autowired
	private AbstractRestController<DetalleAnexoOcho, DetalleAnexoOchoDTO> detalleAnexoOchoService;
	
	@SuppressWarnings("unchecked")
	@Override
	public DatatableDTO<CuadreAnexoOchoTableDTO> search(ReporteSearch reporteSearch) {
		List<CuadreAnexoOchoTableDTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_ANEXO_OCHO_LISTAR")
				.setParameter("P_FECHAPROCESO", reporteSearch.getFecha())
				.getResultList();
		
		return new DatatableDTO<>(
				reporteSearch.getDraw(),
				Long.valueOf(resultados.size()),
				resultados
				);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void generar(UploadCargaAnexoOchoDTO uploadCarga) {
		//conversión de fecha
		Calendar fechaC = Calendar.getInstance();
		fechaC.setTimeInMillis(uploadCarga.getFechaL());
		
		//Creo plantilla inicial
		em.createNamedStoredProcedureQuery("SP_BCR_ANEXO_OCHO_INICIALIZAR")
		  .setParameter("P_FECHAPROCESO", fechaC.getTime())
		  .execute();
		
		//Obtenemos los diferentes parametros para el cuadre
		List<ParametrosAnexoOchoDTO> parametros = 
		em.createNamedStoredProcedureQuery("SP_BCR_ANEXO_OCHO_PARAMETROS")
			.setParameter("P_CODIGOARCHIVO", uploadCarga.getOpcionTipoArchivo())
			.setParameter("P_FECHAPROCESO", fechaC.getTime() )
			.getResultList();
		Iterator<ParametrosAnexoOchoDTO> parametrosIterator = parametros.iterator();
		
		//leo los datos del Anexo 8
		List<DetalleAnexoOchoDTO> detalleAnexo8 = new ArrayList<DetalleAnexoOchoDTO>();
		List<CodigoOperacionAnexoOchoDTO> CodigoOperacion = new ArrayList<CodigoOperacionAnexoOchoDTO>();
		
		try {
			detalleAnexo8 = readtxt(uploadCarga.getFile().getInputStream(),uploadCarga.getOpcionTipoArchivo());
			CodigoOperacion = readExcel(uploadCarga.getFilecodigos().getInputStream());
			log.info(detalleAnexo8);
			Map<String, DetalleAnexoOchoDTO>  map = new HashMap<>();
			
			for(DetalleAnexoOchoDTO detalle: detalleAnexo8) {
				map.put(detalle.getCodigooperacion().trim(), detalle);
			}
			
			for(CodigoOperacionAnexoOchoDTO codigo : CodigoOperacion) {
				if(map.containsKey(codigo.getCodigooperacion())) {
					map.get(codigo.getCodigooperacion().trim()).setNumerooperacion(codigo.getNumerooperacion());
				}
			}
			
		} catch (Exception e) {
			log.error("failed!", e);
		}
		
	
		//Sumatoria de importes
		
		for(ParametrosAnexoOchoDTO parametro : parametros) {
			
			String codigo = parametro.getCodigoproducto().concat(parametro.getTipooperacion());
			BigDecimal SumaImporte = BigDecimal.ZERO;
			
			for (DetalleAnexoOchoDTO detalle : detalleAnexo8) {
				if(codigo.equals(detalle.getCodigooperacion().substring(0, codigo.length()))) {
					SumaImporte = SumaImporte.add(detalle.getMontoanexo());
				}
			}
			
			CuadreAnexoOcho cuadreanexo = cuadreAnexoOchoService.buscarId(parametro.getIdcuadreanexoocho());
			cuadreanexo.setMontoanexo(SumaImporte);
			cuadreanexo.setDiferencia(cuadreanexo.getMontoposicioncambiaria().subtract(SumaImporte));
			
			int compareBigDecimal = cuadreanexo.getMontoanexo().compareTo(cuadreanexo.getMontoposicioncambiaria());
			if(compareBigDecimal == 0) {
				cuadreanexo.setDescripcion("No hay diferencias");
			}else if (compareBigDecimal > 0) {
				cuadreanexo.setDescripcion("Existen un monto mayor en Anexo 8");
			}else if(compareBigDecimal < -1) {
				cuadreanexo.setDescripcion("Existen un monto mayor en Posicion Cambiaria");
			}
			cuadreAnexoOchoService.actualizar(cuadreanexo);
		}
		
		//Comparamos operaciones
		for(ParametrosAnexoOchoDTO parametro : parametros) {
			
			em.createNamedStoredProcedureQuery("SP_BCR_ANEXO_OCHO_ELIMINARDET")
			  .setParameter("P_ID_CUADRE_ANEXO_OCHO", parametro.getIdcuadreanexoocho())
			  .execute();
			
			if(parametro.getReporte()==4) {
				
				List<ReporteCuatroDetalleDTO> operacionespc = new ArrayList<ReporteCuatroDetalleDTO>();
				operacionespc = operacionespc(parametro.getIdposicioncambiaria(), fechaC.getTime());
				
				Map<String, ReporteCuatroDetalleDTO>  map = new HashMap<>();
				
				for(ReporteCuatroDetalleDTO operacion: operacionespc) {
					map.put(operacion.getNumerooperacion().trim(), operacion);
				}
				
				for(DetalleAnexoOchoDTO detalle: detalleAnexo8) {
					String codigoreporte = parametro.getCodigoproducto().concat(parametro.getTipooperacion());
					
					if(detalle.getCodigooperacion().substring(0, codigoreporte.length()).equals(codigoreporte)) {
						
						if(!map.containsKey(detalle.getNumerooperacion())) {
							detalle.setFuente("Anexo 8");
							detalle.setIdCuadreAnexoOcho(parametro.getIdcuadreanexoocho());
							detalle.setObservacion("La operacion no existe en Posicion Cambiaria");
							detalle.setProducto(parametro.getCodigoproducto());
							detalle.setTipooperacion(parametro.getTipooperacion());
							detalleAnexoOchoService.create(detalle);
						}else if(!StringUtils.isBlank(detalle.getNumerooperacion().trim())) {
							
							if(map.get(detalle.getNumerooperacion()).getImporteusd().compareTo(detalle.getMontoanexo())!=0) {
								detalle.setFuente("Posicion Cambiaria");
								detalle.setIdCuadreAnexoOcho(parametro.getIdcuadreanexoocho());
								detalle.setMontoposicioncambiaria(map.get(detalle.getNumerooperacion()).getImporteusd());
								detalle.setDiferencia(map.get(detalle.getNumerooperacion()).getImporteusd().subtract(detalle.getMontoanexo()));
								detalle.setObservacion("Diferencia de importes");
								detalle.setProducto(parametro.getCodigoproducto());
								detalle.setTipooperacion(parametro.getTipooperacion());
								detalleAnexoOchoService.create(detalle);
							}
							
						}
					}
				}
				
			}else if(parametro.getReporte()==8) {
				List<ReporteOchoAnexo8DTO> operacionessd = new ArrayList<ReporteOchoAnexo8DTO>();
				operacionessd = operacionessd(parametro.getIdsaldoderivados(), fechaC.getTime());
				
				Map<String, ReporteOchoAnexo8DTO>  map = new HashMap<>();
				
				for(ReporteOchoAnexo8DTO operacion: operacionessd) {
					map.put(operacion.getNumerooperacion().trim(), operacion);
				}
				
				for(DetalleAnexoOchoDTO detalle: detalleAnexo8) {
					String codigoreporte = parametro.getCodigoproducto().concat(parametro.getTipooperacion());
					if(detalle.getCodigooperacion().substring(0, codigoreporte.length()).equals(codigoreporte)) {
						if(!map.containsKey(detalle.getNumerooperacion())) {
							detalle.setFuente("Anexo 8");
							detalle.setIdCuadreAnexoOcho(parametro.getIdcuadreanexoocho());
							detalle.setObservacion("La operacion no existe en Posicion Cambiaria");
							detalle.setProducto(parametro.getCodigoproducto());
							detalle.setTipooperacion(parametro.getTipooperacion());
							detalleAnexoOchoService.create(detalle);
						}else if(!StringUtils.isBlank(detalle.getNumerooperacion().trim())) {
							if(map.get(detalle.getNumerooperacion()).getImporteusd().compareTo(detalle.getMontoanexo())!=0) {
								detalle.setFuente("Posicion Cambiaria");
								detalle.setIdCuadreAnexoOcho(parametro.getIdcuadreanexoocho());
								detalle.setMontoposicioncambiaria(map.get(detalle.getNumerooperacion()).getImporteusd());
								detalle.setDiferencia(map.get(detalle.getNumerooperacion()).getImporteusd().subtract(detalle.getMontoanexo()));
								detalle.setObservacion("Diferencia de importes");
								detalle.setProducto(parametro.getCodigoproducto());
								detalle.setTipooperacion(parametro.getTipooperacion());
								detalleAnexoOchoService.create(detalle);
							}
						}
					}
				}
			}	
		}
		
	}

	
	@SuppressWarnings("unchecked")
	public List<ReporteCuatroDetalleDTO> operacionespc(String idposicioncambiaria, Date fecha){
		
		List<ReporteCuatroDetalleDTO> resultados = new ArrayList<ReporteCuatroDetalleDTO>();
		
			resultados.addAll(
					em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_ANEXO8")
					.setParameter("P_IDPOSICIONCAMBIARIA", StringUtils.isBlank(idposicioncambiaria)?"0":idposicioncambiaria)
					.setParameter("P_FECHA", fecha)
					.setParameter("P_TIPOPROCESO", "D" )
					.getResultList()
					);
			
		    resultados.addAll(
					em.createNamedStoredProcedureQuery("SP_BCR_REPORTE4_ANEXO8_IRC")
					.setParameter("P_IDPOSICIONCAMBIARIA", StringUtils.isBlank(idposicioncambiaria)?"0":idposicioncambiaria)
					.setParameter("P_FECHA", fecha)
					.setParameter("P_TIPOPROCESO","D" )
					.getResultList());
		
		
		return resultados;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<ReporteOchoAnexo8DTO> operacionessd(String idsaldoderivados, Date fecha){
		
		List<ReporteOchoAnexo8DTO> resultados = 
				em.createNamedStoredProcedureQuery("SP_BCR_REPORTE8_ANEXO8")
				.setParameter("P_IDSALDODERIVADOS", StringUtils.isBlank(idsaldoderivados)?"0":idsaldoderivados)
				.setParameter("P_FECHA", fecha)
				.setParameter("P_TIPOPROCESO", "D")
				.getResultList();
		return resultados;
	}
	
	public List<DetalleAnexoOchoDTO> readtxt( InputStream is ,  String codigoarchivo) {

		List<DetalleAnexoOchoDTO> Anexo8 = new ArrayList<DetalleAnexoOchoDTO>();
	
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String row = null;

			while (reader.ready()) {
				row = reader.readLine();
				if(row.length() > 400 ) {
					Anexo8.add(new DetalleAnexoOchoDTO(row,codigoarchivo));
				}
			}
		} catch (Exception e) {
			log.error("failed read!", e);
		}
		
		return Anexo8;
	}
	
	public List<CodigoOperacionAnexoOchoDTO> readExcel(InputStream is) {
		List<CodigoOperacionAnexoOchoDTO> Codigos = new ArrayList<CodigoOperacionAnexoOchoDTO>();
		Workbook wb = null;
		Sheet sheet = null;
		try {
			wb = WorkbookFactory.create(is);
			sheet = wb.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.rowIterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				Cell cell =  row.getCell(0);
				String numerooperacion = row.getCell(0).toString();
				
				if(cell.getCellType().equals(CellType.NUMERIC)) {
					numerooperacion = BigDecimal.valueOf(cell.getNumericCellValue()).toPlainString();
				}
				
				Codigos.add(new CodigoOperacionAnexoOchoDTO(numerooperacion.trim().replace("N", ""), row.getCell(1).toString()));
			}

		} catch (Exception e) {
			log.error("failed!", e);
		} finally {
			try {
				if (wb != null) {
					wb.close();
				}
			} catch (IOException e) {
				log.error("failed!", e);
			}
		}
		
		return Codigos;
	}
	
}
