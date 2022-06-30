package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Producto;

@Data
public class ProductoDTO extends AbstractDTO<Producto> {

	private String codigo;
	private String descripcion;
	private String nombreproducto;
	private String codigobcr;
	private String tipooperacion;
	private String tipoentrega;
	private String rechazarcarga;

	public ProductoDTO() {
		super();
	}

	public ProductoDTO(Producto entity) {
		super(entity);
		this.codigo = entity.getCodigo();
		this.descripcion = entity.getDescripcion();
		this.nombreproducto = entity.getNombreproducto();
		this.codigobcr = entity.getCodigobcr();
		this.tipooperacion = entity.getTipooperacion();
		this.tipoentrega = entity.getTipoentrega();
		this.rechazarcarga = entity.getRechazarcarga();
		this.codigoestado = entity.getCodigoestado();

	}

	@Override
	public Producto fromDTO(Producto entity) {
		if (entity == null) {
			entity = new Producto();
		}

		if (codigo != null) {
			entity.setCodigo(this.codigo);
		}

		if (descripcion != null) {
			entity.setDescripcion(this.descripcion);
		}

		if (nombreproducto != null) {
			entity.setNombreproducto(this.nombreproducto);
		}

		if (codigobcr != null) {
			entity.setCodigobcr(this.codigobcr);
		}

		if (tipooperacion != null) {
			entity.setTipooperacion(this.tipooperacion);
		}

		if (tipoentrega != null) {
			entity.setTipoentrega(this.tipoentrega);
		}

		if (rechazarcarga != null) {
			entity.setRechazarcarga(this.rechazarcarga);
		}

		if (codigoestado != null) {
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
	 * @param descripcion
	 * @param nombreproducto
	 * @param codigobcr
	 * @param tipooperacion
	 * @param tipoentrega
	 * @param rechazarcarga
	 * @param codigoestado
	 */
	public ProductoDTO(String id, String codigo, String descripcion, String nombreproducto, String codigobcr,
			String tipooperacion, String tipoentrega, String rechazarcarga, Integer codigoestado) {
		super(id);
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nombreproducto = nombreproducto;
		this.codigobcr = codigobcr;
		this.tipooperacion = tipooperacion;
		this.tipoentrega = tipoentrega;
		this.rechazarcarga = rechazarcarga;
		this.codigoestado = codigoestado;
	}
	
	/**
	 * @param codigo
	 * @param descripcion
	 * @param nombreproducto
	 * @param codigobcr
	 * @param tipoentrega
	 * @param tipoentregadescripcion
	 */
	public ProductoDTO(String id, String codigo, String descripcion, String nombreproducto, String codigobcr,
			String tipoentrega) {
		super(id);
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.nombreproducto = nombreproducto;
		this.codigobcr = codigobcr;
		this.tipoentrega = tipoentrega;
		
	}
	
	public ProductoDTO(String id) {
		super(id);
	}

}
