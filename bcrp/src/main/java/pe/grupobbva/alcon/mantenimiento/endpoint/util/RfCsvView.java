package pe.grupobbva.alcon.mantenimiento.endpoint.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import pe.grupobbva.alcon.mantenimiento.dto.RFEspanaDTO;

public class RfCsvView extends AbstractView{
	
	private MultipartFile rfespana;
	private MultipartFile rf;
	
	private List<RFEspanaDTO> listrfespana = new ArrayList<RFEspanaDTO>();
	
	private static final Logger log = LogManager.getLogger();
	
	public RfCsvView() {
		super();
	}
	public RfCsvView(MultipartFile rfespana, MultipartFile rf) {
		super();
		this.rfespana = rfespana;
		this.rf = rf;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		response.setContentType("text/csv");
		response.setHeader("Content-Disposition", "attachment; filename=" + "rep_Posicion_RF" + ".csv");
		
		PrintWriter out = response.getWriter();
		
		getDataRFEspana(rfespana);
		setDataRF(rf, out);
	}
	
	private void getDataRFEspana(MultipartFile rfespana) throws FileNotFoundException, IOException {
		InputStream inp = rfespana.getInputStream();
	    Workbook wb = null;
	    Sheet sheet = null;
	    
	    try {
	    	   wb = WorkbookFactory.create(inp);
	    	   sheet = wb.getSheetAt(0);
	   			int iRow=1;
	   	       Row row = sheet.getRow(iRow); 
	   	       while(row!=null) 
	   	       {
	   	    	   try {
	   	    		Cell caltamira = row.getCell(0);
		   	           Cell ccartera = row.getCell(1);
		   	           Cell cisin = row.getCell(2);
		   	           Cell cnominal = row.getCell(14);
		   	           Cell cinteres = row.getCell(20);
		   	           Cell cprima = row.getCell(23);
		   	           Cell cfluctuacion = row.getCell(26);   	           
		   	    
		   	           RFEspanaDTO dto = new RFEspanaDTO();	   	           
			   	     
			   	           dto.setCentroaltamira(caltamira.getStringCellValue());
			   	           dto.setCartera(ccartera.getStringCellValue());
			   	           dto.setIsin(cisin.getStringCellValue());
			   	           dto.setNominal(String.format("%.2f", cnominal.getNumericCellValue()));
			   	           dto.setInteres(String.format("%.2f", cinteres.getNumericCellValue()));
			   	           dto.setPrima(String.format("%.2f", cprima.getNumericCellValue()));
			   	           dto.setFluctuacion(String.format("%.2f", cfluctuacion.getNumericCellValue()));
			   	           
			   	           
			   	           //String value = caltamira.getStringCellValue();
			   	           
			   	           listrfespana.add(dto);
			   	           
			   	           
			   	           iRow++;  
			   	           row = sheet.getRow(iRow);
	   	    	   } catch(NullPointerException e) {
	   	    		   row = null;
	   	    		   System.out.println("ERROR :::: "+ e);
	   	    	   }
	   	           
	   	     
	   	       }
	       } catch (Exception e) {
				log.error("failed!", e);
			} finally {
				try {
					if (wb != null) {
						wb.close();
					}
				} catch (IOException e) {
					log.error("failed!", e);
				}
			}
	}

	/* private void setDataRF(MultipartFile rf, PrintWriter out) throws IOException {
		File file = convertMultiPartToFile(rf);
		try (Scanner scanRF = new Scanner(file)){
			scanRF.useDelimiter(";");
			
			if(scanRF.hasNextLine()) {
				out.print(scanRF.nextLine());
				out.print("\r\n");
			}
			
			while(scanRF.hasNextLine()) {
				String rfLine = scanRF.nextLine();
				readRFLine(rfLine, out);
			}
		}
	} */
	private void setDataRF(MultipartFile rf, PrintWriter out) throws IOException {
		CSVReader reader = null;
		InputStream is =  new BufferedInputStream(rf.getInputStream());
		
		try {
			reader = new CSVReaderBuilder(new InputStreamReader(is)).build();
			String[] nextLine;
			
			if((nextLine = reader.readNext()) != null) {
				out.print(nextLine[0]);
				out.print("\r\n");
			}

			while ((nextLine = reader.readNext()) != null) {
				
				readRFLine(nextLine[0], out);				
				
			} 
		} catch (Exception e) {
			log.error("failed!", e);
			
		}
	}
	
