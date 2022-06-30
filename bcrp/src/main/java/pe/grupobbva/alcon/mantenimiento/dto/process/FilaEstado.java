package pe.grupobbva.alcon.mantenimiento.dto.process;

import lombok.Data;

public @Data class FilaEstado {

	private FilaEstadoEnum estado;
	private String mensaje;

	/**
	 * @param estado
	 * @param mensaje
	 */
	public FilaEstado() {
		super();
		this.estado = FilaEstadoEnum.OK;
		this.mensaje = "";
	}

	public FilaEstado(FilaEstadoEnum estado, String mensaje) {
		super();
		this.estado = estado;
		this.mensaje = mensaje;
	}

	public enum FilaEstadoEnum {
		OK, ERROR;
	}

}
