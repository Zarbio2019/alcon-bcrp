package pe.grupobbva.alcon.mantenimiento.dto.custom.response;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.table.ParametroTableDTO;
import pe.grupobbva.alcon.mantenimiento.dto.util.ParameterCode;

@Data
public class ParametroResponse implements Comparable<ParametroResponse>{
	
	private String idparametro;
	private String codigoparametro;
	private String parametrodescripcion;
	private String iddetalleparametro;
	private String codigodetalleparametro;
	private String descripciondetalleparametro;
	private String visibledetalleparametro;
	
	private String idvalorparametro1;
	private String valorparametro1;
	
	private String idvalorparametro2;
	private String valorparametro2;
	
	private String idvalorparametro3;
	private String valorparametro3;
	
	private String idvalorparametro4;
	private String valorparametro4;
	
	private String idvalorparametro5;
	private String valorparametro5;
	
	
	
	public ParametroResponse() {
		super();
	}

	public ParametroResponse(ParametroTableDTO dto) {
		super();
		this.idparametro = dto.getIdparametro();
		this.codigoparametro = dto.getCodigoparametro();
		this.parametrodescripcion = dto.getParametrodescripcion();
		this.iddetalleparametro = dto.getIddetalleparametro();
		this.codigodetalleparametro = dto.getCodigodetalleparametro();
		this.descripciondetalleparametro = dto.getDescripciondetalleparametro();
		this.visibledetalleparametro = dto.getVisibledetalleparametro();
	}

	public ParametroResponse(String idparametro, String codigoparametro, String parametrodescripcion,
			String iddetalleparametro, String codigodetalleparametro, String descripciondetalleparametro,
			String visibledetalleparametro, String idvalorparametro1, String valorparametro1, String idvalorparametro2,
			String valorparametro2, String idvalorparametro3, String valorparametro3, String idvalorparametro4,
			String valorparametro4, String idvalorparametro5, String valorparametro5) {
		super();
		this.idparametro = idparametro;
		this.codigoparametro = codigoparametro;
		this.parametrodescripcion = parametrodescripcion;
		this.iddetalleparametro = iddetalleparametro;
		this.codigodetalleparametro = codigodetalleparametro;
		this.descripciondetalleparametro = descripciondetalleparametro;
		this.visibledetalleparametro = visibledetalleparametro;
		this.idvalorparametro1 = idvalorparametro1;
		this.valorparametro1 = valorparametro1;
		this.idvalorparametro2 = idvalorparametro2;
		this.valorparametro2 = valorparametro2;
		this.idvalorparametro3 = idvalorparametro3;
		this.valorparametro3 = valorparametro3;
		this.idvalorparametro4 = idvalorparametro4;
		this.valorparametro4 = valorparametro4;
		this.idvalorparametro5 = idvalorparametro5;
		this.valorparametro5 = valorparametro5;
	}

	@Override
	public int compareTo(ParametroResponse o) {
		ParameterCode parametercode = new ParameterCode();
		if(o.getCodigoparametro().equals(parametercode.getCuentas())) {
			if (valorparametro2.compareTo(o.getValorparametro2())<0 ) {
	            return -1;
	        }
	        if (valorparametro2.compareTo(o.getValorparametro2())>0) {
	            return 1;
	        }
		}else if(o.getCodigoparametro().equals(parametercode.getEstadoOperaciones())) {
			if (codigodetalleparametro.compareTo(o.getCodigodetalleparametro())<0 ) {
	            return -1;
	        }
	        if (codigodetalleparametro.compareTo(o.getCodigodetalleparametro())>0) {
	            return 1;
	        }
		}
		
        return 0;
	}
}
