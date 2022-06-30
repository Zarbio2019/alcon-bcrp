package pe.grupobbva.alcon.mantenimiento.endpoint.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import pe.grupobbva.alcon.mantenimiento.dto.CfgFxVigenteDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRFDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgPosRVDTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD02DTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgRCD07DTO;
import pe.grupobbva.alcon.mantenimiento.dto.CfgSpeFrairDTO;
import pe.grupobbva.alcon.mantenimiento.dto.RcdObject02DTO;
import pe.grupobbva.alcon.mantenimiento.dto.RcdObject07DTO;
import pe.grupobbva.alcon.mantenimiento.dto.RcdObjectFxVigenteDTO;
import pe.grupobbva.alcon.mantenimiento.dto.RcdObjectRfDTO;
import pe.grupobbva.alcon.mantenimiento.dto.RcdObjectRvDTO;
import pe.grupobbva.alcon.mantenimiento.dto.RcdObjectSpeFrairDTO;



public class RcdTxtView extends AbstractView {
	
	private MultipartFile fxvigente;
	private MultipartFile spefrair;
	private MultipartFile rv;
	private MultipartFile rf;
	private MultipartFile optasas;
	private MultipartFile opfx;
	
	private List<CfgFxVigenteDTO> dto;
	private List<CfgSpeFrairDTO> dtospefrair;
	private List<CfgPosRVDTO> rvdto;
	private List<CfgPosRFDTO> rfdto;
	private List<CfgRCD07DTO> optasasdto;
	private List<CfgRCD02DTO> opfxdto;
	
	private static final Logger log = LogManager.getLogger();
	
	public RcdTxtView() {
		super();
	}
	
	public RcdTxtView(MultipartFile fxvigente, List<CfgFxVigenteDTO> dto, 
			MultipartFile spefrair,List<CfgSpeFrairDTO> dto1, MultipartFile rv, List<CfgPosRVDTO> dto2,
			MultipartFile rf, List<CfgPosRFDTO> dto3,
			MultipartFile optasas, List<CfgRCD07DTO> dto4,
			MultipartFile opfx, List<CfgRCD02DTO> dto5) {
		this.fxvigente = fxvigente;
		this.spefrair = spefrair;
		this.rv = rv;
		this.rf = rf;
		this.optasas = optasas;
		this.opfx = opfx;
		
		this.dtospefrair = dto1;
		this.dto = dto;
		this.rvdto = dto2;
		this.rfdto = dto3;
		this.optasasdto = dto4;
		this.opfxdto = dto5;
	}

	@Override
	protected void renderMergedOutputModel(
			Map<String, Object> model, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		response.setContentType("text/plain");
		response.setHeader("Content-Disposition", "attachment; filename=" + "RCDMIDAS" + ".txt");
		PrintWriter out = response.getWriter();
		
		File file = convertMultiPartToFile(fxvigente);
		File file1 = convertMultiPartToFile(spefrair);
		File file2 = convertMultiPartToFile(rv);
		File file3 = convertMultiPartToFile(rf);
		File file4 = convertMultiPartToFile(optasas);
		File file5 = convertMultiPartToFile(opfx);
		
		setFxVigente(fxvigente, out);
		setSpeFrair(spefrair,out);
		setRV(rv, out);
		setRF(rf, out);
		setOpTasas(optasas, out);
		setOpFx(opfx, out);
		
	}
	
	
	private File convertMultiPartToFile(MultipartFile file) throws IOException {
		File convFile = new File(file.getOriginalFilename());
		try(
		FileOutputStream fos = new FileOutputStream(convFile)){
			fos.write(file.getBytes());
		}
		return convFile;
	}
	private String completeZeroOficina(String data,Integer length) {
		data = data.trim().substring(0, Math.min(4, data.length()));
		StringBuilder dataResponse = new StringBuilder();
		for(int i=1; i<= length-data.length(); i++) {
			dataResponse.append("0");
		}
		dataResponse.append(data);
		return dataResponse.toString();
	}
	private String completeZeroCodigoCentral(String data,Integer length) {
		data = data.trim().substring(0, Math.min(8, data.length()));
		StringBuilder dataResponse = new StringBuilder();
		for(int i=1; i<= length-data.length(); i++) {
			dataResponse.append("0");
		}
		dataResponse.append(data);
		return dataResponse.toString();
	}
	private String completeZeroImp(String data,Integer decimals,Integer length) {
		data = data.replace("-", "");
		data = data.substring(0, Math.min(18, data.length())).trim();
		StringBuilder dataResponse = new StringBuilder();
		BigDecimal number = new BigDecimal(data);
		String stringNumber = number.abs().setScale(decimals ,BigDecimal.ROUND_HALF_UP).toString().replace(".", "");
		for(int i=1; i<= length-stringNumber.length(); i++) {
			dataResponse.append("0");
		}
		dataResponse.append(stringNumber);
		return dataResponse.toString();	
	}
		
