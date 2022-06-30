package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import pe.grupobbva.alcon.core.beans.TimeFormat;
import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.dto.process.CampanaDepositoCargaType;

@Entity
@Table(name = "CampanaDeposito")
@SuppressWarnings("serial")
public class CampanaDeposito extends AbstractEntity {
	
	public CampanaDeposito(CampanaDepositoCargaType registro) throws ParseException {
		
		this.idCarga = registro.getIdCarga();
		this.fechaproceso = registro.getFechaproceso();
		this.codigocampana = registro.getCodigocampana().trim().replace("-", "");
		this.nombrecampana = registro.getNombrecampana().trim();
		this.nombrecortocampana = registro.getNombrecortocampana().trim();
		
		Divisa div = new Divisa();
		div.setCodigo(registro.getCodigodivisa().trim());
		this.divisa = div;
		
		this.montototalcampana = registro.getMontototalcampana();
		this.fechainidepositoestructurado = Utils.stringtoCalendar(registro.getFechainidepositoestructurado().trim(), TimeFormat.DATEFORMAT2);
		this.fechainiopcion =Utils.stringtoCalendar(registro.getFechainiopcion().trim(), TimeFormat.DATEFORMAT2);
		this.fechafinopcion = Utils.stringtoCalendar(registro.getFechafinopcion().trim(), TimeFormat.DATEFORMAT2);
		this.fechafindepositoestructurado = Utils.stringtoCalendar(registro.getFechafindepositoestructurado().trim(), TimeFormat.DATEFORMAT2);
		this.tasauno = registro.getTasauno();
		this.tasaefecinttotaldepositoestruc = registro.getTasaefecinttotaldepositoestruc();
		this.tasados = registro.getTasados();
		this.tasaefecintminpotencial = registro.getTasaefecintminpotencial();
		
		Cliente cli = new Cliente();
		cli.setAltamira(registro.getCodigoaltamiracliente().trim());
		cli.setNombre(registro.getNombrecliente().trim());
		
		switch (registro.getTipodocumento().trim()) {
			case "L":
				cli.setTipodocumento(1);
				break;
			case "R":
				cli.setTipodocumento(2);
				break;
			case "E":
				cli.setTipodocumento(3);
				break;
			case "P":
				cli.setTipodocumento(4);
				break;
			default:
				break;
		}
		
		cli.setNumerodocumento(registro.getNrodocumento().trim());
		cli.setPaisresidencia(registro.getPaiscliente().trim().substring(0, 2));
		this.cliente = cli;

		this.direccioncliente = registro.getDireccioncliente().trim();
		this.cuentaasociada = registro.getCuentaasociada().trim();
		this.numoficina = registro.getNumoficina().trim();
		this.cuentaplazoestructurado = registro.getCuentaplazoestructurado().trim();
		this.depositoimposicion = registro.getDepositoimposicion();
		this.primacliente = registro.getPrimacliente();
		this.importeintadelantadocliente = registro.getImporteintadelantadocliente();
		this.nombreopcion = registro.getNombreopcion().trim();
		this.tipoopcion = registro.getTipoopcion().trim();
		this.costototalopcion = registro.getCostototalopcion();
		this.subyacentefx = registro.getSubyacentefx().trim();
		this.subyacenteotros = registro.getSubyacenteotros().trim();
		this.dealstar = registro.getDealstar().trim();
		this.strike = registro.getStrike();
		this.tminr = registro.getTminr();
		this.tmaxr = registro.getTmaxr();
		this.tasatres = registro.getTasatres();
		this.valornominalopcionpen = registro.getValornominalopcionpen();
		this.valornominalopcionusd = registro.getValornominalopcionusd();
		this.franquicia = registro.getFranquicia();
		this.email = registro.getEmail().trim();
		this.unidadgestora = registro.getUnidadgestora().trim();
		this.nombreoficina = registro.getNombreoficina().trim();
		this.nombreterritorio = registro.getNombreterritorio().trim();
		this.registrogestor = registro.getRegistrogestor().trim();
		this.nombregestor = registro.getNombregestor().trim();
		this.dealcliente = registro.getDealcliente().trim();
		this.fechafinfixing = Utils.stringtoCalendar(registro.getFechafinfixing().trim(), TimeFormat.DATEFORMAT2);
		this.fechastrike = Utils.stringtoCalendar(registro.getFechastrike().trim(), TimeFormat.DATEFORMAT2);
		this.indicadorautocall = registro.getIndicadorautocall().trim();
		this.fechaautocall = Utils.stringtoCalendar(registro.getFechaautocall().trim(), TimeFormat.DATEFORMAT2);
		this.porcapitalasegurado = registro.getPorcapitalasegurado();
		this.indsegmcliente = registro.getIndsegmcliente().trim();
		this.direccioncompleta = registro.getDireccioncompleta().trim();

	}

