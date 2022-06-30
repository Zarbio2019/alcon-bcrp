package pe.grupobbva.alcon.mantenimiento.dto;

import lombok.Data;

@Data
public class ParametrosAnexoOchoDTO {

	private String idcuadreanexoocho;
	private String fuente;
	private String tipooperacion;
	private Integer reporte;
	private String codigo;
	private String codigoproducto;
	private String codigoarchivo;
	private String idposicioncambiaria;
	private String idsaldoderivados;
	
	public ParametrosAnexoOchoDTO(String idcuadreanexoocho, String fuente, String tipooperacion, Integer reporte,
			String codigo, String codigoproducto, String codigoarchivo, String idposicioncambiaria,String idsaldoderivados  ) {
		super();
		this.idcuadreanexoocho = idcuadreanexoocho;
		this.fuente = fuente;
		this.tipooperacion = tipooperacion;
		this.reporte = reporte;
		this.codigo = codigo;
		this.codigoproducto = codigoproducto;
		this.codigoarchivo = codigoarchivo;
		this.idposicioncambiaria = idposicioncambiaria;
		this.idsaldoderivados = idsaldoderivados;
	}


	public ParametrosAnexoOchoDTO() {
		super();
	}
	
}
