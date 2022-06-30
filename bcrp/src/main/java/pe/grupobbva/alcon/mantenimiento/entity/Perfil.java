package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "Perfil")
@Data
public class Perfil extends AbstractEntity {
	
	@Size(max = 50)
	private String descripcion;
	
	@Size(max = 6)
	private String hostperfil;
	
	private Integer codigoestado;

}
