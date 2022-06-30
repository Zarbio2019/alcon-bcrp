package pe.grupobbva.alcon.mantenimiento.dto;

public class RcdObjectFxVigenteDTO {
	private String subproducto;
	private String deal;
	private String codigoMercado;
	private String oficina;
	private String operacion;
	private String divisaCompra;
	private String divisaCompraImp;
	private String divisaVenta;
	private String divisaVentaImp;
	private String fechaFixing;
	private String codigoCentral;
	private String referencia; //subproducto + deal
	private String fechaVencimiento;
	private String cuenta;
	private String divisa;
	private String impOperacion;
	private String contrapartida;
	private String signoImporte;
	
	public String getDivisaCompra() {
		return divisaCompra;
	}

	public void setDivisaCompra(String divisaCompra) {
		this.divisaCompra = divisaCompra;
	}

	public String getDivisaCompraImp() {
		return divisaCompraImp;
	}

	public void setDivisaCompraImp(String divisaCompraImp) {
		this.divisaCompraImp = divisaCompraImp;
	}

	public String getDivisaVenta() {
		return divisaVenta;
	}

	public void setDivisaVenta(String divisaVenta) {
		this.divisaVenta = divisaVenta;
	}

	public String getDivisaVentaImp() {
		return divisaVentaImp;
	}

	public void setDivisaVentaImp(String divisaVentaImp) {
		this.divisaVentaImp = divisaVentaImp;
	}

	
	
	
	
	public String getCodigoMercado() {
		return codigoMercado;
	}

	public void setCodigoMercado(String codigoMercado) {
		this.codigoMercado = codigoMercado;
	}

	public String getOficina() {
		return oficina;
	}

	public void setOficina(String oficina) {
		this.oficina = oficina;
	}

	public String getCodigoCentral() {
		return codigoCentral;
	}

	public void setCodigoCentral(String codigoCentral) {
		this.codigoCentral = codigoCentral;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(String fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
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

	public String getImpOperacion() {
		return impOperacion;
	}

	public void setImpOperacion(String impOperacion) {
		this.impOperacion = impOperacion;
	}

	public String getContrapartida() {
		return contrapartida;
	}

	public void setContrapartida(String contrapartida) {
		this.contrapartida = contrapartida;
	}

	public String getSignoImporte() {
		return signoImporte;
	}

	public void setSignoImporte(String signoImporte) {
		this.signoImporte = signoImporte;
	}

	
	
	public RcdObjectFxVigenteDTO() {}

	public String getSubproducto() {
		return subproducto;
	}

	public void setSubproducto(String subproducto) {
		this.subproducto = subproducto;
	}

	public String getDeal() {
		return deal;
	}

	public void setDeal(String deal) {
		this.deal = deal;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public String getFechaFixing() {
		return fechaFixing;
	}

	public void setFechaFixing(String fechaFixing) {
		this.fechaFixing = fechaFixing;
	}
}
