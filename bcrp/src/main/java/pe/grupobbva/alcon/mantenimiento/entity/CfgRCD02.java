package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CFG_RCD02")
public class CfgRCD02 extends AbstractEntity{
	private String filainicio;
	private String filafin;
	private String divisa;
	private String cuenta;
	
	public CfgRCD02() {
		super();
	}
	public CfgRCD02(String id) {
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
