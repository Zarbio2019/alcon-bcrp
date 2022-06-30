package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.AnexoOcho;

@Data
public class AnexoOchoDTO extends AbstractDTO<AnexoOcho>{

	private String fuente;
	private String tipooperacion;
	private Integer reporte;
	private String codigo;
	private String codigoproducto;
	private String codigoarchivo;
	
	public AnexoOchoDTO() {
		super();
	}
	
	public AnexoOchoDTO(AnexoOcho entity) {
		super(entity);
		this.fuente = entity.getFuente();
		this.tipooperacion = entity.getTipooperacion();
		this.reporte = entity.getReporte();
		this.codigo = entity.getCodigo();
		this.codigoproducto = entity.getCodigoproducto();
		this.codigoarchivo = entity.getCodigoarchivo();
	}

	
	@Override
	public AnexoOcho fromDTO(AnexoOcho entity) {
		
		if(entity == null) {
			entity = new AnexoOcho();
		}
		
		if(fuente != null) {
			entity.setFuente(this.fuente);
		}
		
		if(tipooperacion != null) {
			entity.setTipooperacion(this.tipooperacion);
		}
		
		if(codigo != null) {
			entity.setCodigo(this.codigo);
		}
		
		if(codigoproducto!= null) {
			entity.setCodigoproducto(this.codigoproducto);
		}
		
		if(codigoarchivo!= null) {
			entity.setCodigoarchivo(this.codigoarchivo);
		}
		
		return entity;
	}

	@Override
	public void preactualizar() {
		super.preactualizar();
	}
	
	/**
	* 
 	* @param id
 	* @param fuente
 	* @param tipooperacion
 	* @param reporte
 	* @param codigo
 	*/
	public AnexoOchoDTO(String id,String fuente, String tipooperacion, Integer reporte, String codigo, String codigoproducto, String codigoarchivo) {
		super(id);
		this.fuente = fuente;
		this.tipooperacion = tipooperacion;
		this.reporte = reporte;
		this.codigo = codigo;
		this.codigoproducto = codigoproducto;
		this.codigoarchivo = codigoarchivo;
	}
	
	public AnexoOchoDTO(String id) {
		super(id);
	}
	
	

}
