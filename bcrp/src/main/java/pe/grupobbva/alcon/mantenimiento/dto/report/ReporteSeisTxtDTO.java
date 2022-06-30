package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.ConstantCode;
import pe.grupobbva.alcon.mantenimiento.util.ReportUtils;

@Data
public class ReporteSeisTxtDTO {
	private String codigoreporte;
	private String importeusd;
	private String deltad;
	private String cobertura;
	
	public ReporteSeisTxtDTO() {
		super();
	}
	
	public ReporteSeisTxtDTO(ReporteSeisDTO dto) {
		ReportUtils Utils = new ReportUtils();
		this.codigoreporte = Utils.completeSpace(dto.getCodigoreporte(), 16);
		this.importeusd = Utils.completeZeros(dto.getImporteusd(), 2, 12);
		this.deltad = Utils.completeZeros(dto.getDeltad(), 4, 5);
		this.cobertura = Utils.completeZeros(dto.getCobertura(), 2, 12);
	}

	public List<String> headTxt(Date fecha,String tipoproceso){
		ConstantCode constantCode = new ConstantCode();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyMMdd");
		
		List<String> columns = new ArrayList<String>();
		columns.add(constantCode.getCodInstitucion());
		columns.add(tipoproceso);
		columns.add(constantCode.getNumReporteSeis());
		columns.add(formatter.format(fecha));
		columns.add(constantCode.getUnidad());
		
		return columns;
	}


	public ReporteSeisTxtDTO(String codigoreporte, String importeusd, String deltad, String cobertura) {
		super();
		this.codigoreporte = codigoreporte;
		this.importeusd = importeusd;
		this.deltad = deltad;
		this.cobertura = cobertura;
	}
	
}
