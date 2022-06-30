package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.ConstantCode;
import pe.grupobbva.alcon.mantenimiento.util.ReportUtils;

@Data
public class ReporteTresTxtC2DTO {
	private String codigoreporte;
	private String tipooperacion;
	private String importeusd;
	private String tipocliente;
	private String clientenombre;
	private String documentocliente;
	private String sectorcliente;
	private String residente;
	private String clientepaisresidencia;
	private String divisasalidadescripcion;
	private String montomonedaentrega;
	private String divisaentradadescripcion;
	private String montomonedarecibe;
	private String tcspot;
	private String tipocambiopactado;
	private String tipoentrega;
	private String fechaefectiva;
	private String fechatermino;
	private String recibetasafijaspread;
	private String recibetfija;
	private String recibeindentificadorfrecuencia;
	private String pagatasafijaspread;
	private String pagatfija;
	private String pagaidentificadorfrecuencia;
	private String opcion;
	private String estilo;
	private String volatilidad;
	private String prima;
	private String delta;
	private String tasacambiovencimiento;
	private String fechaejercicio;
	private String intencioncontratacion;
	private String tipoaccion;
	private String observacion;
	
	
	public ReporteTresTxtC2DTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReporteTresTxtC2DTO(ReporteTresC2DTO dto) {
		super();
		
		ReportUtils Utils = new ReportUtils();
		
		this.codigoreporte = Utils.completeSpace(dto.getCodigoreporte(), 16);
		this.tipooperacion = Utils.completeSpace(dto.getTipooperacion(), 1);
		this.importeusd = Utils.addSignLeft(dto.getImporteusd(), 2, 14);
		this.tipocliente = Utils.completeSpace(dto.getTipocliente(), 1);
		this.clientenombre = Utils.completeSpace(dto.getClientenombre(), 30);
		this.documentocliente = Utils.completeSpace(dto.getDocumentocliente(), 11);
		this.sectorcliente = Utils.completeSpace(dto.getSectorcliente(), 4);
		this.residente = Utils.completeSpace(dto.getResidente(), 1);
		this.clientepaisresidencia = Utils.completeSpace(dto.getClientepaisresidencia(), 2);
		this.divisasalidadescripcion = Utils.completeSpace(dto.getDivisasalidadescripcion(), 3);
		this.montomonedaentrega = Utils.addSignLeft(dto.getImportedivisasalida(), 2, 14);
		this.divisaentradadescripcion = Utils.completeSpace(dto.getDivisaentradadescripcion(), 3);
		this.montomonedarecibe = Utils.addSignLeft(dto.getImportedivisaentrada(), 2, 14);
		this.tcspot = Utils.completeZeros(dto.getTipocambiospot(), 4, 8);
		this.tipocambiopactado = Utils.completeZeros(dto.getTipocambiopactado(), 4, 8);
		this.tipoentrega = Utils.completeSpace(dto.getTipoentrega(), 1);
		
		this.fechaefectiva = dto.getFechavalor() != null ? Utils.dateFormat(dto.getFechavalor()) : Utils.completeSpace(null, 8);
		this.fechatermino = dto.getFechavencimiento() != null ? Utils.dateFormat(dto.getFechavencimiento()) : Utils.completeSpace(null, 8); //TODO falta colocar valores
		
		this.recibetasafijaspread = Utils.addSignLeft(dto.getRecibetasafijaspread(), 4, 8);
		this.recibetfija = Utils.completeSpace(dto.getRecibetfija(), 5);
		this.recibeindentificadorfrecuencia = Utils.completeSpace(dto.getRecibeidentificadorfrecuencia(), 3);
		this.pagatasafijaspread = Utils.addSignLeft(dto.getPagatasafijaspread(), 4, 8);
		this.pagatfija = Utils.completeSpace(dto.getPagatfija(), 5);
		this.pagaidentificadorfrecuencia = Utils.completeSpace(dto.getPagaidentificadorfrecuencia(), 3);
		
		this.opcion = Utils.completeSpace(dto.getTipoopcion(), 1);
		this.estilo = Utils.completeSpace(dto.getEstilo(), 1);
		this.volatilidad = Utils.completeZeros(dto.getVolatilidad(), 2, 5);
		
		this.prima = Utils.completeZeros(dto.getPrima(), 2, 10);
		this.delta = Utils.completeZeros(dto.getDelta(), 2, 5);
		this.tasacambiovencimiento = Utils.completeZeros(null, 4, 8); // 8 ceros por defecto (0.000000)
		this.fechaejercicio = Utils.completeZeros(null, 0, 8);// 8 espacios por defecto
		
		this.intencioncontratacion = Utils.completeSpace(dto.getIntencioncontratacion(), 1);
		this.tipoaccion = Utils.completeSpace(dto.getTipoaccion(), 1);
		this.observacion = Utils.completeSpace(dto.getObservaciones(), 30);
		
	}
	
	public List<String> headExcel(){
		List<String> columns = new ArrayList<String>();
		 columns.add("Identificador");
		 columns.add("Operación");
		 columns.add("Monto de la operación");
		 columns.add("Tipo contraparte");
		 columns.add("Nombre contraparte");
		 columns.add("Documento contraparte");
		 columns.add("Sector económico");
		 columns.add("Tipo residencia");
		 columns.add("Pais residencia");
		 columns.add("Código moneda entrega");
		 columns.add("Monto moneda entrega");
		 columns.add("Código moneda recibe");
		 columns.add("Monto moneda recibe");
		 columns.add("T.C Spot");
		 columns.add("T.C Pactado");
		 columns.add("Tipo Liquidación");
		 columns.add("Fecha efectiva");
		 columns.add("Fecha término");
		 columns.add("Recibe tasa fija");
		 columns.add("Recibe TFIJA");
		 columns.add("Recibe indentificador frecuencia");
		 columns.add("Paga tasa fija");
		 columns.add("Paga TFIJA");
		 columns.add("Paga indentificador frecuencia");
		 columns.add("Opción: Tipo");
		 columns.add("Opción: Ejercicio");
		 columns.add("Opción: Volatilidad");
		 columns.add("Opción: Prima");
		 columns.add("Opción: Delta");
		 columns.add("T.C al vencimiento");
		 columns.add("Fecha de ejercicio");
		 columns.add("Intención de contratación");
		 columns.add("Tipo acción");
		 columns.add("Observaciones");
		 
		
		return columns;
	}
	
	public List<String> headTxt(Date fecha,String tipoproceso){
		ConstantCode constantCode = new ConstantCode();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyMMdd");
		
		List<String> columns = new ArrayList<String>();
		columns.add(constantCode.getCodInstitucion());
		columns.add(tipoproceso);
		columns.add(constantCode.getNumReporteTres());
		columns.add(formatter.format(fecha));
		columns.add(constantCode.getUnidad());
		
		return columns;
	}

}
