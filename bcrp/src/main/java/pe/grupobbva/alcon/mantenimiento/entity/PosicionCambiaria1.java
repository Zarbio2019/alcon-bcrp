package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PosicionCambiaria1")

public class PosicionCambiaria1 extends AbstractEntity {
	
	@Size(max = 10)
	private String codigo;
	
	@Size(max = 10)
	private String rubro;
	
	@Size(max = 100)
	private String descripcion;
	
	private Integer idproducto;
	
	@Size(max = 2)
	private String codigobcr;
	
	
	private TipoOperacion tipooperacion;
	
	
	
	@Size(max = 30)
	private String tipoCliente;
	
	
	
	private Residente residente;
	
	
	private TipoEntrega tipoentrega;
	
	
	private CallPut callput;
	
	@Size(max = 2)
	private String padrerubro;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}

	public String getCodigobcr() {
		return codigobcr;
	}

	public void setCodigobcr(String codigobcr) {
		this.codigobcr = codigobcr;
	}

	@Enumerated(EnumType.STRING)
	public TipoOperacion getTipooperacion() {
		return tipooperacion;
	}

	public void setTipooperacion(TipoOperacion tipooperacion) {
		this.tipooperacion = tipooperacion;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	@Enumerated(EnumType.STRING)
	public Residente getResidente() {
		return residente;
	}

	public void setResidente(Residente residente) {
		this.residente = residente;
	}

	@Enumerated(EnumType.STRING)
	public TipoEntrega getTipoentrega() {
		return tipoentrega;
	}

	public void setTipoentrega(TipoEntrega tipoentrega) {
		this.tipoentrega = tipoentrega;
	}

	@Enumerated(EnumType.STRING)
	public CallPut getCallput() {
		return callput;
	}

	public void setCallput(CallPut callput) {
		this.callput = callput;
	}

	public String getPadrerubro() {
		return padrerubro;
	}

	public void setPadrerubro(String padrerubro) {
		this.padrerubro = padrerubro;
	}
	
	
	
}
