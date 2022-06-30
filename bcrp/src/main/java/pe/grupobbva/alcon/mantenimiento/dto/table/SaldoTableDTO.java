package pe.grupobbva.alcon.mantenimiento.dto.table;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.SaldoDTO;
import pe.grupobbva.alcon.mantenimiento.dto.process.SaldoCargaType;
import pe.grupobbva.alcon.mantenimiento.entity.Saldo;
import pe.grupobbva.alcon.mantenimiento.entity.Signo;

@Data
public class SaldoTableDTO extends SaldoDTO {

	/**
	 * @param registro
	 * @throws ParseException
	 */
	public SaldoTableDTO(SaldoCargaType registro) throws ParseException {
		
		setNumerocuenta(registro.getNumerocuenta());
		setSaldo(registro.getSaldo());
		setSignosaldo(String.valueOf(registro.getSignosaldo().ordinal()));
		setSaldomedio(registro.getSaldomedio());
		setSignosaldomedio(String.valueOf(registro.getSignosaldomedio().ordinal()));
		setNumerolinea(registro.getNumerolinea());
		setFechaproceso(registro.getFechaproceso());
		setActivo(true);

	}

	private String oficinacodigo;
	private String divisacodigo;

	public SaldoTableDTO() {
		super();
	}

	public SaldoTableDTO(String id) {
		super(id);
	}

	public SaldoTableDTO(Saldo entity) {
		super(entity);
	}

	@Override
	public Saldo fromDTO(Saldo entity) {

		if (entity == null) {
			entity = new Saldo();
		}

		if (getIdoficina() != null) {
			entity.setIdoficina(getIdoficina());
		}

		if (getNumerocuenta() != null) {
			entity.setNumerocuenta(getNumerocuenta());
		}

		if (getIddivisa() != null) {
			entity.setIddivisa(getIddivisa());
		}

		if (getSaldo() != null) {
			entity.setSaldo(getSaldo());
		}

		if (getSignosaldo() != null) {
			entity.setSignosaldo(getSignosaldo().equals("1") ? Signo.POSITIVO : Signo.NEGATIVO);
		}

		if (getSaldomedio() != null) {
			entity.setSaldomedio(getSaldomedio());
		}

		if (getSignosaldomedio() != null) {
			entity.setSignosaldomedio(getSignosaldomedio().equals("1") ? Signo.POSITIVO : Signo.NEGATIVO);
		}

		if (getNumerolinea() != null) {
			entity.setNumerolinea(getNumerolinea());
		}

		if (getFechaproceso() != null) {
			entity.setFechaproceso(getFechaproceso());
		}
		
		if (getActivo() != null) {
			entity.setActivo(getActivo());
		}

		if (getCodigoestado() != null) {
			entity.setCodigoestado(getCodigoestado());
		}

		return entity;
	}

	public SaldoTableDTO(String id, String idoficina, String numerocuenta, String iddivisa, BigDecimal saldo,
			String signosaldo, BigDecimal saldomedio, String signosaldomedio, Integer numerolinea,
			Calendar fechaproceso, Boolean activo, Integer codigoestado, String oficinacodigo, String divisacodigo) {

		super(id, idoficina, numerocuenta, iddivisa, saldo, signosaldo, saldomedio, signosaldomedio, numerolinea,
				fechaproceso, activo, codigoestado);
		this.oficinacodigo = oficinacodigo;
		this.divisacodigo = divisacodigo;

	}

}
