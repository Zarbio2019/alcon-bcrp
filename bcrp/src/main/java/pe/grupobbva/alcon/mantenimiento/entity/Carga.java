package pe.grupobbva.alcon.mantenimiento.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Carga")
public class Carga extends AbstractEntity {
	
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
	
	@Size(max = 3000)
	private String notaerror;
	
	@Size(max = 13)
	private String codigoinicio;
	
	@Size(max = 13)
	private String codigofinal;
	
	@Size(max = 4)
	private String anio;
	
	@Size(max = 20)
	private String mes;
	
//	@Enumerated(EnumType.STRING)
	private String tipo;
	
//	@Enumerated(EnumType.STRING)
	private String tipoproceso;
	
	
	public Carga(String id) {
		super(id);
	}


	public Carga() {
		super();
	}

	@NotNull
	public Boolean getCondicion() {
		return condicion;
	}


	public void setCondicion(Boolean condicion) {
		this.condicion = condicion;
	}

	@NotNull
	//@Enumerated(EnumType.STRING)
	@Size(max = 3)
	public String getTipocarga() {
		return tipocarga;
	}


	public void setTipocarga(String tipocarga) {
		this.tipocarga = tipocarga;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	public Calendar getFecha() {
		return fecha;
	}


	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	
	@Size(max = 300)
	@NotNull
	public String getRutaarchivo() {
		return rutaarchivo;
	}


	public void setRutaarchivo(String rutaarchivo) {
		this.rutaarchivo = rutaarchivo;
	}

	@Size(max = 100)
	@NotNull
	public String getNombrearchivo() {
		return nombrearchivo;
	}


	public void setNombrearchivo(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
	}


	public String getEjecutado() {
		return ejecutado;
	}


	public void setEjecutado(String ejecutado) {
		this.ejecutado = ejecutado;
	}


	public String getHorainicio() {
		return horainicio;
	}


	public void setHorainicio(String horainicio) {
		this.horainicio = horainicio;
	}


	public String getHorafin() {
		return horafin;
	}


	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}


	public Integer getTotalreg() {
		return totalreg;
	}


	public void setTotalreg(Integer totalreg) {
		this.totalreg = totalreg;
	}


	public Integer getTotalcargado() {
		return totalcargado;
	}


	public void setTotalcargado(Integer totalcargado) {
		this.totalcargado = totalcargado;
	}


	public String getNotaerror() {
		return notaerror;
	}


	public void setNotaerror(String notaerror) {
		this.notaerror = notaerror;
	}


	public String getCodigoinicio() {
		return codigoinicio;
	}


	public void setCodigoinicio(String codigoinicio) {
		this.codigoinicio = codigoinicio;
	}


	public String getCodigofinal() {
		return codigofinal;
	}


	public void setCodigofinal(String codigofinal) {
		this.codigofinal = codigofinal;
	}


	public String getAnio() {
		return anio;
	}


	public void setAnio(String anio) {
		this.anio = anio;
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getTipoproceso() {
		return tipoproceso;
	}


	public void setTipoproceso(String tipoproceso) {
		this.tipoproceso = tipoproceso;
	}
	
	
	

}
