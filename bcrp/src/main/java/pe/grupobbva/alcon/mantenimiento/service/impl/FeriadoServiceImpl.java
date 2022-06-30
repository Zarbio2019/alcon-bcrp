package pe.grupobbva.alcon.mantenimiento.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.grupobbva.alcon.core.beans.Codigoestado;
import pe.grupobbva.alcon.core.utils.dto.DatatableDTO;
import pe.grupobbva.alcon.mantenimiento.config.ValidatorUtil;
import pe.grupobbva.alcon.mantenimiento.dto.FeriadoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.custom.FeriadoCopia;
import pe.grupobbva.alcon.mantenimiento.dto.search.FeriadoSearch;
import pe.grupobbva.alcon.mantenimiento.dto.table.FeriadoTableDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Feriado;
import pe.grupobbva.alcon.mantenimiento.repository.FeriadoRepository;
import pe.grupobbva.alcon.mantenimiento.repository.OperacionRepository;
import pe.grupobbva.alcon.mantenimiento.service.FeriadoService;

@Service
public class FeriadoServiceImpl extends AbstractServiceImpl<Feriado> implements FeriadoService {

	@Autowired
	private OperacionRepository operacionRepository;

	@Override
	public DatatableDTO<FeriadoTableDTO> search(FeriadoSearch feriadoSearch) {
		return ((FeriadoRepository) repository).search(feriadoSearch);
	}

	@Override
	public void guardar(Feriado entity) {
		Long registros = ((FeriadoRepository) repository).feriadosDuplicados(entity.getCodigoestado(),
				entity.getFecha().get(Calendar.DAY_OF_MONTH), entity.getFecha().get(Calendar.MONTH) + 1,
				entity.getFecha().get(Calendar.YEAR));

		if (registros > 0l) {
			ValidatorUtil.validateMessage("feriado", "No se ha ingresado el feriado, debido a que ya existe un feriado con la fecha indicada.");
		}
		super.guardar(entity);
	}

	@Override
	public void actualizar(Feriado entity) {
		Long registros = ((FeriadoRepository) repository).feriadosDuplicadosActualizar(entity.getCodigoestado(),
				entity.getFecha().get(Calendar.DAY_OF_MONTH), entity.getFecha().get(Calendar.MONTH) + 1,
				entity.getFecha().get(Calendar.YEAR), entity.getId());

		if (registros > 0l) {
			ValidatorUtil.validateMessage("feriado",
					"No se puede modificar el feriado, debido a que ya existe un feriado con la fecha indicada.");
		}
		super.actualizar(entity);
	}

	@Override
	public void eliminar(Feriado entity) {
		Long registros = ((FeriadoRepository) repository).feriadosExistentesActualizar(entity.getId());

		if (registros < 1l) {
			ValidatorUtil.validateMessage("id", "id No Existe");
		}

		if (entity.getCodigoestado().equals(Codigoestado.INACTIVO.getCodigoestado())) {
			ValidatorUtil.validateMessage("codigoestado", "El registro ya fue borrado");
		}

		super.eliminar(entity);

		operacionRepository.actualizarOperacionFeriado(entity);

	}

	@Override
	public void copiarFeriado(FeriadoCopia feriadoCopia) {
		((FeriadoRepository) repository).copiarFeriado(feriadoCopia);
	}
	
	@Override
	public List<FeriadoDTO> listarFeriados() {
		return ((FeriadoRepository) repository).listarFeriados();
	}

	@Override
	public Boolean esDiaUtil(Calendar fecha, List<FeriadoDTO> feriados) {

		// Verificamos si la fecha no es ni sabado ni domingo
		if (fecha.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || fecha.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			return false;
		} else {
			for (FeriadoDTO feriado : feriados) {
				if (truncateToDay(feriado.getFecha()).compareTo(truncateToDay(fecha)) == 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public Calendar truncateToDay(Calendar fecha) {
		fecha.set(Calendar.HOUR_OF_DAY, 0);
		fecha.set(Calendar.MINUTE, 0);
		fecha.set(Calendar.SECOND, 0);
		fecha.set(Calendar.MILLISECOND, 0);
        
        return fecha;
	}

	@Override
	public Calendar obtenerSiguienteDiaUtil(Calendar fecha, List<FeriadoDTO> feriados) {
		Calendar fechaTmp = fecha;
		
		while (esDiaUtil(fecha, feriados).equals(Boolean.FALSE)) {
			fechaTmp.add(Calendar.DAY_OF_YEAR, 1);// se agrega un dia
			fecha = fechaTmp;
		}
		
		return fechaTmp;
	}
	
	@Override
	public Calendar obtenerAnteriorDiaUtil(Calendar fecha, List<FeriadoDTO> feriados) {
		Calendar fechaTmp = fecha;
		
		while (esDiaUtil(fecha, feriados).equals(Boolean.FALSE)) {
			fechaTmp.add(Calendar.DAY_OF_YEAR, -1);// se quita un dia
		}
		
		return fechaTmp;
	}
	
	@Override
	public Feriado obtenerFeriadoPorId(String id) {
		return ((FeriadoRepository) repository).obtenerFeriadoPorId(id);
	}
	
	@Override
	@Transactional
	public void actualizarOperacionFeriado(String id) {
		((FeriadoRepository) repository).actualizarOperacionFeriado(id);
	}
	
	public int diasHabiles(Calendar fechaInicial, Calendar fechaFinal, List<FeriadoDTO> feriados) {
	       int diffDays = 0;
	       boolean diaHabil = false;
	       //mientras la fecha inicial sea menor se cuentan los dias
	       while (fechaInicial.before(fechaFinal)) {

	          if (!feriados.isEmpty()) {
	              for (FeriadoDTO feriado : feriados) {
	                  Date fechaNoLaborablecalendar = fechaInicial.getTime();
	                  //si el dia de la semana de la fecha minima es diferente de sabado o domingo
	                  if (fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && !fechaNoLaborablecalendar.equals(feriado.getFecha().getTime())) {
	                      //se aumentan los dias de diferencia entre min y max
	                      diaHabil = true;
	                  } else {
	                      diaHabil = false;
	                      break;
	                  }
	              }
	          } else {
	              if (fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && fechaInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
	                  //se aumentan los dias de diferencia entre min y max
	                  diffDays++;
	              }
	          }
	          
	          if (diaHabil == true) {
	        	  diffDays++;
	          }
	          
	          //se suma 1 dia para hacer la validacion del siguiente dia.
	          fechaInicial.add(Calendar.DATE, 1);
	     }
	     return diffDays;
	  }
	
}
