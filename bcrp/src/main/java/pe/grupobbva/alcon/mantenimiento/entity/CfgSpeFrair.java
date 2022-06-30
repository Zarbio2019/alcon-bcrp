package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CFG_SPEFRAIR")
public class CfgSpeFrair extends AbstractEntity {
	private String subproducto;
	public String getSubproducto() {
		return subproducto;
	}
	public void setSubproducto(String subproducto) {
		this.subproducto = subproducto;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getDivisa() {
		return divisa;
	}
	public void setDivisa(String divisa) {
		this.divisa = divisa;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public String getRecibo() {
		return recibo;
	}
	public void setRecibo(String recibo) {
		this.recibo = recibo;
	}
	private String operacion;
	private String cuenta;
	private String divisa;
	private String importe;
	private String recibo;
	
	public CfgSpeFrair(String id) {
		super(id);
	}
	public CfgSpeFrair() {
		super();
	}
	
}
