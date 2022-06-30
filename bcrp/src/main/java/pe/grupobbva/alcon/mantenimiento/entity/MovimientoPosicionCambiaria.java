package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "MovimientoPosicionCambiaria")
public class MovimientoPosicionCambiaria extends AbstractEntity {
	

	private TipoProceso tipoproceso;
	

	private PosicionCambiaria posicionCambiaria;
	
	
	private BigDecimal importedelta;
	
	
	private BigDecimal importeactual;
	
	
	private Calendar fecha;

	@Enumerated(EnumType.STRING)
	public TipoProceso getTipoproceso() {
		return tipoproceso;
	}

	public void setTipoproceso(TipoProceso tipoproceso) {
		this.tipoproceso = tipoproceso;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_posicioncambiaria")
	public PosicionCambiaria getPosicionCambiaria() {
		return posicionCambiaria;
	}

	public void setPosicionCambiaria(PosicionCambiaria posicionCambiaria) {
		this.posicionCambiaria = posicionCambiaria;
	}

	@Column(precision = 20 ,scale = 6)
	public BigDecimal getImportedelta() {
		return importedelta;
	}

	public void setImportedelta(BigDecimal importedelta) {
		this.importedelta = importedelta;
	}

	@Column(precision = 20 ,scale = 6)
	public BigDecimal getImporteactual() {
		return importeactual;
	}

	public void setImporteactual(BigDecimal importeactual) {
		this.importeactual = importeactual;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}
	
	

}
