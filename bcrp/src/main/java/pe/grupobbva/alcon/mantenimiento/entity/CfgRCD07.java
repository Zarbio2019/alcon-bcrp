package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CFG_RCD07")
public class CfgRCD07 extends AbstractEntity{
	private String filainicio;
	private String filafin;
	private String divisa;
	private String cuenta;
	
	public CfgRCD07() {
		super();
	}
	public CfgRCD07(String id) {
		super(id);
	}
	public String getFilainicio() {
		return filainicio;
	}
	public void setFilainicio(String filainicio) {
		this.filainicio = filainicio;
	}
	public String getFilafin() {
		return filafin;
	}
	public void setFilafin(String filafin) {
		this.filafin = filafin;
	}
	public String getDivisa() {
		return divisa;
	}
	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	
}
