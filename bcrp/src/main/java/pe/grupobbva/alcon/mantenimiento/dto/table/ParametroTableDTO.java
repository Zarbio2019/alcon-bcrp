package pe.grupobbva.alcon.mantenimiento.dto.table;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.ParametroDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Parametro;

@Data
public class ParametroTableDTO  {
	
	private String idparametro;
	private String codigoparametro;
	private String parametrodescripcion;
	private String iddetalleparametro;
	private String codigodetalleparametro;
	private String descripciondetalleparametro;
	private String visibledetalleparametro;
	
	public ParametroTableDTO() {
		super();
	}



	public ParametroTableDTO(String idparametro, String codigoparametro, String parametrodescripcion,
			String iddetalleparametro, String codigodetalleparametro, String descripciondetalleparametro,
			String visibledetalleparametro) {
		super();
		this.idparametro = idparametro;
		this.codigoparametro = codigoparametro;
		this.parametrodescripcion = parametrodescripcion;
		this.iddetalleparametro = iddetalleparametro;
		this.codigodetalleparametro = codigodetalleparametro;
		this.descripciondetalleparametro = descripciondetalleparametro;
		this.visibledetalleparametro = visibledetalleparametro;

	}
	
}
