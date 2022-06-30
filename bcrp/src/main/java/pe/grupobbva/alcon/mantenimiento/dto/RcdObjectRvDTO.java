package pe.grupobbva.alcon.mantenimiento.dto;

public class RcdObjectRvDTO {
	private String centroaltamira;
	private String codigocentral; // COD EMISOR
	private String cartera;
	private String clase;
	private String isin;
	private String cuenta;
	private String divisa;
	private String importe;
	private String fluctuacion;
	private String cliente; // emisor
	private String signo;
	
	public RcdObjectRvDTO() {}

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

	public String getCartera() {
		return cartera;
	}

	public void setCartera(String cartera) {
		this.cartera = cartera;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
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

	public String getFluctuacion() {
		return fluctuacion;
	}

	public void setFluctuacion(String fluctuacion) {
		this.fluctuacion = fluctuacion;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getSigno() {
		return signo;
	}

	public void setSigno(String signo) {
		this.signo = signo;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}
	
	

}
