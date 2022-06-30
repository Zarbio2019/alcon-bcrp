package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import lombok.Data;

@Data
public class DetalleAnexoOchoExcelDTO {
	
	private String fuente;
	private String producto;
	private String numerooperacion;
	private String codigooperacion;
	private BigDecimal montoposicioncambiaria;
	private BigDecimal montoanexo;
	private BigDecimal diferencia;
	private String tipooperacion;
	private String monedaentrega;
	private String monedarecibe;
	private Calendar fechainicio;
	private Calendar fechavencimiento;
	private String cliente;
	private String residente;
	private String pais;
	private String financiero;
	
	
	/* Solo IRS */
	private String tipotasainteresrecibe;
	private String tipotasainteresentrega;
	private String moneda;
	private BigDecimal tasainteresrecibe;
	private BigDecimal tasainteresentrega; 
	
	private String observacion;
	
	
	public DetalleAnexoOchoExcelDTO() {
		super();
	}

	public DetalleAnexoOchoExcelDTO(String fuente, String producto, String numerooperacion, String codigooperacion,
			BigDecimal montoposicioncambiaria, BigDecimal montoanexo, BigDecimal diferencia, String tipooperacion,
			String monedaentrega, String monedarecibe, Calendar fechainicio, Calendar fechavencimiento, String cliente,
			String residente, String pais, String financiero, String tipotasainteresrecibe,
			String tipotasainteresentrega, String moneda, BigDecimal tasainteresrecibe, BigDecimal tasainteresentrega,
			String observacion) {
		super();
		this.fuente = fuente;
		this.producto = producto;
		this.numerooperacion = numerooperacion;
		this.codigooperacion = codigooperacion;
		this.montoposicioncambiaria = montoposicioncambiaria;
		this.montoanexo = montoanexo;
		this.diferencia = diferencia;
		this.tipooperacion = tipooperacion;
		this.monedaentrega = monedaentrega;
		this.monedarecibe = monedarecibe;
		this.fechainicio = fechainicio;
		this.fechavencimiento = fechavencimiento;
		this.cliente = cliente;
		this.residente = residente;
		this.pais = pais;
		this.financiero = financiero;
		this.tipotasainteresrecibe = tipotasainteresrecibe;
		this.tipotasainteresentrega = tipotasainteresentrega;
		this.moneda = moneda;
		this.tasainteresrecibe = tasainteresrecibe;
		this.tasainteresentrega = tasainteresentrega;
		this.observacion = observacion;
	}



	public List<String> headExcel() {
		List<String> columns = new ArrayList<String>();
		columns.add("Fuente");
		columns.add("Producto");
		columns.add("Numero Operación");
		columns.add("Código Operación");
		columns.add("Monto Posicion Cambiaria");
		columns.add("Monto Anexo");
		columns.add("Diferencia");
		columns.add("Tipo operación");
		columns.add("Moneda entrega");
		columns.add("Moneda recibe");
		columns.add("Fecha Inicio");
		columns.add("Fecha vencimiento");
		columns.add("Cliente");
		columns.add("Residente");
		columns.add("Pais");
		columns.add("Financiero");
		columns.add("Tipo tasa recibe");
		columns.add("Tipo tasa entrega");
		columns.add("Moneda");
		columns.add("Tasa recibe");
		columns.add("Tasa entrega");
		columns.add("Observación");
		return columns;
	}





}
