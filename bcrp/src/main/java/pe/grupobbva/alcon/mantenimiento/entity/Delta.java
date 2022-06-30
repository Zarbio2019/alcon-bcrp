package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.process.DeltaCargaType;

@Entity
@Table(name = "Delta")
public class Delta extends AbstractEntity {
	
	public Delta(DeltaCargaType registro) {
		this();
		this.numerooperacion=registro.getNumerooperacion();
		this.deltas= registro.getDeltas() .divide(BigDecimal.valueOf(100)).setScale(4, BigDecimal.ROUND_HALF_EVEN).abs();
		this.descripcion=registro.getDescripcion();
		this.importe= registro.getImporte().setScale(2, BigDecimal.ROUND_HALF_EVEN);
	
	}
	
	public Delta(String id) {
		super(id);
	}
	
	public Delta() {
		super();
		this.cobertura=BigDecimal.ZERO;
	}

	@Size(max = 20)
	private String numerooperacion;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal deltas;
	
	@Size(max = 50)
	private String descripcion;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal importe;
	
	
	private Calendar fechaproceso;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal cobertura;

	public String getNumerooperacion() {
		return numerooperacion;
	}

	public void setNumerooperacion(String numerooperacion) {
		this.numerooperacion = numerooperacion;
	}

	public BigDecimal getDeltas() {
		return deltas;
	}

	public void setDeltas(BigDecimal deltas) {
		this.deltas = deltas;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@NotNull
	public Calendar getFechaproceso() {
		return fechaproceso;
	}

	public void setFechaproceso(Calendar fechaproceso) {
		this.fechaproceso = fechaproceso;
	}

	public BigDecimal getCobertura() {
		return cobertura;
	}

	public void setCobertura(BigDecimal cobertura) {
		this.cobertura = cobertura;
	}

	
	
}
