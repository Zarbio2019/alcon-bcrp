package pe.grupobbva.alcon.mantenimiento.dto.custom;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ImportesReporteCuadreDiarioC2 {

	private BigDecimal importeposicionpublico=BigDecimal.ZERO;
	private BigDecimal importeposicionfinanciero=BigDecimal.ZERO;
	private BigDecimal importepublico=BigDecimal.ZERO;
	private BigDecimal importefinanciero=BigDecimal.ZERO;
	private BigDecimal importesaldo=BigDecimal.ZERO;
	
	public ImportesReporteCuadreDiarioC2(BigDecimal importeposicionpublico, BigDecimal importeposicionfinanciero,
			BigDecimal importepublico, BigDecimal importefinanciero, BigDecimal importesaldo) {
		super();
		this.importeposicionpublico = importeposicionpublico==null? BigDecimal.ZERO: importeposicionpublico;
		this.importeposicionfinanciero = importeposicionfinanciero==null? BigDecimal.ZERO: importeposicionfinanciero ;
		this.importepublico = importepublico==null? BigDecimal.ZERO: importepublico;
		this.importefinanciero = importefinanciero==null? BigDecimal.ZERO: importefinanciero;
		this.importesaldo = importesaldo==null? BigDecimal.ZERO: importesaldo;
	}

	public ImportesReporteCuadreDiarioC2() {
		super();
	}
	
}
