package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "DetalleParametro")
public class DetalleParametro extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	public DetalleParametro(String id) {
		super(id);
	}
	
	public DetalleParametro() {
		super();
	}


	private String codigo;
	
	
	private String descripcion;
	

	private Boolean visible;
	

	private Parametro parametro;

	@Size(max = 3)
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Size(max = 60)
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	@NotNull
	@Convert(converter = BooleanConverter.class)
	@Column(columnDefinition="CHAR")
	public Boolean getVisible() {
		return visible;	
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_parametro")
	public Parametro getParametro() {
		return parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}
	
	

}
