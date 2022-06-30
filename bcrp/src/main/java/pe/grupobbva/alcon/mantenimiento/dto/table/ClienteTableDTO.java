package pe.grupobbva.alcon.mantenimiento.dto.table;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.ClienteDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Cliente;

@Data
public class ClienteTableDTO extends ClienteDTO {

	public ClienteTableDTO() {
		super();
	}

	public ClienteTableDTO(String id) {
		super(id);
	}

	public ClienteTableDTO(Cliente entity) {
		super(entity);
	}

	public ClienteTableDTO(String id, String codigo, String nombre, String entidad, String paisresidencia,
			String riesgopais, String altamira, String plaza, String sector, String nombrecorto, String rechazarcarga,
			String tipocliente, String codigoSwift, Integer tipoDocumento, String numeroDocumento) {

		super(id, codigo, nombre, entidad, paisresidencia, riesgopais, altamira, plaza, sector, nombrecorto,
				rechazarcarga, tipocliente, codigoSwift, tipoDocumento, numeroDocumento);
	}

	public ClienteTableDTO(String id, String codigo, String nombre, String entidad, String paisresidencia,
			String riesgopais, String altamira, String plaza, String sector, String nombrecorto, String rechazarcarga,
			String tipocliente, String codigoswift, Integer tipodocumento, String numerodocumento, Integer codigoestado,
			String paisResidenciaDescripcion, String riesgoPaisDescripcion, String rechazarCargaDescripcion,
			String tipoClienteDescripcion, String tipoDocumentoDescripcion) {

		super(id, codigo, nombre, entidad, paisresidencia, riesgopais, altamira, plaza, sector, nombrecorto,
				rechazarcarga, tipocliente, codigoswift, tipodocumento, numerodocumento, codigoestado);

		this.paisResidenciaDescripcion = paisResidenciaDescripcion;
		this.riesgoPaisDescripcion = riesgoPaisDescripcion;
		this.rechazarCargaDescripcion = rechazarCargaDescripcion;
		this.tipoClienteDescripcion = tipoClienteDescripcion;
		this.tipoDocumentoDescripcion = tipoDocumentoDescripcion;

	}

	private String paisResidenciaDescripcion;

	private String riesgoPaisDescripcion;

	private String rechazarCargaDescripcion;

	private String tipoClienteDescripcion;

	private String tipoDocumentoDescripcion;

}
