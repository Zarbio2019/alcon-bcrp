package pe.grupobbva.alcon.mantenimiento.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
@Table(name = "Configuracion")

public class Configuracion extends AbstractEntity {
	
	
	private String nombreconfiguracion;
	
	
	private Boolean cambioconfiguracion;
	
	private Integer intervaloejecucionminutos;

	
	private String horainicialejecucion;
	
	
	private String horafinalejecucion;
	
	
	private Calendar fechahorafinejecutadoperiodo;
	

	private Calendar fechahorainicioejecutado;
	
	
	private Calendar fechahorafinejecutado;
	
	@Size(max = 100)
	private String remitente;
	
	@Size(max = 1000)
	private String emailerrores;
	
	@Size(max = 1000)
	private String copiaemailerrores;
	
	@Size(max = 1000)
	private String asuntoerrores;
	
	@Size(max = 100)
	private String firmaenviocorreo;
	
	@Size(max = 20)
	private String ipserverftp;
	
	@Size(max = 6)
	private String puertoftp;
	
	@Size(max = 20)
	private String usuarioftp;
	
	@Size(max = 20)
	private String passwordftp;
	
	@Size(max = 1000)
	private String carpetaftp;
	
	@Size(max = 1000)
	private String carpetadestino;
	
	@Size(max = 30)
	private String nombrecarga01;
	
	@Size(max = 30)
	private String nombrecarga02;
	
	@Size(max = 30)
	private String nombrecarga03;
	
	private Boolean lunes;
	
	private Boolean martes;
	
	private Boolean miercoles;
	
	
	private Boolean jueves;
	
	private Boolean viernes;
	
	
	private Boolean sabado;
	
	
	private Boolean domingo;

	@Size(max = 100)
	public String getNombreconfiguracion() {
		return nombreconfiguracion;
	}

	public void setNombreconfiguracion(String nombreconfiguracion) {
		this.nombreconfiguracion = nombreconfiguracion;
	}

	@Type(type="true_false")
	public Boolean getCambioconfiguracion() {
		return cambioconfiguracion;
	}

	public void setCambioconfiguracion(Boolean cambioconfiguracion) {
		this.cambioconfiguracion = cambioconfiguracion;
	}

	public Integer getIntervaloejecucionminutos() {
		return intervaloejecucionminutos;
	}

	public void setIntervaloejecucionminutos(Integer intervaloejecucionminutos) {
		this.intervaloejecucionminutos = intervaloejecucionminutos;
	}

	@Size(max = 5)
	public String getHorainicialejecucion() {
		return horainicialejecucion;
	}

	public void setHorainicialejecucion(String horainicialejecucion) {
		this.horainicialejecucion = horainicialejecucion;
	}

	@Size(max = 5)
	public String getHorafinalejecucion() {
		return horafinalejecucion;
	}

	public void setHorafinalejecucion(String horafinalejecucion) {
		this.horafinalejecucion = horafinalejecucion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFechahorafinejecutadoperiodo() {
		return fechahorafinejecutadoperiodo;
	}

	public void setFechahorafinejecutadoperiodo(Calendar fechahorafinejecutadoperiodo) {
		this.fechahorafinejecutadoperiodo = fechahorafinejecutadoperiodo;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFechahorainicioejecutado() {
		return fechahorainicioejecutado;
	}

	public void setFechahorainicioejecutado(Calendar fechahorainicioejecutado) {
		this.fechahorainicioejecutado = fechahorainicioejecutado;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFechahorafinejecutado() {
		return fechahorafinejecutado;
	}

	public void setFechahorafinejecutado(Calendar fechahorafinejecutado) {
		this.fechahorafinejecutado = fechahorafinejecutado;
	}

	public String getRemitente() {
		return remitente;
	}

	public void setRemitente(String remitente) {
		this.remitente = remitente;
	}

	public String getEmailerrores() {
		return emailerrores;
	}

	public void setEmailerrores(String emailerrores) {
		this.emailerrores = emailerrores;
	}

	public String getCopiaemailerrores() {
		return copiaemailerrores;
	}

	public void setCopiaemailerrores(String copiaemailerrores) {
		this.copiaemailerrores = copiaemailerrores;
	}

	public String getAsuntoerrores() {
		return asuntoerrores;
	}

	public void setAsuntoerrores(String asuntoerrores) {
		this.asuntoerrores = asuntoerrores;
	}

	public String getFirmaenviocorreo() {
		return firmaenviocorreo;
	}

	public void setFirmaenviocorreo(String firmaenviocorreo) {
		this.firmaenviocorreo = firmaenviocorreo;
	}

	public String getIpserverftp() {
		return ipserverftp;
	}

	public void setIpserverftp(String ipserverftp) {
		this.ipserverftp = ipserverftp;
	}

	public String getPuertoftp() {
		return puertoftp;
	}

	public void setPuertoftp(String puertoftp) {
		this.puertoftp = puertoftp;
	}

	public String getUsuarioftp() {
		return usuarioftp;
	}

	public void setUsuarioftp(String usuarioftp) {
		this.usuarioftp = usuarioftp;
	}

	public String getPasswordftp() {
		return passwordftp;
	}

	public void setPasswordftp(String passwordftp) {
		this.passwordftp = passwordftp;
	}

	public String getCarpetaftp() {
		return carpetaftp;
	}

	public void setCarpetaftp(String carpetaftp) {
		this.carpetaftp = carpetaftp;
	}

	public String getCarpetadestino() {
		return carpetadestino;
	}

	public void setCarpetadestino(String carpetadestino) {
		this.carpetadestino = carpetadestino;
	}

	public String getNombrecarga01() {
		return nombrecarga01;
	}

	public void setNombrecarga01(String nombrecarga01) {
		this.nombrecarga01 = nombrecarga01;
	}

	public String getNombrecarga02() {
		return nombrecarga02;
	}

	public void setNombrecarga02(String nombrecarga02) {
		this.nombrecarga02 = nombrecarga02;
	}

	public String getNombrecarga03() {
		return nombrecarga03;
	}

	public void setNombrecarga03(String nombrecarga03) {
		this.nombrecarga03 = nombrecarga03;
	}

	
	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition="CHAR")
	public Boolean getLunes() {
		return lunes;
	}

	public void setLunes(Boolean lunes) {
		this.lunes = lunes;
	}

	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition="CHAR")
	public Boolean getMartes() {
		return martes;
	}

	public void setMartes(Boolean martes) {
		this.martes = martes;
	}

	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition="CHAR")
	public Boolean getMiercoles() {
		return miercoles;
	}

	public void setMiercoles(Boolean miercoles) {
		this.miercoles = miercoles;
	}
	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition="CHAR")
	public Boolean getJueves() {
		return jueves;
	}

	public void setJueves(Boolean jueves) {
		this.jueves = jueves;
	}

	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition="CHAR")
	public Boolean getViernes() {
		return viernes;
	}

	public void setViernes(Boolean viernes) {
		this.viernes = viernes;
	}

	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition="CHAR")
	public Boolean getSabado() {
		return sabado;
	}

	public void setSabado(Boolean sabado) {
		this.sabado = sabado;
	}

	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition="CHAR")
	public Boolean getDomingo() {
		return domingo;
	}

	public void setDomingo(Boolean domingo) {
		this.domingo = domingo;
	}
	
	
	
}
