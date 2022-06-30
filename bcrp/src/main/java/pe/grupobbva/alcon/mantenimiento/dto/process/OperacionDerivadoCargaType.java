package pe.grupobbva.alcon.mantenimiento.dto.process;

import lombok.Data;
import pe.grupobbva.alcon.core.beans.TimeFormat;
import pe.grupobbva.alcon.core.utils.Utils;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.TipoProceso;

public @Data class OperacionDerivadoCargaType extends AbstractType {

	public OperacionDerivadoCargaType(Carga carga, Long rownum, String[] cells) {
		super();

		this.idcarga = carga.getId();
		this.idfilaarchivo = rownum.intValue();
		
		this.fechacarga = Utils.calendartoString(carga.getFecha(), TimeFormat.TIMESTAMPFORMAT);
		this.tipoproceso = TipoProceso.valueOf(carga.getTipoproceso());
		
		this.fechareporte = cells[0].trim();
		this.numerooperacion = cells[1].trim();
		this.codigodiva = cells[2].trim();
		this.producto = cells[3].trim();
		this.tipooperacion = cells[4].trim();
		this.codigocliente = cells[5].trim();
		this.nombrecliente = cells[6].trim();
		this.importeusd = cells[7].trim();
		this.divisa = cells[8].trim();
		this.importedivisa = cells[9].trim();
		this.fechaefectiva = cells[10].trim();
		this.fechatermino = cells[11].trim();
		this.tipoentrega = cells[12].trim();
		this.callput = cells[13].trim();
		this.estilo = cells[14].trim();
		this.strikerate = cells[15].trim();
		this.benchmark = cells[16].trim();
		this.tiposubyacente = cells[17].trim();
		this.descripcionsubyacente = cells[18].trim();
		this.preciopactado = cells[19].trim();
		this.commoditytamanocontratounid = cells[20].trim();
		this.commoditytamanounidmedida = cells[21].trim();
		this.benchmarkfrecuencia = cells[22].trim();
		this.volatilidad = cells[23].trim();
		this.prima = cells[24].trim();
		this.delta = cells[25].trim();
		this.intencioncontratacion = cells[26].trim();
		this.tipoaccion = cells[27].trim();
		this.observacion = cells[28].trim();

	}
	
	
	@Override
	public Boolean validar() {
		return fechareporte.equals(fechacarga.substring(0, 10));
	}

	private String idcarga;
	private Integer idfilaarchivo;
	private String fechacarga;
	private TipoProceso tipoproceso;
	
	private String fechareporte;
	private String numerooperacion;
	private String codigodiva;
	private String producto;
	private String tipooperacion;
	private String codigocliente;
	private String nombrecliente;
	private String importeusd;
	private String divisa;
	private String importedivisa;

	
	private String fechaefectiva;
	private String fechatermino;
	private String tipoentrega;
	
	private String callput;
	private String estilo;
	private String strikerate;
	private String benchmark;
	private String benchmarkfrecuencia;
	private String tiposubyacente;
	private String descripcionsubyacente;
	private String preciopactado;
	private String commoditytamanocontratounid;
	private String commoditytamanounidmedida;
	private String volatilidad;
	private String prima;
	private String delta;
	private String intencioncontratacion;
	private String tipoaccion;
	private String observacion;

}