	public CampanaDeposito(String id) {
		super(id);
	}

	public CampanaDeposito() {
		super();
	}

	private String idCarga;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaproceso;

	@Size(max = 19)
	private String codigocampana;

	@Size(max = 30)
	private String nombrecampana;

	@Size(max = 4)
	private String nombrecortocampana;

	private Divisa divisa;

	@Column(precision = 20, scale = 6)
	private BigDecimal montototalcampana;

	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechainidepositoestructurado;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechainiopcion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechafinopcion;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechafindepositoestructurado;

	@Column(precision = 20, scale = 6)
	private BigDecimal tasauno;

	@Column(precision = 20, scale = 6)
	private BigDecimal tasaefecinttotaldepositoestruc;

	@Column(precision = 20, scale = 6)
	private BigDecimal tasados;

	@Column(precision = 20, scale = 6)
	private BigDecimal tasaefecintminpotencial;
	
	private Cliente cliente;
	
	@Size(max = 30)
	private String direccioncliente;
	
	@Size(max = 22)
	private String cuentaasociada;
	
	//private Oficina oficina;
	@Size(max = 4)
	private String numoficina;
	
	@Size(max = 22)
	private String cuentaplazoestructurado;
	
	@Column(precision = 20, scale = 6)
	private BigDecimal depositoimposicion;
	
	@Column(precision = 20, scale = 6)
	private BigDecimal primacliente;
	
	@Column(precision = 20, scale = 6)
	private BigDecimal importeintadelantadocliente;
	
	@Size(max = 30)
	private String nombreopcion;
	
	@Size(max = 3)
	private String tipoopcion;
	
	@Column(precision = 20, scale = 6)
	private BigDecimal costototalopcion;
	
	@Size(max = 20)
	private String subyacentefx;
	
	@Size(max = 20)
	private String subyacenteotros;
	
	@Size(max = 30)
	private String dealstar;
	
	@Column(precision = 20, scale = 6)
	private BigDecimal strike;

	@Column(precision = 20, scale = 6)
	private BigDecimal tminr;
	
	@Column(precision = 20, scale = 6)
	private BigDecimal tmaxr;
	
	@Column(precision = 20, scale = 6)
	private BigDecimal tasatres;
	
	@Column(precision = 20, scale = 6)
	private BigDecimal valornominalopcionpen;
	
	@Column(precision = 20, scale = 6)
	private BigDecimal valornominalopcionusd;
	
	@Column(precision = 20, scale = 6)
	private BigDecimal franquicia;
	
	@Size(max = 80)
	private String email;
	
	@Size(max = 6)
	private String unidadgestora;
	
	@Size(max = 40)
	private String nombreoficina;
	
	@Size(max = 40)
	private String nombreterritorio;
	
	@Size(max = 7)
	private String registrogestor;
	
	@Size(max = 90)
	private String nombregestor;
	
	@Size(max = 30)
	private String dealcliente;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechafinfixing;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechastrike;
	
	@Size(max = 1)
	private String indicadorautocall;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar fechaautocall;
	
	@Column(precision = 20, scale = 6)
	private BigDecimal porcapitalasegurado;
	
	@Size(max = 1)
	private String indsegmcliente;
	
	@Size(max = 72)
	private String direccioncompleta;

	@Size(max = 50)
	public String getIdCarga() {
		return idCarga;
	}

	public void setIdCarga(String idCarga) {
		this.idCarga = idCarga;
	}

	public Calendar getFechaproceso() {
		return fechaproceso;
	}

	public void setFechaproceso(Calendar fechaproceso) {
		this.fechaproceso = fechaproceso;
	}

	public String getCodigocampana() {
		return codigocampana;
	}

	public void setCodigocampana(String codigocampana) {
		this.codigocampana = codigocampana;
	}

	public String getNombrecampana() {
		return nombrecampana;
	}

