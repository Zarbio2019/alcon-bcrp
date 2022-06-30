package pe.grupobbva.alcon.mantenimiento.entity;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

//@Entity
//@Table(name = "CampanaDepositoCarga")
public class CampanaDepositoCarga extends AbstractEntity {
	
	@Size(max = 19)
	private String codigocampana;
	
	@Size(max = 30)
	private String nombrecampana;
	
	@Size(max = 4)
	private String nombrecortocampana;
	
	@Size(max = 4)
	private String codigodivisacampana;
	
	@Size(max = 17)
	private BigDecimal montototalcampana;
	
	@Size(max = 10)
	private Calendar fechainidepositoestructurado;
	
	@Size(max = 10)
	private Calendar fechainiopcion;
	
	@Size(max = 10)
	private Calendar fechafinopcion;
	
	@Size(max = 10)
	private Calendar fechafindepositoestructurado;
	
	@Size(max = 6)
	private String tasauno;
	
	@Size(max = 6)
	private String tasaefecinttotaldepositoestruc;
	
	@Size(max = 6)
	private String tasados;
	
	@Size(max = 6)
	private String tasaefecintminpotencial;
	
	@Size(max = 10)
	private String codigocliente;
	
	@Size(max = 30)
	private String nombrecliente;
	
	@Size(max = 3)
	private String tipodocumento;
	
	@Size(max = 12)
	private BigDecimal numerodocumento;
	
	@Size(max = 30)
	private String direccioncliente;
	
	@Size(max = 3)
	private String paiscliente;
	
	@Size(max = 22)
	private String cuentaasociada;
	
	@Size(max = 4)
	private String numerooficina;
	
	@Size(max = 22)
	private String cuentaplazoestructurado;
	
	@Size(max = 15)
	private String depositoimposicion;
	
	@Size(max = 7)
	private String primacliente;
	
	@Size(max = 15)
	private String importeintadelantadocliente;
	
	@Size(max = 30)
	private String nombreopcion;
	
	@Size(max = 3)
	private String tipoopcion;
	
	@Size(max = 18)
	private String costototalopcion;
	
	@Size(max = 20)
	private String subyacentefx;
	
	@Size(max = 20)
	private String subyacenteotros;
	
	@Size(max = 30)
	private String dealstar;
	
	@Size(max = 18)
	private BigDecimal strike;
	
	@Size(max = 20)
	private String tminr;
	
	@Size(max = 20)
	private String tmaxr;
	
	@Size(max = 30)
	private String tasatres;
	
	@Size(max = 18)
	private String valornominalopcionpen;
	
	@Size(max = 18)
	private String valornominalopcionusd;
	
	@Size(max = 14)
	private String franquicia;
	
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
	
	@Size(max = 10)
	private String fechafinfixing;
	
	@Size(max = 10)
	private String fechastrike;
	
	@Size(max = 1)
	private String indicadorautocall;
	
	@Size(max = 10)
	private String fechaautocall;
	
	@Size(max = 5)
	private BigDecimal porcapitalasegurado;
	
	@Size(max = 1)
	private String indsegmcliente;
	
	@Size(max = 72)
	private String direccioncompleta;
	
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
	
	public String getCodigodivisacampana() {
		return codigodivisacampana;
	}

	public void setCodigodivisacampana(String codigodivisacampana) {
		this.codigodivisacampana = codigodivisacampana;
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
	
	public String getTasauno() {
		return tasauno;
	}

	public void setTasauno(String tasauno) {
		this.tasauno = tasauno;
	}

	public String getTasaefecinttotaldepositoestruc() {
		return tasaefecinttotaldepositoestruc;
	}

	public void setTasaefecinttotaldepositoestruc(String tasaefecinttotaldepositoestruc) {
		this.tasaefecinttotaldepositoestruc = tasaefecinttotaldepositoestruc;
	}
	
	public String getTasados() {
		return tasados;
	}

	public void setTasados(String tasados) {
		this.tasados = tasados;
	}

	public String getTasaefecintminpotencial() {
		return tasaefecintminpotencial;
	}

	public void setTasaefecintminpotencial(String tasaefecintminpotencial) {
		this.tasaefecintminpotencial = tasaefecintminpotencial;
	}
	
	public String getCodigocliente() {
		return codigocliente;
	}

	public void setCodigocliente(String codigocliente) {
		this.codigocliente = codigocliente;
	}

	public String getNombrecliente() {
		return nombrecliente;
	}
	
	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}
	
