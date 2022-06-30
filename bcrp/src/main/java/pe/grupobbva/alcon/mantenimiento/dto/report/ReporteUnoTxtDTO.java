package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.ConstantCode;
import pe.grupobbva.alcon.mantenimiento.util.ReportUtils;

@Data
public class ReporteUnoTxtDTO {
	private String codigoreporte;
	private String tipooperacion;
	private String importeusd;
	private String tipocliente;
	private String clientenombre;
	private String sectorcliente;
	private String residente;
	private String clientepaisresidencia;
	private String montomonedaextranjera;
	private String monedaextranjeradescripcion;
	private String montopen;
	private String divisasalidadescripcion;
	private String divisaentradadescripcion;
	private String tcspot;
	private String tasamonedanacional;
	private String tasamonedaextranjera;
	private String tasadiferencial;
	private String tipocambiopactado;
	private String tipoentrega;
	private String fechavalor;
	private String plazo;
	private String fechavencimiento;
	private String fechaejercicio;
	private String tasacambiovencimiento;
	private String estilo;
	private String opcion;
	private String prima;
	private String delta;
	private String contrato;
	private String observacion;
	
	public ReporteUnoTxtDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ReporteUnoTxtDTO(ReporteUnoDTO dto) {
		super();
		
		ReportUtils Utils = new ReportUtils();
		
		this.codigoreporte = dto.getCodigoreporte();
		this.tipooperacion = dto.getTipooperacion();
		this.importeusd    = Utils.completeZeros(dto.getImporteusd(), 2, 12);
		this.tipocliente   = dto.getTipocliente();
		this.clientenombre = Utils.completeSpace(dto.getClientenombre(), 30);
		this.sectorcliente = Utils.completeSpace(dto.getSectorcliente(),4);
		this.residente     = Utils.completeSpace(dto.getResidente(),1);
		this.clientepaisresidencia = dto.getClientepaisresidencia();
		this.montomonedaextranjera = Utils.completeZeros(dto.getMontomonedaextranjera(), 2,12);
		this.monedaextranjeradescripcion= Utils.completeSpace(dto.getMonedaextranjeradescripcion(),3);
		this.montopen = Utils.completeZeros(dto.getMontopen(), 2, 12);
		this.divisasalidadescripcion = dto.getDivisasalidadescripcion();
		this.divisaentradadescripcion = dto.getDivisaentradadescripcion();
		this.tcspot = Utils.completeZeros(dto.getTipocambiospot(), 4, 8);
		this.tasamonedanacional= Utils.addSignLeft(dto.getTasamonedanacional(), 2, 5);
		this.tasamonedaextranjera = Utils.addSignLeft(dto.getTasamonedaextranjera(), 2, 5);
		this.tasadiferencial=Utils.completeZeros(dto.getTasadiferencial(), 2, 5, true);
		this.tipocambiopactado = Utils.completeZeros(dto.getTipocambiopactado(), 4, 8);
		this.tipoentrega = Utils.completeSpace(dto.getTipoentrega(),1);
		
		if(dto.getFechavalor()!=null && StringUtils.isBlank(this.tipoentrega)) {
			this.fechavalor = Utils.dateFormat(dto.getFechavalor());
		}else {
			this.fechavalor = Utils.completeZeros(null,0,8);
		}
		
		this.plazo = Utils.completeZeros(new BigDecimal(dto.getPlazo()!=null?dto.getPlazo():0), 0, 5);
		
		if(dto.getFechavencimiento()!=null && !StringUtils.isBlank(this.tipoentrega)) {
			this.fechavencimiento = Utils.dateFormat(dto.getFechavencimiento());
		}else {
			this.fechavencimiento = Utils.completeSpace(null, 8);
		}
		
		this.fechaejercicio =Utils.completeSpace(null, 8); //se aplica solo en el reporte 2 13/
		this.tasacambiovencimiento = Utils.completeZeros(null,0,8); // 8 ceros por defecto (0.000000)
		this.estilo = Utils.completeSpace(dto.getEstilo(),1);
		this.opcion = Utils.completeSpace(dto.getTipoopcion(),1);
		this.prima = Utils.completeZeros(dto.getPrima(),2, 10);
		this.delta = Utils.completeZeros(dto.getDelta(), 2, 5);
		this.contrato = Utils.completeZeros(dto.getDelta(), 2, 5);
		this.observacion= Utils.completeSpace(dto.getObservaciones(), 30);
		
	}
	
	public List<String> headTxt(Date fecha,String tipoproceso){
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
