package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.custom.ImportesReporteCuadreDiarioC2;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.ParametroResponse;
import pe.grupobbva.alcon.mantenimiento.util.ReportUtils;

@Data
public class ReporteCuadreDiarioC2ExcelDTO {

	private String column1;
	private String column2;
	private String column3;
	private String column4;
	private String column5;
	private String column6;
	private String column7;
	
	private static final ReportUtils Utils = new ReportUtils();
	
	public ReporteCuadreDiarioC2ExcelDTO(String column1, String column2, String column3, String column4, String column5,
			String column6, String column7) {
		super();
		this.column1 = column1;
		this.column2 = column2;
		this.column3 = column3;
		this.column4 = column4;
		this.column5 = column5;
		this.column6 = column6;
		this.column7 = column7;
	}

	public ReporteCuadreDiarioC2ExcelDTO() {
		super();
	}
	
	public void numberFormat() {
		if(!StringUtils.isBlank(this.getColumn1())) {
			if(this.getColumn1().equals("SALDO ANTERIOR") ||
				this.getColumn1().equals("PACTADAS") ||
				this.getColumn1().equals("VENCIDAS") ||
				this.getColumn1().equals("OMITIDAS") ||
				this.getColumn1().equals("ANULADAS") ||
				this.getColumn1().equals("MODIFICADAS") ||
				this.getColumn1().equals("TOTALES")||
				this.getColumn1().equals("DIFERENCIA") ||
				this.getColumn1().equals("OTRAS DIVISAS") || 
				this.getColumn1().equals("OTRA OFICINA")) {
				
				this.setColumn2(Utils.numberFormat(this.getColumn2()));
				this.setColumn3(Utils.numberFormat(this.getColumn3()));
				this.setColumn4(Utils.numberFormat(this.getColumn4()));
				this.setColumn5(Utils.numberFormat(this.getColumn5()));
				this.setColumn7(Utils.numberFormat(this.getColumn7()));
			}
		}
		
		if(StringUtils.isBlank(this.getColumn1()) && !StringUtils.isBlank(this.getColumn7())) {
			this.setColumn7(Utils.numberFormat(this.getColumn7()));
		}
	}
	
	public ReporteCuadreDiarioC2ExcelDTO(ParametroResponse cuenta ) {
		//HEADERS
		super();
		this.setColumn1((cuenta.getValorparametro1().equals("C")?"COMPRA":"VENTA")+" "+cuenta.getValorparametro2());
		this.setColumn2("PUBLICO");
		this.setColumn3(cuenta.getValorparametro4());
		this.setColumn4("FINANCIERO");
		this.setColumn5(cuenta.getValorparametro5());
		this.setColumn6("SALDO CONTABLE");
		this.setColumn7(cuenta.getDescripciondetalleparametro());
	}
	
	public ReporteCuadreDiarioC2ExcelDTO(ParametroResponse estadoOperaciones , ImportesReporteCuadreDiarioC2 importes) {
		super();
		
		this.setColumn1(estadoOperaciones.getDescripciondetalleparametro());
		this.setColumn2(importes.getImportepublico()==null?"0.00":importes.getImportepublico().toString());
		this.setColumn3(importes.getImporteposicionpublico()== null ?"0.00":importes.getImporteposicionpublico().toString());
		this.setColumn4(importes.getImportefinanciero()== null?"0.00":importes.getImportefinanciero().toString());
		this.setColumn5(importes.getImporteposicionfinanciero() == null?"0.00":importes.getImporteposicionfinanciero().toString());
		this.setColumn6(estadoOperaciones.getValorparametro1().equals("0000")?"":estadoOperaciones.getValorparametro1());
		
		if(estadoOperaciones.getDescripciondetalleparametro().equals("OTRAS DIVISAS")) {
			
			this.setColumn7((this.getColumn2()==null? BigDecimal.ZERO : Utils.numberAsBigDecimal(this.getColumn2()))
					.add(this.getColumn4()==null? BigDecimal.ZERO : Utils.numberAsBigDecimal(this.getColumn4()))
					.toString());
			
		}else {
			
			this.setColumn7(importes.getImportesaldo()==null?"0.00":importes.getImportesaldo().toString());
		
		}
		
	}
	
	public void sumatoriaimportesaldo(ImportesReporteCuadreDiarioC2 importes) {
		
		this.setColumn7(this.getColumn7()==null? 
				(
				importes.getImportesaldo()==null?"0.00":
				importes.getImportesaldo().toString()
				) : 
				importes.getImportesaldo().add(Utils.numberAsBigDecimal(this.getColumn7())).toString());
		
	}
	
	public void diferencia(ReporteCuadreDiarioC2ExcelDTO sumatotales, ReporteCuadreDiarioC2ExcelDTO sumatoriaimportesaldo) {
		
		this.setColumn1("DIFERENCIA");
		this.setColumn2("");
		this.setColumn3("0.00");
		this.setColumn4("");
		this.setColumn5("0.00");
		this.setColumn6("");
		
		this.setColumn7(Utils.numberAsBigDecimal(sumatoriaimportesaldo.getColumn7())
			  .subtract(Utils.numberAsBigDecimal(sumatotales.getColumn7())).toString());
		
	}
	
	public void diffinal(ReporteCuadreDiarioC2ExcelDTO diferencia, ReporteCuadreDiarioC2ExcelDTO otrasdivisas) {
		
		this.setColumn7(Utils.numberAsBigDecimal(diferencia.getColumn7())
				   .add(Utils.numberAsBigDecimal(otrasdivisas.getColumn7())).toString());
		
	}
	
	public void sumatotales( ImportesReporteCuadreDiarioC2 importes) {
		
		this.setColumn1("TOTALES");
		this.setColumn2(this.getColumn2()==null? 
				(
				importes.getImportepublico()==null?"0.00":
				importes.getImportepublico().toString()
				) : 
				importes.getImportepublico().add(Utils.numberAsBigDecimal(this.getColumn2())).toString());		
		
		this.setColumn3(this.getColumn3()==null?
				(
				importes.getImporteposicionpublico()==null?"0.00":		
				importes.getImporteposicionpublico().toString() 
				):
				importes.getImporteposicionpublico().add(Utils.numberAsBigDecimal(this.getColumn3())).toString());
		
		this.setColumn4(this.getColumn4()==null?
				(
				importes.getImportefinanciero()	== null?"0.00":	
				importes.getImportefinanciero().toString()
				):
				importes.getImportefinanciero().add(Utils.numberAsBigDecimal(this.getColumn4())).toString());
		
		this.setColumn5(this.getColumn5()==null?
				(
				importes.getImporteposicionfinanciero() == null ? "0.00":
				importes.getImporteposicionfinanciero().toString() 
				):
				importes.getImporteposicionfinanciero().add(Utils.numberAsBigDecimal(this.getColumn5())).toString());
		
		this.setColumn6("SALDO STAR");
		
		this.setColumn7((this.getColumn3()==null? BigDecimal.ZERO : Utils.numberAsBigDecimal(this.getColumn3()))
				    .add(this.getColumn5()==null? BigDecimal.ZERO : Utils.numberAsBigDecimal(this.getColumn5()))
				    .toString());
		
	}
	
}
