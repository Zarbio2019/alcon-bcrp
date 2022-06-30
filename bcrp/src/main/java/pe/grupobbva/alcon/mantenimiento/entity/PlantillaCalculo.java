package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "PlantillaCalculo")
public class PlantillaCalculo extends AbstractEntity{
	
	
	public PlantillaCalculo(String id) {
		super(id);
	}

	public PlantillaCalculo() {
		super();
	}

	
	private TipoDatoPlantilla tipodatoplantilla;
	
	private Integer idposicioncambiaria;
	
	@Size(max = 10)
	private String rubro;
	
	@Size(max = 200)
	private String texto;
	
	
	private TipoSigno tiposigno;
	
	
	private Boolean estado;

	@Enumerated(EnumType.STRING)
	public TipoDatoPlantilla getTipodatoplantilla() {
		return tipodatoplantilla;
	}

	public void setTipodatoplantilla(TipoDatoPlantilla tipodatoplantilla) {
		this.tipodatoplantilla = tipodatoplantilla;
	}

	public Integer getIdposicioncambiaria() {
		return idposicioncambiaria;
	}

	public void setIdposicioncambiaria(Integer idposicioncambiaria) {
		this.idposicioncambiaria = idposicioncambiaria;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	
	@Enumerated(EnumType.STRING)
	public TipoSigno getTiposigno() {
		return tiposigno;
	}

	public void setTiposigno(TipoSigno tiposigno) {
		this.tiposigno = tiposigno;
	}
	
	@NotNull
	@Type(type="true_false")
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	

}
