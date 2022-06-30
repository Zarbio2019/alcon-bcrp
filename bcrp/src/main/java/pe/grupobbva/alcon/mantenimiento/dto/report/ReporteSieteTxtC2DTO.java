package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.ConstantCode;
import pe.grupobbva.alcon.mantenimiento.util.ReportUtils;

@Data
public class ReporteSieteTxtC2DTO {
	private String codigoreporte;
	private String tipooperacion;
	private String importeusd;
	private String tipocliente;
	private String clientenombre;
	private String documentocliente;
	private String sectorcliente;
	private String residente;
	private String clientepaisresidencia;
	private String tiposubyacente;
	private String descripcionsubyacente;
	private String fechaefectiva;
	private String fechatermino;
	private String tipoentrega;
	private String preciopactado;
	private String commoditytamanocontratounid;
	private String commoditytamanounidmedida;
	private String cdscupon;
	private String cdstradeddpread;
	private String cdsfrecpagomeses;
	private String trstipooperacion;
	private String trstasa;
	private String trsfija;
	private String trsfrepagomes;
	private String callput;
	private String estilo;
	private String volatilidad;
	private String prima;
	private String delta;
	private String intencioncontratacion;
	private String tipoaccion;
	private String observacion;

	public ReporteSieteTxtC2DTO() {
		super();

	}

	public ReporteSieteTxtC2DTO(ReporteSieteC2DTO dto) {
		super();

		ReportUtils utils = new ReportUtils();

		this.codigoreporte = utils.completeSpace(dto.getCodigoreporte(), 16);
		this.tipooperacion = utils.completeSpace(dto.getTipooperacion(), 1);
		this.importeusd = utils.completeZeros(dto.getImporteusd(), 2, 14);
		//this.importeusd = utils.addSignLeft(dto.getImporteusd(), 2, 14);
		this.tipocliente = utils.completeSpace(dto.getTipocliente(), 1);
		this.clientenombre = utils.completeSpace(dto.getClientenombre(), 30);
		this.documentocliente = utils.completeSpace(dto.getDocumentocliente(), 11);
		this.sectorcliente = utils.completeSpace(dto.getSectorcliente(), 4);
		this.residente = utils.completeSpace(dto.getResidente(), 1);
		this.clientepaisresidencia = utils.completeSpace(dto.getClientepaisresidencia(), 2);
		this.tiposubyacente = utils.completeSpace(dto.getTiposubyacente(), 2);
		this.descripcionsubyacente = utils.completeSpace(dto.getDescripcionsubyacente(), 30);
		this.fechaefectiva = dto.getFechaefectiva() != null ? utils.dateFormat(dto.getFechaefectiva()) : utils.completeSpace(null, 8);
		this.fechatermino = dto.getFechatermino() != null ? utils.dateFormat(dto.getFechatermino()) : utils.completeSpace(null, 8);
		this.tipoentrega = utils.completeSpace(dto.getTipoentrega(), 1);
		this.preciopactado = utils.completeZeros(dto.getPreciopactado(), 4, 11);
		this.commoditytamanocontratounid = utils.completeZeros(dto.getCommoditytamanocontratounid(), 2, 14);
		this.commoditytamanounidmedida = utils.completeSpace(dto.getCommoditytamanounidmedida(), 10);
		this.cdscupon = utils.completeZeros(dto.getCdscupon(), 4, 9);
		this.cdstradeddpread = utils.completeZeros(dto.getCdstradeddpread(), 4, 9);
		this.cdsfrecpagomeses = utils.completeSpace(dto.getCdsfrecpagomeses(), 2);
		this.trstipooperacion = utils.completeSpace(dto.getTrstipooperacion(), 1);
		this.trstasa = utils.completeZeros(dto.getTrstasa(), 4, 8);
		this.trsfija = utils.completeSpace(dto.getTrsfija(), 5);
		this.trsfrepagomes = utils.completeSpace(dto.getTrsfrepagomes(), 3);
		this.callput = utils.completeSpace(dto.getCallput(), 1);
		this.estilo = utils.completeSpace(dto.getEstilo(), 1);
		this.volatilidad = utils.completeZeros(dto.getVolatilidad(), 2, 5);
		this.prima = utils.completeZeros(dto.getPrima(), 2, 10);
		this.delta = utils.completeZeros(dto.getDelta(), 4, 5);
		this.intencioncontratacion = utils.completeSpace(dto.getIntencioncontratacion(), 1);
		this.tipoaccion = utils.completeSpace(dto.getTipoaccion(), 1);
		this.observacion = utils.completeSpace(dto.getObservaciones(), 50);
	
	}

	
	public List<String> headExcel(){
		List<String> columns = new ArrayList<String>();
		 columns.add("Identificador");
		 columns.add("Operación");
		 columns.add("Monto nominal USD");
		 columns.add("Tipo contraparte");
		 columns.add("Nombre contraparte");
		 columns.add("Documento contraparte");
		 columns.add("Sector económico");
		 columns.add("Tipo residencia");
		 columns.add("Pais residencia");
		 columns.add("Tipo del subyacente");
		 columns.add("Descripción del subyacente");
		 columns.add("Fecha efectiva");
		 columns.add("Fecha término");
		 columns.add("Tipo liquidación");
		 columns.add("Precio pactado");
		 columns.add("Tamaño contrato unidades");
		 columns.add("Unidad de medida");
		 columns.add("CDS: Cupón");
		 columns.add("CDS: Traded spread");
		 columns.add("CDS: Frecuencia de pago en meses");
		 columns.add("Total Return Swap: Tipo Operación");
		 columns.add("Total Return Swap: Tasa fija");
		 columns.add("Total Return Swap: TFIJA");
		 columns.add("Total Return Swap: Frecuencia de pago en meses");
		 columns.add("Opción: Tipo");
		 columns.add("Opción: Ejercicio");
		 columns.add("Opción: Volatilidad");
		 columns.add("Opción: Prima");
		 columns.add("Opción: Delta");
		 columns.add("Intención de contratación");
		 columns.add("Tipo acción");
		 columns.add("Observaciones");
		 
		
		return columns;
	}
	
	public List<String> headTxt(Date fecha) {
		ConstantCode constantCode = new ConstantCode();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyMMdd");

		List<String> columns = new ArrayList<String>();
		columns.add(constantCode.getCodInstitucion());
		columns.add(constantCode.getNumReporteSiete());
		columns.add(formatter.format(fecha));
		columns.add(constantCode.getUnidad());

		return columns;
	}

}