	public String getTipodocumento() {
		return tipodocumento;
	}
	
	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}
	
	public BigDecimal getNumerodocumento() {
		return numerodocumento;
	}
	
	public void setNumerodocumento(BigDecimal numerodocumento) {
		this.numerodocumento = numerodocumento;
	}
	
	public String getDireccioncliente() {
		return direccioncliente;
	}
	
	public void setDireccioncliente(String direccioncliente) {
		this.direccioncliente = direccioncliente;
	}
	
	public String getPaiscliente() {
		return paiscliente;
	}
	
	public void setPaiscliente(String paiscliente) {
		this.paiscliente = paiscliente;
	}
	
	public String getCuentaasociada() {
		return cuentaasociada;
	}
	
	public void setCuentaasociada(String cuentaasociada) {
		this.cuentaasociada = cuentaasociada;
	}
	
	public String getNumerooficina() {
		return numerooficina;
	}
	
	public void setNumerooficina(String numerooficina) {
		this.numerooficina = numerooficina;
	}
	
	public String getCuentaplazoestructurado() {
		return cuentaplazoestructurado;
	}
	
	public void setCuentaplazoestructurado(String cuentaplazoestructurado) {
		this.cuentaplazoestructurado = cuentaplazoestructurado;
	}
	
	public String getDepositoimposicion() {
		return depositoimposicion;
	}

	public void setDepositoimposicion(String depositoimposicion) {
		this.depositoimposicion = depositoimposicion;
	}
	
	public String getPrimacliente() {
		return primacliente;
	}

	public void setPrimacliente(String primacliente) {
		this.primacliente = primacliente;
	}
	
	public String getImporteintadelantadocliente() {
		return importeintadelantadocliente;
	}

	public void setImporteintadelantadocliente(String importeintadelantadocliente) {
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
	
	public String getCostototalopcion() {
		return costototalopcion;
	}

	public void setCostototalopcion(String costototalopcion) {
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
	
	public String getTminr() {
		return tminr;
	}

	public void setTminr(String tminr) {
		this.tminr = tminr;
	}


	public String getTmaxr() {
		return tmaxr;
	}

	public void setTmaxr(String tmaxr) {
		this.tmaxr = tmaxr;
	}

	public String getTasatres() {
		return tasatres;
	}

	public void setTasatres(String tasatres) {
		this.tasatres = tasatres;
	}


	public String getValornominalopcionpen() {
		return valornominalopcionpen;
	}

	public void setValornominalopcionpen(String valornominalopcionpen) {
		this.valornominalopcionpen = valornominalopcionpen;
	}

	public String getValornominalopcionusd() {
		return valornominalopcionusd;
	}

	public void setValornominalopcionusd(String valornominalopcionusd) {
		this.valornominalopcionusd = valornominalopcionusd;
	}

	public String getFranquicia() {
		return franquicia;
	}
	
	public void setFranquicia(String franquicia) {
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
	
	public String getFechafinfixing() {
		return fechafinfixing;
	}
	
	public void setFechafinfixing(String fechafinfixing) {
		this.fechafinfixing = fechafinfixing;
	}
	
	public String getFechastrike() {
		return fechastrike;
	}

	public void setFechastrike(String fechastrike) {
		this.fechastrike = fechastrike;
	}

	public String getIndicadorautocall() {
		return indicadorautocall;
	}

	public void setIndicadorautocall(String indicadorautocall) {
		this.indicadorautocall = indicadorautocall;
	}

	public String getFechaautocall() {
		return fechaautocall;
	}
	
	public void setFechaautocall(String fechaautocall) {
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
