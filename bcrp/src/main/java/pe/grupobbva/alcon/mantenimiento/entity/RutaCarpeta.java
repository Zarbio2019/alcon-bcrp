package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "RutaCarpeta")
@Data
public class RutaCarpeta extends AbstractEntity {

	@Size(max = 500)
	@NotNull
	private String rutacarpeta;

}
