package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ValorParametro")
public class ValorParametro extends AbstractEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Size(max = 50)
	private String valor;

	private DetalleParametro detalleParametro;
	
	private Integer orden;

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public String getValor() {
		/**Hack oracle*/
		if(valor==null) {
			valor="";
		}
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_detalle")
	public DetalleParametro getDetalleParametro() {
		return detalleParametro;
	}

	public void setDetalleParametro(DetalleParametro detalleParametro) {
		this.detalleParametro = detalleParametro;
	}
	
	

}
