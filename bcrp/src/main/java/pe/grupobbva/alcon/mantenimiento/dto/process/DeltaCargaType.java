package pe.grupobbva.alcon.mantenimiento.dto.process;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;

public @Data class DeltaCargaType extends AbstractType {

	/**
	 * @param idFilaArchivo
	 * @param tipoProceso
	 */
	public DeltaCargaType(Carga carga, Long rownum, Row row) {
		super();

		this.row = row;
		this.rownum=rownum;
		if(row.getCell(2)!=null) {
			if(row.getCell(2).getCellType().equals(CellType.NUMERIC)) {
				this.numerooperacion = format(row.getCell(2).getNumericCellValue());
			}else {
				this.numerooperacion = row.getCell(2).getStringCellValue();
			}
		}
		if(row.getCell(8)!=null) {
			
			if(row.getCell(8).getCellType().equals(CellType.NUMERIC)) {
				this.deltas = BigDecimal.valueOf(row.getCell(8).getNumericCellValue());
			}else {
				try {
					this.deltas = new BigDecimal (row.getCell(8).getStringCellValue());	
				} catch (Exception e) {
					
				}
				
			}
		}
	
		//this.deltas = BigDecimal.valueOf(row.getCell(8).getNumericCellValue()).divide(BigDecimal.valueOf(100)).setScale(4, BigDecimal.ROUND_HALF_EVEN).abs();
		if(row.getCell(5)!=null) {
			
			if(row.getCell(5).getCellType().equals(CellType.NUMERIC)) {
				this.descripcion = String.valueOf(row.getCell(5).getNumericCellValue());
			}else {
				this.descripcion = row.getCell(5).getStringCellValue();
			}
			
			
		}
		
		if(row.getCell(6)!=null) {
			
			if(row.getCell(6).getCellType().equals(CellType.NUMERIC)) {
				this.importe = BigDecimal.valueOf(row.getCell(6).getNumericCellValue());
			}else {
				try {
					this.importe = new BigDecimal (row.getCell(6).getStringCellValue());	
				} catch (Exception e) {
					
				}
				
			}
		}
		//this.importe = BigDecimal.valueOf(row.getCell(8).getNumericCellValue()).setScale(2, BigDecimal.ROUND_HALF_EVEN);

	}

	@Override
	public Boolean validar() {
		if(rownum<4) {
			return false;
		}
		return numerooperacion!=null && !numerooperacion.isEmpty() && deltas!=null ;
	}

	private Row row;
	
	
	
	private String numerooperacion;
	private BigDecimal deltas;
	private String descripcion;
	private BigDecimal importe;
	
	
	 public String format(Number n) {
	        NumberFormat format = DecimalFormat.getInstance();
	        format.setRoundingMode(RoundingMode.FLOOR);
	        format.setMinimumFractionDigits(0);
	        format.setMaximumFractionDigits(0);
	        format.setGroupingUsed(false);
	        return format.format(n);
	}

}
