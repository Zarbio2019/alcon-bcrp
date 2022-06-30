package pe.grupobbva.alcon.mantenimiento.dto;

import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Operacioncarga;
import pe.grupobbva.alcon.mantenimiento.entity.TipoOperacion;
import pe.grupobbva.alcon.mantenimiento.entity.TipoProceso;

@Data
public class OperacioncargaDTO extends AbstractDTO<Operacioncarga> {

	private String idcarga;
	private Calendar fechacarga;
	private Integer idfilaarchivo;
	private String fechacontratacion;
	private String producto;
	private String numerooperacion;
	private String codigocliente;
	private String nombrecliente;
	private String divisaentrada;
	private String divisasalida;
	private String importedivisaentrada;
	private String importedivisasalida;
	private String cotizacion;
	private String puntosswap;
	private String basica;
	private String cambioref;
	private String fechavalor;
	private String fechavencimiento;
	private String plazo;
	private String fechaejercicio;
	private String callput;
	private String plaza;
	private String paisresidencia;
	private String paisriesgo;
	private String prima;
	private String divisaprima;
	private String observacioncarga;
	private String fechaalta;
	private String fechamodificacioncarga;
	private String operacionsustituye;
	private String fechabaja;
	private String nif;
	private String intermediario;
	private String intermediariodescripcion;
	private String usuario;
	private String nombreusuario;
	private String estado;

	private String fechafixing;
	private String tasapen;
	private String tasausd;
	private String delta;
	private String basicaauxiliar;
	private String tipopperacionauxiliar;
	private String mensajeerror;

	private TipoProceso tipoproceso;
	private TipoOperacion tipooperacion;

	public OperacioncargaDTO() {
		super();
	}
	
	public OperacioncargaDTO(String id) {
		super(id);
	}

	public OperacioncargaDTO(Operacioncarga entity) {
		super(entity);
	}

	public OperacioncargaDTO(String id, String idcarga, Calendar fechacarga, Integer idfilaarchivo,
			String fechacontratacion, String producto, String numerooperacion, String codigocliente,
			String nombrecliente, String divisaentrada, String divisasalida, String importedivisaentrada,
			String importedivisasalida, String cotizacion, String puntosswap, String basica, String cambioref,
			String fechavalor, String fechavencimiento, String plazo, String fechaejercicio, String callput,
			String plaza, String paisresidencia, String paisriesgo, String prima, String divisaprima,
			String observacioncarga, String fechaalta, String fechamodificacioncarga, String operacionsustituye,
			String fechabaja, String nif, String intermediario, String intermediariodescripcion, String usuario,
			String nombreusuario, String estado, String fechafixing, String tasapen, String tasausd, String delta,
			String basicaauxiliar, String tipopperacionauxiliar, String mensajeerror, TipoProceso tipoproceso,
			TipoOperacion tipooperacion) {
		
		super(id);
		this.idcarga = idcarga;
		this.fechacarga = fechacarga;
		this.idfilaarchivo = idfilaarchivo;
		this.fechacontratacion = fechacontratacion;
		this.producto = producto;
		this.numerooperacion = numerooperacion;
		this.codigocliente = codigocliente;
		this.nombrecliente = nombrecliente;
		this.divisaentrada = divisaentrada;
		this.divisasalida = divisasalida;
		this.importedivisaentrada = importedivisaentrada;
		this.importedivisasalida = importedivisasalida;
		this.cotizacion = cotizacion;
		this.puntosswap = puntosswap;
		this.basica = basica;
		this.cambioref = cambioref;
		this.fechavalor = fechavalor;
		this.fechavencimiento = fechavencimiento;
		this.plazo = plazo;
		this.fechaejercicio = fechaejercicio;
		this.callput = callput;
		this.plaza = plaza;
		this.paisresidencia = paisresidencia;
		this.paisriesgo = paisriesgo;
		this.prima = prima;
		this.divisaprima = divisaprima;
		this.observacioncarga = observacioncarga;
		this.fechaalta = fechaalta;
		this.fechamodificacioncarga = fechamodificacioncarga;
		this.operacionsustituye = operacionsustituye;
		this.fechabaja = fechabaja;
		this.nif = nif;
		this.intermediario = intermediario;
		this.intermediariodescripcion = intermediariodescripcion;
		this.usuario = usuario;
		this.nombreusuario = nombreusuario;
		this.estado = estado;
		this.fechafixing = fechafixing;
		this.tasapen = tasapen;
		this.tasausd = tasausd;
		this.delta = delta;
		this.basicaauxiliar = basicaauxiliar;
		this.tipopperacionauxiliar = tipopperacionauxiliar;
		this.mensajeerror = mensajeerror;
		this.tipoproceso = tipoproceso;
		this.tipooperacion = tipooperacion;

	}

	@Override
	public Operacioncarga fromDTO(Operacioncarga entity) {
		if (entity == null) {
			entity = new Operacioncarga();
		}
		
		return entity;
	}

}
