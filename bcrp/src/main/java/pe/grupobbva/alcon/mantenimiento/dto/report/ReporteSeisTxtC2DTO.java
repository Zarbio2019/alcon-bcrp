package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.ConstantCode;
import pe.grupobbva.alcon.mantenimiento.util.ReportUtils;

@Data
public class ReporteSeisTxtC2DTO {
	private String codigoreporte;
	private String importeusd; /*Monto nominal*/
	private String tipocliente;
	private String clientenombre;
	private String documentocliente;
	private String sectorcliente;
	private String residente;
	private String clientepaisresidencia;
	private String montomonedaentrega;
	private String divisaentradadescripcion;
	private String fechaefectiva;
	private String fechatermino;
	private String tipoentrega;
	private String recibetasafijaspread;
	private String recibetfija;
	private String recibeindentificadorfrecuencia;
	private String pagatasafijaspread;
	private String pagatfija;
	private String pagaidentificadorfrecuencia;
	private String tipooperacion;
	private String opcion;
	private String estilo;
	private String strikerate;
	private String benchmark;
	private String frecuenciabrenchmark;
	private String volatilidad;
	private String prima;
	private String delta;
	private String intencioncontratacion;
	private String tipoaccion;
	private String observacion;
	

	public ReporteSeisTxtC2DTO() {
		super();
	}

	public ReporteSeisTxtC2DTO(ReporteSeisC2DTO dto) {
		super();

		ReportUtils utils = new ReportUtils();

		this.codigoreporte = utils.completeSpace(dto.getCodigoreporte(), 16);
		//this.importeusd = utils.completeZeros(dto.getImporteusd(), 2, 14);
		this.importeusd = utils.addSignLeft(dto.getImporteusd(), 2, 14);
		this.tipocliente = utils.completeSpace(dto.getTipocliente(), 1);
		this.clientenombre = utils.completeSpace(dto.getClientenombre(), 30);
		this.documentocliente = utils.completeSpace(dto.getDocumentocliente(), 11);
		this.sectorcliente = utils.completeSpace(dto.getSectorcliente(), 4);
		this.residente = utils.completeSpace(dto.getResidente(), 1);
		this.clientepaisresidencia = utils.completeSpace(dto.getClientepaisresidencia(), 2);
		this.montomonedaentrega = utils.completeZeros(dto.getImportedivisasalida(), 2, 14);
		this.divisaentradadescripcion = utils.completeSpace(dto.getDivisaentradadescripcion(), 3);
		this.fechaefectiva = dto.getFechavalor() != null ? utils.dateFormat(dto.getFechavalor()) : utils.completeSpace(null, 8);
		this.fechatermino = dto.getFechavencimiento() != null ? utils.dateFormat(dto.getFechavencimiento()) : utils.completeSpace(null, 8); 
		this.tipoentrega = utils.completeSpace(dto.getTipoentrega(), 1);
		this.recibetasafijaspread = utils.completeZeros(dto.getRecibetasafijaspread(), 4, 8);
		this.recibetfija = utils.completeSpace(dto.getRecibetfija(), 5);
		this.recibeindentificadorfrecuencia = utils.completeSpace(dto.getRecibeidentificadorfrecuencia(), 3);
		this.pagatasafijaspread = utils.completeZeros(dto.getPagatasafijaspread(), 4, 8);
		this.pagatfija = utils.completeSpace(dto.getPagatfija(), 5);
		this.pagaidentificadorfrecuencia = utils.completeSpace(dto.getPagaidentificadorfrecuencia(), 3);
		this.tipooperacion = utils.completeSpace(dto.getTipooperacion(), 1);
		this.opcion = utils.completeSpace(dto.getTipoopcion(), 1);
		this.estilo = utils.completeSpace(dto.getEstilo(), 1);
		this.strikerate = utils.completeZeros(dto.getStrikerate(), 4, 8);
		this.benchmark = utils.completeSpace(dto.getBenchmark(), 5);
		this.frecuenciabrenchmark = utils.completeSpace(dto.getFrecuenciabenchmark(), 3);
		this.volatilidad = utils.completeZeros(dto.getVolatilidad(), 2, 5);
		this.prima = utils.completeZeros(dto.getPrima(), 2, 10);
		this.delta = utils.completeZeros(dto.getDelta(), 4, 5);
		this.intencioncontratacion = utils.completeSpace(dto.getIntencioncontratacion(), 1);
		this.tipoaccion = utils.completeSpace(dto.getTipoaccion(), 1);
		this.observacion = utils.completeSpace(dto.getObservaciones(), 30);
	
	}

	
	public List<String> headExcel(){
		List<String> columns = new ArrayList<String>();
		 columns.add("Identificador");
		 columns.add("Monto nominal USD");
		 columns.add("Tipo contraparte");
		 columns.add("Nombre contraparte");
		 columns.add("Documento contraparte");
		 columns.add("Sector econ??mico");
		 columns.add("Tipo residencia");
		 columns.add("Pais residencia");
		 columns.add("Monto nominal");
		 columns.add("C??digo moneda");
		 columns.add("Fecha efectiva");
		 columns.add("Fecha t??rmino");
		 columns.add("Tipo Liquidaci??n");
		 columns.add("Recibe tasa fija");
		 columns.add("Recibe TFIJA");
		 columns.add("Recibe indentificador frecuencia");
		 columns.add("Paga tasa fija");
		 columns.add("Paga TFIJA");
		 columns.add("Paga indentificador frecuencia");
		 columns.add("Opci??n: Operaci??n");		 
		 columns.add("Opci??n: Tipo");
		 columns.add("Opci??n: Ejercicio");
		 columns.add("Opci??n: Strike rate");
		 columns.add("Opci??n: Benchmark");
		 columns.add("Opci??n: Frecuencia del benchmark");
		 columns.add("Opci??n: Volatilidad");
		 columns.add("Opci??n: Prima");
		 columns.add("Opci??n: Delta");
		 columns.add("Intenci??n de contrataci??n");
		 columns.add("Tipo acci??n");
		 columns.add("Observaci??n");
		 
		return columns;
	}
	
	public List<String> headTxt(Date fecha) {
		ConstantCode constantCode = new ConstantCode();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyMMdd");

		List<String> columns = new ArrayList<String>();
		columns.add(constantCode.getCodInstitucion());
		columns.add(constantCode.getNumReporteSeis());
		columns.add(formatter.format(fecha));
		columns.add(constantCode.getUnidad());

		return columns;
	}

}
