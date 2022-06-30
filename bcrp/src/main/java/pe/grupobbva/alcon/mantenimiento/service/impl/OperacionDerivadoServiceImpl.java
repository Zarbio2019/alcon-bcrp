package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jfree.util.Log;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.OperacionOtrosDerivadosDTO;
import pe.grupobbva.alcon.mantenimiento.dto.search.OperacionSearch;
import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.OperacionDerivado;
import pe.grupobbva.alcon.mantenimiento.repository.OperacionDerivadoRepository;
import pe.grupobbva.alcon.mantenimiento.service.OperacionDerivadoService;

@Service
public class OperacionDerivadoServiceImpl extends AbstractServiceImpl<OperacionDerivado> implements OperacionDerivadoService {

private static final Logger log = LogManager.getLogger();
	

	
	@Override
	public DatatableDTO<OperacionOtrosDerivadosDTO> search(OperacionSearch operacionSearch) {
		return ((OperacionDerivadoRepository) repository).search(operacionSearch);
	}

	@Override
	public TablaDinamica<OperacionOtrosDerivadosDTO> generarexcel(OperacionSearch operacionSearch) {
		TablaDinamica<OperacionOtrosDerivadosDTO> consultaDinamica = new TablaDinamica<OperacionOtrosDerivadosDTO>();

		List<OperacionOtrosDerivadosDTO> resultados = ((OperacionDerivadoRepository) repository).searchList(operacionSearch);
		
		Log.info("Se obtuvo los resultados");
		consultaDinamica.setColumnas(headExcel());
		consultaDinamica.setRegistros(resultados);
		consultaDinamica.setOrden(loadOrden());
		return consultaDinamica;
	}

	public List<String> headExcel() {
		List<String> columns = new ArrayList<String>();
		columns.add("Historico");
		columns.add("Efectiva");
		columns.add("Movimiento");
		columns.add("F. Reporte");
		columns.add("Termino");
		columns.add("Proceso");
		columns.add("Estado");
		columns.add("Producto");
		columns.add("Operación");
		columns.add("Reporte");
		columns.add("Cliente");
		columns.add("Nombre Cliente");
		columns.add("Tipo");
		columns.add("Divisa E.");
		columns.add("Divisa S.");
		columns.add("Importe E.");
		columns.add("Prima");
		columns.add("Delta");
		columns.add("Cambio P.");
		columns.add("Importe USD");
		columns.add("Observaciones");
//		columns.add("CallPut");
//		columns.add("Divisa Prima");
//		columns.add("Importe Prima");
//		columns.add("Tasa MN");
//		columns.add("Tasa ME");

		return columns;
	}
	public List<String> loadOrden() {
		List<String> columns = new ArrayList<String>();
		columns.add("historico");
		columns.add("fechaefectiva");
		columns.add("fechamovimiento");
		columns.add("fechareporte");
		columns.add("fechatermino");
		columns.add("tipoproceso");
		columns.add("tipoestado");
		columns.add("productodescripcion");
		columns.add("numerooperacion");
		columns.add("codigoreporte");
//		columns.add("operacionsustituye");
		columns.add("clientecodigo");
		columns.add("clientenombre");
		columns.add("tipooperaciondescripcion");
		columns.add("divisadescripcion");
		columns.add("divisasalida");
		columns.add("importedivisa");
//		columns.add("importedivisasalida");
		columns.add("prima");
		columns.add("delta");
		columns.add("tipocambiopactado");
		columns.add("importeusd");
		columns.add("observaciones");
//		columns.add("divisaPrimaCodigo");
//		columns.add("prima");
//		columns.add("");
//		columns.add("tasamonedaextranjera");

		return columns;
	}

	
	@Override
	public void generarCodigoReporteDerivados(Carga carga) {
		((OperacionDerivadoRepository) repository).generarCodigoReporteDerivados(carga);
	}
	
	@Override
	public void generaUsuariosDivas(Carga carga) {
		((OperacionDerivadoRepository) repository).generaUsuariosDivas(carga);
	}
	
	@Override
	public void eliminarOperacionDerivadoPorIdCarga(String idcarga) {
		((OperacionDerivadoRepository) repository).eliminarOperacionDerivadoPorIdCarga(idcarga);
	}
	
}
