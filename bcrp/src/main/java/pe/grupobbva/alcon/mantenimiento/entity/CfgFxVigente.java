package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CFG_FXVIGENTE")
public class CfgFxVigente extends AbstractEntity {
	private String subproducto;
	private String operacion;
	private String fechaVencimiento;
	private String divisa;
	private String cuenta;
	
	public CfgFxVigente(String id) {
		super(id);
	}
	public CfgFxVigente() {
		super();
	}
	
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
	public String getFecha_vencimiento() {
		return fechaVencimiento;
	}
	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fechaVencimiento = fecha_vencimiento;
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
