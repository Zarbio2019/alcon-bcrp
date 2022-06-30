package pe.grupobbva.alcon.mantenimiento.dto;

import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class UploadCargaAnexoOchoDTO {
	private MultipartFile file;
	private MultipartFile filecodigos;
	private Long fechaL;
	private String opcionTipoArchivo;
}
