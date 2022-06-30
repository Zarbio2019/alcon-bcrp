package pe.grupobbva.alcon.mantenimiento.dto.util;

import java.util.ArrayList;
import java.util.List;

public class TablaDinamica<T> {

	private List<String> columnas;
	private List<String> orden;
	private List<T> registros;
	
	
	
	public TablaDinamica(List<String> columnas, List<T> registros) {
		super();
		this.columnas = columnas;
		this.registros = registros;
	}
	
	public TablaDinamica() {
		super();
	}
	
	/**
	 * @return the columnas
	 */
	public List<String> getColumnas() {
		return columnas;
	}
	/**
	 * @param columnas the columnas to set
	 */
	public void setColumnas(List<String> columnas) {
		this.columnas = columnas;
	}
	/**
	 * @return the registros
	 */
	public List<T> getRegistros() {
		if(registros==null) {
			registros=new ArrayList<>();
		}
		
		return registros;
	}
	/**
	 * @param registros the registros to set
	 */
	public void setRegistros(List<T> registros) {
		this.registros = registros;
	}

	public List<String> getOrden() {
		return orden;
	}

	public void setOrden(List<String> orden) {
		this.orden = orden;
	}
	
	
	
}
