package pe.grupobbva.alcon.mantenimiento.dto;

import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Configuracion;

@Data
public class ConfiguracionDTO extends AbstractDTO<Configuracion> {

	private String nombreconfiguracion;
	private Boolean cambioconfiguracion;
	private Integer intervaloejecucionminutos;
	private String horainicialejecucion;
	private String horafinalejecucion;
	private Calendar fechahorafinejecutadoperiodo;
	private Calendar fechahorainicioejecutado;
	private Calendar fechahorafinejecutado;
	private String remitente;
	private String emailerrores;
	private String copiaemailerrores;
	private String asuntoerrores;
	private String firmaenviocorreo;
	private String ipserverftp;
	private String puertoftp;
	private String usuarioftp;
	private String passwordftp;
	private String carpetaftp;
	private String carpetadestino;
	private String nombrecarga01;
	private String nombrecarga02;
	private String nombrecarga03;
	private Boolean lunes;
	private Boolean martes;
	private Boolean miercoles;
	private Boolean jueves;
	private Boolean viernes;
	private Boolean sabado;
	private Boolean domingo;

	public ConfiguracionDTO() {
		super();
	}

	public ConfiguracionDTO(Configuracion entity) {
		super(entity);
		
		this.nombreconfiguracion = entity.getNombreconfiguracion();
		this.cambioconfiguracion = entity.getCambioconfiguracion();
		this.intervaloejecucionminutos = entity.getIntervaloejecucionminutos();
		this.horainicialejecucion = entity.getHorainicialejecucion();
		this.horafinalejecucion = entity.getHorafinalejecucion();
		this.fechahorafinejecutadoperiodo = entity.getFechahorafinejecutadoperiodo();
		this.fechahorainicioejecutado = entity.getFechahorainicioejecutado();
		this.fechahorafinejecutado = entity.getFechahorafinejecutado();
		this.remitente = entity.getRemitente();
		this.emailerrores = entity.getEmailerrores();
		this.copiaemailerrores = entity.getCopiaemailerrores();
		this.asuntoerrores = entity.getAsuntoerrores();
		this.firmaenviocorreo = entity.getFirmaenviocorreo();
		this.ipserverftp = entity.getIpserverftp();
		this.puertoftp = entity.getPuertoftp();
		this.usuarioftp = entity.getUsuarioftp();
		this.passwordftp = entity.getPasswordftp();
		this.carpetaftp = entity.getCarpetaftp();
		this.carpetadestino = entity.getCarpetadestino();
		this.nombrecarga01 = entity.getNombrecarga01();
		this.nombrecarga02 = entity.getNombrecarga02();
		this.nombrecarga03 = entity.getNombrecarga03();
		this.lunes = entity.getLunes();
		this.martes = entity.getMartes();
		this.miercoles = entity.getMiercoles();
		this.jueves = entity.getJueves();
		this.viernes = entity.getViernes();
		this.sabado = entity.getSabado();
		this.domingo = entity.getDomingo();
	}

	@Override
	public Configuracion fromDTO(Configuracion entity) {
		if (entity == null) {
			entity = new Configuracion();
		}
		
		if(nombreconfiguracion != null) {
			entity.setNombreconfiguracion(this.nombreconfiguracion);
		}
		
		if(cambioconfiguracion != null) {
			entity.setCambioconfiguracion(this.cambioconfiguracion);
		}
		
		if(intervaloejecucionminutos != null) {
			entity.setIntervaloejecucionminutos(this.intervaloejecucionminutos);
		}
		
		if(horainicialejecucion != null) {
			entity.setHorainicialejecucion(this.horainicialejecucion);
		}
		
		if(horafinalejecucion != null) {
			entity.setHorafinalejecucion(this.horafinalejecucion);
		}
		
		if(fechahorafinejecutadoperiodo != null) {
			entity.setFechahorafinejecutadoperiodo(this.fechahorafinejecutadoperiodo);
		}
		
		if(fechahorainicioejecutado != null) {
			entity.setFechahorainicioejecutado(this.fechahorainicioejecutado);
		}
		
		if(fechahorafinejecutado != null) {
			entity.setFechahorafinejecutado(this.fechahorafinejecutado);
		}
		
		if(remitente != null) {
			entity.setRemitente(this.remitente);
		}
		
		if(emailerrores != null) {
			entity.setEmailerrores(this.emailerrores);
		}
		
		if(copiaemailerrores != null) {
			entity.setCopiaemailerrores(this.copiaemailerrores);
		}
		
		if(asuntoerrores != null) {
			entity.setAsuntoerrores(this.asuntoerrores);
		}
		
		if(firmaenviocorreo != null) {
			entity.setFirmaenviocorreo(this.firmaenviocorreo);
		}
		
		if(ipserverftp != null) {
			entity.setIpserverftp(this.ipserverftp);
		}
		
		if(puertoftp != null) {
			entity.setPuertoftp(this.puertoftp);
		}
		
		if(usuarioftp != null) {
			entity.setUsuarioftp(this.usuarioftp);
		}
		
		if(passwordftp != null) {
			entity.setPasswordftp(this.passwordftp);
		}
		
		
		if(carpetaftp != null) {
			entity.setCarpetaftp(this.carpetaftp);
		}
		
		if(carpetadestino != null) {
			entity.setCarpetadestino(this.carpetadestino);
		}
		
		if(nombrecarga01 != null) {
			entity.setNombrecarga01(this.nombrecarga01);
		}
		
		if(nombrecarga02 != null) {
			entity.setNombrecarga02(this.nombrecarga02);
		}
		
		if(nombrecarga03 != null) {
			entity.setNombrecarga03(this.nombrecarga03);
		}
		
		if(lunes != null) {
			entity.setLunes(this.lunes);
		}
		
		if(martes != null) {
			entity.setMartes(this.martes);
		}
		
		if(miercoles != null) {
			entity.setMiercoles(this.miercoles);
		}
		
		if(jueves != null) {
			entity.setJueves(this.jueves);
		}
		
		if(viernes != null) {
			entity.setViernes(this.viernes);
		}
		
		if(sabado != null) {
			entity.setSabado(this.sabado);
		}
		
		if(domingo != null) {
			entity.setDomingo(this.domingo);
		}
		
		return entity;
	}
	
	@Override
	public void preactualizar() {	
		super.preactualizar();
	}

}