	public void setNombrecampana(String nombrecampana) {
		this.nombrecampana = nombrecampana;
	}

	public String getNombrecortocampana() {
		return nombrecortocampana;
	}

	public void setNombrecortocampana(String nombrecortocampana) {
		this.nombrecortocampana = nombrecortocampana;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_divisa")
	public Divisa getDivisa() {
		return divisa;
	}

	public void setDivisa(Divisa divisa) {
		this.divisa = divisa;
	}

	public BigDecimal getMontototalcampana() {
		return montototalcampana;
	}

	public void setMontototalcampana(BigDecimal montototalcampana) {
		this.montototalcampana = montototalcampana;
	}

	public Calendar getFechainidepositoestructurado() {
		return fechainidepositoestructurado;
	}

	public void setFechainidepositoestructurado(Calendar fechainidepositoestructurado) {
		this.fechainidepositoestructurado = fechainidepositoestructurado;
	}

	public Calendar getFechainiopcion() {
		return fechainiopcion;
	}

	public void setFechainiopcion(Calendar fechainiopcion) {
		this.fechainiopcion = fechainiopcion;
	}

	public Calendar getFechafinopcion() {
		return fechafinopcion;
	}

	public void setFechafinopcion(Calendar fechafinopcion) {
		this.fechafinopcion = fechafinopcion;
	}

	public Calendar getFechafindepositoestructurado() {
		return fechafindepositoestructurado;
	}

	public void setFechafindepositoestructurado(Calendar fechafindepositoestructurado) {
		this.fechafindepositoestructurado = fechafindepositoestructurado;
	}

	public BigDecimal getTasauno() {
		return tasauno;
	}

	public void setTasauno(BigDecimal tasauno) {
		this.tasauno = tasauno;
	}

	public BigDecimal getTasaefecinttotaldepositoestruc() {
		return tasaefecinttotaldepositoestruc;
	}

	public void setTasaefecinttotaldepositoestruc(BigDecimal tasaefecinttotaldepositoestruc) {
		this.tasaefecinttotaldepositoestruc = tasaefecinttotaldepositoestruc;
	}

	public BigDecimal getTasados() {
		return tasados;
	}

	public void setTasados(BigDecimal tasados) {
		this.tasados = tasados;
	}

	public BigDecimal getTasaefecintminpotencial() {
		return tasaefecintminpotencial;
	}

	public void setTasaefecintminpotencial(BigDecimal tasaefecintminpotencial) {
		this.tasaefecintminpotencial = tasaefecintminpotencial;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_cliente")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDireccioncliente() {
		return direccioncliente;
	}

	public void setDireccioncliente(String direccioncliente) {
		this.direccioncliente = direccioncliente;
	}

	public String getCuentaasociada() {
		return cuentaasociada;
	}

	public void setCuentaasociada(String cuentaasociada) {
		this.cuentaasociada = cuentaasociada;
	}

	public String getNumoficina() {
		return numoficina;
	}

	public void setNumoficina(String numoficina) {
		this.numoficina = numoficina;
	}

	public String getCuentaplazoestructurado() {
		return cuentaplazoestructurado;
	}

	public void setCuentaplazoestructurado(String cuentaplazoestructurado) {
		this.cuentaplazoestructurado = cuentaplazoestructurado;
	}

	public BigDecimal getDepositoimposicion() {
		return depositoimposicion;
	}

	public void setDepositoimposicion(BigDecimal depositoimposicion) {
		this.depositoimposicion = depositoimposicion;
	}

	public BigDecimal getPrimacliente() {
		return primacliente;
	}

	public void setPrimacliente(BigDecimal primacliente) {
		this.primacliente = primacliente;
	}

	public BigDecimal getImporteintadelantadocliente() {
		return importeintadelantadocliente;
	}

	public void setImporteintadelantadocliente(BigDecimal importeintadelantadocliente) {
		this.importeintadelantadocliente = importeintadelantadocliente;
	}

	public String getNombreopcion() {
		return nombreopcion;
	}

	public void setNombreopcion(String nombreopcion) {
		this.nombreopcion = nombreopcion;
	}

	public String getTipoopcion() {
		return tipoopcion;
	}

	public void setTipoopcion(String tipoopcion) {
		this.tipoopcion = tipoopcion;
	}

	public BigDecimal getCostototalopcion() {
		return costototalopcion;
	}

	public void setCostototalopcion(BigDecimal costototalopcion) {
		this.costototalopcion = costototalopcion;
	}

	public String getSubyacentefx() {
		return subyacentefx;
	}

	public void setSubyacentefx(String subyacentefx) {
		this.subyacentefx = subyacentefx;
	}

	public String getSubyacenteotros() {
		return subyacenteotros;
	}

	public void setSubyacenteotros(String subyacenteotros) {
		this.subyacenteotros = subyacenteotros;
	}

	public String getDealstar() {
		return dealstar;
	}

	public void setDealstar(String dealstar) {
		this.dealstar = dealstar;
	}

	public BigDecimal getStrike() {
		return strike;
	}

	public void setStrike(BigDecimal strike) {
		this.strike = strike;
	}

	public BigDecimal getTminr() {
		return tminr;
	}

	public void setTminr(BigDecimal tminr) {
		this.tminr = tminr;
	}

	public BigDecimal getTmaxr() {
		return tmaxr;
	}

	public void setTmaxr(BigDecimal tmaxr) {
		this.tmaxr = tmaxr;
	}

	public BigDecimal getTasatres() {
		return tasatres;
	}

	public void setTasatres(BigDecimal tasatres) {
		this.tasatres = tasatres;
	}

	public BigDecimal getValornominalopcionpen() {
		return valornominalopcionpen;
	}

	public void setValornominalopcionpen(BigDecimal valornominalopcionpen) {
		this.valornominalopcionpen = valornominalopcionpen;
	}

	public BigDecimal getValornominalopcionusd() {
		return valornominalopcionusd;
	}

	public void setValornominalopcionusd(BigDecimal valornominalopcionusd) {
		this.valornominalopcionusd = valornominalopcionusd;
	}

	public BigDecimal getFranquicia() {
		return franquicia;
	}

	public void setFranquicia(BigDecimal franquicia) {
		this.franquicia = franquicia;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUnidadgestora() {
		return unidadgestora;
	}

	public void setUnidadgestora(String unidadgestora) {
		this.unidadgestora = unidadgestora;
	}

	public String getNombreoficina() {
		return nombreoficina;
	}

	public void setNombreoficina(String nombreoficina) {
		this.nombreoficina = nombreoficina;
	}

	public String getNombreterritorio() {
		return nombreterritorio;
	}

	public void setNombreterritorio(String nombreterritorio) {
		this.nombreterritorio = nombreterritorio;
	}

	public String getRegistrogestor() {
		return registrogestor;
	}

	public void setRegistrogestor(String registrogestor) {
		this.registrogestor = registrogestor;
	}

	public String getNombregestor() {
		return nombregestor;
	}

	public void setNombregestor(String nombregestor) {
		this.nombregestor = nombregestor;
	}

	public String getDealcliente() {
		return dealcliente;
	}

	public void setDealcliente(String dealcliente) {
		this.dealcliente = dealcliente;
	}

	public Calendar getFechafinfixing() {
		return fechafinfixing;
	}

	public void setFechafinfixing(Calendar fechafinfixing) {
		this.fechafinfixing = fechafinfixing;
	}

	public Calendar getFechastrike() {
		return fechastrike;
	}

	public void setFechastrike(Calendar fechastrike) {
		this.fechastrike = fechastrike;
	}

	public String getIndicadorautocall() {
		return indicadorautocall;
	}

	public void setIndicadorautocall(String indicadorautocall) {
		this.indicadorautocall = indicadorautocall;
	}

	public Calendar getFechaautocall() {
		return fechaautocall;
	}

	public void setFechaautocall(Calendar fechaautocall) {
		this.fechaautocall = fechaautocall;
	}

	public BigDecimal getPorcapitalasegurado() {
		return porcapitalasegurado;
	}

	public void setPorcapitalasegurado(BigDecimal porcapitalasegurado) {
		this.porcapitalasegurado = porcapitalasegurado;
	}

	public String getIndsegmcliente() {
		return indsegmcliente;
	}

	public void setIndsegmcliente(String indsegmcliente) {
		this.indsegmcliente = indsegmcliente;
	}

	public String getDireccioncompleta() {
		return direccioncompleta;
	}

	public void setDireccioncompleta(String direccioncompleta) {
		this.direccioncompleta = direccioncompleta;
	}

}
