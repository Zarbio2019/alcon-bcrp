package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;  

import org.apache.commons.lang3.StringUtils;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.CuadreAnexoOcho;
import pe.grupobbva.alcon.mantenimiento.entity.DetalleAnexoOcho;

@Data
public class DetalleAnexoOchoDTO extends AbstractDTO<DetalleAnexoOcho>{
	
	/*Todos los productos*/
	private String idCuadreAnexoOcho;
	private String fuente;
	private String producto;
	private String numerooperacion;
	private String codigooperacion;
	private BigDecimal montoposicioncambiaria = BigDecimal.ZERO;
	private BigDecimal montoanexo = BigDecimal.ZERO;
	private BigDecimal diferencia = BigDecimal.ZERO;
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
	private BigDecimal tasainteresrecibe = BigDecimal.ZERO;
	private BigDecimal tasainteresentrega = BigDecimal.ZERO; 
	
	private String observacion;
	
	
	
	public DetalleAnexoOchoDTO() {
		super();
	}
	
	public Calendar StringtoCalendar(String datestring) throws ParseException {
		String year= datestring.substring(0,4);
		String month = datestring.substring(4,6);
		String day = datestring.substring(6,8);
		datestring= day + "/" + month + "/" + year;
	
	    Date newdate=new SimpleDateFormat("dd/MM/yyyy").parse(datestring);  
	    
		Calendar cal = Calendar.getInstance();
		cal.setTime(newdate);
		
		return cal;
	}
	
	public DetalleAnexoOchoDTO(String row, String codigoarchivo) throws ParseException {
		super();
		
		switch(codigoarchivo) {
		
		case "001":
			this.codigooperacion = row.substring(6,17);
			this.montoanexo = (new BigDecimal(StringUtils.isBlank(row.substring(39, 56))?"0":row.substring(39, 56))).divide(BigDecimal.valueOf(100000));
		  	this.cliente = row.substring(155,204);
		  	this.residente = row.substring(205,207);
		  	this.pais = row.substring(207,209);
		  	this.financiero = row.substring(229,232);
		  	this.monedaentrega = row.substring(133,135);
		  	this.monedarecibe = row.substring(136,138);
		  	if(!row.substring(139,147).trim().equals("")) {
		  		this.fechainicio = this.StringtoCalendar(row.substring(139,147)) ;
		  	}
		  	if(!row.substring(147,155).trim().equals("")) {
			  	this.fechavencimiento = this.StringtoCalendar(row.substring(147,155)) ;
		  	}
		  	
			break;
	  
		case "002":
			this.codigooperacion = row.substring(6,17);
			this.montoanexo = (new BigDecimal(StringUtils.isBlank(row.substring(39, 56))?"0":row.substring(39, 56))).divide(BigDecimal.valueOf(100000));
			this.cliente = row.substring(232,282);
		  	this.residente = row.substring(282,284);
		  	this.pais = row.substring(284,286);
		  	this.financiero = row.substring(306,309);
		  	this.tipotasainteresentrega = row.substring(133,173);
		  	this.tipotasainteresrecibe = row.substring(173,213);
		  	this.tasainteresentrega = (new BigDecimal(StringUtils.isBlank(row.substring(400, 411))?"0":row.substring(400, 411))).divide(BigDecimal.valueOf(1000000000)); 
		  	this.tasainteresrecibe = (new BigDecimal(StringUtils.isBlank(row.substring(411,422))?"0":row.substring(411,422))).divide(BigDecimal.valueOf(1000000000));  
			this.moneda = row.substring(213,216);
			if(!row.substring(216,224).trim().equals("")) {
		  		this.fechainicio = this.StringtoCalendar(row.substring(216,224)) ;
		  	}
		  	if(!row.substring(224,232).trim().equals("")) {
			  	this.fechavencimiento = this.StringtoCalendar(row.substring(224,232)) ;
		  	}
		  	
		  	break;
	  
		case "003":
			this.codigooperacion = row.substring(6,17);
			this.montoanexo = (new BigDecimal(StringUtils.isBlank(row.substring(39, 56))?"0":row.substring(39, 56))).divide(BigDecimal.valueOf(100000));
			this.cliente = row.substring(199,249);
			this.residente = row.substring(249,251);
		  	this.pais = row.substring(251,253);
		  	this.financiero = row.substring(273,276);
			if(!row.substring(183,191).trim().equals("")) {
		  		this.fechainicio = this.StringtoCalendar(row.substring(183,191)) ;
		  	}
		  	if(!row.substring(191,199).trim().equals("")) {
			  	this.fechavencimiento = this.StringtoCalendar(row.substring(191,199)) ;
		  	}
			break;
	  
		case "004":
			this.codigooperacion = row.substring(6,17);
			this.montoanexo = (new BigDecimal(StringUtils.isBlank(row.substring(39, 56))?"0":row.substring(39, 56))).divide(BigDecimal.valueOf(100000));
			this.cliente = row.substring(80,130);
		  	this.residente = row.substring(130,132);
		  	this.pais = row.substring(132,134);
		  	this.financiero = row.substring(154,157);
		  	this.monedaentrega = row.substring(57,60);
		  	this.monedarecibe = row.substring(60,63);
		  	if(!row.substring(64,72).trim().equals("")) {
		  		this.fechainicio = this.StringtoCalendar(row.substring(64,72)) ;
		  	}
		  	if(!row.substring(72, 80).trim().equals("")) {
			  	this.fechavencimiento = this.StringtoCalendar(row.substring(72, 80)) ;
		  	}
			break;
		default:
	    // code block
		}
		
	}
	
