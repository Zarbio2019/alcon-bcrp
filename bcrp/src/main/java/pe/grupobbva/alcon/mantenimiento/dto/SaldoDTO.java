package pe.grupobbva.alcon.mantenimiento.dto;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.dto.util.AbstractDTO;
import pe.grupobbva.alcon.mantenimiento.entity.Saldo;
import pe.grupobbva.alcon.mantenimiento.entity.Signo;

@Data
public class SaldoDTO extends AbstractDTO<Saldo> {

	private String idoficina;
	private String numerocuenta;
	private String iddivisa;
	private BigDecimal saldo;
	private String signosaldo;
	private BigDecimal saldomedio;
	private String signosaldomedio;
	private Integer numerolinea;
	private Calendar fechaproceso;
	private Boolean activo;

	public SaldoDTO(String id) {
		super(id);
	}

	public SaldoDTO() {
		super();
	}

	public SaldoDTO(Saldo entity) {
		super(entity);
		this.idoficina = entity.getIdoficina();
		this.numerocuenta = entity.getNumerocuenta();
		this.iddivisa = entity.getIddivisa();
		this.saldo = entity.getSaldo();
		this.signosaldo = entity.getSignosaldo().toString();
		this.saldomedio = entity.getSaldomedio();
		this.signosaldomedio = entity.getSignosaldomedio().toString();
		this.numerolinea = entity.getNumerolinea();
		this.fechaproceso = entity.getFechaproceso();
		this.activo = entity.getActivo();
	}

	@Override
	public Saldo fromDTO(Saldo entity) {
		if (entity == null) {
			entity = new Saldo();
		}

		if (idoficina != null) {
			entity.setIdoficina(this.idoficina);
		}

		if (numerocuenta != null) {
			entity.setNumerocuenta(this.numerocuenta);
		}

		if (iddivisa != null) {
			entity.setIddivisa(this.iddivisa);
		}

		if (saldo != null) {
			entity.setSaldo(this.saldo);
		}

		if (signosaldo != null) {
			entity.setSignosaldo(this.signosaldo.equals(Signo.POSITIVO.toString()) ? Signo.POSITIVO : Signo.NEGATIVO);
		}

		if (saldomedio != null) {
			entity.setSaldomedio(this.saldomedio);
		}

		if (signosaldomedio != null) {
			entity.setSignosaldomedio(
					this.signosaldomedio.equals(Signo.POSITIVO.toString()) ? Signo.POSITIVO : Signo.NEGATIVO);
		}

		if (numerolinea != null) {
			entity.setNumerolinea(this.numerolinea);
		}

		if (fechaproceso != null) {
			entity.setFechaproceso(this.fechaproceso);
		}

		if (activo != null) {
			entity.setActivo(this.activo);
		}

		if (codigoestado != null) {
			entity.setCodigoestado(codigoestado);
		}

		return entity;
	}

	@Override
	public void preactualizar() {
		super.preactualizar();
	}

	public SaldoDTO(String id, String idoficina, String numerocuenta, String iddivisa, BigDecimal saldo,
			String signosaldo, BigDecimal saldomedio, String signosaldomedio, Integer numerolinea,
			Calendar fechaproceso, Boolean activo, Integer codigoestado) {
		super(id);
		this.idoficina = idoficina;
		this.numerocuenta = numerocuenta;
		this.iddivisa = iddivisa;
		this.saldo = saldo;
		this.signosaldo = signosaldo;
		this.saldomedio = saldomedio;
		this.signosaldomedio = signosaldomedio;
		this.numerolinea = numerolinea;
		this.fechaproceso = fechaproceso;
		this.activo = activo;
		this.codigoestado = codigoestado;
	}

}
