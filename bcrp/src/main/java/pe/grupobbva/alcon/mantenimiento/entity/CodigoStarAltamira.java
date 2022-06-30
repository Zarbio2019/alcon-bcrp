package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import pe.grupobbva.alcon.mantenimiento.dto.process.CodigoStarAltamiraCargaType;

@Entity
@Table(name = "CodigoStarAltamira")
@SuppressWarnings("serial")
public class CodigoStarAltamira extends AbstractEntity {
	
	public CodigoStarAltamira(CodigoStarAltamiraCargaType registro) {

		this.codigo = registro.getCodigo();
		this.altamira = registro.getAltamira();
		
	}
	
	public CodigoStarAltamira(String id) {
		super(id);
	}
	
	public CodigoStarAltamira() {
		super();
	}
	
	private static final long serialVersionUID = 1L;
	
	@Size(max = 20)
	private String codigo;
		
	@Size(max = 20)
	private String altamira;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getAltamira() {
		return altamira;
	}

	public void setAltamira(String altamira) {
		this.altamira = altamira;
	}

	
}
