package pe.grupobbva.alcon.mantenimiento.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Transaction")
public class Transaction extends AbstractEntity{

	public Transaction(String id) {
		super(id);
	}
	
	public Transaction() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
	
	private Calendar fechaProceso;
	
	@Size(max = 1)
	private String tipoProceso;
	
	@Size(max = 50)
	private String tabla;
	
	private Calendar inicia;
	
	private Calendar termina;
	
	private Integer procesosTotales;
	
	private Integer procesosActuales;
	
	@Size(max = 250)
	private String descripcion;
	
	private Integer estado;

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFechaProceso() {
		return fechaProceso;
	}

	public void setFechaProceso(Calendar fechaProceso) {
		this.fechaProceso = fechaProceso;
	}

	public String getTipoProceso() {
		return tipoProceso;
	}

	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}

	public String getTabla() {
		return tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getInicia() {
		return inicia;
	}

	public void setInicia(Calendar inicia) {
		this.inicia = inicia;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getTermina() {
		return termina;
	}

	public void setTermina(Calendar termina) {
		this.termina = termina;
	}

	public Integer getProcesosTotales() {
		return procesosTotales;
	}

	public void setProcesosTotales(Integer procesosTotales) {
		this.procesosTotales = procesosTotales;
	}

	public Integer getProcesosActuales() {
		return procesosActuales;
	}

	public void setProcesosActuales(Integer procesosActuales) {
		this.procesosActuales = procesosActuales;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
