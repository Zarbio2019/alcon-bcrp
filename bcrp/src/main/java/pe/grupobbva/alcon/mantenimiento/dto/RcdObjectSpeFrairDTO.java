package pe.grupobbva.alcon.mantenimiento.dto;

public class RcdObjectSpeFrairDTO {
	private String centroaltamira;
	private String codigocentral; // cou par
	private String subtype;
	private String tnum;
	private String vencimiento; // matdate
	private String cuenta;
	private String divisapago; //pago
	private String divisarecibo; //recibo
	private String impvalorcontable; //valorcontable
	private String impamortrc; //amortrc
	private String impamortpy;//amortpy
	private String cliente; // Lname
	private String operacion;
	
	public RcdObjectSpeFrairDTO() {}
	
	
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public String getCentroaltamira() {
		return centroaltamira;
	}
	public void setCentroaltamira(String centroaltamira) {
		this.centroaltamira = centroaltamira;
	}
	public String getCodigocentral() {
		return codigocentral;
	}
	public void setCodigocentral(String codigocentral) {
		this.codigocentral = codigocentral;
	}
	public String getSubtype() {
		return subtype;
	}
	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}
	public String getTnum() {
		return tnum;
	}
	public void setTnum(String tnum) {
		this.tnum = tnum;
	}
	public String getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(String vencimiento) {
		this.vencimiento = vencimiento;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getDivisapago() {
		return divisapago;
	}
	public void setDivisapago(String divisapago) {
		this.divisapago = divisapago;
	}
	public String getDivisarecibo() {
		return divisarecibo;
	}
	public void setDivisarecibo(String divisarecibo) {
		this.divisarecibo = divisarecibo;
	}
	public String getImpvalorcontable() {
		return impvalorcontable;
	}
	public void setImpvalorcontable(String impvalorcontable) {
		this.impvalorcontable = impvalorcontable;
	}
	public String getImpamortrc() {
		return impamortrc;
	}
	public void setImpamortrc(String impamortrc) {
		this.impamortrc = impamortrc;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public String getImpamortpy() {
		return impamortpy;
	}


	public void setImpamortpy(String impamortpy) {
		this.impamortpy = impamortpy;
	}
	
	
}