package pe.grupobbva.alcon.mantenimiento.endpoint.util;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.servlet.view.AbstractView;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public class ReportTxtView<T>  extends AbstractView {
	private TablaDinamica<T> consulta;
	private String nombreReporte;

	public ReportTxtView(TablaDinamica<T> consulta, String nombreReporte ) {
		this.consulta = consulta;
		this.nombreReporte = nombreReporte;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition", "attachment; filename=" + nombreReporte + ".txt");
		PrintWriter out = response.getWriter();
		
		for(int i = 0;i<consulta.getColumnas().size();i++){
			out.print(consulta.getColumnas().get(i).toString());
		}
	
		for(int i = 0;i<consulta.getRegistros().size();i++){
			
			ObjectMapper oMapper = new ObjectMapper(); 
			Map<T, Object> registrosMap = oMapper.convertValue(consulta.getRegistros().get(i), Map.class);
			out.print("\r\n");
			for (Map.Entry<T, Object> entry : registrosMap.entrySet()) {
				if(entry.getValue()==null) {
					out.print(" ");
				}else {
					out.print(entry.getValue().toString());
				}
			}
			
			
		}
		
	}
	
}
