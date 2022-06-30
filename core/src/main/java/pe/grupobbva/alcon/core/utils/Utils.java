package pe.grupobbva.alcon.core.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pe.grupobbva.alcon.core.beans.TimeFormat;
import pe.grupobbva.alcon.core.utils.dto.QueryDatatable;

public class Utils {

	private static final Map<Class<?>, PropertyDescriptor[]> beanDescriptors = new HashMap<Class<?>, PropertyDescriptor[]>();

	private static PropertyDescriptor[] getBeanDescriptors(Class<?> clazz) {
		PropertyDescriptor[] descriptors = beanDescriptors.get(clazz);
		if (descriptors == null) {
			try {
				BeanInfo beanInfo = Introspector.getBeanInfo(clazz);
				descriptors = beanInfo.getPropertyDescriptors();
				beanDescriptors.put(clazz, descriptors);
			} catch (IntrospectionException e) {
				throw new IllegalStateException(e);
			}
		}
		return descriptors;
	}

	public static <T> void copy(T source, T destination, boolean skipIfNull) {
		PropertyDescriptor[] descriptors = getBeanDescriptors(source.getClass());

		for (PropertyDescriptor descriptor : descriptors) {
			try {
				if ("class".equals(descriptor.getName())) {
					// Class is not a regular JavaBeans property!
					continue;
				}

				Method readMethod = descriptor.getReadMethod();
				Method writeMethod = descriptor.getWriteMethod();
				if (readMethod == null || writeMethod == null) {
					// Property must be read/write to copy
					continue;
				}
				Object value = readMethod.invoke(source);
				if (value == null && skipIfNull == true) {
					// As per the flag, do not copy null properties
					continue;
				} else {
					writeMethod.invoke(destination, value);
				}
			} catch (ReflectiveOperationException e) {
				throw new IllegalStateException(e);
			}
		}
	}

	public static Calendar stringtoCalendar(String stringDate, TimeFormat timeFormat) throws ParseException {
		DateFormat df = new SimpleDateFormat(timeFormat.getFormat());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(df.parse(stringDate));
		return calendar;
	}

	public static String calendartoString(Calendar calendar, TimeFormat timeFormat) {
		DateFormat df = new SimpleDateFormat(timeFormat.getFormat());
		return df.format(calendar.getTime());
	}

	public static int obtenerDirefenciaFechaDias(Calendar start, Calendar end) {
		int dias = 0;
		dias = (int) (Math.abs(end.getTimeInMillis() - start.getTimeInMillis()) / 86400000);
		return dias;
	}

	public static double obtenerPlazo(Calendar start, Calendar end) {
		double dias = 0;
		dias = ((double) (end.getTimeInMillis() - start.getTimeInMillis()) / 86400000);
		return dias;
	}

	public static BigDecimal obtenerNumerico(String cadena) {
		BigDecimal valor = BigDecimal.ZERO;

		if (esNumerico(cadena).equals(Boolean.TRUE)) {
			valor = new BigDecimal(cadena);
		}

		return valor;
	}

	public static Boolean esNumerico(String cadena) {
		Boolean resultado = false;

		try {
			new BigDecimal(cadena);
			resultado = true;
		} catch (Exception excepcion) {
			resultado = false;
		}

		return resultado;
	}

	public static String formatearCuenta(String cuenta) {
		int valor = 0;
		String cuentafinal = cuenta;

		if (!cuenta.trim().isEmpty() && cuenta.trim().length() == 15) {

			valor = Integer.valueOf(cuentafinal.substring(4, 6));

			if (valor == 0) {
				return cuentafinal.substring(0, 4);
			}

			valor = Integer.valueOf(cuentafinal.substring(6, 8));

			if (valor == 0) {
				return cuentafinal.substring(0, 6);
			}

			valor = Integer.valueOf(cuentafinal.substring(8, 10));

			if (valor == 0) {
				return cuentafinal.substring(0, 8);
			}

			valor = Integer.valueOf(cuentafinal.substring(10, 12));

			if (valor == 0) {
				return cuentafinal.substring(0, 10);
			}

			valor = Integer.valueOf(cuentafinal.substring(12, 14));

			if (valor == 0) {
				return cuentafinal.substring(0, 12);
			}

			valor = Integer.valueOf(cuentafinal.substring(14, 15));

			if (valor == 0) {
				return cuentafinal.substring(0, 14);
			}
		}

		return cuentafinal;
	}
	
	public static String padLeftZeros(String inputString, int length) {
	    if (inputString.length() >= length) {
	        return inputString;
	    }
	    StringBuilder sb = new StringBuilder();
	    while (sb.length() < length - inputString.length()) {
	        sb.append('0');
	    }
	    sb.append(inputString);
	 
	    return sb.toString();
	}
	
	public static boolean validarFechaNuevaCircular(String fecha) {
		Calendar calendar = Calendar.getInstance();
		Date fechaActual = new Date();
		calendar.setTime(fechaActual);
		String patron = "dd/MM/yyyy";
		boolean resultado = false;
		
		String fechaSistema = new SimpleDateFormat(patron).format(fechaActual);
		
		try {
			//fecha que entra en vigor la C0002-2020
			Calendar fechaC2 = stringtoCalendar(fecha, TimeFormat.DATEFORMAT);
			
			// fecha del sistema
			Calendar fs = stringtoCalendar(fechaSistema, TimeFormat.DATEFORMAT);
			
			resultado = (fechaC2.before(fs) || (fechaC2.compareTo(fs) == 0));
		} catch (ParseException e) {
			
		}
		
		return resultado;
	}
	
	public static Calendar truncateToDay(Calendar fecha) {
		fecha.set(Calendar.HOUR_OF_DAY, 0);
		fecha.set(Calendar.MINUTE, 0);
		fecha.set(Calendar.SECOND, 0);
		fecha.set(Calendar.MILLISECOND, 0);
        
        return fecha;
	}

	public static <T> List<T> paginador(List<T> listaBasem, QueryDatatable qD) {

		Integer maxResults = qD.getStart() + qD.getLength();

		if (listaBasem == null || listaBasem.isEmpty()) {
			return new ArrayList<>();
		} else if (qD.getStart().compareTo(listaBasem.size()) > 0) {
			// null
			return new ArrayList<>();
		} else if (maxResults.compareTo(listaBasem.size()) > 0) {
			// valores a partir de clientes start
			return listaBasem.subList(qD.getStart(), listaBasem.size());
		} else {
			// valores entre start , start+ getlength
			return listaBasem.subList(qD.getStart(), maxResults);
		}

	}

}
