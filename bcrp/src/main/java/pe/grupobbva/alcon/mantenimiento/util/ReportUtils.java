package pe.grupobbva.alcon.mantenimiento.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ReportUtils {
	
	private static final Logger log = LogManager.getLogger();
	
	public ReportUtils() {
		super();

	}

	public String dateFormat(Calendar calendar) {
		Date date = calendar.getTime(); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyMMdd");
		return formatter.format(date);
	}
	
	public String completeZeros(BigDecimal number,Integer decimals, Integer length) {
		
		String stringNumber = number==null? "0" : number
			.abs()
			.setScale(decimals ,BigDecimal.ROUND_HALF_UP)
			.toString().replace(".", "");
		
		StringBuilder stringResponse = new StringBuilder();
		
		for(int i=1; i<= length-stringNumber.length(); i++) {
			stringResponse.append("0");
		}
		
		stringResponse.append(stringNumber);
		
		return stringResponse.toString();
	}
	
	public String completeZeros(BigDecimal number,Integer decimals, Integer length, Boolean flag) {
		String sign = "";
		
		if(flag) {//Signo
			number = number == null? new BigDecimal(0): number;
			sign = number.compareTo(new BigDecimal(0))<0 ? "-":" "; 
		}
		
		return this.completeZeros(number, decimals, length) +sign;
	}
	
	public String addSignLeft(BigDecimal number,Integer decimals, Integer length) {
		String sign = "";
		
		number = number == null? new BigDecimal(0): number;
		sign = number.compareTo(new BigDecimal(0))<0 ? "-":"0"; 
		
		return sign + this.completeZeros(number, decimals, length).substring(1,length);
	}
	
	public String completeSpace(String name, Integer length) {
		
		name = StringUtils.isBlank(name)?" ":name.substring(0, Math.min(30, name.length())).trim();
		StringBuilder nameResponse = new StringBuilder();
		nameResponse.append(name);
		
		for(int i=1; i<= length-name.length(); i++) {
			nameResponse.append(" ");
		}
		
		return nameResponse.toString();
		
	}
	
	public String numberFormat(String number) {
		
		if(!StringUtils.isBlank(number)) {
			number= "+E"+ number;
		}
		
		return number;
	}
	
	public BigDecimal numberAsBigDecimal(String number) {
		return new BigDecimal(number).setScale(2 ,BigDecimal.ROUND_HALF_UP);
	}
	
}
