package pe.grupobbva.alcon.mantenimiento.dto.report;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.ConstantCode;
import pe.grupobbva.alcon.mantenimiento.util.ReportUtils;

@Data
public class ReporteOchoTxtC2DTO {

	private String codigooperacion;
	private String monto;
	
	
	public ReporteOchoTxtC2DTO() {
		super();
	}
	
	public ReporteOchoTxtC2DTO(ReporteOchoC2DTO dto) {
		super();
		ReportUtils utils = new ReportUtils();
		
		this.codigooperacion = dto.getCodigooperacion();
		this.monto = utils.completeZeros(dto.getMonto(), 2, 14);
		
	}
	
	public List<String> headTxt(Date fecha) {
		ConstantCode constantCode = new ConstantCode();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyMMdd");

		List<String> columns = new ArrayList<String>();
		columns.add(constantCode.getCodInstitucion());
		columns.add(constantCode.getNumReporteOcho());
		columns.add(formatter.format(fecha));
		columns.add(constantCode.getUnidad());

		return columns;
	}
	
}
