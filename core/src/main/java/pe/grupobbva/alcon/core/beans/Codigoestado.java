package pe.grupobbva.alcon.core.beans;

public enum Codigoestado {

	ACTIVO(1),INACTIVO(2);
	
	
	
	Codigoestado(Integer codigoestado) {
		this.codigoestado=codigoestado;
	}

	private Integer codigoestado;
	
	public Integer getCodigoestado() {
		return codigoestado;
	}
	
}
