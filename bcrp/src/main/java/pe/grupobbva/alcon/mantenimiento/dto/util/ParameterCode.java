package pe.grupobbva.alcon.mantenimiento.dto.util;

import lombok.Data;

@Data
public class ParameterCode {

	private final String posicionCambiaria = "001";
	private final String tipoOperacion = "002";
	private final String tipoEntrega = "003";
	private final String tipoCliente = "004";
	private final String tipoResidente = "005";
	private final String tipoCallPut = "006";
	private final String pais = "007";
	private final String entidadCliente = "008";
	private final String cargaCliente = "009";
	private final String meses = "010";
	private final String anios = "011";
	private final String tipoFeriado = "012";
	private final String tipoProceso = "013";
	private final String estadoOperacion = "014";
	private final String estiloOpcionOperacion = "015";
	private final String tipoContratoOperacion = "016";
	private final String cargaArchivos = "017";
	private final String tipoDatoPlantilla = "018";
	private final String signoPlantilla = "019";
	private final String movimientoPosicionCambiaria = "020";
	private final String cuentas = "021";
	private final String estadoOperaciones = "022";
	private final String subProductoFxVigentes = "023";
	private final String compraVentaFxVigentes = "024";
	private final String columnaFechaVencimientoFxVigentes = "025";
	private final String columnaDivisaFxVigentes = "026";
	private final String claseRentaVariable = "027";
	private final String carteraRentaVariable = "028";
	private final String divisa = "029";
	private final String columnaImporteRentaVariable = "030";
	private final String subProductoSpeFrair = "031";
	private final String compraVentaSpeFrair = "032";
	private final String columnaDivisaSpeFrair = "033";
	private final String columnaImporteSpeFrair = "034";
	private final String carteraRentaFija = "035";
	private final String claseRentaFija = "036";
	private final String columnaImporteRentaFija = "037";
	private final String spotCdrs = "038";
	private final String fechaNuevaCircular = "039";
	private final String tipoDocumento = "040";
	private final String benchmark = "041";
	private final String curva = "042";
	private final String productoTasaCurva = "043";
	private final String tenorDias = "044";
	private final String rutacarpetastaraltamira = "045";
	private final String nombrearchivostaraltamira = "046";
	private final String HoraTareaProgramada = "047";
	private final String CredencialesServicioInterfazCliente = "048";
	private final String paisAlfaTres = "049";
	private final String archivosAnexoOcho= "050";
	

	
	/**
	 * Columnas
	 * @return
	 */
	
	
	public ParameterColumnsDTO getColumns(String codigo){
		ParameterColumnsDTO columnsresponse = new ParameterColumnsDTO();
		
		 switch(codigo) {
		  case posicionCambiaria:
			  columnsresponse.setDetalle("Posición Cambiaria");
			  columnsresponse.setValor1("Valor");
		  break;
		  case tipoOperacion:
			  columnsresponse.setDetalle("Tipo Operación");
			  columnsresponse.setValor1("Valor Operación");
		  break;
		  case tipoEntrega:
			  columnsresponse.setDetalle("Tipo Entrega");
			  columnsresponse.setValor1("Valor Entrega");
		  break;
		  case tipoCliente:
			  columnsresponse.setDetalle("Tipo Cliente");
			  columnsresponse.setValor1("Valor Cliente");
			  break;
		  case tipoResidente:
			  columnsresponse.setDetalle("Tipo Residente");
			  columnsresponse.setValor1("Valor Residente");
			  break;
		  case tipoCallPut:
			  columnsresponse.setDetalle("Tipo CallPut");
			  columnsresponse.setValor1("Valor CallPut");
			  break;
		  case pais:
			  columnsresponse.setDetalle("Pais");
			  columnsresponse.setValor1("Abreviatura");
			  break;
		  case entidadCliente:
			  columnsresponse.setDetalle("Entidad Cliente");
			  columnsresponse.setValor1("Entidad");
			  columnsresponse.setValor2("Valor 1");
			  columnsresponse.setValor3("Valor 2");
			  columnsresponse.setValor4("Valor 3");
			  break;
		  case cargaCliente:
			  columnsresponse.setDetalle("Cargar Cliente");
			  columnsresponse.setValor1("Valor");
			  break;
		  case meses:
			  columnsresponse.setDetalle("Meses");
			  columnsresponse.setValor1("Número Mes");
			  break;
		  case anios:
			  columnsresponse.setDetalle("Años");
			  columnsresponse.setValor1("Valor Años");
			  break;
		  case tipoFeriado:
			  columnsresponse.setDetalle("Tipo Feriado");
			  columnsresponse.setValor1("Valor");
			  break;
		  case tipoProceso:
			  columnsresponse.setDetalle("Tipo Proceso");
			  columnsresponse.setValor1("Valor Proceso");
			  break;
		  case estadoOperacion:
			  columnsresponse.setDetalle("Estado Operación");
			  columnsresponse.setValor1("Valor");
			  break;
		  case estiloOpcionOperacion:
			  columnsresponse.setDetalle("Estilo Opción Operación");
			  columnsresponse.setValor1("Valor");
			  break;
		  case tipoContratoOperacion:
			  columnsresponse.setDetalle("Tipo Contrato Operación");
			  columnsresponse.setValor1("Valor");
			  break;
		  case cargaArchivos:
			  columnsresponse.setDetalle("Carga Archivos");
			  columnsresponse.setValor1("Valor");
			  columnsresponse.setValor2("Hoja por defecto");
			  columnsresponse.setValor3("Columnas del excel");
			  columnsresponse.setValor4("Inicio de lectura");
			  break;
		  case tipoDatoPlantilla:
			  columnsresponse.setDetalle("Tipo Dato Plantilla");
			  columnsresponse.setValor1("Valor");
			  break;
		  case signoPlantilla:
			  columnsresponse.setDetalle("Signo Plantilla");
			  columnsresponse.setValor1("Valor");
			  break;
		  case movimientoPosicionCambiaria:
			  columnsresponse.setDetalle("Movimiento Posición Camabiaria ");
			  columnsresponse.setValor1("Valor");
			  break;
		  case cuentas:
			  columnsresponse.setDetalle("Cuentas");
			  columnsresponse.setValor1("Tipo Operación");
			  columnsresponse.setValor2("Producto");
			  columnsresponse.setValor3("Tipo CallPut");
			  columnsresponse.setValor4("InfoReport Publico");
			  columnsresponse.setValor5("InfoReportFinanciero");
			  break;
		  case estadoOperaciones:
			  columnsresponse.setDetalle("Estado de Operaciones");
			  columnsresponse.setValor1("Oficina");
			  columnsresponse.setValor2("Estado");
			  break;
		  case subProductoFxVigentes:
	  
			  break;
		  case compraVentaFxVigentes:
	  
			  break;
		  case columnaFechaVencimientoFxVigentes:
	  
			  break;
		  case columnaDivisaFxVigentes:
	  
			  break;
		  case claseRentaVariable:
	  
			  break;
		  case carteraRentaVariable:
	  
			  break;
		  case divisa:
	  
			  break;
		  case columnaImporteRentaVariable:
	  
			  break;
		  case subProductoSpeFrair:
			  
			  break;
		  case compraVentaSpeFrair:
			  
			  break;
		  case columnaDivisaSpeFrair:
			  
			  break;
		  case columnaImporteSpeFrair:
			  
			  break;
		  case carteraRentaFija:
			  
			  break;
		  case claseRentaFija:
			  
			  break;
		  case columnaImporteRentaFija:
			  
			  break;
		  case spotCdrs:
			  
			  break;
		  case fechaNuevaCircular:
			  columnsresponse.setDetalle("Fecha Nueva Circular");
			  columnsresponse.setValor1("Valor");
			  break;
		  case tipoDocumento:
			  columnsresponse.setDetalle("Tipo Documento");
			  columnsresponse.setValor1("Valor");
			  break;
		  case benchmark:
			  columnsresponse.setDetalle("Benchmark");
			  columnsresponse.setValor1("Valor");
			  break;
		  case curva:
			  columnsresponse.setDetalle("Curva");
			  columnsresponse.setValor1("Código");
			  columnsresponse.setValor2("Divisa");
			  break;
		  case productoTasaCurva:
			  columnsresponse.setDetalle("Producto Curva Tasa");
			  columnsresponse.setValor1("Producto");
			  break;
		  case tenorDias:
			  columnsresponse.setDetalle("Tenor");
			  columnsresponse.setValor1("Días");
			  break;
		  case rutacarpetastaraltamira:
			  columnsresponse.setDetalle("Ruta Carpeta Star Altamira");
			  columnsresponse.setValor1("Valor");
			  break;
		  case nombrearchivostaraltamira:
			  columnsresponse.setDetalle("Nombre Archivo Star Altamira");
			  columnsresponse.setValor1("Valor");
			  break;
		  case HoraTareaProgramada:
			  columnsresponse.setDetalle("Hora Tarea Programada");
			  columnsresponse.setValor1("Valor");
			  break;
		  case CredencialesServicioInterfazCliente:
			  columnsresponse.setDetalle("Cred. Servicio Interfaz Cliente");
			  columnsresponse.setValor1("Usuario");
			  columnsresponse.setValor2("Password");
			  break;
		  case paisAlfaTres:
			  columnsresponse.setDetalle("Pais Alfa 3");
			  columnsresponse.setValor1("Abreviatura");
			  break;
		  case archivosAnexoOcho:
			  columnsresponse.setDetalle("Archivos anexo 8");
			  columnsresponse.setValor1("Código");
			  columnsresponse.setValor2("Producto 1");
			  columnsresponse.setValor3("Producto 2");
			  break;
		  default:
			  break;
		}
		 
		return columnsresponse;
	}
	
}