	private String completeZeroImp1(String data,Integer length) {
		data = data.substring(0, Math.min(18, data.length())).trim();
		StringBuilder dataResponse = new StringBuilder();
		for(int i=1; i<= length-data.length(); i++) {
			dataResponse.append("0");
		}
		dataResponse.append(data);
		return dataResponse.toString();
	}
	private String completeSpaceDescription(String subproducto,String deal, Integer length) {
		String data = subproducto.trim()+"-"+deal.trim();
		StringBuilder dataResponse = new StringBuilder();
		dataResponse.append(data);
		for(int i=1; i<= length-data.length(); i++) {
			dataResponse.append(" ");
		}
		
		return dataResponse.toString();
	}
	private String completeSpaceContrato(String codigo, Integer length) {
		String data = codigo.trim();
		StringBuilder dataResponse = new StringBuilder();
		dataResponse.append(data);
		for(int i=1; i<= length-data.length(); i++) {
			dataResponse.append(" ");
		}
		return dataResponse.toString();
	}
	private String completeSpaceCuentas(String cuenta, Integer length) {
		String data = cuenta.trim();
		StringBuilder dataResponse = new StringBuilder();
		dataResponse.append(data);
		for(int i=1; i<= length-data.length(); i++) {
			dataResponse.append(" ");
		}
		
		return dataResponse.toString();
	}
	private String completeSpaceContrapartida(String nombre, Integer length) {
		String data = nombre.trim();
		StringBuilder dataResponse = new StringBuilder();
		dataResponse.append(data);
		for(int i=1; i<= length-data.length(); i++) {
			dataResponse.append(" ");
		}
		
		return dataResponse.toString();
	}
	public String dateFormat(String date) throws ParseException { //calendar
		date = date.trim();
		Calendar cal = Calendar.getInstance();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		cal.setTime(sdf.parse(date));
		
		Date date1 = cal.getTime(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyMMdd");
		return formatter.format(date1);
	}
	public String numberFormat(String number) {
		
		if(!StringUtils.isBlank(number)) {
			number= "+E"+ number;
		}
		
		return number;
	}
	public String getSigno(String importe) {
		Double num = Double.parseDouble(importe);
		
		if (num >= 0) {
			return "+";
		} else {
			return "-";
		}
		
	}
	private String reemplazaVac(String divisa) {
		 divisa = divisa.trim();
		if(divisa.equals("VAC")){
			 return "PEN";
		}else {
			return divisa;
		}
	}
	
	private void setFxVigente(MultipartFile fx, PrintWriter out) throws Exception {
		
		CSVReader reader = null;
		InputStream is =  new BufferedInputStream(fx.getInputStream());
		
		try {
			reader = new CSVReaderBuilder(new InputStreamReader(is)).withSkipLines(1).build();
			String[] nextLine;
			
			

			while ((nextLine = reader.readNext()) != null) {
				
				setFxVigenteLine(nextLine[0], out);				
				
			} 
		} catch (Exception e) {
			log.error("failed!", e);
			
		}
	}
	private void setFxVigenteLine(String sfxvigenteLine, PrintWriter out) throws ParseException {
		try( Scanner scanfxVigLine = new Scanner(sfxvigenteLine))
        {
            
            scanfxVigLine.useDelimiter(";");
            
            int fxVigInt = 0;
            RcdObjectFxVigenteDTO rcdObj = new RcdObjectFxVigenteDTO();
            
            setDataToFxVigenteObject(rcdObj, out, fxVigInt, scanfxVigLine);
      
        }
	}
	private void setDataToFxVigenteObject(RcdObjectFxVigenteDTO rcdObj, PrintWriter out, int fxVigInt, Scanner scanfxVigLine) throws ParseException  {
		
		while (scanfxVigLine.hasNext()) { //Se lee cada entrada
        	String data = "";
        	switch(fxVigInt) {
        	case 0:
        		
        		data = scanfxVigLine.next();
        		rcdObj.setSubproducto(data.trim());
        		fxVigInt++;
        		break;
        	case 1:
        		
        		rcdObj.setDeal(scanfxVigLine.next());
        		fxVigInt++;
        		break;
        	case 4:
        		
        		rcdObj.setFechaVencimiento(scanfxVigLine.next());
        		fxVigInt++;
        		break;
        	case 5:
        		
        		rcdObj.setFechaFixing(scanfxVigLine.next());
        		fxVigInt++;
        		break;
        	case 6:
        		
        		rcdObj.setCodigoCentral(scanfxVigLine.next());
        		fxVigInt++;
        		break;
        	case 7:
        		
        		data = scanfxVigLine.next();
        		data = data.replace("Ã‘", "Ñ");
        		
        		rcdObj.setContrapartida(data);
        		fxVigInt++;
        		break;
        	case 8:
        		
        		data = scanfxVigLine.next();
        		rcdObj.setOperacion(data);
        		fxVigInt++;
        		break;
        	case 9:
        		
        		rcdObj.setDivisaCompra(scanfxVigLine.next());
        		fxVigInt++;
        		break;
        	case 10:
        		
        		rcdObj.setDivisaCompraImp(scanfxVigLine.next());		             		           		
        		fxVigInt++;
        		break;
        	case 12:
        		
        		rcdObj.setDivisaVenta(scanfxVigLine.next());        		           		
        		fxVigInt++;
        		break;
        	case 13:
        		
        		rcdObj.setDivisaVentaImp(scanfxVigLine.next());		            	        		           		
        		fxVigInt++;
        		break;
        	case 15:
        		
        		data = scanfxVigLine.next();
        		rcdObj.setOficina(completeZeroOficina(data,4));
        		fxVigInt++;
        		break;
        	case 19:
        		
        		data = scanfxVigLine.next();
        		rcdObj.setCuenta(completeSpaceCuentas(data,15));
        		fxVigInt++;
        		break;
        	default:        		
        		if(scanfxVigLine.hasNext()) {
        			data = scanfxVigLine.next();
        			
        		}
        		fxVigInt++;
        	}
        	
        }
		compareFxVigenteCfgFx(rcdObj, out);
	}
	private void compareFxVigenteCfgFx(RcdObjectFxVigenteDTO rcdObj, PrintWriter out) throws ParseException {
		for(CfgFxVigenteDTO cfg: dto) {
        	if( cfg.getSubproducto().equals(rcdObj.getSubproducto().trim()) && 
        			(cfg.getOperacion().equalsIgnoreCase(rcdObj.getOperacion().trim())) ) {
        		
        		setFxVigenteFecha(rcdObj, cfg, out);
        	}
        }
	}
	private void setFxVigenteFecha(RcdObjectFxVigenteDTO rcdObj, CfgFxVigenteDTO cfg, PrintWriter out) throws ParseException {
		
		if (cfg.getFechaVencimiento().equals("fec_vcto")) {
			setFxVigenteDivisa(rcdObj, cfg, out, rcdObj.getFechaVencimiento());
		}
		else if (cfg.getFechaVencimiento().equals("fec_fixing")) {
			setFxVigenteDivisa(rcdObj, cfg, out, rcdObj.getFechaFixing());
		}
	}
	private void setFxVigenteDivisa(RcdObjectFxVigenteDTO rcdObj, CfgFxVigenteDTO cfg, PrintWriter out, String fecha) throws ParseException {
		if (cfg.getDivisa().equals("div_comp")) {
			setFxVigenteCuenta(rcdObj, cfg, out, fecha, rcdObj.getDivisaCompra(), rcdObj.getDivisaCompraImp());
		}
		else if(cfg.getDivisa().equals("div_venta")) {
			setFxVigenteCuenta(rcdObj, cfg, out, fecha, rcdObj.getDivisaVenta(), rcdObj.getDivisaVentaImp());
		}
	}
	private void setFxVigenteCuenta(RcdObjectFxVigenteDTO rcdObj, CfgFxVigenteDTO cfg, PrintWriter out, String fecha, String divisa, String importe) throws ParseException {
		out.print("0011091"+
				rcdObj.getOficina()+
				"1"+
				completeZeroCodigoCentral(rcdObj.getCodigoCentral(),8)+
        		completeSpaceDescription(rcdObj.getSubproducto(),rcdObj.getDeal(),20)+
        		"0091    "+
        		dateFormat(fecha)+
        		"0000"+
        		completeSpaceCuentas(cfg.getCuenta(),15)+
        		reemplazaVac(divisa)+
        		completeZeroImp(importe,2,18)+
        		"000000000000000000"+
        		"R"+
        		completeSpaceContrapartida(rcdObj.getContrapartida(),60)+
        		"+"
        		
        		);
        out.print("\r\n");
	}

	
	private void setSpeFrair(MultipartFile spefr, PrintWriter out) throws Exception {
		CSVReader reader = null;
		InputStream is =  new BufferedInputStream(spefr.getInputStream());
		
		try {
			reader = new CSVReaderBuilder(new InputStreamReader(is)).withSkipLines(1).build();
			String[] nextLine;
			

			while ((nextLine = reader.readNext()) != null) {
				
				setSpeFrairLine(nextLine[0], out);				
				
			} 
		} catch (Exception e) {
			log.error("failed!", e);
			
		}
	}	
	private void setSpeFrairLine(String sspefrairLine, PrintWriter out) throws ParseException {
		try( Scanner scanspefrLine = new Scanner(sspefrairLine))
        {
            
            scanspefrLine.useDelimiter(";");
            
            int spefrInt = 0;
            RcdObjectSpeFrairDTO rcdObj = new RcdObjectSpeFrairDTO();
            
            setDataToSpeFrairObject(rcdObj, out, spefrInt, scanspefrLine);
      
        }
	}
	private void setDataToSpeFrairObject(RcdObjectSpeFrairDTO rcdObj, PrintWriter out, int spefrInt, Scanner scanspefrLine) throws ParseException{
		while (scanspefrLine.hasNext()) { //Se lee cada entrada
        	String data = "";
        	switch(spefrInt) {
        
        	case 1:        		
        		rcdObj.setTnum(scanspefrLine.next());
        		spefrInt++;
        		break;
        	case 3:        		
        		rcdObj.setCodigocentral(scanspefrLine.next()); // cou par
        		spefrInt++;
        		break;
        	case 4:
        		data = scanspefrLine.next();
        		data = data.replace("Ã‘", "Ñ");
        		rcdObj.setCliente(data); // Lname
        		spefrInt++;
        		break;
        	case 5:        		
        		rcdObj.setSubtype(scanspefrLine.next());
        		spefrInt++;
        		break;
        	case 8:       		
        		rcdObj.setVencimiento(scanspefrLine.next());
        		spefrInt++;
        		break;
        	case 10:        		
        		data = scanspefrLine.next();
        		rcdObj.setDivisapago(data);
        		spefrInt++;
        		break;
        	case 13:
        		rcdObj.setImpamortpy(scanspefrLine.next());		             		           		
        		spefrInt++;
        		break;
        	case 15:        		
        		rcdObj.setDivisarecibo(scanspefrLine.next());
        		spefrInt++;
        		break;
        	case 18:        		
        		rcdObj.setImpamortrc(scanspefrLine.next());		             		           		
        		spefrInt++;
        		break;
        	case 19:        		
        		rcdObj.setOperacion(scanspefrLine.next());		             		           		
        		spefrInt++;
        		break;
        	case 21:        		
        		rcdObj.setImpvalorcontable(scanspefrLine.next());        		           		
        		spefrInt++;
        		break;
        	case 28:
        		rcdObj.setCentroaltamira(scanspefrLine.next());		            	        		           		
        		spefrInt++;
        		break;
        	
        	default:           		
        		if(scanspefrLine.hasNext()) {
        			data = scanspefrLine.next();
        			
        		}
        		spefrInt++;
        	}
        	
        }
		compareSpeFrairCfgSpe(rcdObj, out);
	}
	private void compareSpeFrairCfgSpe(RcdObjectSpeFrairDTO rcdObj, PrintWriter out) throws ParseException {
		for(CfgSpeFrairDTO cfg: dtospefrair) {
			if (cfg.getOperacion().equals(" ")) {
				
				if (cfg.getDivisa().equalsIgnoreCase("recibo")) {
					setSpeFrairImporte(rcdObj, cfg, rcdObj.getDivisarecibo(), out);
				}else if(cfg.getDivisa().equals("pago")) {
					setSpeFrairImporte(rcdObj, cfg, rcdObj.getDivisapago(), out);
				}
				
			}else if( cfg.getSubproducto().trim().equals(rcdObj.getSubtype().trim()) && 
        			(cfg.getOperacion().equalsIgnoreCase(rcdObj.getOperacion().trim())) ) {
				
				if (cfg.getDivisa().equalsIgnoreCase("recibo")) {
					setSpeFrairImporte(rcdObj, cfg, rcdObj.getDivisarecibo(), out);
				}else if(cfg.getDivisa().equalsIgnoreCase("pago")) {
					setSpeFrairImporte(rcdObj, cfg, rcdObj.getDivisapago(), out);
				}
        		
        	}
        }
	}
	private void setSpeFrairImporte(RcdObjectSpeFrairDTO rcdObj,CfgSpeFrairDTO cfg, String divisa, PrintWriter out) throws ParseException{
		if (cfg.getImporte().equalsIgnoreCase("amortrc")) {
			setCuentaSpeFrair(rcdObj, cfg, divisa, rcdObj.getImpamortrc(), out);
		} else if (cfg.getImporte().equalsIgnoreCase("valorcontable")) {
			setCuentaSpeFrair(rcdObj, cfg, divisa, rcdObj.getImpvalorcontable(), out);
		} else if (cfg.getImporte().equalsIgnoreCase("amortpy")) {
			setCuentaSpeFrair(rcdObj, cfg, divisa, rcdObj.getImpamortpy(), out);
		}
	}
	private void setCuentaSpeFrair(RcdObjectSpeFrairDTO rcdObj, CfgSpeFrairDTO cfg, String divisa, String importe, PrintWriter out) throws ParseException{
		if (cfg.getRecibo().equals(" ")) {
			out.print("0011091"+
					completeZeroOficina(rcdObj.getCentroaltamira(),4)+
					"1"+
					completeZeroCodigoCentral(rcdObj.getCodigocentral(),8)+
	        		completeSpaceDescription(rcdObj.getSubtype(),rcdObj.getTnum(),20)+
	        		"0091    "+
	        		dateFormat(rcdObj.getVencimiento())+
	        		"0000"+
	        		completeSpaceCuentas(cfg.getCuenta(),15)+
	        		reemplazaVac(divisa)+
	        		completeZeroImp(importe,2,18)+
	        		"000000000000000000"+
	        		"R"+
	        		completeSpaceContrapartida(rcdObj.getCliente(),60)+
	        		"+"
	        		
	        		);
	        out.print("\r\n");
		} else {
			out.print("0011091"+
					completeZeroOficina(rcdObj.getCentroaltamira(),4)+
					"1"+
					completeZeroCodigoCentral(rcdObj.getCodigocentral(),8)+
	        		completeSpaceDescription(rcdObj.getSubtype(),rcdObj.getTnum(),20)+
	        		"0091    "+
	        		dateFormat(rcdObj.getVencimiento())+
	        		"0000"+
	        		completeSpaceCuentas(cfg.getCuenta(),15)+
	        		cfg.getRecibo()+
	        		completeZeroImp(importe,2,18)+
	        		"000000000000000000"+
	        		"R"+
	        		completeSpaceContrapartida(rcdObj.getCliente(),60)+
	        		"+"	        		
	        		);
	        out.print("\r\n");
		}
	}
	
	
	private void setRV(MultipartFile rv, PrintWriter out)throws Exception {
		CSVReader reader = null;
		InputStream is =  new BufferedInputStream(rv.getInputStream());
		
		try {
			reader = new CSVReaderBuilder(new InputStreamReader(is)).withSkipLines(1).build();
			String[] nextLine;
			
				

			while ((nextLine = reader.readNext()) != null) {
				
				setRvLine(nextLine[0], out);				
				
			} 
		} catch (Exception e) {
			log.error("failed!", e);
			
		}
	}
	private void setRvLine(String srvLine, PrintWriter out) throws ParseException{
		try(Scanner scanRvLine = new Scanner(srvLine)){
			scanRvLine.useDelimiter(";");
			
			int rvInt = 0;
			RcdObjectRvDTO rcdObj = new RcdObjectRvDTO();
			setDataToRvObject(rcdObj, out, rvInt, scanRvLine);
			
		}
	}
	private void setDataToRvObject(RcdObjectRvDTO rcdObj, PrintWriter out, int rvInt, Scanner scanRvLine) throws ParseException{
		
		while (scanRvLine.hasNext()) {
			String data="";
			switch(rvInt) {
			case 0:	    		
	    		data = scanRvLine.next();
	    		rcdObj.setCentroaltamira(data.trim());
	    		rvInt++;
	    		break;
			case 1:	    		
	    		data = scanRvLine.next();
	    		rcdObj.setCartera(data.trim());
	    		rvInt++;
	    		break;
			case 2:	    		
	    		data = scanRvLine.next();
	    		rcdObj.setIsin(data.trim());
	    		rvInt++;
	    		break;
			case 3:	    		
	    		data = scanRvLine.next();
	    		rcdObj.setClase(data.trim());
	    		rvInt++;
	    		break;
			case 6:	    		
	    		data = scanRvLine.next();
	    		rcdObj.setCodigocentral(data.trim());
	    		rvInt++;
	    		break;
			case 7:	    		
	    		data = scanRvLine.next();
	    		rcdObj.setCliente(data.trim());
	    		rvInt++;
	    		break;
			case 13:	    		
	    		data = scanRvLine.next();
	    		rcdObj.setDivisa(data.trim());
	    		rvInt++;
	    		break;
			case 15:	    		
	    		data = scanRvLine.next();
	    		rcdObj.setImporte(data.trim());
	    		rvInt++;
	    		break;
			case 23:	    		
	    		data = scanRvLine.next();
	    		rcdObj.setFluctuacion(data.trim());
	    		rvInt++;
	    		break;
			default:        		
	    		if(scanRvLine.hasNext()) {
	    			data = scanRvLine.next();
	    			
	    		}
	    		rvInt++;
	    		break;
			}	
		}
		compareRvCfgRv(rcdObj, out);
		
	}
	private void compareRvCfgRv(RcdObjectRvDTO rcdObj, PrintWriter out)throws ParseException {
		for(CfgPosRVDTO cfg: rvdto) {
			if ( (cfg.getCartera().equalsIgnoreCase(rcdObj.getCartera())) && 
					(cfg.getClase().equalsIgnoreCase(rcdObj.getClase())) &&
					(cfg.getDivisa().equalsIgnoreCase(rcdObj.getDivisa())) ) {
				if (cfg.getImporte().equalsIgnoreCase("importe")) {
					setCuentaRv(rcdObj, cfg.getCuenta(), rcdObj.getImporte(), out);
				} else if (cfg.getImporte().equalsIgnoreCase("fluctuacion")) {
					setCuentaRv(rcdObj, cfg.getCuenta(), rcdObj.getFluctuacion(), out);
				}
				
			}
		}
	}
	private void setCuentaRv(RcdObjectRvDTO rcdObj,String cuenta, String importe, PrintWriter out ) throws ParseException{
		out.print("0011091"+
				completeZeroOficina(rcdObj.getCentroaltamira(),4)+
				"1"+
				completeZeroCodigoCentral(rcdObj.getCodigocentral(),8)+
        		completeSpaceDescription(rcdObj.getCartera(),rcdObj.getIsin(),20)+
        		"0091    "+
        		"20501231"+
        		"0000"+
        		completeSpaceCuentas(cuenta,15)+
        		reemplazaVac(rcdObj.getDivisa())+
        		completeZeroImp(importe,2,18)+
        		"000000000000000000"+
        		"R"+
        		completeSpaceContrapartida(rcdObj.getCliente(),60)+
        		getSigno(importe)	        		
        		);
        out.print("\r\n");
	}
	
	
	private void setRF(MultipartFile rf, PrintWriter out)throws Exception {
		CSVReader reader = null;
		InputStream is =  new BufferedInputStream(rf.getInputStream());
		
		try {
			reader = new CSVReaderBuilder(new InputStreamReader(is)).withSkipLines(1).build();
			String[] nextLine;
			
		

			while ((nextLine = reader.readNext()) != null) {
				
				setRfLine(nextLine[0], out);				
				
			} 
		} catch (Exception e) {
			log.error("failed!", e);
			
		}
	}
	private void setRfLine(String srfLine, PrintWriter out) throws ParseException{
		try(Scanner scanRfLine = new Scanner(srfLine)){
			scanRfLine.useDelimiter(";");
			
			int rfInt = 0;
			RcdObjectRfDTO rcdObj = new RcdObjectRfDTO();
			setDataToRfObject(rcdObj, out, rfInt, scanRfLine);
			
		}
	}
	private void setDataToRfObject(RcdObjectRfDTO rcdObj, PrintWriter out, int rfInt, Scanner scanRfLine) throws ParseException{
		
		while (scanRfLine.hasNext()) {
			String data="";
			switch(rfInt) {
			case 0:	    		
	    		data = scanRfLine.next();
	    		rcdObj.setCentroaltamira(data.trim());
	    		rfInt++;
	    		break;
			case 1:	    		
	    		data = scanRfLine.next();
	    		rcdObj.setCartera(data.trim());
	    		rfInt++;
	    		break;
			case 2:	    		
	    		data = scanRfLine.next();
	    		rcdObj.setIsin(data.trim());
	    		rfInt++;
	    		break;
			case 3:	    		
	    		data = scanRfLine.next();
	    		rcdObj.setClase(data.trim());
	    		rfInt++;
	    		break;
			case 6:	    		
	    		data = scanRfLine.next();
	    		rcdObj.setCodigocentral(data.trim());
	    		rfInt++;
	    		break;
			case 7:	    		
	    		data = scanRfLine.next();
	    		rcdObj.setCliente(data.trim());
	    		rfInt++;
	    		break;
			case 9:	    		
	    		data = scanRfLine.next();
	    		rcdObj.setFechavencimiento(data.trim());
	    		rfInt++;
	    		break;
			case 13:	    		
	    		data = scanRfLine.next();
	   			rcdObj.setDivisa(data.trim());
	    		rfInt++;
	    		break;
			case 14:	    		
	    		data = scanRfLine.next();
	    		rcdObj.setNominal(data.trim());
	    		rfInt++;
	    		break;
			case 15:	    		
	    		data = scanRfLine.next();
	    		rcdObj.setImporte(data.trim());
	    		rfInt++;
	    		break;
			case 19:	    		
	    		data = scanRfLine.next();
	    		rcdObj.setPrima(data.trim());
	    		rfInt++;
	    		break;
			case 20:	    		
	    		data = scanRfLine.next();
	    		rcdObj.setInteres(data.trim());
	    		rfInt++;
	    		break;
			case 23:	    		
	    		data = scanRfLine.next();
	    		rcdObj.setFluctuacion(data.trim());
	    		rfInt++;
	    		break;
			default:        		
	    		if(scanRfLine.hasNext()) {
	    			data = scanRfLine.next();
	    			
	    		}
	    		rfInt++;
	    		break;
			}	
		}
		compareRfCfgRv(rcdObj, out);
		
	}
	private void compareRfCfgRv(RcdObjectRfDTO rcdObj, PrintWriter out)throws ParseException {
	for(CfgPosRFDTO cfg: rfdto) {
		if ( (cfg.getCartera().equalsIgnoreCase(rcdObj.getCartera())) && 
				(cfg.getClase().equalsIgnoreCase(rcdObj.getClase())) &&
				(cfg.getDivisa().equalsIgnoreCase(rcdObj.getDivisa())) ) {
			if (cfg.getImporte().equalsIgnoreCase("importe")) {
				setCuentaRf(rcdObj, cfg.getCuenta(), rcdObj.getImporte(), out);
			} else if (cfg.getImporte().equalsIgnoreCase("fluctuacion")) {
				setCuentaRf(rcdObj, cfg.getCuenta(), rcdObj.getFluctuacion(), out);
			} else if (cfg.getImporte().equalsIgnoreCase("nominal")) {
				setCuentaRf(rcdObj, cfg.getCuenta(), rcdObj.getNominal(), out);
			} else if (cfg.getImporte().equalsIgnoreCase("interes")) {
				setCuentaRf(rcdObj, cfg.getCuenta(), rcdObj.getInteres(), out);
			} else if(cfg.getImporte().equalsIgnoreCase("prima")) {
				setCuentaRf(rcdObj, cfg.getCuenta(), rcdObj.getPrima(), out);
				}
			
			}
		}
	}
	private void setCuentaRf(RcdObjectRfDTO rcdObj,String cuenta, String importe, PrintWriter out ) throws ParseException{
		out.print("0011091"+
				completeZeroOficina(rcdObj.getCentroaltamira(),4)+
				"1"+
				completeZeroCodigoCentral(rcdObj.getCodigocentral(),8)+
        		completeSpaceDescription(rcdObj.getCartera(),rcdObj.getIsin(),20)+
        		"0091    "+
        		dateFormat(rcdObj.getFechavencimiento())+
        		"0000"+
        		completeSpaceCuentas(cuenta,15)+
        		reemplazaVac(rcdObj.getDivisa())
        		+
        		completeZeroImp(importe,2,18)+
        		"000000000000000000"+
        		"R"+
        		completeSpaceContrapartida(rcdObj.getCliente(),60)
        		+        		getSigno(importe)	        		
        		);
        out.print("\r\n");
	}

	
	private void setOpTasas(MultipartFile optasas, PrintWriter out) throws Exception {
		InputStream is =  new BufferedInputStream(optasas.getInputStream());
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String row = null;
			
			if(reader.ready()) {
				row = reader.readLine();
			}
			
			
			while (reader.ready()) {

				row = reader.readLine();
				
				String cod = row.substring(6, 18);
				cod = cod.replaceAll("\\s", "");
				
				
				
				if (cod.length()>0) {
					setOpTasasLine(row,out);
				}
				
			}

		} catch (Exception e) {
			log.error("failed!", e);
			
		}
	}
	private void setOpTasasLine(String op07Line, PrintWriter out) throws ParseException {
		String partIntImp = "";
		String partDecimalImp="";
		RcdObject07DTO rcdObject = new RcdObject07DTO();
		rcdObject.setCodigocentral(op07Line.substring(288,310));
		rcdObject.setContrato(op07Line.substring(6,18));
		rcdObject.setFechavencimiento(op07Line.substring(191,199));
		rcdObject.setDivisa(reemplazaVac(op07Line.substring(36,39)));
		partIntImp=op07Line.substring(39,51);
		partDecimalImp=op07Line.substring(51,53);
		rcdObject.setImporte(partIntImp+""+partDecimalImp);
		rcdObject.setCliente(op07Line.substring(199,249));
		rcdObject.setCofigofila(op07Line.substring(0,6));
		
		compareOp07Cfg07(rcdObject, out);
	}
	private void compareOp07Cfg07(RcdObject07DTO rcdObject, PrintWriter out) throws ParseException {
		for(CfgRCD07DTO cfg: optasasdto) {
			int filainicio = Integer.valueOf(cfg.getFilainicio());
			int filafin = Integer.valueOf(cfg.getFilafin());
			int codfila = Integer.valueOf(rcdObject.getCofigofila());
			if ((cfg.getDivisa().equalsIgnoreCase(rcdObject.getDivisa())) &&
					(codfila>=filainicio) && (codfila<=filafin)) {
				
				if(rcdObject.getCodigocentral().trim().length() < 8) {
					rcdObject.setCodigocentral(String.format("%1$-22s", agregarCeros(rcdObject.getCodigocentral().trim(), 8)));
				}
				out.print("0011091"+
						"0571"+
						"1"+
						completeZeroCodigoCentral(rcdObject.getCodigocentral(),8)+
		        		completeSpaceContrato(rcdObject.getContrato(),20)+
		        		"0091    "+
		        		rcdObject.getFechavencimiento().trim()+
		        		"0000"+
		        		completeSpaceCuentas(cfg.getCuenta(),15)+
		        		reemplazaVac(rcdObject.getDivisa())+
		        		completeZeroImp1(rcdObject.getImporte(),18)+
		        		"000000000000000000"+
		        		"R"+
		        		completeSpaceContrapartida(rcdObject.getCliente(),60)+
		        		"+"	        		
		        		);
		        out.print("\r\n");
			}
		}
	}

	
private String agregarCeros(String cad, int largo) {
		String ceros = "";
		String resultado = "";
		
		int cantidad = largo - cad.length();
		
		if(cantidad >= 1) {
			for (int i = 0; i < cantidad; i++){
				ceros += "0";
			}
			
			resultado = (ceros + cad);
		} else {
			resultado = cad;
		}
		
		return resultado;
	}

private void setOpFx(MultipartFile opx, PrintWriter out) throws IOException {
		
		InputStream is =  new BufferedInputStream(opx.getInputStream());
		
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String row = null;
			
			if(reader.ready()) {
				row = reader.readLine();
			}
			
			
			while (reader.ready()) {

				row = reader.readLine();
				
				String cod = row.substring(6, 18);
				cod = cod.replaceAll("\\s", "");
				
				
				
				if (cod.length()>0) {
					setOpFxLine(row,out);
				}
				
			}

		} catch (Exception e) {
			log.error("failed!", e);
			
		}
	}
	private void setOpFxLine(String op02Line, PrintWriter out)throws ParseException {
		String partIntImp = "";
		String partDecimalImp="";
		RcdObject02DTO rcdObject = new RcdObject02DTO();
		
		rcdObject.setCodigocentral(op02Line.substring(169,191));
		rcdObject.setContrato(op02Line.substring(6,18));
		rcdObject.setFechavencimiento(op02Line.substring(72,80));
		rcdObject.setDivisa(reemplazaVac(op02Line.substring(36,39)));
		partIntImp=op02Line.substring(39,51);
		partDecimalImp=op02Line.substring(51,53);
		rcdObject.setImporte(partIntImp+""+partDecimalImp);
		rcdObject.setCliente(op02Line.substring(80,130));
		rcdObject.setCofigofila(op02Line.substring(0,6));
		
		compareOp02Cfg02(rcdObject, out);
	}
	private void compareOp02Cfg02(RcdObject02DTO rcdObject, PrintWriter out)throws ParseException {
		for(CfgRCD02DTO cfg: opfxdto) {
			int filainicio = Integer.valueOf(cfg.getFilainicio());
			int filafin = Integer.valueOf(cfg.getFilafin());
			int codfila = Integer.valueOf(rcdObject.getCofigofila());
			if ((cfg.getDivisa().equalsIgnoreCase(rcdObject.getDivisa())) &&
					(codfila>=filainicio) && (codfila<=filafin)) {
				
				if(rcdObject.getCodigocentral().trim().length() < 8) {
					rcdObject.setCodigocentral(String.format("%1$-22s", agregarCeros(rcdObject.getCodigocentral().trim(), 8)));
				}
				
				out.print("0011091"+
						"0571"+
						"1"+
						completeZeroCodigoCentral(rcdObject.getCodigocentral(),8)+
		        		completeSpaceContrato(rcdObject.getContrato(),20)+
		        		"0091    "+
		        		rcdObject.getFechavencimiento().trim()+
		        		"0000"+
		        		completeSpaceCuentas(cfg.getCuenta(),15)+
		        		reemplazaVac(rcdObject.getDivisa())+
		        		completeZeroImp1(rcdObject.getImporte(),18)+
		        		"000000000000000000"+
		        		"R"+
		        		completeSpaceContrapartida(rcdObject.getCliente(),60)+
		        		"+"	        		
		        		);
		        out.print("\r\n");
		}
	}
	}
}
