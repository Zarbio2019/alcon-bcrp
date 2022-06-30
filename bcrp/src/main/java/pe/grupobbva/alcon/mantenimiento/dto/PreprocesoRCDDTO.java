package pe.grupobbva.alcon.mantenimiento.dto;

public class PreprocesoRCDDTO {
	private String cliente;
	private String codigooficina;
	private String codigocentral;
	private String descripcion;
	private String fecha;
	private String divisa;
	private String cuenta;
	private String importe;
	
	public PreprocesoRCDDTO(){}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public String getCodigooficina() {
		return codigooficina;
	}

	public void setCodigooficina(String codigooficina) {
		this.codigooficina = codigooficina;
	}

	public String getCodigocentral() {
		return codigocentral;
	}

	public void setCodigocentral(String codigocentral) {
		this.codigocentral = codigocentral;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
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
	
	
}
