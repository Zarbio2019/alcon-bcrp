package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.AnexoOcho;
import pe.grupobbva.alcon.mantenimiento.entity.CuadreAnexoOcho;

@Data
public class CuadreAnexoOchoDTO extends AbstractDTO<CuadreAnexoOcho>{
	
	private String idAnexoOcho;
	private Calendar fecha;
	private BigDecimal montoposicioncambiaria;
	private BigDecimal montoanexo;
	private BigDecimal diferencia;
	private String progreso;
	private String descripcion;
	
	public CuadreAnexoOchoDTO() {
		super();
	}
	
	public CuadreAnexoOchoDTO(String id) {
		super(id);
	}
	
	
	public CuadreAnexoOchoDTO(CuadreAnexoOcho entity) {
		super(entity);
		this.idAnexoOcho = entity.getAnexoOcho().getId();
		this.fecha = entity.getFecha();
		this.montoposicioncambiaria = entity.getMontoposicioncambiaria();
		this.montoanexo = entity.getMontoanexo();
		this.diferencia = entity.getDiferencia();
		this.progreso = entity.getProgreso();
		this.descripcion = entity.getDescripcion();
	}
	
	@Override
	public CuadreAnexoOcho fromDTO(CuadreAnexoOcho entity) {
		if(entity == null) {
			entity = new CuadreAnexoOcho();
		}
		
		if(idAnexoOcho != null) {
			entity.setAnexoOcho(new AnexoOcho(this.idAnexoOcho));
		}
		
		if(fecha != null) {
			entity.setFecha(fecha);
		}
		
		if(montoposicioncambiaria != null) {
			entity.setMontoposicioncambiaria(this.montoposicioncambiaria);
		}
		
		if(montoanexo != null) {
			entity.setMontoanexo(this.montoanexo);
		}
		
		if(diferencia != null) {
			entity.setDiferencia(this.diferencia);
		}
		
		if(progreso != null) {
			entity.setProgreso(this.progreso);
		}
		
		if(descripcion != null) {
			entity.setDescripcion(this.descripcion);
		}
		
		return entity;
	}

	@Override
	public void preactualizar() {
		super.preactualizar();
	}
	
	public CuadreAnexoOchoDTO(String id, String idAnexoOcho, Calendar fecha, BigDecimal montoposicioncambiaria,
			BigDecimal montoanexo, BigDecimal diferencia, String progreso, String descripcion) {
		super(id);
		this.idAnexoOcho = idAnexoOcho;
		this.fecha = fecha;
		this.montoposicioncambiaria = montoposicioncambiaria;
		this.montoanexo = montoanexo;
		this.diferencia = diferencia;
		this.progreso = progreso;
		this.descripcion = descripcion;
	}


	public CuadreAnexoOchoDTO(String idAnexoOcho, Calendar fecha, BigDecimal montoposicioncambiaria,
			BigDecimal montoanexo, BigDecimal diferencia, String progreso, String descripcion) {
		super();
		this.idAnexoOcho = idAnexoOcho;
		this.fecha = fecha;
		this.montoposicioncambiaria = montoposicioncambiaria;
		this.montoanexo = montoanexo;
		this.diferencia = diferencia;
		this.progreso = progreso;
		this.descripcion = descripcion;
	}
	
	

}
