package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CuadreDiario;

@Data
public class CuadreDiarioDTO extends AbstractDTO<CuadreDiario> {
	
	private Calendar fechacuadrediario;
	private BigDecimal totalcuadreplantilla;
	private BigDecimal totalreferencial;
	private Boolean estado;
	
	public CuadreDiarioDTO() {
		super();
	}
	
	public CuadreDiarioDTO(String id) {
		super(id);
	}
	
	public CuadreDiarioDTO(CuadreDiario entity) {
		super(entity);
		this.fechacuadrediario = entity.getFechacuadrediario();
	}

	
	@Override
	public CuadreDiario fromDTO(CuadreDiario entity) {
		if (entity == null) {
			entity = new CuadreDiario();
		}
		
		if(fechacuadrediario != null) {
			entity.setFechacuadrediario(this.fechacuadrediario);
		}
		

		
		return entity;
	}
	
	@Override
	public void preactualizar() {
		super.preactualizar();
	}

	/**
	 * @param fechacuadrediario
	 * @param totalcuadreplantilla
	 * @param totalreferencial
	 * @param estado
	 */
	public CuadreDiarioDTO(String id, Calendar fechacuadrediario, BigDecimal totalcuadreplantilla, BigDecimal totalreferencial,
			Boolean estado) {
		super(id);
		this.fechacuadrediario = fechacuadrediario;
		this.totalcuadreplantilla = totalcuadreplantilla;
		this.totalreferencial = totalreferencial;
		this.estado = estado;
	}
	
	
	
}
