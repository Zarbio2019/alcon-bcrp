package pe.grupobbva.alcon.mantenimiento.dto;

import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Ejecutado;

@Data
public class CargaDTO extends AbstractDTO<Carga> {

	private Boolean condicion;
	private String tipocarga;
	private Calendar fecha;
	private String rutaarchivo;
	private String nombrearchivo;
	private String ejecutado;
	private String horainicio;
	private String horafin;
	private Integer totalreg;
	private Integer totalcargado;
	private String notaerror;
	private String codigoinicio;
	private String codigofinal;
	private String anio;
	private String mes;
	private String tipo;
	private String tipoProceso;

	public CargaDTO() {
		super();
	}

	public CargaDTO(Carga entity) {
		super(entity);
	}

	public CargaDTO(String id, String tipocarga, Calendar fecha, String ejecutado, String horainicio) {
		super(id);
		this.tipocarga = tipocarga;
		this.fecha = fecha;
		this.ejecutado = ejecutado;
		this.horainicio = horainicio;
	}

	public CargaDTO(String id, String creadoPor, String actualizadoPor, Calendar fechaCreacion,	Calendar fechaModificacion,	Integer codigoestado, Boolean condicion, String tipocarga, Calendar fecha, String rutaarchivo,
			String nombrearchivo, String ejecutado, String horainicio, String horafin, Integer totalreg,
			Integer totalcargado, String notaerror, String codigoinicio, String codigofinal, String anio, String mes,
			String tipo, String tipoproceso) {
		super(id,  creadoPor,  actualizadoPor,  fechaCreacion,	 fechaModificacion,	 codigoestado);
		this.condicion = condicion;
		this.tipocarga = tipocarga;
		this.fecha = fecha;
		this.rutaarchivo = rutaarchivo;
		this.nombrearchivo = nombrearchivo;
		this.ejecutado = ejecutado;
		this.horainicio = horainicio;
		this.horafin = horafin;
		this.totalreg = totalreg;
		this.totalcargado = totalcargado;
		this.notaerror = notaerror;
		this.codigoinicio = codigoinicio;
		this.codigofinal = codigofinal;
		this.anio = anio;
		this.mes = mes;
		this.tipo = tipo;
		this.tipoProceso = tipoproceso;
	}

	@Override
	public Carga fromDTO(Carga entity) {
		if (entity == null) {
			entity = new Carga();
		}

		entity.setFecha(this.fecha);
		entity.setTipocarga(this.tipocarga);
		entity.setRutaarchivo(this.rutaarchivo);
		entity.setNombrearchivo(this.nombrearchivo);
		entity.setCondicion(this.condicion);
		entity.setTipoproceso(this.tipoProceso);
		entity.setTotalreg(totalreg);
		entity.setTotalcargado(totalcargado);
		entity.setHorainicio(horainicio);
		entity.setTipo(tipo);
		entity.setEjecutado(Ejecutado.valueOf(ejecutado).name());
		entity.setNotaerror(notaerror);
		return entity;
	}

}
