package pe.grupobbva.alcon.mantenimiento.service.process.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import pe.grupobbva.alcon.mantenimiento.dto.process.AbstractType;
import pe.grupobbva.alcon.mantenimiento.dto.process.FilaEstado;
import pe.grupobbva.alcon.mantenimiento.dto.process.FilaEstado.FilaEstadoEnum;
import pe.grupobbva.alcon.mantenimiento.dto.process.TipoArchivo;
import pe.grupobbva.alcon.mantenimiento.entity.Carga;

public class GenericReader<T extends AbstractType> {

	private static final Logger log = LogManager.getLogger();

	private Class<T> clazz;

	public GenericReader(Class<T> clazz) {
		this.clazz = clazz;
	}

	/*
	 * public void read(Carga carga, MultipartFile file, List<T> registros,
	 * Map<String, FilaEstado> errores) { try { read(carga, file.getInputStream(),
	 * file.getOriginalFilename(), registros, errores); } catch (IOException e) {
	 * log.error("failed!",e); }
	 * 
	 * 
	 * }
	 */

	public void read(Carga carga, InputStream file, String originalName, List<T> registros,
			Map<String, FilaEstado> errores) {
		if (registros == null) {
			registros = new ArrayList<>();
		}
		if (errores == null) {
			errores = new HashMap<>();
		}

		Map<String, T> registrosMap = new HashMap<>();

		String[] words = originalName.split("\\.");
		String extension = words[words.length - 1];

		try {
			if (TipoArchivo.XLS.getExtension().equalsIgnoreCase(extension)
					|| TipoArchivo.XLSX.getExtension().equalsIgnoreCase(extension)) {
				readExcel(carga, file, registrosMap, errores);
			} else if (TipoArchivo.CSV.getExtension().equalsIgnoreCase(extension)) {
				readCsv(carga, file, registrosMap, errores);
			} else {
				readTXT(carga, file, registrosMap, errores);
			}
			registros.addAll(registrosMap.values());

		} catch (Exception e) {
			log.error("failed!", e);
		}

	}

	public void readExcel(Carga carga, InputStream is, Map<String, T> registros, Map<String, FilaEstado> errores) {

		Long numerolinea = 0l;

		Workbook wb = null;
		Sheet sheet = null;
		try {
			wb = WorkbookFactory.create(is);

			if (carga.getTipocarga().equals("8")) {
				sheet = wb.getSheetAt(0);
			} else {
				sheet = wb.getSheetAt(1);
			}

			Iterator<Row> rowIterator = sheet.rowIterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				numerolinea++;
				process(carga, registros, errores, Row.class, row, numerolinea);
			}

		} catch (Exception e) {
			log.error("failed!", e);
		} finally {
			try {
				if (wb != null) {
					wb.close();
				}
			} catch (IOException e) {
				log.error("failed!", e);
			}
		}
	}

	public void readCsv(Carga carga, InputStream is, Map<String, T> registros, Map<String, FilaEstado> errores) {

		Long numerolinea = 0l;

		CSVReader reader = null;
		try {
			reader = new CSVReaderBuilder(new InputStreamReader(is)).withSkipLines(1).build();
			String[] nextLine;

			while ((nextLine = reader.readNext()) != null) {
				numerolinea++;
				process(carga, registros, errores, String[].class, nextLine, numerolinea);
			}
		} catch (Exception e) {
			log.error("failed!", e);
			errores.put(numerolinea.toString(), new FilaEstado(FilaEstadoEnum.ERROR, e.getMessage()));
		}
	}

	public void readTXT(Carga carga, InputStream is, Map<String, T> registros, Map<String, FilaEstado> errores) {

		Long numerolinea = 0l;

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String row = null;

			while (reader.ready()) {

				row = reader.readLine();
				numerolinea++;
				process(carga, registros, errores, String.class, row, numerolinea);

			}

		} catch (Exception e) {
			log.error("failed!", e);
			errores.put(numerolinea.toString(), new FilaEstado(FilaEstadoEnum.ERROR, e.getMessage()));
		}

	}

	private <V> void process(Carga carga, Map<String, T> lista, Map<String, FilaEstado> errores,
			Class<V> clazzConstruct, V row, Long numerolinea) {

		try {
			T trow = clazz.getConstructor(Carga.class, Long.class, clazzConstruct).newInstance(carga, numerolinea, row);
			trow.setRownum(numerolinea);
			trow.loadKey();
			if (!trow.validar()) {
				return;
			}

			if (!trow.agrupar()) {

				lista.put(trow.getKey(), trow);
			} else {
				if (lista.containsKey(trow.getKey())) {
					T primero = lista.get(trow.getKey());
					primero.merge(trow);
				} else {
					lista.put(trow.getKey(), trow);
				}

			}
		} catch (Exception e) {
			log.error("failed!", e);
			errores.put(numerolinea.toString(), new FilaEstado(FilaEstadoEnum.ERROR, e.getMessage()));
		}

	}

}
