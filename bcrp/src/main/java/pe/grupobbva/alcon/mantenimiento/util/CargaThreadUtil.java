package pe.grupobbva.alcon.mantenimiento.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import pe.grupobbva.alcon.mantenimiento.entity.Carga;
import pe.grupobbva.alcon.mantenimiento.entity.Ejecutado;
import pe.grupobbva.alcon.mantenimiento.entity.TipoCarga;
import pe.grupobbva.alcon.mantenimiento.service.CargaService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaCalculoTasasService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaCampanaDepositoService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaDeltaService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaEUService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaInfoReportDerivadoService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaInforReportDiarioService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaSaldoContableService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaTasaCurvaService;
import pe.grupobbva.alcon.mantenimiento.service.process.CargaTipoCambioService;
import pe.grupobbva.alcon.mantenimiento.service.process.impl.CargaInforReportDiarioServiceImpl;

@Component
@Scope("prototype")
//@Transactional
public class CargaThreadUtil implements Runnable {

	private static final Logger log = LogManager.getLogger();

	@Autowired
	private CargaInforReportDiarioService cargaInforReportDiarioService;

	@Autowired
	private CargaSaldoContableService cargaSaldoContableService;

	@Autowired
	private CargaTipoCambioService tipoCambioContableService;

	@Autowired
	private CargaCalculoTasasService cargaCalculoTasasService;

	@Autowired
	private CargaEUService cargaEUService;

	@Autowired
	private CargaDeltaService cargaDeltaService;
	
	@Autowired
	private CargaInfoReportDerivadoService cargaInfoReportDerivadoService;
	
	@Autowired
	private CargaCampanaDepositoService cargaCampanaDepositoService;
	
	@Autowired
	private CargaTasaCurvaService cargaTasaCurvaService;

	private Integer opcionTipoCarga;

	private InputStream file;

	@Autowired
	private CargaService cargaService;

	private String cargaId;

	private String filename;

	public void load(Integer opcionTipoCarga, InputStream file, String filename, String cargaId) {
		this.cargaId = cargaId;
		this.file = file;
		this.filename = filename;
		this.opcionTipoCarga = opcionTipoCarga;
	}

	@Override
	public void run() {

		Carga carga = cargaService.buscarId(cargaId);
		
		try {

			if (opcionTipoCarga.equals(TipoCarga.SALDOSCONTABLES.getNumeroTipoCarga())) {

				InputStream fileClone = clone(file);

				cargaSaldoContableService.procesarCarga(carga, file, filename, opcionTipoCarga);
				tipoCambioContableService.procesarCarga(carga, fileClone, filename, opcionTipoCarga);

			} else if (opcionTipoCarga.equals(TipoCarga.INFOREPORTDIARIO.getNumeroTipoCarga())
					|| opcionTipoCarga.equals(TipoCarga.INFOREPORTIRC.getNumeroTipoCarga())
					|| opcionTipoCarga.equals(TipoCarga.INFOREPORTDIARIOSPECTRUM.getNumeroTipoCarga())
					|| opcionTipoCarga.equals(TipoCarga.INFOREPORTEXTRANJERO.getNumeroTipoCarga())
					|| opcionTipoCarga.equals(TipoCarga.INFOREPORTOTFX.getNumeroTipoCarga())
					|| opcionTipoCarga.equals(TipoCarga.INFOREPORTASASMX.getNumeroTipoCarga())) {

				cargaInforReportDiarioService.procesarCarga(carga, file, filename, opcionTipoCarga);

			} else if (opcionTipoCarga.equals(TipoCarga.TASAS.getNumeroTipoCarga())) {
				cargaCalculoTasasService.procesarCarga(carga, file, filename, opcionTipoCarga);

			} else if (opcionTipoCarga.equals(TipoCarga.EU.getNumeroTipoCarga())) {
				cargaEUService.procesarCarga(carga, file, filename, opcionTipoCarga);
			} else if (opcionTipoCarga.equals(TipoCarga.DELTA.getNumeroTipoCarga())) {
				cargaDeltaService.procesarCarga(carga, file, filename, opcionTipoCarga);
			} else if (
					opcionTipoCarga.equals(TipoCarga.INFOREPORTDERIVADO.getNumeroTipoCarga())
					|| opcionTipoCarga.equals(TipoCarga.INFOREPORTDIVAS.getNumeroTipoCarga())
					) {
				cargaInfoReportDerivadoService.procesarCarga(carga, file, filename, opcionTipoCarga);
			} else if (opcionTipoCarga.equals(TipoCarga.BACKOFFICE.getNumeroTipoCarga())) {
				cargaCampanaDepositoService.procesarCarga(carga, file, filename, opcionTipoCarga);
			} else if (opcionTipoCarga.equals(TipoCarga.TASASCURVAS.getNumeroTipoCarga())) {
				cargaTasaCurvaService.procesarCarga(carga, file, filename, opcionTipoCarga);
			}

		} catch (Exception e) {
			log.error("Error", e);
		} finally {
			DateFormat dateFormat = new SimpleDateFormat("hh:mm a");
			carga.setEjecutado(Ejecutado.S.name());
			carga.setHorafin(dateFormat.format(Calendar.getInstance().getTime()));
			if(CargaInforReportDiarioServiceImpl.MENSAJE_PROCESANDO.equalsIgnoreCase(carga.getNotaerror())) {
				carga.setNotaerror(null);
			}
			
			
			cargaService.guardar(carga);
		}

	}

	public static InputStream clone(final InputStream inputStream) {
		try {
			inputStream.mark(0);
			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			byte[] buffer = new byte[1024];
			int readLength = 0;
			while ((readLength = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, readLength);
			}
			inputStream.reset();
			outputStream.flush();
			return new ByteArrayInputStream(outputStream.toByteArray());
		} catch (Exception e) {
			log.error("Error", e);
		}
		return null;
	}

}
