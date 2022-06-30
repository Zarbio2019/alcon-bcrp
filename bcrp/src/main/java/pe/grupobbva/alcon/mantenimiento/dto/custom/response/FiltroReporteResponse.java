package pe.grupobbva.alcon.mantenimiento.dto.custom.response;

import java.util.Calendar;

import lombok.Data;

@Data
public class FiltroReporteResponse {

	private Calendar fecha;
	private String tipoproceso;
	private String divisa;
	private String producto;
}
