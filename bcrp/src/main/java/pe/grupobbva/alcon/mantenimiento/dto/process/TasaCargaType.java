package pe.grupobbva.alcon.mantenimiento.dto.process;

import java.math.BigDecimal;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.Row;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;

public @Data class TasaCargaType extends AbstractType {
	
	public TasaCargaType(Carga carga, Long rownum, Row row) {
		super();

		this.row = row;

		this.fechaproceso = carga.getFecha();
		this.curva = row.getCell(0).getStringCellValue();
		this.codigoDivisa = row.getCell(1).getStringCellValue();
		this.fechavencimiento = row.getCell(2).getStringCellValue();
		
		if (row.getCell(3) != null) {
			this.par = row.getCell(3).getStringCellValue();
		}
		
		this.coordenaday = BigDecimal.valueOf(row.getCell(4).getNumericCellValue()).setScale(6,	BigDecimal.ROUND_HALF_EVEN);
		
		if (row.getCell(5) != null) {
			this.fechainicio = row.getCell(5).getStringCellValue();
		}
		

	}

	@Override
	public Boolean validar() {
		return !row.getCell(0).getStringCellValue().isEmpty() && !row.getCell(1).getStringCellValue().isEmpty()
				&& !row.getCell(2).getStringCellValue().isEmpty()
				&& !String.valueOf(row.getCell(4).getNumericCellValue()).isEmpty();
	}

	private Row row;

	private Calendar fechaproceso;
	private String curva;
	private String codigoDivisa;
	private String fechavencimiento;
	private String par;
	private BigDecimal coordenaday;
	private String fechainicio;

}
