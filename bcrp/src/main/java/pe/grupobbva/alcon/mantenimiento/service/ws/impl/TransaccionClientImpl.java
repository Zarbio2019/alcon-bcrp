package pe.grupobbva.alcon.mantenimiento.service.ws.impl;

import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.ws.transacciones.Transacciones;
import pe.grupobbva.alcon.core.ws.transacciones.TransaccionesSoap;
import pe.grupobbva.alcon.mantenimiento.service.ws.TransaccionClient;

@Service
public class TransaccionClientImpl implements TransaccionClient {
	
	@Value("${app.wsdl.transaccion}")
	private String url;
	
	private TransaccionesSoap service2;
	
	public String enviaTramas(String strIdLogin,String strIdTrama,String strTrama,String strAmbienteHOST,
			String strIpCliente,String strSesion,String strUsuario,String strPassword,String strCodigoSistema) throws Exception {
		
		return getService().enviaTramas(strIdLogin, strIdTrama, strTrama, strAmbienteHOST, strIpCliente, strSesion, 
				strUsuario, strPassword, strCodigoSistema);
		
	}
	
	
	private TransaccionesSoap getService() throws MalformedURLException {
		if(service2 == null) {
//			String url = "http://172.30.10.222/WSERGENERAL/Transacciones.asmx?wsdl";
			URL endpoint = new URL(url);
			
			Transacciones service = new Transacciones(endpoint);
			service2 = service.getTransaccionesSoap();
		}
		return service2;
		
	}
}
