package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "Correlativo")
@Data
public class Correlativo extends AbstractEntity {
	
	@Size(max = 50)
	@NotNull
	private String nombrecorrelativo;
	
	@Size(max = 2)
	private String mescorrelativo;
	
	@Size(max = 4)
	private String aniocorrelativo;
	
	@Size(max = 2)
	private String diacorrelativo;
	
	@NotNull
	private Integer valorcorrelativo;
		
}
