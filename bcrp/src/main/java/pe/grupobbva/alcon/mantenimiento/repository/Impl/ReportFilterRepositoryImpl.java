package pe.grupobbva.alcon.mantenimiento.repository.Impl;

import java.util.Calendar;

import javax.persistence.EntityManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.grupobbva.alcon.mantenimiento.dto.custom.FiltroReporte;
import pe.grupobbva.alcon.mantenimiento.dto.custom.response.FiltroReporteResponse;
import pe.grupobbva.alcon.mantenimiento.repository.ReportFilterRepository;

@Repository
public class ReportFilterRepositoryImpl implements ReportFilterRepository {

	@Autowired
	private EntityManager em;
	
	private static final Logger log = LogManager.getLogger();
	
	@Override
	public FiltroReporteResponse getFilter(FiltroReporte filtro) {
		FiltroReporteResponse filtroResponse = new FiltroReporteResponse();

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(filtro.getFecha());
		//Tipo operación inicial
		filtroResponse.setDivisa("-2");
		filtroResponse.setProducto("-2");
		filtroResponse.setTipoproceso("A");
		filtroResponse.setFecha(calendar);
		
		if(calendar.get(Calendar.HOUR_OF_DAY)<15) {
			//Cambio Tipo Operación
			filtroResponse.setTipoproceso("D");
			
			//Resto un dia
			calendar.add(Calendar.DAY_OF_YEAR,-1);
			filtroResponse.setFecha(this.workingDay(calendar));
		}
		
		
		return filtroResponse;
	}
	
	private Calendar workingDay(Calendar fecha) {
		
		if( fecha.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY) {
			fecha.add(Calendar.DAY_OF_YEAR,-2);
		}else if(fecha.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY) {
			fecha.add(Calendar.DAY_OF_YEAR,-1);
		}
		
		return fecha;
	}

}