	public DetalleAnexoOchoDTO(DetalleAnexoOcho entity) {
		super(entity);
		this.idCuadreAnexoOcho = entity.getCuadreAnexoOcho().getId();
		this.fuente = entity.getFuente();
		this.numerooperacion = entity.getNumerooperacion();
		this.codigooperacion = entity.getCodigooperacion();
		this.montoposicioncambiaria = entity.getMontoposicioncambiaria();
		this.montoanexo = entity.getMontoanexo();
		this.diferencia = entity.getDiferencia();
		this.tipooperacion = entity.getTipooperacion();
		this.monedaentrega = entity.getMonedaentrega();
		this.monedarecibe = entity.getMonedarecibe();
		this.fechainicio = entity.getFechainicio();
		this.fechavencimiento = entity.getFechavencimiento();
		this.cliente = entity.getCliente();
		this.residente = entity.getResidente();
		this.pais = entity.getPais();
		this.financiero = entity.getFinanciero();
		this.tipotasainteresrecibe = entity.getTipotasainteresrecibe();
		this.tipotasainteresentrega = entity.getTipotasainteresentrega();
		this.moneda = entity.getMoneda();
		this.tasainteresrecibe = entity.getTasainteresrecibe();
		this.tasainteresentrega = entity.getTasainteresentrega();
		this.observacion = entity.getObservacion();
		
		
	}
	
	@Override
	public DetalleAnexoOcho fromDTO(DetalleAnexoOcho entity) {
		if(entity == null) {
			entity = new DetalleAnexoOcho();
		}
		
		if(idCuadreAnexoOcho != null) {
			entity.setCuadreAnexoOcho(new CuadreAnexoOcho(this.idCuadreAnexoOcho));
		}
		
		if(fuente != null) {
			entity.setFuente(this.fuente);
		}
		
		if(producto != null) {
			entity.setProducto(this.producto);
		}
		
		if(numerooperacion != null) {
			entity.setNumerooperacion(this.numerooperacion);
		}
		
		if(codigooperacion != null) {
			entity.setCodigooperacion(this.codigooperacion);
		}
		
		if(tipooperacion != null) {
			entity.setTipooperacion(this.tipooperacion);
		}
		
		if(montoposicioncambiaria != null) {
			entity.setMontoposicioncambiaria(this.montoposicioncambiaria);
		}
		
		if(montoanexo != null) {
			entity.setMontoanexo(this.montoanexo);
		}
		
		if(diferencia != null) {
			entity.setDiferencia(this.diferencia);
		}
		
		if(monedaentrega != null) {
			entity.setMonedaentrega(this.monedaentrega);
		}
		
		if(monedarecibe != null) {
			entity.setMonedarecibe(this.monedarecibe);
		}
		
		if(fechainicio != null) {
			entity.setFechainicio(this.fechainicio);
		}
		
		if(fechavencimiento != null) {
			entity.setFechavencimiento(this.fechavencimiento);
		}
		
		if(cliente != null) {
			entity.setCliente(this.cliente);
		}
		
		if(residente != null) {
			entity.setResidente(this.residente);
		}
		
		if(pais != null) {
			entity.setPais(this.pais);
		}
		
		if(financiero != null) {
			entity.setFinanciero(this.financiero);
		}
		
		if(tipotasainteresrecibe != null) {
			entity.setTipotasainteresrecibe(this.tipotasainteresrecibe);
		}
		
		if(tipotasainteresentrega != null) {
			entity.setTipotasainteresentrega(this.tipotasainteresentrega);
		}
		
		if(moneda != null) {
			entity.setMoneda(this.moneda);
		}
		
		if(tasainteresrecibe != null) {
			entity.setTasainteresrecibe(this.tasainteresrecibe);
		}
		
		if(tasainteresentrega != null) {
			entity.setTasainteresentrega(this.tasainteresentrega);
		}
		
		if(observacion != null) {
			entity.setObservacion(this.observacion);
		}
		return entity;
	}


	@Override
	public void preactualizar() {
		super.preactualizar();
	}

	public DetalleAnexoOchoDTO(String id,String idCuadreAnexoOcho, String fuente, String numerooperacion, String codigooperacion,
			BigDecimal montoposicioncambiaria, BigDecimal montoanexo, BigDecimal diferencia, String tipooperacion,
			String monedaentrega, String monedarecibe, Calendar fechainicio, Calendar fechavencimiento,
			String cliente, String residente, String pais, String financiero, String tipotasainteresrecibe,
			String tipotasainteresentrega, String moneda, BigDecimal tasainteresrecibe, BigDecimal tasainteresentrega,
			String observacion) {
		super(id);
		this.idCuadreAnexoOcho = idCuadreAnexoOcho;
		this.fuente = fuente;
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
	
	public DetalleAnexoOchoDTO(String idCuadreAnexoOcho, String fuente, String numerooperacion,String codigooperacion,
			BigDecimal montoposicioncambiaria, BigDecimal montoanexo, BigDecimal diferencia, String tipooperacion,
			String monedaentrega, String monedarecibe, Calendar fechainicio, Calendar fechavencimiento,
			String cliente, String residente, String pais, String financiero, String tipotasainteresrecibe,
			String tipotasainteresentrega, String moneda, BigDecimal tasainteresrecibe, BigDecimal tasainteresentrega,
			String observacion) {
		super();
		this.idCuadreAnexoOcho = idCuadreAnexoOcho;
		this.fuente = fuente;
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
	
}
