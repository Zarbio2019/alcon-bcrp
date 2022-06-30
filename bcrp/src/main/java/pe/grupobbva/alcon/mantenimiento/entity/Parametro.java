package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "Parametro")
@Data
public class Parametro extends AbstractEntity {
	
	public Parametro(String id) {
		super(id);
	}
	public Parametro() {
		super();
	}
	private static final long serialVersionUID = 1L;
	
	@Size(max = 3)
	private String codigo;
	
	@Size(max = 50)
	private String descripcion;

}
