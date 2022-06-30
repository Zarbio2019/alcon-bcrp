package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "Ciuu")
public @Data class Ciuu extends AbstractEntity {
	
	@Size(max = 8)
	private String central;
	
	@Size(max = 4)
	private String ciuu;
	
	private Integer codigoestado;
	
}
