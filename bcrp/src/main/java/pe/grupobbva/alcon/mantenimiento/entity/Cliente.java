package pe.grupobbva.alcon.mantenimiento.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cliente")
public class Cliente extends AbstractEntity {

	private static final long serialVersionUID = -2881063822755102379L;
	
	public Cliente(String id) {
		super(id);
	}
	
	public Cliente() {
		super();
	}
	

	private String codigo;
	

	private String nombre;
	
	@Size(max = 20)
	private String entidad;
	
	@Size(max = 2)
	private String paisresidencia;
	
	@Size(max = 2)
	private String riesgopais;
	
	@Size(max = 20)
	private String altamira;
	
	@Size(max = 30)
	private String plaza;
	
	@Size(max = 5)
	private String sector;
	
	@Size(max = 20)
	private String nombrecorto;
	
	@Size(max = 30)
	private String rechazarcarga;

	private String tipocliente;
	
	private Integer tipodocumento;
	
	@Size(max = 20)
	private String numerodocumento;
	
	@Size(max = 11)
	private String codigoswift;


	@Size(max = 20)
	@NotNull
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Size(max = 100)
	@NotNull
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getPaisresidencia() {
		return paisresidencia;
	}

	public void setPaisresidencia(String paisresidencia) {
		this.paisresidencia = paisresidencia;
	}

	public String getRiesgopais() {
		return riesgopais;
	}

	public void setRiesgopais(String riesgopais) {
		this.riesgopais = riesgopais;
	}

	public String getAltamira() {
		return altamira;
	}

	public void setAltamira(String altamira) {
		this.altamira = altamira;
	}

	public String getPlaza() {
		return plaza;
	}

	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getNombrecorto() {
		return nombrecorto;
	}

	public void setNombrecorto(String nombrecorto) {
		this.nombrecorto = nombrecorto;
	}

	public String getRechazarcarga() {
		return rechazarcarga;
	}

	public void setRechazarcarga(String rechazarcarga) {
		this.rechazarcarga = rechazarcarga;
	}
	
	@Size(max = 30)
	@NotNull
	public String getTipocliente() {
		return tipocliente;
	}

	public void setTipocliente(String tipocliente) {
		this.tipocliente = tipocliente;
	}
	
	public Integer getTipodocumento() {
		return tipodocumento;
	}

	public void setTipodocumento(Integer tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	public String getNumerodocumento() {
		return numerodocumento;
	}

	public void setNumerodocumento(String numerodocumento) {
		this.numerodocumento = numerodocumento;
	}

	public String getCodigoswift() {
		return codigoswift;
	}

	public void setCodigoswift(String codigoswift) {
		this.codigoswift = codigoswift;
	}

}
