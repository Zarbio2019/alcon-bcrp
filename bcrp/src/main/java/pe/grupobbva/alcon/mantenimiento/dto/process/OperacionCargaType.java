package pe.grupobbva.alcon.mantenimiento.dto.process;

import java.text.SimpleDateFormat;

import lombok.Data;
import pe.grupobbva.alcon.core.beans.TimeFormat;
import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCarga;
import pe.grupobbva.alcon.mantenimiento.entity.TipoProceso;

public @Data class OperacionCargaType extends AbstractType {

	private static final String PRODUCTOIRD = "IRD";

	public OperacionCargaType(Carga carga, Long rownum, String[] cells) {
		super();

		this.codigoproducto = cells[1].trim();

//		if (!cells[1].trim().equals(PRODUCTOIRD)) {

		this.idcarga = carga.getId();

		//new SimpleDateFormat("dd/MM/yyyy");
		this.fechacarga = Utils.calendartoString(carga.getFecha(), TimeFormat.TIMESTAMPFORMAT);
		this.tipoproceso = TipoProceso.valueOf(carga.getTipoproceso());
		this.idfilaarchivo = rownum.intValue();
		this.fechacontratacion = cells[0].trim();
		this.producto = cells[1].trim();
		this.numerooperacion = cells[2].trim();
		this.codigocliente = cells[3].trim();
		this.nombrecliente = cells[4].trim();
		this.tipooperacion = cells[5].trim();
		this.divisaentrada = cells[6].trim();
		this.divisasalida = cells[7].trim();
		this.importedivisaentrada = cells[8].trim();
		this.importedivisasalida = cells[9].trim();
		this.cotizacion = cells[10].trim();
		this.puntosswap = cells[11].trim();
		this.basica = cells[12].trim();
		this.cambioref = cells[13].trim();
		this.fechavalor = cells[14].trim();
		this.fechavencimiento = cells[15].trim();
		this.plazo = cells[16].trim();
		this.fechaejercicio = cells[17].trim();
		this.callput = cells[18].trim();
		this.plaza = cells[19].trim();
		this.paisresidencia = cells[20].trim();
		this.paisriesgo = cells[21].trim();
		this.prima = cells[22].trim();
		this.divisaprima = cells[23].trim();
		this.observacioncarga = cells[24].trim();
		this.basicaauxiliar = cells[25].trim();
		this.fechaalta = cells[26].trim();
		this.fechamodificacioncarga = cells[27].trim();
		this.operacionsustituye = cells[28].trim();
		this.fechabaja = cells[29].trim();
		this.nif = cells[30].trim();
		this.intermediario = cells[31].trim();
		this.intermediariodescripcion = cells[32].trim();
		this.usuario = cells[33].trim();
		this.nombreusuario = cells[34].trim();
		this.estado = cells[35].trim();

		if (Integer.valueOf(carga.getTipocarga()).equals(TipoCarga.INFOREPORTDIARIO.getNumeroTipoCarga())) {
			this.tipooperacionauxiliar = cells[36].trim();
			this.fechafixing = cells[37].trim();
		}

		if (cells.length > 41 && Integer.valueOf(carga.getTipocarga()).equals(TipoCarga.INFOREPORTIRC.getNumeroTipoCarga())) {
			this.recibetasafijaspread = cells[41].trim();
			this.recibetfija = cells[42].trim();
			this.recibeidentificadorfrecuencia = cells[43].trim();
			this.pagatasafijaspread = cells[44].trim();
			this.pagatfija = cells[45].trim();
			this.pagaidentificadorfrecuencia = cells[46].trim();
		}
		
//		}
	}

//	@Override
//	public Boolean validar() {
//		return !codigoproducto.trim().equals(PRODUCTOIRD);
//	}

	private String codigoproducto;

	private String idcarga;

	private String fechacarga;
	private String fechacontratacion;
	private String producto;
	private String numerooperacion;
	private String codigocliente;
	private String nombrecliente;
	private String tipooperacion;
	private String divisaentrada;
	private String divisasalida;
	private String importedivisaentrada;
	private String importedivisasalida;
	private String cotizacion;
	private String puntosswap;
	private String basica;
	private String cambioref;
	private String fechavalor;
	private String fechavencimiento;
	private String plazo;
	private String fechaejercicio;
	private String callput;
	private String plaza;
	private String paisresidencia;
	private String paisriesgo;
	private String prima;
	private String divisaprima;
	private String observacioncarga;
	private String fechaalta;
	private String fechamodificacioncarga;
	private String operacionsustituye;
	private String fechabaja;
	private String nif;
	private String intermediario;
	private String intermediariodescripcion;
	private String usuario;
	private String nombreusuario;
	private String estado;
	private String fechafixing;
	private String tasapen;
	private String tasausd;
	private String delta;
	private String basicaauxiliar;
	private String tipooperacionauxiliar;
	private String mensajeerror;
	private Integer idfilaarchivo;
	private TipoProceso tipoproceso;

	// cambio nueva circular 0002-2020
	private String recibetasafijaspread;
	private String recibetfija;
	private String recibeidentificadorfrecuencia;
	private String pagatasafijaspread;
	private String pagatfija;
	private String pagaidentificadorfrecuencia;

}