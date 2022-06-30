package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.PosicionCambiaria;

@Data
public class PosicionCambiariaDTO extends AbstractDTO<PosicionCambiaria> {
	
	private String codigo;
	private String rubro;
	private String descripcion;
	private Integer idproducto;
	private String codigobcr;
	private String tipooperacion;
	private String tipocliente;
	private String residente;
	private String tipoentrega;
	private String callput;
	private String padrerubro;
	private Boolean editar;
	private Boolean detalle;
	private String descripcionc2;
	
	public PosicionCambiariaDTO() {
		super();
	}
	
	public PosicionCambiariaDTO(String id) {
		super(id);
	}

	
	public PosicionCambiariaDTO(PosicionCambiaria entity) {
		super(entity);
		this.codigo = entity.getCodigo();
		this.rubro = entity.getRubro();
		this.descripcion = entity.getDescripcion();
		this.idproducto = entity.getIdProducto();
		this.codigobcr = entity.getCodigoBCR();
		this.tipooperacion = entity.getTipoOperacion();
		this.tipocliente = entity.getTipoCliente();
		this.residente = entity.getResidente();
		this.tipoentrega = entity.getTipoEntrega();
		this.callput = entity.getCallPut();
		this.padrerubro = entity.getPadreRubro();
		this.editar = entity.getEditar();
		this.detalle = entity.getDetalle();
		this.descripcionc2=entity.getDescripcionc2();
	}

	@Override
	public PosicionCambiaria fromDTO(PosicionCambiaria entity) {
		if (entity == null) {
			entity = new PosicionCambiaria();
		}
		
		if(codigo!=null) {
			entity.setCodigo(this.codigo);	
		}
		
		if(rubro!=null) {
			entity.setRubro(this.rubro);
		}
		
		if(descripcion!=null) {
			entity.setDescripcion(this.descripcion);
		}
		
		if(idproducto!=null) {
			entity.setIdProducto(this.idproducto);
		}
		
		if(codigobcr!=null) {
			entity.setCodigoBCR(this.codigobcr);
		}
		
		if(tipooperacion!=null) {
			entity.setTipoOperacion(this.tipooperacion);
		}
		
		if(tipocliente!=null) {
			entity.setTipoCliente(this.tipocliente);
		}
		
		if(residente!=null) {
			entity.setResidente(this.residente);
		}
		
		if(tipoentrega!=null) {
			entity.setTipoEntrega(this.tipoentrega);
		}
		
		if(callput!=null) {
			entity.setCallPut(this.callput);
		}
		
		if(padrerubro!=null) {
			entity.setPadreRubro(this.padrerubro);
		}
		
		if(editar!=null) {
			entity.setEditar(this.editar);
		}
		if(detalle!=null) {
			entity.setDetalle(this.detalle);
		}
		
		if(descripcionc2!=null) {
			entity.setDescripcionc2(this.descripcionc2);
		}
		
		if(codigoestado!=null) {
			entity.setCodigoestado(this.codigoestado);
		}
		return entity;
	}

	@Override
	public void preactualizar() {
		super.preactualizar();
	}

	/**
	 * @param codigo
	 * @param rubro
	 * @param descripcion
	 * @param idproducto
	 * @param codigobcr
	 * @param tipooperacion
	 * @param tipocliente
	 * @param residente
	 * @param tipoentrega
	 * @param callput
	 * @param padrerubro
	 * @param codigoestado
	 * @param editar
	 * @param detalle
	 */
	public PosicionCambiariaDTO(String id, String codigo, String rubro, String descripcion, Integer idproducto, String codigobcr,
			String tipooperacion, String tipocliente, String residente, String tipoentrega,
			String callput, String padrerubro, Boolean editar, Boolean detalle, String descripcionc2) {
		super(id);
		this.codigo = codigo;
		this.rubro = rubro;
		this.descripcion = descripcion;
		this.idproducto = idproducto;
		this.codigobcr = codigobcr;
		this.tipooperacion = tipooperacion;
		this.tipocliente = tipocliente;
		this.residente = residente;
		this.tipoentrega = tipoentrega;
		this.callput = callput;
		this.padrerubro = padrerubro;
		this.editar = editar;
		this.detalle = detalle;
		this.descripcionc2 = descripcionc2;
	}

	public PosicionCambiariaDTO( String codigo, String rubro, String descripcion, Integer idproducto, String codigobcr,
			String tipooperacion, String tipocliente, String residente, String tipoentrega,
			String callput, String padrerubro, Boolean editar, Boolean detalle, String descripcionc2) {
		super();
		this.codigo = codigo;
		this.rubro = rubro;
		this.descripcion = descripcion;
		this.idproducto = idproducto;
		this.codigobcr = codigobcr;
		this.tipooperacion = tipooperacion;
		this.tipocliente = tipocliente;
		this.residente = residente;
		this.tipoentrega = tipoentrega;
		this.callput = callput;
		this.padrerubro = padrerubro;
		this.editar = editar;
		this.detalle = detalle;
		this.descripcionc2 = descripcionc2;
	}

}
