package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.ConstantCode;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.Circular;
import pe.grupobbva.alcon.mantenimiento.util.ReportUtils;

@Data
public class ReporteCuatroTxtDTO {
	private String codigo;
	private String importe;
	public ReporteCuatroTxtDTO(String codigo, String importe) {
		super();
		this.codigo = codigo;
		this.importe = importe;
	}
	
	public ReporteCuatroTxtDTO(ReporteCuatroExcelDTO dto , Circular circular) {
		super();
		ReportUtils Utils = new ReportUtils();
		
		this.codigo = dto.getCodigo();
		if(circular.equals(Circular.C1)) {
			this.importe = Utils.completeZeros(dto.getImporteactual(), 2,12, true); 
		}else {
			this.importe = Utils.completeZeros(dto.getImporteactual(), 2,14, true);
		}
		
		
	}
	
	public List<String> headTxt(Date fecha,String tipoproceso){
		ConstantCode constantCode = new ConstantCode();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyMMdd");
		
		List<String> columns = new ArrayList<String>();
		columns.add(constantCode.getCodInstitucion());
		 columns.add(tipoproceso);
		 columns.add(constantCode.getNumReporteCuatro());
		 columns.add(formatter.format(fecha));
		 columns.add(constantCode.getUnidad());
		
		return columns;
	}
	
	public ReporteCuatroTxtDTO() {
		super();
	}
	
}
