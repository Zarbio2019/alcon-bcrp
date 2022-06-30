package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleParametro;
import pe.grupobbva.alcon.mantenimiento.entity.ValorParametro;

@Data
public class ValorParametroDTO extends AbstractDTO<ValorParametro> {

	private String valor;
	private String idDetalle;
	private Integer codigoestado;
	private Integer orden;
	
	public ValorParametroDTO() {
		super();
	}

	public ValorParametroDTO(ValorParametro entity) {
		super(entity);
		this.valor=entity.getValor();
		this.idDetalle=entity.getDetalleParametro().getId();
		this.codigoestado=entity.getCodigoestado();
		this.orden=entity.getOrden();
	}

	@Override
	public ValorParametro fromDTO(ValorParametro entity) {
		if (entity == null) {
			entity = new ValorParametro();
		}
		if(valor!=null) {
			entity.setValor(this.valor);
		}
		if(idDetalle!=null) {
			entity.setDetalleParametro(new DetalleParametro(this.idDetalle));
		}
		if(codigoestado!=null) {
			entity.setCodigoestado(this.codigoestado);
		}
		if(orden!= null) {
			entity.setOrden(this.orden);
		}
		return entity;
	}
	
	@Override
	public void preactualizar() {
		super.preactualizar();
	}

	/**
	 * @param id
	 * @param valor
	 * @param idDetalle
	 */
	
	public ValorParametroDTO(String id, String valor, String idDetalle,Integer orden) {
		super(id);
		this.valor = valor;
		this.idDetalle = idDetalle;
		this.orden= orden;
	}
	
	public ValorParametroDTO(String id, String valor, String idDetalle, Integer orden,Integer codigoestado) {
		super(id);
		this.valor = valor;
		this.idDetalle = idDetalle;
		this.codigoestado=codigoestado;
		this.orden= orden;
	}

}
