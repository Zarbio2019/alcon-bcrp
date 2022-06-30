package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Producto")
public class Producto extends AbstractEntity {
	
	public Producto(String id) {
		super(id);
	}

	public Producto() {
		super();
	}
	

	private String codigo;
	

	private String descripcion;
	

	private String nombreproducto;
	

	private String codigobcr;
	
	private String tipooperacion;
	

	private String tipoentrega;
	
	@Size(max = 30)
	private String rechazarcarga;

	@Size(max = 15)
	@NotNull
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Size(max = 50)
	@NotNull
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Size(max = 50)
	@NotNull
	public String getNombreproducto() {
		return nombreproducto;
	}

	public void setNombreproducto(String nombreproducto) {
		this.nombreproducto = nombreproducto;
	}

	@Size(max = 2)
	@NotNull
	public String getCodigobcr() {
		return codigobcr;
	}

	public void setCodigobcr(String codigobcr) {
		this.codigobcr = codigobcr;
	}

	public String getTipooperacion() {
		return tipooperacion;
	}

	public void setTipooperacion(String tipooperacion) {
		this.tipooperacion = tipooperacion;
	}
	
	@NotNull
	public String getTipoentrega() {
		return tipoentrega;
	}

	public void setTipoentrega(String tipoentrega) {
		this.tipoentrega = tipoentrega;
	}

	public String getRechazarcarga() {
		return rechazarcarga;
	}

	public void setRechazarcarga(String rechazarcarga) {
		this.rechazarcarga = rechazarcarga;
	}
	
	
	
	

}
