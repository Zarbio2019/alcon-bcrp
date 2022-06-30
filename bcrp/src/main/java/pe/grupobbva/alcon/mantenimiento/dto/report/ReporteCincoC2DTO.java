package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;

@Data
public class ReporteCincoC2DTO {
	private String id; 
	private String numerooperacion; 
	private String idCliente; 
	private String clientecodigo;
	private String clientenombre;
	private Calendar fechacontratacion; 
	private Calendar fechavalor;
	private Calendar fechavencimiento; 
	private String iddivisaentrada;
	private String codigodivisaentrada;
	private String iddivisasalida;
	private String codigodivisasalida;
	private BigDecimal importedivisaentrada;
	private BigDecimal importedivisasalida;
	private Integer plazo; 
	private String tipooperacion;
	private BigDecimal cotizacion; 
	private BigDecimal cambioref; 
	private Calendar fechaejercicio; 
	private String callput; 
	private BigDecimal prima; 
	private String iddivisaprima; 
	private String codigodivisaprima;
	private String observaciones;
	private String tipoopcion;
	private String tipoproceso; 
	private String codigooperacion; 
	private BigDecimal importeusd = BigDecimal.ZERO;
	private BigDecimal delta; 
	private String iddelta;
	private BigDecimal deltad;
	private String descripcion;
	private BigDecimal importedelta;
	private BigDecimal cobertura;
	private Calendar fechaproceso;
	private String codigoreporte;  
	private String estado;
	

	public ReporteCincoC2DTO() {
		super();
	}

	public void updtReporteCincoC2DTO(ReporteCincoUpdateDeltaC2DTO dto) {
		this.numerooperacion = dto.getNumerooperacion();
		this.iddelta = dto.getId();
		this.deltad = dto.getDeltas();
		this.descripcion = dto.getDescripcion();
		this.cobertura = dto.getCobertura();
		this.fechaproceso = dto.getFechaproceso();
		this.estado = dto.getEstado();
		this.importedelta= this.importeusd.multiply(dto.getDeltas()).setScale(2 ,BigDecimal.ROUND_HALF_UP);
	}

	public ReporteCincoC2DTO(String id, String numerooperacion, String idCliente, String clientecodigo,
			String clientenombre, Calendar fechacontratacion, Calendar fechavalor, Calendar fechavencimiento,
			String iddivisaentrada, String codigodivisaentrada, String iddivisasalida, String codigodivisasalida,
			BigDecimal importedivisaentrada, BigDecimal importedivisasalida, Integer plazo, String tipooperacion,
			BigDecimal cotizacion, BigDecimal cambioref, Calendar fechaejercicio, String callput, BigDecimal prima,
			String iddivisaprima, String codigodivisaprima, String observaciones, String tipoopcion, String tipoproceso,
			String codigooperacion, BigDecimal importeusd, BigDecimal delta, String iddelta, BigDecimal deltad,
			String descripcion, BigDecimal importedelta, BigDecimal cobertura, Calendar fechaproceso,
			String codigoreporte, String estado) {
		super();
		this.id = id;
		this.numerooperacion = numerooperacion;
		this.idCliente = idCliente;
		this.clientecodigo = clientecodigo;
		this.clientenombre = clientenombre;
		this.fechacontratacion = fechacontratacion;
		this.fechavalor = fechavalor;
		this.fechavencimiento = fechavencimiento;
		this.iddivisaentrada = iddivisaentrada;
		this.codigodivisaentrada = codigodivisaentrada;
		this.iddivisasalida = iddivisasalida;
		this.codigodivisasalida = codigodivisasalida;
		this.importedivisaentrada = importedivisaentrada;
		this.importedivisasalida = importedivisasalida;
		this.plazo = plazo;
		this.tipooperacion = tipooperacion;
		this.cotizacion = cotizacion;
		this.cambioref = cambioref;
		this.fechaejercicio = fechaejercicio;
		this.callput = callput;
		this.prima = prima;
		this.iddivisaprima = iddivisaprima;
		this.codigodivisaprima = codigodivisaprima;
		this.observaciones = observaciones;
		this.tipoopcion = tipoopcion;
		this.tipoproceso = tipoproceso;
		this.codigooperacion = codigooperacion;
		this.importeusd = importeusd;
		this.delta = delta;
		this.iddelta = iddelta;
		this.deltad = deltad;
		this.descripcion = descripcion;
		this.importedelta = importedelta;
		this.cobertura = cobertura;
		this.fechaproceso = fechaproceso;
		this.codigoreporte = codigoreporte;
		this.estado = estado;
	}

	
	
}
