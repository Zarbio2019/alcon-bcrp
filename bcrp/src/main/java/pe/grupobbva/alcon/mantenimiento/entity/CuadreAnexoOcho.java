package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CuadreAnexoOcho")
public class CuadreAnexoOcho extends AbstractEntity{

	public CuadreAnexoOcho() {
		super();
	}

	public CuadreAnexoOcho(String id) {
		super(id);
	}

	private AnexoOcho anexoOcho;
	private Calendar fecha;
	private BigDecimal montoposicioncambiaria;
	private BigDecimal montoanexo;
	private BigDecimal diferencia;
	private String progreso;
    private String descripcion;
    

	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_anexoocho")
	public AnexoOcho getAnexoOcho() {
		return anexoOcho;
	}
    
	public void setAnexoOcho(AnexoOcho anexoOcho) {
		this.anexoOcho = anexoOcho;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFecha() {
		return fecha;
	}
	
	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	@Column(precision = 20, scale =6)
	public BigDecimal getMontoposicioncambiaria() {
		return montoposicioncambiaria;
	}
	
	public void setMontoposicioncambiaria(BigDecimal montoposicioncambiaria) {
		this.montoposicioncambiaria = montoposicioncambiaria;
	}
	
	@Column(precision = 20, scale =6)
	public BigDecimal getMontoanexo() {
		return montoanexo;
	}
	
	public void setMontoanexo(BigDecimal montoanexo) {
		this.montoanexo = montoanexo;
	}
	
	public String getProgreso() {
		return progreso;
	}
	
	public void setProgreso(String progreso) {
		this.progreso = progreso;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
	public BigDecimal getDiferencia() {
		return diferencia;
	}

	public void setDiferencia(BigDecimal diferencia) {
		this.diferencia = diferencia;
	}
    
}
