package pe.grupobbva.alcon.mantenimiento.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.entity.Ejecutado;
import pe.grupobbva.alcon.mantenimiento.entity.Tipo;
import pe.grupobbva.alcon.mantenimiento.service.process.impl.CargaInforReportDiarioServiceImpl;

@Data
public class UploadCargaDTO extends CargaDTO {

	private MultipartFile file;
	private Long fechaL;
	private String opcionTipoCarga;
	

	@Override
	public void preNuevo() {
		super.preNuevo();
		DateFormat dateFormat = new SimpleDateFormat("hh:mm a"); 
		
		setNombrearchivo(file.getOriginalFilename());
		setTotalcargado(0);
		setTotalreg(0);
		Calendar fechaC = Calendar.getInstance();
		fechaC.setTimeInMillis(fechaL);
		setTipo("M");
		setFecha(fechaC);
		setNotaerror(CargaInforReportDiarioServiceImpl.MENSAJE_PROCESANDO);
		setCondicion(true);
		setTipo(Tipo.MANUAL.name());
		setEjecutado(Ejecutado.N.name());
		setTipocarga(opcionTipoCarga);
		
		setFechaCreacion(Calendar.getInstance());
		setHorainicio(dateFormat.format(getFechaCreacion().getTime()));

	}

}
