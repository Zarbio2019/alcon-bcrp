package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;

@Data
public class OperacionOtrosDerivadosDTO {
	private String id;
	private String idcarga;
	private String idProducto;
	private String productodescripcion;
	private String numerooperacion;
	private String codigoreporte;
	private String tipooperacion;
	private String tipooperaciondescripcion;
	private BigDecimal importeusd = BigDecimal.ZERO;
	private String iddivisa;
	private String divisadescripcion;
	private BigDecimal importedivisa;
	private String idcliente;
	private String clientecodigo;
	private String clientenombre;
	private Integer tipodocumento;
	private String tipocliente;
	private String tipoclientedescripcion;
	private String documentocliente;
	private String sectorcliente;
	private String clientepaisresidencia;
	private String residente;
	private String tiposubyacente;
	private String descripcionsubyacente;
	private Calendar fechaefectiva;
	private Calendar fechareporte;
	private Calendar fechatermino;
	private String tipoentrega;
	private BigDecimal preciopactado;
	private BigDecimal commoditytamanocontratounid;
	private String commoditytamanounidmedida;
	private BigDecimal cdscupon;
	private BigDecimal cdstradeddpread;
	private String cdsfrecpagomeses;
	private String trstipooperacion;
	private BigDecimal trstasa;
	private String trsfija;
	private String trsfrepagomes;
	private String callput;
	private String estilo;
	private BigDecimal volatilidad;
	private BigDecimal prima;
	private BigDecimal delta;
	private String intencioncontratacion;
	private String tipoaccion;
	private String observaciones;
	private String tipoproceso;
	private String tipoprocesodesc;
	private Calendar fechamovimiento;
	private Integer idfilaarchivo;
	private Integer codigoestado;

	public OperacionOtrosDerivadosDTO() {
		super();

	}

	public OperacionOtrosDerivadosDTO(String id, String idcarga, String idProducto, String productodescripcion,
			String numerooperacion, String codigoreporte, String tipooperacion, String tipooperaciondescripcion,
			BigDecimal importeusd, String iddivisa, String divisadescripcion, BigDecimal importedivisa,
			String idcliente, String clientecodigo, String clientenombre, Integer tipodocumento, String tipocliente,
			String tipoclientedescripcion, String documentocliente, String sectorcliente, String clientepaisresidencia,
			String residente, String tiposubyacente, String descripcionsubyacente, Calendar fechaefectiva,
			Calendar fechatermino,Calendar fechareporte, String tipoentrega, BigDecimal preciopactado, BigDecimal commoditytamanocontratounid,
			String commoditytamanounidmedida, BigDecimal cdscupon, BigDecimal cdstradeddpread, String cdsfrecpagomeses,
			String trstipooperacion, BigDecimal trstasa, String trsfija, String trsfrepagomes, String callput,
			String estilo, BigDecimal volatilidad, BigDecimal prima, BigDecimal delta, String intencioncontratacion,
			String tipoaccion, String observaciones, String tipoproceso, String tipoprocesodesc,Calendar fechamovimiento,
			Integer idfilaarchivo, Integer codigoestado) {
		super();

		this.id = id;
		this.idcarga = idcarga;
		this.idProducto = idProducto;
		this.productodescripcion = productodescripcion;
		this.numerooperacion = numerooperacion;
		this.codigoreporte = codigoreporte;
		this.tipooperacion = tipooperacion;
		this.tipooperaciondescripcion = tipooperaciondescripcion;
		this.importeusd = importeusd;
		this.iddivisa = iddivisa;
		this.divisadescripcion = divisadescripcion;
		this.importedivisa = importedivisa;
		this.idcliente = idcliente;
		this.clientecodigo = clientecodigo;
		this.clientenombre = clientenombre;
		this.tipodocumento = tipodocumento;
		this.tipocliente = tipocliente;
		this.tipoclientedescripcion = tipoclientedescripcion;
		this.documentocliente = documentocliente;
		this.sectorcliente = sectorcliente;
		this.clientepaisresidencia = clientepaisresidencia;
		this.residente = residente;
		this.tiposubyacente = tiposubyacente;
		this.descripcionsubyacente = descripcionsubyacente;
		this.fechaefectiva = fechaefectiva;
		this.fechatermino = fechatermino;
		this.fechareporte = fechareporte;
		this.tipoentrega = tipoentrega;
		this.preciopactado = preciopactado;
		this.commoditytamanocontratounid = commoditytamanocontratounid;
		this.commoditytamanounidmedida = commoditytamanounidmedida;
		this.cdscupon = cdscupon;
		this.cdstradeddpread = cdstradeddpread;
		this.cdsfrecpagomeses = cdsfrecpagomeses;
		this.trstipooperacion = trstipooperacion;
		this.trstasa = trstasa;
		this.trsfija = trsfija;
		this.trsfrepagomes = trsfrepagomes;
		this.callput = callput;
		this.estilo = estilo;
		this.volatilidad = volatilidad;
		this.prima = prima;
		this.delta = delta;
		this.intencioncontratacion = intencioncontratacion;
		this.tipoaccion = tipoaccion;
		this.observaciones = observaciones;
		this.tipoproceso = tipoproceso;
		this.tipoprocesodesc = tipoprocesodesc;
		this.fechamovimiento = fechamovimiento;
		this.idfilaarchivo = idfilaarchivo;
		this.codigoestado = codigoestado;

	}
}
