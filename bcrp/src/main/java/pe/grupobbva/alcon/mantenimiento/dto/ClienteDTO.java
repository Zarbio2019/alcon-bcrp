package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;

@Data
public class ClienteDTO extends AbstractDTO<Cliente> {

	private String codigo;
	private String nombre;
	private String entidad;
	private String paisresidencia;
	private String riesgopais;
	private String altamira;
	private String plaza;
	private String sector;
	private String nombrecorto;
	private String rechazarcarga;
	private String tipocliente;
	private String codigoSwift;
	private Integer tipoDocumento;
	private String numeroDocumento;

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(Cliente entity) {
		super(entity);
		this.codigo = entity.getCodigo();
		this.nombre = entity.getNombre();
		this.entidad = entity.getEntidad();
		this.paisresidencia = entity.getPaisresidencia();
		this.riesgopais = entity.getRiesgopais();
		this.altamira = entity.getAltamira();
		this.plaza = entity.getPlaza();
		this.sector = entity.getSector();
		this.nombrecorto = entity.getNombrecorto();
		this.rechazarcarga = entity.getRechazarcarga();
		this.tipocliente = entity.getTipocliente();
		this.codigoestado = entity.getCodigoestado();
		this.codigoSwift = entity.getCodigoswift();
		this.tipoDocumento = entity.getTipodocumento();
		this.numeroDocumento = entity.getNumerodocumento();
	}

	@Override
	public Cliente fromDTO(Cliente entity) {

		if (entity == null) {
			entity = new Cliente();
		}

		if (codigo != null) {
			entity.setCodigo(this.codigo);
		}

		if (nombre != null) {
			entity.setNombre(this.nombre);
		}

		if (entidad != null) {
			entity.setEntidad(this.entidad);
		}

		if (paisresidencia != null) {
			entity.setPaisresidencia(this.paisresidencia);
		}

		if (riesgopais != null) {
			entity.setRiesgopais(this.riesgopais);
		}

		if (altamira != null) {
			entity.setAltamira(this.altamira);
		}

		if (plaza != null) {
			entity.setPlaza(this.plaza);
		}

		if (sector != null) {
			entity.setSector(this.sector);
		}

		if (nombrecorto != null) {
			entity.setNombrecorto(this.nombrecorto);
		}

		if (rechazarcarga != null) {
			entity.setRechazarcarga(this.rechazarcarga);
		}

		if (tipocliente != null) {
			entity.setTipocliente(this.tipocliente);
		}

		if (codigoestado != null) {
			entity.setCodigoestado(this.codigoestado);
		}

		if (codigoSwift != null) {
			entity.setCodigoswift(this.codigoSwift);
		}

		if (tipoDocumento != null) {
			entity.setTipodocumento(this.tipoDocumento);
		}

		if (numeroDocumento != null) {
			entity.setNumerodocumento(this.numeroDocumento);
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
	 * @param codigo
	 * @param nombre
	 * @param entidad
	 * @param paisresidencia
	 * @param riesgopais
	 * @param altamira
	 * @param plaza
	 * @param sector
	 * @param nombrecorto
	 * @param rechazarcarga
	 * @param tipocliente
	 * @param codigoestado
	 * @param codigoSwift
	 * @param tipoDocumento
	 * @param numeroDocumento
	 */
	public ClienteDTO(String id, String codigo, String nombre, String entidad, String paisresidencia, String riesgopais,
			String altamira, String plaza, String sector, String nombrecorto, String rechazarcarga, String tipocliente, 
			String codigoswift, Integer tipodocumento, String numerodocumento, Integer codigoestado) {
		super(id);
		this.codigo = codigo;
		this.nombre = nombre;
		this.entidad = entidad;
		this.paisresidencia = paisresidencia;
		this.riesgopais = riesgopais;
		this.altamira = altamira;
		this.plaza = plaza;
		this.sector = sector;
		this.nombrecorto = nombrecorto;
		this.rechazarcarga = rechazarcarga;
		this.tipocliente = tipocliente;
		this.codigoSwift = codigoswift;
		this.tipoDocumento = tipodocumento;
		this.numeroDocumento = numerodocumento;
		this.codigoestado = codigoestado;
		
	}

	/**
	 * 
	 * @param id
	 * @param codigo
	 * @param nombre
	 * @param entidad
	 * @param paisresidencia
	 * @param riesgopais
	 * @param altamira
	 * @param plaza
	 * @param sector
	 * @param nombrecorto
	 * @param rechazarcarga
	 * @param tipocliente
	 * @param codigoSwift
	 * @param tipoDocumento
	 * @param numeroDocumento
	 */
	public ClienteDTO(String id, String codigo, String nombre, String entidad, String paisresidencia, String riesgopais,
			String altamira, String plaza, String sector, String nombrecorto, String rechazarcarga, String tipocliente,
			String codigoSwift, Integer tipoDocumento, String numeroDocumento) {
		super(id);
		this.codigo = codigo;
		this.nombre = nombre;
		this.entidad = entidad;
		this.paisresidencia = paisresidencia;
		this.riesgopais = riesgopais;
		this.altamira = altamira;
		this.plaza = plaza;
		this.sector = sector;
		this.nombrecorto = nombrecorto;
		this.rechazarcarga = rechazarcarga;
		this.tipocliente = tipocliente;
		this.codigoSwift = codigoSwift;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
	}

	public ClienteDTO(String id) {
		super(id);
	}

}
