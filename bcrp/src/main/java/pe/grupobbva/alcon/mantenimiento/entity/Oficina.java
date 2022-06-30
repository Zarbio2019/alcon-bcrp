package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Oficina")
public class Oficina extends AbstractEntity {
	
	public Oficina(String id) {
		super(id);
	}
	
	public Oficina() {
		super();
	}


	private String codigo;
	
	@Size(max = 50)
	private String descripcion;
	
	@Size(max = 10)
	private String posicioncambiaria;

	@Size(max = 4)
	@NotNull
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPosicioncambiaria() {
		return posicioncambiaria;
	}

	public void setPosicioncambiaria(String posicioncambiaria) {
		this.posicioncambiaria = posicioncambiaria;
	}
	
	
	
		
}
