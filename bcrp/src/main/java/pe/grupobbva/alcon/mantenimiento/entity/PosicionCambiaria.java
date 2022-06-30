package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "PosicionCambiaria")
public class PosicionCambiaria extends AbstractEntity {
	
	
	public PosicionCambiaria(String id) {
		super(id);
	}
	
	public PosicionCambiaria() {
		super();
	}


	@Size(max = 10)
	private String codigo;
	
	@Size(max = 10)
	private String rubro;
	
	@Size(max = 100)
	private String descripcion;
	
	private Integer idProducto;
	
	@Size(max = 2)
	private String codigoBCR;
	
	private String tipoOperacion;
	
	@Size(max = 20)
	private String tipoCliente;
	
	private String residente;
	
	private String tipoEntrega;
	
	private String callPut;
	
	@Size(max = 2)
	private String padreRubro;
	
	
	private Boolean editar;
	
	
	private Boolean detalle;

	@Size(max = 100)
	private String descripcionc2;
	
	public String getDescripcionc2() {
		return descripcionc2;
	}

	public void setDescripcionc2(String descripcionc2) {
		this.descripcionc2 = descripcionc2;
	}

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

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodigoBCR() {
		return codigoBCR;
	}

	public void setCodigoBCR(String codigoBCR) {
		this.codigoBCR = codigoBCR;
	}

	public String getTipoOperacion() {
		return tipoOperacion;
	}

	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getResidente() {
		return residente;
	}

	public void setResidente(String residente) {
		this.residente = residente;
	}

	public String getTipoEntrega() {
		return tipoEntrega;
	}

	public void setTipoEntrega(String tipoEntrega) {
		this.tipoEntrega = tipoEntrega;
	}

	public String getCallPut() {
		return callPut;
	}

	public void setCallPut(String callPut) {
		this.callPut = callPut;
	}

	public String getPadreRubro() {
		return padreRubro;
	}

	public void setPadreRubro(String padreRubro) {
		this.padreRubro = padreRubro;
	}

	@Type(type="true_false")
	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	@Type(type="true_false")
	public Boolean getDetalle() {
		return detalle;
	}

	public void setDetalle(Boolean detalle) {
		this.detalle = detalle;
	}
	
	
	
	
	
	
}
