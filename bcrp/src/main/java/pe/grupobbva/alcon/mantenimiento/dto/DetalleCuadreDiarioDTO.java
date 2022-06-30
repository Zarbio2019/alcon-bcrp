package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleCuadreDiario;
import pe.grupobbva.alcon.mantenimiento.entity.CuadreDiario;
import pe.grupobbva.alcon.mantenimiento.entity.PlantillaCalculo;

@Data
public class DetalleCuadreDiarioDTO extends AbstractDTO<DetalleCuadreDiario>{
	private String idCuadreDiario;
	private String idPlantillaCalculo;
	private BigDecimal valorCuadre;
	private Boolean estado;
	
	public DetalleCuadreDiarioDTO() {
		super();
	}
	
	public DetalleCuadreDiarioDTO(String id) {
		super(id);
	}
	
	public DetalleCuadreDiarioDTO(DetalleCuadreDiario entity) {
		super(entity);
		this.idCuadreDiario= entity.getCuadrediario().getId();
		this.idPlantillaCalculo=entity.getPlantillacalculo().getId();
		this.valorCuadre = entity.getValorcuadre();
		this.estado=entity.getEstado();
	}
	
	public DetalleCuadreDiario fromDTO(DetalleCuadreDiario entity) {
		if(entity == null) {
			entity = new DetalleCuadreDiario();
		}
		
		if(idCuadreDiario !=null) {
			entity.setCuadrediario(new CuadreDiario(this.idCuadreDiario));
		}
		
		if(idPlantillaCalculo!=null) {
			entity.setPlantillacalculo(new PlantillaCalculo(this.idPlantillaCalculo));
		}
		
		if(valorCuadre != null) {
			entity.setValorcuadre(this.valorCuadre);
		}
		
		if(estado!=null) {
			entity.setEstado(this.estado);
		}
		
		return entity;
	}
	
	@Override
	public void preactualizar() {
		super.preactualizar();
	}


	/**
	 * @param idCuadreDiario
	 * @param idPlantillaCalculo
	 * @param valorCuadre
	 * @param estado
	 */
	public DetalleCuadreDiarioDTO(String id, String idCuadreDiario, String idPlantillaCalculo, BigDecimal valorCuadre,
			Boolean estado) {
		super(id);
		this.idCuadreDiario = idCuadreDiario;
		this.idPlantillaCalculo = idPlantillaCalculo;
		this.valorCuadre = valorCuadre;
		this.estado = estado;
	}

}
