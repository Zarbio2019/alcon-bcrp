package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table(name = "DetalleCuadreDiario")
@SuppressWarnings("serial")
public class DetalleCuadreDiario extends AbstractEntity {
	



	public DetalleCuadreDiario(String id) {
		super(id);
	}
	
	public DetalleCuadreDiario() {
		super();
	}
	
	
	private CuadreDiario cuadrediario;
	
	
	private PlantillaCalculo plantillacalculo;
	
	
	private BigDecimal valorcuadre;
	

	private Boolean estado;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cuadrediario")
	public CuadreDiario getCuadrediario() {
		return cuadrediario;
	}

	public void setCuadrediario(CuadreDiario cuadrediario) {
		this.cuadrediario = cuadrediario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_plantillacalculo")
	public PlantillaCalculo getPlantillacalculo() {
		return plantillacalculo;
	}

	public void setPlantillacalculo(PlantillaCalculo plantillacalculo) {
		this.plantillacalculo = plantillacalculo;
	}

	@Column(precision = 20, scale = 6)
	public BigDecimal getValorcuadre() {
		return valorcuadre;
	}

	public void setValorcuadre(BigDecimal valorcuadre) {
		this.valorcuadre = valorcuadre;
	}

	@Type(type="true_false")
	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	
}
