package pe.grupobbva.alcon.mantenimiento.endpoint;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.grupobbva.alcon.mantenimiento.config.UsuarioActivo;
import pe.grupobbva.alcon.mantenimiento.dto.UploadCargaDTO;
import pe.grupobbva.alcon.mantenimiento.endpoint.util.ReportFilter;

@RestController
@RequestMapping("/usuario")
public class UserEndpoint extends ReportFilter {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UsuarioActivo usuarioActivo;

	@GetMapping(produces = "application/json")
	public ResponseEntity<UsuarioActivo>  getusuarioActivo() {
		UsuarioActivo user = new UsuarioActivo();
		user.setUser(usuarioActivo.getUser());
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(user);
				
	}

	@PostMapping(path = "logout")
	public ResponseEntity<Void> upload(UploadCargaDTO uploadCarga, Integer opcionTipoCarga) {
		request.getSession().invalidate();
		return ResponseEntity.status(HttpStatus.OK).build();
	}

}