	private void readRFLine(String line, PrintWriter out) {
		try (Scanner scanRFLine = new Scanner(line)){
			scanRFLine.useDelimiter(";");
			
			int countDat = 0;
			String data = "";
			String centroaltamira ="";
			String cartera = "";
			String isin ="";
			
			while(scanRFLine.hasNext()) {
				switch(countDat) {
				case 0:
					centroaltamira = completeZeroAltamira(scanRFLine.next(),4);
					data = data + centroaltamira+";";
					countDat++;
					break;
				case 1:
					cartera = scanRFLine.next().trim();
					data = data + cartera+";";
					countDat++;
					break;
				case 2: 
					isin = scanRFLine.next().trim();
					data = data + isin + ";";
					countDat++;
					break;
				case 14:
					int setternominal = 0;
					for(RFEspanaDTO dto: listrfespana) {
						if ((centroaltamira.equals(dto.getCentroaltamira())) &&
								(cartera.equals(dto.getCartera())) &&
								(isin.equals(dto.getIsin()))) {
							data = data + dto.getNominal() + ";";
							scanRFLine.next();
							setternominal++;
							countDat++;
						} 
					}
					if (setternominal == 0){
						data = data + scanRFLine.next()+";";
						countDat++;
					}
					break;
				case 19:
					int setterprima = 0;
					for(RFEspanaDTO dto: listrfespana) {
						if ((centroaltamira.equals(dto.getCentroaltamira())) &&
								(cartera.equals(dto.getCartera())) &&
								(isin.equals(dto.getIsin()))) {
							data = data + dto.getPrima() + ";";
							countDat++;
							setterprima++;
							scanRFLine.next();
						} 
					}
					if(setterprima == 0) {
						data = data + scanRFLine.next()+";";
						countDat++;
					}
					break;
				case 20:
					int setterinteres = 0;
					for(RFEspanaDTO dto: listrfespana) {
						if ((centroaltamira.equals(dto.getCentroaltamira())) &&
								(cartera.equals(dto.getCartera())) &&
								(isin.equals(dto.getIsin()))) {
							data = data + dto.getInteres() + ";";
							countDat++;
							setterinteres++;
							scanRFLine.next();
						} 
					}
					if(setterinteres==0){
						data = data + scanRFLine.next()+";";
						countDat++;
					}
					break;
				case 23:
					int setterfluctua = 0;
					for(RFEspanaDTO dto: listrfespana) {
						if ((centroaltamira.equals(dto.getCentroaltamira())) &&
								(cartera.equals(dto.getCartera())) &&
								(isin.equals(dto.getIsin()))) {
							data = data + dto.getFluctuacion() + ";";
							countDat++;
							setterfluctua++;
							scanRFLine.next();
						} 
					}
					if(setterfluctua==0) {
						data = data + scanRFLine.next()+";";
						countDat++;
					}
					break;
				case 31:
					data = data+scanRFLine.next();
					countDat++;
					break;
				default:
						data = data+scanRFLine.next()+";";
						countDat++;
						break;
				}
			}
			out.print(data +"\r\n");
		}
	}
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		try(
		FileOutputStream fos = new FileOutputStream(convFile)){
			fos.write(file.getBytes());
		}
		return convFile;
	}
	private String completeZeroAltamira(String data,Integer length) {
		data = data.substring(0, Math.min(4, data.length())).trim();
		StringBuilder dataResponse = new StringBuilder();
		for(int i=1; i<= length-data.length(); i++) {
			dataResponse.append("0");
		}
		dataResponse.append(data);
		return dataResponse.toString();
	}
}
