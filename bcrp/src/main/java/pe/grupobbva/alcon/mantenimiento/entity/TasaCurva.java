package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import lombok.Data;
import pe.grupobbva.alcon.core.beans.TimeFormat;
import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.dto.process.TasaCurvaCargaType;

@Entity
@Table(name = "TasaCurva")
@Data
public class TasaCurva extends AbstractEntity {
	
	public TasaCurva(TasaCurvaCargaType registro) throws ParseException {

		this.fechaproceso = registro.getFechaproceso();

		if (registro.getFecha() != null && !registro.getFecha().equals("")) {
			this.fecha = Utils.stringtoCalendar(registro.getFecha(), TimeFormat.DATEFORMAT3);
		}

		this.curva = registro.getCurva();
		this.divisacurva = registro.getCodigoCurvaDivisa();
		
		if (registro.getFechafin() != null && !registro.getFechafin().equals("")) {
			this.fechafin = Utils.stringtoCalendar(registro.getFechafin(), TimeFormat.DATEFORMAT3);
		}

//		if (registro.getFechafin() != null) {
//			this.plazo = BigDecimal.valueOf(Utils.obtenerPlazo(registro.getFechaproceso(), this.fechafin));
//		}

		this.tenor = registro.getTenor();
		this.tasa1 = registro.getTasa1();
		this.tasa2 = registro.getTasa2();
		this.tasa3 = registro.getTasa3();
		this.datofijo1 = registro.getDatofijo1();

		if (registro.getFechainicio() != null && !registro.getFechainicio().equals("")) {
			this.fechainicio = Utils.stringtoCalendar(registro.getFechainicio(), TimeFormat.DATEFORMAT3);
		}

		this.datofijo2 = registro.getDatofijo2();

	}

	public TasaCurva() {
		super();
	}

	@Size(max = 50)
	private String curva;

	private String iddivisa;

	@Size(max = 10)
	private String divisacurva;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaproceso;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fecha;

	@Size(max = 10)
	private String tenor;

	@Column(precision = 20, scale = 7)
	private BigDecimal plazo; // x

	@Column(precision = 20, scale = 7)
	private BigDecimal tasa1; // y

	@Column(precision = 20, scale = 7)
	private BigDecimal tasa2;

	@Column(precision = 20, scale = 7)
	private BigDecimal tasa3;

	@Size(max = 10)
	private String datofijo1;

	@Size(max = 10)
	private String datofijo2;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechainicio;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechafin;

}
