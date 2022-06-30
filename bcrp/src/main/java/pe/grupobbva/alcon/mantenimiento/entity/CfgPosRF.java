package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CFG_POSRF")
public class CfgPosRF extends AbstractEntity{
	private String cartera;
	public String getCartera() {
		return cartera;
	}
	public void setCartera(String cartera) {
		this.cartera = cartera;
	}
	public String getClase() {
		return clase;
	}
	public void setClase(String clase) {
		this.clase = clase;
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
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	private String clase;
	private String divisa;
	private String cuenta;
	private String importe;
	
	public CfgPosRF() {
		super();
	}
	public CfgPosRF(String id) {
		super(id);
	}
}
