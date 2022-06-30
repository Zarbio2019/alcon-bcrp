package pe.grupobbva.alcon.mantenimiento.endpoint.util;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.fasterxml.jackson.databind.ObjectMapper;

import pe.grupobbva.alcon.mantenimiento.dto.util.TablaDinamica;

public class ReportExcelView<T>  extends AbstractXlsView{
	
	private static final Logger log = LogManager.getLogger();
	
	private TablaDinamica<T> consulta;
	private String nombreReporte;
	private String titulo;
	private Date fecha;
	private Integer reporte;
	
	public ReportExcelView(TablaDinamica<T> consulta, String nombreReporte ) {
		this.consulta = consulta;
		this.nombreReporte = nombreReporte;
	}
	
	public ReportExcelView(TablaDinamica<T> consulta, String nombreReporte, String titulo, Date fecha, Integer reporte) {
		this.consulta = consulta;
		this.nombreReporte = nombreReporte;
		this.titulo = titulo;
		this.fecha = fecha;
		this.reporte = reporte;
	}
	

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		if(response != null){
			response.setHeader("Content-Disposition", "attachment; filename=" + nombreReporte + ".xls");
		}
		Sheet sheet = workbook.createSheet("Reporte");
		
		//autoSizeColumns(workbook);
		
		int indexColumna = 0;
		int indexFila = 0;
		
		// Begin styleb lock
		
		CellStyle headerSTyle = headerStyle(workbook);
		CellStyle number2dec = cellStyle2(workbook);
		
		if(reporte != null && reporte == 9) {
			indexFila = designCuadreDiario(sheet,workbook,indexFila);
		}
		
		
		// Begin styleb lock
		Row cabecera = sheet.createRow((short) indexFila++);
		
		//Generamos la Cabecera<
		if(consulta.getColumnas() != null) {
			for(int i = 0;i<consulta.getColumnas().size();i++){
				Cell cell = cabecera.createCell(indexColumna++);
				cell.setCellStyle(headerSTyle);
				cell.setCellValue(consulta.getColumnas().get(i).toString());
			}
		}

		
		//Generar detalles
		for(int i = 0;i<consulta.getRegistros().size();i++){
			//autoSizeColumns(workbook);
			ObjectMapper oMapper = new ObjectMapper(); 
			oMapper.setDateFormat(new SimpleDateFormat("dd/MM/yyyy"));
			
			Map<T, Object> registrosMap = oMapper.convertValue(consulta.getRegistros().get(i), Map.class);
			
			Row detalle = sheet.createRow((short) indexFila++);
			indexColumna = 0;
			

			if(consulta.getOrden()==null) {
				for (Map.Entry<T, Object> entry : registrosMap.entrySet()) {
					
					Cell cell = detalle.createCell(indexColumna);
					
					if(entry.getValue() == null || entry.getValue().toString().trim().equals("")) {
						cell.setCellValue("");
					} else if(entry.getValue() instanceof BigDecimal) {
						
						cell.setCellStyle(number2dec);
						
						cell.setCellValue(((BigDecimal)entry.getValue()).doubleValue());
					} else {
						if(entry.getValue().toString().length() > 2) {
							if(entry.getValue().toString().substring(0,2).equals("+E")) {
								BigDecimal number = new BigDecimal(entry.getValue().toString().substring(2));
							
								cell.setCellStyle(number2dec);
								cell.setCellValue(((BigDecimal)number).doubleValue());
							} else {
								cell.setCellValue(entry.getValue().toString());
							}
						} else {
							cell.setCellValue(entry.getValue().toString());
						}
						
					}
					
					indexColumna++;
				}
			} else {
				for(String field : consulta.getOrden()) {
					Cell cell = detalle.createCell(indexColumna);
					if( !registrosMap.containsKey(field) ) {
						cell.setCellValue("");
					} else if(registrosMap.get(field) instanceof BigDecimal) {
						cell.setCellStyle(number2dec);
						cell.setCellValue(((BigDecimal)registrosMap.get(field)).doubleValue());
						
					} else {
						cell.setCellValue(registrosMap.get(field) ==null ? "":registrosMap.get(field).toString());
					}
					indexColumna++;
				}
			}
			
			
		}
		// Verificar
		if(consulta.getColumnas()!=null) {
			for(int i = 0;i<consulta.getColumnas().size();i++){
				sheet.autoSizeColumn(i);
			}
		}
		
	}
	

	private int  designCuadreDiario(Sheet sheet, Workbook workbook, int indexFila) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(cellStyle.getAlignment().CENTER);
		sheet.addMergedRegion(new CellRangeAddress(0,0,0,6));
		sheet.addMergedRegion(new CellRangeAddress(1,1,0,6));
		sheet.setColumnWidth(0, 6000);
		sheet.setColumnWidth(1, 4000);
		sheet.setColumnWidth(2, 4000);
		sheet.setColumnWidth(3, 4000);
		sheet.setColumnWidth(4, 4000);
		sheet.setColumnWidth(5, 6000);
		sheet.setColumnWidth(6, 6000);
		
		Row title = sheet.createRow((short) indexFila++);
		title.createCell(0).setCellValue(titulo);
        title.getCell(0).setCellStyle(cellStyle);
        
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy"); 
		Row date = sheet.createRow((short) indexFila++);
		date.createCell(0).setCellValue("FECHA:"+ formatDate.format(fecha));
		date.getCell(0).setCellStyle(cellStyle);
		
		return indexFila;
	}
	

	private CellStyle headerStyle(Workbook workbook) {
		CellStyle headerStyle =workbook.createCellStyle();
		headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
		headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);  

		Font headerFont = workbook.createFont();
		headerFont.setColor(IndexedColors.WHITE.getIndex());
		headerStyle.setFont(headerFont);
        
		return headerStyle;
	}

	private CellStyle cellStyle2 (Workbook workbook) {
		String pattern = "###,##0.00";
		CellStyle cellStyle =workbook.createCellStyle();
		cellStyle.setDataFormat(workbook.createDataFormat().getFormat(pattern));
		return cellStyle;
	}
	/*
	private void autoSizeColumns(Workbook workbook) {
	    int numberOfSheets = workbook.getNumberOfSheets();
	    for (int i = 0; i < numberOfSheets; i++) {
	        Sheet sheet = workbook.getSheetAt(i);
	        if (sheet.getPhysicalNumberOfRows() > 0) {
	            Row row = sheet.getRow(sheet.getFirstRowNum());
	            Iterator<Cell> cellIterator = row.cellIterator();
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                int columnIndex = cell.getColumnIndex();
	                sheet.autoSizeColumn(columnIndex);
	            }
	        }
	    }
	}*/

}
