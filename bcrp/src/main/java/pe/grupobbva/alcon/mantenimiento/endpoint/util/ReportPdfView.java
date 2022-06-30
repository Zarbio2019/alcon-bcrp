package pe.grupobbva.alcon.mantenimiento.endpoint.util;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public class ReportPdfView<T> extends AbstractPdfView {
	private TablaDinamica<T> consulta;
	private String nombreReporte;
	private String tituloReporte;
	
	public ReportPdfView(TablaDinamica<T> consulta, String nombreReporte, String tituloReporte) {
		super();
		this.consulta = consulta;
		this.nombreReporte = nombreReporte;
		this.tituloReporte=tituloReporte;
	}


	@Override
	protected Document newDocument() {
		return new Document(PageSize.A4);
	}
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ReportPdfEvents objEventos = new ReportPdfEvents();
		writer.setPageEvent(objEventos);
		
		// cambiar nombre de archivo
				response.setHeader("Content-Disposition", "attachment; filename="+ nombreReporte +".pdf");
				int cantidadColumnas = consulta.getColumnas().size();
				//solo reporte 4
				float[] medidaCeldas = {0.55f, 0.55f, 2.55f, 1f,0.55f};
				
				Table table = new Table(cantidadColumnas);
				table.setPadding(5);
				table.setWidth(100);
				table.setWidths(medidaCeldas);
				
				Cell cell = new Cell(tituloReporte);
				cell.setHeader(true);
				cell.setColspan(cantidadColumnas);
				cell.setBorderWidthTop(0);
				cell.setBorderWidthLeft(0);
				cell.setBorderWidthRight(0);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
				
		        //Generamos la Cabecera
		        
		        for(int i = 0;i<consulta.getColumnas().size();i++){
		        	
		        	 Paragraph detail = new Paragraph();
		        	 detail.setAlignment(Paragraph.ALIGN_CENTER);
		        	 detail.setFont(FontFactory.getFont("Times New Roman", 7, Font.BOLD));
		        	 detail.add(consulta.getColumnas().get(i).toString());
		        	
		        	 Cell cabecera = new Cell(detail);
		        	 cabecera.setHeader(true);
		        	 cabecera.setHorizontalAlignment(Element.ALIGN_CENTER);
		     
					table.addCell(cabecera);
				}
				
		        table.endHeaders();
		        
		      //Generar detalles
				for(int i = 0;i<consulta.getRegistros().size();i++){
					ObjectMapper oMapper = new ObjectMapper(); 
					Map<T, Object> registrosMap = oMapper.convertValue(consulta.getRegistros().get(i), Map.class);
					
					for (Map.Entry<T, Object> entry : registrosMap.entrySet()) {
						
						Paragraph detail = new Paragraph();
			        	detail.setFont(FontFactory.getFont("Times New Roman", 7, Font.BOLD));
			        	detail.add(entry.getValue().toString());
						
						Cell valores = new Cell(detail);
						if(entry.getValue() instanceof BigDecimal) {
							valores.setHorizontalAlignment(Element.ALIGN_RIGHT);
						}
						
						valores.setVerticalAlignment(Element.ALIGN_CENTER);
						
						table.addCell(valores);
					}
					
				}
		        
		        
		        document.add(table);
	}
	
}
