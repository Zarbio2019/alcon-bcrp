package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PosicionCambiaria39")
public class PosicionCambiaria39 extends AbstractEntity {
	
	private Integer idposicioncambiaria;
	
	@Size(max = 10)
	private String codigobcr;
	
	
	private TipoOperacion tipooperacion;
	
	
	@Size(max = 30)
	private String tipoCliente;
	
	
	private Residente residente;
	
	
	private TipoEntrega tipoentrega;
	
	
	private CallPut callput;

	public Integer getIdposicioncambiaria() {
		return idposicioncambiaria;
	}

	public void setIdposicioncambiaria(Integer idposicioncambiaria) {
		this.idposicioncambiaria = idposicioncambiaria;
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
	
	
	
	
}
