package pe.grupobbva.alcon.mantenimiento.service.ws;

public interface TransaccionClient {
	public String enviaTramas(String strIdLogin, String strIdTrama, String strTrama, String strAmbienteHOST,
			String strIpCliente, String strSesion, String strUsuario, String strPassword, String strCodigoSistema) throws Exception;
}
