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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "Saldo")
public class Saldo extends AbstractEntity {
	
	public Saldo() {
		super();
	}
	
	private String idoficina;
	
	private String numerocuenta;
	
	private String iddivisa;
	
	private BigDecimal saldo;
	
	private Signo signosaldo;
	
	private BigDecimal saldomedio;
	
	private Signo signosaldomedio;
	
	private Integer numerolinea;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaproceso;
	
	
	private Boolean activo;

	@NotNull
	public String getIdoficina() {
		return idoficina;
	}

	public void setIdoficina(String idoficina) {
		this.idoficina = idoficina;
	}

	@Size(max = 15)
	@NotNull
	public String getNumerocuenta() {
		return numerocuenta;
	}

	public void setNumerocuenta(String numerocuenta) {
		this.numerocuenta = numerocuenta;
	}
	
	@NotNull
	public String getIddivisa() {
		return iddivisa;
	}

	public void setIddivisa(String iddivisa) {
		this.iddivisa = iddivisa;
	}

	@Column(precision = 18 ,scale = 2)
	@NotNull
	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Enumerated(EnumType.ORDINAL)
	@NotNull
	public Signo getSignosaldo() {
		return signosaldo;
	}

	public void setSignosaldo(Signo signosaldo) {
		this.signosaldo = signosaldo;
	}
	
	@Column(precision = 18 ,scale = 2)
	@NotNull
	public BigDecimal getSaldomedio() {
		return saldomedio;
	}

	public void setSaldomedio(BigDecimal saldomedio) {
		this.saldomedio = saldomedio;
	}

	@Enumerated(EnumType.ORDINAL)
	@NotNull
	public Signo getSignosaldomedio() {
		return signosaldomedio;
	}

	public void setSignosaldomedio(Signo signosaldomedio) {
		this.signosaldomedio = signosaldomedio;
	}

	@NotNull
	public Integer getNumerolinea() {
		return numerolinea;
	}

	public void setNumerolinea(Integer numerolinea) {
		this.numerolinea = numerolinea;
	}

	public Calendar getFechaproceso() {
		return fechaproceso;
	}

	public void setFechaproceso(Calendar fechaproceso) {
		this.fechaproceso = fechaproceso;
	}


	@NotNull
	@Type(type="true_false")
	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
	
}
