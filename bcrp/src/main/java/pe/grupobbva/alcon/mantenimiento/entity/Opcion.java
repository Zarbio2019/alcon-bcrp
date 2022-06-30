package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Opcion")
public class Opcion extends AbstractEntity {

	private String nombre;

	private Integer nivel;

	private Integer codigoopcpadre;

	private String url;

	private Integer orden;

	private Boolean visible;

	@Size(max = 25)
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getNivel() {
		return nivel;
	}

	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}

	public Integer getCodigoopcpadre() {
		return codigoopcpadre;
	}

	public void setCodigoopcpadre(Integer codigoopcpadre) {
		this.codigoopcpadre = codigoopcpadre;
	}

	@Size(max = 100)
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	@Type(type = "true_false")
	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

}
