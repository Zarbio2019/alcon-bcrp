package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name = "Operaciones41")
public class Operaciones41 extends AbstractEntity {
	
//	private Integer id;
	
	@Column(precision = 20 ,scale = 6)
	private BigDecimal importeusd;
	

	private TipoOperacion tipooperacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechacontratacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechavencimiento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechamovimiento;
	
	private Integer idproducto;

	public BigDecimal getImporteusd() {
		return importeusd;
	}

	public void setImporteusd(BigDecimal importeusd) {
		this.importeusd = importeusd;
	}

	@Enumerated(EnumType.STRING)
	public TipoOperacion getTipooperacion() {
		return tipooperacion;
	}

	public void setTipooperacion(TipoOperacion tipooperacion) {
		this.tipooperacion = tipooperacion;
	}

	public Calendar getFechacontratacion() {
		return fechacontratacion;
	}

	public void setFechacontratacion(Calendar fechacontratacion) {
		this.fechacontratacion = fechacontratacion;
	}

	public Calendar getFechavencimiento() {
		return fechavencimiento;
	}

	public void setFechavencimiento(Calendar fechavencimiento) {
		this.fechavencimiento = fechavencimiento;
	}

	public Calendar getFechamovimiento() {
		return fechamovimiento;
	}

	public void setFechamovimiento(Calendar fechamovimiento) {
		this.fechamovimiento = fechamovimiento;
	}

	public Integer getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Integer idproducto) {
		this.idproducto = idproducto;
	}
	
	

}
