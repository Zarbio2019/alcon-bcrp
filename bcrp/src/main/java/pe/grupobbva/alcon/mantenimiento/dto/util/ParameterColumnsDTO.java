package pe.grupobbva.alcon.mantenimiento.dto.util;

import lombok.Data;

@Data
public class ParameterColumnsDTO {
	private String detalle;
    private String valor1; 
    private String valor2; 
    private String valor3;
    private String valor4;
    private String valor5;
    private String visible="Visible";
    
	public ParameterColumnsDTO(String detalle, String valor1, String valor2, String valor3, String valor4,
			String valor5, String visible) {
		super();
		this.detalle = detalle;
		this.valor1 = valor1;
		this.valor2 = valor2;
		this.valor3 = valor3;
		this.valor4 = valor4;
		this.valor5 = valor5;
	}
	
	public ParameterColumnsDTO() {
		super();
	}

}
