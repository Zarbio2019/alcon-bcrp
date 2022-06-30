package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "AnexoOcho")
public class AnexoOcho extends AbstractEntity{

	public AnexoOcho() {
		super();
	}

	public AnexoOcho(String id) {
		super(id);
	}
	
	@Size(max = 100)
	private String fuente;
	
	@Size(max = 1)
	private String tipooperacion;
	
	@Size(max = 1)
	private Integer reporte;
	
	@Size(max = 8)
	private String codigo;

	@Size(max = 8)
	private String codigoproducto;
	
	@Size(max = 8)
	private String codigoarchivo;

	
	public String getCodigoarchivo() {
		return codigoarchivo;
	}

	public void setCodigoarchivo(String codigoarchivo) {
		this.codigoarchivo = codigoarchivo;
	}

	public String getCodigoproducto() {
		return codigoproducto;
	}

	public void setCodigoproducto(String codigoproducto) {
		this.codigoproducto = codigoproducto;
	}

	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getTipooperacion() {
		return tipooperacion;
	}

	public void setTipooperacion(String tipooperacion) {
		this.tipooperacion = tipooperacion;
	}

	public Integer getReporte() {
		return reporte;
	}

	public void setReporte(Integer reporte) {
		this.reporte = reporte;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	


	
	

}
