package pe.grupobbva.alcon.mantenimiento.dto.process;

import java.math.BigDecimal;
import java.util.Calendar;

import lombok.Data;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;

public @Data class CampanaDepositoCargaType extends AbstractType {

	public CampanaDepositoCargaType(Carga carga, Long rownum, String row) {

		super();

		this.idCarga = carga.getId();
		this.fechaproceso = carga.getFecha();
		this.codigocampana = row.substring(0, 19);
		this.nombrecampana = row.substring(19, 49);
		this.nombrecortocampana = row.substring(49, 53);
		this.codigodivisa = row.substring(53, 57);
		this.montototalcampana = (new BigDecimal(row.substring(57, 74))).divide(BigDecimal.valueOf(100));
		this.fechainidepositoestructurado = row.substring(74, 84);
		this.fechainiopcion = row.substring(84, 94);
		this.fechafinopcion = row.substring(94, 104);
		this.fechafindepositoestructurado = row.substring(104, 114);
		this.tasauno = (new BigDecimal(row.substring(114, 120))).divide(BigDecimal.valueOf(1000));
		this.tasaefecinttotaldepositoestruc = (new BigDecimal(row.substring(120, 126))).divide(BigDecimal.valueOf(1000));
		this.tasados = (new BigDecimal(row.substring(126, 132))).divide(BigDecimal.valueOf(1000));
		this.tasaefecintminpotencial = (new BigDecimal(row.substring(132, 138))).divide(BigDecimal.valueOf(1000));
		this.codigoaltamiracliente = row.substring(138, 148);
		this.nombrecliente = row.substring(148, 178);
		this.tipodocumento = row.substring(178, 181);
		this.nrodocumento = row.substring(181, 193);
		this.direccioncliente = row.substring(193, 223);
		this.paiscliente = row.substring(223, 226);
		this.cuentaasociada = row.substring(226, 248);
		this.numoficina = row.substring(248, 252);
		this.cuentaplazoestructurado = row.substring(252, 274);
		this.depositoimposicion = (new BigDecimal(row.substring(274, 289))).divide(BigDecimal.valueOf(100));
		this.primacliente = (new BigDecimal(row.substring(289, 296))).divide(BigDecimal.valueOf(10000));
		this.importeintadelantadocliente = (new BigDecimal(row.substring(296, 311))).divide(BigDecimal.valueOf(100));
		this.nombreopcion = row.substring(311, 341);
		this.tipoopcion = row.substring(341, 344);
		this.costototalopcion = (new BigDecimal(row.substring(344, 362))).divide(BigDecimal.valueOf(10000));
		this.subyacentefx = row.substring(362, 382);
		this.subyacenteotros = row.substring(382, 402);
		this.dealstar = row.substring(402, 432);
		this.strike = (new BigDecimal(row.substring(432, 450))).divide(BigDecimal.valueOf(10000));
		this.tminr = (new BigDecimal(row.substring(450, 468))).divide(BigDecimal.valueOf(10000));
		this.tmaxr = (new BigDecimal(row.substring(468, 486))).divide(BigDecimal.valueOf(10000));
		this.tasatres = new BigDecimal(row.substring(486, 500));
		this.valornominalopcionpen = (new BigDecimal(row.substring(500, 518))).divide(BigDecimal.valueOf(10000));
		this.valornominalopcionusd = (new BigDecimal(row.substring(518, 536))).divide(BigDecimal.valueOf(10000));
		this.franquicia = (new BigDecimal(row.substring(536, 550))).divide(BigDecimal.valueOf(100));
		this.email = row.substring(550, 630);
		this.unidadgestora = row.substring(630, 636);
		this.nombreoficina = row.substring(636, 676);
		this.nombreterritorio = row.substring(676, 716);
		this.registrogestor = row.substring(716, 723);
		this.nombregestor = row.substring(723, 813);
		this.dealcliente = row.substring(813, 843);
		this.fechafinfixing = row.substring(843, 853);
		this.fechastrike = row.substring(853, 863);
		this.indicadorautocall = row.substring(863, 864);
		this.fechaautocall = row.substring(864, 874);
		this.porcapitalasegurado = (new BigDecimal(row.substring(874, 879))).divide(BigDecimal.valueOf(100));
		this.indsegmcliente = row.substring(879, 880);
		this.direccioncompleta = row.substring(880, 952);

		this.row = row;

	}

	private String idCarga;
	private Calendar fechaproceso;
	private String codigocampana;
	private String nombrecampana;
	private String nombrecortocampana;
	private String codigodivisa;
	private BigDecimal montototalcampana;
	private String fechainidepositoestructurado;
	private String fechainiopcion;
	private String fechafinopcion;
	private String fechafindepositoestructurado;
	private BigDecimal tasauno;
	private BigDecimal tasaefecinttotaldepositoestruc;
	private BigDecimal tasados;
	private BigDecimal tasaefecintminpotencial;
	private String codigoaltamiracliente;
	private String nombrecliente;
	private String tipodocumento;
	private String nrodocumento;
	private String direccioncliente;
	private String paiscliente;
	private String cuentaasociada;
	private String numoficina;
	private String cuentaplazoestructurado;
	private BigDecimal depositoimposicion;
	private BigDecimal primacliente;
	private BigDecimal importeintadelantadocliente;
	private String nombreopcion;
	private String tipoopcion;
	private BigDecimal costototalopcion;
	private String subyacentefx;
	private String subyacenteotros;
	private String dealstar;
	private BigDecimal strike;
	private BigDecimal tminr;
	private BigDecimal tmaxr;
	private BigDecimal tasatres;
	private BigDecimal valornominalopcionpen;
	private BigDecimal valornominalopcionusd;
	private BigDecimal franquicia;
	private String email;
	private String unidadgestora;
	private String nombreoficina;
	private String nombreterritorio;
	private String registrogestor;
	private String nombregestor;
	private String dealcliente;
	private String fechafinfixing;
	private String fechastrike;
	private String indicadorautocall;
	private String fechaautocall;
	private BigDecimal porcapitalasegurado;
	private String indsegmcliente;
	private String direccioncompleta;
	private String row;

}
