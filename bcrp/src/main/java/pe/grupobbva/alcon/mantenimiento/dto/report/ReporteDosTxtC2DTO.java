package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.ConstantCode;
import pe.grupobbva.alcon.mantenimiento.util.ReportUtils;

@Data
public class ReporteDosTxtC2DTO {
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
	

	public ReporteDosTxtC2DTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReporteDosTxtC2DTO(ReporteDosC2DTO dto) {
		super();

		ReportUtils utils = new ReportUtils();

		this.codigoreporte = utils.completeSpace(dto.getCodigoreporte(), 16);
		this.tipooperacion = utils.completeSpace(dto.getTipooperacion(), 1);
		this.importeusd = utils.addSignLeft(dto.getImporteusd(), 2, 14);
		this.tipocliente = utils.completeSpace(dto.getTipocliente(), 1);
		this.clientenombre = utils.completeSpace(dto.getClientenombre(), 30);
		this.documentocliente = utils.completeSpace(dto.getDocumentocliente(), 11);
		this.sectorcliente = utils.completeSpace(dto.getSectorcliente(), 4);
		this.residente = utils.completeSpace(dto.getResidente(), 1);
		this.clientepaisresidencia = utils.completeSpace(dto.getClientepaisresidencia(), 2);
		this.divisasalidadescripcion = utils.completeSpace(dto.getDivisasalidadescripcion(), 3);
		this.montomonedaentrega = utils.addSignLeft(dto.getImportedivisasalida(), 2, 14);
		this.divisaentradadescripcion = utils.completeSpace(dto.getDivisaentradadescripcion(), 3);
		this.montomonedarecibe = utils.addSignLeft(dto.getImportedivisaentrada(), 2, 14);
		this.tcspot = utils.completeZeros(dto.getTipocambiospot(), 4, 8);
		this.tipocambiopactado = utils.completeZeros(dto.getTipocambiopactado(), 4, 8);
		this.tipoentrega = utils.completeSpace(dto.getTipoentrega(), 1);

		this.fechaefectiva = dto.getFechavalor() != null ? utils.dateFormat(dto.getFechavalor()) : utils.completeSpace(null, 8);
		this.fechatermino = dto.getFechavencimiento() != null ? utils.dateFormat(dto.getFechavencimiento()) : utils.completeSpace(null, 8); //TODO falta colocar valores
		
		this.recibetasafijaspread = utils.addSignLeft(dto.getRecibetasafijaspread(), 4, 8);
		this.recibetfija = utils.completeSpace(dto.getRecibetfija(), 5);
		this.recibeindentificadorfrecuencia = utils.completeSpace(dto.getRecibeidentificadorfrecuencia(), 3);
		this.pagatasafijaspread = utils.addSignLeft(dto.getPagatasafijaspread(), 4, 8);
		this.pagatfija = utils.completeSpace(dto.getPagatfija(), 5);
		this.pagaidentificadorfrecuencia = utils.completeSpace(dto.getPagaidentificadorfrecuencia(), 3);
		
		this.opcion = utils.completeSpace(dto.getTipoopcion(), 1);
		this.estilo = utils.completeSpace(dto.getEstilo(), 1);
		this.volatilidad = utils.completeZeros(dto.getVolatilidad(), 2, 5);
		
		this.prima = utils.completeZeros(dto.getPrima(), 2, 10);
		this.delta = utils.completeZeros(dto.getDelta(), 2, 5);
		this.tasacambiovencimiento = utils.completeZeros(dto.getTipocambiovencimiento(), 4, 8);
		
		if (dto.getProductodescripcion().equals("OTFX")) {
			this.fechaejercicio = dto.getFechaejercicio() != null ? utils.dateFormat(dto.getFechaejercicio()) : utils.completeZeros(null, 0, 8);
		} else {
			this.fechaejercicio = utils.completeZeros(null, 0, 8);// 8 espacios por defecto
		}
		
		this.intencioncontratacion = utils.completeSpace(dto.getIntencioncontratacion(), 1);
		this.tipoaccion = utils.completeSpace(dto.getTipoaccion(), 1);
		this.observacion = utils.completeSpace(dto.getObservaciones(), 30);
		
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

	public List<String> headTxt(Date fecha, String tipoproceso) {
		ConstantCode constantCode = new ConstantCode();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyMMdd");

		List<String> columns = new ArrayList<String>();
		columns.add(constantCode.getCodInstitucion());
		columns.add(tipoproceso);
		columns.add(constantCode.getNumReporteUno());
		columns.add(formatter.format(fecha));
		columns.add(constantCode.getUnidad());

		return columns;
	}

}
