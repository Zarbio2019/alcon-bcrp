package pe.grupobbva.alcon.mantenimiento.config;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.grupobbva.bc.per.tele.seguridad.ServiciosSeguridadBbva;

@Component
public class UserFilter implements Filter {
	private static final Logger log = LogManager.getLogger();

	@Resource(name = "usuarioActivo")
	private UsuarioActivo usuarioActivo;

	@Value("${app.wsdl.location}")
	private String location;

	@Value("${app.wsdl.namespace}")
	private String namespace;

	@Value("${app.wsdl.localpart}")
	private String localpart;

	@Value("${spring.profiles.active}")
	private String scope;

	
	private void securidadbbva(HttpServletRequest request) {
		ServiciosSeguridadBbva ssBbva = new ServiciosSeguridadBbva(request);

		log.info("INFO::: paso #01 ");
		ssBbva.obtener_ID();

		log.info("INFO::: Usuario " + ssBbva.getUsuario());
//		UsuarioExtendido usuario = getUsuarioLDAP(ssBbva.getUsuario());
		
		// Solo valido al usuario
		if(ssBbva.getUsuario()!=null) {
			usuarioActivo.setUser(ssBbva.getUsuario());	
		}
		
		
		
		/*
		if (usuario != null) {
			usuario.getPerfiles().getPerfil().stream().forEach(item -> {
				log.info("Nombre : "+item.getNombre()+" Aplicacion: "+item.getCodigoAplicacion()+" Descripcion : "+item.getDescripcion());
				if (item.getNombre().substring(0, 5).equalsIgnoreCase("PCBCRP")) {
					usuarioActivo.setUser(usuario.getUsuario());
					//usuarioActivo.getRoles().add(item.getDescripcion());
				}
			}

			);

		}*/
	}
/*
	private UsuarioExtendido getUsuarioLDAP(String loginUsuario) {
		List<UsuarioExtendido> usuarios = new ArrayList<>();

		List<String> listUsuario = new ArrayList<>();
		listUsuario.add(loginUsuario);

		URL wsdlLocation;
		try {
			wsdlLocation = new URL(location);
			QName serviceName = new QName(namespace, localpart);
			WSLDAPServiceImplService wsldapServiceImplService = new WSLDAPServiceImplService(wsdlLocation, serviceName);
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			List<Object> usuariosObj = wsldapServiceImplService.getWSLDAPServiceImplPort().obtenerUsuarios(listUsuario);
			JAXBElement<UsuarioExtendido> usuarioNodo;

			for (Object usuarioObj : usuariosObj) {
				Node node = (Node) usuarioObj;
				usuarioNodo = jaxbUnmarshaller.unmarshal(node, UsuarioExtendido.class);
				usuarios.add(usuarioNodo.getValue());
			}
		} catch (Exception e) {
			log.error("Error recuperando usuario");
		}
		

		return usuarios.isEmpty() ? null : usuarios.get(0);
	}
*/
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		
		HttpServletResponse resp = (HttpServletResponse) response;
		
		if (scope.equalsIgnoreCase("dev") || scope.equalsIgnoreCase("test")) {
			usuarioActivo.setUser("Frerly");
			//usuarioActivo.getRoles().add("DER");
		} else {
			try {
				securidadbbva((HttpServletRequest) request);
			} catch (Exception e) {
				log.error("failed!",e);
			}
		}
		
		if(usuarioActivo.getUser()==null) {
			
			String mensaje ="{\"operation\" : \"user\"}";
			resp.setContentLength(mensaje.length());
			resp.getOutputStream().print(mensaje);
			
		}/*else if(usuarioActivo.getRoles().isEmpty()) {
			
			String mensaje ="{\"operation\" : \"rol\"}";
			
			resp.setContentLength(mensaje.length());
			resp.getOutputStream().print(mensaje);
		}*/else {
			chain.doFilter(request, response);	
		}
		
	}
		
}
